package Lab11;

import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.*;
import java.util.*;

public class FolderReport {
    public static void main(String[] args) throws IOException {

        Path folder = Paths.get("sample_folder");
        Path report = Paths.get("file_report.txt");

        // Create sample folder and files
        Files.createDirectories(folder);

        Files.write(folder.resolve("first.txt"),
            Arrays.asList("Hello Java"));

        Files.write(folder.resolve("second.txt"),
            Arrays.asList("Learning NIO", "File handling"));

        Files.createDirectories(folder.resolve("subfolder"));

        Files.write(
            folder.resolve("subfolder/third.txt"),
            Arrays.asList("Nested file"));

        // Generate report
        try (PrintWriter writer =
                 new PrintWriter(
                     Files.newBufferedWriter(report))) {

            writer.println("FOLDER TREE REPORT");
            writer.println("==================");

            Files.walkFileTree(folder,
                new SimpleFileVisitor<Path>() {

                    @Override
                    public FileVisitResult visitFile(
                        Path file, BasicFileAttributes attrs)
                        throws IOException {

                        writer.println(
                            "Name: " + file.getFileName());

                        writer.println(
                            "Size: " + attrs.size() + " bytes");

                        writer.println(
                            "Modified: " +
                            attrs.lastModifiedTime());

                        writer.println();

                        return FileVisitResult.CONTINUE;
                    }
                });
        }

        System.out.println(
            "Report generated: " + report.toAbsolutePath());
    }
}
