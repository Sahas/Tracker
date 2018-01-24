package com.trackit.tracker.exception;

import java.util.ArrayList;
import java.util.List;

public class ExceptionFormatter {

  private List<String> errors = new ArrayList<>();

  private final String errorMessage;

  public ExceptionFormatter(String errorMessage) {
    this.errorMessage = errorMessage;
  }

  public void addValidationException(String error) {
    this.errors.add(error);
  }

  public List<String> getErrors() {
    return this.errors;
  }

  public String getErrorMessage() {
    return this.errorMessage;
  }
}
