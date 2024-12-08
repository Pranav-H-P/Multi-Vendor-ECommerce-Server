package com.panic.sasserver.controller;

import com.panic.sasserver.service.CustomUserDetailService;
import com.panic.sasserver.service.FileSystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

@RestController
@RequestMapping("/api/images")
public class ImageController {

    @Autowired
    private FileSystemService fileSystemService;

    @Value("${upload.dir}")
    private String uploadDir;

    @Autowired
    private CustomUserDetailService userDetailService;

    @GetMapping("/product/{id}")
    public ResponseEntity<List<String>> getProductImageNames(@PathVariable Long id) {
        List<String> imageNames = fileSystemService.listImages("products/" + id);
        return ResponseEntity.ok(imageNames);
    }


    @GetMapping("/product/{id}/{name}")
    @ResponseBody
    public ResponseEntity<Resource> getProductImage(@PathVariable Long id, @PathVariable String name) {
        try {
            Resource resource = fileSystemService.getImage("products/" + id + "/" + name);

            if (!resource.exists()) {
                return ResponseEntity.notFound().build();
            }

            String contentType = Files.probeContentType(Path.of(resource.getFile().getPath()));
            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.CONTENT_TYPE, contentType != null ? contentType : "application/octet-stream");

            return new ResponseEntity<>(resource, headers, HttpStatus.OK);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PreAuthorize("isAuthenticated()")
    @PostMapping("/uploaduserimage")
    public ResponseEntity<String> uploadImage(@RequestParam("file") MultipartFile file) {
        try {



            String originalFilename = file.getOriginalFilename();
            if (originalFilename == null || (!originalFilename.toLowerCase().endsWith(".png") && !originalFilename.toLowerCase().endsWith(".jpg"))) {
                return ResponseEntity.badRequest().body("Only PNG and JPG files are supported");
            }

            Path uploadPath = Paths.get(uploadDir,"users/");
            Files.createDirectories(uploadPath);

            BufferedImage originalImage = ImageIO.read(file.getInputStream());
            if (originalImage == null) {
                return ResponseEntity.badRequest().body("The file is not a valid image");
            }


            String outputFilename = userDetailService.getCurrentUserId() + ".jpg";
            Path targetPath = uploadPath.resolve(outputFilename);
            File outputFile = targetPath.toFile();


            ImageIO.write(originalImage, "jpg", outputFile); // converting to jpg before saving

            return ResponseEntity.ok("File uploaded successfully: " + targetPath);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error uploading file: " + e.getMessage());
        }
    }

    @PreAuthorize("hasAuthority('VENDOR')")
    @PostMapping("/uploadproductimages")
    public ResponseEntity<String> uploadAndConvertMultipleToJpg(
            @RequestParam("files") List<MultipartFile> files,
            @RequestParam("id") Long id) {
        try {

            Path uploadPath = Paths.get(uploadDir, "products/" + id.toString());
            if (Files.exists(uploadPath) && Files.isDirectory(uploadPath)) {

                try (Stream<Path> paths = Files.walk(uploadPath)) {
                    paths.filter(Files::isRegularFile)
                            .forEach(path -> path.toFile().delete());
                } catch (IOException e) {

                    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                            .body("Error clearing old files: " + e.getMessage());
                }
            } else {

                Files.createDirectories(uploadPath);
            }

            Files.createDirectories(uploadPath);


            StringBuilder responseMessage = new StringBuilder();
            int count = 0;
            for (MultipartFile file : files) {

                BufferedImage originalImage = ImageIO.read(file.getInputStream());
                if (originalImage == null) {
                    return ResponseEntity.badRequest().body("The file is not a valid image");
                }


                String outputFilename = count + ".jpg";
                Path targetPath = uploadPath.resolve(outputFilename);
                File outputFile = targetPath.toFile();


                ImageIO.write(originalImage, "jpg", outputFile);

                ++count;

                responseMessage.append("File uploaded and converted to JPG: ").append(targetPath).append("\n");
            }

            return ResponseEntity.ok(responseMessage.toString());
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error uploading and converting files: " + e.getMessage());
        }
    }

    @GetMapping("/user/{id}")
    @ResponseBody
    public ResponseEntity<Resource> getUserImage(@PathVariable Long id) {
        try {
            Resource resource = fileSystemService.getImage("users/" + id + ".jpg");

            if (!resource.exists()) {

                resource = fileSystemService.getStaticImage("users/placeholder.jpg");
            }

            String contentType = Files.probeContentType(Path.of(resource.getFile().getPath()));
            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.CONTENT_TYPE, contentType != null ? contentType : "application/octet-stream");

            return new ResponseEntity<>(resource, headers, HttpStatus.OK);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}