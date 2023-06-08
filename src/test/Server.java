package test;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author Tan
 * @date 2023/6/8 9:01
 */
public class Server {
    public static void main(String[] args) throws Exception {
        //创建服务器，指定端口8888
        ServerSocket ss = new ServerSocket(8888);
        //监听，接收请求
        Socket s = ss.accept();

        //根据服务器端接收到的客户端，获取对应的输入流
        InputStream is = s.getInputStream();
        //基于这个输入流，获取对应的数据输入流
        DataInputStream dis = new DataInputStream(is);
        //获取输出流
        OutputStream os = s.getOutputStream();
        DataOutputStream dos = new DataOutputStream(os);
        Scanner sc = new Scanner(System.in);
        while (true) {
            //读取输入流（对应服务器的输出流）中的信息，写入内存中的msg中
            String msg = dis.readUTF();
            System.out.println("收到的客户端信息为" + msg);
            dos.writeUTF(sc.nextLine());
        }
    }
}
