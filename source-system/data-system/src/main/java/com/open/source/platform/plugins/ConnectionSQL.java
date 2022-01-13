package com.open.source.platform.plugins;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author hanguo
 * @date 2022/1/13
 * @Description 请填写描述信息
 */
public class ConnectionSQL {
    public static void main(String[] args) {
        Connection conn = null;
        try {
            // 加载驱动类
            Class.forName("com.mysql.cj.jdbc.Driver");
            long start = System.currentTimeMillis();

            // 建立连接
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/open_source_platform?useUnicode=true&characterEncoding=utf-8&serverTimezone=GMT",
                    "root", "123456");
            long end = System.currentTimeMillis();
            System.out.println(conn);
            System.out.println("建立连接耗时： " + (end - start) + "ms 毫秒");

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}
