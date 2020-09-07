package jp.co.c4c.db.dao;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jp.co.c4c.db.dto.BK_T_LendDto;
import jp.sf.amateras.mirage.ClasspathSqlResource;
import jp.sf.amateras.mirage.SqlManager;
import jp.sf.amateras.mirage.SqlResource;

/**
 * @author takayukiyamaoka
 *
 */
@Component
public class InsertLendBookDao {

    @Autowired
    public SqlManager sqlManager;

    /**
     * 貸出・予約手続き　データ登録
     * @param bk_T_LendDto
     */
    public void insertLendBook(BK_T_LendDto bk_T_LendDto) {
        final SqlResource sqlSrc = new ClasspathSqlResource("sql/" + "BK_T_LendDao_Submit_LendBook.sql");
        Map<String, Object> param = new HashMap<>();
        Date date = new Date();
        param.put("bookId", bk_T_LendDto.getBookId());
        param.put("mId", bk_T_LendDto.getMemId());
        param.put("lstatus", bk_T_LendDto.getLendStatus());
        param.put("fromDate", bk_T_LendDto.getFromDate());
        param.put("toDate", bk_T_LendDto.getToDate());
        param.put("delFlg", 0);
        param.put("createAt", date);
        param.put("updateAt", date);
        sqlManager.executeUpdate(sqlSrc, param);
    }

}
