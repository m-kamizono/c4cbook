/* BK_T_NewsReadDao_update.sql */

-- MEM_IDは現在固定

update
    book_db.BK_T_NEWS_READ
set
    READ_AT = now()
where
    MEM_ID = 1
;