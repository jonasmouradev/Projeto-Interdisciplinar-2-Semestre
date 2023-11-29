
package unittest;

import DAO.House;
import DTO.HouseDB;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class HouseTest {
    
    public HouseTest() {
    }
    
    @Test
    public void calculateConsumption(){
        
        
        House newHouse = new House();
        HouseDB test = new HouseDB();
        
        newHouse.setTotPower(2000);
        test.calculatorElectricChargeDB(newHouse);
        int expectedResult = 2400;
        
        assertEquals(expectedResult, newHouse.getTotCharge());
    }
    
    @Test
    public void calculateDemandFactor(){
        House newHouse = new House();
        HouseDB test = new HouseDB();
        
        newHouse.setMaximumDemand(1000);
        newHouse.setTotDemand(800);
        double expectedResult = 1.25;
        test.demandFactorCalculatorDB(newHouse);
        assertEquals((int) expectedResult, (int) newHouse.getDemandFactor());
        
    }

}
