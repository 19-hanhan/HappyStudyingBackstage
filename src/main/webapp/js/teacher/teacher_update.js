$(function () {
    $('#addSubmitBtn').click(function () {
        var id = $('#updateId').val();
        var name = $('#updateName').val();
        var sex = $('#updateSex').val();
        var college = $('#updateCollege').val();
        var title = $('#updateTitle').val();
        console.log(id);
        $.ajax({
            url: '/OptTeacherHttpServlet',
            type: 'post',
            data: {
                id: id,
                name: name,
                sex: sex,
                college: college,
                title: title,
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