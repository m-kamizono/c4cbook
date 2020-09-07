/* BK_T_RecomeDao_RecomeBookByBookId.sql */
-- bookIdは現在固定

select
    book_db.BK_T_RECOM.RECOM_DATE,
    book_db.M_MEM_BASIC.MEM_NAME
from
    book_db.BK_T_RECOM join book_db.M_MEM_BASIC
        on book_db.BK_T_RECOM.FROM_MEM_ID = book_db.M_MEM_BASIC.MEM_ID
where
    BOOK_ID = 2
order by
    book_db.BK_T_RECOM.RECOM_DATE desc
;
