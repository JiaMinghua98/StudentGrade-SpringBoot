package org.bistu.course.service;

import java.util.List;
import org.bistu.course.domain.Grade;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/** 
* @author jmh
* @version 2019年4月23日 上午10:16:30 
*/
public interface GradeService {

	  /**
     * 获取所有
     *
     * @return
     */
    //public List<Grade> getGradeList();
	public List<Grade> testTransaction();
	/**
	 * 以分页的方式展示数据
	 * @param pageable
	 * @return
	 */
	public Page<Grade> getAll(Pageable pageable); 
    /**
     * 根据id获取
     *
     * @param id
     * @return
     */
    public Grade findGradeById(long id);

    /**
     * 根据studnetID获取
     *
     * @param studnetID
     * @return
     */
    public Grade findGradeByStudnetID(String studentID);
    
    /**
     * 根据courseName获取
     *
     * @param courseName
     * @return
     */
    public Grade findGradeByCourseName(String courseName);
    
    /**
     * 新增
     *
     * @param grade
     */
    public void save(Grade grade);

    /**
     * 修改
     *
     * @param grade
     */
    public void edit(Grade grade);

    /**
     * 删除
     *
     * @param id
     */
    public void delete(long id);
}
