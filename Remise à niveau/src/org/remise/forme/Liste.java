package org.remise.forme;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Liste {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
		String[] unTab = new String[10];
		unTab[2] = "test";
		List uneListe = new ArrayList();
		 //Les m�thodes de la classe liste utilisent la meth equals, toujours d�finir la m�thode equals dans les classes. 
		Map<Integer, String> uneMap = new HashMap<>(); 
		
		CompteBancaire unCompte = new CompteBancaire("ABAD", 0);
		System.out.println(unCompte);
		
	}

}
