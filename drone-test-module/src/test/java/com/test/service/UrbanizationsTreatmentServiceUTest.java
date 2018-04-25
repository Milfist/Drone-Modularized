package com.test.service;

import com.drone.service.UrbanizationsTreatmentService;
import com.drone.service.UrbanizationsTreatmentServiceImpl;
import org.junit.Test;

//import java.util.ServiceLoader;

import static org.junit.Assert.assertEquals;

public class UrbanizationsTreatmentServiceUTest {

//	private UrbanizationsTreatmentService service = ServiceLoader.load(UrbanizationsTreatmentService.class).findFirst().get();
    private UrbanizationsTreatmentService service = new UrbanizationsTreatmentServiceImpl();

	@Test
	public void shouldBeOkInGetAdjacentCallForAnythingParams() {
		String result = service.getAdjacent(null, null);
		assertEquals(null, result);
	}

	@Test
	public void shouldBeOkInGetPositionByCoordinateCallForAnythingParams() {
		String result = service.getPositionByCoordinate(null, null);
		assertEquals(null, result);
	}
}
