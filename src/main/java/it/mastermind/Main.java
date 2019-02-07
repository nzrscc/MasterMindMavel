package it.mastermind;

import it.mastermind.controllers.Controller;
import it.mastermind.models.CombinationModel;
import it.mastermind.models.Dao;
import it.mastermind.models.TryModel;
import it.mastermind.services.CombinationService;
import it.mastermind.services.TryService;
import it.mastermind.services.ValidatorService;
import it.mastermind.services.utils.Checker;
import it.mastermind.services.utils.CheckerMasterMind;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int contatoreTentativi=1;
        Scanner in=new Scanner(System.in);
        String scelta="SI";
        Controller controller=createContext();
        controller.creaCombinazione();
        do{
            controller.verificaInput();
            controller.verificaCombinazione();
            controller.salvaGiocata(contatoreTentativi);
            contatoreTentativi++;
            if(!controller.esitoGiocata()) //equivale a dire che è falso
            {
                System.out.print("Si vuole effettuare una nuova giocata? (SI o NO)\t");
                scelta=in.nextLine();
                scelta=scelta.toUpperCase();

            }
            else if(controller.esitoGiocata()) //equivale a dire che è vero
            {
                scelta="NO";
            }
        }while(scelta.equals("SI"));

    }

    private static Controller createContext()
    {
        Checker checkerMasterMind=new CheckerMasterMind();
        Dao instanceDao=Dao.newIstance();
        TryModel tryModel=new TryModel(instanceDao);
        CombinationModel combinationModel=new CombinationModel(instanceDao);
        CombinationService combinationService=new CombinationService(combinationModel, checkerMasterMind);
        TryService tryService=new TryService(tryModel);
        ValidatorService validatorService=new ValidatorService();
        Controller controller=new Controller(validatorService, combinationService, tryService);
        return controller;
    }

}
