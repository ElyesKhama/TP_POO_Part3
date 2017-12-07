package Src;

import java.io.IOException;
import java.net.*;

public class User {
    private String pseudo;
    private DatagramSocket socket;

    public User(String pseudo){
        System.out.println("créer socket");
        try {
            this.socket = new DatagramSocket(45046);

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

    public void receiveMessage() throws IOException {

        byte[] recvBuf = new byte[1024];
        DatagramPacket recvPacket = new DatagramPacket(recvBuf, recvBuf.length);

        socket.receive(recvPacket);

        String recvStr = new String(recvPacket.getData(), 0, recvPacket.getLength());
        InetAddress addr = recvPacket.getAddress();
        System.out.println("nouveau client : " + recvStr + "\n voici son adresse IP : " + addr);
        int port = recvPacket.getPort();

    }

}
