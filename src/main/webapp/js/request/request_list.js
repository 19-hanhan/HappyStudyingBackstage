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
            url: '/ExportRequestListHttpServlet',
            type: 'post',
            dataType: 'json',
            contentType: "application/json; charset=utf-8",
            success: function (data) {
                console.log(data);

                // 1. 如果需要调整顺序，请执行梳理函数
                var dt = excel.filterExportData(data, [
                    'a_id',
                    'a_name',
                    'a_email',
                    'is_post',
                    'u_no',
                    'u_avatar',
                    'u_sub_divsion',
                    'u_diamond_number'
                ]);

                // 2. 数组头部新增表头
                dt.unshift({
                    a_id: 'ID',
                    a_name: '姓名',
                    a_email: '邮箱',
                    is_post: '职位',
                    u_no: '工号、学号',
                    u_avatar: '用户头像',
                    u_sub_divsion: '用户权限',
                    u_diamond_number: '钻石数'
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
                }, '用户数据.xlsx', 'xlsx', {
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
                    window.location.href = '/home/request_list';
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
    url: '/request_list.do',
    data: {},
    dataType: 'json',
    type: 'get',
    success: function (jdata) {
        // 显示用户数据数量
        var cnt = jdata.count;
        console.log("cnt = " + cnt);
        var request_count_html = '共有数据：' + cnt + ' 条';
        $('#requestCount').html(request_count_html);

        // 显示管理员列表
        var ls_data = jdata.list;
        if (ls_data.length > 0) {
            console.log(ls_data);
            var request_list_html = '<thead>\n' +
                '        <tr>\n' +
                '            <th>ID</th>\n' +
                '            <th>活动ID</th>\n' +
                '            <th>申请时间</th>\n' +
                '            <th>申请原因</th>\n' +
                '            <th>操作</th>\n' +
                '        </thead>\n';
            ls_data.map(function (item, index) {
                request_list_html += '        <tbody>\n' +
                    '        <tr>\n' +
                    '            <td>' + item.tId + '</td>\n' +
                    '            <td>' + item.tActivityId + '</td>\n' +
                    '            <td>' + item.tRequestTime + '</td>\n' +
                    '            <td>' + item.tWhy + '</td>\n' +
                    '            <td class="td-manage">\n' +
                    '                <a title="编辑" href="/PassRequestHttpServlet?id=' + item.tId + '&activityId=' + item.tActivityId + '" onclick="passRequest(this)">\n' +
                    '                    <i class="layui-icon layui-icon-ok"></i>\n' +
                    '                </a>\n' +
                    '                <a href="/OptRequestHttpServlet?id=' + item.tId + '&opt=delete" onclick="delRequest(this)">\n' +
                    '                    <i class="layui-icon">&#xe640;</i>\n' +
                    '                </a>\n' +
                    '            </td>\n' +
                    '        </tr>\n' +
                    '        </tbody>'
            })
            $('#requestList').html(request_list_html);
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
function delRequest(obj) {
    var statu = confirm("确认要删除该用户信息吗?");
    if (!statu) {
        return false;
    }
    else return true;
}
// 通过
function passRequest(obj) {
    var statu = confirm("你确认要通过该条用户的活动请求吗?");
    if (!statu) {
        return false;
    }
    else return true;
}

// $("#searchBtn").click(function () {
//     var key = $("#findByName").val();
//     console.log(key);
//     $.ajax({
//         url: '/FindRequestHttpServlet',
//         type: 'post',
//         data: {key: key},
//         dataType: 'json',
//         success: function (jdata) {
//
//             // 显示管理员列表
//             var ls_data = jdata.list;
//             if (ls_data.length > 0) {
//                 alert("用户搜索成功");
//                 var cnt = 0;
//                 console.log("ininininini");
//                 console.log(ls_data);
//                 var request_list_html = '<thead>\n' +
//                     '        <tr>\n' +
//                     '            <th>ID</th>\n' +
//                     '            <th>活动ID</th>\n' +
//                     '            <th>申请时间</th>\n' +
//                     '            <th>申请原因</th>\n' +
//                     '            <th>操作</th>\n' +
//                     '        </thead>\n';
//                 ls_data.map(function (item, index) {
//                     request_list_html += '        <tbody>\n' +
//                         '        <tr>\n' +
//                         '            <td>' + item.t_id + '</td>\n' +
//                         '            <td>' + item.t_activity_id + '</td>\n' +
//                         '            <td>' + item.t_request_time + '</td>\n' +
//                         '            <td>' + item.t_why + '</td>\n' +
//                         '            <td class="td-manage">\n' +
//                         '                <a href="/OptRequestHttpServlet?id=' + item.tId + '&opt=delete" onclick="delRequest(this)">\n' +
//                         '                    <i class="layui-icon">&#xe640;</i>\n' +
//                         '                </a>\n' +
//                         '            </td>\n' +
//                         '        </tr>\n' +
//                         '        </tbody>'
//                 })
//                 $('#requestList').html(request_list_html);
//
//                 // 显示用户数据数量
//                 console.log("cnt = " + cnt);
//                 var request_count_html = '共有数据：' + cnt + ' 条';
//                 $('#requestCount').html(request_count_html);
//             }
//             else {
//                 alert("查无此人");
//             }
//         }
//     })
// })