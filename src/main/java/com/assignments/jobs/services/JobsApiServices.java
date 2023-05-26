package com.assignments.jobs.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.assignments.jobs.model.Jobs;
import com.assignments.jobs.repository.DbRepositoryJobs;

@Component
public class JobsApiServices {

	@Autowired
	DbRepositoryJobs repository;

	public List<Jobs> getAllJobs() {
		
			return repository.findAll();
		

	}

	public Optional<Jobs> getJob(int id) {
		
			return repository.findById(id);
	

		
	}

	public String saveJob(Jobs obj) {

		try {
			repository.save(obj);
		} catch (Exception e) {
			System.out.println("something wrong please check " + e);
		}

		return "jobs saved successfully";
	}

}
