package com.voting.factory.inter;

import com.voting.inter.Ticket;

/**
 * Created by yaguang.wang
 * on 2017/4/4.
 */
public interface TicketFactory {

    Ticket productionTicket();

    boolean checkOver();
}
