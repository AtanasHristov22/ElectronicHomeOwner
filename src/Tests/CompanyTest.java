package Tests;

import com.company.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CompanyTest {
    Company company;
    Employee employee;
    Buildings building;
    Taxes westTaxes;

    @BeforeEach
    void init(){westTaxes = new Taxes(2, 5, 10, 3, AreaType.WEST);}
    @BeforeEach
    void init1(){building = new Buildings("Building1", 5, 15, 60000, westTaxes);}
    @BeforeEach
    void init2(){employee = new Employee("Gosho","Goshev","Goshev");}
    @BeforeEach
    void init3(){company = new Company("KartofiOOD");}

    @Test
    public void addBuildingTest(){
        company.addBuildings(building);
        assertEquals(1,company.getListOfBuildings().size());
    }
    @Test
    public void addBuildingTestFail(){
        company.addBuildings(building);
        Throwable exception = assertThrows(IllegalArgumentException.class,() -> company.addBuildings(building));
        assertEquals("This building is already in the company!", exception.getMessage());
    }
    @Test
    public void hireEmployeeInTheCompanyTest(){
        company.hireEmployeeInTheCompany(employee);
        assertEquals(1, company.getListOfEmployees().size());
    }
    @Test
    public void hireEmployeeInTheCompanyTestFail(){
        company.hireEmployeeInTheCompany(employee);
        Throwable exception = assertThrows(IllegalArgumentException.class, ()-> company.hireEmployeeInTheCompany(employee));
        assertEquals("This employee is already in the company!", exception.getMessage());
    }
    @Test
    public void fireEmployeeFromTheCompanyTest(){
        company.hireEmployeeInTheCompany(employee);
        company.fireEmployeeFromTheCompany(employee);
        assertEquals(0, company.getListOfEmployees().size());
    }
    @Test
    public void fireEmployeeFromTheCompanyTestFail(){
        Throwable exception = assertThrows(IllegalArgumentException.class, ()-> company.fireEmployeeFromTheCompany(employee));
        assertEquals("This employee is not in the company!", exception.getMessage());
    }
}
