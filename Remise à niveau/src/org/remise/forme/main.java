package org.remise.forme;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class main 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
	/*	Integer unEntier;
		Integer deEntier;
		
		
		unEntier = 1;
		deEntier = 5;
		System.out.println(unEntier);
		System.out.println(deEntier);
		for(int i=1; i<13; i++)
		{
			Comparaison(unEntier, deEntier);
			unEntier = i;
		}
		
		Scanner unScan = new Scanner(System.in);
		System.out.println("Entrez un truc");
		String unString = unScan.nextLine();
		if(unString.equals( "Ta race"))
		{
			System.out.println("T'es un g�nie");
		}
		else
		{
			System.out.println("Vous avez entr� : "+unString);
		}
		unScan.close();*/
		
		
		
		
		
		String rep ="0";
		Scanner unScan = new Scanner(System.in);
		boolean verif;
		
		
		
		//Cr�ation Riche
		Personne pCr�sus = new Personne("Cr�sus", "9999");
		CompteBancaire compteRiche = new CompteBancaire("Compte Courant", 50000, pCr�sus);
		CompteBancaire compteAssu = new CompteBancaire("Assurance Vie", 20000, pCr�sus);
		List<CompteBancaire> listeRiche = new ArrayList<CompteBancaire>();
		listeRiche.add(compteRiche);
		listeRiche.add(compteAssu);
		Map<String, List<CompteBancaire>> uneMap = new HashMap<>(); //Cr�ation de la Map  (liste des compte )
		uneMap.put("Cr�sus", listeRiche);		
		//Cr�ation Pauvre
		Personne pClodo = new Personne("Clodo", "0000");
		CompteBancaire compteClodo = new CompteBancaire("Compte Courant", 1000, pClodo);
		List<CompteBancaire> listePauvre = new ArrayList<CompteBancaire>();
		listePauvre.add(compteClodo); 
		uneMap.put("Clodo", listePauvre);
		
		
		System.out.println("Veuillez entrer votre Nom");
		String repNom = unScan.nextLine();
		if(uneMap.containsKey(repNom))
		{
			
			verif = Verification(uneMap.get(repNom).get(0).getLaPersonne().getUnCode(), unScan);
		}
		else
		{
			System.out.println("Aucun utilisateur � ce Nom, voulez-vous cr�er un compte � ce nom?");
			System.out.println("1.Oui");
			System.out.println("2.Non");
			rep = unScan.nextLine();
			while(!rep.equals("1") && !rep.equals("2"))
			{
				System.out.println("Oui ou Non abruti");
				rep = unScan.nextLine();
			}
			if(rep.equals("1"))
			{
				System.out.println("Choisissez un Code pour votre compte :");
				String unCode = unScan.nextLine();
				uneMap.put(repNom, new ArrayList<CompteBancaire>());
				uneMap.get(repNom).add(new CompteBancaire("Compte Courant", 0, new Personne(repNom, unCode)));
				System.out.println("Compte courant cr�e");
				verif = true;
			}
			else
			{
				verif = false;
			}
			
		}
		
	
		if(verif)
		{
			while(!rep.equals("4"))
			{	
				System.out.println("Voulez-vous :");
				System.out.println("1 : Voir votre (vos) compte");
				System.out.println("2 : D�biter");
				System.out.println("3 : Cr�diter");
				System.out.println("4 : Sortir");
				rep = unScan.nextLine();
				if(rep.isEmpty())
				{
					rep = unScan.nextLine();
				}
				while(!rep.equals("1") && !rep.equals("2") && !rep.equals("3") && !rep.equals("4"))
				{
					System.out.println("Mauvaise manip, recommencez");
					rep = unScan.nextLine();
				}	
					
				if(rep.equals("1"))
				{
					Consultation(uneMap, repNom, unScan);
				}
				if(rep.equals("2"))
				{
					D�bit(uneMap, repNom, unScan);
				}
				if(rep.equals("3"))
				{
					Cr�dit(uneMap, repNom, unScan);
				}
			}
			System.out.println("Byyyeee~~");
			
		}
		unScan.close();		
		
	}	
		

	
	public static Boolean Verification(String leCode, Scanner unScan)
	{
		int i = 1 ;
		System.out.println("Entrez votre Code");
		String unCode = unScan.nextLine();
		while(!unCode.equals(leCode) && i < 3)
		{
			System.out.println(i);
			i++;
						
			System.out.println("Erreur de code, recommencez");
			unCode = unScan.nextLine();
						
		}
		if(i < 3)
		{
			return true;
		}
		else
		{
			
			System.out.println("Trop d'erreur tue l'erreur");
			return false;
		}
	}
	
	public static void Consultation(Map<String, List<CompteBancaire>> uneMap, String unNom, Scanner unScan)
	{
		for(CompteBancaire unCb : uneMap.get(unNom))
		{
			System.out.println(unCb.toString());
		}
		
	}
	
	public static void D�bit(Map<String, List<CompteBancaire>> uneMap, String unNom, Scanner unScan)
	{
		Integer leMontant;
		if(uneMap.get(unNom).size() == 1)
		{	
			System.out.println("Vous avez "+ uneMap.get(unNom).get(0).getLeMontant() + " �, combien voulez vous retirer?");
			leMontant = unScan.nextInt();
			while(leMontant > uneMap.get(unNom).get(0).getLeMontant())
			{
				System.out.println("Montant trop �lev� BOULAY, recommence");
				leMontant = unScan.nextInt();
			}
			uneMap.get(unNom).get(0).d�biter(leMontant);
		}
		else
		{
			int i = 1;
			System.out.println("Sur quel compte d�biter?");
			for(CompteBancaire unCb : uneMap.get(unNom))
			{
				System.out.println( i + " : " + unCb.getLeLibell�());
				i++;
			}
			Integer uneRep = unScan.nextInt();
			while(uneRep > i && uneRep < 1)
			{
				System.out.println("Erreur, recommencez");
				uneRep = unScan.nextInt();
			}
			System.out.println("Vous avez "+ uneMap.get(unNom).get(uneRep-1).getLeMontant() + " �, combien voulez vous retirer?");
			leMontant = unScan.nextInt();
			while(leMontant > uneMap.get(unNom).get(uneRep-1).getLeMontant())
			{
				System.out.println("Montant trop �lev� BOULAY, recommence");
				leMontant = unScan.nextInt();
			}
			uneMap.get(unNom).get(uneRep-1).d�biter(leMontant);
		}
		System.out.println("Compte d�biter de "+ leMontant + " �");
			
		
	}
	
	public static void Cr�dit(Map<String, List<CompteBancaire>> uneMap, String unNom, Scanner unScan)
	{
		Integer leMontant;
		if(uneMap.get(unNom).size() == 1)
		{	
			System.out.println("De combien voulez vous cr�diter?");
			leMontant = unScan.nextInt();
			uneMap.get(unNom).get(0).cr�diter(leMontant);
		}
		else
		{
			int i = 1;
			System.out.println("Sur quel compte cr�diter?");
			for(CompteBancaire unCb : uneMap.get(unNom))
			{
				System.out.println( i + " : " + unCb.getLeLibell�());
				i++;
			}
			Integer uneRep = unScan.nextInt();
			while(uneRep > i && uneRep < 1)
			{
				System.out.println("Erreur, recommencez");
				uneRep = unScan.nextInt();
			}
			System.out.println("Combien voulez vous cr�diter?");
			leMontant = unScan.nextInt();
			uneMap.get(unNom).get(uneRep-1).cr�diter(leMontant);
		}
		System.out.println("Compte cr�diter de "+ leMontant + " �");
		
	}
}