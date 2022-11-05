package com.mycompany.lab4p1_joselobo;

import java.util.Scanner;

/**
 *
 * @author jose lobo
 */
public class Lab4P1_JoseLobo {

    static Scanner leer = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        do {
            System.out.println("Menu");
            System.out.println("1-->Sumador binario");
            System.out.println("2-->Contains");
            System.out.println("3-->Alpha");
            System.out.println("4-->Salir");
            System.out.println("Ingrese su opcion: ");
            opcion = leer.nextInt();
            switch (opcion) {
                case 1 -> {
                    boolean valido;
                    String num1, num2 = "";
                    do {
                        System.out.println("Ingrese su numero: ");
                        num1 = leer.next();
                        valido = validarsuma(num1);
                    } while (valido == false);
                    do {
                        if (num2.length() != num1.length()) {
                            System.out.println("Los numero tienes que tener la misma cantidad de dijitos");
                        }//if
                        System.out.println("Ingrese su segundo numero: ");
                        num2 = leer.next();
                        valido = validarsuma(num2);
                    } while (valido == false || num2.length() != num1.length());
                    Sumador(num1, num2);
                }//case 1
                case 2 -> {
                    contain();
                }//case 2
                case 3 -> {
                    Alpha();
                }//case3
                case 4 -> {
                    System.out.println("Saliendo...");
                }//salir
                default -> {
                    System.out.println("Invalido");
                }//error
            }//switch
        } while (opcion != 4);//fin while opcion
    }//fin main

    public static boolean validarsuma(String bi) {
        boolean valido = true;
        int num;
        String carnum;
        char letra;
        for (int i = 0; i < bi.length(); i++) {
            letra = bi.charAt(i);
            carnum = String.valueOf(letra);
            num = Integer.parseInt(carnum);
            if (num > 1 || num < 0) {
                valido = false;
            }//validacion if
        }//for
        if (valido == false) {
            System.out.println("Numero invalido");
        }//if valido
        return valido;
    }//validacion

    public static void Sumador(String strnum1, String strnum2) {
        int num1, num2, num3 = 0, respuestanum;
        char cnum1, cnum2;
        String snum1, snum2;
        String respuestaacum = "", respuesta;
        for (int i = strnum1.length() - 1; i >= 0; i--) {
            cnum1 = strnum1.charAt(i);
            snum1 = String.valueOf(cnum1);
            num1 = Integer.parseInt(snum1);
            cnum2 = strnum2.charAt(i);
            snum2 = String.valueOf(cnum2);
            num2 = Integer.parseInt(snum2);
            int respuestanum2 = num1 + num2 + num3;
            if (respuestanum2>=2){
                num3=1;
            }//sumra 
            else{
                num3=0;
            }
            respuestanum = respuestanum2 % 2;
            respuesta = String.valueOf(respuestanum);
            respuestaacum += respuesta;
        }//for
        respuestaacum += num3;
        String acum2="";
        for (int i = respuestaacum.length()-1;i>=0;i--){
            char letra = respuestaacum.charAt(i);
            acum2+=letra;
        }//for
        System.out.println(acum2);
    }//fin sumador

    public static void contain() {
        char letra, letra2;
        boolean respuesta = false;
        System.out.println("Ingrese la primera cadena: ");
        String palabra = leer.nextLine();
        //arreglar error de enter
        palabra = leer.nextLine();
        System.out.println("Ingrese la segunda cadena: ");
        String palabra2 = leer.nextLine();
        while (palabra.length() < palabra2.length()) {
            System.out.println("no se permite que sea mas largo: ");
            palabra2 = leer.nextLine();
        }//while
        char letra3 = palabra2.charAt(0);
        for (int i = 0; i < palabra.length(); i++) {
            letra = palabra.charAt(i);
            if (letra == letra3) {
                respuesta = true;
                for (int h = 0; h < palabra2.length(); h++) {
                    letra2 = palabra2.charAt(h);
                    letra = palabra.charAt(i);
                    if (letra != letra2) {
                        respuesta = false;
                    }//if
                    i++;
                }//for
            }//if
        }//for
        if (respuesta == true) {
            System.out.println("la cadena " + palabra + " contiene la cadena " + palabra2);
        }//if si
        else {
            System.out.println("la cadena " + palabra + " no contiene la cadena " + palabra2);
        }

    }//contain

    public static void Alpha() {
        System.out.println("Ingrese la cadena: ");
        String cadena = leer.nextLine();
        cadena = leer.nextLine();
        char letra;
        boolean valido, resultado = true;
        for (int n = 0; n < cadena.length(); n++) {
            letra = cadena.charAt(n);
            valido = false;
            for (int i = 97; i <= 122; i++) {
                //tabla ASCII
                if (i == (int) letra) {
                    valido = true;
                }//if
            }//for
            if (valido == false) {
                resultado = false;
            }//valido?
        }//for palabrafinal
        if (resultado == false) {
            System.out.println("La cadena contiene caracteres que no son letras");
        } else {
            System.out.println("La cadena solo contiene letras");
        }//else
    }//alpha
}//fin public class
