package jp.co.c4c.db.dao;

import jp.co.c4c.db.dto.BK_M_BookDto;
import jp.sf.amateras.mirage.ClasspathSqlResource;
import jp.sf.amateras.mirage.SqlManager;
import jp.sf.amateras.mirage.SqlResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author takayukiyamaoka
 *
 */
@Component
public class InsertBookDao {

    @Autowired
    public SqlManager sqlManager;

    public void insertBook(BK_M_BookDto bk_m_bookDto) {
        final SqlResource sqlSrc = new ClasspathSqlResource("sql/" + "BK_M_BookDto_InsertBook.sql");
        Map<String, Object> param = new HashMap<>();
        Date date = new Date();
        param.put("title", bk_m_bookDto.getTitle());
        param.put("titleKana", bk_m_bookDto.getTitleKana());
        param.put("author", bk_m_bookDto.getAuthor());
        param.put("authorKana", bk_m_bookDto.getAuthorKana());
        param.put("tagIds", bk_m_bookDto.getTagIds());
        param.put("outline", bk_m_bookDto.getOutline());
        param.put("bookImg", bk_m_bookDto.getBookImg());
        param.put("offerMemId", 1);
        param.put("offerMemComment", bk_m_bookDto.getOfferMemComment());
        param.put("offerDate", date);
        param.put("delFlg", 0);
        param.put("createdAt", date);
        param.put("updateAt", date);
        sqlManager.executeUpdate(sqlSrc, param);
    }

}
