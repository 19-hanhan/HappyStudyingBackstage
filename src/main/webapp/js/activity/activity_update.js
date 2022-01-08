$(function () {
    $('#addSubmitBtn').click(function () {
        var id = $('#updateId').val();
        var title = $('#updateTitle').val();
        var name = $('#updateName').val();
        var college = $('#updateCollege').val();
        var sticky = $('#updateSticky').val();
        var essence = $('#updateEssence').val();
        console.log(id);
        $.ajax({
            url: '/OptActivityHttpServlet',
            type: 'post',
            data: {
                id: id,
                title: title,
                name: name,
                college: college,
                sticky: sticky,
                essence: essence,
                opt: 'update'
            },
            dataType: 'text',
            success:function (data) {
                // if (data='true'){
                    alert('修改成功');
                    window.opener.location.reload();
                    window.close();
                // } else {
                //     alert('修改失败');
                // }
            }
        })
    })
})