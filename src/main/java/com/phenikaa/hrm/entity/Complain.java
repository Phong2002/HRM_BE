package com.phenikaa.hrm.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Getter
@Setter
@Entity
@Table(name = "Complain")
public class Complain implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "complain_id", nullable = false)
    private Integer id;

    @Column(name = "`content`")
    private String content;

    @ManyToOne()
    @JoinColumn(name = "`user_id`")
    private User user;

}
