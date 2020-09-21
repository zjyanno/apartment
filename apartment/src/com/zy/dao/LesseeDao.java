package com.zy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import com.zy.model.Lessee;
import com.zy.model.User;
import com.zy.util.DBUtil;

public class LesseeDao {

	public ArrayList<Lessee> findAll() {
		Connection conn = null;
		Statement s = null;
		ResultSet rs = null;
		Lessee lessee = null;
		ArrayList<Lessee> list = new ArrayList<>();

		try {
			conn = DBUtil.getConnection();
			s = conn.createStatement();
			rs = s.executeQuery("select * from lessee");

			while (rs.next()) {
				// 创建java对象,将结果集中的数据封装进对象
				lessee = new Lessee();
				lessee.setLid(rs.getInt("lid"));
				lessee.setLname(rs.getString("lname"));
				lessee.setLtel(rs.getString("ltel"));
				lessee.setLsex(rs.getInt("lsex"));
				lessee.setLnp(rs.getString("lnp"));
				lessee.setLidCard(rs.getString("lidCard"));
				lessee.setLaddTime(rs.getDate("laddTime"));
				// 将数据添加进集合
				list.add(lessee);
			}
		} catch (SQLException e) {
			System.out.println("sql异常");
		} finally {
			DBUtil.closeAll(rs, s, conn);
		}
		return list;
	}

	public Lessee findInfoById(int lid) {
		Connection conn = null;
		PreparedStatement s = null;
		ResultSet rs = null;
		Lessee lessee= null;
		try {
			conn = DBUtil.getConnection();
			s = conn.prepareStatement("select * from lessee where lid=?");
			s.setInt(1, lid);
			rs = s.executeQuery();
			
			while (rs.next()) {
				// 创建java对象,将结果集中的数据封装进对象
				lessee = new Lessee();
				lessee.setLid(rs.getInt("lid"));
				lessee.setLname(rs.getString("lname"));
				lessee.setLtel(rs.getString("ltel"));
				lessee.setLsex(rs.getInt("lsex"));
				lessee.setLnp(rs.getString("lnp"));
				lessee.setLidCard(rs.getString("lidCard"));
				lessee.setLaddTime(rs.getDate("laddTime"));
								
			}
		} catch (SQLException e) {
			System.out.println("sql异常");
		} finally {
			DBUtil.closeAll(rs, s, conn);
		}
		return lessee;
	}

	public int add(Lessee lessee) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps=null;
		int num=0;
		try {
			ps = conn.prepareStatement("insert into lessee (lname,ltel,lsex,lnp,lidCard,laddTime) values(?,?,?,?,?,?)");
			ps.setString(1, lessee.getLname());
			ps.setString(2, lessee.getLtel());
			ps.setInt(3, lessee.getLsex());
			ps.setString(4, lessee.getLnp());
			ps.setString(5, lessee.getLidCard());
			ps.setString(6, new SimpleDateFormat("yyyy-MM-dd").format(lessee.getLaddTime()));
						
			num = ps.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			DBUtil.closeAll(null, ps, conn);
		}
		return num;
	}

	public Lessee findLesseeById(int lid) {
		Connection conn = null;
		PreparedStatement s = null;
		ResultSet rs = null;
		Lessee lessee = null;
		try {
			conn = DBUtil.getConnection();
			s = conn.prepareStatement("select * from lessee where lid=?");
			s.setInt(1, lid);
			rs = s.executeQuery();
			
			while (rs.next()) {
				// 创建java对象,将结果集中的数据封装进对象
				lessee = new Lessee();
				lessee.setLid(rs.getInt("lid"));
				lessee.setLname(rs.getString("lname"));
				lessee.setLtel(rs.getString("ltel"));
				lessee.setLsex(rs.getInt("lsex"));
				lessee.setLnp(rs.getString("lnp"));
				lessee.setLidCard(rs.getString("lidCard"));
				lessee.setLaddTime(rs.getDate("laddTime"));
				System.out.println("bfdbdbdfb="+lid);
			}
		} catch (SQLException e) {
			System.out.println("sql异常");
		} finally {
			DBUtil.closeAll(rs, s, conn);
		}
		return lessee;
	}

	public void updateLessee(Lessee lessee) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps=null;
		
		try {
			ps = conn.prepareStatement("update lessee set lname=?,ltel=?,lsex=?,lnp=?,lidCard=?,laddTime=? where lid=?");
			
			ps.setString(1, lessee.getLname());
			ps.setString(2, lessee.getLtel());
			ps.setInt(3, lessee.getLsex());
			ps.setString(4, lessee.getLnp());
			ps.setString(5, lessee.getLidCard());
			ps.setString(6, new SimpleDateFormat("yyyy-MM-dd").format(lessee.getLaddTime()));
			ps.setInt(7, lessee.getLid());
			
			ps.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			DBUtil.closeAll(null, ps, conn);
		}
	}

	public void delLesseeById(int lid) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps=null;
		
		try {
			ps = conn.prepareStatement("delete from lessee where lid=?");
			
			ps.setInt(1, lid);
			ps.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			DBUtil.closeAll(null, ps, conn);
		}
	}

	
}
