package com.example.tallerlistview;

import java.util.ArrayList;

public class Datos{
    private static ArrayList<Operation> operations = new ArrayList();

    public static void save(Operation operation){
        operations.add(operation);
    }

    public static ArrayList<Operation> get(){
        return operations;
    }
}
