package com.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.SetQueAnsBean;

@Repository
public class SecQueAnsDao {

	@Autowired
	JdbcTemplate pstmt;

	public void addQuestion(SetQueAnsBean ansBean) {
		pstmt.update("insert into setquestion (question,answer,userid) values (?,?,?)", ansBean.getQuestion(),
				ansBean.getAns(), ansBean.getUserId());
	}

	public List<SetQueAnsBean> getQuestionByUser(int userId) {
		return pstmt.query(
				"select * from  users inner join secquestion on users.userid = secquestion.userid where users.userid = ?",
				new BeanPropertyRowMapper<SetQueAnsBean>(SetQueAnsBean.class), new Object[] { userId });
	}

}
