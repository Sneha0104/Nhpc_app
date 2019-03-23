package com.example.snehasaj.nhpcapp;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;


    public class APPServer implements Runnable {



        public static void main(String[] args) {

            try {
                Thread t = new Thread(new APPServer());
                t.start();
            } catch (Exception e) {
                System.out.println("noooooooo output");
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            try {
                ServerSocket serverSocket = new ServerSocket(1521);
                while (true) {
                    try {
                        String i;
                        System.out.println("Waiting for client on port " + serverSocket.getLocalPort() + "...");
                        Socket server = serverSocket.accept();
                        System.out.println("Just connected to " + server.getRemoteSocketAddress());
                        DataInputStream in = new DataInputStream(server.getInputStream());
                        System.out.println("ok");
                        String s = in.readUTF();
                        System.out.println(s);
                        String[] buffer = null;
                        buffer = s.split("\\n");
                        System.out.println(buffer[0]);
                        DataOutputStream out = new DataOutputStream(server.getOutputStream());
                        DataQ d = new DataQ();
                        if (buffer[0].equals("*****")) {
                            //System.out.println(buffer[1]);
                            System.out.println(buffer[2]);
                            System.out.println(buffer[3]);
                            System.out.println(buffer[4]);
                            i = d.Get_Authentication_for_NHPC_APPS(buffer[2], buffer[1]);
                            System.out.println("Details Called noooooooooooot");
                        } else {
                            i = d.Get_Authentication_for_NHPC_APPS(buffer[1], buffer[0]);
                            System.out.println("hellooooooooooo");
                        }
                        System.out.println(i);
                        DataOutputStream outToClient = new DataOutputStream(server.getOutputStream());
                        outToClient.writeUTF(i);

                    }


                    catch (Exception e) {
                        System.out.println("\n Error in servlet");
                    }
                }
            } catch (Exception e) {
            }
        }

    }






