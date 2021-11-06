package fciencias.edatos.proyecto01;
import fciencias.edatos.proyecto01.DoubleLinkedList;
import fciencias.edatos.proyecto01.Carta;
import java.util.Random;

public class Baraja{

public int n;

public Carta carta;
//una lista de listas que contiene la baraja completa//
public DoubleLinkedList<Carta> conjunto;


public Baraja(){
Random rn=new Random();
int random;
random = rn.nextInt(51);//ya que se quita una carta de la baraja original
carta=new Carta();
this.n=n;
DoubleLinkedList<Integer> auxiliar = new DoubleLinkedList<>();
conjunto=new DoubleLinkedList<>();
this.n=52;
generaCarta();
generaCarta2();
//genera una carta y la añade a l baraja, no habra cartas repetidas//
while(!generaCarta().equals(generaCarta2())&&conjunto.size()==51){
generaCarta();
random = rn.nextInt(51);
generaCarta2();
if(!generaCarta().equals(generaCarta2()))
conjunto.add(0,generaCarta());	

}
}

public DoubleLinkedList<Carta> getBaraja(){
Random rn=new Random();
int random;
random = rn.nextInt(51);//ya que se quita una carta de la baraja original
DoubleLinkedList<Integer> auxiliar = new DoubleLinkedList<>();
conjunto=new DoubleLinkedList<>();
this.n=52;
generaCarta();
generaCarta2();
while(!generaCarta().equals(generaCarta2())&&conjunto.size()==51){
generaCarta();
random = rn.nextInt(51);
generaCarta2();
if(!generaCarta().equals(generaCarta2()))
conjunto.add(0,generaCarta());	
}

return conjunto;


}

//genera una carta con valores random
public Carta generaCarta(){
Random rn=new Random();
int color;
color = rn.nextInt(2);
Random sn=new Random();
int tipo;
tipo = sn.nextInt(7);

Random tn=new Random();
int rango;
rango = tn.nextInt(13);

Carta random=new Carta(color,tipo,rango);

return random;
}
public Carta generaCarta2(){
Random rn=new Random();
int color;
color = rn.nextInt(2);
Random sn=new Random();
int tipo;
tipo = sn.nextInt(7);

Random tn=new Random();
int rango;
rango = tn.nextInt(13);

Carta random=new Carta(color,tipo,rango);

return random;
}

}