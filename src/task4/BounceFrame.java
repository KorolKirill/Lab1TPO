package task4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class BounceFrame extends JFrame {
    private BallCanvas canvas;
    public static final int WIDTH = 450;
    public static final int HEIGHT = 350;
    public static ArrayList<BallThread> lasts = new ArrayList<>();

    public BounceFrame() {
        this.setSize(WIDTH, HEIGHT);
        this.setTitle("Bounce programm");
        this.canvas = new BallCanvas();
        System.out.println("In Frame Thread name = "
                + Thread.currentThread().getName());
        Container content = this.getContentPane();
        content.add(this.canvas, BorderLayout.CENTER);
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.lightGray);
        JButton buttonStart = new JButton("Red");
        JButton buttonStart1 = new JButton("Blue");
        JButton buttonStop = new JButton("Stop");


        lasts.add(null);
        buttonStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Ball b = new Ball(canvas,Color.RED);
                canvas.add(b);

                BallThread thread = new BallThread(b,lasts.get(lasts.size()-1));
                thread.start();
                BounceFrame.lasts.add(thread);
                System.out.println("Thread name = " +
                        thread.getName());
            }
        });
        buttonStart1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < 1; i++){
                    Ball b = new Ball(canvas,Color.BLUE);
                    canvas.add(b);

                    BallThread thread = new BallThread(b,lasts.get(lasts.size()-1));

                    thread.start();

                    System.out.println("Thread name = " +
                            thread.getName());
                   /* try {
                        thread.join();
                    } catch (InterruptedException interruptedException) {
                        interruptedException.printStackTrace();
                    }*/
                }
            }
        });

        buttonStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                System.exit(0);
            }
        });
        buttonPanel.add(buttonStart);
        buttonPanel.add(buttonStart1);
        buttonPanel.add(buttonStop);

        content.add(buttonPanel, BorderLayout.SOUTH);
    }
}