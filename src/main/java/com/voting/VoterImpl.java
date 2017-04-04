package com.voting;

import com.voting.inter.Ticket;
import com.voting.inter.TicketRecord;
import com.voting.inter.Voter;

import java.util.ArrayList;
import java.util.List;

/**
 * 选举人
 * Created by yaguang.wang
 * on 2017/4/4.
 */
public class VoterImpl implements Voter {

    // 投票
    private List<TicketRecord> ticketRecord = new ArrayList<>();

    // 票
    private List<Ticket> tickets;

    @Override
    public boolean joinTicketRecord(TicketRecord record) {
        return ticketRecord.add(record);
    }

    @Override
    public boolean quitTicketRecord(TicketRecord record) {
        return ticketRecord.contains(record) && ticketRecord.remove(record);
    }

    @Override
    public boolean voteRecord(TicketRecord record) {
        if(ticketRecord.contains(record)){
            //record.
        }
        return false;
    }

    @Override
    public boolean restitutionTicket(TicketRecord record) {
        return false;
    }

    @Override
    public boolean checkResidueTicketOver() {
        return false;
    }
}
