package com.mingyuansoftware.aifactory.mapper;

import com.mingyuansoftware.aifactory.model.StyleBook;
import com.mingyuansoftware.aifactory.model.dto.StyleBookDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface StyleBookMapper {
    int deleteByPrimaryKey(Integer styleBookId);

    int insert(StyleBook record);

    StyleBook selectByPrimaryKey(Integer styleBookId);

    List<StyleBook> selectAll();

    int updateByPrimaryKey(StyleBook record);

    /**
     * 获取式样书列表
     * @return
     */
    List<StyleBook> selectStyleBookList(@Param("styleBookDto") StyleBookDto styleBookDto);

    /**
     * 获取式样书总条数
     * @return
     */
    int selectCount(@Param("styleBookDto") StyleBookDto styleBookDto);

    /**
     * 根据式样书id逻辑删除式样书(设置字段is_delete为1)
     * @param styleBookById
     * @return
     */
    int deleteStyleBookById(@Param("styleBookId") int styleBookById);

    /**
     * 根据id查询式样书信息
     * @param styleBookId
     * @return
     */
    StyleBook selectStyleBookById(@Param("styleBookId") int styleBookId);
}