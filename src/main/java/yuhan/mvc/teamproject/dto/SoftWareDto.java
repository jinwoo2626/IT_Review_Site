package yuhan.mvc.teamproject.dto;

import java.sql.Timestamp;

public class SoftWareDto {

	private int s_no;
	private String s_subject;
	private String s_name;
	private String s_code;
	Timestamp s_time;
	private int s_count;
	private String s_content;
	private String s_id;
	private String s_price;
	private String s_score;
	private int s_suggest;

	
	public SoftWareDto() {
		
	}
		
	public SoftWareDto(int s_no, String s_subject, String s_name, String s_code, Timestamp s_time, int s_count, String s_content,
			String s_id, String s_price, String s_score, int s_suggest) {
		
		this.s_no = s_no;
		this.s_subject = s_subject;
		this.s_name = s_name;
		this.s_code = s_code;
		this.s_time = s_time;
		this.s_count = s_count;
		this.s_content = s_content;
		this.s_id = s_id;
		this.s_price = s_price;
		this.s_score = s_score;
		this.s_suggest = s_suggest;

	}

	public int getS_no() {
		return s_no;
	}

	public void setS_no(int s_no) {
		this.s_no = s_no;
	}

	public String getS_subject() {
		return s_subject;
	}

	public void setS_subject(String s_subject) {
		this.s_subject = s_subject;
	}

	public String getS_name() {
		return s_name;
	}

	public void setS_name(String s_name) {
		this.s_name = s_name;
	}

	public String getS_code() {
		return s_code;
	}

	public void setS_code(String s_code) {
		this.s_code = s_code;
	}

	public Timestamp getS_time() {
		return s_time;
	}

	public void setS_time(Timestamp s_time) {
		this.s_time = s_time;
	}

	public int getS_count() {
		return s_count;
	}

	public void setS_count(int s_count) {
		this.s_count = s_count;
	}

	public String getS_content() {
		return s_content;
	}

	public void setS_content(String s_content) {
		this.s_content = s_content;
	}

	public String getS_id() {
		return s_id;
	}

	public void setS_id(String s_id) {
		this.s_id = s_id;
	}

	public String getS_price() {
		return s_price;
	}

	public void setS_price(String s_price) {
		this.s_price = s_price;
	}

	public String getS_score() {
		return s_score;
	}

	public void setS_score(String s_score) {
		this.s_score = s_score;
	}

	public int getS_suggest() {
		return s_suggest;
	}

	public void setS_suggest(int s_suggest) {
		this.s_suggest = s_suggest;
	}

	
}
