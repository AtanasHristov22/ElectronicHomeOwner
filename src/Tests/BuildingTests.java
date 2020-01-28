package Tests;

import com.company.*;
import org.junit.jupiter.api.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BuildingTests {

    Buildings building;
    Taxes taxes;
    Family family;
    Employee employee;

    @BeforeEach
    void init1(){taxes = new Taxes(2, 3, 4, 5, AreaType.CENTER);}
    @BeforeEach
    void init2(){building = new Buildings("Building1", 2, 5, 1000, taxes);}
    @BeforeEach
    void init3(){family = new Family ("Toshovi", 3);}
    @BeforeEach
    void init4(){employee = new Employee("Gosho","Goshev","Goshev");}

    @Test
    public void addFamilyTest(){
        int expected = 1;
        building.addFamily(family);
        assertEquals(expected, building.getRegisteredFamilies().size());
        assertEquals(2, building.getCurrentApartment());
    }

    @Test
    public void addFamilyTestFail(){
        building.setCurrentApartment(10);
        assertThrows(IllegalArgumentException.class, () -> building.addFamily(family));
    }

    @Test
    public void removeFamilyTest(){
        building.addFamily(family);
        building.removeFamily(family);
        assertEquals(1, building.getCurrentApartment());
        assertEquals(0, building.getRegisteredFamilies().size());
    }

    @Test
    public void removeFamilyTestFail(){
        assertThrows(IllegalArgumentException.class, () -> building.removeFamily(family));
    }

    @Test
    public void addEmployeeToBuildingTest(){
    building.addEmployeeToBuilding(employee);
    assertEquals(1, building.getEmployeesWorkingInTheBuilding().size());
    assertEquals(1,building.getCurrentEmployeeInBuilding());
    assertTrue(building.isServiced());
    }
    @Test
    public void addEmployeeToBuildingTestNumberOfemployeeTestFail(){
        building.setCurrentEmployeeInBuilding(6);
        Throwable exception =  assertThrows(IllegalArgumentException.class, () -> building.addEmployeeToBuilding(employee));
        assertEquals("Too many employees working in this building!", exception.getMessage());

    }
    @Test
    public void addEmployeeToBuildingTestContainsTestFail(){
        building.addEmployeeToBuilding(employee);
        Throwable exception =  assertThrows(IllegalArgumentException.class, () -> building.addEmployeeToBuilding(employee));
        assertEquals("This employee is already working in this building or in another one!", exception.getMessage());
    }

    @Test
    public void addTaxToBuildingTest(){
        int expected = 1;
        building.addTaxToBuilding(taxes);
        assertEquals(expected, building.getListOfTaxes().size());
    }
    @Test
    public void addTaxToBuildingTestFail(){
        building.addTaxToBuilding(taxes);
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> building.addTaxToBuilding(taxes));
        assertEquals("The building already has tax!", exception.getMessage());
    }
    @Test
    public void removeTaxFromBuilding(){
        building.addTaxToBuilding(taxes);
        building.removeTaxFromBuilding(taxes);
        assertEquals(0, building.getListOfTaxes().size());
    }
    @Test
    public void removeTaxFromBuildingFail(){
        Throwable exception = assertThrows(IllegalArgumentException.class, () ->building.removeTaxFromBuilding(taxes));
        assertEquals("The building has no taxes!", exception.getMessage());
    }








}
