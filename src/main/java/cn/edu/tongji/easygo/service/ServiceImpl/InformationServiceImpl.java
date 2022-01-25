package cn.edu.tongji.easygo.service.ServiceImpl;

import cn.edu.tongji.easygo.model.Information;
import cn.edu.tongji.easygo.repository.InformationRepository;
import cn.edu.tongji.easygo.service.InformationService;
import cn.edu.tongji.easygo.util.JpaUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InformationServiceImpl implements InformationService {

    @Autowired
    InformationRepository informationRepository;

    @Override
    public Information addInformation(Information information) {
        return informationRepository.save(information);
    }

    @Override
    public void deleteInformation(Long informationId) {
        informationRepository.deleteById(informationId);
    }

    @Override
    public Information showInformation(Long informationId) {
        return informationRepository.findByInformationId(informationId);
    }

    @Override
    public void updateInformation(Long informationId, Information information) {
        Information originInformation = informationRepository.findByInformationId(informationId);
        JpaUtil.copyNotNullProperties(information, originInformation);
        informationRepository.save(originInformation);
    }

    @Override
    public List<Information> findInformationByType(Integer informationType) {
        List<Information> allByInformationType = informationRepository.findInformationsByInformationType(informationType);
        return allByInformationType;
    }

    @Override
    public List<Information> findInformationByUser(Long userId) {
        List<Information> allByInformationType = informationRepository.findInformationsByInformationUserId(userId);
        return allByInformationType;
    }

    @Override
    public List<Information> findInformationByTypeAndContent(Integer informationType, String content) {
        List<Information> allByInformationType = informationRepository.findByTypeAndContent(informationType, content);
        return allByInformationType;
    }

    @Override
    public List<Information> findInformationByKeyword(String keyword) {
        return informationRepository.findByKeyword(keyword);
    }

    @Override
    public List<Information> findAllInformation(int page, int size) {
        Pageable request = PageRequest.of(page, size);
        return informationRepository.findAllInformation(request).getContent();
    }
}
