package com.panic.sasserver.service;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Service
public class FileSystemService {

    @Value("${upload.dir}")
    private String imageDirectory;

    private final ResourceLoader resourceLoader;

    public FileSystemService(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    @PostConstruct
    public void ensureDirectoriesExist() {
        try {
            Files.createDirectories(Paths.get(imageDirectory, "products"));
            Files.createDirectories(Paths.get(imageDirectory, "users"));
        } catch (IOException e) {
            throw new RuntimeException("Failed to create required directories", e);
        }
    }

    public Resource getImage(String path) throws IOException {
        Path imagePath = Paths.get(imageDirectory, path);
        return resourceLoader.getResource("file:" + imagePath.toString());
    }

    public Resource getStaticImage(String path) throws IOException {
        Path imagePath = Paths.get("src/main/resources/static/images/", path);
        return resourceLoader.getResource("file:" + imagePath.toString());
    }

    public List<String> listImages(String path) {
        File directory = new File(Paths.get(imageDirectory, path).toString());

        if (!directory.exists() || !directory.isDirectory()) {
            return new ArrayList<>();
        }

        File[] files = directory.listFiles();
        List<String> imageNames = new ArrayList<>();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    String fileName = file.getName();
                    if (fileName.toLowerCase().endsWith(".jpg") || fileName.toLowerCase().endsWith(".png")) {
                        imageNames.add(fileName);
                    }
                }
            }
        }

        return imageNames;
    }
}