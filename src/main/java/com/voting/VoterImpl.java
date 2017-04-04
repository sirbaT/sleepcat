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
    public void joinTicketRecord(TicketRecord record) {
        ticketRecord.add(record);
    }

    @Override
    public void quitTicketRecord() {

    }

    @Override
    public void voteRecord() {

    }

    @Override
    public void restitutionTicket() {

    }

    @Override
    public boolean checkResidueTicketCount() {
        return false;
    }
}
