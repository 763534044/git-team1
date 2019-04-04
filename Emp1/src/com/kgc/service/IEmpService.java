package com.kgc.service;

import com.kgc.pojo.Dept;
import com.kgc.pojo.Emp;
import com.kgc.utils.PageBean;

import java.util.List;

public interface IEmpService {
    List<Emp> selectAll(PageBean page);

    List<Dept> selectDept();
}
