package org.remise.forme;

public class CompteBancaire 
{
	private String leLibellé;
	private Integer leMontant;
	private Personne laPersonne;

	
	public CompteBancaire(String leLibellé, Integer leMontant, Personne laPersonne)
	{
		this.leLibellé = leLibellé;
		this.leMontant = leMontant;
		this.laPersonne = laPersonne;
		//rajouter la personne
	} 
	
	
	
	



	/**
	 * @return the leLibellé
	 */
	public String getLeLibellé() {
		return leLibellé;
	}







	/**
	 * @param leLibellé the leLibellé to set
	 */
	public void setLeLibellé(String leLibellé) {
		this.leLibellé = leLibellé;
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

	public void débiter(Integer leMontant)
	{
		this.leMontant = this.leMontant - leMontant;
	}
	
	public void créditer(Integer leMontant)
	{
		this.leMontant = this.leMontant + leMontant;
	}





	@Override
	public String toString()
	{
		String unString = "Ceci est le compte  " + this.leLibellé + " avec un montant de " + this.leMontant;
		return unString;

	}



}// Suppression de compte (sauf si un seul compte), ajout, virement de compte à compte, sur la BDD, SQL que dans main 
