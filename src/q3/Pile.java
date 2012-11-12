package q3;

import java.util.ArrayList;
// Pile Homogene de <T>, de capacite fixee a l'instantiation

public class Pile<T> { 
	private int capacite;
	private ArrayList<T> listDisque;
    // suppose 'capa' strictement positif !
    public Pile(int capa) throws ErreurPile{
    	if(capa>0){
    		this.capacite = capa; 
		    this.listDisque = new ArrayList<>();
    	}
    	else throw new ErreurPile("Valeur non permise de la capacite de la Pile!");
    }

    public void empiler(T v) throws ErreurPile {
    	if (this.listDisque.size() == this.capacite) {
			throw new ErreurPile("La Pile est pleine !");
		}
		else {
			this.listDisque.add(0, v);
		}
    }

    public void depiler () throws ErreurPile {
    	if (this.estVide()) {
			throw new ErreurPile("depilation: La Pile est vide !");
		}
		this.listDisque.remove(0);
    }

    public T sommet() throws ErreurPile {
    	if ( this.estVide() ) {
			throw new ErreurPile("La Pile est vide !");
		}
		return this.listDisque.get(0);
    }

    public boolean estVide() {
    	if ( this.listDisque.size() == 0 ) 
    		return true;
		return false;
    }

    public int hauteur () {
    	return this.listDisque.size();
    }

    public int capacite () {
    	return this.capacite;
    }

    public void affiche () { 
    	for (int i = 0; i < this.listDisque.size(); i++) {
			System.out.println( this.listDisque.get(i).toString());
		}
	}
  }

