package com.bank.MCC.repositories;

import com.bank.MCC.entities.MetaEntity;
import com.bank.MCC.entities.TechnicalEntity;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TechnicalRepository extends JpaSpecificationExecutor<TechnicalEntity>,
        PagingAndSortingRepository<TechnicalEntity, Integer>, CrudRepository<TechnicalEntity,Integer> {

    @Query("select e from TechnicalEntity e where e.roles =:roles ")
    TechnicalEntity checkExist(@Param("roles") String roles);
}
