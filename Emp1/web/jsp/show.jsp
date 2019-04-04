<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>展示页面</title>
</head>
<body bgcolor="fuchsia">
<h1 align="center">欢迎来到员工管理系统</h1>
<form action="/Emp1/show" method="post" style="text-align: center">
    员工姓名：<input type="text" class="criteria" name="name" value="${sessionScope.page.name}">
    入职时间：<input type="date" name="startDate" value="${sessionScope.page.startDate}">
    -<input type="date" name="endDate" value="${sessionScope.page.endDate}">
    工资：<input type="text" class="criteria" name="startSalary" value="${sessionScope.page.startSalary}">-
    <input type="text" class="criteria" name="endSalary" value="${sessionScope.page.endSalary}">
    部门：<select name="deptid" >
            <option value="0">请选择部门</option>
            <c:forEach var="dept" items="${sessionScope.depts}">
                <option value="${dept.id}" <c:if test="${dept.id==page.deptid}">selected="selected"</c:if> >${dept.dname}</option>
            </c:forEach>
          </select>
    <input type="submit" value="搜索">
</form>
<table cellpadding="15" cellspacing="0" border="1" bgcolor="#adff2f" align="center">
    <tr>
        <td>编号</td>
        <td>姓名</td>
        <td>年龄</td>
        <td>性别</td>
        <td>生日</td>
        <td>入职时间</td>
        <td>工资</td>
        <td>简历</td>
        <td>津贴</td>
        <td>部门编号</td>
        <td>操作</td>
    </tr>
<c:if test="${not empty sessionScope.list}">
    <c:forEach var="emp" items="${sessionScope.list}">
        <tr>
            <td>${emp.id}</td>
            <td>${emp.name}</td>
            <td>${emp.age}</td>
            <td>${emp.gender}</td>
            <td>${emp.birthday}</td>
            <td>${emp.hiredate}</td>
            <td>${emp.salary}</td>
            <td>${emp.resume}</td>
            <td>${emp.bonus}</td>
            <td>${emp.dept.dname}</td>
            <td>操作</td>
        </tr>
    </c:forEach>
</c:if>

</table>
<table bgcolor="#7fff00" border="1" cellspacing="10" cellpadding="15" align="center">
    <tr>
        <td><a href="javascript:toPage(1)">首页</a></td>
        <td><a href="javascript:toPage(${sessionScope.page.currPage-1})">上一页</a></td>

        <c:forEach var="i" begin="1" end="${sessionScope.page.totalPage}">
            <td><a href="javascript:toPage(${i})">${i}</a></td>
        </c:forEach>
        <td><a href="javascript:toPage(${sessionScope.page.currPage+1})">下一页</a></td>
        <td><a href="javascript:toPage(${sessionScope.page.totalPage})">尾页</a></td>
        <td>跳到<input style="width: 50px" type="text" value="${sessionScope.page.currPage}">页，<input type="button" onclick="toPage(this.previousElementSibling.value)" value="go"></td>
    </tr>
</table>

</body>
<script>
    //实现双击清空输入框
window.onload=function (ev) {
    var inps=document.getElementsByClassName("criteria");
    for (var i=0;i<inps.length;i++) {
        inps[i].ondblclick=function () {
            this.value="";
        }
    }

}

    function toPage(page) {
        var end=${sessionScope.page.totalPage};
        if(page>end){
            page=end;
        }
        if(page<1){
           page=1;
        }
        location.href="/Emp1/show?currPage="+page;
    }
</script>
</html>
