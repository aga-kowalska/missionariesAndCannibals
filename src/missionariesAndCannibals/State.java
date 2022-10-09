package missionariesAndCannibals;

public class State {
	
	public int mOnLeft = 3;
	public int cOnLeft = 3;
	public boolean bOnLeft = true;
	
	
	
	public State() {
		super();
	}
	public State(int mOnLeft, int cOnLeft, boolean bOnLeft) {
		super();
		this.mOnLeft = mOnLeft;
		this.cOnLeft = cOnLeft;
		this.bOnLeft = bOnLeft;
	}
	public int getmOnLeft() {
		return mOnLeft;
	}
	public void setmOnLeft(int mOnLeft) {
		this.mOnLeft = mOnLeft;
	}
	public int getcOnLeft() {
		return cOnLeft;
	}
	public void setcOnLeft(int cOnLeft) {
		this.cOnLeft = cOnLeft;
	}
	public boolean isbOnLeft() {
		return bOnLeft;
	}
	public void setbOnLeft(boolean bOnLeft) {
		this.bOnLeft = bOnLeft;
	}
	
	

}
