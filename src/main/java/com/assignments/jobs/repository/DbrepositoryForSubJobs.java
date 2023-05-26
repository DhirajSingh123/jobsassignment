package com.assignments.jobs.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.assignments.jobs.model.Jobs;
import com.assignments.jobs.model.SubJobs;

@Repository
public interface DbrepositoryForSubJobs extends MongoRepository<SubJobs, String> {





}
