package cn.edu.tongji.easygo.service;

import org.springframework.web.multipart.MultipartFile;

public interface OssService {
    public String uploadFilePic(MultipartFile file);
}
