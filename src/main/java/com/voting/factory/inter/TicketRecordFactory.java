package com.voting.factory.inter;

import com.voting.inter.TicketRecord;

/**
 * Created by yaguang.wang
 * on 2017/4/4.
 */
public interface TicketRecordFactory {

    TicketRecord productionTicketRecord();

    boolean checkOver();
}
