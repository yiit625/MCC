package com.bank.MCC.repositories;

import com.bank.MCC.entities.TechnicalOldEntity;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface TechnicalOldRepository extends JpaSpecificationExecutor<TechnicalOldEntity>,
        PagingAndSortingRepository<TechnicalOldEntity, Integer>, CrudRepository<TechnicalOldEntity,Integer> {
}
