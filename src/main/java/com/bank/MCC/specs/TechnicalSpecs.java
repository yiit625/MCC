package com.bank.MCC.specs;

import com.bank.MCC.entities.TechnicalEntity;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.ObjectUtils;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

public class TechnicalSpecs  <T extends TechnicalEntity> {
    public TechnicalSpecs() { }

    public Specification<TechnicalEntity> filter(String role , String permission) {
        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (!ObjectUtils.isEmpty(role)) {
                predicates.add(cb.like(root.get("role"), "%" + role + "%"));
            }
            if (!ObjectUtils.isEmpty(permission)) {
                predicates.add(cb.like(root.get("ownerOfApplication"), "%" + permission + "%"));
            }
            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}
