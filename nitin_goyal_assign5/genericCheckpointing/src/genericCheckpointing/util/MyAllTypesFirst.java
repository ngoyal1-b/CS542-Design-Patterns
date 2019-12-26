package genericCheckpointing.util;

public class MyAllTypesFirst extends SerializableObject {
	public int myInt;
	public long myLong;
	public long myOtherLong;

	public String myString;
	public boolean myBool;
	public int myOtherInt;
	public MyAllTypesFirst()
	{
		super();	
		myInt = 0;
		myLong = 0;
		myString = "c";
		myBool = true;
		myOtherInt = 0;
		myOtherLong = 0;
	}
	public MyAllTypesFirst(int myInt, long myLong, String myString, boolean myBool, int myOtherInt,long myOtherLong) {
		super();
		this.myInt = myInt;
		this.myLong = myLong;
		this.myString = myString;
		this.myBool = myBool;
		this.myOtherInt = myOtherInt;
		this.myOtherLong = myOtherLong;
	}
	public int getmyInt() {
		return myInt;
	}
	public void setmyInt(int myInt) {
		this.myInt = myInt;
	}
	public long getmyOtherLong() {
		return myOtherLong;
	}
	public void setmyOtherLong(long myOtherLong) {
		this.myOtherLong = myOtherLong;
	}

	public long getmyLong() {
		return myLong;
	}
	public void setmyLong(long myLong) {
		this.myLong = myLong;
	}
	public String getmyString() {
		return myString;
	}
	public void setmyString(String myString) {
		this.myString = myString;
	}
	public Boolean getmyBool() {
		return myBool;
	}
	public void setmyBool(boolean myBool) {
		this.myBool = myBool;
	}
	public int getmyOtherInt() {
		return myOtherInt;
	}
	public void setmyOtherInt(int myOtherInt) {
		this.myOtherInt = myOtherInt;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (myBool ? 1231 : 1237);
		result = prime * result + myInt;
		result = prime * result + (int) (myLong ^ (myLong >>> 32));
		result = prime * result + myOtherInt;
		result = prime * result + ((myString == null) ? 0 : myString.hashCode());
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
		MyAllTypesFirst other = (MyAllTypesFirst) obj;
		if (myBool != other.myBool)
			return false;
		if (myInt != other.myInt)
			return false;
		if (myLong != other.myLong)
			return false;
		if (myOtherInt != other.myOtherInt)
			return false;
		if (myString == null) {
			if (other.myString != null)
				return false;
		} else if (!myString.equals(other.myString))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "MyAllTypesFirst [myInt=" + myInt + ", myLong=" + myLong + ", myString=" + myString + ", myBool="
				+ myBool + ", myOtherInt=" + myOtherInt + "]";
	}
}
