package com.corenetworks.presentacion;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class LeerFichero {
    public static void main(String[] args) {

        try (FileReader f1= new FileReader("salida1.txt");
             FileWriter f2=new FileWriter("Mayusculas.txt")
             ;){
            String frase = "";
            int letra =0;
            while (true){

                letra=f1.read();
                frase+=Character.toString((char)letra);

                System.out.println((char) letra);
                if (letra==-1){
                    break;

                }


            }
            System.out.println();
            System.out.println();
            System.out.println(frase.toUpperCase());
            f2.write(frase.toUpperCase());
            f2.flush();


        } catch (FileNotFoundException e) {
            System.out.println(e.toString());
        } catch (IOException e) {
            System.out.println(e.toString());
        }

    }
}
