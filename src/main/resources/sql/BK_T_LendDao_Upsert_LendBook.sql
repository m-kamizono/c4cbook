/* BK_T_LendDao_Upsert_LendBook.sql */

insert into book_db.BK_T_LEND
(
    BOOK_ID,
    MEM_ID,
    LEND_STATUS,
    FROM_DATE,
    TO_DATE,
    REVIEW,
    DEL_FLG,
    CREATE_AT,
    UPDATE_AT
)
values
(
    bookId,
    mId,
    lstatus,
    fromDate,
    toDate,
    review,
    delFlg,
    createAt,
    updateAt
)
on DUPLICATE key update LEND_STATUS = status, FROM_DATE = fromDate, TO_DATE = toDate, DEL_FLG = delFlg, UPDATE_AT = updateAt
;