package jp.co.c4c.controller.form;

import java.util.Date;
import java.util.List;

import jp.co.c4c.db.dto.BK_T_LendDto;
import jp.co.c4c.db.dto.BK_T_RecomDto;
import jp.co.c4c.db.dto.BK_T_RequestDto;
import jp.co.c4c.db.dto.V_MyLendHistoryDto;
import jp.co.c4c.db.dto.V_TopAndDetailDto;

/**
 * トップ画面 Formクラス
 */
public class TopForm {

    List<V_TopAndDetailDto> topAndDetailDtoList;
    Date readTime;
    List<Integer> myFavoriteBookIdList;
    List<Integer> myLendedBookIdList;
    List<BK_T_LendDto> lendNewsList;
    List<V_MyLendHistoryDto> myLendingBookList;
    List<V_TopAndDetailDto> offerBookNewsList;
    List<BK_T_RequestDto> requestBookNewsList;
    List<BK_T_RecomDto> recomeBookNewsList;

    public List<V_TopAndDetailDto> getTopAndDetailDtoList() {
        return topAndDetailDtoList;
    }

    public void setTopAndDetailDtoList(List<V_TopAndDetailDto> topAndDetailDtoList) {
        this.topAndDetailDtoList = topAndDetailDtoList;
    }

    public List<Integer> getMyFavoriteBookIdList() {
        return myFavoriteBookIdList;
    }

    public void setMyFavoriteBookIdList(List<Integer> myFavoriteBookIdList) {
        this.myFavoriteBookIdList = myFavoriteBookIdList;
    }

    public List<Integer> getMyLendedBookIdList() {
        return myLendedBookIdList;
    }

    public void setMyLendedBookIdList(List<Integer> myLendedBookIdList) {
        this.myLendedBookIdList = myLendedBookIdList;
    }

    // お知らせ既読更新日時取得
    public Date getReadTimeNews() {
        return readTime;
    }

    // お知らせ既読更新日時をformへセット
    public void setReadTimeNews(Date readTime) {
        this.readTime = readTime;
    }

    public List<BK_T_LendDto> getLendNewsList() {
        return lendNewsList;
    }

    public void setLendNewsList(List<BK_T_LendDto> lendNewsList) {
        this.lendNewsList = lendNewsList;
    }

    // 貸出数を取得
    public int getCountMyLendingBookList() {
        return lendNewsList.size();
    }

    public List<V_MyLendHistoryDto> getMyLendingBookList() {
        return myLendingBookList;
    }

    public void setMyLendingBookList(List<V_MyLendHistoryDto> myLendingBookList) {
        this.myLendingBookList = myLendingBookList;
    }

    // 新規入荷本のお知らせ情報をfromへセット
    public List<V_TopAndDetailDto> getOfferBookNewsList() {
        return offerBookNewsList;
    }

    public void setOfferBookNewsList(List<V_TopAndDetailDto> offerBookNewsList) {
        this.offerBookNewsList= offerBookNewsList;
    }

    // 要望承認のお知らせ情報をfromへセット
    public List<BK_T_RequestDto> getRequestBookNewsList() {
        return requestBookNewsList;
    }

    public void setRequestBookNewsList(List<BK_T_RequestDto> requestBookNewsList) {
        this.requestBookNewsList= requestBookNewsList;
    }

    // おすすめされたお知らせ情報をfromへセット
    public List<BK_T_RecomDto> getRecomeBookNewsList() {
        return recomeBookNewsList;
    }

    public void setRecomeBookNewsList(List<BK_T_RecomDto> recomeBookNewsList) {
        this.recomeBookNewsList= recomeBookNewsList;
    }

}