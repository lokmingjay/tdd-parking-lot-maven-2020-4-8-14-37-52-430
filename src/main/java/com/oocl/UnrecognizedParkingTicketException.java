package com.oocl;

public class UnrecognizedParkingTicketException extends RuntimeException {

    private static final String message = "Unrecognized parking ticket.";

    public UnrecognizedParkingTicketException() {
    super(message);
    }
}
