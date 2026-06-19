package modelo;
import java.util.Random;

public class JuegoAhorcado {
    private String palabra;
    private char letra;
    private int errores;
    private String display;
    private boolean[] correctas;
    private String[] palabras={"MEXICO","ESPAÑA","BRASIL","FRANCIA","JAPON",
        "INGLATERRA","ITALIA","ARGENTINA","COLOMBIA","SUDAFRICA"};

    public String getPalabra(){
        return palabra;
    }

    public String getDisplay(){
        return display;
    }

    public int getErrores(){
        return errores;
    }

    public void setLetra(char letra){
        this.letra= letra;
    }

    public boolean validar(){
        boolean ban= false;
        for(int i=0;i<palabra.length();i++){
            if(palabra.charAt(i)==letra){
                correctas[i]= true;
                ban= true;
            }
        }
        if(!ban){
            errores++;
        }
        return ban;
    }

    public void seleccionarPalabra(){
        Random aleatorio= new Random();
        int x;
        x= aleatorio.nextInt(palabras.length);
        palabra= palabras[x];
        correctas= new boolean[palabra.length()];
    }

    public void generarDisplay(){
        int tam= palabra.length();
        display="";
        for(int i=0;i<tam;i++){
            if(correctas[i]){
                display+= palabra.charAt(i)+" ";
            }else{
                display+= "_ ";
            }
        }
    }

    public boolean yaGano(){
        boolean banOk= true;
        for(int i=0;i<correctas.length;i++){
            if(!correctas[i]){
                banOk= false;
                break;
            }
        }
        return banOk;
    }

    public boolean yaPerdio(){
        return (errores==7);
    }
}
