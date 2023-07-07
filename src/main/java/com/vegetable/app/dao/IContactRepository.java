package com.vegetable.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vegetable.app.vo.Contact;

@Repository
public interface IContactRepository extends JpaRepository<Contact, Integer> {

}
