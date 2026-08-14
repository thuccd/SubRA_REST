package com.ACB.SubRA.Controller;

import com.ACB.SubRA.Request.AuthenticationRequest;
import com.ACB.SubRA.Request.IntrospectRequest;
import com.ACB.SubRA.Response.ApiReponse;
import com.ACB.SubRA.Response.AuthenticationResponse;
import com.ACB.SubRA.Response.IntrospectResponse;
import com.ACB.SubRA.Service.AuthenticationService;
import com.nimbusds.jose.JOSEException;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

/**
 * @author ThucCD
 */
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthenticationController {

    AuthenticationService authenticationService;

    @PostMapping("/log-in")
    ApiReponse<AuthenticationResponse> authenticate (@RequestBody AuthenticationRequest authenticationRequest) {
      var result =  authenticationService .authenticate (authenticationRequest);

      return ApiReponse.<AuthenticationResponse>builder()
              .resutl(result)
              .build();
    }

    @PostMapping("/introspect")
    ApiReponse<IntrospectResponse> authenticate(@RequestBody IntrospectRequest request)
            throws ParseException, JOSEException {
        var result = authenticationService.introspect(request);
        return ApiReponse.<IntrospectResponse>builder().resutl(result).build();
    }

}
