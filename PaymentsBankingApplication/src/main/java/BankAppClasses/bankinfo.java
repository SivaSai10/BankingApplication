package BankAppClasses;

public class bankinfo {

	String BankAccnum;
	String BankName;
	int AcctypeId;
	String BankIFSCcode;
	int userId;
	double CurrAccBal;
	int pin;
	public int getPin() {
		return pin;
	}
	public void setPin(int pin) {
		this.pin = pin;
	}
	public String getBankAccnum() {
		return BankAccnum;
	}
	public void setBankAccnum(String bankAccnum) {
		BankAccnum = bankAccnum;
	}
	public String getBankName() {
		return BankName;
	}
	public void setBankName(String bankName) {
		BankName = bankName;
	}
	public int getAcctypeId() {
		return AcctypeId;
	}
	public void setAcctypeId(int acctypeId) {
		AcctypeId = acctypeId;
	}
	public String getBankIFSCcode() {
		return BankIFSCcode;
	}
	public void setBankIFSCcode(String bankIFSCcode) {
		BankIFSCcode = bankIFSCcode;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public double getCurrAccBal() {
		return CurrAccBal;
	}
	public void setCurrAccBal(double currAccBal) {
		CurrAccBal = currAccBal;
	}

}
