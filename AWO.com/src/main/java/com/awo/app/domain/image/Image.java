package com.awo.app.domain.image;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import com.awo.app.domain.registration.Registration;

@Entity
public class Image implements Serializable {

	private static final long serialVersionUID = -6473532570200791535L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int imgId;

	private String imgName;

	private String type;

	
	@Lob
	private byte[] pic;

	private String createdDate;

	private String modifiedDate;

	private int regId;

	public int getRegId() {
		return regId;
	}

	public void setRegId(int regId) {
		this.regId = regId;
	}
	


	public Image() {
		super();
	}

	public Image(int imgId, String imgName, String type, byte[] pic, String createdDate,
			String modifiedDate, int regId) {
		super();
		this.imgId = imgId;
		this.imgName = imgName;
		this.type = type;
		this.pic = pic;
		this.createdDate = createdDate;
		this.modifiedDate = modifiedDate;
		this.regId = regId;
	}

	public int getImgId() {
		return imgId;
	}

	public void setImgId(int imgId) {
		this.imgId = imgId;
	}

	public String getImgName() {
		return imgName;
	}

	public void setImgName(String imgName) {
		this.imgName = imgName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}


	public byte[] getPic() {
		return pic;
	}

	public void setPic(byte[] pic) {
		this.pic = pic;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(String modifiedDate) {
		this.modifiedDate = modifiedDate;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
