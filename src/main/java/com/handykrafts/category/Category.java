package com.handykrafts.category;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Category")
public class Category {
	
	@Id
	@GeneratedValue
	private int catid;
	private String catname;
	private String catdesc;
	private String catlink;
	
	public Category() {
		super();
	}
	
	public Category(int catid, String catname, String catdesc, String catlink) {
		super();
		this.catid = catid;
		this.catname = catname;
		this.catdesc = catdesc;
		this.catlink=catlink;
	}

	public int getCatid() {
		return catid;
	}

	public void setCatid(int catid) {
		this.catid = catid;
	}

	public String getCatname() {
		return catname;
	}

	public void setCatname(String catname) {
		this.catname = catname;
	}

	public String getCatdesc() {
		return catdesc;
	}

	public void setCatdesc(String catdesc) {
		this.catdesc = catdesc;
	}
	
	public String getCatlink() {
		return catlink;
	}

	public void setCatlink(String catlink) {
		this.catlink = catlink;
	}

	@Override
	public String toString() {
		return "CategoryModel [Categoryid=" + catid + ", Categoryname=" + catname + ", Categorydescription=" + catdesc + ", Categorydescription=" + catdesc +  "]";
	}
	
}