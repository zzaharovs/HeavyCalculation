package ru.netology;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {

        int port = 8081;

        try (ServerSocket serverSocket = new ServerSocket(port);
             Socket clientSocket = serverSocket.accept();
             PrintWriter out = new
                     PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new
                     BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {

            System.out.println("Соединение установлено");

            //Отправляем запрос числа
            out.println("Введите целое число, для которого нужно получить n-ный член ряда Фибоначчи");

            //Принимаем число
            String input = in.readLine();

            try {
                int arg = Integer.parseInt(input);
                out.println("N-ый член ряда Фибоначчи для числа" + input + " равен " + fibNumber(arg));
            } catch (NumberFormatException ex) {
                out.println("Введен текст вместо числа. Работа программы завершена");
            }

            /*
            Blocking IO выбран, т.к. для получения корректного результата данные нельзя считывать по кускам,
            вычисление надо завершить полностью
             */

        } catch (IOException ex) {
            ex.printStackTrace();
        }


    }

    public static int fibNumber (int arg)
    {

        //F(n)
        int x = 1;
        //F(n-1)
        int y = 0;
        for (int i = 0; i < arg; i++)
        {
            x += y;
            y = x - y;
        }
        return y;
    }

}
