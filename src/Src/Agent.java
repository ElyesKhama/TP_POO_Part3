package Src;

import java.io.IOException;
import java.net.*;
import java.util.ArrayList;

public class Agent {


    private ArrayList<User> listUser;
    public static boolean start = false;

    public Agent() {
            listUser = new ArrayList<User>();
        }

    public void addUser(String pseudo, int i) throws IOException {
        if (this.unicityPseudo(pseudo)) {

            //Gestion User
            start = true;
            User user = new User(pseudo, i);
            listUser.add(user);
            System.out.println("Utilisateur : " + pseudo + " bien crée");

            Thread threadReceive = new Thread(() -> {
                try {

                    user.receiveMessage();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });


            Thread threadAdd = new Thread(() -> {
                try {
                    user.sendMessageBroadcast();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });


            threadAdd.start();
            threadReceive.start();



        } else {
            System.out.println("Pseudo déjà existant");
        }
    }

    public void printAllUser() {
        System.out.println("Liste des utilisateurs présents sur l'agent : \n");
        for (User user : listUser) {
            System.out.println(user.toString());
        }
    }

    public boolean unicityPseudo(String pseudo) {
        for (User user : listUser) {
            if (user.getPseudo().equals(pseudo)) {
                return false;
            }
        }
        return true;
    }

    public void changePseudo(User user, String pseudo) {
        if (this.unicityPseudo(pseudo)) {
            user.setPseudo(pseudo);
            System.out.println("Pseudo mis à jour \n Nouveau pseudo : " + pseudo);
        } else {
            System.out.println("Pseudo déjà existant");
        }
    }

    public User getUser() {
        if (listUser.isEmpty())
            return null;
        return listUser.get(0);
    }

}