package ar.fiuba.tdd.tp2;

import ar.fiuba.tdd.tp2.exceptions.CashierCanNotCloseCashRegisterException;
import ar.fiuba.tdd.tp2.exceptions.CashierCanNotOpenCashRegisterException;

public class Cashier extends Role {

	@Override
	public void canOpen() {
		throw new CashierCanNotOpenCashRegisterException();
	}

	@Override
	public void canClose() {
		throw new CashierCanNotCloseCashRegisterException();
	}

	public Boolean isCashier() {
		return true;
	}
}
