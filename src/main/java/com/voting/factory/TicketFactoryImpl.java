package com.voting.factory;

import com.voting.factory.inter.TicketFactory;
import com.voting.inter.Ticket;

/**
 * 票务工厂的实现
 * Created by yaguang.wang
 * on 2017/4/4.
 */
public class TicketFactoryImpl implements TicketFactory{

    private boolean over = false;

    private Integer outputSun;

    @Override
    public Ticket productionTicket() {
        return null;
    }

    @Override
    public boolean checkOver() {
        return false;
    }
}
