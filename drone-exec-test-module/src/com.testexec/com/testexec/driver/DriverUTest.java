package com.testexec.driver;

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
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;
import java.util.OptionalDouble;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
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

		when(realServiceMock.getPositionByCoordinate(Mockito.anyDouble(), Mockito.anyDouble())).thenReturn(POSITION);
		when(realServiceMock.getAdjacent(Mockito.anyString(), Mockito.anyString())).thenReturn(POSITION);

		String[] result = this.realDriver.getUrbanizations(OptionalDouble.of(X), OptionalDouble.of(Y), Optional.of(RANGE));

		Assert.assertNotNull(result);
	}

	@Test
	public void shouldBeOkWhenCallToGetUrbanizationsWithSimulatedService() {

		when(simulatedServiceMock.getPositionByCoordinate(Mockito.anyDouble(), Mockito.anyDouble())).thenReturn(POSITION);
		when(simulatedServiceMock.getAdjacent(Mockito.anyString(), Mockito.anyString())).thenReturn(POSITION);

		String[] result = this.simulatedDriver.getUrbanizations(OptionalDouble.of(X), OptionalDouble.of(Y), Optional.of(RANGE));

		Assert.assertNotNull(result);
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
		when(realServiceMock.getAdjacent(Mockito.anyString(), Mockito.anyString())).thenReturn(POSITION);
		String result = this.realDriver.getAdjacent("13", Directions.RIGHT);
		Assert.assertEquals(POSITION, result);
	}

	@Test
	public void shouldBeOkWhenCallToGetAdjacentWithSimulatedService() {
		when(simulatedServiceMock.getAdjacent(Mockito.anyString(), Mockito.anyString())).thenReturn(POSITION);
		String result = this.simulatedDriver.getAdjacent("13", Directions.RIGHT);
		Assert.assertEquals(POSITION, result);
	}

	@Test
	public void shouldBeOkWhenCallToGetUrbanizationIdWithRealService() {
		when(realServiceMock.getPositionByCoordinate(Mockito.anyDouble(), Mockito.anyDouble())).thenReturn(POSITION);
		String result = this.realDriver.getUrbanizationId(X, Y);
		Assert.assertEquals(POSITION, result);
	}

	@Test
	public void shouldBeOkWhenCallToGetUrbanizationIdWithSimulatedService() {
		when(simulatedServiceMock.getPositionByCoordinate(Mockito.anyDouble(), Mockito.anyDouble())).thenReturn(POSITION);
		String result = this.simulatedDriver.getUrbanizationId(X, Y);
		Assert.assertEquals(POSITION, result);
	}

}
