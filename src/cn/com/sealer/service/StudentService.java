package cn.com.sealer.service;

import cn.com.sealer.model.Pager;
import cn.com.sealer.model.Student;

public interface StudentService {
	
	/**
	 * ���ݲ�ѯ������ ��ѯѧ���ķ�ҳ��Ϣ
	 * @param serachModel ��װ��ѯ����
	 * @param pageNum ��ѯ�ڼ�ҳ����
	 * @param pageSize ÿҳ��ʾ��������¼
	 * @return
	 */
	Pager<Student> findStudent(Student serachModel, int pageNum, int pageSize);
}
