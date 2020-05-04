package com.kitezone.app.ws.utils;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class Utils {

    public String getUuid() {
        return UUID.randomUUID()
                   .toString();
    }
}