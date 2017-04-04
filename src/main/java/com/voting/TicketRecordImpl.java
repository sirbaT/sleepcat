package com.voting;

import com.voting.inter.Ticket;
import com.voting.inter.TicketRecord;

import java.util.HashSet;
import java.util.Set;

/**
 * 机票器
 * Created by yaguang.wang
 * on 2017/4/4.
 */
public class TicketRecordImpl implements TicketRecord {

    private Set<Ticket> tickets = new HashSet<>();

    @Override
    public Integer countTicket() {
        return tickets.size();
    }

    @Override
    public boolean acquisitionTicket() {
        return false;
    }

    @Override
    public boolean restitutionTicket() {
        return false;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
