package cn.blake.shoa.dao.base;

import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

/**
 * 
 * @author Blake.Zhou
 * @see Dao interface(common)
 * @param <T>
 */
public interface BaseDao<T> {
	/**
	 * @see 得到T代表的所有的实体对象
	 * @return
	 */
	public  Collection<T> getAllEntry(Class<T> entityClass);

	/**
	 * @see Serializable该类型可以接受所有的基本类型和String类型
	 * @param id
	 * @return
	 */
	public T getEntryById(Serializable id,Class<T> entityClass);

	public void saveEntry(T t);

	public void deleteEntry(Serializable id,Class<T> entityClass);

	public void updateEntry(T t);
	
	/**idType example:uid,rid...*/
	public Set<T> getEntrysByIDS(String idType,String ids,Class<T> entityClass);
	
	/**idType example:uid,rid...*/
	public Set<T> getEntrysByIDS(String idType,Object[] ids,Class<T> entityClass);

}
