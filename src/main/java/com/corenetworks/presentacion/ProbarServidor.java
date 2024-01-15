package com.corenetworks.presentacion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ProbarServidor {

        public static void main(String[] args) throws IOException {
            PrintWriter fSalida;
            BufferedReader buffer;
            String respuesta="";

            int cantidad=0;

            try (
                    //instanciar
                    ServerSocket servidor = new ServerSocket(3000)){

                while (true) {
                    System.out.println("espera de peticion ");
                    Socket s1 = servidor.accept();
                    buffer = new BufferedReader(new InputStreamReader(s1.getInputStream()));
                    respuesta=buffer.readLine();
                    System.out.println(respuesta);
                    System.out.println(respuesta.substring(10).strip());
                    cantidad=Integer.parseInt(respuesta.substring(10).strip());

                    fSalida = new PrintWriter(s1.getOutputStream(),true);
                    fSalida.printf("El total de su compra es de %2f€ ",(cantidad*2.0));
                }

            } catch (IOException e) {
                System.out.println(e.toString());
            }
        }
    }

