package com.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.LoginBean;
import com.bean.UserBean;

@Repository
public class UserDao {

	@Autowired
	JdbcTemplate pstmt;

	public void addUser(UserBean user) {
		pstmt.update("insert into users (firstname,lastname,gender,email,password,usertype) values (?,?,?,?,?,?)",
				user.getFirstName(), user.getLastName(), user.getGender(), user.getEmail(), user.getPassword(), user.getUserType());
	}

	public List<UserBean> getAllUsers() {

		List<UserBean> users = pstmt.query("select * from users", new BeanPropertyRowMapper<UserBean>(UserBean.class));
		return users;
	}

	public void deleteUser(int userId) {
		pstmt.update("delete from users where userid = ? ", userId);
	}

	public UserBean getUserByUserId(int userId) {
		UserBean user = pstmt.queryForObject("select * from users where userId = ?",
				new BeanPropertyRowMapper<UserBean>(UserBean.class), new Object[] { userId });
		return user;
	}

	public UserBean searchUserByFirstName(UserBean firstName) {
		UserBean name = pstmt.queryForObject("select * from users where firstName like = ?%",
				new BeanPropertyRowMapper<UserBean>(UserBean.class), new Object [] { firstName });
		return firstName;
	}

	public void updateUser(UserBean user) {
		pstmt.update("update users set firstname = ? , lastname = ? where userid = ? ", user.getFirstName(),
				user.getLastName(), user.getUserId());
	}

	public UserBean authenticate(LoginBean loginBean) {
		UserBean user = null;

		try {
		user = pstmt.queryForObject("select * from users where email = ? and password = ? ",
				new BeanPropertyRowMapper<UserBean>(UserBean.class),
				new Object[] { loginBean.getEmail(), loginBean.getPassword() });
		}catch(Exception e) {
			System.out.println("invalid email password");
		}
		return user;
	}
}
