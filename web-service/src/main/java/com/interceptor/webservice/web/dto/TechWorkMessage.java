package com.interceptor.webservice.web.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class TechWorkMessage {

    private boolean status;
    private LocalDateTime time;
}
