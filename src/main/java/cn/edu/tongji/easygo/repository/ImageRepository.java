package cn.edu.tongji.easygo.repository;

import cn.edu.tongji.easygo.model.Image;
import cn.edu.tongji.easygo.model.ImagePK;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;

public interface ImageRepository extends JpaRepository<Image, ImagePK> {

    List<Image> findImagesByImageIdAndAndImageType(Long id,Integer type);

    @Transactional
    void deleteAllByImageIdAndAndImageType(Long id,Integer type);
}
