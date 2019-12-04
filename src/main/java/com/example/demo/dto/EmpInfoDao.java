package com.example.demo.dto;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmpInfoDao {

	 //@Resource(name="sqlSession")
     private SqlSession sqlSession;

	 public int selectEmpList() {

		String conf = "config/context.xml";
		String fileName = "C:/Temp/FilePrint.txt";
		PrintWriter pw = null;

		ApplicationContext context = new ClassPathXmlApplicationContext(conf);
		sqlSession = (SqlSession) context.getBean("sqlSession");

		try {
			pw = new PrintWriter(new FileWriter(fileName));

			List<EmpInfoDto> empList = sqlSession.selectList("EmpInfo.selectEmpList", "0003");
			for (EmpInfoDto emp : empList) {
				pw.printf(  "%5s", emp.getEmpNo());
				pw.printf("%-20s", emp.getEmpNm());
				pw.printf(  "%4s", emp.getDeptCd());
				pw.printf("%-20s", emp.getDeptNm());
				pw.printf(  "%1s", emp.getGender());
				pw.printf( "%-8s", emp.getRetireDt());
				pw.printf("%-20s", emp.getRegiUserId());
				pw.printf("%-16s", emp.getRegiDttm());
				pw.printf("%-20s", emp.getLastModUserId());
				pw.printf("%-16s", emp.getLastModDttm());
				pw.println();
			}

		} catch(Throwable e) {
			e.printStackTrace();
			return -1;
		} finally {
			pw.close();
		}

		return 0;
	}
}