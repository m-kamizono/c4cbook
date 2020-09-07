package jp.co.c4c.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import jp.co.c4c.db.dao.InsertLendBookDao;
import jp.co.c4c.db.dao.SelectBookDataDao;
import jp.co.c4c.db.dao.SelectFavoriteMembersDao;
import jp.co.c4c.db.dao.SelectLendHistorysDao;
import jp.co.c4c.db.dto.BK_T_LendDto;
import jp.co.c4c.db.dto.V_FavoriteMemberDto;
import jp.co.c4c.db.dto.V_LendHistoryDto;
import jp.co.c4c.db.dto.V_TopAndDetailDto;

@Component
public class DetailService {

    @Autowired
    private SelectBookDataDao SelectBookDataDao;
    private SelectLendHistorysDao SelectLendHistorysDao;
    private SelectFavoriteMembersDao SelectFavoriteMembersDao;
    private InsertLendBookDao InsertLendBookDao;

    /**
     * 詳細ページに表示させる本を取得
     * @param bookId
     * @return
     */
    @Transactional
    public V_TopAndDetailDto getBookById(int bookId) {
        return SelectBookDataDao.seletctBookById(bookId);
    }

    /**
     * 詳細ページに表示させる貸出履歴を取得
     * @param bookId
     * @return
     */
    @Transactional
    public List<V_LendHistoryDto> getLendHistorysById(int bookId) {
        return SelectLendHistorysDao.seletctLendHistorysById(bookId);
    }

    /**
     * 詳細ページに表示させるお気に入りした人を取得
     * @param bookId
     * @return
     */
    @Transactional
    public List<V_FavoriteMemberDto> getFavoriteMembersById(int bookId) {
        return SelectFavoriteMembersDao.seletctFavoriteMembersById(bookId);
    }

    @Transactional
    public void saveLendBook(BK_T_LendDto bk_T_LendDto) {
        InsertLendBookDao.insertLendBook(bk_T_LendDto);
    }

}
