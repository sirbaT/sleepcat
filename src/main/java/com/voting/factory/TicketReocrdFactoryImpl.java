package com.voting.factory;

import com.voting.factory.inter.TicketRecordFactory;
import com.voting.inter.TicketRecord;

/**
 * Created by yaguang.wang
 * on 2017/4/4.
 */
public class TicketReocrdFactoryImpl implements TicketRecordFactory{

    private boolean over = false;

    private Integer outputSun;

    @Override
    public TicketRecord productionTicketRecord() {
        return null;
    }

    @Override
    public boolean checkOver() {
        return false;
    }
}
