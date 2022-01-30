package com.bank.MCC.services;

import com.bank.MCC.config.ValidationMessage;
import com.bank.MCC.dto.MetaModel;
import com.bank.MCC.entities.MetaEntity;
import com.bank.MCC.entities.MetaOldEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MetaService {
    MetaEntity create(MetaModel model);

    MetaEntity update(MetaModel model);

    void delete(Integer metaId);

    Page<MetaEntity> pagingMetas(String nameOfApplication , String ownerOfApplication,
                                 String configManagerOfApplication , Pageable page);

    Page<MetaOldEntity> pagingOldMetas(Integer id, String nameOfApplication , String ownerOfApplication,
                                       String configManagerOfApplication , Pageable page);

    ValidationMessage checkExist(String nameOfApplication);
}
