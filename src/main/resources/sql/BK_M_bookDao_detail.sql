/* BK_M_BookDao_top.sql */
select

-- 本マスタ
  BK_M_BOOK.BOOK_ID,
  BK_M_BOOK.TITLE,
  BK_M_BOOK.AUTHOR,
  BK_M_BOOK.TAG_IDS,
  BK_M_BOOK.OUTLINE,
  BK_M_BOOK.BOOK_IMG,
  BK_M_BOOK.OFFER_MEM_ID,
  BK_M_BOOK.OFFER_MEM_COMMENT,

-- 貸出テーブル
  BK_T_LEND.LEND_ID,
  BK_T_LEND.MEM_ID as L_MEN_ID,
  BK_T_LEND.LEND_STATUS,
  BK_T_LEND.FROM_DATE,
  BK_T_LEND.TO_DATE,
  BK_T_LEND.REVIEW,

-- おすすめテーブル
  BK_T_RECOM.RECOM_ID,
  BK_T_RECOM.FROM_MEM_ID,
  BK_T_RECOM.TO_MEM_ID,

-- お気に入りテーブル
  BK_T_FAVORITE.MEM_ID as F_MEN_ID

from
  book_db.BK_M_BOOK

  join book_db.BK_T_LEND
  on BK_M_BOOK.BOOK_ID = BK_T_LEND.BOOK_ID
  join book_db.BK_T_RECOM
  on BK_M_BOOK.BOOK_ID = BK_T_RECOM.BOOK_ID
  join book_db.BK_T_FAVORITE
  on BK_M_BOOK.BOOK_ID = BK_T_FAVORITE.BOOK_ID

where
  BK_M_BOOK.DEL_FLG = 0;
