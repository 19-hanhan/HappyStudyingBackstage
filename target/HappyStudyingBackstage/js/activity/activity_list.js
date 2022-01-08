layui.config({
    base: '../layui_exts/', <!--111111111111111111111111111-->
}).extend({
    excel: 'excel',
});

layui.use(['jquery', 'excel', 'form', 'layer', 'laydate'], function () {
    var form = layui.form,
        $ = layui.jquery,
        laydate = layui.laydate;
    var excel = parent.layui.excel;

    //执行一个laydate实例
    laydate.render({
        elem: '#start' //指定元素
    });
    form.render();

    form.on('submit(toolbarDemo)', function () {

        $.ajax({
            url: '/ExportActivityListHttpServlet',
            type: 'post',
            dataType: 'json',
            contentType: "application/json; charset=utf-8",
            success: function (data) {
                console.log(data);

                // 1. 如果需要调整顺序，请执行梳理函数
                var dt = excel.filterExportData(data, [
                    'a_id',
                    'a_user_id',
                    'a_user_name',
                    'a_publish_time',
                    'a_begin_time',
                    'a_end_time',
                    'a_view_number',
                    'a_responses_number',
                    'a_title',
                    'a_icon',
                    'a_description',
                    'a_colleges',
                    'a_grade_level',
                    'is_sticky',
                    'is_essence'
                ]);

                // 2. 数组头部新增表头
                dt.unshift({
                    a_id: 'ID',
                    a_user_id: '发布者编号',
                    a_user_name: '发布者名称',
                    a_publish_time: '发布时间',
                    a_begin_time: '活动开始时间',
                    a_end_time: '活动结束时间',
                    a_view_number: '浏览数',
                    a_responses_number: '回复数',
                    a_title: '活动标题',
                    a_icon: '活动图标',
                    a_description: '活动描述',
                    a_colleges: '所属学院',
                    a_grade_level: '所属年级',
                    is_sticky: '是否置顶',
                    is_essence: '是否精华'
                });

                // 意思是：A列40px，B列60px(默认)，C列120px，D、E、F等均未定义
                var colConf = excel.makeColConfig({
                    'A': 40,
                    'D': 90
                }, 60);

                var timestart = Date.now();
                // 3. 执行导出函数，系统会弹出弹框
                excel.exportExcel({
                    sheet1: dt
                }, '活动数据.xlsx', 'xlsx', {
                    extend: {
                        '!cols': colConf
                    }
                });
                var timeend = Date.now();

                var spent = (timeend - timestart) / 1000;
                layer.alert('导出耗时 ' + spent + ' s');
                //setTimeout(function () {window.location.href='/findAdmin';},2000);
            },

            error: function () {
                //console.log(data);
                setTimeout(function () {
                    window.location.href = '/home/activity_list';
                }, 2000);
            }
        });
    });


    /*添加弹出框*/
    // $("#addStudnetBtn").click(function () {
    //     // alert(1);
    //     layer.open({
    //         type: 1,
    //         title: "添加管理员",
    //         skin: "myclass",
    //         area: ["50%"],
    //         anim: 2,
    //         content: $("#test").html()
    //     });
    //     // $("#addEmployeeForm")[0].reset();
    //     form.on('submit(formDemo)', function (data) {
    //         // layer.msg('aaa',{icon:1,time:3000});
    //         var param = data.field;
    //         console.log(JSON.stringify(param));
    //         $.ajax({
    //             url: '/AddAdminHttpServlet',
    //             type: "post",
    //             data: JSON.stringify(param),
    //             // dataType: "text",
    //             contentType: "application/json; charset=utf-8",
    //             success: function (da) {
    //                 console.log(da);
    //                 layer.msg('添加成功', {icon: 1, time: 2000});
    //                 setTimeout(function () {
    //                     window.location.href = '/home/admin_list';
    //                 }, 2000);
    //
    //             },
    //             error: function () {
    //                 layer.msg('添加失败', {icon: 0, time: 2000});
    //                 setTimeout(function () {
    //                     window.location.href = '/AddAdminHttpServlet';
    //                 }, 2000);
    //             }
    //         });
    //         // return false;
    //     });
    // });

    // $(function () {
    //     $("body").on('click', '#addSubmitBtn', function () {
    //         var email = $('[name=email]').text();
    //         // var email = document.getElementById("addEmail").innerHTML;
    //         var pwd = $('[name=password]').val();
    //         var name = $('[name=name]').val();
    //         console.log(email);
    //         console.log(pwd);
    //         console.log(name);
    //         $.ajax({
    //             url: '/AddAdminHttpServlet',
    //             type: 'get',
    //             data: {
    //                 name: name,
    //                 pwd: pwd,
    //                 email: email
    //             },
    //             dataType: 'text',
    //             success: function (data) {
    //                 if (data == 'true') {
    //                     alert("添加成功");
    //                 } else {
    //                     alert("添加错误");
    //                 }
    //             }
    //         });
    //     });
    // })
})

