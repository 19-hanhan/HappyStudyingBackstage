$(function () {
    $('#addSubmitBtn').click(function () {
        var id = $('#addId').val();
        var name = $('#addName').val();
        var sex = $('#addsex').val();
        var college = $('#addCollege').val();
        var title = $('#addTitle').val();
        $.ajax({
            url: '/AddTeacherHttpServlet',
            type: 'post',
            data: {
                id: id,
                name: name,
                sex: sex,
                college: college,
                title: title
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