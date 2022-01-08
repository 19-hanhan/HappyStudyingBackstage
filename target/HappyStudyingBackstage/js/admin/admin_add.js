$(function () {
    $('#addSubmitBtn').click(function () {
        var email = $('#addEmail').val();
        var pwd = $('#addPassword').val();
        var name = $('#addName').val();
        $.ajax({
            url: '/AddAdminHttpServlet',
            type: 'post',
            data: {
                email: email,
                pwd: pwd,
                name: name
            },
            dataType: 'text',
            success:function (data) {
                if (data='true'){
                    alert('添加成功');
                    window.opener.location.reload();
                    window.close();
                } else {
                    alert('添加失败');
                }
            }
        })
    })
})