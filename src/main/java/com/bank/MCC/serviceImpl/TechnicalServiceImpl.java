package com.bank.MCC.serviceImpl;

import com.bank.MCC.dto.TechnicalModel;
import com.bank.MCC.entities.TechnicalEntity;
import com.bank.MCC.repositories.TechnicalRepository;
import com.bank.MCC.services.TechnicalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TechnicalServiceImpl implements TechnicalService {

    @Autowired
    TechnicalRepository technicalRepository;

    @Override
    public TechnicalEntity create(TechnicalModel model) {
        TechnicalEntity technicalEntity = new TechnicalEntity();
        technicalEntity.setRoles(model.getRoles());
        technicalEntity.setPermissions(model.getPermissions());
        technicalEntity.setCreatedDate(new Date());
        technicalEntity.setUpdateDate(new Date());
        return technicalRepository.save(technicalEntity);
    }

    @Override
    public TechnicalEntity update(TechnicalModel model) {
        return null;
    }

    @Override
    public void delete(Integer technicalId) {
        technicalRepository.deleteById(technicalId);
    }

    @Override
    public Page<TechnicalEntity> pagingMetas(String nameOfApplication, String ownerOfApplication,
                                             String configManagerOfApplication, Pageable page) {
        return null;
    }
}
