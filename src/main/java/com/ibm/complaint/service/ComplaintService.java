package com.ibm.complaint.service;

import java.util.List;

import com.ibm.complaint.exception.NoComplaintsFoundException;
import com.ibm.complaint.model.Complaint;

public interface ComplaintService {

	String registerComplaint(Complaint complaint);

	List<Complaint> getComplaintsByUser(String username,String status, String groupType) throws NoComplaintsFoundException;

	Complaint getComplaintDetails(String id) throws NoComplaintsFoundException;
}
