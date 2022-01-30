package com.bank.MCC.serviceImpl;

import com.bank.MCC.dto.ApplicationModel;
import com.bank.MCC.entities.MetaEntity;
import com.bank.MCC.entities.TechnicalEntity;
import com.bank.MCC.repositories.MetaRepository;
import com.bank.MCC.repositories.TechnicalRepository;
import com.bank.MCC.services.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ApplicationServiceImpl implements ApplicationService {

    @Autowired
    MetaRepository metaRepository;
    @Autowired
    TechnicalRepository technicalRepository;

    @Override
    public void create(ApplicationModel model) {
        MetaEntity metaEntity = new MetaEntity();
        metaEntity.setCreatedDate(new Date());
        metaEntity.setVersion(0);
        metaEntity.setNameOfApplication(model.getNameOfApplication());
        metaEntity.setConfigManagerOfApplication(model.getConfigManagerOfApplication());
        metaEntity.setOwnerOfApplication(model.getOwnerOfApplication());
        metaEntity.setUpdateDate(new Date());

        TechnicalEntity technicalEntity = new TechnicalEntity();
        technicalEntity.setRoles(model.getRoles());
        technicalEntity.setPermissions(model.getPermissions());
        technicalEntity.setCreatedDate(new Date());
        technicalEntity.setUpdateDate(new Date());

        metaRepository.save(metaEntity);
        technicalRepository.save(technicalEntity);
    }
}
