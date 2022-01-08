$(function () {
    $('#addSubmitBtn').click(function () {
        var id = $('#updateId').val();
        var name = $('#updateName').val();
        var email = $('#updateEmail').val();
        var pwd = $('#updatePassword').val();
        var post = $('#updatePost').val();
        var no = $('#updateNo').val();
        var subDivision = $('#updateSubDivision').val();
        var diamond = $('#updateDiamond').val();
        console.log(id); console.log(email); console.log(pwd); console.log(name);
        $.ajax({
            url: '/OptUserHttpServlet',
            type: 'post',
            data: {
                id: id,
                name: name,
                email: email,
                pwd: pwd,
                post: post,
                no: no,
                subDivision: subDivision,
                diamond: diamond,
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