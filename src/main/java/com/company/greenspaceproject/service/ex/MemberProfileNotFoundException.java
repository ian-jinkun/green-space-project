package com.company.greenspaceproject.service.ex;

public class MemberProfileNotFoundException extends ServiceException{
    public MemberProfileNotFoundException() {
        super();
    }

    public MemberProfileNotFoundException(String message) {
        super(message);
    }

    public MemberProfileNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public MemberProfileNotFoundException(Throwable cause) {
        super(cause);
    }

    protected MemberProfileNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
