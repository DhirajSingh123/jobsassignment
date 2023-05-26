package com.assignments.jobs.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;


@Document("subjobs")
public class SubJobs {
	public SubJobs(String jobId, String name, Date createdDate) {
		super();
		this.jobId = jobId;
		this.name = name;
		this.createdDate = createdDate;
	}
	private String jobId;
	private String name;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	private Date createdDate = new Date();
	public String getJobId() {
		return jobId;
	}
	public void setJobId(String jobId) {
		this.jobId = jobId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	@Override
	public String toString() {
		return "SubJobs [jobId=" + jobId + ", name=" + name + ", createdDate=" + createdDate + "]";
	}

	
}
