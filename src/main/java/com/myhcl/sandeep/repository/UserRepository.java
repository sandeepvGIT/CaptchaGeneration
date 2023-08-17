package com.myhcl.sandeep.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myhcl.sandeep.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
