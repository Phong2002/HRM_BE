package com.phenikaa.hrm.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Getter
@Setter
@Entity
@Table(name = "Timekeeping")
public class Timekeeping implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "timekeeping_id", nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "`user_id`")
    private User user;

    @Column(name = "`start_time`")

    private LocalTime startTime;

    @Column(name = "`time_end`")

    private LocalTime timeEnd;

    @Column(name = "`workday`")


    private LocalDate workday;

}
