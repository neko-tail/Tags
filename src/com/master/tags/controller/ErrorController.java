package com.master.tags.controller;

public class ErrorController {
    public String err_404() {
        return "404";
    }
    
    public String err_500() {
        return "500";
    }
    
    public String err_error() {
        return "error";
    }
    
}
