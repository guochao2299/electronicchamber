package com.ec.bean;

import java.util.Date;

public class Affair
{
	private int affairId;
	private String title;
	private String content;
	private String releaseTime;
	private int sortId;
	
	public int getAffairId()
	{
		return affairId;
	}
	public void setAffairId(int affairId)
	{
		this.affairId = affairId;
	}
	public String getTitle()
	{
		return title;
	}
	public void setTitle(String title)
	{
		this.title = title;
	}
	public String getContent()
	{
		return content;
	}
	public void setContent(String content)
	{
		this.content = content;
	}
	public String getReleaseTime()
	{
		return releaseTime;
	}
	public void setReleaseTime(String releaseTime)
	{
		this.releaseTime = releaseTime;
	}
	public int getSortId()
	{
		return sortId;
	}
	public void setSortId(int sortId)
	{
		this.sortId = sortId;
	}	
	
}
