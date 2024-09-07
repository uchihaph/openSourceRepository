package com.open.source.platform.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/**
 * 去重.
 *
 * @author hanguo
 * @date 2024/8/24
 */
public class CompareDistinct {

    public static void main(String[] args) throws IOException {
        InputStream inputStream = CompareDistinct.class.getResourceAsStream("/aaa.txt");
        // 检查是否找到文件
        if (inputStream == null) {
            System.out.println("文件未找到！");
            return;
        }

        // 使用 BufferedReader 逐行读取文件内容
        Set<String> set = new HashSet<String>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = reader.readLine()) != null) {
                set.add(line);
//                System.out.println(line); // 输出每一行内容
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

       set.stream().forEach(e -> System.out.println(e));
    }

}
