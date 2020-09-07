package jp.co.c4c.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import jp.co.c4c.db.dao.SelectBookListDao;
import jp.co.c4c.db.dto.V_TopAndDetailDto;

@Component
public class TopService {

    @Autowired
    private SelectBookListDao topDao;

    /**
     * トップページに表示させる本のリストを取得
     * @return
     */
    @Transactional
    public List<V_TopAndDetailDto> getAllBooks() {
        return topDao.seletctAllBooks();
    }



}
