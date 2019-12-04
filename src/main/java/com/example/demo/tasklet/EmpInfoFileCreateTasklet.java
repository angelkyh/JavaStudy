package com.example.demo.tasklet;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

import com.example.demo.dto.EmpInfoDao;

public class EmpInfoFileCreateTasklet implements Tasklet {

	@Override
	public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {

		int resultVal = 0;

		// 사원 DAO 객체를 생성한다.
		EmpInfoDao empDao = new EmpInfoDao();
		
		try {
			/* 사원 목록을 조회한다. */
			resultVal = empDao.selectEmpList();
			if (resultVal != 0) {
				System.exit(resultVal);	
			}
		} catch(Throwable e) {
		    e.printStackTrace();
		    System.out.println("프로그램이 수행 실패!!!");
		} 

		return RepeatStatus.FINISHED;
	}
}