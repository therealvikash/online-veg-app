package com.vegetable.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vegetable.app.dao.IVegetableDTORepo;
import com.vegetable.app.exception.CategoryNotFoundExcetion;
import com.vegetable.app.exception.NameNotFoundException;
import com.vegetable.app.exception.VegetableNotFoundException;
import com.vegetable.app.vo.VegetableDTO;

@Service
public class VegetableDTOServiceImpl implements IVegetableDTOService {

	@Autowired
	private IVegetableDTORepo iVegetableDTORepo;

	@Override
	public VegetableDTO addVegetable(VegetableDTO dto) {
		// TODO Auto-generated method stub
		VegetableDTO saveVegetable = iVegetableDTORepo.save(dto);
		return saveVegetable;
	}

	@Override
	public void removeVegetable(Integer vid) throws VegetableNotFoundException {
		Optional<VegetableDTO> opt = iVegetableDTORepo.findById(vid);
		if (opt.isPresent()) {
			iVegetableDTORepo.deleteById(vid);
		} else {
			throw new VegetableNotFoundException("Vegetable with Given ID:" + vid + "Not Available");
		}

		// TODO Auto-generated method stub

	}

	@Override
	public VegetableDTO viewVegetable(Integer vid) throws VegetableNotFoundException {
		// TODO Auto-generated method stub
		Optional<VegetableDTO> opt = iVegetableDTORepo.findById(vid);
		if (opt.isPresent()) {
			VegetableDTO vegetable = opt.get();
			return vegetable;
		} else {
			throw new VegetableNotFoundException("Vegetable with Given ID:" + vid + "Not Available");
		}

	}

	@Override
	public List<VegetableDTO> viewAllVegetables() {
		// TODO Auto-generated method stub
		List<VegetableDTO> viewVeg = iVegetableDTORepo.findAll();
		return viewVeg;
	}

	@Override
	public VegetableDTO updateVegetable(Integer vid, VegetableDTO dto) {
		// TODO Auto-generated method stub

		Optional<VegetableDTO> opt = iVegetableDTORepo.findById(vid);
		if (opt.isPresent()) {
			VegetableDTO veget1 = opt.get();
			veget1.setCategory(dto.getCategory());
			veget1.setName(dto.getName());
			veget1.setPrice(dto.getPrice());
			veget1.setQuantity(dto.getQuantity());
			veget1.setType(dto.getType());
			return iVegetableDTORepo.save(veget1);
		} else {
			return iVegetableDTORepo.save(dto);
		}

	}

	@Override
	public List<VegetableDTO> viewVegetableList(String category) throws CategoryNotFoundExcetion {
		return iVegetableDTORepo.find(category);

	}

	public List<VegetableDTO> viewVegetableByName(String name) throws NameNotFoundException {
		// TODO Auto-generated method stub
		return iVegetableDTORepo.findByName(name);

	}

}
