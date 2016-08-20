package org.remise.forme;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Personne 
{
	private String unNom;
	private String unCode;
	//private Map<String, List<CompteBancaire>> uneMap; virer les comptes de la personnes
	
	
	
	
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((unCode == null) ? 0 : unCode.hashCode());
		result = prime * result + ((unNom == null) ? 0 : unNom.hashCode());
		return result;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Personne other = (Personne) obj;
		if (unCode == null) {
			if (other.unCode != null)
				return false;
		} else if (!unCode.equals(other.unCode))
			return false;
		if (unNom == null) {
			if (other.unNom != null)
				return false;
		} else if (!unNom.equals(other.unNom))
			return false;
		return true;
	}


	public Personne(String unNom, String unCode)
	{
		this.unNom = unNom;
		this.unCode = unCode;
	}
	
	
	/**
	 * @return the unNom
	 */
	public String getUnNom() {
		return unNom;
	}
	/**
	 * @param unNom the unNom to set
	 */
	public void setUnNom(String unNom) {
		this.unNom = unNom;
	}
	/**
	 * @return the unCode
	 */
	public String getUnCode() {
		return unCode;
	}
	/**
	 * @param unCode the unCode to set
	 */
	public void setUnCode(String unCode) {
		this.unCode = unCode;
	}
	


}
