/* BK_T_FavoriteDao_Submit_MyFavoriteBook.sql */

-- value以降はすべてパラメータが必要

insert into book_db.BK_T_FAVORITE
   (
    BOOK_ID,
    MEM_ID,
    DEL_FLG,
    CREATE_AT,
    UPDATE_AT
   )
values
   (
    bookId,
    mId,
    delFlg,
    createAt,
    updateAt
   )
on DUPLICATE key update
   DEL_FLG = delFlg,
   UPDATE_AT = updateAt;
;