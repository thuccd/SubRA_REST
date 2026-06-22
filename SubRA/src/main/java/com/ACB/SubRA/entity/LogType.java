package com.ACB.SubRA.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * @author ThucCD
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "log_type")
public class LogType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "log_type_id")
    private Integer logTypeId;

    @Column(name = "log_type_name")
    private String logTypeName;

    @Column(name = "description")
    private String description;

    @Column(name = "created_time")
    private Date createdTime;

    @Column(name = "is_active")
    private boolean isActive;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "logType")
    private Set<Log> logs;
}
