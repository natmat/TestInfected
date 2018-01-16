package testInfected;

public class Money implements IMoney {
	private int fAmount;
	private String fCurrency;

	public Money(int amount, String currency) {
		fAmount = amount;
		fCurrency = currency;
	}

	@Override
	public String toString() {
		return(String.valueOf(amount()) + currency());
	}

	public int amount() {
		return fAmount;
	}

	public String currency() {
		return fCurrency;
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

	public IMoney add(IMoney m) {
		return(m.addMoney(this));
	}

	@Override
	public IMoney addMoney(Money m) {
		// Add Money to this Money, or create a MoneyBag
		if (currency().equals(m.currency())) {
			return(new Money(amount() + m.amount(), currency()));
		}
		else {
			return(new MoneyBag(this, m));
		}
	}

	@Override
	public IMoney addMoneyBag(MoneyBag mb) {
		// Add this Money to MoneyBag
		return(mb.addMoney(this));
	}
}


