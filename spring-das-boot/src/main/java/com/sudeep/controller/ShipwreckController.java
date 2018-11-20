package com.sudeep.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sudeep.model.Shipwreck;

@RestController
@RequestMapping("/api/v1")
public class ShipwreckController {

	@RequestMapping(value = "shipwrecks", method = RequestMethod.GET)
	public List<Shipwreck> list() {

		return ShipwreckStub.list();
	}

	@RequestMapping(value = "shipwrecks", method = RequestMethod.POST)
	public Shipwreck create(@RequestBody Shipwreck shipwreck) {

		return ShipwreckStub.create(shipwreck);
	}

	@RequestMapping(value = "shipwrecks", method = RequestMethod.PUT)
	public Shipwreck create(@PathVariable Long id, @RequestBody Shipwreck shipwreck) {

		return ShipwreckStub.update(id, shipwreck);
	}

	@RequestMapping(value = "shipwrecks", method = RequestMethod.DELETE)
	public Shipwreck create(@PathVariable Long id) {

		return ShipwreckStub.delete(id);
	}

}
