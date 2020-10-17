$(document).ready(function () {
    getBookList();
    let dataList;

    // 非同期でbookListを取得
    function getBookList() {
        $.ajax({
            url: 'api/demo',
            type: 'get',
            success: function (response) {
                dataList = response.dataList;
                console.log(dataList);
                for (let i = 0; i < dataList.length; i++) {
                    $('#bookList').append(`
                        <ul>
                            <li>ID：${dataList[i]["bookId"]}</li>
                            <li>タイトル：${dataList[i]["title"]}</li>
                            <li>著者${dataList[i]["author"]}</li>
                            <li>読まれた回数：${dataList[i]["lendCount"]}</li>
                            <li>お気に入り回数：${dataList[i]["favCount"]}</li>
                            <li>タグ：${dataList[i]["tagIds"]}</li>
                        </ul>
                    `);
                }
            },
            error: function () {
            }
        });
    }

    // チェックボックスの選択制御
    $('.checkbox').on("click", function () {
        $('.checkbox').prop('checked', false);  //  全部のチェックを外す
        $(this).prop('checked', true);  //  押したやつだけチェックつける
    });

    let sortCond;
    $('input[name="param"]').on('change', function () {
        sortCond = $(this).val();
        console.log(sortCond);
    });

    // 並び替えの処理
    $(document).on("click", '#sorting', function () {
        console.log("clicked")
        let sortedList = null;
        // あいうえお順
        if (sortCond === "1") {
            sortedList = getSortedListKana(dataList);
            // お気に入り数順
        } else if (sortCond === "2") {
            sortedList = getSortedListFav(dataList);
            // 読まれた回数順
        } else if (sortCond === "3") {
            sortedList = getSortedListLend(dataList);
        }

        if (sortedList !== null) {
            $(`#bookList`).children().remove();
            for (let i = 0; i < sortedList.length; i++) {
                $('#bookList').append(`
                            <ul>
                                <li>ID：${sortedList[i]["bookId"]}</li>
                                <li>タイトル：${sortedList[i]["title"]}</li>
                                <li>著者${sortedList[i]["author"]}</li>
                                <li>読まれた回数：${sortedList[i]["lendCount"]}</li>
                                <li>お気に入り回数：${sortedList[i]["favCount"]}</li>
                                <li>タグ：${sortedList[i]["tagIds"]}</li>
                            </ul>
                        `);
            }
        }

        function getSortedListKana(list) {
            let sortedList = list.sort(function (a, b) {
                if (a.titleKana < b.titleKana) return -1;
                if (a.titleKana > b.titleKana) return 1;
                return 0;
            });
            console.log(list)
            return sortedList;
        }

        function getSortedListFav(list) {
            let sortedList = list.sort(function (a, b) {
                if (a.favCount > b.favCount) return -1;
                if (a.favCount < b.favCount) return 1;
                return 0;
            });
            console.log(list)
            return sortedList;
        }

        function getSortedListLend(list) {
            let sortedList = list.sort(function (a, b) {
                if (a.lendCount > b.lendCount) return -1;
                if (a.lendCount < b.lendCount) return 1;
                return 0;
            });
            return sortedList;
        }

    });

    // サンプル2 HTMLの要素から値を取得して並び替え
    let sortCond2;
    $('input[name="param2"]').on('change', function () {
        sortCond = $(this).val();
        console.log(sortCond);
    });
    $(document).on("click", "#sorting2", function () {
        let ids = $('#content').find('li[name="id"]').text();
        let result1 = ids.split("ID：").splice(1, ids.length - 1);
        console.log(result1);

        let productName = $('#content').find('li[name="productName"]').text();
        let result2 = productName.split("品名：").splice(1, productName.length - 1);
        console.log(result2);

        let data = [];
        for (let i = 0; i < result1.length; i++) {
            let tmpData = {};
            tmpData.id = result1[i];
            tmpData.productName = result2[i];
            data.unshift(tmpData);
        }
        console.log(data);

        $(document).on("click", '#sorting2', function () {
            console.log("clicked")
            let sortedList = null;
            // ID順
            if (sortCond === "1") {
                sortedList = getSortedListId(data);
                // 品名順
            } else if (sortCond === "2") {
                sortedList = getSortedListProName(data);
            }

            if (sortedList !== null) {
                $(`#content`).children().remove();
                for (let i = 0; i < sortedList.length; i++) {
                    $('#content').append(`
                            <ul>
                                <li name="id">ID：${sortedList[i].id}</li>
                                <li name="productName">品名：${sortedList[i].productName}</li>
                            </ul>
                        `);
                }
            }

            function getSortedListId(list) {
                let sortedList = list.sort(function (a, b) {
                    if (a.id < b.id) return -1;
                    if (a.id > b.id) return 1;
                    return 0;
                });
                console.log(list)
                return sortedList;
            }

            function getSortedListProName(list) {
                let sortedList = list.sort(function (a, b) {
                    if (a.productName < b.productName) return -1;
                    if (a.productName > b.productName) return 1;
                    return 0;
                });
                console.log(list)
                return sortedList;
            }
        });


    });


});