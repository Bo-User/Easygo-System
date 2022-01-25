package cn.edu.tongji.easygo.repository;

import cn.edu.tongji.easygo.model.Advertisement;
import cn.edu.tongji.easygo.service.AdvertisementService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface AdvertisementRepository extends JpaRepository<Advertisement, Long> {
    Advertisement findByAdvertisementId(Long advertisementId);

    @Transactional
    void deleteAdvertisementByAdvertisementId(Long advertisementId);

    List<Advertisement> findAdvertisementsByAdvertisementState(Integer state);
}
