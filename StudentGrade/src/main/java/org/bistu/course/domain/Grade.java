package org.bistu.course.domain;

import java.util.Date;
import javax.persistence.*;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/** 
* @author jmh
* @version 2019年4月23日 上午9:51:12 
*/
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Grade {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

	@Column(nullable = false)
    private String studentID;
    
    @Column(name = "coursename", nullable = true, unique = true)
    private String courseName;
    
    @Column(nullable = true)
    private int grade;
    
    /**
     * 创建时间
     */
    @CreatedDate
    @Column(name = "create_time",updatable = false)
    private Date createTime;

    /**
     * 修改时间
     */
    @UpdateTimestamp
    @Column(nullable = false)
    private Date updateTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStudentID() {
		return studentID;
	}

	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public static Grade of(Grade entity) {
		return entity;
	}
	
}
