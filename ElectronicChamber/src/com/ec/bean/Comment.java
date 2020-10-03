package com.ec.bean;

import java.util.Date;

public class Comment
{
	private int commentId;
	private String content;
	private String releaseTime;
	private int affairId;
	private String userAccount;
	
	public String getUserAccount()
	{
		return userAccount;
	}
	public void setUserAccount(String userAccount)
	{
		this.userAccount = userAccount;
	}
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
	public String getReleaseTime()
	{
		return releaseTime;
	}
	public void setReleaseTime(String releaseTime)
	{
		this.releaseTime = releaseTime;
	}
	public int getAffairId()
	{
		return affairId;
	}
	public void setAffairId(int affairId)
	{
		this.affairId = affairId;
	}	
}
