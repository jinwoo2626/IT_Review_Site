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

import yuhan.mvc.teamproject.dto.SoftWareDto;
import yuhan.mvc.util.ConstantTemplate;

public class SoftWareDao {

	JdbcTemplate template;
	
	public SoftWareDao() {		
		this.template = ConstantTemplate.template;				
	}

	public ArrayList<SoftWareDto>list(String strNo){

        ArrayList<SoftWareDto>dtos =null;
        String query;
        if(strNo == null || strNo == "") {
            query = "select * from spring_project_software order by s_no desc";
        }
        else {
            query = "select * from spring_project_software where s_code = '" + strNo +  "' order by s_no desc";
        }


        dtos= (ArrayList<SoftWareDto>)template.query(query, new BeanPropertyRowMapper<SoftWareDto>(SoftWareDto.class));

        return dtos;
    }
		
		public void write(final String s_subject, final String s_name, final String s_code, final String s_content,final String s_id, final String s_price, final String s_score) {
		
			String query="insert into spring_project_software(s_no, s_subject, s_name, s_code, s_count, s_content, s_id, s_price, s_score, s_suggest)" 
					+ "values(spring_project_softwareseq.nextval, ?, ?, ?, 0, ?, ?, ?, ?, 0)"; 
			this.template.update(query, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement preparedStatement) throws SQLException {
				preparedStatement.setString(1, s_subject);
				preparedStatement.setString(2, s_name);
				preparedStatement.setString(3, s_code);
				preparedStatement.setString(4, s_content);
				preparedStatement.setString(5, s_id);
				preparedStatement.setString(6, s_price);
				preparedStatement.setString(7, s_score);
			}
		});
	}
		public SoftWareDto contentView(String strNo) {
			
			String query= "select * from spring_project_software where s_no=" + strNo;
			final SoftWareDto dto = this.template.queryForObject(query, new BeanPropertyRowMapper<SoftWareDto>
			(SoftWareDto.class));
			
			String query2 = "update spring_project_software set s_count=? where s_no=" + strNo;
			this.template.update(query2,new PreparedStatementSetter(){
				@Override
				public void setValues(PreparedStatement preparedStatement) throws SQLException {
					preparedStatement.setInt(1, dto.getS_count() + 1);
				}
			});
			return dto;	
		}
		public void modify(final String s_no, final String s_subject, final String s_name, final String s_code, final String s_content, final String s_price, final String s_score) {
						
			String query = "update spring_project_software set s_subject=?, s_name=?, s_code=?, s_content=?, s_price=?, s_score=? where s_no=?";
			this.template.update(query,new PreparedStatementSetter(){
			@Override
			public void setValues(PreparedStatement preparedStatement) throws SQLException {
				preparedStatement.setString(1, s_subject);
				preparedStatement.setString(2, s_name);
				preparedStatement.setString(3, s_code);
				preparedStatement.setString(4, s_content);
				preparedStatement.setString(5, s_price);
				preparedStatement.setString(6, s_score);
				preparedStatement.setInt(7, Integer.parseInt(s_no));
			}
		});
		}
		public void delete(final String s_no) {
					
			String query="delete from spring_project_software where s_no=?";
			this.template.update(query, new PreparedStatementSetter(){
			@Override
			public void setValues(PreparedStatement preparedStatement) throws SQLException {
			preparedStatement.setString(1, s_no);
			}
			});
		}
}
