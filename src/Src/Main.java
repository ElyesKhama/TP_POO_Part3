package Src;

import graphique.AgentFrame;

import javax.swing.*;
import java.io.IOException;
import java.net.SocketException;

public class Main {

    private static Agent agent;
    public static Agent getAgent(){
        return agent;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                try {
                    agent = new Agent();
                } catch (SocketException e) {
                    e.printStackTrace();
                }
                AgentFrame game = new AgentFrame(agent);
                game.setVisible(true);
            }
        });



    }
}
