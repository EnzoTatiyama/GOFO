package System;

import System.Administrator;
import System.Playground;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Scanner;
import UI.SystemUI;

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

    
}
