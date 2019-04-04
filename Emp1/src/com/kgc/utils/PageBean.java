package com.kgc.utils;

public class PageBean {
    /*
    select * from emp limit startRow,size

    (currPage-1)*size=startRow
     */
    //分页四大参数
    private int currPage=1;//当前页
    private int size=5;//每页显示几条数据
    private int totalPage;//总页数
    private int count;//总记录数
    //模糊查询条件
    private String name;
    private String startDate;
    private String endDate;
    private String startSalary;
    private String endSalary;
    private String deptid;

    public String getDeptid() {
        return deptid;
    }

    public void setDeptid(String deptid) {
        this.deptid = deptid;
    }

    public String getStartSalary() {
        return startSalary;
    }

    public void setStartSalary(String startSalary) {
        this.startSalary = startSalary;
    }

    public String getEndSalary() {
        return endSalary;
    }

    public void setEndSalary(String endSalary) {
        this.endSalary = endSalary;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCurrPage() {
        return currPage;
    }

    public void setCurrPage(int currPage) {
        this.currPage = currPage;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "PageBean{" +
                "currPage=" + currPage +
                ", size=" + size +
                ", totalPage=" + totalPage +
                ", count=" + count +
                ", name='" + name + '\'' +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", startSalary='" + startSalary + '\'' +
                ", endSalary='" + endSalary + '\'' +
                '}';
    }
}
