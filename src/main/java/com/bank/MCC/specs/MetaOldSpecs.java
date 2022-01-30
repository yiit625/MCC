package com.bank.MCC.specs;

import com.bank.MCC.entities.MetaOldEntity;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.ObjectUtils;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

public class MetaOldSpecs <T extends MetaOldEntity> {
    public MetaOldSpecs() { }

    public Specification<MetaOldEntity> filter(Integer id, String nameOfApplication , String ownerOfApplication,
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
            if(id != null){
                predicates.add(cb.equal(root.join("metaId").get("id"), id));
            }
            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}
