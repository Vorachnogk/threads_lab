import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BounceFrame extends JFrame {

    public static final int WIDTH = 450;
    public static final int HEIGHT = 300;
    private BallCanvas canvas;

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
                Ball b = new Ball(canvas, Color.blue);
                canvas.add(b);
                Ball ball = new Ball(canvas, Color.yellow);
                canvas.add(ball);

                BallThread thread1 = new BallThread(b);
                thread1.start();
                System.out.println("Thread name = " + thread1.getName());

                BallThread thread2 = new BallThread(ball, thread1);

                thread2.start();
                System.out.println("Thread name = " + thread2.getName());
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
