/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TicTacToe;

import javafx.scene.layout.Pane;

/**
 *
 * @author OWNER
 */
public class AllPanes {
    
    static RegisterMenu registerMenu = new RegisterMenu();
    static PlayerData playerData = new PlayerData();
    static MainMenu mainMenu = new MainMenu();  
    static SingleplayerLevels SingleplayerLevels =new SingleplayerLevels();
    static MultiplayerOptions multiplayerOptions = new MultiplayerOptions();
    static LocalMultiplayerOptions localMultiplayerOptions = new LocalMultiplayerOptions();
    static XOGame xoGame = new XOGame();
    static XOGame_MultiPlayer xoGame_MultiPlayer = new XOGame_MultiPlayer();
    static NetworkMultiplayerOptions networkMultiplayerOptions  = new NetworkMultiplayerOptions();
    static IpNetwork ipNetwork = new IpNetwork();
    static Record record = new Record();
    static XORecords xoRecords=new XORecords();
    
    
    public static void viewPane(Pane pane)
    {
        registerMenu.setVisible(false);
        playerData.setVisible(false);
        mainMenu.setVisible(false);
        SingleplayerLevels.setVisible(false);
        multiplayerOptions.setVisible(false);
        localMultiplayerOptions.setVisible(false);
        xoGame.setVisible(false);
        xoGame_MultiPlayer.setVisible(false);
        networkMultiplayerOptions.setVisible(false);
        record.setVisible(false);
        xoRecords.setVisible(false);
        
        
        pane.setVisible(true);
    }

}
