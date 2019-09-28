package com.mingyuansoftware.aifactory.service;

import com.mingyuansoftware.aifactory.model.StyleBook;
import com.mingyuansoftware.aifactory.model.dto.StyleBookDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StyleBookService {
    /**
     * 查询式样书列表
     * @return
     */
    List<StyleBook> getStyleBookList(StyleBookDto styleBookDto);

    /**
     * 获取式样书总条数
     * @param styleBookDto
     * @return
     */
    int selectCount(StyleBookDto styleBookDto);

    /**
     * 新增式样书
     * @param styleBook
     * @return
     */
    int insertStyleBook(StyleBook styleBook);

    /**
     * 逻辑删除式样书(设置字段is_delete为1)
     * @param styleBookId
     * @return
     */
    int deleteStyleBookById(int styleBookId);

    /**
     * 根据id查询式样书信息
     * @param styleBookId
     * @return
     */
    StyleBook selectStyleBookById(int styleBookId);

    /**
     * 更新式样书信息
     * @param styleBook
     * @return
     */
    int updateStyleBook(StyleBook styleBook);
}
