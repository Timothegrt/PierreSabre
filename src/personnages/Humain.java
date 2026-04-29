package personnages;

public class Humain {
	private String nom;
	private String boissonFav;
	private int argent;
	protected int nbConnaissance=0;
	protected Humain[] memoire = new Humain[30];
	
	
	public Humain(String nom, String boissonFav, int argent) {
		this.nom = nom;
		this.boissonFav = boissonFav;
		this.argent = argent;
	}
	
	public void setArgent(int argent) {
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
	
	protected void parler(String texte) {
		System.out.println("(" + getNom() +") - " + texte);
	}
	
	protected void gagnerArgent(int montant) {
		argent+=montant;
	}
	
	protected void perdreArgent(int prix) {
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

	public void faireConnaissanceAvec(Humain autreHumain) {
		direBonjour();
		autreHumain.repondre(this);
		memoriser(autreHumain);
	}
	
	private void memoriser(Humain humain) {
		if (nbConnaissance<30) {
			memoire[nbConnaissance]=humain;
			nbConnaissance++;
		}
		else {
			for(int i=0;i<nbConnaissance-1;i++) {
				memoire[i]=memoire[i+1];
			}
			memoire[nbConnaissance-1]=humain;
		}
		System.out.println("---memoire---");
		for (int i = 0; i < nbConnaissance; i++) {
			System.out.println(memoire[i].getNom());
		}
	}
	
	private void repondre(Humain humain) {
		direBonjour();
		memoriser(humain);
	}
	
	public void listerConnaissance() {
		String texte = "Je connais beaucoup de monde dont : "+memoire[0].getNom();
		for (int i = 1; i < nbConnaissance; i++) {
			texte+=", "+memoire[i].getNom();
		}
		texte+=".";
		parler(texte);
	}
	
}
