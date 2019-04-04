package com.kgc.dao;

import com.kgc.pojo.Dept;
import com.kgc.pojo.Emp;
import com.kgc.utils.PageBean;

import java.util.List;

public interface IEmpDao {
    List<Emp> selectAll(PageBean page);
//查询总记录数
    int selectCount(PageBean page);

    List<Dept> selectDept();
}
