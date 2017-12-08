package graphique;
import Src.Agent;
import Src.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;


public class AgentJPanel extends JPanel{

    private JButton ajoutButton;
  //  private JButton changeButton;
    private JTextField textFieldPseudo;

    public AgentJPanel(Agent agent) {
        textFieldPseudo = new JTextField("Entrez pseudo");
        ajoutButton = new JButton("Ajouter utilisateur");
        //changeButton = new JButton("Changer pseudo");
        this.add(textFieldPseudo);
        this.add(ajoutButton);
        this.setVisible(true);


        ajoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                try {
                    agent.addUser(textFieldPseudo.getText());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                agent.printAllUser();

                while (agent.start) {
                    System.out.println("start activated");
                    System.out.println("start : >>> " + agent.start);

                    try {
                        agent.getUser().receiveMessage();

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

      /*  changeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JTextField textFieldChange = new JTextField("Nouveau pseudo");
                agent.changePseudo();

            }
        }); */
      System.out.println("test git adam");

    }
}
