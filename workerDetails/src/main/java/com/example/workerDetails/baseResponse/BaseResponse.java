package com.example.workerDetails.baseResponse;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseResponse<T> {

    String StatusCode;
    String StatusMsg;
    private T Data;
}
