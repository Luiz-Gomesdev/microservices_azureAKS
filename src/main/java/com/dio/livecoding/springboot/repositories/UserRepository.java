package com.dio.livecoding.springboot.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dio.livecoding.springboot.model.UserModel;

@Repository
public interface UserRepository extends CrudRepository<UserModel, Long> {

}