//import org.junit.jupiter.api.Assertions;

import org.example.entities.Account;
import org.example.factory.AccountFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class AccountTest {
    @Test
    @DisplayName( "Should increase balance when positive amount" )
    public void depositShouldIncreaseBalanceWhenPositiveAmount(){
            double amount = 200.00;
            double expectedValue = 196.00;
            Account acc = AccountFactory.createEmptyAccount();

            acc.deposit( amount );

        assertThat( acc.getBalance() ).isEqualTo( expectedValue );


    }

    @Test
    @DisplayName( "Should do nothing when negative amount" )
    public void depositShouldDoNothingWhenNegativeAmount(){
        double amount = -200.00;
        double expectedValue = 0.00;
        Account acc = AccountFactory.createEmptyAccount();

        acc.deposit( amount );

        assertThat( acc.getBalance() ).isGreaterThanOrEqualTo( expectedValue );


    }

    @Test
    @DisplayName( "Should clear balance when called fullwithdraw" )
    public void shouldClearBalance(){
        double initialBalance = 800.00;
        double expectedValue = 0.00;
        Account acc = AccountFactory.createAccount(initialBalance);

        Double finalBalance = acc.fullWithdraw();

        assertThat( acc.getBalance() ).isEqualTo( expectedValue );
        assertThat( finalBalance ).isEqualTo( initialBalance );



    }

    @Test
    @DisplayName( "Should decrease Balance when has sufficient Balance" )
    public void shouldDecreaseBalanceWhenHasSufficientBalance(){
        double initialBalance = 800.00;
        double expectedValue = 500.00;
        Account acc = AccountFactory.createAccount(initialBalance);

        acc.withdraw(300.00);

        assertThat( acc.getBalance() ).isEqualTo( expectedValue );

    }
    @Test
    @DisplayName( "Should throw Illegal Argument Exception when balance is less than withdraw" )
    public void shouldThrowIllegalArgumentException(){
        double initialBalance = 200.00;

        assertThatIllegalArgumentException().isThrownBy( () -> {
            Account acc = AccountFactory.createAccount(initialBalance);
            acc.withdraw(300.00);
        } );

    }

}
