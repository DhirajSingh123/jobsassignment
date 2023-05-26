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
import com.assignments.jobs.model.SubJobs;
import com.assignments.jobs.services.SubJobsServices;

@RestController
public class SubJobsApiController {

	@Autowired
	SubJobsServices subJobsServices;

	@GetMapping("/getAllSubjobs")
	public List<SubJobs> getAllSubJobs() {

		return subJobsServices.getAllSubJobs();

	}

	@GetMapping("/getSubjob/{id}")
	public Optional<SubJobs> getSubJob(@PathVariable String id) {

		return subJobsServices.getSubJob(id);

	}

	@PostMapping("/saveSubjob")
	public String saveJob(@RequestBody SubJobs obj) {

		return subJobsServices.saveSubJobs(obj);

	}

	/*
	 * AscendingOrder order
	 */
	@GetMapping("/getAscendingOrder/SortedAllJobs")
	public List<SubJobs> getSortedAllJobs() {

		return subJobsServices.getAscendingOrderSortedAlljobs();

	}

	/*
	 * Descending order
	 */
	@GetMapping("/getDescending/SortedAllJobs")
	public List<SubJobs> getReverseSortedorderAllJobs() {

		return subJobsServices.getDescendingSortedAllJobs();

	}

}
