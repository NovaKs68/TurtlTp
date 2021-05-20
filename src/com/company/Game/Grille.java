package com.company.Game;

import com.company.model.Bank;
import com.company.model.Player;
import com.company.model.Position;
import com.company.model.Case;

import java.util.Arrays;
import java.util.List;
import java.util.Collections;

/**
 * Object grille contain all pawns
 */
public class Grille {
    private int grilleWidth;
    private int grilleHeight;
    private int numberOfCases;

    private int numberGreenPawn = 0;
    private int numberRedPawn = 0;

    /**
     * grid contain all cases
     */
    private Case[][] setupGrid;

    private Position actualPosition = new Position(0, 0);

    public Grille(int grilleWidth, int grilleHeight) {
        this.grilleWidth = grilleWidth;
        this.grilleHeight = grilleHeight;

        // Setup the grille
        setupGrid = new Case[grilleWidth][grilleHeight];

        numberOfCases = grilleHeight * grilleWidth;

        calculateNumberOfpawn();

        generateGrille();

        initPlayerAndBank();
    }

    public Position getActualPosition() {
        return actualPosition;
    }

    /**
     * Methods for move forward
     * @param numberOfDice: int
     */
    public String moveForward(int numberOfDice) {
        return "String";
    }

    /**
     * Calculate the number of green and red pawn
     */
    private void calculateNumberOfpawn() {
        if ((grilleHeight * grilleWidth) %2 == 0){
            numberGreenPawn = (grilleHeight * grilleWidth)/2;
            numberRedPawn = (grilleHeight * grilleWidth)/2;
        } else{
            numberGreenPawn = ((grilleHeight * grilleWidth)/2)+1;
            numberRedPawn = ((grilleHeight * grilleWidth)/2)+1;
        }
    }

    /**
     * Calculate a third of the number
     * @param number: int
     * @return : int
     */
    private int thirdNumberOfCases(int number) {
        // Calculate a third of the grille
        int thirdNumberOfCases;
        if (numberOfCases % 3 == 0) {
            thirdNumberOfCases = numberOfCases / 3;
        } else {
            thirdNumberOfCases = (numberOfCases / 3) + 1;
        }

        return thirdNumberOfCases;
    }

    private void initPlayerAndBank() {
        int thirdNumberOfCases = thirdNumberOfCases(numberOfCases);

        // Init of player
        Player player = Player.getInstance();
        player.setRedPawn(numberRedPawn - thirdNumberOfCases);
        player.setLimitedRedPawn(numberOfCases / 2);

        // Init of bank
        Bank bank = Bank.getInstance();
        bank.setGreenPawn(numberGreenPawn - thirdNumberOfCases);
    }

    private void generateGrille() {

        // Calculate a third of the grille
        int thirdNumberOfCases = thirdNumberOfCases(numberOfCases);

        int lastPartOfNumberOfCases =  numberOfCases - (thirdNumberOfCases * 2);

        // Create table of green cases, red cases and none cases
        Case[] numberOfCasesWithContent1 = generateTableOfCases("Green", thirdNumberOfCases);
        Case[] numberOfCasesWithContent2 = generateTableOfCases("Red", thirdNumberOfCases);
        Case[] numberOfCasesWithoutContent = generateTableOfCases("None", lastPartOfNumberOfCases);

        Case[] numberOfCasesWithContent = new Case[numberOfCases];

        // Push every tables in same the table
        System.arraycopy(numberOfCasesWithContent1, 0, numberOfCasesWithContent, 0, thirdNumberOfCases);
        System.arraycopy(numberOfCasesWithContent2, 0, numberOfCasesWithContent, thirdNumberOfCases, thirdNumberOfCases);
        System.arraycopy(numberOfCasesWithoutContent, 0, numberOfCasesWithContent, thirdNumberOfCases + thirdNumberOfCases, lastPartOfNumberOfCases);


        // Shuffle the array
        numberOfCasesWithContent = shuffleArray(numberOfCasesWithContent);


        // Push values in setupGrille
        int indexOfNumberOfCaseWithContent = 0;
        for(int i = 0; i < setupGrid.length; i++){
            for(int j = 0; j < setupGrid[i].length; j++) {
                setupGrid[i][j] = numberOfCasesWithContent[indexOfNumberOfCaseWithContent];
                indexOfNumberOfCaseWithContent++;
            }
        }
    }

    /**
     * Generate an Array of Cases
     * @param valueOfCase: String
     * @param numberOfCase: int
     * @return Case[]
     */
    private Case[] generateTableOfCases(String valueOfCase, int numberOfCase) {
        Case[] numberOfCasesWithContent = new Case[numberOfCase];
        Arrays.fill(numberOfCasesWithContent, new Case(valueOfCase));

        return numberOfCasesWithContent;
    }

    /**
     * Shuffle an Array of Cases
     * @param tableOfCase: Case[]
     * @return Case[]
     */
    private Case[] shuffleArray(Case[] tableOfCase) {
        List<Case> shuffleList = Arrays.asList(tableOfCase);
        Collections.shuffle(shuffleList);
        return shuffleList.toArray(tableOfCase);
    }
}
