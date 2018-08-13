package user;

public class DrivePID extends BasicPID{
	
	double valMin, valMax;
	public DrivePID(double P, double I, double D, double valMin, double valMax) {
		super(P, I, D);
		this.valMin = valMin;
		this.valMax = valMax;
	}
	public double getValMin() {
		return valMin;
	}
	public void setValMin(double valMin) {
		this.valMin = valMin;
	}
	public double getValMax() {
		return valMax;
	}
	public void setValMax(double valMax) {
		this.valMax = valMax;
	}
	public double getPower(double currentValue) {
		return 0;
	}
}
