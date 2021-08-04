package com.westpacgroup.westpac.exception;

import lombok.AllArgsConstructor;

import java.util.Date;

@AllArgsConstructor
public class ErrorDetails {
    private Date  date;
    private String message;
    private String description;
}
