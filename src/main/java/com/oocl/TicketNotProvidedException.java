package com.oocl;

public class TicketNotProvidedException extends RuntimeException {

    private static final String message = "Please provide your parking ticket.";

    public TicketNotProvidedException() {
        super(message);
    }
}
