package com.sudeep;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.aspectj.lang.annotation.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.sudeep.controller.ShipwreckController;
import com.sudeep.model.Shipwreck;
import com.sudeep.repository.ShipwreckRepository;

public class ShipwreckControllerTest {

	// mockinto will create repository also
	@InjectMocks
	private ShipwreckController sc;

	@Mock
	private ShipwreckRepository shipwreckRepository;

	@Before(value = "")
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testShipwreckGet() {

//		Shipwreck sw = new Shipwreck();
//		sw.setId(1L);
//		when(shipwreckRepository.findById(1L)).thenReturn(Optional.of(sw));
////		when(shipwreckRepository.findById((1L)).thenReturn(Optional.of(sw)));
//		// ShipwreckController sc = new
//		// ShipwreckController();
//		Optional<Shipwreck> wreck = sc.get(1L);
//		wreck.ifPresent(existingWreck -> {
//			assertEquals(1L, existingWreck.getId().longValue());
//			// operate on existingCustomer
//		});
	}
}
