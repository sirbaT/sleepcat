package com.voting.factory;

import com.voting.TicketImpl;
import com.voting.factory.inter.TicketFactory;
import com.voting.inter.Ticket;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 票务工厂的实现
 * Created by yaguang.wang
 * on 2017/4/4.
 */
public class TicketFactoryImpl implements TicketFactory {

    private boolean over = false;
    private Integer outputSun;
    private ReadWriteLock lock = new ReentrantReadWriteLock();

    @Override
    public Ticket productionTicket() {
        lock.readLock().lock();
        if (checkOver()) {
            return null;
        }
        lock.readLock().unlock();
        lock.writeLock().lock();
        if (--outputSun == 0) {
            over = true;
        }
        lock.writeLock().unlock();
        return new TicketImpl();
    }

    @Override
    public boolean checkOver() {
        return over;
    }
}
