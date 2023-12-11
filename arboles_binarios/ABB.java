
public class ABB{   
     private Nodo raiz;  

    ABB(){
	this.raiz = null;
    } 

    public boolean esVacio(){
	return (this.raiz == null); 
    }

    public Nodo regresaRaiz(){  
	return this.raiz;
    }

    public void insertarValor(int valor){
        if (this.raiz == null){
		System.out.println("Insertando raiz: " + valor);
		this.raiz = new Nodo();
		this.raiz.dato = valor;
		this.raiz.izquierdo = null;
		this.raiz.derecho = null;
	}
	else insertarNodo(valor, this.raiz);
    }

    public void insertarNodo(int valor, Nodo nodoRef){
		if (valor <= nodoRef.dato) {
			if (nodoRef.izquierdo == null){
				System.out.println("Insertando hijo izquierdo de: "  + nodoRef.dato + ": " + valor);
				nodoRef.izquierdo =  new Nodo();
				nodoRef.izquierdo.dato = valor;
				nodoRef.izquierdo.izquierdo = null;
				nodoRef.izquierdo.derecho = null;
			}
			else {
				insertarNodo(valor, nodoRef.izquierdo);
			}
		}
		else {
			if (valor > nodoRef.dato) {
				if (nodoRef.derecho == null){
					System.out.println("Insertando hijo derecho de: " + nodoRef.dato + ": " + valor);
					nodoRef.derecho =  new Nodo();
					nodoRef.derecho.dato = valor;
					nodoRef.derecho.izquierdo = null;
					nodoRef.derecho.derecho = null;
				}
				else {
					insertarNodo(valor, nodoRef.derecho);
				}
			}
		}
    }


     public void muestraAcostado(int nivel, Nodo nodoRef){
	if (nodoRef == null){
		return;
	}
	else {
		muestraAcostado(nivel + 1, nodoRef.derecho);
		for (int i=0; i < nivel; i++){
			System.out.print("   ");
		}
		System.out.println(nodoRef.dato);
		muestraAcostado(nivel + 1, nodoRef.izquierdo);
		}
    }
    
    public void imprimirHorizontal() {
        imprimirHorizontal(this.raiz, 0);
    }

    private void imprimirHorizontal(Nodo nodoRef, int nivel) {
        if (nodoRef != null) {
            imprimirHorizontal(nodoRef.derecho, nivel + 1);
            for (int i = 0; i < nivel; i++) {
                System.out.print("   ");
            }
            System.out.println(nodoRef.dato);
            imprimirHorizontal(nodoRef.izquierdo, nivel + 1);
        }
    }

    public Nodo buscarNodo(int valor) {
        return buscarNodo(valor, this.raiz);
    }

    private Nodo buscarNodo(int valor, Nodo nodoRef) {
        if (nodoRef == null || nodoRef.dato == valor) {
            return nodoRef;
        }

        if (valor < nodoRef.dato) {
            return buscarNodo(valor, nodoRef.izquierdo);
        } else {
            return buscarNodo(valor, nodoRef.derecho);
        }
    }

    public void preorden() {
        preorden(this.raiz);
    }

    private void preorden(Nodo nodoRef) {
        if (nodoRef != null) {
            System.out.print(nodoRef.dato + " ");
            preorden(nodoRef.izquierdo);
            preorden(nodoRef.derecho);
        }
    }

    public void inorden() {
        inorden(this.raiz);
    }

    private void inorden(Nodo nodoRef) {
        if (nodoRef != null) {
            inorden(nodoRef.izquierdo);
            System.out.print(nodoRef.dato + " ");
            inorden(nodoRef.derecho);
        }
    }

    public void postorden() {
        postorden(this.raiz);
    }

    private void postorden(Nodo nodoRef) {
        if (nodoRef != null) {
            postorden(nodoRef.izquierdo);
            postorden(nodoRef.derecho);
            System.out.print(nodoRef.dato + " ");
        }
    }

    public void eliminarNodo(int valor) {
        this.raiz = eliminarNodo(valor, this.raiz);
    }

    private Nodo eliminarNodo(int valor, Nodo nodoRef) {
         if (nodoRef == null) {
           return null; 
        }
        if (valor < nodoRef.dato) {
         nodoRef.izquierdo = eliminarNodo(valor, nodoRef.izquierdo);
        } else if (valor > nodoRef.dato) {
        nodoRef.derecho = eliminarNodo(valor, nodoRef.derecho);
        } else {
            if (nodoRef.izquierdo == null) {
            return nodoRef.derecho;
            } else if (nodoRef.derecho == null) {
            return nodoRef.izquierdo;
           }
           nodoRef.dato = encontrarMinimoValor(nodoRef.derecho);
           nodoRef.derecho = eliminarNodo(nodoRef.dato, nodoRef.derecho);
        }
        return nodoRef;
    }

    private int encontrarMinimoValor(Nodo nodoRef) {
     int minimoValor = nodoRef.dato;
     while (nodoRef.izquierdo != null) {
        minimoValor = nodoRef.izquierdo.dato;
        nodoRef = nodoRef.izquierdo;
     }
     return minimoValor;
    }
}










