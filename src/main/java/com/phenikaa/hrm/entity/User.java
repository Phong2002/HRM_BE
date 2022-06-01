package com.phenikaa.hrm.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Formula;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Getter
@Setter
@Entity
@Table(name = "User")
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`user_id`", nullable = false)
    public int id;
    @Column(name ="`firstname`" ,nullable = false)
    public String firstname;
    @Column(name ="`lastname`" ,nullable = false)
    public String lastname;

    @Formula(" concat(firstname, ' ', lastname) ")
    private String fullName;

    @Column(name = "gender")
    private String gender;

    @Column(name = "`dateOfBirth`")
    @Temporal(TemporalType.DATE)

    private Date dateOfBirth;

    @Column(name = "address")
    private String address;

    @Column(name ="`email`" ,nullable = false)
    public String email;
    @Column(name ="`username`" ,nullable = false)
    public String username;
    @Column(name ="`password`" ,nullable = false)
    public String password;

    @Column(name = "`workStartDate`")
    @Temporal(TemporalType.DATE)

    private Date workStartDate;

    @Column(name = "`numberPhone`")
    private String numberPhone;

    @Column(name = "`salary`")
    private Long salary;

    @Column(name = "`id_card`")
    private String idCard;

    @ManyToOne
    @JoinColumn(name = "`department_id`")
    private Department department;

    @Column(name = "Classify")
    private String classify;

    @Column(name = "role")
    private String role;
}
