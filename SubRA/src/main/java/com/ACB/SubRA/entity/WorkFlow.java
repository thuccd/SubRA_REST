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
@Table(name = "work_flow")
public class WorkFlow implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "work_flow_id")
    private Integer workFlowId;

    @Column(name = "work_flow_name")
    private String workFlowName;

    @Column(name = "description")
    private String description;

    @Column(name = "is_active")
    private boolean isActive;

    @Column(name = "created_time")
    private Date createdTime;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "workFlow")
    private Set<GroupWorkConfig> groupWorkConfigs;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "workFlow")
    private Set<Work> works;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "workFlows")
    private Set<Group> groups;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "process_type_id", nullable = false)
    private ProcessType processType;
}
