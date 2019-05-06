package org.bistu.course.service;

import java.util.List;
import java.util.stream.Collectors;
import org.bistu.course.domain.Grade;
import org.bistu.course.repository.GradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/** 
* @author jmh
* @version 2019年4月23日 上午10:22:28 
*/
@Service
public class GradeServiceImpl implements GradeService {

	@Autowired
    private GradeRepository gradeRepository;

//	public List<Grade> getGradeList() {
//		// TODO Auto-generated method stub
//		return gradeRepository.findAll();
//		
//	}
	 @Override
	  public List<Grade> testTransaction() {
		List<Grade> grades = this.gradeRepository.findAll();
		return grades;
	}

	/**
	 * 基于分页方式查询所有的User数据.
	 * 
	 */
	@Override
	public Page<Grade> getAll(Pageable pageable) {
		Page<Grade> entities = this.gradeRepository.findAll(pageable);
		//JDK 8 Stream流式处理
		List<Grade> grades = entities.getContent().stream().map(entity -> Grade.of(entity))
				.collect(Collectors.toList());
		Page<Grade> pageProducts = new PageImpl<Grade>(grades, pageable, entities.getTotalElements());

		return pageProducts;
	}


	@Override
	public Grade findGradeById(long id) {
		// TODO Auto-generated method stub
		return gradeRepository.findById(id);
	}

	@Override
	public Grade findGradeByStudnetID(String studentID) {
		// TODO Auto-generated method stub
		return gradeRepository.findByStudentID(studentID);
	}

	@Override
	public Grade findGradeByCourseName(String courseName) {
		// TODO Auto-generated method stub
		return gradeRepository.findByCourseName(courseName);
	}

	@Override
	public void save(Grade grade) {
		// TODO Auto-generated method stub
		gradeRepository.save(grade);
	}

	@Override
	public void edit(Grade grade) {
		// TODO Auto-generated method stub
		gradeRepository.save(grade);
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		gradeRepository.deleteById(id);
	}

}
