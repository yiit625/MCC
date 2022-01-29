package com.bank.MCC.serviceImpl;

import com.bank.MCC.dto.MetaModel;
import com.bank.MCC.entities.MetaEntity;
import com.bank.MCC.entities.MetaOldEntity;
import com.bank.MCC.repositories.MetaRepository;
import com.bank.MCC.services.MetaService;
import com.bank.MCC.specs.MetaSpecs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Date;

@Service
public class MetaServiceImpl implements MetaService {

    @Autowired
    MetaRepository metaRepository;

    @Override
    public MetaEntity create(MetaModel model) {
        MetaEntity metaEntity = new MetaEntity();
        metaEntity.setCreatedDate(new Date());
        metaEntity.setVersion(0);
        return metaRepository.save(mapMeta(metaEntity, model));
    }

    @Override
    public MetaEntity update(MetaModel model) {
        MetaEntity metaEntity = metaRepository.findById(model.getId()).orElseThrow(EntityNotFoundException::new);

        MetaOldEntity metaOldEntity = new MetaOldEntity();
        metaOldEntity.setNameOfApplication(metaEntity.getNameOfApplication());
        metaOldEntity.setConfigManagerOfApplication(metaEntity.getConfigManagerOfApplication());
        metaOldEntity.setOwnerOfApplication(metaEntity.getOwnerOfApplication());
        metaOldEntity.setVersion(metaEntity.getVersion());
        metaOldEntity.setCreatedDate(metaEntity.getCreatedDate());
        metaOldEntity.setUpdateDate(new Date());
        metaOldEntity.setMetaId(metaEntity);
        //metaOldRepository.save(metaOldEntity);

        MetaEntity metaEntity1 = new MetaEntity();
        metaEntity1.setId(model.getId());
        metaEntity1.setCreatedDate(metaEntity.getCreatedDate());
        metaEntity1.setVersion(metaEntity.getVersion() + 1);

        delete(metaEntity.getId());
        return metaRepository.save(mapMeta(metaEntity1, model));
    }

    private MetaEntity mapMeta(MetaEntity metaEntity, MetaModel model) {
        metaEntity.setNameOfApplication(model.getNameOfApplication());
        metaEntity.setConfigManagerOfApplication(model.getConfigManagerOfApplication());
        metaEntity.setOwnerOfApplication(model.getOwnerOfApplication());
        metaEntity.setUpdateDate(new Date());
        return metaEntity;
    }



    @Override
    public void delete(Integer metaId) {
        metaRepository.deleteById(metaId);
    }

    @Override
    public Page<MetaEntity> pagingMetas(String nameOfApplication, String ownerOfApplication,
                                        String configManagerOfApplication, Pageable page) {
        MetaSpecs<MetaEntity> spec = new MetaSpecs<>();
        return metaRepository.findAll(spec.filter(nameOfApplication, ownerOfApplication,
                configManagerOfApplication), page);
    }
}
