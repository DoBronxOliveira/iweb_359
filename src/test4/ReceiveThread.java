package test4;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

/**
 * @author Tan
 * @date 2023/6/8 14:28
 */
public class ReceiveThread extends Thread {
    private Socket s;

    public ReceiveThread(Socket s) {
        this.s = s;
    }

    @Override
    public void run() {
        InputStream is = null;
        try {
            is = s.getInputStream();
            DataInputStream dis = new DataInputStream(is);
            while (true) {
                System.out.println(dis.readUTF());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}