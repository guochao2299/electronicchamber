package com.ec.bean;

import java.util.Date;

public class Comment
{
	private int commentId;
	private String content;
	private Date releaseTime;
	private int sortId;
	
	public int getCommentId()
	{
		return commentId;
	}
	public void setCommentId(int commentId)
	{
		this.commentId = commentId;
	}
	public String getContent()
	{
		return content;
	}
	public void setContent(String content)
	{
		this.content = content;
	}
	public Date getReleaseTime()
	{
		return releaseTime;
	}
	public void setReleaseTime(Date releaseTime)
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
