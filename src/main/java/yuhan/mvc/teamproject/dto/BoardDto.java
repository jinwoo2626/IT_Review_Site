package yuhan.mvc.teamproject.dto;

import java.sql.Timestamp;

public class BoardDto {
	
	//Dto에서는 반드시 private로 설정해야함
	//일반메소드 사용불가 /get, set, 일반생성자만 가능
	//필드(속성)명은 데이터베이스의 속성명과 똑같이 한다.
	private int b_no;
	private String b_name;
	private String b_subject;
	private String b_content;
	private String b_id;
	Timestamp b_date;
	
	public BoardDto() {
		
	}
	
	public BoardDto(int b_no, String b_name, String b_subject, String b_content, String b_id, Timestamp b_date) {
		
		this.b_no = b_no;
		this.b_name = b_name;
		this.b_subject = b_subject;
		this.b_content = b_content;
		this.b_id = b_id;
		this.b_date = b_date;
	}

	public int getB_no() {
		return b_no;
	}

	public void setB_no(int b_no) {
		this.b_no = b_no;
	}

	public String getB_name() {
		return b_name;
	}

	public void setB_name(String b_name) {
		this.b_name = b_name;
	}

	public String getB_subject() {
		return b_subject;
	}

	public void setB_subject(String b_subject) {
		this.b_subject = b_subject;
	}

	public String getB_content() {
		return b_content;
	}

	public void setB_content(String b_content) {
		this.b_content = b_content;
	}
	
	public String getB_id() {
		return b_id;
	}

	public void setB_id(String b_id) {
		this.b_id = b_id;
	}

	public Timestamp getB_date() {
		return b_date;
	}

	public void setB_date(Timestamp b_date) {
		this.b_date = b_date;
	}
	
}
