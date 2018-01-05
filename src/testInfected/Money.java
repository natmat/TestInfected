package testInfected;

public class Money {
	private int fAmount;
	private String fCurrency;

	public Money(int amount, String currency) {
		fAmount = amount;
		fCurrency = currency;
	}

	@Override
	public String toString() {
		return("amount=" + amount() + currency());
	}
	
	public int amount() {
		return fAmount;
	}

	public String currency() {
		return fCurrency;
	}
	
	public Money add(Money m) {
		return(new Money(amount() + m.amount(), currency()));
	}
	
	public boolean equals(Object o) {
		if (!(o instanceof Money)) {
			return(false);
		}
		Money m = (Money)o;
		if ((amount() == m.amount()) && (currency().equals(m.currency()))) {
			return(true);
		}
		return false;
	}
}
