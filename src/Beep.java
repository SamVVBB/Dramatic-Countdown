import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class Beep {

    private String path;
    private File file;
    private AudioInputStream audioStream;
    private Clip clip;

    public Beep() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        path = "src\\resources\\dinosteps1-94200.wav";
        file = new File(path);
        audioStream = AudioSystem.getAudioInputStream(file);
        clip = AudioSystem.getClip();
        clip.open(audioStream);
    }

    public void play() throws InterruptedException {
        clip.setMicrosecondPosition(0);
        clip.start();
    }

}
