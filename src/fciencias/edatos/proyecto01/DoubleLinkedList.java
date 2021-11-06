package fciencias.edatos.proyecto01;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
* Práctica 02 del curso de Estructuras de Datos.
* @author Góngora Ramírez Dania Paula numero de cuenta: 3181274
* @author Herrera Saavedra Alan numero de cuenta:421055951
* @version 2 de noviembre 2021.
* 
*/

public class DoubleLinkedList<T> implements TDAList<T> {

    /* Clase interna privada para nodos. */
    private class Nodo {
        /* El elemento del nodo. */
        private T elemento;
        /* El nodo anterior. */
        private Nodo anterior;
        /* El nodo siguiente. */
        private Nodo siguiente;

        /* Construye un nodo con un elemento. */
        private Nodo(T elemento) {
            this.elemento=elemento;
            
        }


    }

    public Iterator listIterador(){
    	return new Iterador();
        //iterador para recorrer la lista
    }

    /* Clase Iterador privada para iteradores. */
    public class Iterador implements Iterator<T>{
        /* El nodo anterior. */
        private Nodo anterior;
        /* El nodo siguiente. */
        private Nodo siguiente;

        /* Construye un nuevo iterador. */
        private Iterador() {
          siguiente=cabeza;
           
            
        }

        /* Nos dice si hay un elemento siguiente. */
        @Override public boolean hasNext() {
            if(siguiente==null)
            return false;
        else{
            return true;
            
            }
        }

        /* Nos da el elemento siguiente. */
       public T next() {
          if (!hasNext())
            throw new NoSuchElementException();
        else{
            T e= siguiente.elemento;
            anterior=siguiente;
            siguiente=siguiente.siguiente;
            return e;
          
        }
    }
         
       
        
    }

    /* Primer elemento de la lista. */
    private Nodo cabeza;
    /* Último elemento de la lista. */
    private Nodo rabo;
    /* Número de elementos en la lista. */
    private int longitud;

    /**
	 * Regresa la cantidad de elementos contenidos en la lista.
	 * @return la cantidad de elementos contenidos.
	 */
    @Override
    public int size() {
        return longitud;
        
    }

    /**
	 * Verifica si la lista está vacía.
	 * @return true si la lista no contiene elementos, false en otro caso.
	 */
    @Override
    public boolean isEmpty() {
        return longitud==0;
        
    }

    /**
     * Agrega un elemento al final de la lista. Si la lista no tiene elementos,
     * el elemento a agregar será el primero y último.
     * @param elemento el elemento a agregar.
     * @throws IllegalArgumentException si <code>elemento</code> es
     *         <code>null</code>.
     */
    public void agregaFinal(T elemento) {
       if(elemento==null)
        throw new IllegalArgumentException();
      Nodo n = new Nodo(elemento);
      if(isEmpty()){
        cabeza = n;
        rabo = cabeza;
        cabeza.anterior = null;
        rabo.siguiente= null;
      }
      else{
            n.anterior = rabo;
            rabo.siguiente = n;
            rabo= n;
            

            }
            longitud++;
        
    }

    /**
     * Agrega un elemento al inicio de la lista. Si la lista no tiene elementos,
     * el elemento a agregar será el primero y último.
     * @param elemento el elemento a agregar.
     * @throws IllegalArgumentException si <code>elemento</code> es
     *         <code>null</code>.
     */
    
    public void agregaInicio(T elemento)  {
        if(elemento==null)
         throw new IllegalArgumentException();
         Nodo n = new Nodo(elemento);
      if(isEmpty()){
        cabeza = n;
        rabo = cabeza;
        cabeza.anterior = null;
        rabo.siguiente= null;
      }else{
            n.siguiente = cabeza;
            cabeza.anterior = n;
            cabeza= n;
            

            }
       longitud++;
        
    }

