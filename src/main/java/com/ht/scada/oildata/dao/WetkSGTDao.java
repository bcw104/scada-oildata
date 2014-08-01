package com.ht.scada.oildata.dao;

import org.sql2o.Sql2o;

public interface WetkSGTDao {
    Sql2o getSql2o();
    void setSql2o(Sql2o sql2o);
}
