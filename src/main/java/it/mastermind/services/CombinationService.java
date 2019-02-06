package it.mastermind.services;

import it.mastermind.services.utils.Checker;
import it.mastermind.models.CombinationModel;


public class CombinationService  {
    private CombinationModel combinationModel;
    private Checker checkerMasterMind;
    private int [] soluzione=new int [3];

    public CombinationService(CombinationModel combinationModel, Checker checkerMasterMind) {
        this.combinationModel=combinationModel;
        this.checkerMasterMind=checkerMasterMind;
    }

    public int[] create()
    {
        for(int i=0;i<this.soluzione.length;i++)
        {
            this.soluzione[i]=(int)(Math.random()*10);
        }
        this.combinationModel.popolaTabella(this.soluzione);
        return this.soluzione;

    }

    public int [] check(int [] soluzione, int [] input)
    {
        return this.checkerMasterMind.doCheck(soluzione, input);
    }
}


