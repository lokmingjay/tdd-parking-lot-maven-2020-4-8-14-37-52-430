package com.oocl;

public class TicketNotProvidedException extends RuntimeException {

    public TicketNotProvidedException() {
        super("Please provide your parking ticket.");
    }
}
