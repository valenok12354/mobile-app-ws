package com.kitezone.app.ws.ui.model.responce;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Value;

import java.util.Date;
@Value
public class ErrorMessage {
    private Date timeStamp;
    private String message;
}
