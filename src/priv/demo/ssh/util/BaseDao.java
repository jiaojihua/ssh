package priv.demo.ssh.util;

import java.io.Serializable;
import java.util.List;

/**
 * dao接口工具
 * @author 焦计划
 * @date 2019年7月20日  上午7:34:53
 */
public interface BaseDao<T> {
	public void save(T instance);//增加方法
	public void delete(T instance);//删除方法
	public void deletyById(Serializable id);//删除方法2
	public void update(T instance);//更改方法
	public T findById(Serializable id);//根据id查询
	public List<T> findAll();//查找所有对象
	public Object findByHql(String hql, Object...paras);//根据hql语句查询
	public List<T> findByPage(int pageNo, int pageSize);//分页查询
	public int getTotalCount();//查询总记录数
	
}
