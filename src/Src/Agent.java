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

    public void addUser(String pseudo) throws IOException {
        if (this.unicityPseudo(pseudo)) {

            //Gestion User
            start = true;
            User user = new User(pseudo);
            listUser.add(user);
            System.out.println("Utilisateur : "+pseudo +" bien crée");


        }
        else
        {
            System.out.println("Pseudo déjà existant");
        }
    }

    public void printAllUser(){
        System.out.println("Liste des utilisateurs présents sur l'agent : \n");
        for (User user : listUser) {
            System.out.println(user.toString());
        }
    }

    public boolean unicityPseudo(String pseudo){
        for ( User user : listUser){
            if (user.getPseudo().equals(pseudo)) {
                return false;
            }
        }
        return true;
    }

    public void changePseudo(User user, String pseudo){
        if (this.unicityPseudo(pseudo)){
            user.setPseudo(pseudo);
            System.out.println("Pseudo mis à jour \n Nouveau pseudo : " + pseudo);
        }
        else
        {
            System.out.println("Pseudo déjà existant");
        }
    }

    public User getUser() {
        if(listUser.isEmpty())
            return null;
        return listUser.get(0);
    }

}