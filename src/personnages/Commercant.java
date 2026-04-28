package personnages;

public class Commercant extends Humain {
	
	public Commercant(String nom, int argent) {
		this.nom = nom;
		this.argent = argent;
		this.boissonFav ="Thé";
	}

	public int seFaireExtorquer() {
		int montantVole = getArgent();
		setArgent(0);
		parler("J'ai tout perdu! Le monde est trop injuste...");
		return montantVole;
	}
	
	public void recevoir(int argent) {
		setArgent(getArgent()+argent);
		parler(argent + " sous! Je te remercie généreux donateur!");
	}
}
