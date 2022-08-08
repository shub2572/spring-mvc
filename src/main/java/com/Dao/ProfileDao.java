package com.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.ProfileBean;

@Repository
public class ProfileDao {
	
	@Autowired
	JdbcTemplate pstmt;

	public void addImg(ProfileBean profileBean) {
		pstmt.update("insert into profiles (userid,imgurl,active) values (?,?,?)", profileBean.getUserId(),profileBean.getImgUrl(),profileBean.getActive());
	}

	public List<ProfileBean> getAllImagesByUser(int userId) {

		return pstmt.query("select * from profiles where userid = ? ",new BeanPropertyRowMapper<ProfileBean>(ProfileBean.class),new Object[] {userId});

		
	}
}
