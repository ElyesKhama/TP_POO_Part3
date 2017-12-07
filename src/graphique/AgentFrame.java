package graphique;

import javax.swing.*;
import Src.Agent;

public class AgentFrame extends JFrame{

    private JPanel agentJPanel;

    public void initUI() {
        setTitle("Clavardage");
        setSize(800, 420);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.setVisible(true);

    }

    public AgentFrame(Agent agent) {
        // Initialize the interface
        initUI();
        agentJPanel = new AgentJPanel(agent);
        this.setContentPane(agentJPanel);




    }

}
