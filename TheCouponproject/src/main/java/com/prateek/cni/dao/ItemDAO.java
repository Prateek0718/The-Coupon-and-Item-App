package com.prateek.cni.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.prateek.cni.model.Coupon;
import com.prateek.cni.model.Item;
import com.prateek.cni.util.ConnectionUtil;

public class ItemDAO {
	public void save(Item it) {
		Connection con=ConnectionUtil.getConnection();
		try {
			PreparedStatement stmt=con.prepareStatement("insert into item(name,description,price) values (?,?,?)");
			stmt.setString(1, it.getName());
			stmt.setBigDecimal(3,it.getPrice());
			stmt.setString(2,it.getDescription() );
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
