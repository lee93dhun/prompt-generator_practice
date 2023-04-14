package com.ai.promptgenerator.message;

import com.ai.promptgenerator.status.StatusEnum;
import lombok.Data;

@Data
public class ResponseMessage<T> {
    private StatusEnum status;
    private String message;
    private T data;

    public ResponseMessage(){
        this.status = StatusEnum.BAD_REQUEST;
        this.message = null;
        this.data = null;
    }

}
