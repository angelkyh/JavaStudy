package com.example.demo.dto;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class EmpInfoDao {

	SqlSessionFactory sqlSessionFactory;
	
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}
	
	public int selectEmpList() {
		SqlSession sqlSession = sqlSessionFactory.openSession();

		String fileName = "C:/Temp/FilePrint.txt";
		PrintWriter pw = null;

		try {
			pw = new PrintWriter(new FileWriter(fileName));

			List<EmpInfoDto> empList = sqlSession.selectList("EmpInfo.selectEmpList", "0001");
			for (EmpInfoDto emp : empList) {
				pw.printf("%s ", emp.getEmpNo());
				pw.printf("%s ", emp.getEmpNm());
				pw.printf("%s ", emp.getDeptCd());
				pw.printf("%s ", emp.getDeptNm());
				pw.printf("%s ", emp.getGender());
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