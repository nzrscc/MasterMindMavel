package it.mastermind.services;

import it.mastermind.models.TryModel;

import java.util.Arrays;

public class TryService {
    private TryModel tryModel;

    public TryService(TryModel tryModel) {
        this.tryModel=tryModel;
    }

    public void save(int tentativi, int []input,int[]esito)
    {
        String numeri= Arrays.toString(input);
        int posEsatta=esito[0];
        int numEsatto=esito[1];
        this.tryModel.popolaTabella(tentativi,posEsatta,numEsatto,numeri);
    }

    public void retrieve()
    {

    }
}
