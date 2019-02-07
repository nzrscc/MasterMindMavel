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
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO COMBINATION (ID, User, Soluzione, Data_Operazione) VALUES ('0','");
        sql.append(this.username);
        sql.append("','");
        sql.append(Arrays.toString(soluzione));
        sql.append("','");
        sql.append(this.timeStamp);
        sql.append("')");
        /*String sql = "INSERT INTO COMBINATION (ID, User, Soluzione, Data_Operazione) " +
                "VALUES " +
                "('0', '"+ this.username + "', '" + Arrays.toString(soluzione) +  "', '" + this.timeStamp + "')";*/
        instanceDao.popolaTabella(sql);
    }

    /*public int prendiID()
    {

    }*/

}
