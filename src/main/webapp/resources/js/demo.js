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
});