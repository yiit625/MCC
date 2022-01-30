package com.bank.MCC.specs;

import com.bank.MCC.entities.TechnicalOldEntity;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.ObjectUtils;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

public class TechnicalOldSpecs <T extends TechnicalOldEntity> {
    public TechnicalOldSpecs() { }

    public Specification<TechnicalOldEntity> filter(Integer id, String role , String permission) {
        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (!ObjectUtils.isEmpty(role)) {
                predicates.add(cb.like(root.get("role"), "%" + role + "%"));
            }
            if (!ObjectUtils.isEmpty(permission)) {
                predicates.add(cb.like(root.get("ownerOfApplication"), "%" + permission + "%"));
            }
            if(id != null){
                predicates.add(cb.equal(root.join("metaId").get("id"), id));
            }
            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}
