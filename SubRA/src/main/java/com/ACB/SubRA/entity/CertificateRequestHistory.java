package com.ACB.SubRA.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import java.io.Serializable;

/**
 * @author ThucCD
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "certificate_request_history")
public class CertificateRequestHistory implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "certificate_request_history_id")
    private Integer certificateRequestHistoryId;

    @Column(name = "uid")
    private String uid;

    @Column(name = "uid_prefix")
    private String uidPrefix;

    @Column(name = "extra_uid")
    private String extraUid;

    @Column(name = "extra_uid_prefix")
    private String extraUidPrefix;

    @Column(name = "common_name")
    private String commonName;

    @Column(name = "organization")
    private String organization;

    @Column(name = "locality")
    private String locality;

    @Column(name = "state")
    private String state;

    @Column(name = "country")
    private String country;

    @Column(name = "email")
    private String email;

    @Column(name = "certificate_signing_request")
    private String certificateSigningRequest;

    @Column(name = "total_day")
    private int totalDay;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "incident_id", nullable = false)
    private Incident incident;

    @Column(name = "guid")
    private String guid;

    @Column(name = "store_type")
    private Integer storeType;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "certificate_request_history_old_id", nullable = false)
    @NotFound(action = NotFoundAction.IGNORE)
    private CertificateRequestHistory oldCertificateRequestHistory;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_type_id", nullable = false)
    private CustomerType customerType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "certificate_type_id", nullable = false)
    private CertificateType certificateType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "certificate_package_id", nullable = false)
    private CertificatePackage certificatePackage;

}
