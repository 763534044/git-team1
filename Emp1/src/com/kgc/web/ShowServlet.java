package com.kgc.web;

import com.kgc.pojo.Dept;
import com.kgc.pojo.Emp;
import com.kgc.service.IEmpService;
import com.kgc.service.impl.EmpServiceEmpl;
import com.kgc.utils.PageBean;

import java.io.IOException;
import java.util.List;

public class ShowServlet extends javax.servlet.http.HttpServlet {
    IEmpService service=new EmpServiceEmpl();
    PageBean page=new PageBean();
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        //取（查询条件） 调 doget
        request.setCharacterEncoding("utf-8");
        String name = request.getParameter("name");
        String startDate = request.getParameter("startDate");
        String endDate = request.getParameter("endDate");
        String startSalary = request.getParameter("startSalary");
        String endSalary = request.getParameter("endSalary");
        String deptid = request.getParameter("deptid");

        page.setName(name.trim());
        page.setStartDate(startDate.trim());
        page.setEndDate(endDate.trim());
        page.setStartSalary(startSalary.trim());
        page.setEndSalary(endSalary.trim());
        page.setDeptid(deptid.trim());

        doGet(request,response);

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        // 调 存 转
        String currPage = request.getParameter("currPage");
        if(currPage!=null){
            page.setCurrPage(Integer.valueOf(currPage));
        }
        //查询所有部门信息
        List<Dept> depts=service.selectDept();
        List<Emp> list=service.selectAll(page);
        request.getSession().setAttribute("list",list);
        request.getSession().setAttribute("page",page);
        request.getSession().setAttribute("depts",depts);
        request.getRequestDispatcher("/jsp/show.jsp").forward(request,response);
    }
}
