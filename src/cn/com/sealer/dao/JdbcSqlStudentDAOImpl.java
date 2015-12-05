package cn.com.sealer.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import cn.com.sealer.Constant;
import cn.com.sealer.model.Pager;
import cn.com.sealer.model.Student;
import cn.com.sealer.util.JdbcUtil;

public class JdbcSqlStudentDAOImpl implements StudentDAO {

	@Override
	public Pager<Student> findStudent(Student searchModel, int pageNum, int pageSize) {
		
		Pager<Student> result = null;
		
		List<Student> stuList = new ArrayList<Student>();
		
		List<Object> paramList = new ArrayList<Object>();
		StringBuilder sql = new StringBuilder();
		StringBuilder countSql = new StringBuilder();
		
		int totalRecord = 0;
		int fromIndex = pageSize * (pageNum - 1);
		
		String name = searchModel.getName();
		int gender = searchModel.getGender();
		
		
		
		
		sql.append("select * from t_student where 1=1 ");
		countSql.append("select count(id) as totalRecord from t_student where 1=1 ");
		
		if(name != null && !"".equals(name)){
			sql.append("and stu_name like ? ");
			countSql.append("and stu_name like ? ");
			paramList.add("%" +name +"%");
		}

		
		if(gender == Constant.GENDER_FEMALE || gender == Constant.GENDER_MALE){
			sql.append("and gender = ? ");
			countSql.append("and gender = ? ");
			paramList.add(gender);
		}
		
		
		
		
		JdbcUtil jdbcUtil = new JdbcUtil();
		
		jdbcUtil.getConnection();//返回值在这里不用, 在其自己内部使用;
		
		
		try {
			List<Map<String, Object>> countMapList = jdbcUtil.findResult(countSql.toString(), paramList);
			
			if(countMapList != null){
//				totalRecord = (int)((long)countMapList.get(0).get("totalRecord"));
				totalRecord = ((Number)countMapList.get(0).get("totalRecord")).intValue();
				System.out.println(totalRecord);
			}
			
//			sql.append("limit " + (fromIndex > totalRecord ? totalRecord : fromIndex) + "," 
//						+ ((fromIndex + pageSize) > totalRecord ? (totalRecord - fromIndex + 1): pageSize));
			sql.append("limit " + fromIndex + "," + pageSize);
		
			
		
			
			List<Map<String, Object>> mapList = jdbcUtil.findResult(sql.toString(), paramList);
			
			if(mapList != null){
				for(Map<String, Object> map : mapList){
					Student student = new Student(map);
					stuList.add(student);
				}
			}
			
			
			
			
			
		} catch (SQLException e) {
			throw new RuntimeException("数据库异常", e);
		}finally{
			jdbcUtil.releaseConn();
		}
		
		
		result = new Pager<Student>(stuList, pageNum, pageSize, totalRecord);
		
		
		
		return result;
	}

}
