package com.open.source.platform.entity;

class TicketCounter implements Runnable {
    private int ticketsAvailable = 100;

    @Override
    public void run() {
        while (ticketsAvailable > 0) {
            sellTicket();
        }
    }

    private synchronized void sellTicket() {
        if (ticketsAvailable > 0) {
            System.out.println(Thread.currentThread().getName() + " sold ticket: " + ticketsAvailable);
            ticketsAvailable--;
        }
    }
}
