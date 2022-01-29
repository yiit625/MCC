package com.bank.MCC.services;

import com.bank.MCC.dto.TechnicalModel;
import com.bank.MCC.entities.TechnicalEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TechnicalService {

    TechnicalEntity create(TechnicalModel model);

    TechnicalEntity update(TechnicalModel model);

    void delete(Integer technicalId);

    Page<TechnicalEntity> pagingMetas(String nameOfApplication , String ownerOfApplication, String configManagerOfApplication , Pageable page);
}
