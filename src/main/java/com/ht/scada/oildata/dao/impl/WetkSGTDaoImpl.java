package com.ht.scada.oildata.dao.impl;

import com.ht.scada.oildata.dao.WetkSGTDao;
import org.sql2o.Sql2o;

import javax.inject.Inject;

/**
 * Created with IntelliJ IDEA.
 * User: 陈志强
 * Date: 2014/7/10
 * Time: 19:45
 */
public class WetkSGTDaoImpl implements WetkSGTDao {

    @Inject
    private Sql2o sql2o;


    @Override
    public Sql2o getSql2o() {
        return null;
    }

    @Override
    public void setSql2o(Sql2o sql2o) {
        this.sql2o = sql2o;
    }
}
