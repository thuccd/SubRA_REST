package com.ACB.SubRA.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Set;

/**
 * @author ThucCD
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "token_model")
public class Token implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "token_id")
    private Integer tokenId;

    @Column(name = "token_serial_number")
    private String tokenSerialNumber;

    @Column(name = "so_pin")
    private String soPin;

    @Column(name = "user_pin")
    private String userPin;

    @Column(name = "code_uninstall")
    private String codeUninstall;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "token")
    private Set<Certificate> certificates;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "token_model_id", nullable = false)
    private TokenModel tokenModel;
}
