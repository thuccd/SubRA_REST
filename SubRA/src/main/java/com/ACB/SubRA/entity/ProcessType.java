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
@Table(name = "process_type")
public class ProcessType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "process_type_id")
    private Integer processTypeId;

    @Column(name = "process_type_name")
    private String processTypeName;

    @Column(name = "description")
    private String description;

    @Column(name = "is_active")
    private boolean isActive;

    @Column(name = "created_time")
    private Date createdTime;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "processType")
    private Set<Incident> incidents;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "processType")
    private Set<WorkFlow> workFlows;
}
