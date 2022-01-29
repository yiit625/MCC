package com.bank.MCC.repositories;

import com.bank.MCC.entities.MetaOldEntity;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MetaOldRepository extends JpaSpecificationExecutor<MetaOldEntity>,
        PagingAndSortingRepository<MetaOldEntity, Integer>, CrudRepository<MetaOldEntity,Integer> {
}
