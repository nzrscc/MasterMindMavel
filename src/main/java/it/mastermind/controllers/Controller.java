package it.mastermind.controllers;

import it.mastermind.services.CombinationService;
import it.mastermind.services.TryService;
import it.mastermind.services.ValidatorService;

public class Controller {
    private ValidatorService validatorService;
    private CombinationService combinationService;
    private TryService tryService;
    private int[] soluzione=new int[3];
    private int[] input=new int[3];
    private int[] esito=new int[2];

    public Controller(ValidatorService validatorService, CombinationService combinationService, TryService tryService) {
        this.combinationService=combinationService;
        this.validatorService=validatorService;
        this.tryService=tryService;
    }

    public void creaCombinazione()
    {
        this.soluzione = this.combinationService.create();
    }

    public void verificaInput()
    {
        this.input=this.validatorService.controlloInput();
    }

    public void verificaCombinazione()
    {
        this.esito=this.combinationService.check(this.soluzione,this.input);
    }

    public boolean esitoGiocata()
    {
        if(esito[0]==3)
        {
            return true; //hai vinto
        }
        else
        {
            return false; //ritenta
        }
    }

    public void salvaGiocata()
    {
        this.tryService.save(input,esito);
    }


}
