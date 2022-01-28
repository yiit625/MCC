package com.bank.MCC.services;

import com.bank.MCC.dto.MetaModel;
import com.bank.MCC.entities.MetaEntity;

public interface MetaService {
    MetaEntity create(MetaModel model);

    MetaEntity update(MetaModel model);

    void delete(Integer metaId);
}
