package com.ACB.SubRA.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @author ThucCD
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "revocation_reason")
public class RevocationReason implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "revocation_reason_id")
    private Integer revocationReasonId;

    @Column(name = "revocation_reason_code")
    private Integer revocationReasonCode;

    @Column(name = "revocation_reason_name")
    private String revocationReasonName;

    @Column(name = "description")
    private String description;

    @Column(name = "is_active")
    private boolean isActive;

    @Column(name = "created_time")
    private Date createdTime;

}
