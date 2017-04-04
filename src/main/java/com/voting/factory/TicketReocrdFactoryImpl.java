package com.voting.factory;

import com.voting.TicketRecordImpl;
import com.voting.factory.inter.TicketRecordFactory;
import com.voting.inter.TicketRecord;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by yaguang.wang
 * on 2017/4/4.
 */
public class TicketReocrdFactoryImpl implements TicketRecordFactory {

    private boolean over = false;
    private Integer outputSun;
    private ReadWriteLock lock = new ReentrantReadWriteLock();

    @Override
    public TicketRecord productionTicketRecord() {
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
        return new TicketRecordImpl();
    }

    @Override
    public boolean checkOver() {
        return over;
    }
}
