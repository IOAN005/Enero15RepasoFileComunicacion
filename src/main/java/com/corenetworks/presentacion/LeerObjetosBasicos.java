package com.corenetworks.presentacion;

import com.corenetworks.modelo.Pedido;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class LeerObjetosBasicos {
    public static void main(String[] args) {
        Pedido p1 = null;
        try (FileInputStream f1 = new FileInputStream("pedidos.dat");
             ObjectInputStream o1 = new ObjectInputStream(f1)) {
            while (true) {
                p1 = (Pedido) o1.readObject();
                if (p1 == null) {
                    break;
                }
                System.out.println(p1.toString());
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.toString());
        } catch (IOException e) {
            System.out.println(e.toString());
        } catch (ClassNotFoundException e) {
            System.out.println(e.toString());
        }
    }
}