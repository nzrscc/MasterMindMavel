package it.mastermind.services;

import it.mastermind.models.TryModel;

public class TryService {
    private TryModel tryModel;

    public TryService(TryModel tryModel) {
        this.tryModel=tryModel;
    }

    public void save(int []input,int[]esito)
    {
        String numeri=input.toString();
        int posEsatta=esito[0];
        int numEsatto=esito[1];
        this.tryModel.popolaTabella(posEsatta,numEsatto,numeri);
    }

    public void retrieve()
    {

    }
}
