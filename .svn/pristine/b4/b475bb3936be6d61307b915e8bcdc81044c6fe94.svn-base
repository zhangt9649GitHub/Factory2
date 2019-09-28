package com.mingyuansoftware.aifactory.service.impl;

import com.mingyuansoftware.aifactory.mapper.StyleBookMapper;
import com.mingyuansoftware.aifactory.model.StyleBook;
import com.mingyuansoftware.aifactory.model.dto.StyleBookDto;
import com.mingyuansoftware.aifactory.service.StyleBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @author 张婷
 * @date 2019/7/4 10:08
 */

@Service
public class StyleBookServiceImpl implements StyleBookService {

    @Autowired
    private StyleBookMapper styleBookMapper;

    @Override
    public List<StyleBook> getStyleBookList(StyleBookDto styleBookDto) {
        try {
            return styleBookMapper.selectStyleBookList(styleBookDto);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int selectCount(StyleBookDto styleBookDto) {
        try {
            return styleBookMapper.selectCount(styleBookDto);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public int insertStyleBook(StyleBook styleBook) {
        styleBook.setIsDelete((byte) 0);
        styleBook.setCreateTime(new Date());
        return styleBookMapper.insert(styleBook);
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteStyleBookById(int styleBookId) {
        return styleBookMapper.deleteStyleBookById(styleBookId);
    }


    @Override
    public StyleBook selectStyleBookById(int styleBookId) {
        try {
            return styleBookMapper.selectStyleBookById(styleBookId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public int updateStyleBook(StyleBook styleBook) {
        styleBook.setIsDelete((byte) 0);
        styleBook.setUpdateTime(new Date());
        return styleBookMapper.updateByPrimaryKey(styleBook);
    }
}
