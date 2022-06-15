package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.User;
import com.example.repository.CategoryRepository;
import com.example.repository.QualificationRepository;
import com.example.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	QualificationRepository qualificationRepository;
	@Autowired
	CategoryRepository categoryRepository;

	@Override
	public User saveUser(User user) {
		log.info("user {}", user);
		user.getQualifications().stream().forEach(qualification -> qualification.setUser(user));
		userRepository.save(user);
		// qualificationRepository.saveAll(user.getQualifications());
		// Qualification qualification = new Qualification();

		// categoryRepository.save(qualification.getCategory());
		return user;
	}

	@Override
	public List<User> fetchUserList() {
		return (List<User>) userRepository.findAll();

	}

	@Override
	public User updateUser(User user, Long id) {
		return userRepository.save(user);
	}

	@Override
	public Optional<User> findById(int id) {
		return userRepository.findById(id);
	}

	@Override
	public List<User> findAllBydepartId(int id) {
		return userRepository.findByDepartmentDepartId(id);
	}

	@Override
	public List<User> fetchCategoryList() {
		return (List<User>) userRepository.findAll();
	}

	@Override
	public List<User> fetchDepartmentList() {
		return (List<User>) userRepository.findAll();
	}

	@Override
	public List<User> findAllByQualificationCategoryId(int categoryId) {
		log.info("findAllByQualificationCategoryId");

		return userRepository.getByQualificationsCategoryId(categoryId);
	}

	@Override
	public List<User> findAllByQualificationQualiName(String qualiName) {
		// TODO Auto-generated method stub
		return userRepository.getByQualificationsQualiName(qualiName);
	}


	

}
