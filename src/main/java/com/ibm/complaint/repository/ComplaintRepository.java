package com.ibm.complaint.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ComplaintRepository {

	//@Autowired
	//private Database db;
	
	@Autowired
	ComplaintMongoRepository complaintmongorepository;

	public ComplaintRepository() {
	}

	/*
	 * public List<Complaint> getAll() throws IOException { List<Complaint> allDocs
	 * = db.getAllDocsRequestBuilder().includeDocs(true).build().getResponse()
	 * .getDocsAs(Complaint.class); return allDocs; }
	 * 
	 * public Complaint getComplaintDetails(String id) throws IOException {
	 * Complaint complaint = db.find(Complaint.class, id); return complaint; }
	 * 
	 * public List<Complaint> getComplaintsByUser(String username, String status,
	 * String groupType) throws NoComplaintsFoundException { Map<String, Object>
	 * selector = new HashMap<String, Object>(); selector.put("username",
	 * username.toString()); selector.put("complaintStatus", status);
	 * selector.put("assignedTo", groupType); List<Complaint> complaint = null; try
	 * { complaint = db.findByIndex(new GsonBuilder().create().toJson(selector),
	 * Complaint.class); } catch (Exception e) { throw new
	 * NoComplaintsFoundException("No complaints found due to " + e.getMessage()); }
	 * return complaint; }
	 * 
	 * public String add(Complaint complaint) { //Response response =
	 * db.post(complaint); complaintmongorepository.save(complaint); String id =
	 * response.getId(); return id; }
	 */

}
