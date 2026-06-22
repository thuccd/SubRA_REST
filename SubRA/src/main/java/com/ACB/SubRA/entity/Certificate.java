package com.ACB.SubRA.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;
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
@Table(name = "certificate")
public class Certificate implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "certificate_id")
    private Integer certificateId;
    @Column(name = "certificate_serial_number")
    private String certificateSerialNumber;
    @Column(name = "subject_dn")
    private String subjectDn;

    @Column(name = "not_before")
    private Date notBefore;

    @Column(name = "not_after")
    private Date notAfter;

    @Column(name = "revocation_date")
    private Date revocationDate;

    @Column(name = "base64_certificate")
    private String base64Certificate;

    @Column(name = "is_remote_import")
    private boolean isRemoteImport;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "incident_id", nullable = false)
    private Incident incident;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "token_id", nullable = true)
    private Token token;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "certificate")
    private Set<SystemSynchronization> systemSynchronizations;





}
