package com.mingyuansoftware.aifactory.service.impl;

import com.mingyuansoftware.aifactory.mapper.UploadFilesMapper;
import com.mingyuansoftware.aifactory.model.UploadFiles;
import com.mingyuansoftware.aifactory.service.UploadFilesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UploadFilesServiceImpl implements UploadFilesService {

    @Autowired
    private UploadFilesMapper uploadFilesMapper;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public Integer insert(UploadFiles uploadFiles) {
        uploadFilesMapper.insert(uploadFiles);
        return uploadFiles.getUfId();

    }

}
