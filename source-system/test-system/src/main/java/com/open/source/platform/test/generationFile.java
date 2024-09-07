package com.open.source.platform.test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class generationFile {
    public static void main(String[] args) {
        // 指定文件路径和名称
        String directoryPath = "C:/Users/korea/Desktop/aaa"; // 将此路径替换为你想要保存文件的路径
        String fileName = "";


        try {

            for (char i = 'q'; i <= 'z'; i++) {

                    String fileNewName = i + "" ;

                    // 创建文件对象
                    Path filePath = Paths.get(directoryPath, fileNewName + ".java");

                    // 确保目录存在，如果不存在则创建
                    Files.createDirectories(filePath.getParent());

                    // 创建一个空文件
                    Files.createFile(filePath);


            }

//            System.out.println("File created successfully at: " + filePath.toString());
        } catch (IOException e) {
            System.err.println("An error occurred while creating the file: " + e.getMessage());
        }
    }
}
