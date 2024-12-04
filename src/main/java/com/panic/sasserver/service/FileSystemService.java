package com.panic.sasserver.service;


import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Service
public class FileSystemService {


    private final String IMAGE_DIR = "src/main/resources/static/images/";
    private final ResourceLoader resourceLoader;

    public FileSystemService(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }


    public Resource getImage(String id) throws IOException {
        Path imagePath = Paths.get(IMAGE_DIR + id);
        return resourceLoader.getResource("file:" + imagePath.toString());
    }


    public List<String> listImages(String id) {
        File directory = new File(IMAGE_DIR + id);


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
