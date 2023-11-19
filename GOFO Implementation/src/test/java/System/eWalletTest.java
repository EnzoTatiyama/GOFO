package System;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author enzotatiyama
 */
public class eWalletTest {
    
    
    @Test
    public void testGetInstance() {
        eWallet wallet = new eWallet();
        assertEquals(eWallet.class, wallet.getClass());
    }

    @Test
    public void testSetAndBalanceWithIntInput() {
        eWallet wallet = new eWallet();
        wallet.setBalance(100);
        assertEquals(100, wallet.getBalance());
    }

    @Test
    public void testDeposit() {
        eWallet wallet = new eWallet();
        wallet.setBalance(100);
        wallet.deposit(10);
        assertEquals(110, wallet.getBalance());
    }

    @Test
    public void testWithdraw() {
        eWallet wallet = new eWallet();
        wallet.setBalance(100);
        wallet.withdraw(10);
        assertEquals(90, wallet.getBalance());
    }
    
}
