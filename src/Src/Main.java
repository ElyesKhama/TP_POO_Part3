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
                agent = new Agent();
                AgentFrame game = new AgentFrame(agent);
                game.setVisible(true);
            }
        });
    }
}