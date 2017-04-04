package com.voting.inter;

/**
 * Created by yaguang.wang
 * on 2017/4/4.
 */
public interface Voter {

    void joinTicketRecord(TicketRecord record);

    void quitTicketRecord();

    void voteRecord();

    void restitutionTicket();

    boolean checkResidueTicketCount();
}
