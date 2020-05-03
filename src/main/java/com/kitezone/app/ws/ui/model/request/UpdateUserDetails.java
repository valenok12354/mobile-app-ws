package com.kitezone.app.ws.ui.model.request;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class UpdateUserDetails {

    @NotNull(message = "not null!!!")
    @Size(min = 2, message = "not less than 2")
    private String firstName;
    @NotNull(message = "not null!!!")
    @Size(min = 2, message = "not less than 2")
    private String lastName;

}
