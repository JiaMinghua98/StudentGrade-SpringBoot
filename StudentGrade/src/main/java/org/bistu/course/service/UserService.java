package org.bistu.course.service;

import java.util.List;
import org.bistu.course.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {
    /**
     * 获取所有
     *
     * @return
     */
	public List<User> testTransaction();
	/**
	 * 以分页的方式展示数据
	 * @param pageable
	 * @return
	 */
	public Page<User> getAll(Pageable pageable); 
	
    //public List<User> getUserList();
    /**
     * 根据id获取
     *
     * @param id
     * @return
     */
    public User findUserById(long id);

    /**
     * 新增
     *
     * @param user
     */
    public void save(User user);

    /**
     * 修改
     *
     * @param user
     */
    public void edit(User user);

    /**
     * 删除
     *
     * @param id
     */
    public void delete(long id);


}
