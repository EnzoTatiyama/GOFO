package System;

import System.Administrator;
import System.Playground;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class AdministratorTest {

    @Test
    public void testApprovePlayground() {
        Administrator admin = new Administrator();
        Playground playground = new Playground();
        playground.setName("Playground Teste");
        playground.setOwner("Proprietário Teste");
        admin.playgroundRequests(playground);

        ArrayList<Playground> approvedList = Administrator.Approved;
        approvedList.add(playground);
        assertEquals(1, approvedList.size());
        assertTrue(approvedList.contains(playground));
    }

    @Test
    public void testSearchByName() {
        Administrator admin = new Administrator();
        Playground playground = new Playground();
        playground.setName("Playground de Teste");
        playground.setOwner("Dono de Teste");
        admin.Approved.add(playground);

        admin.searchByName("Playground de Teste");
        
    }

    @Test
    public void testBookByName() {
        Administrator admin = new Administrator();
        Playground playground = new Playground();
        playground.setName("Playground para Reserva");
        playground.setOwner("Proprietário para Reserva");
        admin.Approved.add(playground);

       
        assertEquals(1, admin.Approved.size());
        
    }

    @Test
    public void testGetApproved() {
        Administrator admin = new Administrator();
        Playground playground = new Playground();
        playground.setName("Playground para Reserva");
        playground.setOwner("Proprietário para Reserva");
        admin.Approved.add(playground);

        admin.getApproved();
    }
    
    @Test
    public void testAppPlayground() {
        String simulatedInputOption = "yes";

        InputStream in = new ByteArrayInputStream(simulatedInputOption.getBytes());
        System.setIn(in);
        
        Administrator admin = new Administrator();
        Playground playground = new Playground();
        playground.setName("Playground para Reserva");
        playground.setOwner("Proprietário para Reserva");
        admin.Approved.add(playground);
        admin.Requested.add(playground);
        
        admin.approvePlayground();
        assertEquals(2, admin.Approved.size());
        assertEquals(0, admin.Requested.size());
    }
    
    @Test
    public void testSuspendPlayground() {
        String simulatedInputOption = "t\nyes";

        InputStream in = new ByteArrayInputStream(simulatedInputOption.getBytes());
        System.setIn(in);
        
        Administrator admin = new Administrator();
        Playground playground = new Playground();
        playground.setName("Playground para Reserva");
        playground.setOwner("Proprietário para Reserva");
        admin.Approved.add(playground);
        
        admin.suspendPlayground(playground.getName());
        assertEquals(0, admin.Approved.size());
        assertEquals(1, admin.suspended.size());
    }
            
    @Test
    public void testUnSuspendPlayground() {
        String simulatedInputOption = "t\nyes";

        InputStream in = new ByteArrayInputStream(simulatedInputOption.getBytes());
        System.setIn(in);
        
        Administrator admin = new Administrator();
        Playground playground = new Playground();
        playground.setName("Playground para Reserva");
        playground.setOwner("Proprietário para Reserva");
        admin.Approved.add(playground);
        admin.suspended.add(playground);
        
        admin.unSuspendPlayground();
        assertEquals(2, admin.Approved.size());
        assertEquals(0, admin.suspended.size());
    }
    
    @Test
    public void testDeletePlayground() {
        Administrator admin = new Administrator();
        Playground playground = new Playground();
        playground.setName("Playground para Reserva");
        playground.setOwner("Proprietário para Reserva");
        admin.Approved.add(playground);
        
        admin.deletePlayground(playground.getName());
        assertEquals(0, admin.Approved.size());
    }
            
    @Test
    public void testBkByName() {
        String simulatedInputOption = "10\n10\n0";

        InputStream in = new ByteArrayInputStream(simulatedInputOption.getBytes());
        System.setIn(in);
        
        Administrator admin = new Administrator();
        Playground playground = new Playground();
        playground.setName("Playground para Reserva");
        playground.setOwner("Proprietário para Reserva");
        admin.Approved.add(playground);
        
        admin.bookByName(playground.getName(), "Playground para Reserva", 20);

    }
}
