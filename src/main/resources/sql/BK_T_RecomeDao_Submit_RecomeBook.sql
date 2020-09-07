/* BK_T_RecomeDao_Submit_RecomeBook.sql */

insert into book_db.BK_T_RECOM
(
    BOOK_ID,
    FROM_MEM_ID,
    TO_MEM_ID,
    RECOM_DATE,
    DEL_FLG,
    CREATE_AT,
    UPDATE_AT
)
values
(
    bookId,
    fMId,
    tMId,
    recomeDate,
    delFlg,
    createAt,
    updateAt
)
;