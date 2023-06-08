package test4;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author Tan
 * @date 2023/6/8 14:28
 */
public class SendThread extends Thread {
    private Socket s;

    public SendThread(Socket s) {
        this.s = s;
    }

    @Override
    public void run() {
        try {
            OutputStream os = s.getOutputStream();
            DataOutputStream dos = new DataOutputStream(os);
            Scanner sc = new Scanner(System.in);
            while (true) {
                dos.writeUTF(sc.nextLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
