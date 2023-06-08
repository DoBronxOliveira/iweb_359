package test4;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 * 聊天室的ip地址
 * 39.106.106.39
 * @author Tan
 * @date 2023/6/8 14:10
 */
public class Client {
    public static void main(String[] args) {
        try {
            System.out.println("请输入你要访问的聊天室的ip地址");
            Scanner sc = new Scanner(System.in);
            String ip = sc.nextLine();
//建立客户端socket对象并且向服务器端发送请求
            Socket socket = new Socket(ip, 8888);
//启动发送消息和接受消息的线程
            new SendThread(socket).start();
            new ReceiveThread(socket).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

