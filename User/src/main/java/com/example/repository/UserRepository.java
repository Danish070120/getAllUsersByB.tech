package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	@Query("select u from User u where u.department.id=:id ")
	List<User> findByDepartmentDepartId(int id);

	@Query("select u from User u join  u.qualifications q join q.category c where c.categoryId=:categoryId ")
	List<User> getByQualificationsCategoryId(int categoryId);

	@Query("select u from User u join  u.qualifications q where q.qualiName=:qualiName")
	List<User> getByQualificationsQualiName(@Param("qualiName") String qualiName);

}
