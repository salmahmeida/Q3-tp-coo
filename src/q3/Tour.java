package q3;

// La classe Tour est elle-meme generique et sous-classe de Pile 
public class Tour<T extends Empilable> extends Pile<T> {
    
    public Tour(int capa) {
	super(capa);
    }
    public void remplir(int nb, Class C) throws ErreurPile, InstantiationException, IllegalAccessException, ClassNotFoundException {

		for(int i = nb; i > 0; i--){
			try{
				Class cl=Class.forName(C.getName());
				Object d=cl.newInstance();
				((Empilable)d).setVal(i);
				this.empiler(d);
			} catch (NullPointerException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				System.out.println("Ops!!!, la class entree n'existe pas!!");
				e.printStackTrace();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (ClassCastException e) {
				System.out.println("les objets de la class entree ne sont pas empilable!!!");
				e.printStackTrace();
				System.exit(0);
			}
		}
	}

	public void empiler(Object v) throws ErreurPile {
		try{		
			if(this.estVide() || (((Empilable)this.sommet()).compareTo((Empilable)v)>0)) super.empiler(v);
			else throw new ErreurTour("le sommet est plus petit que l'object a empiler!!");
		}catch(ClassCastException e){
			System.out.println("Ops! l'objet a empiler n'est pas un empilable, la tour rejete");//le cas ou la tour est vide et v#disque
		}

	}
}
