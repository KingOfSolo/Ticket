package nju.edu.daoImpl;

import nju.edu.dao.BaseDao;
import nju.edu.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Created by xiaoJun on 2018/2/28.
 */
public class BaseDaoImpl implements BaseDao{
    @Override
    public void flush() {

    }

    @Override
    public void clear() {

    }

    @Override
    public Object load(Class c, int id) {
//        try {
//            Session session = HibernateUtil.getSession();
//            Transaction tx=session.beginTransaction();
//            Object o=session.get(c, id);
//            tx.commit();
//            return o;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
        return null;
    }

    @Override
    public void save(Object bean) {

    }

    @Override
    public void delete(Object bean) {

    }
}
