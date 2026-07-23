package com.ACB.SubRA.Request;

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
public class IntrospectRequest {
    String token;
}
