package com.sampark.ctool.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tbl_spvs_details")
public class SpvsDetailsEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private Integer id;
	
	@Column(name="SPVS_ID")
	private Integer spvsId;
	
	@Column(name="HEADER_IMAGE")
	private String headerImage;
	
	@Column(name="FOOTER_IMAGE")
	private String footerImage;
	
		
	@ManyToOne(optional=false)
	@JoinColumn(name="SPVS_ID",referencedColumnName="ID",insertable=false,updatable=false)
	private SpvsEntitiy spvsEntitiy;

	

	public SpvsEntitiy getSpvsEntitiy() {
		return spvsEntitiy;
	}

	public void setSpvsEntitiy(SpvsEntitiy spvsEntitiy) {
		this.spvsEntitiy = spvsEntitiy;
	}

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getSpvsId() {
		return spvsId;
	}

	public void setSpvsId(Integer spvsId) {
		this.spvsId = spvsId;
	}

	public String getHeaderImage() {
		return headerImage;
	}

	public void setHeaderImage(String headerImage) {
		this.headerImage = headerImage;
	}

	public String getFooterImage() {
		return footerImage;
	}

	public void setFooterImage(String footerImage) {
		this.footerImage = footerImage;
	}

	@Override
	public String toString() {
		return "SpvsDetailsEntity [id=" + id + ", spvsId=" + spvsId + ", headerImage=" + headerImage + ", footerImage="
				+ footerImage + ", spvsEntitiy=" + spvsEntitiy + "]";
	}

	

	
}
