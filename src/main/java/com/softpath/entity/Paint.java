package com.softpath.entity;

import javax.persistence.Embeddable;

@Embeddable
public class Paint {
	
	private String namePaint;
	private String yearPaint;
	public String getNamePaint() {
		return namePaint;
	}
	public void setNamePaint(String namePaint) {
		this.namePaint = namePaint;
	}
	public String getYearPaint() {
		return yearPaint;
	}
	public void setYearPaint(String yearPaint) {
		this.yearPaint = yearPaint;
	}
	
	

	
	
}
