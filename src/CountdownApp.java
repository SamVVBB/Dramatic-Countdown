import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.DecimalFormat;

public class CountdownApp {

    public static void main(String[] args) throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        new CountdownApp();
    }

    // GUI
    JFrame frame;
    JLabel label;
    Font font = new Font("Courier", Font.BOLD, 80);
    // Countdown
    Timer timer;
    int minute, second;
    String formattedMinute, formattedSecond;
    DecimalFormat decimalFormat = new DecimalFormat("00");
    // Audio
    Beep beep;

    public CountdownApp() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        frame = new JFrame();
        frame.setSize(800,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.BLACK);
        frame.setLayout(null);

        label = new JLabel("");
        label.setBounds(210, 160, 400, 200);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setFont(font);
        label.setForeground(new Color(255, 200, 0));

        frame.add(label);
        frame.setVisible(true);

        beep = new Beep();

        // Set time
        label.setText("03:00");
        minute = 3;
        second = 0;
        countdownTimer();
        timer.start();

    }

    public void countdownTimer() {

        timer = new Timer(1000, e -> {

            second--;

            try {
                beep.play();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }

            formattedMinute = decimalFormat.format(minute);
            formattedSecond = decimalFormat.format(second);
            label.setText(formattedMinute + ":" + formattedSecond);

            if(second == -1) {
                second = 59;
                minute--;
                formattedMinute = decimalFormat.format(minute);
                formattedSecond = decimalFormat.format(second);
                label.setText(formattedMinute + ":" + formattedSecond);
            }

            if(minute == 0 && second == 0) {
                timer.stop();
            }
        });

    }

}
