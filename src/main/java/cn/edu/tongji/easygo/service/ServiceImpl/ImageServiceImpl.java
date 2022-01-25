package cn.edu.tongji.easygo.service.ServiceImpl;

import cn.edu.tongji.easygo.model.Image;
import cn.edu.tongji.easygo.model.ImagePK;
import cn.edu.tongji.easygo.repository.ImageRepository;
import cn.edu.tongji.easygo.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ImageServiceImpl implements ImageService {

    @Autowired
    ImageRepository imageRepository;

    @Override
    public boolean addImage(Long informationId, String imageUrl, int i) {
        ImagePK imagePK = new ImagePK(informationId,imageUrl,i);
        if(imageRepository.existsById(imagePK))
            return false;
        imageRepository.save(new Image(informationId,imageUrl,i));
        return true;
    }

    @Override
    public List<String> showImages(Long id, Integer type) {
        List<Image> images = imageRepository.findImagesByImageIdAndAndImageType(id, type);
        List<String> ans = new ArrayList<>();
        for(Image tmp:images) {
            ans.add(tmp.getImageUrl());
        }
        return ans;
    }

    @Override
    public boolean deleteImages(Long id, Integer type) {
        imageRepository.deleteAllByImageIdAndAndImageType(id, type);
        return true;
    }

}
