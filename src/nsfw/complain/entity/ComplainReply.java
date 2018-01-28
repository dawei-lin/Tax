package nsfw.complain.entity;

import java.sql.Timestamp;

/**
 * ComplainReply entity. @author MyEclipse Persistence Tools
 */

public class ComplainReply implements java.io.Serializable {

	// Fields

	private String replyId;
	private Complain complain;
	private String replyDept;
	private String replyName;
	private String replyContent;
	private Timestamp replyDate;

	// Constructors

	/** default constructor */
	public ComplainReply() {
	}

	/** minimal constructor */
	public ComplainReply(Complain complain) {
		this.complain = complain;
	}

	/** full constructor */
	public ComplainReply(Complain complain, String replyDept, String replyName,
			String replyContent, Timestamp replyDate) {
		this.complain = complain;
		this.replyDept = replyDept;
		this.replyName = replyName;
		this.replyContent = replyContent;
		this.replyDate = replyDate;
	}

	// Property accessors

	public String getReplyId() {
		return this.replyId;
	}

	public void setReplyId(String replyId) {
		this.replyId = replyId;
	}

	public Complain getComplain() {
		return this.complain;
	}

	public void setComplain(Complain complain) {
		this.complain = complain;
	}

	public String getReplyDept() {
		return this.replyDept;
	}

	public void setReplyDept(String replyDept) {
		this.replyDept = replyDept;
	}

	public String getReplyName() {
		return this.replyName;
	}

	public void setReplyName(String replyName) {
		this.replyName = replyName;
	}

	public String getReplyContent() {
		return this.replyContent;
	}

	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}

	public Timestamp getReplyDate() {
		return this.replyDate;
	}

	public void setReplyDate(Timestamp replyDate) {
		this.replyDate = replyDate;
	}

}