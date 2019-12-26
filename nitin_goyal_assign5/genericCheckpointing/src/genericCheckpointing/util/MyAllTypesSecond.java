package genericCheckpointing.util;

public class MyAllTypesSecond extends MyAllTypesFirst{
	public double myDoubleT;
	public float myFloatT;
	public short myShortT;
	public char myCharT;
	public double myOtherDoubleT;
	
	
	public MyAllTypesSecond()
	{
		super();
		myDoubleT = 0.0;
		myFloatT = 0;
		myShortT = 0;
		myCharT = 'c';
		myOtherDoubleT = 0;
		
	}

	public MyAllTypesSecond(double myDoubleT, float myFloatT, short myShortT, char myCharT, double myOtherDoubleT) {
		super();
		this.myDoubleT = myDoubleT;
		this.myFloatT = myFloatT;
		this.myShortT = myShortT;
		this.myCharT = myCharT;
		this.myOtherDoubleT = myOtherDoubleT;
	}

	public double getmyDoubleT() {
		return myDoubleT;
	}

	public void setmyDoubleT(double myDoubleT) {
		this.myDoubleT = myDoubleT;
	}
	public float getmyFloatT() {
		return myFloatT;
	}
	public void setmyFloatT(float myFloatT) {
		this.myFloatT = myFloatT;
	}
	public short getmyShortT() {
		return myShortT;
	}
	public void setmyShortT(short myShortT) {
		this.myShortT = myShortT;
	}
	public char getmyCharT() {
		return myCharT;
	}
	public void setmyCharT(char myCharT) {
		this.myCharT = myCharT;
	}
	public double getmyOtherDoubleT() {
		return myOtherDoubleT;
	}
	public void setmyOtherDoubleT(double myOtherDoubleT) {
		this.myOtherDoubleT = myOtherDoubleT;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + myCharT;
		long temp;
		temp = Double.doubleToLongBits(myDoubleT);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + Float.floatToIntBits(myFloatT);
		temp = Double.doubleToLongBits(myOtherDoubleT);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + myShortT;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MyAllTypesSecond other = (MyAllTypesSecond) obj;
		if (myCharT != other.myCharT)
			return false;
		if (Double.doubleToLongBits(myDoubleT) != Double.doubleToLongBits(other.myDoubleT))
			return false;
		if (Float.floatToIntBits(myFloatT) != Float.floatToIntBits(other.myFloatT))
			return false;
		if (Double.doubleToLongBits(myOtherDoubleT) != Double.doubleToLongBits(other.myOtherDoubleT))
			return false;
		if (myShortT != other.myShortT)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "MyAllTypesSecond [myDoubleT=" + myDoubleT + ", myFloatT=" + myFloatT + ", myShortT=" + myShortT
				+ ", myCharT=" + myCharT + ", myOtherDoubleT=" + myOtherDoubleT + "]";
	}
	
}
