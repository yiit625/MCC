package com.bank.MCC.services;

import com.bank.MCC.dto.MetaModel;
import com.bank.MCC.entities.MetaEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MetaService {
    MetaEntity create(MetaModel model);

    MetaEntity update(MetaModel model);

    void delete(Integer metaId);

    Page<MetaEntity> pagingMetas(String nameOfApplication , String ownerOfApplication, String configManagerOfApplication , Pageable page);
}
