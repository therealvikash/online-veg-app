package com.vegetable.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vegetable.app.vo.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {
}
