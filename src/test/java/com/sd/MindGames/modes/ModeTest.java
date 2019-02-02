package com.sd.MindGames.modes;


import com.sd.MindGames.games.Game;
import com.sd.MindGames.games.MastermindGame;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;


class ModeTest {

    static private Game game;
    static private Mode mode;

   @BeforeAll
   static void initialize(){
       game=new MastermindGame();
       mode=new Challenger(game);
   }


    @Test
    void testConvertStringToTabOfInt() {
        String testString="12345";
        int[] tabExpected ={1,2,3,4,5};
        assertArrayEquals(mode.convertStringToTabOfInt(testString), tabExpected, "conversion en tab ok");

        testString="12d45";
        assertNull(mode.convertStringToTabOfInt(testString), "NumberFormatException, tab=null");
    }

    @Test
    void testCheckFormatOfResponse() {

        int[] combiTest= new int[game.getLongueurCombinaison()];
        assertTrue(mode.checkFormatOfResponse(combiTest), "longueur ok");

        combiTest= new int[game.getLongueurCombinaison()+1];
        assertFalse(mode.checkFormatOfResponse(combiTest), "longueur differente");

        combiTest=null;
        assertFalse(mode.checkFormatOfResponse(combiTest), "combinaison null");
    }

}