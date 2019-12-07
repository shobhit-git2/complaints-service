
package com.ibm.complaint.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.complaint.ComplaintConstants;
import com.ibm.complaint.exception.NoComplaintsFoundException;
import com.ibm.complaint.model.Complaint;
import com.ibm.complaint.service.ComplaintService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * This rest controller handles the restful service calls for handling
 * complaints from users.
 * 
 * @author SowjanyaLakkaraju
 *
 */
@RestController
@CrossOrigin
public class ComplaintController {

	@Autowired
	private ComplaintService complaintService;

	private ResponseEntity responseEntity;
	private Map<String, String> map = new HashMap<>();
	private static final Logger logger = LoggerFactory.getLogger(ComplaintController.class);

	public ComplaintController() {
		// TODO Auto-generated constructor stub
	}

	public ComplaintController(ComplaintService complaintService) {
		this.complaintService = complaintService;
	}

	@ApiOperation(value = "Stores the complaint from user into the database", tags = "Register Complaint")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Success | Created"),
			@ApiResponse(code = 401, message = "Un Authorized"), @ApiResponse(code = 403, message = "forbidden"),
			@ApiResponse(code = 404, message = "Resource Not Found"), @ApiResponse(code = 409, message = "Conflict"),
			@ApiResponse(code = 500, message = "Internal Server Error") })
	@PostMapping(path = "/api/v1/complaint/register")
	public ResponseEntity<?> registerComplaint(@RequestBody Complaint complaint) throws NoComplaintsFoundException {
		String status = complaintService.registerComplaint(complaint);
		if (null != status && !status.isEmpty()) {
			responseEntity = new ResponseEntity<>(ComplaintConstants.SUCCESS, HttpStatus.CREATED);
		} else {
			responseEntity = new ResponseEntity<>(ComplaintConstants.FAILURE, HttpStatus.CONFLICT);
		}

		return responseEntity;
	}

	@ApiOperation(value = "Fetches all the complaints associated to a user", tags = "Get Complaints By User")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Success | Created"),
			@ApiResponse(code = 401, message = "Un Authorized"), @ApiResponse(code = 403, message = "forbidden"),
			@ApiResponse(code = 404, message = "Resource Not Found"), @ApiResponse(code = 409, message = "Conflict"),
			@ApiResponse(code = 500, message = "Internal Server Error") })
	@PostMapping(path = "/api/v1/complaint/retrieve")
	public ResponseEntity<?> getComplaintsByUser(@RequestParam("username") String username,
			@RequestParam("status") String status, @RequestParam("groupType") String groupType) {
		try {
			List<Complaint> c = complaintService.getComplaintsByUser(username, status, groupType);
			if (null == c || c.isEmpty()) {
				return new ResponseEntity<>("No complaints found for the user:" + username, HttpStatus.NOT_FOUND);
			} else {
				return new ResponseEntity<>(c, HttpStatus.OK);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}

	}

	@ApiOperation(value = "Fetches the details of a complaint", tags = "Get Complaint details")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Success | Created"),
			@ApiResponse(code = 401, message = "Un Authorized"), @ApiResponse(code = 403, message = "forbidden"),
			@ApiResponse(code = 404, message = "Resource Not Found"), @ApiResponse(code = 409, message = "Conflict"),
			@ApiResponse(code = 500, message = "Internal Server Error") })
	@PostMapping(path = "/api/v1/complaint/details")
	public ResponseEntity<?> getComplaintDetails(@RequestParam("id") String id) {
		try {
			Complaint c = complaintService.getComplaintDetails(id);
			if (null == c) {
				return new ResponseEntity<>("No complaints found for the id:" + id, HttpStatus.NOT_FOUND);
			} else {
				return new ResponseEntity<>(c, HttpStatus.OK);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}

	}

}
