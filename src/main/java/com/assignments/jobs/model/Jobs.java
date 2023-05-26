package com.assignments.jobs.model;

import java.util.Arrays;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("jobs")
public class Jobs {

	public Jobs(int assetId, String description) {
		super();
		this.assetId = assetId;
		this.description = description;
		
	}
	private int assetId;
	private String description;
	private SubJobs[] subJob;
	public int getAssetId() {
		return assetId;
	}
	public void setAssetId(int assetId) {
		this.assetId = assetId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public SubJobs[] getSubJob() {
		return subJob;
	}
	public void setSubJob(SubJobs[] subJob) {
		this.subJob = subJob;
	}
	@Override
	public String toString() {
		return "Jobs [assetId=" + assetId + ", description=" + description + ", subJob=" + Arrays.toString(subJob)
				+ "]";
	}

	
}
