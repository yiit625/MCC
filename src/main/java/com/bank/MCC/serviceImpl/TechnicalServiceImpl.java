package com.bank.MCC.serviceImpl;

import com.bank.MCC.dto.TechnicalModel;
import com.bank.MCC.entities.MetaEntity;
import com.bank.MCC.entities.MetaOldEntity;
import com.bank.MCC.entities.TechnicalEntity;
import com.bank.MCC.entities.TechnicalOldEntity;
import com.bank.MCC.repositories.TechnicalOldRepository;
import com.bank.MCC.repositories.TechnicalRepository;
import com.bank.MCC.services.TechnicalService;
import com.bank.MCC.specs.MetaSpecs;
import com.bank.MCC.specs.TechnicalOldSpecs;
import com.bank.MCC.specs.TechnicalSpecs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Date;

@Service
public class TechnicalServiceImpl implements TechnicalService {

    @Autowired
    TechnicalRepository technicalRepository;
    @Autowired
    TechnicalOldRepository technicalOldRepository;

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
        TechnicalEntity technicalEntity = technicalRepository.findById(model.getId()).orElseThrow(EntityNotFoundException::new);

        TechnicalOldEntity technicalOldEntity = new TechnicalOldEntity();
        technicalOldEntity.setRoles(technicalEntity.getRoles());
        technicalOldEntity.setPermissions(technicalEntity.getPermissions());
        technicalOldEntity.setVersion(technicalEntity.getVersion());
        technicalOldEntity.setCreatedDate(technicalEntity.getCreatedDate());
        technicalOldEntity.setUpdateDate(new Date());
        technicalOldEntity.setMetaId(technicalEntity);
        technicalOldRepository.save(technicalOldEntity);

        technicalEntity.setVersion(technicalEntity.getVersion() + 1);
        technicalEntity.setRoles(model.getRoles());
        technicalEntity.setPermissions(model.getPermissions());
        technicalEntity.setUpdateDate(new Date());

        return technicalRepository.save(technicalEntity);
    }

    @Override
    public void delete(Integer technicalId) {
        technicalRepository.deleteById(technicalId);
    }

    @Override
    public Page<TechnicalEntity> pagingMetas(String role , String permission, Pageable page) {
        TechnicalSpecs<TechnicalEntity> spec = new TechnicalSpecs<>();
        return technicalRepository.findAll(spec.filter(role, permission), page);
    }

    @Override
    public Page<TechnicalOldEntity> pagingOldMetas(Integer id, String role, String permission, Pageable page) {
        TechnicalOldSpecs<TechnicalOldEntity> spec = new TechnicalOldSpecs<>();
        return technicalOldRepository.findAll(spec.filter(id, role, permission), page);
    }
}
