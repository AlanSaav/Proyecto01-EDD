package fciencias.edatos.practica03;
import java.util.EmptyStackException;
import fciencias.edatos.practica03.DoubleLinkedList;

/**
 * Implementa la interfaz TDAStack en la clase llamada Stack
 * Basada en una lista doblemente ligada de la practica 02
 * Practica 03 del curso Estructura de Datos
 * @author Góngora Ramírez Dania Paula numero de cuenta: 3181274
 * @author Herrera Saavedra Alan numero de cuenta:421055951
 * @version 2 de noviembre 2021.
 */

public class Stack<T> implements TDAStack<T> {
    /** Nuestra lista de la practica 02 */
    public DoubleLinkedList<T> lista = new DoubleLinkedList<T>();
    
	/**
	 * Limpia la pila. Elimina todos los elementos.
	 */
    @Override
	public void clear(){
        lista.clear();

    }

	/**
	 * Verifica si la pila está vacía.
	 * @return true si la pila no contiene elementos, false en otro caso.
	 */
    @Override
	public boolean isEmpty(){
        return lista.isEmpty();

    }

	/**
	 * Remueve y regresa el tope de la pila.
	 * @return el tope de la pila.
	 * @throws EmptyStackExpception si la pila está vacía.
	 */
    @Override
	public T pop() throws EmptyStackException{
        if(lista.isEmpty())
        throw new  EmptyStackException();

        return lista.remove(0);

    }

	/**
	 * Agrega un nuevo elemento a la pila.
	 * @param e el elemento a agregar.
	 */
    @Override
	public void push(T e){
    lista.agregaInicio(e);
	
	
	
    }


	/**
	 * Regresa el tope de la pila.
	 * @throws EmptyStackExpception si la pila está vacía.
	 */
    @Override
	public T top() throws EmptyStackException{
        if(lista.isEmpty())
        throw new EmptyStackException();

        return lista.get(0);
    }


}
