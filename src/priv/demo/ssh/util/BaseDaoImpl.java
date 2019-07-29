package priv.demo.ssh.util;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
/**
 * basedao实现类
 * @author 焦计划
 * @date 2019年7月26日  上午12:11:29 
 * @param <T>
 */
public abstract class BaseDaoImpl<T> implements BaseDao<T> {
	private Class<T> entityClass;
	protected SessionFactory sessionFactory;
	
	
	public BaseDaoImpl() {
		//当BaseDaoImpl<T>被继承时，使用该代码可以获取T的类型
		ParameterizedType pt = (ParameterizedType)this.getClass().getGenericSuperclass();
		entityClass = (Class<T>) pt.getActualTypeArguments()[0];
	}

	@Override
	public void save(T instance) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.save(instance);

	}

	@Override
	public void delete(T instance) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.delete(instance);

	}

	@Override
	public void deletyById(Serializable id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		T instance = session.get(entityClass, id);
		session.delete(instance);

	}

	@Override
	public void update(T instance) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.update(instance);

	}

	@Override
	public T findById(Serializable id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		return session.get(entityClass, id);
	}

	@Override
	public List<T> findAll() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("from "+ entityClass.getSimpleName()).list();
	}

	@Override
	public Object findByHql(String hql, Object... paras) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(hql);
		for(int i=0; i<paras.length; i++) {
			query.setParameter(i, paras[i]);
		}
		return query.uniqueResult();
	}

	@Override
	public List<T> findByPage(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from "+entityClass.getSimpleName());
		query.setMaxResults(pageSize);
		query.setFirstResult((pageNo-1)*pageSize);
		return query.list();
	}
	
	@Override
	public int getTotalCount() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		String sql = "select count(*) from "+entityClass.getSimpleName().toLowerCase();
		Query query = session.createSQLQuery(sql);
		return (int) query.uniqueResult();
	}


}
