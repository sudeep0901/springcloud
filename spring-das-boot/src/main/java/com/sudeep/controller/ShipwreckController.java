package com.sudeep.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sudeep.model.Shipwreck;
import com.sudeep.repository.ShipwreckRepository;

@RestController
@RequestMapping("/api/v1")
public class ShipwreckController {

	@Autowired
	private ShipwreckRepository shipwreckRepository;

	@RequestMapping(value = "shipwrecks", method = RequestMethod.GET)
	public List<Shipwreck> list() {

//		return ShipwreckStub.list();

		return shipwreckRepository.findAll();
	}

	@RequestMapping(value = "shipwrecks", method = RequestMethod.POST)
	public Shipwreck create(@RequestBody Shipwreck shipwreck) {

		return shipwreckRepository.saveAndFlush(shipwreck);
	}

	@RequestMapping(value = "shipwrecks", method = RequestMethod.PUT)
	public Optional<Shipwreck> update(@PathVariable Long id, @RequestBody Shipwreck shipwreck) {
		Optional<Shipwreck> existingShipwreck = shipwreckRepository.findById(id);
		BeanUtils.copyProperties(shipwreck, existingShipwreck);
//		return shipwreckRepository.saveAndFlush(existingShipwreck);
	return null;	 
	}

	@RequestMapping(value = "shipwrecks/{id}", method = RequestMethod.GET)
	public Optional<Shipwreck> get(@PathVariable Long id) {

		return shipwreckRepository.findById(id);

	}

	@RequestMapping(value = "shipwrecks", method = RequestMethod.DELETE)
	public Optional<Shipwreck> delete(@PathVariable Long id) {

		Optional<Shipwreck> existingShipwreck = shipwreckRepository.findById(id);

		shipwreckRepository.deleteById(id);

		return existingShipwreck;
	}

}
