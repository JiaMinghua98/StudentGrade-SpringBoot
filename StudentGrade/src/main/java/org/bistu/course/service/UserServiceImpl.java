package org.bistu.course.service;


import java.util.List;
import java.util.stream.Collectors;
import org.bistu.course.domain.User;
import org.bistu.course.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Override
//    public List<User> getUserList() {
//        return userRepository.findAll();
//    } 
    public List<User> testTransaction() {
//		User entity = new User();
		
//		entity.setId(entity.getId());
//		entity.setUserName(entity.getUserName());
//		entity.setSex(entity.getSex());
//		entity.setAge(entity.getAge());
//		entity.setCreateTime(entity.getCreateTime());
//		entity.setUpdateTime(entity.getUpdateTime());
//		
//		entity = this.userRepository.save(entity);
		List<User> users = this.userRepository.findAll();
		return users;
	}

	/**
	 * 基于分页方式查询所有的User数据.
	 * 
	 */
	@Override
	public Page<User> getAll(Pageable pageable) {
		Page<User> entities = this.userRepository.findAll(pageable);

		//JDK 8 Stream流式处理
		List<User> users = entities.getContent().stream().map(entity -> User.of(entity))
				.collect(Collectors.toList());
		Page<User> pageProducts = new PageImpl<User>(users, pageable, entities.getTotalElements());

		return pageProducts;
	}

    @Override
    public User findUserById(long id) {
        return userRepository.findById(id);
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public void edit(User user) {
        userRepository.save(user);
    }

    @Override
    public void delete(long id) {
        userRepository.deleteById(id);
    }
}
