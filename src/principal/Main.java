package principal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		
		String llegada = "";
		Map<String, List<String>> guardarDatos = new HashMap<String, List<String>>();
	    Map<Integer, Integer> recorrido = new HashMap<Integer, Integer>();
	    Integer podioFinal[] = new Integer[3];
	    System.out.println("Juego de Carros");
	    int jugadores = Datos_Entrada.numJugadores();
        int distancia = Datos_Entrada.largoPista();
        for(int i=1 ; i<=jugadores ; i++){
        	List<String> infoJugador = new ArrayList<String>();
	        infoJugador.add(Datos_Entrada.id(i));
	        infoJugador.add(Datos_Entrada.nombreJugador());
	        infoJugador.add(Datos_Entrada.escogerCarro(i));
	        guardarDatos.put(String.valueOf(i),infoJugador);
	        }	      
	        int contadorPodio=0;
	        int primero = 0;
	        do{
	            for (int i=1 ; i<=jugadores ; i++){
	                int acumularDistancia=0;
	                List<String> players = guardarDatos.get(String.valueOf(i));
	                if(!players.get(0).equals(String.valueOf(podioFinal[0])) && !players.get(0).equals(String.valueOf(podioFinal[1])) && !players.get(0).equals(String.valueOf(podioFinal[2]))){
	                    System.out.println("Es el turno de "+ players.get(1) +" para tirar el dado, ingrese cualquier numero y enter");
	                    Scanner valor =new Scanner(System.in);
	                    int dado = valor.nextInt();
	                    int dadokm = (int)(Math.random()*6+1)*100;
	                    System.out.println("El dado muestra "+(dadokm/100));
	                    
	                    if(recorrido.get(i)==null){
	                        acumularDistancia = dadokm;
	                    }else{
	                        acumularDistancia = dadokm + recorrido.get(i);
	                    }
	                    recorrido.put(i, acumularDistancia);
	                    System.out.println("Se han recorrido "+recorrido.get(i)+"m de "+distancia+"m");
	                    if(recorrido.get(i)>=distancia) {
	                    	podioFinal[contadorPodio]= Integer.valueOf(players.get(0));
	                        contadorPodio++;
	                        System.out.println("El jugador "+players.get(1)+" termina la carrera en la posición #"+contadorPodio);
	                    }
	                }
	            }
	        }while(contadorPodio<3);
	        System.out.println("Los carros llegaron a la meta y quedaron en el siguiente orden \n");
	        for(int i=0 ; i < 3 ; i++){
	            List<String> infoJugador = guardarDatos.get(""+podioFinal[i]);
	            System.out.println((i+1)+"- El participante "+infoJugador.get(1) + " con su carro de color "+infoJugador.get(2));
	            llegada = llegada + (i+1)+"- El participante "+infoJugador.get(1) + " con su carro de color "+infoJugador.get(2)+" \n";
	        }
	        Guardar_Info.podio(llegada);
	    }

}
