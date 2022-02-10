package com.company.greenspaceproject.controller;

import com.company.greenspaceproject.service.ex.*;
import com.util.JsonResult;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpSession;

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
            result.setMessage("Email is not exist!");
        } else if(e instanceof PasswordNotMatchException) {
            result.setState(4002);
            result.setMessage("Password Not Match!");
        }else if(e instanceof EmailInvalidFormatException){
                result.setState(4003);
                result.setMessage("Invalid Email address format!");
        }else if(e instanceof EmailNullException){
            result.setState(4004);
            result.setMessage("Email is empty!");
        }else if(e instanceof PasswordNullException){
            result.setState(4005);

        } else if (e instanceof SessionNotFoundException){
            result.setState(3000);

            result.setMessage("Password is empty!");
        } else if (e instanceof ConfirmPasswordNotMatchException) {
            result.setState(4006);
            result.setMessage("Confirm password is not matched password!");
        }
        else if (e instanceof ConfirmPasswordNullException) {
            result.setState(4007);
            result.setMessage("Confirm password is empty!");
        }
        else if (e instanceof VerifyCodeNullException) {
            result.setState(4008);
            result.setMessage("Verification code is empty!");
        }
        else if (e instanceof VerifyCodeNotMatchException) {
            result.setState(4009);
            result.setMessage("Input code is not matched verification code!");
        }
        else if (e instanceof UserLockedException) {
            result.setState(4010);
            result.setMessage("Account is locked, please reset your password!");
        }
        else if (e instanceof NotSendVerifyCodeException) {
            result.setState(4011);
            result.setMessage("Please click the send button to accept the verification code!");
        }

        return result;
    }

    protected final Integer getUidFromSession(HttpSession session){
        return Integer.valueOf(session.getAttribute("uid").toString());
    }

    protected final String getEmailFromSession(HttpSession session){
        return session.getAttribute("email").toString();
    }

    protected final String getRegister(HttpSession session){
        return session.getAttribute("register").toString();
    }

    protected final String getUser(HttpSession session){
        return session.getAttribute("user").toString();
    }

    protected final String getEmail(HttpSession session){
        return session.getAttribute("email").toString();
    }

}
