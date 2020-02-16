import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BounceFrame extends JFrame {

    private BallCanvas canvas;
    public static final int WIDTH = 900;
    public static final int HEIGHT = 500;

    public BounceFrame() {
        this.setSize(WIDTH, HEIGHT);
        this.setTitle("Bounce program");

        this.canvas = new BallCanvas();
        System.out.println("In Frame Thread name = "
                + Thread.currentThread().getName());
        Container content = this.getContentPane();
        content.add(this.canvas, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.lightGray);

        JButton buttonStart = new JButton("Start");
        JButton buttonStop = new JButton("Stop");

        buttonStart.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                for (int i = 0; i < 1000; i++) {
                    Ball b = new Ball(canvas, Color.blue);
                    canvas.add(b);

                    BallThread thread = new BallThread(b);
                    thread.start();
                    thread.setPriority(Thread.MIN_PRIORITY);
                    System.out.println("Thread name = " + thread.getName());
                }
                Ball ball = new Ball(canvas, Color.yellow);
                canvas.add(ball);
                BallThread thread = new BallThread(ball);
                thread.start();
                thread.setPriority(Thread.MAX_PRIORITY);
                System.out.println("Thread name = " + thread.getName());
            }
        });

        buttonStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                System.exit(0);
            }

        });


        buttonPanel.add(buttonStart);
        buttonPanel.add(buttonStop);

        content.add(buttonPanel, BorderLayout.SOUTH);
    }
}
