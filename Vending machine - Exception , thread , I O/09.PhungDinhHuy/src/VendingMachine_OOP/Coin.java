package VendingMachine_OOP;

public class Coin {

	enum ClassifyCoin {
		PENNY(1), NICKLE(2), DIME(3), QUARTER(4);

		private int value;

		private ClassifyCoin(int value) {
			this.value = value;
		}
	}

	int denomination;

	public int getDenomination() {
		return denomination;
	}

}
