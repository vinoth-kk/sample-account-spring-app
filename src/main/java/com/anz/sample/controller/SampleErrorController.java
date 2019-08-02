package com.anz.sample.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/error")
public class SampleErrorController implements ErrorController {

	@RequestMapping
    public ResponseEntity error(HttpServletRequest request){
        return new ResponseEntity(getStatus(request));
    }
	
	@Override
	public String getErrorPath() {
		return "/error";
	}

	private HttpStatus getStatus(HttpServletRequest request) {
        Integer statusCode = (Integer) request
                .getAttribute("javax.servlet.error.status_code");
        if (statusCode != null) {
            try {
                return HttpStatus.valueOf(statusCode);
            }
            catch (Exception ex) {
            }
        }
        return HttpStatus.BAD_REQUEST;
    }
}
