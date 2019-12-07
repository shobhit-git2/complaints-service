package com.ibm.complaint.service.impl;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.complaint.ComplaintConstants;
import com.ibm.complaint.exception.NoComplaintsFoundException;
import com.ibm.complaint.model.Complaint;
import com.ibm.complaint.repository.ComplaintRepository;
import com.ibm.complaint.service.ComplaintService;

@Service
public class ComplaintServiceImpl implements ComplaintService {

	@Autowired
	private ComplaintRepository repo;

	@Override
	public String registerComplaint(Complaint complaint) {
		// Setting defaults
		complaint.setComplaintStatus(ComplaintConstants.DEFAULT_COMPLAINT_STATUS);
		complaint.setCreatedDate(new Date());
		complaint.setAssignedTo(ComplaintConstants.DEFAULT_MAINTENANCE_TEAM);
		complaint.setOperationType(ComplaintConstants.DEFAULT_OPERATION_TYPE);
		String result = repo.add(complaint);

		return result;
	}

	@Override
	public List<Complaint> getComplaintsByUser(String username, String status, String groupType)
			throws NoComplaintsFoundException {
		List<Complaint> comList = repo.getComplaintsByUser(username, status, groupType);
		return comList;
	}

	@Override
	public Complaint getComplaintDetails(String id) throws NoComplaintsFoundException {
		Complaint comList;
		try {
			comList = repo.getComplaintDetails(id);
		} catch (IOException e) {
			throw new NoComplaintsFoundException("Error occurred due to:" + e.getMessage());
		}
		return comList;
	}

}
