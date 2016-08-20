package org.remise.forme;

public class CompteBancaire 
{
	private String leLibell�;
	private Integer leMontant;
	private Personne laPersonne;

	
	public CompteBancaire(String leLibell�, Integer leMontant, Personne laPersonne)
	{
		this.leLibell� = leLibell�;
		this.leMontant = leMontant;
		this.laPersonne = laPersonne;
		//rajouter la personne
	} 
	
	
	
	



	/**
	 * @return the leLibell�
	 */
	public String getLeLibell�() {
		return leLibell�;
	}







	/**
	 * @param leLibell� the leLibell� to set
	 */
	public void setLeLibell�(String leLibell�) {
		this.leLibell� = leLibell�;
	}







	/**
	 * @return the leMontant
	 */
	public Integer getLeMontant() {
		return leMontant;
	}







	/**
	 * @param leMontant the leMontant to set
	 */
	public void setLeMontant(Integer leMontant) {
		this.leMontant = leMontant;
	}







	/**
	 * @return the laPersonne
	 */
	public Personne getLaPersonne() {
		return laPersonne;
	}







	/**
	 * @param laPersonne the laPersonne to set
	 */
	public void setLaPersonne(Personne laPersonne) {
		this.laPersonne = laPersonne;
	}

	public void d�biter(Integer leMontant)
	{
		this.leMontant = this.leMontant - leMontant;
	}
	
	public void cr�diter(Integer leMontant)
	{
		this.leMontant = this.leMontant + leMontant;
	}





	@Override
	public String toString()
	{
		String unString = "Ceci est le compte  " + this.leLibell� + " avec un montant de " + this.leMontant;
		return unString;

	}



}// Suppression de compte (sauf si un seul compte), ajout, virement de compte � compte, sur la BDD, SQL que dans main 
