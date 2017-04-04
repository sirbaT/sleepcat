package com.voting.inter;

/**
 * Created by yaguang.wang
 * on 2017/4/4.
 */
public interface Voter {

    boolean joinTicketRecord(TicketRecord record);

    boolean quitTicketRecord(TicketRecord record);

    boolean voteRecord(TicketRecord record);

    boolean restitutionTicket(TicketRecord record);

    boolean checkResidueTicketOver();
}
