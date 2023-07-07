package com.vegetable.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.vegetable.app.vo.VegetableDTO;

@Repository
public interface IVegetableDTORepo extends JpaRepository<VegetableDTO, Integer> {

	public void deleteById(Integer vid);

	List<VegetableDTO> findAll();

	public List<VegetableDTO> findByName(String name);

	@Query("FROM VegetableDTO  WHERE category=?1")
	public List<VegetableDTO> find(@Param("category") String category);
}
