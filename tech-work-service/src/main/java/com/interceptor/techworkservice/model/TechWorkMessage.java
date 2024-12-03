package com.interceptor.techworkservice.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class TechWorkMessage implements Serializable {

    private boolean status;
    private LocalDateTime time;

}
