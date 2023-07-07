package com.vegetable.app.service;

import java.util.List;

import com.vegetable.app.exception.CategoryNotFoundExcetion;
import com.vegetable.app.exception.NameNotFoundException;
import com.vegetable.app.vo.VegetableDTO;

public interface IVegetableDTOService {

	public VegetableDTO addVegetable(VegetableDTO dto);

	public VegetableDTO updateVegetable(Integer vid, VegetableDTO dto);

	public void removeVegetable(Integer vid);

	public VegetableDTO viewVegetable(Integer vid);

	public List<VegetableDTO> viewAllVegetables();

	public List<VegetableDTO> viewVegetableList(String category) throws CategoryNotFoundExcetion;

	public List<VegetableDTO> viewVegetableByName(String name) throws NameNotFoundException;

}
