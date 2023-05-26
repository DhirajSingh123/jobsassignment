package com.assignments.jobs.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.assignments.jobs.model.Jobs;
import com.assignments.jobs.model.SubJobs;
import com.assignments.jobs.repository.DbRepositoryJobs;
import com.assignments.jobs.repository.DbrepositoryForSubJobs;

@Component
public class SubJobsServices {

	@Autowired
	DbrepositoryForSubJobs subrepository;

	public Optional<SubJobs> getSubJob(String id) {

		return subrepository.findById(id);
	}

	public List<SubJobs> getAllSubJobs() {
		// TODO Auto-generated method stub
		return subrepository.findAll();
	}

	public String saveSubJobs(SubJobs obj) {

		subrepository.save(obj);

		return "Sub Jobs save successfully";
	}

	public List<SubJobs> getDescendingSortedAllJobs() {

		List<SubJobs> allSubJob = subrepository.findAll();
		List<SubJobs> allSubJobReverseOrder = new ArrayList<SubJobs>();

//		Comparator c = Collections.reverseOrder();
//	      Collections.sort(allSubJob,c);

		Collections.sort(allSubJob, new Comparator<SubJobs>() {

			public int compare(SubJobs o1, SubJobs o2) {

				return o1.getCreatedDate().compareTo(o2.getCreatedDate());
			}
		});

		/*
		 * We are sending response in Descending order
		 */
		for (int i = allSubJob.size() - 1; i >= 0; i--) {

			allSubJobReverseOrder.add(allSubJob.get(i));

		}

		return allSubJobReverseOrder;
	}

	public List<SubJobs> getAscendingOrderSortedAlljobs() {

		List<SubJobs> allSubJob = subrepository.findAll();

		/*
		 * We are sending response in ascending order
		 */
		Collections.sort(allSubJob, new Comparator<SubJobs>() {

			public int compare(SubJobs o1, SubJobs o2) {

				return o1.getCreatedDate().compareTo(o2.getCreatedDate());
			}
		});

		return allSubJob;
	}

}
