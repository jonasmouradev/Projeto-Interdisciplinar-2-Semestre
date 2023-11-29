
package unittest;

import DAO.Room;
import DTO.RoomDB;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class RoomTest {
    
    public RoomTest() {
    }
    
    @Test
    public void calculateTugTueLamp(){
        Room room1 = new Room(),room2 = new Room(),room3 = new Room();
        RoomDB test = new RoomDB();
        
        room1.setType("1");
        room1.setArea(25);
        room1.setPerimeter(20);
        int expectedTUG1 = 4;
        int expectedLamp1 = 5;
        test.calculatorTugLampDB(room1);
        assertEquals(expectedTUG1, room1.getTotTUG());
        assertEquals(expectedLamp1, room1.getTotLamp());
        
        room2.setType("2");
        room2.setArea(16);
        room2.setPerimeter(16);
        int expectedTUG2 = 5;
        int expectedLamp2 = 3;
        test.calculatorTugLampDB(room2);
        assertEquals(expectedTUG2, room2.getTotTUG());
        assertEquals(expectedLamp2, room2.getTotLamp());
        
        room3.setType("3");
        room3.setArea(36);
        room3.setPerimeter(24);
        int expectedTUG3 = 1;
        int expectedLamp3 = 8;
        test.calculatorTugLampDB(room3);
        assertEquals(expectedTUG3, room3.getTotTUG());
        assertEquals(expectedLamp3, room3.getTotLamp());
    }
}
