package yuhan.mvc.teamproject.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;

import yuhan.mvc.teamproject.dto.BoardDto;
import yuhan.mvc.util.ConstantTemplate;

public class BoardDao {

	JdbcTemplate template;
	
	public BoardDao() {		
		this.template = ConstantTemplate.template;				
	}
	
	public ArrayList<BoardDto>list(){
		
		ArrayList<BoardDto>dtos =null;
		
		String query = "select b_no, b_name, b_subject, b_content, b_date from spring_project_board order by b_no desc";
		
		dtos= (ArrayList<BoardDto>)template.query(query, new BeanPropertyRowMapper<BoardDto>(BoardDto.class));
		
		return dtos;
	}

	public void write(final String b_name, final String b_subject, final String b_content, final String b_id) {
		String query="insert into spring_project_board(b_no, b_name, b_subject, b_content, b_id) values(spring_project_boardseq.nextval, ?, ?, ?, ?)";
		this.template.update(query, new PreparedStatementSetter() {
		@Override
		public void setValues(PreparedStatement preparedStatement) throws SQLException {
		preparedStatement.setString(1, b_name);
		preparedStatement.setString(2, b_subject);
		preparedStatement.setString(3, b_content);
		preparedStatement.setString(4, b_id);
		}
	});
}
	public BoardDto contentView(String strNo) {
		String query= "select * from spring_project_board where b_no=" + strNo;
		BoardDto dto = this.template.queryForObject(query, new BeanPropertyRowMapper<BoardDto>
		(BoardDto.class));
		return dto;
		}

	public void modify(final String b_no, final String b_name, final String b_subject, final String b_content) {
			String query = "update spring_project_board set b_name=?, b_subject=?, b_content=? where b_no=?";
			this.template.update(query,new PreparedStatementSetter(){
			@Override
			public void setValues(PreparedStatement preparedStatement) throws SQLException {
			preparedStatement.setString(1, b_name);
			preparedStatement.setString(2, b_subject);
			preparedStatement.setString(3, b_content);
			preparedStatement.setInt(4, Integer.parseInt(b_no));
			}
		});
	}

	public void delete(final String b_no) {
		String query="delete from spring_project_board where b_no=?";
		this.template.update(query, new PreparedStatementSetter(){
		@Override
		public void setValues(PreparedStatement preparedStatement) throws SQLException {
		preparedStatement.setString(1, b_no);
		}
		});
	}
}
