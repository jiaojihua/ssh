package priv.demo.ssh.util;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.HibernateTemplate;
/**
 * hibernateTemplate简化dao
 * @author 焦计划
 * @date 2019年7月26日  上午12:46:54 
 * @param <T>
 */
public abstract class BaseDaoImpl2<T> implements BaseDao<T> {
	private Class<T> entityClass;
	protected SessionFactory sessionFactory;
	protected HibernateTemplate hibernateTemplate;
	
	public BaseDaoImpl2() {
		//当BaseDaoImpl<T>被继承时，使用该代码可以获取T的类型
		ParameterizedType pt = (ParameterizedType)this.getClass().getGenericSuperclass();
		entityClass = (Class<T>) pt.getActualTypeArguments()[0];
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Override
	public void save(T instance) {
		// TODO Auto-generated method stub
		this.hibernateTemplate.save(instance);
	}

	@Override
	public void delete(T instance) {
		// TODO Auto-generated method stub
		this.hibernateTemplate.delete(instance);
	}

	@Override
	public void deletyById(Serializable id) {
		// TODO Auto-generated method stub
		T instance = this.hibernateTemplate.get(entityClass, id);
		this.hibernateTemplate.delete(instance);
	}

	@Override
	public void update(T instance) {
		// TODO Auto-generated method stub
		this.hibernateTemplate.update(instance);
	}

	@Override
	public T findById(Serializable id) {
		// TODO Auto-generated method stub
		return this.hibernateTemplate.get(entityClass, id);
	}

	@Override
	public List<T> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object findByHql(String hql, Object... paras) {
		// TODO Auto-generated method stub
		Object o = hibernateTemplate.execute(new HibernateCallback() {

			@Override
			public Object doInHibernate(Session session) throws HibernateException {
				// TODO Auto-generated method stub
				Query query = session.createQuery(hql);
				if(paras != null &&paras.length != 0) {
					for(int i=0; i<paras.length; i++) {
						query.setParameter(i, paras[i]);
					}
				}
				return query.list();
			}
			
		});
		return o;
	}

	@Override
	public List<T> findByPage(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

}
