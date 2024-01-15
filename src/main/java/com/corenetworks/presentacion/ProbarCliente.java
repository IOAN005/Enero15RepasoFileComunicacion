package com.corenetworks.presentacion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class ProbarCliente {

        public static void main(String[] args) {
            String articulo="pera";
            int cantidad =5;
            try (Socket peticion = new Socket("localhost", 3000);
                 PrintWriter fSalida = new PrintWriter(peticion.getOutputStream(), true);) {


                fSalida.printf("%10s%d %n", articulo,cantidad);
                try (BufferedReader buffer = new BufferedReader(new InputStreamReader(peticion.getInputStream()));) {
                    System.out.println(buffer.readLine());
                }

            } catch (UnknownHostException e) {
                System.out.println(e.toString());
            } catch (IOException e) {
                System.out.println(e.toString());
            }
        }

    }



