package nju.edu.util;

import nju.edu.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 * Created by xiaoJun on 2018/2/28.
 */
public class HibernateUtil {

    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory(){
        try {
            Configuration config;
            ServiceRegistry serviceRegistry;
            config = new Configuration().configure();
            config.addAnnotatedClass(User.class);
            serviceRegistry =new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
            sessionFactory=config.buildSessionFactory(serviceRegistry);
            return sessionFactory;
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    public static Session getSession(){
        return getSessionFactory().getCurrentSession();
    }
}
