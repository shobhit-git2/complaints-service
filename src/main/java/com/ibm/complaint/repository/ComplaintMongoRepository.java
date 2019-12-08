package com.ibm.complaint.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ibm.complaint.model.Complaint;

public interface ComplaintMongoRepository extends MongoRepository<Complaint, String> {
	Complaint findBy_id(String _id);
}