$.ajax({
    url: '/activity_list.do',
    data: {},
    dataType: 'json',
    type: 'get',
    success: function (jdata) {
        // 显示用户数据数量
        var cnt = jdata.count;
        console.log("cnt = " + cnt);
        var activity_count_html = '共有数据：' + cnt + ' 条';
        $('#activityCount').html(activity_count_html);

        // 显示管理员列表
        var ls_data = jdata.list;
        if (ls_data.length > 0) {
            console.log(ls_data);
            var activity_list_html = '<thead>\n' +
                '        <tr>\n' +
                '            <th>标题</th>\n' +
                '            <th>发布者姓名</th>\n' +
                '            <th>所属学院</th>\n' +
                '            <th>是否置顶</th>\n' +
                '            <th>是否精华</th>\n' +
                '            <th>操作</th>\n' +
                '        </thead>\n';
            ls_data.map(function (item, index) {
                activity_list_html += '        <tbody>\n' +
                    '        <tr>\n' +
                    '            <td>' + item.aTitle + '</td>\n' +
                    '            <td>' + item.aUserName + '</td>\n' +
                    '            <td>' + item.aColleges + '</td>\n' +
                    '            <td>' + item.isSticky + '</td>\n' +
                    '            <td>' + item.isEssence + '</td>\n' +
                    '            <td class="td-manage">\n' +
                    '                <a title="编辑" onClick=\'javascript:window.open("/UpdateActivityServlet?id=' + item.aId + '","","width=400,height=270,top=400,left=600,toolbar=no, status=no, menubar=no, resizable=no, scrollbars=no");return false;\'>\n' +
                    '                    <i class="layui-icon">&#xe642;</i>\n' +
                    '                </a>\n' +
                    '                <a href="/OptActivityHttpServlet?id=' + item.aId + '&opt=delete" onclick="delActivity(this)">\n' +
                    '                    <i class="layui-icon">&#xe640;</i>\n' +
                    '                </a>\n' +
                    '            </td>\n' +
                    '        </tr>\n' +
                    '        </tbody>'
            })
            $('#activityList').html(activity_list_html);
        }
    }
})

// // 编辑
// $(".updateEdit").click(function () {
//     var myid = $(this).parent("td").parent("tr").children(".myid").html();
//     //判断
//     var admin_id = ${sessionScope.ad.a_id};
//     if (admin_id != myid) {
//         layer.alert("对不起，您没有权限:(");
//     } else {
//     <%
//         --window.location.href = "/findAdminById?a_id=${ai.a_id}";
//         -- % >
//         window.location.href = "/findAdminById?a_id=" + myid;
//     }
// });


// 删除
function delActivity(obj) {
    var statu = confirm("确认要删除该用户信息吗?");
    if (!statu) {
        return false;
    }
    else return true;
}

$("#searchBtn").click(function () {
    var key = $("#findByName").val();
    console.log(key);
    $.ajax({
        url: '/FindActivityHttpServlet',
        type: 'post',
        data: {key: key},
        dataType: 'json',
        success: function (jdata) {

            // 显示管理员列表
            var ls_data = jdata.list;
            if (ls_data.length > 0) {
                alert("用户搜索成功");
                var cnt = 0;
                console.log(ls_data);
                var activity_list_html = '<thead>\n' +
                    '        <tr>\n' +
                    '            <th>标题</th>\n' +
                    '            <th>发布者姓名</th>\n' +
                    '            <th>所属学院</th>\n' +
                    '            <th>是否置顶</th>\n' +
                    '            <th>是否精华</th>\n' +
                    '            <th>操作</th>\n' +
                    '        </thead>\n';
                ls_data.map(function (item, index) {
                    activity_list_html += '        <tbody>\n' +
                        '        <tr>\n' +
                        '            <td>' + item.aTitle + '</td>\n' +
                        '            <td>' + item.aUserName + '</td>\n' +
                        '            <td>' + item.aColleges + '</td>\n' +
                        '            <td>' + item.isSticky + '</td>\n' +
                        '            <td>' + item.isEssence + '</td>\n' +
                        '            <td class="td-manage">\n' +
                        '                <a title="编辑" onClick=\'javascript:window.open("/UpdateActivityServlet?id=' + item.aId + '","","width=400,height=270,top=400,left=600,toolbar=no, status=no, menubar=no, resizable=no, scrollbars=no");return false;\'>\n' +
                        '                    <i class="layui-icon">&#xe642;</i>\n' +
                        '                </a>\n' +
                        '                <a href="/OptActivityHttpServlet?id=' + item.aId + '&opt=delete" onclick="delActivity(this)">\n' +
                        '                    <i class="layui-icon">&#xe640;</i>\n' +
                        '                </a>\n' +
                        '            </td>\n' +
                        '        </tr>\n' +
                        '        </tbody>'
                })
                $('#activityList').html(activity_list_html);

                // 显示用户数据数量
                console.log("cnt = " + cnt);
                var activity_count_html = '共有数据：' + cnt + ' 条';
                $('#activityCount').html(activity_count_html);
            }
            else {
                alert("查无此人");
            }
        }
    })
})