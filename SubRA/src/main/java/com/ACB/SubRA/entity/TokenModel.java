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
public class TokenModel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "token_model_id")
    private Integer tokenModelId;

    @Column(name = "token_model_name")
    private String tokenModelName;

    @Column(name = "manufacturer_name")
    private String manufacturerName;

    @Column(name = "lib_name")
    private String libName;

    @Column(name = "default_so_pin")
    private String defaultSoPin;

    @Column(name = "default_user_pin")
    private String defaultUserPin;

    @Column(name = "is_active")
    private boolean isActive;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "tokenModel")
    private Set<Token> tokens;
}
