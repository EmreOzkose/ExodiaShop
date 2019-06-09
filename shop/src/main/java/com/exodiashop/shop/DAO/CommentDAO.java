package com.exodiashop.shop.DAO;

import com.exodiashop.shop.Model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class CommentDAO extends JdbcDaoSupport{

    @Autowired
    DataSource datasource;

    public List<Comment> getCommentsByProductID(int productID){
        String sql = "select * from `comment` where ProductID='"+productID+"'";
        List<Comment> commentList = getJdbcTemplate().query(sql, new CommentMapper());

        return commentList;
    }

}

class CommentMapper implements RowMapper<Comment> {

    public Comment mapRow(ResultSet rs, int arg1) throws SQLException {
        Comment comment = new Comment();

        comment.setId(rs.getInt("id"));
        comment.setCommentator(rs.getString("Commentator"));
        comment.setProductID(rs.getInt("ProductID"));
        comment.setText(rs.getString("Text"));
        comment.setStar(rs.getString("Star"));
        comment.setDate(rs.getDate("Date"));

        return comment;
    }
}
