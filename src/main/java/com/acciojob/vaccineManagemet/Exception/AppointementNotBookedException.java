package com.acciojob.vaccineManagemet.Exception;

public class AppointementNotBookedException extends Exception {
    public AppointementNotBookedException(String notFound) {
        super(notFound);
    }
}
