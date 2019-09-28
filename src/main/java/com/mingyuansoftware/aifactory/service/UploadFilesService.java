package com.mingyuansoftware.aifactory.service;

import com.mingyuansoftware.aifactory.model.UploadFiles;
import org.springframework.stereotype.Service;

@Service
public interface UploadFilesService {
    /**
     * 上传图片
     * @param uploadFiles
     */
    Integer insert(UploadFiles uploadFiles);

}
