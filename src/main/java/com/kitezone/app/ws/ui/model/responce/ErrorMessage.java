package com.kitezone.app.ws.ui.model.responce;

import lombok.Value;

import java.util.Date;
@Value
public class ErrorMessage {
    Date timeStamp;
    String message;
}
