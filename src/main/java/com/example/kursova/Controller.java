package com.example.kursova;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;


import java.io.OutputStream;
import java.io.PrintStream;



public class Controller extends Thread {
    @FXML
    private TextField mass1in;

    @FXML
    private TextField mass2in;

    @FXML
    private TextArea Output;
    private PrintStream ps;

    public void initialize() {
        ps = new PrintStream(new Console(Output));
    }

    @FXML
    private void startAction() throws InterruptedException {

        System.setOut(ps);
        System.setErr(ps);


        Runnable task = () -> {
            synchronized (this) {
                String t;
                t = mass1in.getText();
                int R = Integer.parseInt(t);
                long[] MArray = new long[R];
                for (int i = 0; i < MArray.length; i++) {
                    MArray[i] = i + 1;
                }

                ArraySum Array = new ArraySum();

                Array.ArrayS(MArray);
                for (int i = 0; i < MArray.length; i++) {
                    System.out.println("Array 1: " + MArray[i] + " " + Thread.currentThread().getName());

                    // Output.setText(String.valueOf("Масив 1:" + MArray[i] + "\n"));

                }
            }
            ;
        };

            Runnable task1 = () -> {
                synchronized (this) {
                    String y;
                    y = mass2in.getText();
                    int B = Integer.parseInt(y);

                    long[] MArray1 = new long[B];

                    for (int i = 0; i < MArray1.length; i++) {
                        MArray1[i] = i + 1;
                    }

                    ArraySum Array1 = new ArraySum();

                    Array1.ArrayS(MArray1);
                    for (int i = 0; i < MArray1.length; i++) {
                        System.out.println("Array 2: " + MArray1[i] + " " + Thread.currentThread().getName());
                        //Output.setText(String.valueOf("Масив 2:" + MArray1[i] + "\n"));
                    }
                }
                ;
            };

        Thread thread = new Thread(task);
        thread.start();


        Thread thread1 = new Thread(task1);
        thread1.start();



        Output.setEditable(false);
    }
    }


    class Console extends OutputStream {
        private final TextArea console;

        public Console(TextArea console) {
            this.console = console;
        }

        public void appendText(String valueOf) {
            Platform.runLater(() -> console.appendText(valueOf));
        }

        public void write(int b) {
            appendText(String.valueOf((char) b));
        }






    }










