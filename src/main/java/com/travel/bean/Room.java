package com.travel.bean;
import java.util.ArrayList;
import java.util.List;

public class Room {

   
    private long adults;
  
    private long child;
    
    private List<Child> children = new ArrayList<Child>();	
    
     public Room() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the adults
	 */
	public long getAdults() {
		return adults;
	}

	/**
	 * @param adults the adults to set
	 */
	public void setAdults(long adults) {
		this.adults = adults;
	}

	/**
	 * @return the child
	 */
	public long getChild() {
		return child;
	}

	/**
	 * @param child the child to set
	 */
	public void setChild(long child) {
		this.child = child;
	}

	/**
	 * @return the children
	 */
	public List<Child> getChildren() {
		return children;
	}

	/**
	 * @param children the children to set
	 */
	public void setChildren(List<Child> children) {
		this.children = children;
	}

	
	

   
}