    /**
	 * Inserta un nuevo elemento <i>e</i> en la posición <i>i</i>.
	 * @param i la posición donde agregar el elemento.
	 * @param e el elemento a insertar.
	 * @throws IndexOutOfBoundException si el índice está fuera de rango.
	 */
    
    @Override
    public void add(int i, T elemento) throws IndexOutOfBoundsException {
	 	  if(i>size() || i<0)
            throw new IndexOutOfBoundsException();
             if (i<=0) agregaInicio(elemento);
    else if (i>= longitud) agregaFinal(elemento);
   
    else{
    int j=longitud/2;
    if(i<=j/2){
    //revisa si el indice esta más cerca de la mitad izquierda o derecha para saber donde agregar, y cumplir la complejidad//
        Nodo n=buscaNodo(get(i));//agrega en la i-esima posición desde la cabeza
        Nodo m = new Nodo(elemento);
        n.anterior.siguiente=m;
        m.anterior=n.anterior;
        n.anterior=m;
        m.siguiente=n;
        longitud++;
        
    }else{
        
        Nodo n=buscaNodoAtras(get(i));//agrega en la i-esima posición desde el rabo
        Nodo m = new Nodo(elemento);
        n.anterior.siguiente=m;
        m.anterior=n.anterior;
        n.anterior=m;
        m.siguiente=n;
        longitud++;
	 } 
    }
}
/**Método auxiliar que busca un nodo por
 * el elemento que se le de como parametro
 * empieza a buscar desde la cabeza
 * @param return el nodo 
 */
    

    private Nodo buscaNodo(T elemento){
        Nodo n=cabeza;
         if(elemento == null) return null;
    while(n!= null){ 
        if(n.elemento.equals(elemento)) return n;
        else{ 
            n=n.siguiente;
        }
            
        }
    return null;
    }
/**Método auxiliar que busca un nodo por
 * el elemento que se le de como parametro
 * pero empieza adesde el rabo
 * @param return el nodo 
 */
    private Nodo buscaNodoAtras(T elemento){
        Nodo n=rabo;
         if(elemento == null) return null;
    while(n!= null){ 
        if(n.elemento.equals(elemento)) return n;
        else{ 
            n=n.anterior;
        }
            
        }
    return null;
    
    }
      @Override
      public T remove(int i) throws IndexOutOfBoundsException {
        Nodo a = cabeza;
        Nodo b = a;
        
        
        if(i>size() || i<0) //excepcion
        throw new IndexOutOfBoundsException();
  
        if(i == 0){ //eliminar primer elemento
            if(longitud == 1) clear();
            b = cabeza;
            cabeza = cabeza.siguiente;
            cabeza.anterior = null;
            longitud--;
         
        }
  
        if(i != 0){ //eliminar en la iesima posicion
            for(int g = 0; g< i-1; g++){
                a = a.siguiente;
            }
  
            b = a.siguiente;
            a.siguiente = a.siguiente.siguiente;
            Nodo c = a.siguiente;
            c.anterior = b.anterior;
            longitud--;
  
        }
  
            
        return b.elemento; //fin
  
  }


   
    /**
     * Elimina el primer elemento de la lista y lo regresa.
     * @return el primer elemento de la lista antes de eliminarlo.
     * @throws NoSuchElementException si la lista es vacía.
     */
    public T eliminaPrimero() {
    if(isEmpty())
    throw new NoSuchElementException();
            Nodo m=cabeza;
            if(longitud==1) 
            clear();
                else{
                cabeza=cabeza.siguiente;
                cabeza.anterior=null;
                longitud--;
        }
    return m.elemento;
    }

    /**
     * Elimina el último elemento de la lista y lo regresa.
     * @return el último elemento de la lista antes de eliminarlo.
    
     */
    public T eliminaUltimo() {
        if(isEmpty())
        throw new NoSuchElementException();
        Nodo m=rabo;
   if(longitud==1) clear();
    else{
        rabo=rabo.anterior;
        rabo.siguiente=null;
        longitud--; 
        
        
    }
    return m.elemento; 
        
    }

