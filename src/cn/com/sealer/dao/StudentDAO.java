package cn.com.sealer.dao;

import cn.com.sealer.model.Pager;
import cn.com.sealer.model.Student;

public interface StudentDAO {

	/**
	 * 根据查询条件， 查询学生的分页信息
	 * @param serachModel 封装查询条件
	 * @param pageNum 查询第几页数据
	 * @param pageSize 每页显示多少条记录
	 * @return
	 */
	Pager<Student> findStudent(Student serachModel, int pageNum, int pageSize);
}