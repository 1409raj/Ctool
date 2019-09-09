package com.sampark.ctool.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tbl_incrementLetter_details")
public class IncrementLetterDetails {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private Integer id;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="PARAGRAPH_1")
	private String paragraph1;;
	
	@Column(name="PARAGRAPH_2")
	private String paragraph2;
	
	@Column(name="PARAGRAPH_3")
	private String paragraph3;
	
	@Column(name="PARAGRAPH_4")
	private String paragraph4;

	@Column(name="PARAGRAPH_5")
	private String paragraph5;
	
	@Column(name="PARAGRAPH_6")
	private String paragraph6;
		
	@Column(name="PARAGRAPH_7")
	private String paragraph7;
	
	@Column(name="TITLE")
	private String title;
	
	
	@Column(name="STATUS")
	private Integer status;
	
	

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getParagraph1() {
		return paragraph1;
	}

	public void setParagraph1(String paragraph1) {
		this.paragraph1 = paragraph1;
	}

	public String getParagraph2() {
		return paragraph2;
	}

	public void setParagraph2(String paragraph2) {
		this.paragraph2 = paragraph2;
	}

	public String getParagraph3() {
		return paragraph3;
	}

	public void setParagraph3(String paragraph3) {
		this.paragraph3 = paragraph3;
	}

	public String getParagraph4() {
		return paragraph4;
	}

	public void setParagraph4(String paragraph4) {
		this.paragraph4 = paragraph4;
	}

	public String getParagraph5() {
		return paragraph5;
	}

	public void setParagraph5(String paragraph5) {
		this.paragraph5 = paragraph5;
	}

	public String getParagraph6() {
		return paragraph6;
	}

	public void setParagraph6(String paragraph6) {
		this.paragraph6 = paragraph6;
	}

	public String getParagraph7() {
		return paragraph7;
	}

	public void setParagraph7(String paragraph7) {
		this.paragraph7 = paragraph7;
	}

	
	
	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "IncrementLetterDetails [id=" + id + ", name=" + name + ", paragraph1=" + paragraph1 + ", paragraph2="
				+ paragraph2 + ", paragraph3=" + paragraph3 + ", paragraph4=" + paragraph4 + ", paragraph5="
				+ paragraph5 + ", paragraph6=" + paragraph6 + ", paragraph7=" + paragraph7 + ", title=" + title
				+ ", status=" + status + "]";
	}


}
