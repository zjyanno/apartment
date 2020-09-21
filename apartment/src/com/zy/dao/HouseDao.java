package com.zy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import com.zy.model.House;
import com.zy.util.DBUtil;

public class HouseDao {
	//展现全部house信息
	public ArrayList<House> findAll() {

		Connection conn = null;
		Statement s = null;
		ResultSet rs = null;
		House house = null;
		ArrayList<House> list = new ArrayList<>();
		try {
			conn = DBUtil.getConnection();
			s = conn.createStatement();
			rs = s.executeQuery("select * from house");

			while (rs.next()) {
				// 创建java对象,将结果集中的数据封装进对象
				house = new House();
				house.setHid(rs.getInt("hid"));
				house.setHaddress(rs.getString("haddress"));
				house.setHfloor(rs.getString("hfloor"));
				house.setHroomNum(rs.getInt("hroomNum"));
				house.setHarea(rs.getString("harea"));
				house.setHdir(rs.getString("hdir"));
				house.setHdeco(rs.getInt("hdeco"));
				house.setHair(rs.getInt("hair"));
				house.setHprice(rs.getDouble("hprice"));
				house.setHrentStatus(rs.getInt("hrentStatus"));
				house.setHimage(rs.getString("himage"));
				house.setHaddTime(rs.getDate("haddTime"));
				house.setHupdateTime(rs.getDate("hupdateTime"));
				// 将数据添加进集合
				list.add(house);
			}
		} catch (SQLException e) {
			System.out.println("sql异常");
		} finally {
			DBUtil.closeAll(rs, s, conn);
		}
		return list;
	}
	//根据id查
	public House findInfoById(int hid) {

		Connection conn = null;
		PreparedStatement s = null;
		ResultSet rs = null;
		House house = null;
		try {
			conn = DBUtil.getConnection();
			s = conn.prepareStatement("select * from house where hid=?");
			s.setInt(1, hid);
			rs = s.executeQuery();
			
			while (rs.next()) {
				// 创建java对象,将结果集中的数据封装进对象
				house = new House();
				house.setHid(rs.getInt("hid"));
				house.setHaddress(rs.getString("haddress"));
				house.setHfloor(rs.getString("hfloor"));
				house.setHroomNum(rs.getInt("hroomNum"));
				house.setHarea(rs.getString("harea"));
				house.setHdir(rs.getString("hdir"));
				house.setHdeco(rs.getInt("hdeco"));
				house.setHair(rs.getInt("hair"));
				house.setHprice(rs.getDouble("hprice"));
				house.setHrentStatus(rs.getInt("hrentStatus"));
				house.setHimage(rs.getString("himage"));
				house.setHaddTime(rs.getDate("haddTime"));
				house.setHupdateTime(rs.getDate("hupdateTime"));
				
			}
		} catch (SQLException e) {
			System.out.println("sql异常");
		} finally {
			DBUtil.closeAll(rs, s, conn);
		}
		return house;
	}
	
	//添加数据
	public int insert(House house) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps=null;
		int num=0;
		try {
			ps = conn.prepareStatement("insert into house (haddress,hfloor,hroomNum,harea,hdir,hdeco,hair,hprice,hrentStatus,himage,haddTime) values(?,?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1, house.getHaddress());
			ps.setString(2, house.getHfloor());
			ps.setInt(3, house.getHroomNum());
			ps.setString(4, house.getHarea());
			ps.setString(5, house.getHdir());
			ps.setInt(6, house.getHdeco());
			ps.setInt(7, house.getHair());
			ps.setDouble(8, house.getHprice());
			ps.setInt(9, house.getHrentStatus());
			ps.setString(10, house.getHimage());
			ps.setString(11, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(house.getHaddTime()));
			num = ps.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			DBUtil.closeAll(null, ps, conn);
		}
		return num;
	}
	//update之前用hid查
	public House findHouseById(int hid) {
		Connection conn = null;
		PreparedStatement s = null;
		ResultSet rs = null;
		House house = null;
		try {
			conn = DBUtil.getConnection();
			s = conn.prepareStatement("select * from house where hid=?");
			s.setInt(1, hid);
			rs = s.executeQuery();
			
			while (rs.next()) {
				// 创建java对象,将结果集中的数据封装进对象
				house = new House();
				house.setHid(rs.getInt("hid"));
				house.setHaddress(rs.getString("haddress"));
				house.setHfloor(rs.getString("hfloor"));
				house.setHroomNum(rs.getInt("hroomNum"));
				house.setHarea(rs.getString("harea"));
				house.setHdir(rs.getString("hdir"));
				house.setHdeco(rs.getInt("hdeco"));
				house.setHair(rs.getInt("hair"));
				house.setHprice(rs.getDouble("hprice"));
				house.setHrentStatus(rs.getInt("hrentStatus"));
				house.setHimage(rs.getString("himage"));
				house.setHaddTime(rs.getDate("haddTime"));
				house.setHupdateTime(rs.getDate("hupdateTime"));
				
			}
		} catch (SQLException e) {
			System.out.println("sql异常");
		} finally {
			DBUtil.closeAll(rs, s, conn);
		}
		return house;
	}
	//根据hid更新
	public void updateHouse(House house) {
		System.out.println("housessss="+house);
	
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps=null;
		
		try {
			ps = conn.prepareStatement("update house set haddress=?,hfloor=?,hroomNum=?,harea=?,hdir=?,hdeco=?,hair=?,hprice=?,hrentStatus=?,himage=?,hupdateTime=?,haddTime=? where hid=?");
			ps.setString(1, house.getHaddress());
			ps.setString(2, house.getHfloor());
			ps.setInt(3, house.getHroomNum());
			ps.setString(4, house.getHarea());
			ps.setString(5, house.getHdir());
			ps.setInt(6, house.getHdeco());
			ps.setInt(7, house.getHair());
			ps.setDouble(8, house.getHprice());
			ps.setInt(9, house.getHrentStatus());
			ps.setString(10, house.getHimage());
			ps.setString(11, new SimpleDateFormat("yyyy-MM-dd").format(house.getHupdateTime()));
			ps.setString(12, new SimpleDateFormat("yyyy-MM-dd").format(house.getHaddTime()));
			ps.setInt(13, house.getHid());
			ps.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			DBUtil.closeAll(null, ps, conn);
		}
		
	}
	//根据hid删除一条数据
	public void delHouseById(int hid) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps=null;
		
