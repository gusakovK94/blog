package com.aboutme.blog.dao;

import com.aboutme.blog.dao.interfaces.AdminUserDAO;
import com.aboutme.blog.models.Admin;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class AdminUserDAOImpl extends JdbcDaoSupport
								implements AdminUserDAO {

	@Override
	public List<Admin> find(String login, String password) {

		List<Admin> admin = getJdbcTemplate().query(
				"SELECT * FROM admins WHERE login = ? AND password = ?",
				new RowMapper<Admin>() {
					public Admin mapRow(ResultSet rs, int rowNum) throws SQLException {
						Admin admin = new Admin();
						admin.setId(rs.getInt("id"));
						admin.setUsername(rs.getString("username"));
						admin.setSurname(rs.getString("surname"));
						admin.setLogin(rs.getString("login"));
						admin.setPassword(rs.getString("password"));
						admin.setAge(rs.getInt("age"));
						admin.setProfileImageUrl(rs.getString("profileimageurl"));
						return admin;
					}
				},
					login, password);

		return admin;
	}

}
