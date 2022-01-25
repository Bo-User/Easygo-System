package cn.edu.tongji.easygo.service.ServiceImpl;

import cn.edu.tongji.easygo.model.Advertisement;
import cn.edu.tongji.easygo.repository.AdvertisementRepository;
import cn.edu.tongji.easygo.service.AdvertisementService;
import cn.edu.tongji.easygo.util.JpaUtil;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AdvertisementServiceImpl implements AdvertisementService {
    @Resource
    AdvertisementRepository advertisementRepository;

    @Override
    public boolean addAdvertisement(Advertisement advertisement) {
        advertisementRepository.save(advertisement);
        return true;
    }

    @Override
    public List<Advertisement> showAllAdvertisement(int pageNum,int sizeNum) {
        Pageable page = PageRequest.of(pageNum,sizeNum);
        Page<Advertisement> advertisements = advertisementRepository.findAll(page);
        return advertisements.getContent();
    }

    @Override
    public Advertisement showConcreteAdvertisement(Long advertisementId) {
        return advertisementRepository.findByAdvertisementId(advertisementId);
    }

    @Override
    public boolean updateAdvertisement(Long advertisementId, Advertisement after) {
        Advertisement before = advertisementRepository.findByAdvertisementId(advertisementId);
        JpaUtil.copyNotNullProperties(after, before);
        advertisementRepository.save(before);
        return true;
    }

    @Override
    public void deleteAdvertisement(Long advertisementId) {
        advertisementRepository.deleteAdvertisementByAdvertisementId(advertisementId);
    }

    @Cacheable(value="index",key="'frontAdvertisements'")
    @Override
    public List<Advertisement> showFrontAdvertisement() {
        List<Advertisement> advertisements = advertisementRepository.findAdvertisementsByAdvertisementState(1);
        return advertisements;
    }
}
