package com.assignments.jobs.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.assignments.jobs.model.Jobs;
import com.assignments.jobs.services.JobsApiServices;

@RestController
public class JobsApiController {

	@Autowired
	JobsApiServices services;

	@GetMapping("/getjobs")
	public List<Jobs> getAllJobs() {

		return services.getAllJobs();

	}

	@GetMapping("/getjob/{id}")
	public Optional<Jobs> getJob(@PathVariable int id) {

		return services.getJob(id);

	}

	@PostMapping("/savejob")
	public String saveJob(@RequestBody Jobs obj) {

		return services.saveJob(obj);

	}

}
