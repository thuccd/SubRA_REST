package com.ACB.SubRA.Response;

import lombok.*;
import lombok.experimental.FieldDefaults;
/**
 * @author ThucCD
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AuthenticationResponse {
    String token;
    boolean authenticated;
}
