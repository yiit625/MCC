package com.bank.MCC.specs;

import com.bank.MCC.entities.MetaEntity;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.ObjectUtils;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

public class MetaSpecs  <T extends MetaEntity> {
    public MetaSpecs() { }

    public Specification<MetaEntity> filter(String nameOfApplication , String ownerOfApplication,
                                            String configManagerOfApplication) {
        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (!ObjectUtils.isEmpty(nameOfApplication)) {
                predicates.add(cb.like(root.get("nameOfApplication"), "%" + nameOfApplication + "%"));
            }
            if (!ObjectUtils.isEmpty(ownerOfApplication)) {
                predicates.add(cb.like(root.get("ownerOfApplication"), "%" + ownerOfApplication + "%"));
            }
            if (!ObjectUtils.isEmpty(configManagerOfApplication)) {
                predicates.add(cb.equal(root.get("configManagerOfApplication"), configManagerOfApplication));
            }
            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}
