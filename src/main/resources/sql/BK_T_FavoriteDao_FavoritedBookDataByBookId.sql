/* BK_T_FavoriteDao_FavoritedBookDataByBookId.sql */

-- BOOK_IDは現在固定

select
  F.MEM_ID,
  book_db.M_MEM_BASIC.MEM_NAME
from
  book_db.BK_T_FAVORITE F
join
  book_db.M_MEM_BASIC on F.MEM_ID = book_db.M_MEM_BASIC.MEM_ID
where
  F.BOOK_ID = 6
;