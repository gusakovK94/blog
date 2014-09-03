package com.aboutme.blog.dao;

import com.aboutme.blog.dao.interfaces.TagDao;
import com.aboutme.blog.models.Tag;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class TagDaoImpl extends JdbcDaoSupport
							implements TagDao {

	@Override
	public void add(Tag tag) {
		getJdbcTemplate().update("INSERT INTO tags (tag_name, popularity) VALUES (?, ?)",
								tag.getTagName(),
								tag.getPopularity());
	}

	@Override
	public Tag find(int id) {
		return null;
	}

	@Override
	public void update(Tag tag) {

	}

	@Override
	public void delete(int tag_id) {
		getJdbcTemplate().update("DELETE FROM tags WHERE id = ?",
								tag_id);
	}

	@Override
	public List<Tag> getTags() {
		List<Tag> tags = getJdbcTemplate().query(
				"SELECT * FROM tags" ,
				new RowMapper<Tag>() {
					public Tag mapRow(ResultSet rs, int rowNum) throws SQLException {
						Tag tag = new Tag();
						tag.setId(rs.getInt("id"));
						tag.setTagName(rs.getString("tag_name"));
						tag.setPopularity(rs.getInt("popularity"));
						return tag;
					}
				});

		return tags;
	}
}
