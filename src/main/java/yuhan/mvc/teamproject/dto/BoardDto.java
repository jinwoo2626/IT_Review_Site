package yuhan.mvc.teamproject.dto;

import java.sql.Timestamp;

public class BoardDto {
	
	//Dto������ �ݵ�� private�� �����ؾ���
	//�Ϲݸ޼ҵ� ���Ұ� /get, set, �Ϲݻ����ڸ� ����
	//�ʵ�(�Ӽ�)���� �����ͺ��̽��� �Ӽ���� �Ȱ��� �Ѵ�.
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
