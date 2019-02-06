package it.mastermind.models;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class TryModel  {
    private Dao instanceDao;
    private String timeStamp;

    public TryModel(Dao instanceDao) {
        this.instanceDao=instanceDao;
    }

    public void popolaTabella(int posEsatta, int numEsatto, String numeri)
    {
        this.timeStamp = new SimpleDateFormat("dd.MM.yyyy - HH.mm.ss").format(new Date());
        //String sql = "INSERT INTO COMBINATION (ID, User, Soluzione, Data_Operazione) " +
               // "VALUES ('0', '"+ this.username + "', '" + Arrays.toString(soluzione) +  "', '" + this.timeStamp + "')";
        //instanceDao.popolaTabella(sql);
    }
}
