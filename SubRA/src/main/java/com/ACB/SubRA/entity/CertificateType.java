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
@Table(name = "certificate_type")
public class CertificateType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "certificate_type_id")
    private Integer certificateTypeId;

    @Column(name = "certificate_type_code")
    private String certificateTypeCode;

    @Column(name = "certificate_type_name")
    private String certificateTypeName;

    @Column(name = "description")
    private String description;

    @Column(name = "is_active")
    private boolean isActive;

    @Column(name = "created_time")
    private Date createdTime;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "certificateType")
    private Set<GroupConfig> groupConfigs;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "certificateType")
    private Set<CertificateRequestHistory> certificateRequestHistories;
}
