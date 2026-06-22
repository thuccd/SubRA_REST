package com.ACB.SubRA.Response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
/*Không cần trả về khi giá trị null */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiReponse <T>{
    private int code = 200;
    private String message;
    private T resutl ;
}
