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
    private JLabel label_liste;

    public AgentJPanel(Agent agent) {
        textFieldPseudo = new JTextField("Entrez pseudo");
        ajoutButton = new JButton("Ajouter utilisateur");
        label_liste = new JLabel("Liste des utilisateurs présents :");

        //changeButton = new JButton("Changer pseudo");
        this.add(textFieldPseudo);
        this.add(ajoutButton);
        this.add(label_liste);
        this.setVisible(true);


        ajoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                try {
                    if(textFieldPseudo.getText().equals("user1")) {
                        agent.addUser(textFieldPseudo.getText(), 1);
                    }
                    else {
                        agent.addUser(textFieldPseudo.getText(), 2);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                agent.printAllUser();

            }
        });



      /*  changeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JTextField textFieldChange = new JTextField("Nouveau pseudo");
                agent.changePseudo();

            }
        }); */
    }
}