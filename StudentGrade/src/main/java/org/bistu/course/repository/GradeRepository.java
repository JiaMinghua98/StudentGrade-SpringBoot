package org.bistu.course.repository;

import org.bistu.course.domain.Grade;
import org.springframework.data.jpa.repository.JpaRepository;

/** 
* @author jmh
* @version 2019年4月23日 上午10:23:30 
*/
public interface GradeRepository extends JpaRepository<Grade, Long> {

	Grade findById(long id);
	Grade findByStudentID(String studentID);
	Grade findByCourseName(String courseName);
    void deleteById(Long id);
}
