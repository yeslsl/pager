package cn.com.sealer.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import cn.com.sealer.Constant;
import cn.com.sealer.model.Pager;
import cn.com.sealer.model.Student;
import cn.com.sealer.util.JdbcUtil;

public class SublistStudentDAOImpl implements StudentDAO {

	@Override
	public Pager<Student> findStudent(Student searchModel, int pageNum, int pageSize) {
		
		List<Student> stuList = findAllStudents(searchModel);
		Pager<Student> pager = new Pager<Student>(stuList, pageNum, pageSize);
		return pager;
	}
	
	
	public List<Student> findAllStudents(Student searchModel){
		List<Student> result = new ArrayList<Student>(); 
		
		List<Object> paramList = new ArrayList<Object>();
		StringBuilder sql = new StringBuilder();
		sql.append("select * from t_student where 1=1 ");
		String name = searchModel.getName();
		int gender = searchModel.getGender();
		
		if(name != null && !"".equals(name)){
			sql.append("and stu_name like ? ");
			paramList.add("%" +name +"%");
		}

		
		if(gender == Constant.GENDER_FEMALE || gender == Constant.GENDER_MALE){
			sql.append("and gender = ? ");
			paramList.add(gender);
		}
		
		JdbcUtil jdbcUtil = new JdbcUtil();
		
		jdbcUtil.getConnection();//返回值在这里不用, 在其自己内部使用;
		
		try {
			List<Map<String, Object>> mapList = jdbcUtil.findResult(sql.toString(), paramList);
			if(mapList != null){
				for(Map<String, Object> map : mapList){
					Student student = new Student(map);
					result.add(student);
				}
			}
			
		} catch (SQLException e) {
			throw new RuntimeException("数据库异常", e);
		}finally{
			jdbcUtil.releaseConn();
		}
		
		return result;
	}
	
	
	public static void main(String[] args){
		SublistStudentDAOImpl daoImpl = new SublistStudentDAOImpl();
		List<Student> stuList = daoImpl.findAllStudents(new Student(1, "王小军", 1, 0, "北京市东城区"));
		if(stuList != null){
			for(Student s : stuList){
				System.out.println(s.getName());
			}
		}
		
		System.out.println("=========================================================");
		
		Pager<Student> paper = daoImpl.findStudent(new Student(1, "王小军", 17, 1, null), 2, 3);
		List<Student> list = paper.getDataList();
		for(Student s : list){
			System.out.println(s.getName());
		}
		
	}

}
