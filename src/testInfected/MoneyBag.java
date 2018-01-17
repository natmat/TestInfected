package testInfected;

import java.util.Currency;
import java.util.Iterator;
import java.util.Vector;

public class MoneyBag implements IMoney {
	private Vector<Money> fMonies;
	
	public static void main(String[] args) {
		Money m1 = new Money(1, "A");
		Money m2 = new Money(2, "B");
		
		Money bag[] = {m1, m2};
		MoneyBag mb1 = new MoneyBag(bag);

		Money m3 = new Money(3, "C");
		MoneyBag mb2 = new MoneyBag(m3, mb1);
		
		System.out.println(mb2);
	}

	public MoneyBag(Money m1, Money m2) {
		appendMoney(m1);
		appendMoney(m2);
	}
	
	public MoneyBag(Money m) {
		this.appendMoney(m);
	}
	
	public MoneyBag(Money m, MoneyBag mb) {
		fMonies = mb.fMonies;
		appendMoney(m);
	}

	public MoneyBag(final Money bag[]) {
		for (int i= 0; i < bag.length; i++) {
			appendMoney(bag[i]);
		}
	}

	private void appendMoney(final Money m) {
		if (fMonies == null) fMonies = new Vector<>();
		fMonies.add(m);
	}

	public boolean equals(Object o) {
		if (o == null) return(false);

		if (!(o instanceof MoneyBag)) return(false);

		MoneyBag mb = (MoneyBag)o;
		if (fMonies.size() != mb.fMonies.size()) return(false);

		Iterator<Money> iOther = mb.fMonies.iterator();
		Iterator<Money> iThis = fMonies.iterator();

		while (iThis.hasNext()) {
			Money mOther = (Money)iOther.next();
			Money mThis = (Money)iThis.next();

			if (((mThis.amount() != mOther.amount())
					|| !mThis.currency().equals(mOther.currency()))) {
				return(false);
			}
		}
		return(true);
	}
	
	public IMoney add(IMoney m) {
		return(m.addMoneyBag(this));
	}

	@Override
	public IMoney addMoney(Money m) {
		// Add Money to this MoneyBag
		for (Money mbm : fMonies) {
			if (mbm.currency() == m.currency()) {
				mbm.add(m);
				return(this);
			}
		}
		this.appendMoney(m);
		return(this);
	}

	@Override
	public IMoney addMoneyBag(MoneyBag mb) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public String toString() {
		String s = "MonbeyBag: ";
		for (Money m : fMonies) {
			s += m.toString() + " ";
		}
		return(s);
	}
}

