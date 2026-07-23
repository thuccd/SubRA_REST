package com.ACB.SubRA.Service;

import com.ACB.SubRA.Exception.AppException;
import com.ACB.SubRA.Exception.ErrorCode;
import com.ACB.SubRA.Repository.EmployeeRepository;
import com.ACB.SubRA.Request.AuthenticationRequest;
import com.ACB.SubRA.Response.AuthenticationResponse;
import com.ACB.SubRA.entity.Employee;
import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jwt.JWTClaimsSet;
import lombok.Value;
import lombok.experimental.NonFinal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.UUID;

/**
 * @author ThucCD
 */
@Service
public class AuthenticationService {
    private  static  final Logger log = LoggerFactory.getLogger(AuthenticationService.class);
   @Autowired
   EmployeeRepository employeeRepository;

   @NonFinal
   protected static final String  SIGNER_KEY = "7A91E4C83FD25B6A18F0D7E5B94AC31F6E2D98A70CBF41D5E6A3921C84F75B0D";


//    @NonFinal
//    @Value("${jwt.signerKey}")
//    protected String SIGNER_KEY;
//
//    @NonFinal
//    @Value("${jwt.valid-duration}")
//    protected long VALID_DURATION;
//
//    @NonFinal
//    @Value("${jwt.refreshable-duration}")
//    protected long REFRESHABLE_DURATION;


    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);

        Employee username =employeeRepository.findByuserName(request.getUsername());

        boolean authenticated = passwordEncoder.matches(request.getPassword(), username.getPassword());


        if(!authenticated) throw new AppException(ErrorCode.UNAUTHENTICATED);


        var token = generateToken(username);
        return AuthenticationResponse.builder()
                .token(token)
                .authenticated(true)
                .build();

    }


    private String generateToken(Employee employee) {
        // 1 header
        JWSHeader header = new JWSHeader(JWSAlgorithm.HS512);

        //2.1 trong paylad cần claims
        JWTClaimsSet jwtClaimsSet = new JWTClaimsSet.Builder()
                .subject(employee.getUserName())  // tên
                .issuer("devteria.com")            // issuser từ cái j
                .issueTime(new Date())              // date
                .expirationTime(new Date(           // thừoi hạn cuủa token
                        Instant.now().plus(1, ChronoUnit.SECONDS).toEpochMilli()))
                .jwtID(UUID.randomUUID().toString())
                .claim("scope", "Custom")
                .build();

        // 2 payload
        Payload payload = new Payload(jwtClaimsSet.toJSONObject());

        // khởi tạo
        JWSObject jwsObject = new JWSObject(header, payload);

        try {
            jwsObject.sign(new MACSigner(SIGNER_KEY.getBytes()));
            return jwsObject.serialize();
        } catch (JOSEException e) {
            log.error("Cannot create token", e);
            throw new RuntimeException(e);
        }
    }


}
