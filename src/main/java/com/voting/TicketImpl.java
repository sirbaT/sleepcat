package com.voting;

import com.voting.inter.Ticket;
import com.voting.inter.Voter;

import java.util.Objects;
import java.util.UUID;

/**
 * 票
 * Created by yaguang.wang
 * on 2017/4/4.
 */

public class TicketImpl implements Ticket {
    private final String id;
    private Voter voter;

    TicketImpl() {
        id = UUID.randomUUID().toString();
    }

    public String getTicketId() {
        return id;
    }

    public Voter getVoter() {
        return voter;
    }

    public void setVoter(Voter voter) {
        this.voter = voter;
    }

    public boolean equals(Object o){
        if(this == o){
            return true;
        }
        if(o == null || !(o instanceof Ticket)){
            return false;
        }

        Ticket ticket = (Ticket) o;
        return Objects.equals(ticket.getTicketId(),this.getTicketId());
    }
}
