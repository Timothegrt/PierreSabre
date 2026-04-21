package personnages;

public class Humain {
	private String nom;
	private String boissonFav;
	private int argent;
	
	public Humain(String nom, String boissonFav, int argent) {
		super();
		this.nom = nom;
		this.boissonFav = boissonFav;
		this.argent = argent;
	}
	
	public String getNom() {
		return nom;
	}
	public int getArgent() {
		return argent;
	}
	
	public void direBonjour() {
		parler("Bonjour ! Je m'appelle "+nom+" et j'aime boire du "+boissonFav);
	}
	
	public void boire() { 
		parler("Mmmm, un bon verre de " + boissonFav+ " ! GLOUPS !");
	}
	
	public void parler(String texte) {
		System.out.println("(" + getNom() +") - " + texte);
	}
	
	private void gagnerArgent(int montant) {
		argent+=montant;
	}
	
	private void perdreArgent(int prix) {
		argent-=prix;
	}
	
	public void acheter(String bien, int prix) {
		String texte;
		if (prix>argent) {
			texte="J'ai " + argent + " sous en poche. Je ne peux même pas m'offrir " + bien + " à " + prix + " sous.";
		}else {
			texte="Je n'ai plus que " + argent + " sous en poche. Je vais pouvoir m'offrir " + bien + " à " + prix + " sous.";
			perdreArgent(prix);
		}
		parler(texte);
	}
}
