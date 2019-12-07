package com.ibm.complaint.model;

import java.util.Date;

public class Complaint {

	private String _id;
	private String title;
	private String description;
	private String complaintCategory;
	private String complaintStatus;
	private String location;
	private String floorNo;
	private String seatNumber;
	private String contactNumber;
	private String assignedTo;
	private String comments;
	private String username;
	private Date createdDate;
	private String operationType;
	private Date completedDate;

	public Complaint() {
		// TODO Auto-generated constructor stub
	}

	public Complaint(String _id, String title, String description, String complaintCategory,
			String complaintStatus, String location, String floorNo, String seatNumber, String contactNumber,
			String assignedTo, String comments, String username, Date createdDate, String operationType) {
		super();
		this._id = _id;
		this.title = title;
		this.description = description;
		this.complaintCategory = complaintCategory;
		this.complaintStatus = complaintStatus;
		this.location = location;
		this.floorNo = floorNo;
		this.seatNumber = seatNumber;
		this.contactNumber = contactNumber;
		this.assignedTo = assignedTo;
		this.comments = comments;
		this.username = username;
		this.createdDate = createdDate;
		this.operationType = operationType;
	}

	public String getId() {
		return _id;
	}

	public void setId(String complaintNo) {
		this._id = complaintNo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getComplaintCategory() {
		return complaintCategory;
	}

	public void setComplaintCategory(String complaintCategory) {
		this.complaintCategory = complaintCategory;
	}

	public String getComplaintStatus() {
		return complaintStatus;
	}

	public void setComplaintStatus(String complaintStatus) {
		this.complaintStatus = complaintStatus;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getFloorNo() {
		return floorNo;
	}

	public void setFloorNo(String floorNo) {
		this.floorNo = floorNo;
	}

	public String getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(String seatNumber) {
		this.seatNumber = seatNumber;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getAssignedTo() {
		return assignedTo;
	}

	public void setAssignedTo(String assignedTo) {
		this.assignedTo = assignedTo;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = (null == comments ? "" : comments);
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getOperationType() {
		return operationType;
	}

	public void setOperationType(String operationType) {
		this.operationType = operationType;
	}

	@Override
	public String toString() {
		return "Complaint [id=" + _id + ", title=" + title + ", description=" + description + ", complaintCategory="
				+ complaintCategory + ", complaintStatus=" + complaintStatus + ", location=" + location + ", floorNo="
				+ floorNo + ", seatNumber=" + seatNumber + ", contactNumber=" + contactNumber + ", assignedTo="
				+ assignedTo + ", comments=" + comments + ", username=" + username + ", createdDate=" + createdDate
				+ ", operationType=" + operationType + ", completedDate=" + completedDate + "]";
	}

	public Date getCompletedDate() {
		return completedDate;
	}

	public void setCompletedDate(Date completedDate) {
		this.completedDate = completedDate;
	}

}
