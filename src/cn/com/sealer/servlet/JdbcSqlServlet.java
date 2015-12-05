package cn.com.sealer.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.sealer.Constant;
import cn.com.sealer.model.Pager;
import cn.com.sealer.model.Student;
import cn.com.sealer.service.JdbcSqlStudentServiceImpl;
import cn.com.sealer.service.StudentService;
import cn.com.sealer.util.StringUtil;


@WebServlet("/JdbcSqlServlet")
public class JdbcSqlServlet extends HttpServlet {
       
    
	
	private static final long serialVersionUID = -8598726072752846656L;
	private StudentService studentService = new JdbcSqlStudentServiceImpl();

	/**
     * @see HttpServlet#HttpServlet()
     */
    public JdbcSqlServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		//接受request里的参数
		String stuName = request.getParameter("stuName");
		
		String genderStr = request.getParameter("gender");
		int gender;
		if(genderStr != null && StringUtil.isNum(genderStr.trim())){
			gender = Integer.parseInt(genderStr);
		}else{
			gender = Constant.GENDER_DEFAULT;
		}
		
		String pageNumStr = request.getParameter("pageNum");
		int pageNum;
		
		if(pageNumStr != null && StringUtil.isNum(pageNumStr.trim())){
			pageNum = Integer.parseInt(pageNumStr);
		}else{
			pageNum = Constant.PAGENUM_DEFAULT;
		}
		
		
		String pageSizeStr = request.getParameter("pageSize");
		int pageSize;
		
		if(pageSizeStr != null && StringUtil.isNum(pageSizeStr.trim())){
			pageSize = Integer.parseInt(pageSizeStr);
		}else{
			pageSize = Constant.PAGESIZE_DEFAULT;
		}
		
		
		//组装查询条件
		Student student = new Student();
		student.setGender(gender);
		student.setName(stuName);
		
		//调用service获取查询结果
		Pager<Student> result = studentService.findStudent(student, pageNum, pageSize);
		
		//将结果返回给页面
		request.setAttribute("result", result);
		request.setAttribute("name", stuName);
		request.setAttribute("gender", gender);
		request.getRequestDispatcher("JdbcSqlStudent.jsp").forward(request, response);
	}

}
