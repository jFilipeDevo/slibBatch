package com.slib;

import org.springframework.core.io.Resource;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FileMover {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");

    /**
     * Moves the input file to the specified destination directory.
     * The file is renamed with a timestamp to ensure uniqueness.
     */
    public static void move(Resource inputFile, String destinationDir) throws IOException {
        File sourceFile = inputFile.getFile();
        if (!sourceFile.exists()) {
            throw new IOException("Source file not found: " + sourceFile.getAbsolutePath());
        }
        Path destinationPath = Path.of(destinationDir);
        Files.createDirectories(destinationPath);
        String timestamp = LocalDateTime.now().format(formatter);
        String originalName = sourceFile.getName();
        String newName = originalName.substring(0, originalName.lastIndexOf('.'))
                + "_" + timestamp
                + originalName.substring(originalName.lastIndexOf('.'));
        Path finalDestination = destinationPath.resolve(newName);
        Files.move(sourceFile.toPath(), finalDestination,
                StandardCopyOption.REPLACE_EXISTING);
    }
}