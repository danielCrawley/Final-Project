package me.dancrawley.project.Game;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

/**
 * @author Drew Hoener
 *         A sound player that will keep the file stream open until the proper time (i.e. the file is finished)
 *         Based off of help from stackoverflow and java documentation.
 */
public class SoundUtil {


    public void playSound(File soundFile) throws IOException, UnsupportedAudioFileException, LineUnavailableException, InterruptedException {

        class AudioListener implements LineListener {

            private boolean soundFinished = false;

            @Override
            public synchronized void update(LineEvent event) {
                LineEvent.Type eventType = event.getType();
                if (eventType == LineEvent.Type.STOP || eventType == LineEvent.Type.CLOSE) {
                    soundFinished = true;
                    notifyAll();
                }

            }

            public synchronized void waitUntilDone() throws InterruptedException {
                while (!soundFinished)
                    wait();
            }

        }

        AudioListener listener = new AudioListener();
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFile);
        try {

            Clip clip = AudioSystem.getClip();
            clip.addLineListener(listener);
            clip.open(audioInputStream);
            try {

                clip.start();
                listener.waitUntilDone();
            } finally {

                clip.close();
            }
        } finally {
            audioInputStream.close();
        }

    }


}
