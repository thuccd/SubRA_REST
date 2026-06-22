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
@Table(name = "group")
public class Group implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "group_id")
    private Integer groupId;

    @Column(name = "group_name")
    private String groupName;

    @Column(name = "group_code")
    private String groupCode;

    @Column(name = "is_active")
    private boolean isActive;

    @Column(name = "created_time")
    private Date createdTime;

    @Column(name = "uid")
    private String uid;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "group")
    private Set<Employee> employees;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "group")
    private Set<System> systems;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "group", cascade = CascadeType.ALL)
    private Set<GroupWorkConfig> groupWorkConfigs;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "group", cascade = CascadeType.ALL)
    private Set<GroupConfig> groupConfigs;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "region_id", nullable = false)
    private Region region;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_parent_id", nullable = false)
    private Group parentGroup;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "group_work_config", catalog = "subra", joinColumns = {
            @JoinColumn(name = "group_id", nullable = false)
    }, inverseJoinColumns = {
            @JoinColumn(name = "work_flow_id", nullable = false)
    })
    private Set<WorkFlow> workFlows;

    @Column(name = "ra_group_id")
    private Integer raGroupId;
}
