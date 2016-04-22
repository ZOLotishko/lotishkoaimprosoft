package com.springapp.dao.support;


import com.springapp.util.MYSQLConnection;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created on 06.04.16.
 */
public class ConnectionInvocationHandler<E> implements InvocationHandler {

    private final E target;

    public ConnectionInvocationHandler(E target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Connection connectionAnnotation = method.getAnnotation(Connection.class);

        java.sql.Connection sqlConnection = null;

        try {
            if (connectionAnnotation != null && MYSQLConnection.getCurrentConnection() == null) {
                sqlConnection = MYSQLConnection.getConnection();

                MYSQLConnection.putCurrentConnection(sqlConnection);
            }

            return method.invoke(target, args);
        } finally {
            MYSQLConnection.closeConnection(sqlConnection);
        }
    }
}