		try {
			ps = conn.prepareStatement("delete from house where hid=?");
			
			ps.setInt(1, hid);
			ps.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			DBUtil.closeAll(null, ps, conn);
		}		
	}
	//模糊查询
	public ArrayList<House> findHouseAndWords(String field, String keywords) {
		

		Connection conn = null;
		Statement s = null;
		ResultSet rs = null;
		House house = null;
		ArrayList<House> list = new ArrayList<>();
		String sql="select * from house where "+field+" like '%"+keywords+"%'";
		try {
			conn = DBUtil.getConnection();
			s = conn.createStatement();
			rs = s.executeQuery(sql);

			while (rs.next()) {
				// 创建java对象,将结果集中的数据封装进对象
				house = new House();
				house.setHid(rs.getInt("hid"));
				house.setHaddress(rs.getString("haddress"));
				house.setHfloor(rs.getString("hfloor"));
				house.setHroomNum(rs.getInt("hroomNum"));
				house.setHarea(rs.getString("harea"));
				house.setHdir(rs.getString("hdir"));
				house.setHdeco(rs.getInt("hdeco"));
				house.setHair(rs.getInt("hair"));
				house.setHprice(rs.getDouble("hprice"));
				house.setHrentStatus(rs.getInt("hrentStatus"));
				house.setHimage(rs.getString("himage"));
				house.setHaddTime(rs.getDate("haddTime"));

				// 将数据添加进集合
				list.add(house);
			}
		} catch (SQLException e) {
			System.out.println("sql异常");
		} finally {
			DBUtil.closeAll(rs, s, conn);
		}
		return list;
	}
	//分页第二步查询数据库分页
	public ArrayList<House> findAll(int start, int end) {
		Connection conn = null;
		Statement s = null;
		ResultSet rs = null;
		House house = null;
		String sql="select * from house house limit "+start+","+end+"";
		ArrayList<House> list = new ArrayList<>();
		try {
			conn = DBUtil.getConnection();
			s = conn.createStatement();
			rs = s.executeQuery(sql);

			while (rs.next()) {
				// 创建java对象,将结果集中的数据封装进对象
				house = new House();
				house.setHid(rs.getInt("hid"));
				house.setHaddress(rs.getString("haddress"));
				house.setHfloor(rs.getString("hfloor"));
				house.setHroomNum(rs.getInt("hroomNum"));
				house.setHarea(rs.getString("harea"));
				house.setHdir(rs.getString("hdir"));
				house.setHdeco(rs.getInt("hdeco"));
				house.setHair(rs.getInt("hair"));
				house.setHprice(rs.getDouble("hprice"));
				house.setHrentStatus(rs.getInt("hrentStatus"));
				house.setHimage(rs.getString("himage"));
				house.setHaddTime(rs.getDate("haddTime"));
				house.setHupdateTime(rs.getDate("hupdateTime"));
				// 将数据添加进集合
				list.add(house);
			}
		} catch (SQLException e) {
			System.out.println("sql异常");
		} finally {
			DBUtil.closeAll(rs, s, conn);
		}
		return list;
	}
	//分页第一步查询数据库总条数
	public int count() {
		Connection conn = null;
		PreparedStatement s = null;
		ResultSet rs = null;
		int total=0;
		try {
			conn = DBUtil.getConnection();
			s = conn.prepareStatement("select count(*) from house");
			rs = s.executeQuery();
			
			while (rs.next()) {
				// 创建java对象,将结果集中的数据封装进对象
				total = rs.getInt(1);
			}
		} catch (SQLException e) {
			System.out.println("sql异常");
		} finally {
			DBUtil.closeAll(rs, s, conn);
		}
		return total;
	}
}

