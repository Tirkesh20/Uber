package DAO;

import entities.Account;
import exceptions.DaoException;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public abstract class DAO<T> {
    public Connection connection = ConnectionBuilder.getConnection();

    public abstract void delete() throws DaoException;

    public abstract void deleteById(int id) throws DaoException, SQLException;

    public abstract void insert(T entity) throws DaoException;

    public abstract void update(T entity) throws DaoException;

    public T check(String username, String password) throws DaoException {
        return null;
    };
    public abstract List<T> select() throws DaoException;

    public abstract T selectById(int id) throws DaoException;


}

