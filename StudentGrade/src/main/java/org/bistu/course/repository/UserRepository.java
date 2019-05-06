package org.bistu.course.repository;


import org.bistu.course.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
public interface UserRepository extends JpaRepository<User,Long>{

    User findById(long id);
    void deleteById(Long id);
}
