package test3;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Tan
 * @date 2023/6/8 11:01
 */
public class Client {
    public static void main(String[] args) {
        try {
            Socket s = new Socket("127.0.0.1", 8888);
            new SendThread(s).start();
            new ReceiveThread(s).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
