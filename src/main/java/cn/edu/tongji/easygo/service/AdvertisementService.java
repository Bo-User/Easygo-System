package cn.edu.tongji.easygo.service;

import cn.edu.tongji.easygo.model.Advertisement;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AdvertisementService {
    boolean addAdvertisement(Advertisement advertisement);

    List<Advertisement> showAllAdvertisement(int pageNum,int sizeNum);

    Advertisement showConcreteAdvertisement(Long advertisementId);

    boolean updateAdvertisement(Long advertisementId,Advertisement after);

    void deleteAdvertisement(Long advertisementId);

    List<Advertisement> showFrontAdvertisement();
}
