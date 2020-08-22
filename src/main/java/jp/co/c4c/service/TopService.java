package jp.co.c4c.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import jp.co.c4c.controller.form.TopForm;
import jp.co.c4c.db.dao.TopDao;

@Component
public class TopService {

    @Autowired
    private TopDao topDao;

    @Transactional
    public List<TopForm> getAllBooks() {
        return topDao.seletctAllBooks();
    }

}
