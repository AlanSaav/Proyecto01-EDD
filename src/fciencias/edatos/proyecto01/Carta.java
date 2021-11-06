package fciencias.edatos.proyecto01;

/*Estoy utilizando como base la baraja inglesa
*para crear una carta
*/
public class Carta{
public int numero;
//color de la carta//
public int color;
//tipo de carta//
public int tipo;
//como se dividiran las cartas//
public int division;
//el rango de las cartas//
public int rango;
//método constructor
public Carta(int color, int tipo, int rango){
	this.color=color;
	this.numero=numero;
	this.tipo=tipo;
	this.rango=rango;
}
public Carta(){
	this.color=color;
	this.numero=numero;
	this.tipo=tipo;
	this.rango=rango;
}
public int numero(){
return numero;
}

public String color(){
	String colores = new String();
		
		switch (color) {
		case 0:  
		colores = "Rojo";
		break;
		case 1:  
		colores = "Negro";
		break;
		default: colores = "color invalido";
		break;
		}
		return colores;
}

public String tipo(){
	String tipos=new String();
	switch(tipo){
		case 0:
		tipos = "treboles";
		break;
		case 1:
		tipos ="diamantes";
		break;
		case 2:
		tipos ="corazones";
		break;
		case 3:
		tipos ="picas";
		break;
		case 4:
		tipos="Jack";
		break;
		case 5:
		tipos="Reina";
		break;
		case 6:
		tipos="Rey";
		break;
		default: tipos="tipo invalido";
		break;

	}
	return tipos;
}

public String rango(){

		String rangos = new String();
		switch (rango) {
		case 0:  rangos = "A";
		break;
		case 1:  rangos = "dos";
		break;
		case 2:  rangos = "tres";
		break;
		case 3:  rangos = "cuatro";
		break;
		case 4:  rangos = "cinco";
		break;
		case 5:  rangos = "seis";
		break;
		case 6:  rangos = "siete";
		break;
		case 7:  rangos = "ocho";
		break;
		case 8:  rangos = "nueve";
		break;
		case 9:  rangos = "diez";
		break;
		case 10: rangos = "J";
		break;
		case 11: rangos = "Q";
		break;
		case 12: rangos = "K";
		break;
		default: rangos = "rango invalido";
		break;
		}
		return rangos;
}

}

