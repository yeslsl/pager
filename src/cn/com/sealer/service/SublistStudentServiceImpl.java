package cn.com.sealer.service;

import cn.com.sealer.dao.StudentDAO;
import cn.com.sealer.dao.SublistStudentDAOImpl;
import cn.com.sealer.model.Pager;
import cn.com.sealer.model.Student;

public class SublistStudentServiceImpl implements StudentService {

	private StudentDAO studentDAO;
	
	
	/**
	 * ԭ���������ʼ�� 
	 */
	public SublistStudentServiceImpl() {
		studentDAO = new SublistStudentDAOImpl();
	}



	@Override
	public Pager<Student> findStudent(Student serachModel, int pageNum, int pageSize) {
		Pager<Student> result = studentDAO.findStudent(serachModel, pageNum, pageSize);
		return result;
	}

}
