package com.ACB.SubRA.Request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author ThucCD
 */
@Data
public class JsonGenerateCertificate {
    @JsonProperty("commonName")
    private String commonName;

    @JsonProperty("email")
    private String email;

    @JsonProperty("phoneNumber")
    private String phoneNumber;

    @JsonProperty("country")
    private String country;

    @JsonProperty("locality")
    private String locality;

    @JsonProperty("state")
    private String state;

    @JsonProperty("customerType")
    private String customerType;

    @JsonProperty("extraUid")
    private String extraUid;

    @JsonProperty("extraUidPrefix")
    private String extraUidPrefix;

    @JsonProperty("organization")
    private String organization;

    @JsonProperty("userID")
    private String userID;

    @JsonProperty("certificateSigningRequest")
    private String certificateSigningRequest;



}
