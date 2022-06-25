package yuhan.mvc.teamproject.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;

import yuhan.mvc.teamproject.dto.HardWareDto;
import yuhan.mvc.teamproject.dto.LoginDto;
import yuhan.mvc.util.ConstantTemplate;

public class LoginDao {

	JdbcTemplate template;
	
	public LoginDao() {		
		this.template = ConstantTemplate.template;				
	}

	public LoginDto join(final String user_id, final String user_pwd, final String user_name, final String user_email, final String user_phone) {
		
		LoginDto dto = null;	
        String query= "select user_id from spring_project_user where user_id=" + "'" + user_id + "'";
        try {     	
            dto = this.template.queryForObject(query, new BeanPropertyRowMapper<LoginDto>
            (LoginDto.class));
        }catch(DataAccessException e) {
            if( e instanceof IncorrectResultSizeDataAccessException) {
            	String query2="insert into spring_project_user(user_id, user_pwd, user_name, user_email, user_phone)" 
        				+ "values(?, ?, ?, ?, ?)"; 
        		this.template.update(query2, new PreparedStatementSetter() {
	        		@Override
	        		public void setValues(PreparedStatement preparedStatement) throws SQLException {
	        			preparedStatement.setString(1, user_id);
	        			preparedStatement.setString(2, user_pwd);
	        			preparedStatement.setString(3, user_name);
	        			preparedStatement.setString(4, user_email);
	        			preparedStatement.setString(5, user_phone);
	        		}        		
        		});
            }            
        }
		return dto;		
	}
	
	public LoginDto login(String strNo) {

        LoginDto dto = null;
        String query= "select user_id, user_pwd, user_name, user_email, user_phone from spring_project_user where user_id=" + "'" +strNo + "'";
        try {
            dto = this.template.queryForObject(query, new BeanPropertyRowMapper<LoginDto>
            (LoginDto.class));
            System.out.println(dto.getUser_id());
        }catch(DataAccessException e) {
            if( e instanceof IncorrectResultSizeDataAccessException) {
                dto = null;
            }
            else {
                dto = null;
            }
        }

        return dto;
    }
	public LoginDto update(final String user_id, final String user_pwd, final String user_name, final String user_email, final String user_phone) {
		
		String query = "update spring_project_user set user_pwd=?, user_name=?, user_email=?, user_phone=? where user_id=?";
		this.template.update(query,new PreparedStatementSetter(){
		@Override
		public void setValues(PreparedStatement preparedStatement) throws SQLException {
			preparedStatement.setString(1, user_pwd);
			preparedStatement.setString(2, user_name);
			preparedStatement.setString(3, user_email);
			preparedStatement.setString(4, user_phone);
			preparedStatement.setString(5, user_id);
		}
	});
		String query2= "select * from spring_project_user where user_id=" + "'" + user_id + "'";
		LoginDto dto = this.template.queryForObject(query2, new BeanPropertyRowMapper<LoginDto>
		(LoginDto.class));
		return dto;
	}
	public LoginDto userinfomation(String user_id) {
		String query= "select * from spring_project_user where user_id=" + "'" + user_id + "'";
		LoginDto dto = this.template.queryForObject(query, new BeanPropertyRowMapper<LoginDto>
		(LoginDto.class));
		return dto;
	}

	public LoginDto delete(final String user_id) {
		
		String query="delete from spring_project_user where user_id=?";
		this.template.update(query, new PreparedStatementSetter(){
		@Override
		public void setValues(PreparedStatement preparedStatement) throws SQLException {
		preparedStatement.setString(1, user_id);
		}
		});		
		return null;
	}
}
