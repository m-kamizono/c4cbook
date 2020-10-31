package jp.co.c4c.db.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jp.co.c4c.db.dto.V_LendHistoryDto;
import jp.co.c4c.db.dto.V_MyLendHistoryDto;
import jp.sf.amateras.mirage.ClasspathSqlResource;
import jp.sf.amateras.mirage.SqlManager;
import jp.sf.amateras.mirage.SqlResource;

/**
 * @author takayukiyamaoka
 *
 */
@Component
public class SelectMyLendHistorysDao {

    @Autowired
    public SqlManager sqlManager;

    /**
     * ログインユーザーが読書済みのリストを取得
     * @param memId
     * @return
     */
    public List<V_LendHistoryDto> seletctLendHistorysByMemId(int memId) {
        final SqlResource sqlSrc = new ClasspathSqlResource("sql/" + "BK_T_LendDao_LendedBookDataByMemberId.sql");
        Map<String, Object> param = new HashMap<>();
        param.put("memId", memId);
        return sqlManager.getResultList(V_LendHistoryDto.class, sqlSrc, param);
    }

    /**
     * マイページに表示させる予約・貸出履歴のリストを取得
     * @param memId
     * @return
     */
    public List<V_MyLendHistoryDto> seletctBooksByMemId(int memId) {
        final SqlResource sqlSrc = new ClasspathSqlResource("sql/" + "BK_T_SelectBookDao_BookDataByMemberId.sql");
        Map<String, Object> param = new HashMap<>();
        param.put("memId", memId);
        return sqlManager.getResultList(V_MyLendHistoryDto.class, sqlSrc, param);
    }

}