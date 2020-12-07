package com.fh.common;




import com.fh.utils.BrandSuccess;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class PrizeException {

    //捕捉异常
    @ExceptionHandler(RuntimeExceptions.class)
    public BrandSuccess handlerIgnore(RuntimeExceptions e){

        return BrandSuccess.IgnoreException();
    }

    @ExceptionHandler(IdempotenceNeedExceptions.class)
    public BrandSuccess Idempotence(IdempotenceNeedExceptions e){
        return BrandSuccess.IdempotenceException();
    }

}
