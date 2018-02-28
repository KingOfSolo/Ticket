package nju.edu.dao;

/**
 * Created by xiaoJun on 2018/2/28.
 */
public interface BaseDao {

    public void flush();

    public void clear() ;

    public Object load(Class c, int id) ;

    public void save(Object bean) ;

    public void delete(Object bean) ;
}
