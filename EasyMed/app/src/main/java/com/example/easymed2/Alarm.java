package com.example.easymed2;

import android.media.MediaPlayer;

import java.io.IOException;

public class Alarm {
    /*
    Alarm class for EasyMed

   TODO:
        - Scheduler or integration with one
        - default music path
    */

    String DEFAULT_MUSIC_PATH="Alarm.mp3";

    public void audioPlayer(String path, String fileName){
        //set up MediaPlayer
        MediaPlayer mp = new MediaPlayer();

        try {
            mp.setDataSource(path + "/" + fileName);
        } catch (IllegalArgumentException | IllegalStateException | IOException e) {
            e.printStackTrace();
        }
        try {
            mp.prepare();
        } catch (IllegalStateException | IOException e) {
            e.printStackTrace();
        }
        mp.start();
    }

}
