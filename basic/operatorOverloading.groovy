import groovy.transform.ToString

/**
 * create by
 * @author hujin 2020/9/6
 */
@ToString
class Account {
    BigDecimal balance = 0.0  // reference type default init value is null
    String type

    BigDecimal deposit(BigDecimal amount) {
        balance += amount
    }

    BigDecimal withdraw(BigDecimal amount) {
        balance -= amount
    }

    BigDecimal plus(Account account) {
        return this.balance + account.balance
    }
}

def checking = new Account(type: "Checking")
checking.deposit(100.00)
def savings = new Account(type: "Saving")
savings.deposit(50.00)

BigDecimal total = checking + savings
println total