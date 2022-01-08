<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.Map" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>update</title>
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi"/>

    <link rel="icon" href="/images/favicon.ico" sizes="32x32"/>
    <link rel="stylesheet" href="/css/font.css">
    <link rel="stylesheet" href="/css/xadmin.css">
    <script type="text/javascript" src="/js/jquery-1.3.2.min.js"></script>
    <script src="/lib/layui/layui.js"></script>
    <script type="text/javascript" src="/js/xadmin.js"></script>
    <script src="/layui_exts/excel.js"></script>

    <style type="text/css">
        .layui-table {
            text-align: center;
        }

        .layui-table th {
            text-align: center;
        }
    </style>
</head>
<body>
<div class="layui-col-md10">
    <div class="layui-form" id="addEmployeeForm">
        <% Map<String, Object> st = (Map<String, Object>)request.getAttribute("student"); %>
        <div class="layui-form-item">
            <label class="layui-form-label">学号：</label>
            <div class="layui-input-block">
                <input type="text" id="updateId" class="layui-input" value="<%=st.get("s_id")%>">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">姓名：</label>
            <div class="layui-input-block">
                <input type="text" id="updateName" class="layui-input" value="<%=st.get("s_name")%>">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">性别：</label>
            <div class="layui-input-block">
                <input type="text" id="updateSex" class="layui-input" value="<%=st.get("s_sex")%>">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">学院：</label>
            <div class="layui-input-block">
                <input type="text" id="updateCollege" class="layui-input" value="<%=st.get("s_college")%>">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">班级：</label>
            <div class="layui-input-block">
                <input type="text" id="updateSClass" class="layui-input" value="<%=st.get("s_class")%>">
            </div>
        </div>

        <div class="layui-form-item">
            <div class="layui-input-block">
                <button type="button" id="addSubmitBtn" class="layui-btn layui-btn-normal" lay-submit
                        lay-filter="formDemo">提交
                </button>
                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
            </div>
        </div>
    </div>
</div>
<script src='https://code.jquery.com/jquery-3.3.1.min.js'></script>
<script src="/js/student/student_update.js"></script>
</body>
</html>