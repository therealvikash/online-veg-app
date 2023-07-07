package com.vegetable.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vegetable.app.vo.Order;

@Repository
public interface IOrderRepository extends JpaRepository<Order, Integer> {

}
