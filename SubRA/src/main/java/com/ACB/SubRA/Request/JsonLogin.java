package com.ACB.SubRA.Request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ThucCD
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JsonLogin {
    private String userName;
    private String certificateSerialNumber;
    private String signature;
}
