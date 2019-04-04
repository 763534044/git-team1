package com.kgc.service.impl;

import com.kgc.dao.IEmpDao;
import com.kgc.dao.impl.EmpDaoImpl;
import com.kgc.pojo.Dept;
import com.kgc.pojo.Emp;
import com.kgc.service.IEmpService;
import com.kgc.utils.PageBean;

import java.util.List;

public class EmpServiceEmpl implements IEmpService {
    IEmpDao dao=new EmpDaoImpl();

    @Override
    public List<Emp> selectAll(PageBean page) {
        //确定  总记录数 总页数
        int size=page.getSize();
        int count=dao.selectCount(page);
        int totalPage=count%size==0?(count/size):(count/size+1);
        page.setCount(count);
        page.setTotalPage(totalPage);
        return dao.selectAll(page);
    }

    @Override
    public List<Dept> selectDept() {
        return dao.selectDept();
    }
}
