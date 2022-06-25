package yuhan.mvc.teamproject.dto;

import java.sql.Timestamp;

public class HardWareDto {

	private int h_no;
	private String h_subject;
	private String h_name;
	private String h_code;
	Timestamp h_time;
	private int h_count;
	private String h_content;
	private String h_id;
	private String h_price;
	private String h_score;
	private int h_suggest;

	
	public HardWareDto() {
		
	}
		
	public HardWareDto(int h_no, String h_subject, String h_name, String h_code, Timestamp h_time, int h_count, String h_content,
			String h_id, String h_price, String h_score, int h_suggest) {
		
		this.h_no = h_no;
		this.h_subject = h_subject;
		this.h_name = h_name;
		this.h_code = h_code;
		this.h_time = h_time;
		this.h_count = h_count;
		this.h_content = h_content;
		this.h_id = h_id;
		this.h_price = h_price;
		this.h_score = h_score;
		this.h_suggest = h_suggest;

	}

	public int getH_no() {
		return h_no;
	}

	public void setH_no(int h_no) {
		this.h_no = h_no;
	}

	public String getH_subject() {
		return h_subject;
	}

	public void setH_subject(String h_subject) {
		this.h_subject = h_subject;
	}

	public String getH_name() {
		return h_name;
	}

	public void setH_name(String h_name) {
		this.h_name = h_name;
	}

	public String getH_code() {
		return h_code;
	}

	public void setH_code(String h_code) {
		this.h_code = h_code;
	}

	public Timestamp getH_time() {
		return h_time;
	}

	public void setH_time(Timestamp h_time) {
		this.h_time = h_time;
	}

	public int getH_count() {
		return h_count;
	}

	public void setH_count(int h_count) {
		this.h_count = h_count;
	}

	public String getH_content() {
		return h_content;
	}

	public void setH_content(String h_content) {
		this.h_content = h_content;
	}

	public String getH_id() {
		return h_id;
	}

	public void setH_id(String h_id) {
		this.h_id = h_id;
	}

	public String getH_price() {
		return h_price;
	}

	public void setH_price(String h_price) {
		this.h_price = h_price;
	}

	public String getH_score() {
		return h_score;
	}

	public void setH_score(String h_score) {
		this.h_score = h_score;
	}

	public int getH_suggest() {
		return h_suggest;
	}

	public void setH_suggest(int h_suggest) {
		this.h_suggest = h_suggest;
	}

	
}
