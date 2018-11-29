<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户登录</title>
</head>
<body>
	<br>
	<br>

	<form  class="form-signin" action="/login/form" method="post">
              <h2 class="form-signin-heading">用户登录</h2>
            <table>
                  <tr>
                        <td>用户名:</td>
                        <td><input type="text" name="username"  class="form-control"  placeholder="请输入用户名"/></td>
                  </tr>
                        <tr>
                        <td>密码:</td>
                        <td><input type="password" name="password"  class="form-control" placeholder="请输入密码" /></td>
                  </tr>
                    <tr>
                        <td></td>
                        <td>记住我: <input type="checkbox" name="remember-me" /></td>
                    </tr>
                  <tr>
                  
                        <td colspan="2">
                              <button type="submit"  class="btn btn-lg btn-primary btn-block" >登录</button>
                        </td>
                  </tr>
            </table>
      </form>
	<br>
</body>
</html>