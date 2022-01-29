package com.bank.MCC.repositories;

import com.bank.MCC.entities.TechnicalEntity;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TechnicalRepository extends JpaSpecificationExecutor<TechnicalEntity>,
        PagingAndSortingRepository<TechnicalEntity, Integer>, CrudRepository<TechnicalEntity,Integer> {
}
