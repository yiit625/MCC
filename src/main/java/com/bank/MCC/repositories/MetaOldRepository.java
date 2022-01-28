package com.bank.MCC.repositories;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MetaOldRepository  extends JpaSpecificationExecutor<MetaOldRepository>,
        PagingAndSortingRepository<MetaOldRepository, Integer>, CrudRepository<MetaOldRepository,Integer> {
}
