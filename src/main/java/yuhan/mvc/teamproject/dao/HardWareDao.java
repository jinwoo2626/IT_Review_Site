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

import yuhan.mvc.teamproject.dto.HardWareDto;
import yuhan.mvc.util.ConstantTemplate;

public class HardWareDao {

	JdbcTemplate template;
	
	public HardWareDao() {		
		this.template = ConstantTemplate.template;				
	}

	public ArrayList<HardWareDto>list(String strNo){

        ArrayList<HardWareDto>dtos =null;
        String query;
        if(strNo == null || strNo == "") {
            query = "select * from spring_project_hardware order by h_no desc";
        }
        else {
            query = "select * from spring_project_hardware where h_code = '" + strNo +  "' order by h_no desc";
        }


        dtos= (ArrayList<HardWareDto>)template.query(query, new BeanPropertyRowMapper<HardWareDto>(HardWareDto.class));

        return dtos;
    }
		
		public void write(final String h_subject, final String h_name, final String h_code, final String h_content,final String h_id, final String h_price, final String h_score) {
		
			String query="insert into spring_project_hardware(h_no, h_subject, h_name, h_code, h_count, h_content, h_id, h_price, h_score, h_suggest)" 
					+ "values(spring_project_hardwareseq.nextval, ?, ?, ?, 0, ?, ?, ?, ?, 0)"; 
			this.template.update(query, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement preparedStatement) throws SQLException {
				preparedStatement.setString(1, h_subject);
				preparedStatement.setString(2, h_name);
				preparedStatement.setString(3, h_code);
				preparedStatement.setString(4, h_content);
				preparedStatement.setString(5, h_id);
				preparedStatement.setString(6, h_price);
				preparedStatement.setString(7, h_score);
			}
		});
	}
		public HardWareDto contentView(String strNo) {
			
			String query= "select * from spring_project_hardware where h_no=" + strNo;
			final HardWareDto dto = this.template.queryForObject(query, new BeanPropertyRowMapper<HardWareDto>
			(HardWareDto.class));
			
			String query2 = "update spring_project_hardware set h_count=? where h_no=" + strNo;
			this.template.update(query2,new PreparedStatementSetter(){
				@Override
				public void setValues(PreparedStatement preparedStatement) throws SQLException {
					preparedStatement.setInt(1, dto.getH_count() + 1);
				}
			});
			return dto;	
		}
		public void modify(final String h_no, final String h_subject, final String h_name, final String h_code, final String h_content, final String h_price, final String h_score) {
						
			String query = "update spring_project_hardware set h_subject=?, h_name=?, h_code=?, h_content=?, h_price=?, h_score=? where h_no=?";
			this.template.update(query,new PreparedStatementSetter(){
			@Override
			public void setValues(PreparedStatement preparedStatement) throws SQLException {
				preparedStatement.setString(1, h_subject);
				preparedStatement.setString(2, h_name);
				preparedStatement.setString(3, h_code);
				preparedStatement.setString(4, h_content);
				preparedStatement.setString(5, h_price);
				preparedStatement.setString(6, h_score);
				preparedStatement.setInt(7, Integer.parseInt(h_no));
			}
		});
		}
		public void delete(final String h_no) {
					
			String query="delete from spring_project_hardware where h_no=?";
			this.template.update(query, new PreparedStatementSetter(){
			@Override
			public void setValues(PreparedStatement preparedStatement) throws SQLException {
			preparedStatement.setString(1, h_no);
			}
			});
		}
}
