package com.phenikaa.hrm.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Getter
@Setter
@Entity
@Table(name = "Department")
public class Department implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`department_id`", nullable = false)
    private Integer id;

    @Column(name="`name`")
    private String name;

    @Column(name="`introduce`")
    private String introduce;

    @Column(name = "`founding_date`")
    @Temporal(TemporalType.DATE)
    private Date foundingDate;



}
