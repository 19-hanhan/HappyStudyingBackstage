$(function () {
    $('#addSubmitBtn').click(function () {
        var id = $('#addId').val();
        var name = $('#addName').val();
        var sex = $('#addsex').val();
        var college = $('#addCollege').val();
        var sClass = $('#addSClass').val();
        $.ajax({
            url: '/AddStudentHttpServlet',
            type: 'post',
            data: {
                id: id,
                name: name,
                sex: sex,
                college: college,
                sClass: sClass
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