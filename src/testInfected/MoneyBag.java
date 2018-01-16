package testInfected;

import java.util.Iterator;
import java.util.Vector;

public class MoneyBag implements IMoney {
	private Vector<Money> fMonies;

	public MoneyBag(Money m1, Money m2) {
		appendMoney(m1);
		appendMoney(m2);
	}
	
	public MoneyBag(Money m) {
		this.appendMoney(m);
	}
	
	public MoneyBag(Money m, MoneyBag mb) {
		
		this.appendMoney(m);
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
		return(new MoneyBag(m, this));
	}

	@Override
	public IMoney addMoneyBag(MoneyBag mb) {
		// TODO Auto-generated method stub
		return null;
	}
}