    /**
	 * Verifica si un elemento está contenido en la lista.
	 * @param e el elemento a verificar si está contenido.
	 * @return true si el elemento está contenido, false en otro caso.
	 */
    @Override
    public boolean contains(T elemento)  {
       
       if(buscaNodo(elemento) != null){//recorre y compara desde el rabo y la cabeza

        return true;
    }else{
        return false;
    }
        
    }

    /**
	 * Revierte los elementos de la lista. Esto es, da la reversa de la lista.
	 */
    @Override
    public void revert() {
        DoubleLinkedList l = new DoubleLinkedList();
        Nodo m=rabo;
        while(m!=null){
            l.agregaFinal(m.elemento);
            m=m.anterior;
        }
 }
/**
 * * Revierte los elementos de la lista. Esto es, da la reversa de la lista.
 * @return la lista para poder probarla en el main
 */
 public DoubleLinkedList<T> revert2(){
 	DoubleLinkedList l = new DoubleLinkedList();
        Nodo m=rabo;
        while(m!=null){
            l.agregaFinal(m.elemento);
            m=m.anterior;
        }
        return l;
 }
     
   
    /**
     * Limpia la lista de elementos, dejándola vacía.
     */
    @Override
    public void clear() {
       cabeza=rabo=null;
        longitud=0;
        
    }
     public void elimina(T elemento) {
        Nodo m = buscaNodo(elemento);
        if(m == null)return;
       else if(buscaNodo(m.elemento) == null) return;
       else if(longitud==1 && cabeza.elemento.equals(m.elemento))
            clear();
        else if(m.equals(rabo))
            eliminaUltimo();
        else if(m.equals(cabeza))
            eliminaPrimero();
        else{
            m = buscaNodo(elemento);
            m.anterior.siguiente=m.siguiente;
            m.siguiente.anterior=m.anterior;
            longitud--;
        }
        
    }

   

   /**
	 * Obtiene el elemento en la posición <i>i</i>.
	 * @param i el índice a obtener elemento.
	 * @throws IndexOutOfBoundException si el índice está fuera de rango.
	 */
    @Override
    public T get(int i) throws IndexOutOfBoundsException{
    if(i<0 || i>=longitud)
    throw new IndexOutOfBoundsException();
    int j=longitud/2;
    Nodo n;
        if(i<=j){
         n=cabeza;
            while(i-- >0){
            n=n.siguiente;
            }
                }else{
                    n=rabo;
                while(i-- >0){
                n=n.anterior;
        }
    }
    return n.elemento;
        
    }

   
   /**
	 * Da una cadena con los elementos contenidos en la lista.
	 * @return una representación de la lista.
	 */
    @Override public String toString() {
       if(isEmpty())
        return "";
        String s ="[";
    for (int i = 0; i < longitud-1; i++)
            s += String.format("%s, ", get(i));
        s += String.format("%s]", get(longitud-1));
        return s;
        
    }
    /**
	 * Da la mitad derecha o izquierda de una lista.
	 * @param side la mitad que recortar de la lista original.
	 * true - mitad derecha.
	 * false - mitad izquierda.
	 * @return una nueva lista con la mitad de los elementos.
	 */
    @Override
  	public DoubleLinkedList<T> cut(boolean side){
  		DoubleLinkedList l= new DoubleLinkedList();
  		Nodo m=cabeza;
        int j=longitud;
        Nodo n=buscaNodo(get(j/2));
        if(side){//verifica el aldo que se pide para cumplir la complejidad
        while(n!=null){
            
            l.agregaFinal(n.elemento);
            n=n.siguiente;
        }
        
    
   }else{
    for(int i=0; i<j/2; i++){
            l.agregaFinal(m.elemento);
            m=m.siguiente;
        }
        

   }

   return l; 
}
}

