$(function () {
    $('#addSubmitBtn').click(function () {
        var id = $('#updateId').val();
        var email = $('#updateEmail').val();
        var pwd = $('#updatePassword').val();
        var name = $('#updateName').val();
        console.log(id); console.log(email); console.log(pwd); console.log(name);
        $.ajax({
            url: '/OptAdminHttpServlet',
            type: 'post',
            data: {
                id: id,
                email: email,
                pwd: pwd,
                name: name,
                opt: 'update'
            },
            dataType: 'text',
            success:function (data) {
                if (data='true'){
                    alert('修改成功');
                    window.opener.location.reload();
                    window.close();
                } else {
                    alert('修改失败');
                }
            }
        })
    })
})