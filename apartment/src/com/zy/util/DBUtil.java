package com.zy.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author 2768278679@qq.com
 *
	数据库操作工具类
	1.将获得连接的功能封装.
	2.将关流功能封装
 */
public class DBUtil {
	/**
	 * 将数据库连接数据 抽取成静态常量
	 */
	public static final  String url = "jdbc:mysql://192.168.137.1:3306/zhiyou_apartment?useUnicode=true&characterEncoding=utf8";
	public static final  String username = "root";
	public static final  String password = "123456";
	/**
	 * 静态代码块,让加载驱动只执行一次.随类加载而执行,在内存中只有一份
	 */
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 封装获得连接对象
	 */
	public static Connection getConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url,username,password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
		
	}
	/**
	 * 封装关流功能
	 */
	public static void closeAll(ResultSet rs,Statement s,Connection conn) {
		if(rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(s != null) {
			try {
				s.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
