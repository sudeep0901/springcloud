package com.sudeep;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sudeep.model.Shipwreck;
import com.sudeep.repository.ShipwreckRepository;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ShipwreckWebIntegrationTest {

	@Autowired
	private ShipwreckRepository shipwreckRepository;

	@Test
	public void testAll() {
		List<Shipwreck> wrecks = shipwreckRepository.findAll();

		assertThat(wrecks.size(), is(greaterThanOrEqualTo(0)));
	}

}
