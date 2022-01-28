package com.bank.MCC.repositories;

import com.bank.MCC.entities.MetaEntity;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MetaRepository extends JpaSpecificationExecutor<MetaEntity>,
        PagingAndSortingRepository<MetaEntity, Integer>, CrudRepository<MetaEntity,Integer> {
}
