package personnages;

import java.util.Random;

public class GrandMere extends Humain {

	public GrandMere(String nom, int argent) {
		super(nom, "tisane", argent);
	}
	
	private enum TypeHumain {
		COMMERCANT, RONIN, SAMOURAI, TRAITRE, YAKUZA, HUMAIN, GRANDMERE
	}
	
	private TypeHumain[] types = TypeHumain.values();
	
	
	@Override
	public void memoriser(Humain humain) {
		if (nbConnaissance<5) {
			memoire[nbConnaissance]=humain;
			nbConnaissance++;
		}
		else {
			parler("Oh ma tête je ne peux plus retenir le nom d'une personne supplémentaire !");
		}
	}
	
	private String humainHasard() {
		Random r = new Random();
		TypeHumain type = types[r.nextInt(5)];
		switch (type) {
		case COMMERCANT: {
			return "un commercant";
		}
		case RONIN: {
			return "un ronin";
		}
		case SAMOURAI: {
			return "un samourai";
		}
		case YAKUZA: {
			return "un yakuza";
		}
		case HUMAIN : {
			return "un habitant";
		}
		case TRAITRE :{
			return "un traître. Petit chenapan !";
		}
		default:
			return "une grand-mère";
		}
	}
	
	public void ragoter() {
		for (int i = 0; i < nbConnaissance; i++) {
			parler("Je crois que "+memoire[i].getNom()+" est "+humainHasard());
		}
	}
	
}
