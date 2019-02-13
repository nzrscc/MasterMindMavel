package it.mastermind.models;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TryModel  {
    private Dao instanceDao;
    private String timeStamp;

    public TryModel(Dao instanceDao) {
        this.instanceDao=instanceDao;
    }

    public void popolaTabella(int tentativi, int posEsatta, int numEsatto, String numeri)
    {
        this.timeStamp = new SimpleDateFormat("dd.MM.yyyy - HH.mm.ss").format(new Date());
        StringBuilder sql=new StringBuilder();
        sql.append("INSERT INTO TRY (ID_COMB, ID, POS_ESATTA, NUM_ESATTO, VALORI_INSERITI, Data_Operazione) VALUES ('");
        sql.append(instanceDao.prendiID());
        sql.append("', '");
        sql.append(tentativi);
        sql.append("', '");
        sql.append(posEsatta);
        sql.append("', '");
        sql.append(numEsatto);
        sql.append("', '");
        sql.append(numeri);
        sql.append("', '");
        sql.append(this.timeStamp);
        sql.append("')");
        /*String sql = "INSERT INTO TRY (ID, POS_ESATTA, NUM_ESATTO, VALORI_INSERITI, Data_Operazione) " +
             "VALUES ('"+ tentativi + "', '" + posEsatta +  "', '" + numEsatto + "', '" + (numeri )+ "', '" + this.timeStamp + "')";*/
        instanceDao.popolaTabella(sql);
    }
}
