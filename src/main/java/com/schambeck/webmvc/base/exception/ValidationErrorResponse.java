package com.schambeck.webmvc.base.exception;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@RequiredArgsConstructor
public class ValidationErrorResponse {

    private final List<Violation> violations;

}