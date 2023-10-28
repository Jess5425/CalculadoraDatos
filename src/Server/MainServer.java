package src.Server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.EmptyStackException;
import java.util.Stack;
//Hasta aquí esta bien
public class MainServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        FileWriter fileWriter = new FileWriter("operations.csv", true);
        PrintWriter printWriter = new PrintWriter(fileWriter);

        int operationCounter = 0;
        while (operationCounter < 5) {
            Socket socket = serverSocket.accept();
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            String expression = in.readLine();
            System.out.println("Expresión recibida: " + expression);

            int result = evaluateExpression(expression);
            out.println(result);

            Date currentDate = new Date();
            String record = currentDate + "," + expression + "," + result + "\n";
            printWriter.write(record);
            printWriter.flush();

            socket.close();
            operationCounter++;

        }
    }

    private static int evaluateExpression(String expression) {
        // Implementar la lógica de evaluación de la expresión matemática aquí
        int result = 0;
        Stack<Integer> operandStack = new Stack<>();
        Stack<Character> operatorStack = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            if (c == ' ') {
                continue;
            }

            if (Character.isDigit(c)) {
                operandStack.push(c - '0');
            } else if (c == '(') {
                operatorStack.push(c);
            } else if (c == ')') {
                while (!operatorStack.isEmpty() && operatorStack.peek() != '(') {
                    performOperation(operandStack, operatorStack.pop());
                }
                operatorStack.pop(); // pop '('
            } else {
                while (!operatorStack.isEmpty() && precedence(c) <= precedence(operatorStack.peek())) {
                    performOperation(operandStack, operatorStack.pop());
                }
                operatorStack.push(c);
            }
        }

        while (!operatorStack.isEmpty()) {
            performOperation(operandStack, operatorStack.pop());
        }

        return operandStack.pop();
    }

    private static void performOperation(Stack<Integer> operandStack, char operator) {
        try {
            int rightOperand = operandStack.pop();
            int leftOperand = operandStack.pop();

            switch (operator) {
                case '+':
                    operandStack.push(leftOperand + rightOperand);
                    break;
                case '-':
                    operandStack.push(leftOperand - rightOperand);
                    break;
                case '*':
                    operandStack.push(leftOperand * rightOperand);
                    break;
                case '/':
                    operandStack.push(leftOperand / rightOperand);
                    break;
                case '%':
                    operandStack.push(leftOperand % rightOperand);
                    break;
                case '&':
                    operandStack.push(leftOperand & rightOperand);
                    break;
                case '|':
                    operandStack.push(leftOperand | rightOperand);
                    break;
                case '^':
                    operandStack.push(leftOperand ^ rightOperand);
                    break;
                case '~':
                    operandStack.push(~rightOperand);
                    break;
                case '#':
                    operandStack.push((int) Math.pow(leftOperand, rightOperand));
                    break;
            }
        } catch (EmptyStackException e) {
            System.out.println("Error: Stack is empty. Cannot perform operation.");
            // Manejar el error de pila vacía adecuadamente (por ejemplo, registrar un mensaje de error y cerrar la conexión)
        }
    }

    private static int precedence(char operator) {
        switch (operator) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
            case '%':
                return 2;
            case '(':
            case ')':
                return 0;
            case '&':
            case '|':
            case '^':
            case '~':
                return 3;
            default:
                return -1;
        }
    }
}

