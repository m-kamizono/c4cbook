package jp.co.c4c.service;

import jp.co.c4c.db.dao.InsertBookDao;
import jp.co.c4c.db.dto.BK_M_BookDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class RegisterService {
    @Autowired
    InsertBookDao insertBookDao;

    @Transactional
    public void regBook(BK_M_BookDto bk_m_bookDto) {
        insertBookDao.insertBook(bk_m_bookDto);
    }
}
