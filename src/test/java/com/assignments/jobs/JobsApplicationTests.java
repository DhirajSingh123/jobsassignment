package com.assignments.jobs;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.DynamicTest.stream;
import static org.mockito.Mockito.when;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.assignments.jobs.model.Jobs;
import com.assignments.jobs.model.SubJobs;
import com.assignments.jobs.repository.DbRepositoryJobs;
import com.assignments.jobs.repository.DbrepositoryForSubJobs;
import com.assignments.jobs.services.JobsApiServices;
import com.assignments.jobs.services.SubJobsServices;
import com.mongodb.connection.Stream;

@SpringBootTest
class JobsApplicationTests {

	@Autowired
	private JobsApiServices apiservices;
	@Autowired
	private SubJobsServices subJobsServices;

	@MockBean
	private DbRepositoryJobs dbepositoryJobs;
	@MockBean
	private DbrepositoryForSubJobs dbrepositoryForSubJobs;

	/*
	 * Create a Mock test using multiple threads updating the counter in parallel.
	 * With out using synchronization
	 */
	@Test
	public void counterWithoutSyncronization() throws InterruptedException {
		int numberOfThreads = 10;
		ExecutorService service = Executors.newFixedThreadPool(10);
		CountDownLatch latch = new CountDownLatch(numberOfThreads);
		Counter counter = new Counter();
		for (int i = 0; i < numberOfThreads; i++) {
			service.execute(() -> {
				counter.increment();
				latch.countDown();
			});
		}
		latch.await();
		assertEquals(numberOfThreads, counter.getCount());
	}

	/*
	 * getAllJobs testing using mockito
	 */

	@Test
	public void getAllJobs() {

		List<Jobs> job = List.of(new Jobs(101, "cricket_discovery"), new Jobs(102, "catalogue_discovery"));

		when(dbepositoryJobs.findAll()).thenReturn(job);

		assertEquals(2, apiservices.getAllJobs().size());
	}

//	

}
