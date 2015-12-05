package cn.com.sealer.service;

import cn.com.sealer.dao.JdbcSqlStudentDAOImpl;
import cn.com.sealer.dao.StudentDAO;
import cn.com.sealer.model.Pager;
import cn.com.sealer.model.Student;

public class JdbcSqlStudentServiceImpl implements StudentService {

	private StudentDAO studentDAO;
	
	
	/**
	 * 原则：随用随初始化 
	 */
	public JdbcSqlStudentServiceImpl() {
		studentDAO = new JdbcSqlStudentDAOImpl();
	}



	@Override
	public Pager<Student> findStudent(Student serachModel, int pageNum, int pageSize) {
		Pager<Student> result = studentDAO.findStudent(serachModel, pageNum, pageSize);
		return result;
	}

}
