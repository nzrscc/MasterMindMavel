package it.mastermind.services;

import java.util.ArrayList;
import java.util.Scanner;

public class ValidatorService {

    private Scanner in = new Scanner(System.in);
    private char controllore = 'S';
    private int [] input=new int[3];

    public int[] controlloInput() {
        int i = 0;
        ArrayList<String> inputDaTastiera = new ArrayList<String>();
        System.out.println();
        do {
            System.out.print("Inserire "+(i+1)+"° numero \t");
            inputDaTastiera.add(in.nextLine());
            if (inputDaTastiera.get(i).matches("[0-9]*")) {
                if (inputDaTastiera.get(i).matches("[0-9]")) {
                    controllore = 'S';
                    i++;
                } else {
                    System.out.println("\nInserire un numero da 0 a 9!\n");
                    controllore = 'N';
                    inputDaTastiera.remove(i);
                }
            } else {
                System.out.println("\nInserire numero!\n");
                controllore = 'N';
                inputDaTastiera.remove(i);
            }
        } while (controllore == 'N' || i < 3);
        for(int k=0;k<inputDaTastiera.size();k++)
        {
            this.input[k]=Integer.parseInt(inputDaTastiera.get(k));
        }
        return input;
    }

}
