package com.mingyuansoftware.aifactory.mapper;

import com.mingyuansoftware.aifactory.model.UploadFiles;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface UploadFilesMapper {


    int deleteByPrimaryKey(Integer ufId);


    int insert(UploadFiles record);


    UploadFiles selectByPrimaryKey(Integer ufId);


    List<UploadFiles> selectAll();


    int updateByPrimaryKey(UploadFiles record);

    /**
     * 获取刚刚插入的记录id
     * @return
     */
    Integer selectLastInsertId();
}