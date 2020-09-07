package jp.co.c4c.db.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jp.co.c4c.db.dto.V_TopAndDetailDto;
import jp.sf.amateras.mirage.ClasspathSqlResource;
import jp.sf.amateras.mirage.SqlManager;
import jp.sf.amateras.mirage.SqlResource;

@Component
public class SelectBookListDao {

    @Autowired
    public SqlManager sqlManager;

    /**
     * トップページに表示させる本リストのデータを取得
     * @return
     */
    public List<V_TopAndDetailDto> seletctAllBooks() {
        final SqlResource sqlSrc = new ClasspathSqlResource("sql/" + "BK_T_TopDao_getAllBooks.sql");
        System.out.print("Daoが接続されたよ");

        return sqlManager.getResultList(V_TopAndDetailDto.class, sqlSrc);
    }
}
