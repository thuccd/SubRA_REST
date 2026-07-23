package com.ACB.SubRA.Response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
/*Không cần trả về khi giá trị null */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiReponse <T>{
    @Builder.Default
    private int code = 200;
    private String message;
    private T resutl ;
}
