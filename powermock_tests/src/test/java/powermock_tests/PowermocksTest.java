package powermock_tests;

import static org.mockito.Mockito.when;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import powermock_tests.Powermocks.SystemUnderTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//steps when mocking a static method:
	//1) use a specific runner
	//2) initialize the class containing the static method:  UtilityClass.class
	//3) mock the methods 

// 1)use a specific runner:
@RunWith(PowerMockRunner.class)

//2a) Prepare Initialization of class containing static methods:
@PrepareForTest(UtilityClass.class)

public class PowermocksTest {
	
	@Rule
	public MockitoRule mockitoRule = MockitoJUnit.rule();
	
	@Mock
	Dependency dependency;
	
	@InjectMocks
	SystemUnderTest systemUnderTest; 
	
	@Captor
	ArgumentCaptor<String>stringArgumentCaptor;
	
		
	@Test
	public void testRetrieveTodosRelatedToSpringTest_withMock() {


		List<Integer>stats = Arrays.asList(1,2,3);

		when(dependency.retrieveAllStats()).thenReturn(stats);
		
		//2b) Initialize class containing static methods:
		PowerMockito.mockStatic(UtilityClass.class);
		 
		when(UtilityClass.staticMethod(6)).thenReturn(150);

		systemUnderTest.methodCallingAStaticMethod();
	}

}
