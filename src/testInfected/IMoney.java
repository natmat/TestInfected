package testInfected;

public interface IMoney {
	public abstract IMoney add(final IMoney m);
	
	public IMoney addMoney(Money m);
	public IMoney addMoneyBag(MoneyBag mb);	
}



