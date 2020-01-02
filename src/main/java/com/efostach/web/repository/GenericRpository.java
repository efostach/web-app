package com.efostach.clientserver.repository;

import java.sql.SQLException;
import java.util.List;

public interface GenericRpository<T, ID> {

    T getById(ID id) throws SQLException;

    List<T> getAll() throws SQLException;

    void create(T t) throws SQLException;

    void update(T t) throws SQLException;

    void delete(T t) throws SQLException;
}
