package jp.co.c4c.db.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jp.co.c4c.db.dto.V_TopAndDetailDto;
import jp.sf.amateras.mirage.ClasspathSqlResource;
import jp.sf.amateras.mirage.SqlManager;
import jp.sf.amateras.mirage.SqlResource;

/**
 * @author takayukiyamaoka
 *
 */
@Component
public class SelectBookDataDao {

    @Autowired
    public SqlManager sqlManager;

    /**
     * 詳細ページに表示させる本のデータを取得
     * @param bookId
     * @return
     */
    public V_TopAndDetailDto seletctBookById(int bookId) {
        final SqlResource sqlSrc = new ClasspathSqlResource("sql/" + "BK_T_DitailDao_BookDataByBookId.sql");
        System.out.print("Daoが接続されたよ");
        Map<String, Object> param = new HashMap<>();
        param.put("bookId", bookId);

        return sqlManager.getSingleResult(V_TopAndDetailDto.class, sqlSrc, param);
    }

}
