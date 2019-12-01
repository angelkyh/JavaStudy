package com.example.demo.dto;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class EmpInfoDao {

     private SqlSession sqlSession;

     public void setSqlSession(SqlSession sqlSession) {
       this.sqlSession = sqlSession;
     }
  
	//SqlSessionFactory sqlSessionFactory;
	
	//public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
	//	this.sqlSessionFactory = sqlSessionFactory;
	//}
	
	public int selectEmpList() {
		SqlSession sqlSession = sqlSessionFactory.openSession();

		String fileName = "C:/Temp/FilePrint.txt";
		PrintWriter pw = null;

		try {
			pw = new PrintWriter(new FileWriter(fileName));

			List<EmpInfoDto> empList = sqlSession.selectList("EmpInfo.selectEmpList", "0003");
			for (EmpInfoDto emp : empList) {
				pw.printf("%s ", emp.getEmpNo());
				pw.printf("%s ", emp.getEmpNm());
				pw.printf("%s ", emp.getDeptCd());
				pw.printf("%s ", emp.getDeptNm());
				pw.printf("%s ", emp.getGender());
				pw.printf("%s ", emp.getRetireDt());
				pw.printf("%s ", emp.getRegiUserId());
				pw.printf("%s ", emp.getRegiDttm());
				pw.printf("%s ", emp.getLastModUserId());
				pw.printf("%s ", emp.getLastModDttm());
				pw.println();
			}

		} catch(Throwable e) {
			e.printStackTrace();
			return -1;
		} finally {
			sqlSession.close();
			pw.close();
		}

		return 0;
	}
}