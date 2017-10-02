package com.hms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;

import com.hms.model.LoginUser;
import com.hms.model.User;

public class UserDao {

	@Autowired
	private DataSource datasource;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	 public User validateUser(LoginUser login) {
	    String sql = "select * from users where username='" + login.getUsername() + "' and password='" + login.getPassword() + "'";
	    List<User> users= jdbcTemplate.query(sql, new UserMapper());
	    return users.size() > 0 ? users.get(0) : null;
	 }
	 
	 public String registerUser(final User user) {
		 //validate the user is already exist
		 
		 try {
			String sql = "select * from users where username='" + user.getUsername()+"'";
			 List<User> users = jdbcTemplate.query(sql,new UserMapper());
			 if(users.size() > 0){
				 return "User Exist";
			 } else {
				final String  sql1 = "Insert into Users(Username,Password,Firstname,Lastname,Gender,DOB,AddressLine1,AddressLine2,City,State,Zipcode,CreatedDate) Values(?,?,?,?,?,?,?,?,?,?,?,?)";
			    int result = jdbcTemplate.update(new PreparedStatementCreator() {
					public PreparedStatement createPreparedStatement(Connection arg0)
							throws SQLException {
						// TODO Auto-generated method stub
						PreparedStatement statement = datasource.getConnection().prepareStatement(sql1);
						statement.setString(0, user.getUsername());
						statement.setString(1, user.getPassword());
						statement.setString(2, user.getFirstName());
						statement.setString(3, user.getLastName());
						statement.setString(4, user.getGender());
						statement.setDate(5, new java.sql.Date(user.getDob().getTime()));
						statement.setString(6, user.getAddressLine1());
						statement.setString(7, user.getAddressLine2());
						statement.setString(8, user.getCity());
						statement.setString(9, user.getState());
						statement.setString(10, user.getZipcode());
						statement.setDate(11, new java.sql.Date(new Date().getTime()));
						
						return statement;
					}
				});
			    if(result == 1){
			    	return "Success";
			    } else {
			    	return "Fail";
			    }
			 }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return e.toString();
		}
		 
	 }
}

class UserMapper implements RowMapper<User> {
	
	public User mapRow(ResultSet rs, int arg1) throws SQLException {
		  User user = new User();
		  user.setUsername(rs.getString("username"));
		  user.setPassword(rs.getString("password"));
		  user.setFirstName(rs.getString("firstname"));
		  user.setLastName(rs.getString("lastname"));
		  user.setGender(rs.getString("Gender"));
		  user.setDob(rs.getDate("DOB"));
		  user.setAddressLine1(rs.getString("addressLine1"));
		  user.setAddressLine2(rs.getString("addressLine2"));
		  user.setCity(rs.getString("City"));
		  user.setState(rs.getString("State"));
		  user.setZipcode(rs.getString("Zipcode"));
		  user.setIsLocked(rs.getInt("IsLocked"));
		  user.setLastLoginDate(rs.getDate("LastLoginDate"));
		  user.setCreatedDate(rs.getDate("CreatedDate"));
		  return user;
		}
}