package com.company.greenspaceproject.controller;

import com.company.greenspaceproject.service.ex.*;
import com.util.JsonResult;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpSession;
import java.nio.file.AccessDeniedException;

/** Base Controller class*/
public class BaseController {
    // Operation success code
    public static final int OK = 200;

    // Request handle method, return code to frontend
    // Automatic send exception object to parameter list
    @ExceptionHandler({ServiceException.class, FileUploadException.class}) // handle all Exceptions (set code, and message)
    public JsonResult<Void> handleException(Throwable e){
        JsonResult<Void> result = new JsonResult<>(e);
        if(e instanceof EmailDuplicatedException){
            result.setState(4000);
            result.setMessage("Email is already exist!");
        } else if(e instanceof UserNotFoundException){
            result.setState(4001);
            result.setMessage("Email Not Found!");
        } else if(e instanceof PasswordNotMatchException){
            result.setState(4002);
            result.setMessage("Password Not Match!");
        } else if (e instanceof AccessDeniedException) {
            result.setState(4005);
        } else if (e instanceof SessionNotFoundException){
            result.setState(3000);
        }
        return result;
    }

    protected final Integer getUidFromSession(HttpSession session){
        return Integer.valueOf(session.getAttribute("uid").toString());
    }

    protected final String getEmailFromSession(HttpSession session){
        return session.getAttribute("email").toString();
    }

}
