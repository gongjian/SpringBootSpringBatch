package com.gongjian.schedule;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduledTaskService {
	
	@Autowired
	private JobLauncher jobLauncher;

	@Autowired
	private Job importJob;
	
	private JobParameters jobParameters;
	
	private static final SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");

	@Scheduled(fixedRate = 50*1000, initialDelay = 1*1000)
	public void reportCurrentTime() throws Exception {
		System.out.println("每隔5秒执行一次 " + formatter.format(new Date()));
		
		jobParameters = new JobParametersBuilder()
				.addLong("time", System.currentTimeMillis())
				//.addString("input.file.name", "people.csv")
				.toJobParameters();
		
		jobLauncher.run(importJob, jobParameters);
	}

	// 使用cron属性可按照指定时间执行，本例指的是每天20点07分执行
	/*@Scheduled(cron = "0 01 20 ? * *")
	public void fixTimeExecution() {
		System.out.println("在指定时间 " + formatter.format(new Date()) + " 执行");
	}*/

}
