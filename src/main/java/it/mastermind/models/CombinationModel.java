package it.mastermind.models;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class CombinationModel {
    private Dao instanceDao;
    private String username;
    private String timeStamp;

    public CombinationModel(Dao instanceDao) {
        this.instanceDao=instanceDao;
    }

    public void popolaTabella(int [] soluzione)
    {
        Scanner in=new Scanner(System.in);
        System.out.print("Inserire username:\t");
        this.username=(in.nextLine());
        this.timeStamp = new SimpleDateFormat("dd.MM.yyyy - HH.mm.ss").format(new Date());
        String sql = "INSERT INTO COMBINATION (ID, User, Soluzione, Data_Operazione) " +
                "VALUES ('0', '"+ this.username + "', '" + Arrays.toString(soluzione) +  "', '" + this.timeStamp + "')";
        instanceDao.popolaTabella(sql);
    }



    /*
    public void PopolaTabella(Vettori esecuzione, ControlloNumeri controlloNumeri) {
        timeStamp = new SimpleDateFormat("dd.MM.yyyy - HH.mm.ss").format(new Date());
        try {
            String sql = "INSERT INTO ESECUZIONI (Tentativi, Soluzione, Prova, NumeriInPosizioneEsatta, NumeriInPosizioneSbagliata, Data_Operazione) " +
                    "VALUES ('" + esecuzione.getTentativi() + "', '" + Arrays.toString(esecuzione.getSoluzione()) + "', '" + Arrays.toString(esecuzione.getNumeri())
                    + "', '" + controlloNumeri.getPosizioneEsatta() + "', '" + controlloNumeri.getNumeriEsatti() + "', '" + timeStamp + "')";
            this.stmt.executeUpdate(sql);
            System.out.println("Record aggiunto!!\n");
        } catch (SQLException var3) {
            var3.printStackTrace();
        }

    }*/



}
