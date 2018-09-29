package com.task.storage.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "There is no such contact id")
public class ThereIsNoSuchContactIdException extends RuntimeException { }
