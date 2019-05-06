package org.bistu.course.domain;

import java.util.Date;
import javax.persistence.*;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class User {
    @Id
    private Long id;

    //name="username" 设置userName属性映射到数据库的username字段，而不是默认的user_name
    @Column(name = "username", nullable = true)
    private String userName;

    @Column(nullable = true)
    private int age;

    @Column(nullable = true)
    private String sex;
    
    /**
     * 创建时间
     */
    @CreatedDate
    @Column(name = "create_time",updatable = false, nullable = false)
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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
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

	public static User of(User entity) {
//		User user = new User();
//		entity.setId(user.getId());
//		entity.setAge(user.getAge());
//		entity.setUserName(user.getUserName());
//		entity.setSex(user.getSex());
//		entity.setCreateTime(user.getCreateTime());
//		entity.setUpdateTime(user.getUpdateTime());
		
		return entity;
	}

}
