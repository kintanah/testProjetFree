package parcourList;

import java.util.ArrayList;
import java.util.List;

public class Parcour {
	private List<Integer> liste;
	
	

	public Parcour(List<Integer> liste) {
		super();
		this.liste = liste;
	}
	
	public Parcour() {
		super();
	}

	public List<Integer> getListe() {
		return liste;
	}


	public void setListe(List<Integer> liste) {
		this.liste = liste;
	}
	
	public void parcourirListe() {
		List<Integer> monliste=this.liste;
		for(int i=0;i<monliste.size();i++) {
			if(monliste.get(i)!=0) {
				if(monliste.get(i)%3==0) {
					System.out.println("Fluzz :"+monliste.get(i));
				}
				if(monliste.get(i)%5==0) {
					System.out.println("Gratz :"+monliste.get(i));
				}
				if(monliste.get(i)%3==0 && monliste.get(i)%5==0) {
					System.out.println("FluzzGratz :"+monliste.get(i));
				}
				if(monliste.get(i)%3!=0 && monliste.get(i)%5!=0) {
					System.out.println("Nombre :"+monliste.get(i));
				}
			}
			else {
				System.out.println("Nombre null:"+monliste.get(i));
			}
			
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> maliste=new ArrayList<Integer>();
		maliste.add(49);maliste.add(34);maliste.add(56);maliste.add(67);maliste.add(15);maliste.add(23);maliste.add(27);
		maliste.add(0);maliste.add(4);maliste.add(9);maliste.add(55);maliste.add(124);maliste.add(125);maliste.add(230);
		maliste.add(360);maliste.add(231);maliste.add(30);maliste.add(69);
		
		Parcour parcour=new Parcour(maliste);
		parcour.parcourirListe();
	}

}
