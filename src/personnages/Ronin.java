package personnages;

public class Ronin extends Humain {
	private int honneur = 1;
	public Ronin(String nom, String boissonFav, int argent) {
		super(nom,boissonFav, argent);
	}
	
	public void donner(Commercant beneficiaire) {
		int solde = getArgent();
		int don = (int) (0.1*solde);
		parler(beneficiaire.getNom()+" prend ces "+don+" sous.");
		beneficiaire.recevoir(don);
		setArgent(solde-don);
	}
	
	public void provoquer(Yakuza adversaire) {
		int force = 2*honneur;
		int solde = getArgent();
		parler("Je t'ai retrouvé vermine, tu vas payer pour ce que tu as fait à ce pauvre marchand!");
		if (force>=adversaire.getReputation()) {
			parler("Je t'ai eu petit yakuza!");
			int gain = adversaire.perdre();
			setArgent(solde+gain);
			honneur+=1;
		}
		else {
			parler("J'ai perdu contre ce yakuza, mon honneur et ma bourse en ont prit un coup");
			adversaire.gagner(solde);
			setArgent(0);
			honneur-=1;
		}
	}
}
