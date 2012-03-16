/**
 * BitFieldDemo.java
 * @date Mar 16, 2012
 * @author ricky barrette
 * @author Twenty Codes, LLC
 * 
 * Copyright 2012 Richard Barrette 
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); 
 * you may not use this file except in compliance with the License. 
 * You may obtain a copy of the License at 
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0 
 * 
 * Unless required by applicable law or agreed to in writing, software 
 * distributed under the License is distributed on an "AS IS" BASIS, 
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. 
 * See the License for the specific language governing permissions and 
 * limitations under the License
 */
package com.test;

/**
 * This is a simple bit field demo class 
 * @author ricky barrette
 */
public class BitField {
	
	private int mFlags;
	
	public static final int FLAG_ONE = 1;
	public static final int FLAG_TWO = 2;
	public static final int FLAG_THREE = 4;
	public static final int FLAG_FOUR = 8;
	public static final int FLAG_FIVE = 16;
	public static final int FLAG_SIX = 32;
	public static final int FLAG_SEVEN = 64;
	public static final int FLAG_EIGHT = 128;
	
	/**
	 * Creates a new BitFieldDemo
	 * @author ricky barrette
	 */
	public BitField(){
		this(0);
	}
	
	/**
	 * Creates a new BitFiledDemo
	 * @param flags 
	 * @author ricky barrette
	 */
	public BitField(int flags) {
		setFlags(flags);
	}
	
	/**
	 * @return the flags
	 */
	public int getFlags() {
		return new Integer(mFlags);
	}

	/**
	 * @param flag being checked
	 * @return true if the flag has been set
	 * @author ricky barrette
	 */
	public boolean isFlagSet(int flag){
		return (this.mFlags & flag) > 0;
	}

	/**
	 * Uses XOR logic to unset flags.
	 * Warning: this will set flags if they are NOT already set
	 * @param flags to be removed
	 * @author ricky barrette
	 */
	public void removeFlags(int flags){
		if(flags < 0 || flags > 255)
			throw new IllegalArgumentException("Invald flags");
		this.mFlags = this.mFlags ^ flags;
	}

	/**
	 * Uses OR logic to set flags
	 * @param flags the flags to set
	 * @author ricky barrette
	 */
	public void setFlags(int flags) {
		if(flags < 0 || flags > 255)
			throw new IllegalArgumentException("Invald flags");
		this.mFlags = this.mFlags | flags;
	}
	
	/**
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 * @author ricky barrette
	 */
	@Override
	public String toString() {
		StringBuffer s = new StringBuffer();
		s.append("Flags = ");
		s.append(this.mFlags);
		s.append(", Bit 1 = ");
		s.append(isFlagSet(FLAG_ONE));
		s.append(", Bit 2 = ");
		s.append(isFlagSet(FLAG_TWO));
		s.append(", Bit 3 = ");
		s.append(isFlagSet(FLAG_THREE));
		s.append(", Bit 4 = ");
		s.append(isFlagSet(FLAG_FOUR));
		s.append(", Bit 5 = ");
		s.append(isFlagSet(FLAG_FIVE));
		s.append(", Bit 6 = ");
		s.append(isFlagSet(FLAG_SIX));
		s.append(", Bit 7 = ");
		s.append(isFlagSet(FLAG_SEVEN));
		s.append(", Bit 8 = ");
		s.append(isFlagSet(FLAG_EIGHT));
		return s.toString();
	}
}