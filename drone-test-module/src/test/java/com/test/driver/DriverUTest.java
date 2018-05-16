package com.test.driver;

import com.drone.common.Directions;
import com.drone.common.Range;
import com.drone.service.UrbanizationsTreatmentService;
import com.drone.service.UrbanizationsTreatmentServiceImpl;
import com.drone.service.UrbanizationsTreatmentSimulatedServiceImpl;
import com.drone.driver.Driver;
import com.drone.driver.DriverImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Optional;
import java.util.OptionalDouble;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class DriverUTest {

	private static final Double X = 38.56889;
	private static final Double Y = 40.511107;
	private static final Range RANGE = Range.ONE;
	private static final String POSITION = "1";
	private UrbanizationsTreatmentService realServiceMock = mock(UrbanizationsTreatmentServiceImpl.class);
	private UrbanizationsTreatmentService simulatedServiceMock = mock(UrbanizationsTreatmentSimulatedServiceImpl.class);
	private Driver realDriver;
	private Driver simulatedDriver;

	@Before
	public void setup() {
		realDriver = new DriverImpl(realServiceMock);
		simulatedDriver = new DriverImpl(simulatedServiceMock);
	}

	@Test
	public void shouldBeOkWhenCallToGetUrbanizationsWithRealService() {
		Assert.assertNotNull(callToGetUrbanizationsCommon(realServiceMock, realDriver));
	}

	@Test
	public void shouldBeOkWhenCallToGetUrbanizationsWithSimulatedService() {
		Assert.assertNotNull(callToGetUrbanizationsCommon(simulatedServiceMock, simulatedDriver));
	}

	@Test
	public void shouldBeEmptyArrayWhenCallToGetUrbanizationsWithParam1Empty() {
		String[] result = realDriver.getUrbanizations(OptionalDouble.empty(), OptionalDouble.of(Y), Optional.of(RANGE));
		Assert.assertSame(0, result.length);
	}

	@Test
	public void shouldBeEmptyArrayWhenCallToGetUrbanizationsWithParam2Empty() {
		String[] result = realDriver.getUrbanizations(OptionalDouble.of(X), OptionalDouble.empty(), Optional.of(RANGE));
		Assert.assertSame(0, result.length);
	}

	@Test
	public void shouldBeEmptyArrayWhenCallToGetUrbanizationsWithParam3Empty() {
		String[] result = realDriver.getUrbanizations(OptionalDouble.of(X), OptionalDouble.of(Y), Optional.empty());
		Assert.assertSame(0, result.length);
	}

	@Test
	public void shouldBeEmptyArrayWhenCallToGetUrbanizationsWithAllParamsEmpty() {
		String[] result = realDriver.getUrbanizations(OptionalDouble.empty(), OptionalDouble.empty(), Optional.empty());
		Assert.assertSame(0, result.length);
	}

	@Test
	public void shouldBeOkWhenCallToGetAdjacentWithRealService() {
		Assert.assertEquals(POSITION, callToGetAdjacentCommon(realServiceMock, realDriver));
	}

	@Test
	public void shouldBeOkWhenCallToGetAdjacentWithSimulatedService() {
		Assert.assertEquals(POSITION, callToGetAdjacentCommon(simulatedServiceMock, simulatedDriver));
	}

	@Test
	public void shouldBeOkWhenCallToGetUrbanizationIdWithRealService() {
		Assert.assertEquals(POSITION, callGetUrbanizationIdCommon(realServiceMock, realDriver));
	}

	@Test
	public void shouldBeOkWhenCallToGetUrbanizationIdWithSimulatedService() {
		Assert.assertEquals(POSITION, callGetUrbanizationIdCommon(simulatedServiceMock, simulatedDriver));
	}

	@Test
	public void shouldBeOkWhenCreateANewObject() {
		Driver d = new DriverImpl();
		Assert.assertNotNull(d);
	}

	public String[] callToGetUrbanizationsCommon(UrbanizationsTreatmentService service, Driver driver) {
		when(service.getPositionByCoordinate(Mockito.anyDouble(), Mockito.anyDouble())).thenReturn(POSITION);
		when(service.getAdjacent(Mockito.anyString(), Mockito.anyString())).thenReturn(POSITION);
		return driver.getUrbanizations(OptionalDouble.of(X), OptionalDouble.of(Y), Optional.of(RANGE));
	}

	public String callToGetAdjacentCommon(UrbanizationsTreatmentService service, Driver driver) {
		when(service.getAdjacent(Mockito.anyString(), Mockito.anyString())).thenReturn(POSITION);
		return driver.getAdjacent("13", Directions.RIGHT);
	}

	public String callGetUrbanizationIdCommon(UrbanizationsTreatmentService service, Driver driver) {
		when(service.getPositionByCoordinate(Mockito.anyDouble(), Mockito.anyDouble())).thenReturn(POSITION);
		return driver.getUrbanizationId(X, Y);
	}
}
