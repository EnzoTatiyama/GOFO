package System;

import java.util.Scanner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author enzotatiyama
 */
public class eWalletTest {
    
    private eWallet wallet;
    private Scanner mockScanner;
    
    @BeforeEach
    public void setUp() {
        wallet = new eWallet();
        mockScanner = mock(Scanner.class);
        wallet.input = mockScanner;
    }
    
    @Test
    public void testGetInstance() {
        assertEquals(eWallet.class, wallet.getClass());
    }

    @Test
    public void testSetAndBalanceWithStringInput() {
        when(mockScanner.nextLine()).thenReturn("100");
        wallet.setBalance();
        assertEquals(100, wallet.getBalance());
    }

    @Test
    public void testSetAndBalanceWithIntInput() {
        wallet.setBalance(100);
        assertEquals(100, wallet.getBalance());
    }

    @Test
    public void testDeposit() {
        wallet.setBalance(100);
        wallet.deposit(10);
        assertEquals(110, wallet.getBalance());
    }

    @Test
    public void testWithdraw() {
        wallet.setBalance(100);
        wallet.withdraw(10);
        assertEquals(90, wallet.getBalance());
    }
    
}
