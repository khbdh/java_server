import java.io.*;
import java.net.*;

public class FileServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(12345);
        System.out.println("서버 시작됨. 클라이언트 연결 대기 중...");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("클라이언트 연결됨.");

            DataInputStream dis = new DataInputStream(socket.getInputStream());
            String fileName = dis.readUTF();
            FileOutputStream fos = new FileOutputStream(fileName);

            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = dis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }

            fos.close();
            dis.close();
            socket.close();

            System.out.println("파일 수신 완료: " + fileName);
        }
    }
}