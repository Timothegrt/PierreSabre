package personnages;

public class Samourai extends Ronin{
	private String seigneur;
	public Samourai(String seigneur, String nom, String boissonFav, int argent) {
		super(nom, boissonFav, argent);
		this.seigneur = seigneur;
	}
	
	public String getSeigneur() {
		return seigneur;
	}
	
	@Override
	public void direBonjour() {
		super.direBonjour();
		parler("Je suis fier de servir le seigneur "+ getSeigneur());
	}
	
	
	public void boire(String boisson) {
		parler("Qu'est ce que je vais choisir comme boisson ? Tiens je vais prendre "+boisson);
	}
}
