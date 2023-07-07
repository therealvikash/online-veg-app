package com.vegetable.app.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vegetable.app.exception.NameNotFoundException;
import com.vegetable.app.service.IVegetableDTOService;
import com.vegetable.app.vo.VegetableDTO;

@ControllerAdvice
@Service
@RestController
@RequestMapping(value = "/vegetable")
@CrossOrigin(origins = "http://localhost:3000")
public class VegetableDTOController {
	@Autowired
	private IVegetableDTOService vgService;

	@PostMapping(value = "/add")
	public ResponseEntity<VegetableDTO> addVegetable(@RequestBody VegetableDTO dto) {
		VegetableDTO saveVeg = vgService.addVegetable(dto);
		return new ResponseEntity<VegetableDTO>(saveVeg, HttpStatus.CREATED);
	}

	@PutMapping(value = "/{vid}")
	public ResponseEntity<VegetableDTO> updateVegetable(@PathVariable Integer vid, @RequestBody VegetableDTO dto) {
		VegetableDTO dto1 = vgService.updateVegetable(vid, dto);
		return new ResponseEntity<VegetableDTO>(dto1, HttpStatus.CREATED);
	}

	@GetMapping(value = "/vid{vid}")
	public ResponseEntity<VegetableDTO> viewVegetable(@PathVariable Integer vid) {
		VegetableDTO viewVegetable = vgService.viewVegetable(vid);
		return new ResponseEntity<VegetableDTO>(viewVegetable, HttpStatus.OK);
	}

	@GetMapping(value = "/viewVegetables")
	public ResponseEntity<List<VegetableDTO>> viewVegetables() {
		List<VegetableDTO> allVegetables = vgService.viewAllVegetables();
		return new ResponseEntity<List<VegetableDTO>>(allVegetables, HttpStatus.OK);
	}

	@DeleteMapping(value = "/vid{vid}")
	public ResponseEntity<String> removeVegetable(@PathVariable Integer vid) {
		vgService.removeVegetable(vid);
		String msg = "vegetable with id:" + vid + "deleted successfully";
		return new ResponseEntity<String>(msg, HttpStatus.OK);
	}

	@GetMapping(value = "/viewVegetables/{category}")
	public ResponseEntity<List<VegetableDTO>> viewVegetableList(@PathVariable String category) {

		List<VegetableDTO> allVegetables = vgService.viewVegetableList(category);
		return new ResponseEntity<List<VegetableDTO>>(allVegetables, HttpStatus.OK);

	}

	@GetMapping(value = "/{name}")
	public ResponseEntity<List<VegetableDTO>> viewVegetableByName(@PathVariable String name) {
		try {
			List<VegetableDTO> allVegetables = vgService.viewVegetableByName(name);
			return new ResponseEntity<List<VegetableDTO>>(allVegetables, HttpStatus.OK);
		} catch (NameNotFoundException e) {
			return new ResponseEntity<List<VegetableDTO>>(HttpStatus.NOT_FOUND);
		}
	}

}
