package com.ACB.SubRA.Exception;

import com.ACB.SubRA.Response.ApiReponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    /* Khai báo class GlobalExceptionHandler sử dụng ControllerAdvice Spring biết handle
    khi có bất kỳ 1 runtiExcreption nào trong hệ thống sẽ roll về đây */
    @ExceptionHandler(value = Exception.class)
    ResponseEntity<ApiReponse> handlingRuntime(RuntimeException exception){
        ApiReponse apiReponse = new ApiReponse();

        apiReponse.setCode(ErrorCode.UNCATEGORIZED_EXCEPTION.getCode());
        apiReponse.setMessage(ErrorCode.UNCATEGORIZED_EXCEPTION.getMessage());
        return ResponseEntity.badRequest().body(apiReponse);
    }

    /*Khai báo 1 AppException để tự định nghĩa exception */
    @ExceptionHandler(value = AppException.class)
    ResponseEntity<ApiReponse> handlingAppException(AppException exception){
        ErrorCode errorCode =  exception.getErrorCode();
        ApiReponse apiReponse = new ApiReponse();
        apiReponse.setCode(errorCode.getCode());
        apiReponse.setMessage(errorCode.getMessage());
        return ResponseEntity.badRequest().body(apiReponse);
    }

    /*sử dụng thư viện pring-boot-starter-validation có nhiều thuộc tính size, notnull, notblank , notempty
    * cách tạo 1 validation customer ?*/
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    ResponseEntity<ApiReponse> handlingValidation(MethodArgumentNotValidException exception){

        String enumKey = exception.getFieldError().getDefaultMessage();

        ErrorCode errorCode = ErrorCode.INVALID_KEY;
        try{
            errorCode=ErrorCode.valueOf(enumKey);
        }catch (IllegalArgumentException ex){

        }

        ApiReponse apiReponse = new ApiReponse();
        apiReponse.setCode(errorCode.getCode());
        apiReponse.setMessage(errorCode.getMessage());

        return ResponseEntity.badRequest().body(apiReponse);
    }
}
