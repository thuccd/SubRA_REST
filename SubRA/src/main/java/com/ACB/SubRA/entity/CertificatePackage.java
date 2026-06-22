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
@Table(name = "certificate_package")
public class CertificatePackage implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "certificate_package_id")
    private Integer certificatePackageId;

    @Column(name = "certificate_package_name")
    private String certificatePackageName;

    @Column(name = "certificate_package_code")
    private String certificatePackageCode;

    @Column(name = "month_period")
    private Integer monthPeriod;

    @Column(name = "unit_price")
    private Double unitPrice;

    @Column(name = "description")
    private String description;

    @Column(name = "is_active")
    private boolean isActive;

    @Column(name = "created_time")
    private Date createdTime;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "certificatePackage")
    private Set<CertificateRequestHistory> certificateRequestHistories;
}
