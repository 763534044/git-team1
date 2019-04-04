package com.kgc.dao.impl;

import com.kgc.dao.IEmpDao;
import com.kgc.pojo.Dept;
import com.kgc.pojo.Emp;
import com.kgc.utils.JdbcUtil;
import com.kgc.utils.PageBean;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

public class EmpDaoImpl implements IEmpDao {
    @Override
    public List<Emp> selectAll(PageBean page) {
        System.out.println(page);
        QueryRunner qr=new QueryRunner(JdbcUtil.getDataSource());
        try {
            String sql="select * from emp where 1=1";
            String name=page.getName();
            String startDate=page.getStartDate();
            String endDate=page.getEndDate();
            String startSalary = page.getStartSalary();
            String endSalary = page.getEndSalary();
            String deptid = page.getDeptid();
            if(name!=null&&!name.equals("")){
                sql+=" and name like '%"+name+"%'";
            }
            if(startDate!=null&&!startDate.equals("")){
                sql+=" and hiredate >= '"+startDate+"'";
            }
            if(endDate!=null&&!endDate.equals("")){
                sql+=" and hiredate <= '"+endDate+"'";
            }
            if(startSalary!=null&&!startSalary.equals("")){
                sql+=" and salary >= "+startSalary;
            }
            if(endSalary!=null&&!endSalary.equals("")){
                sql+=" and salary <= "+endSalary;
            }
            if(deptid!=null&&!deptid.equals("0")){
                sql+=" and deptid = "+deptid;
            }

           sql+=" limit ?,?";
            System.out.println(sql);
            int startRow=(page.getCurrPage()-1)*page.getSize();
            List<Emp> list = qr.query(sql, new BeanListHandler<Emp>(Emp.class),
                    startRow, page.getSize());
            //关联部门信息
            for(Emp emp:list){
                Dept dept = qr.query("select * from dept where id=?", new BeanHandler<Dept>(Dept.class), emp.getDeptid());
                emp.setDept(dept);
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public int selectCount(PageBean page) {
        QueryRunner qr=new QueryRunner(JdbcUtil.getDataSource());
        try {
            String sql="select count(*) from emp where 1=1";
            String name=page.getName();
            String startDate=page.getStartDate();
            String endDate=page.getEndDate();
            String startSalary = page.getStartSalary();
            String endSalary = page.getEndSalary();
            String deptid = page.getDeptid();
            if(name!=null&&!name.equals("")){
                sql+=" and name like '%"+name+"%'";
            }
            if(startDate!=null&&!startDate.equals("")){
                sql+=" and hiredate >= '"+startDate+"'";
            }
            if(endDate!=null&&!endDate.equals("")){
                sql+=" and hiredate <= '"+endDate+"'";
            }
            if(startSalary!=null&&!startSalary.equals("")){
                sql+=" and salary >= "+startSalary;
            }
            if(endSalary!=null&&!endSalary.equals("")){
                sql+=" and salary <= "+endSalary;
            }
            if(deptid!=null&&!deptid.equals("0")){
                sql+=" and deptid = "+deptid;
            }
            return qr.query(sql, new ScalarHandler<Long>()).intValue();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Dept> selectDept() {
        QueryRunner qr=new QueryRunner(JdbcUtil.getDataSource());
        try {
            return qr.query("select * from dept", new BeanListHandler<Dept>(Dept.class));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
