package personnages;

public class Yakuza extends Humain{
	private String clan;
	private int reputation=0;
	public Yakuza(String nom, String boissonFav, int argent, String clan) {
		super(nom, boissonFav, argent);
		this.clan = clan;
	}
	
	public void extorquer(Commercant commercant) {
		parler("Tiens, tiens, ne serait-ce pas un faible qui passe par là ?");
		parler(commercant.getNom() + ", si tu tiens à la vie donne moi ta bourse !");
		int montantVole = commercant.seFaireExtorquer();
		argent+=montantVole;
		parler("J'ai piqué les "+montantVole+" sous de "+commercant.getNom()+", ce qui me fait "+argent+" sous dans ma poche. Hi ! Hi !");
		reputation+=1;
		
	}
	
}
