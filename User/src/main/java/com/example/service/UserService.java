package com.example.service;

import java.util.List;
import java.util.Optional;

import com.example.entity.User;

public interface UserService {

	User saveUser(User user);

	List<User> fetchUserList();

	User updateUser(User user, Long id);

	Optional<User> findById(int id);

	List<User> findAllBydepartId(int id);

	List<User> fetchCategoryList();

	List<User> fetchDepartmentList();

	List<User> findAllByQualificationCategoryId(int categoryId);

	List<User> findAllByQualificationQualiName(String qualiName);



}
 