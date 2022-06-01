package com.phenikaa.hrm.entity;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;

@Data
@Getter
@Setter
@Entity
@Table(name = "Reward_Punish")
public class RewardPunish implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Reward_Punish_id", nullable = false)
    private Integer id;

    @Column(name = "`amount`")
    private Long amount;

    @Column(name = "`reason`")
    private String reason;

    @Column(name = "day")
    private LocalDate day;

    @ManyToOne
    @JoinColumn(name = "`user_id`")
    private User user;

}
