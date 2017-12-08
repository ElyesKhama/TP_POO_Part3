package Src;

import java.io.IOException;
import java.net.*;
import java.util.ArrayList;

public class User {
    private String pseudo;
    private DatagramSocket socket_envoi;
    private DatagramSocket socket_ecoute;
    private ArrayList<String> listUser;


    public User(String pseudo){
        listUser = new ArrayList<>();
        try {
            this.socket_envoi = new DatagramSocket();

            this.socket_ecoute = new DatagramSocket(45047);
        }

        catch (SocketException e) {
            e.printStackTrace();
        }
        this.pseudo = pseudo;
    }

    public User(String pseudo, int i){
        listUser = new ArrayList<>();
        try {
            this.socket_envoi = new DatagramSocket();
            if (i == 1) {
                this.socket_ecoute = new DatagramSocket(45047);
            }
            else if (i == 2) {
                this.socket_ecoute = new DatagramSocket(45048);
            }
        }

        catch (SocketException e) {
            e.printStackTrace();
        }
        this.pseudo = pseudo;
    }

    public User(boolean bool,String pseudo){
        this.pseudo = pseudo;
    }

    public String getPseudo(){
        return this.pseudo;
    }

    public void setPseudo(String pseudo){
        this.pseudo = pseudo;
    }
    @Override
    public String toString() {
        return this.pseudo;
    }

    public void sendMessageBroadcast() throws IOException {
        String data = pseudo ;
        socket_envoi.setBroadcast(true);
        InetAddress address = InetAddress.getByName("255.255.255.255"); //mettre l'adresse de broadcast directement
        DatagramPacket packet = new DatagramPacket(data.getBytes(),
                data.getBytes().length, address, 45047);
        DatagramPacket packet2 = new DatagramPacket(data.getBytes(),
                data.getBytes().length, address, 45048);

        socket_envoi.send(packet);
        socket_envoi.send(packet2);
    }

    public void sendMessage(){

    }

    public void receiveMessage() throws IOException {
        while (true) {
            System.out.println("Jattends de recevoir un message <<< bloqué");

            byte[] recvBuf = new byte[1024];
            DatagramPacket recvPacket = new DatagramPacket(recvBuf, recvBuf.length);

            socket_ecoute.receive(recvPacket);
            System.out.println("Jai recu le message >>> non bloqué ");

            String recvStr = new String(recvPacket.getData(), 0, recvPacket.getLength());
            InetAddress addr = recvPacket.getAddress();
            listUser.add(recvStr + " " + addr);
            int port = recvPacket.getPort();
            System.out.println("nouveau client : " + recvStr + "\n voici son adresse IP : " + addr + " et voici son port : " + port);

            System.out.println("voici ma nouvelle liste des utilisateurs présents : ");

            for (String s : listUser) {
                System.out.println(s);
            }
        }
    }

}