package Tests;

import com.company.AreaType;
import com.company.Family;
import com.company.Taxes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TaxTests {
    Taxes taxes;
    Family family;

    @BeforeEach
    void init1(){taxes = new Taxes(2,3,4,5, AreaType.EAST);}
    @BeforeEach
    void init2(){family = new Family("Georgievi",3);}

    @Test
    public void taxFamilyTest(){
        assertEquals(1,taxes.getTaxedFamily());
        assertEquals(0, taxes.getListOfFamiliesPayedTaxes().size());
    }
    @Test
    public void taxFamilyTestFail(){
        taxes.taxFamily(family);
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> taxes.taxFamily(family));
        assertEquals("The family is already taxed!", exception.getMessage());
    }
    @Test
    public void checkIfFamilyPayedTaxesTest(){
        assertEquals(1, taxes.getNotTaxedFamily());
        assertEquals(0, taxes.getListOfFamiliesThatOweTaxes().size());
    }
    @Test
    public void checkIfFamilyPayedTaxesFail(){
        taxes.taxFamily(family);
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> taxes.checkIfFamilyPayedTaxes(family));
        assertEquals("This family has payed all taxes!", exception.getMessage());
    }

}
