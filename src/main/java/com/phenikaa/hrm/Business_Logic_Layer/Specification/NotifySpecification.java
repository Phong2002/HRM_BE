package com.phenikaa.hrm.Business_Logic_Layer.Specification;
import com.phenikaa.hrm.entity.Department;
import com.phenikaa.hrm.entity.Notifications;
import org.springframework.data.jpa.domain.Specification;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class NotifySpecification implements Specification<Notifications> {
    private String field;
    private String operator;
    private Object value;

    public NotifySpecification(String field, String operator, Object value) {
        this.field = field;
        this.operator = operator;
        this.value = value;
    }

    @Override
    public Predicate toPredicate(Root<Notifications> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        if(operator.equalsIgnoreCase("%LIKE%")){
            return criteriaBuilder.like(root.get(field),"%"+value.toString()+"%");
        }
        else if(operator.equalsIgnoreCase("=")){
            return criteriaBuilder.equal(root.get(field),(Department)value);
        }
        return null;
    }
}

