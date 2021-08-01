package principal;

import java.util.Scanner;

public class Datos_Entrada {
	
	
    private static int jugadores;
    private static int distancia;
    private static String nick;
    private static String carro;

    public static int numJugadores(){
        System.out.println("Ingresa el numero de jugadores");
        Scanner valor =new Scanner(System.in);
        jugadores = valor.nextInt();
        if(jugadores<3) {
        	System.out.println("Debes traer mas amigos para empezar el juego");
        	Datos_Entrada datos = new Datos_Entrada();
        	datos.numJugadores();
        }
        return jugadores;
    }
    
    public static String nombreJugador(){
        System.out.println("Ingresar Nickname");
        Scanner valor =new Scanner(System.in);
        nick=valor.next();
        return nick;
    }

    public static int largoPista(){
        System.out.println("Por favor ingresar cuantos kilometros tendrá la pista");
        Scanner valor =new Scanner(System.in);
        int kilometros = valor.nextInt();
        distancia = kilometros * 1000;
        if(distancia==0){
            System.out.println("No puedes poner 0 km, por defecto la pista será de 1 km");
            distancia = 1000;
        }
        return distancia;
    }
    
    public static String escogerCarro(int i){
        System.out.println("Selecciona el color del carro:\n" + "1- Rojo" + " 2- Verde"+ " 3- Azul");
        Scanner valor =new Scanner(System.in);
        int color = valor.nextInt();
        if(color>4 || color<=0){
            System.out.println("No se seleccionó color, por lo tanto el juego te asigna carro color Azul");
            color=3;
        }
        switch (color){
            case 1: carro = "Rojo";
                break;
            case 2: carro = "Verde";
                break;
            default: carro = "Azul";
                break;
        }
        return carro;
    }
    public static String id(int i){
        System.out.println("Información del jugador "+i);
        return String.valueOf(i);
    }

    

}
