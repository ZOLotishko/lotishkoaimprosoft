//package com.springapp.dao;
//
//
//import com.springapp.dao.impl.DepartmentDAOImpl;
//import com.springapp.dao.impl.EmployeeDAOImpl;
//import com.springapp.dao.support.ConnectionInvocationHandler;
//
//import java.lang.reflect.Proxy;
//
///**
// * Created on 06.04.16.
// */
//public class DaoFactory {
//
//    private static volatile DepartmentDAO departmentDAO;
//    private static volatile EmployeeDAO employeeDAO;
//
//    public static DepartmentDAO getDepartmentDAO() {
//        if (departmentDAO == null) {
//            synchronized (DaoFactory.class) {
//                if (departmentDAO == null) {
//
//                    departmentDAO = create(new DepartmentDAOImpl());
//
//                }
//            }
//        }
//
//        return departmentDAO;
//    }
//
//    public static EmployeeDAO getEmployeeDAO() {
//        if (employeeDAO == null) {
//            synchronized (DaoFactory.class) {
//                if (employeeDAO == null) {
//
//                    employeeDAO = create(new EmployeeDAOImpl());
//
//                }
//            }
//        }
//
//        return employeeDAO;
//    }
//
//
//    @SuppressWarnings("unchecked")
//    private static <E> E create(E target) {
//        ConnectionInvocationHandler<E> invocationHandler = new ConnectionInvocationHandler<E>(target);
//
//        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
//
//        return (E) Proxy.newProxyInstance(contextClassLoader, target.getClass().getInterfaces(), invocationHandler);
//    }
//}
