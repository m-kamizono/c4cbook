$(document).ready(function() {

    getBookList();
    function getBookList() {
        $.ajax({
            url: 'api/demo',
            type: 'get',
            success: function(response) {
                console.log(response.dataList);
            },
            error: function() {
            }
        });
    }

    $(".checkbox").on("click", function(){
        $('.checkbox').prop('checked', false);  //  全部のチェックを外す
        $(this).prop('checked', true);  //  押したやつだけチェックつける
    });
});