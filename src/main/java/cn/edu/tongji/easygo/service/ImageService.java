package cn.edu.tongji.easygo.service;

import java.util.List;

public interface ImageService {

    boolean addImage(Long informationId, String imageUrl, int i);

    List<String> showImages(Long id, Integer type);

    boolean deleteImages(Long id, Integer type);
}