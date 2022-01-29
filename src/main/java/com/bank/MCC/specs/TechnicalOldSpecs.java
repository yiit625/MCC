package com.bank.MCC.specs;

import com.bank.MCC.entities.TechnicalOldEntity;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

public class TechnicalOldSpecs <T extends TechnicalOldEntity> {
    public TechnicalOldSpecs() { }

    public Specification<TechnicalOldEntity> filter(Integer id, String role , String permission) {
        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (role != null) {
                predicates.add(cb.like(root.get("role"), "%" + role + "%"));
            }
            if (permission != null) {
                predicates.add(cb.like(root.get("ownerOfApplication"), "%" + permission + "%"));
            }
            if (id != null) {
                predicates.add(cb.equal(root.get("id"), id));
            }
            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}
