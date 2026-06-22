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
@Table(name = "incident")
public class Incident implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "incident_id")
    private Integer incidentId;

    @Column(name = "is_Finish")
    private boolean isFinish;

    @Column(name = "created_time")
    private Date createdTime;

    @Column(name = "ra_id")
    private Integer raId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_id", nullable = false)
    private Group group;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "work_id", nullable = false)
    private Work work;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "process_status_id", nullable = false)
    private ProcessStatus processStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "process_type_id", nullable = false)
    private ProcessType processType;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "incident")
    private CertificateRequestHistory certificateRequestHistory;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "incident")
    private RevocationRequestHistory revocationRequestHistory;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "incident")
    private Certificate certificate;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "incident")
    private ProfileInfo profileInfo;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "incident")
    private Set<SharedWork> sharedWorks;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "incident")
    private Set<FileUpload> fileUploads;
}
