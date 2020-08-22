package jp.co.c4c.db.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jp.co.c4c.db.dto.V_TopAndDetailDto;
import jp.sf.amateras.mirage.ClasspathSqlResource;
import jp.sf.amateras.mirage.SqlManager;
import jp.sf.amateras.mirage.SqlResource;
import jp.sf.amateras.mirage.StringSqlResource;

@Component
public class TopDao {

    @Autowired
    public SqlManager sqlManager;

    public List<V_TopAndDetailDto> seletctAllBooks() {
        final SqlResource sqlSrc = new ClasspathSqlResource("sql/" + "GetAllBooks.sql");
        System.out.print("Daoが接続されたよ");

        return sqlManager.getResultList(V_TopAndDetailDto.class, sqlSrc);
    }
}
