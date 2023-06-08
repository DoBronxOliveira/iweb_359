package test;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author Tan
 * @date 2023/6/8 9:05
 */
public class Client {
    public static void main(String[] args) throws Exception {
        //创建客户端，指定ip地址和端口，客户端自己的端口由jvm分配
        Socket s = new Socket("127.0.0.1", 8888);
        OutputStream os = s.getOutputStream();
        DataOutputStream dos = new DataOutputStream(os);
        InputStream is = s.getInputStream();
        DataInputStream dis = new DataInputStream(is);
        Scanner sc = new Scanner(System.in);
        while (true) {
            //将sc输入的信息从内存写出到输出流（对应客户端的输入流）
            dos.writeUTF(sc.nextLine());
            System.out.println("收到服务器消息为" + dis.readUTF());
        }
    }
}
