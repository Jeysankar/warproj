package edu.ucla.its.itademo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import edu.ucla.its.itademo.servlet.ActiveUsersListServlet;
import edu.ucla.its.itademo.util.User;

public class UserDao {

	private Connection connection;

	static Logger logger = Logger.getLogger(ActiveUsersListServlet.class);

	public List<User> getUsersList() {

		List<User> users = new ArrayList<User>();

		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = connection.prepareStatement("select id, name, email,country from Users limit 10");
			rs = ps.executeQuery();

			if (rs != null) {

				while (rs.next()) {
					User user = new User(rs.getString("name"), rs.getString("email"), rs.getString("country"), rs.getInt("id"));
					logger.info("User found with details=" + user);
					users.add(user);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			logger.error("Database connection problem");
		} finally {
			try {
				rs.close();
				ps.close();
			} catch (SQLException e) {
				logger.error("SQLException in closing PreparedStatement or ResultSet");
			}
		}
		return users;
	}

	
	public User retrieveUser(User reqUser) {

		User user = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = connection.prepareStatement("select id, name, email,country from Users where email=? and password=? limit 1");
			ps.setString(1, reqUser.getEmail());
			ps.setString(2, reqUser.getPassword());
			rs = ps.executeQuery();

			if(rs != null){
				rs.next();
				user = new User(rs.getString("name"), rs.getString("email"), rs.getString("country"), rs.getInt("id"));
				logger.info("User found with details="+user);
			}
	
		} catch (SQLException e) {
			e.printStackTrace();
			logger.error("Database connection problem");
		} finally {
			try {
				rs.close();
				ps.close();
			} catch (SQLException e) {
				logger.error("SQLException in closing PreparedStatement or ResultSet");
			}
		}
		return user;
	}
	
	
	public void registerUser(User reqUser) {

		PreparedStatement ps = null;
		try {
			ps = connection.prepareStatement("insert into Users(name,email,country, password) values (?,?,?,?)");
			ps.setString(1, reqUser.getName());
			ps.setString(2, reqUser.getEmail());
			ps.setString(3, reqUser.getCountry());
			ps.setString(4, reqUser.getPassword());

			ps.execute();
			logger.info("User registered with email=" + reqUser.getEmail());

		} catch (SQLException e) {
			e.printStackTrace();
			logger.error("Database connection problem");
		} finally {
			try {
				ps.close();
			} catch (SQLException e) {
				logger.error("SQLException in closing PreparedStatement or ResultSet");
			}
		}
	}
	
	
	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}
}