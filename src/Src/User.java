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

        System.out.println("créer socket");
        try {
            this.socket_envoi = new DatagramSocket(45046);

            this.socket_ecoute = new DatagramSocket(45047);
        }

        catch (SocketException e) {
            e.printStackTrace();
            System.out.println("socksock");
        }
        this.pseudo = pseudo;
    }

    public User(boolean bool,String pseudo){
        System.out.println("créer socket");
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
        socket_envoi.send(packet);
    }

    public void sendMessage(){

    }

    public void receiveMessage() throws IOException {

        byte[] recvBuf = new byte[1024];
        DatagramPacket recvPacket = new DatagramPacket(recvBuf, recvBuf.length);

        socket_ecoute.receive(recvPacket);

        String recvStr = new String(recvPacket.getData(), 0, recvPacket.getLength());
        InetAddress addr = recvPacket.getAddress();
        listUser.add(recvStr + " " + addr);
        System.out.println("nouveau client : " + recvStr + "\n voici son adresse IP : " + addr);
        int port = recvPacket.getPort();

    }

}