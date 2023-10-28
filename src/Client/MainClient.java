package src.Client;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


public class MainClient {
    public static void main(String[] args) throws IOException {
        SwingUtilities.invokeLater(() -> {
            Pantalla frame = new Pantalla();
            frame.setVisible(true);
        });
        Socket socket = new Socket("localhost", 8080);
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        // Leer la expresión matemática desde la línea de comandos
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Ingrese una expresión matemática: ");
        String expression = reader.readLine();

        out.println(expression);

        String result = in.readLine();
        System.out.println("Resultado: " + result);

        socket.close();
    }

}