package me.nebula.game.tools;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Music;

import me.nebula.game.helpers.GameInfo;
//import me.nebula.game.screens.MainMenu;


public class MusicPlayer extends Thread {
	private Music music;
	private boolean music_mode;
	private String musicFile;


	public MusicPlayer(String s) {
		musicFile = s;

		music_mode = GameInfo.music_conf;

	}
	
	public void run () {
	    //carrega musica conforme a fase

        boolean music_state = true;
    if (music_mode) {
        music = Gdx.audio.newMusic(Gdx.files.internal(musicFile));
        music.setLooping(true);
        music.setVolume(0.9f);
        music.play();
        System.out.println("Tocando musica "+musicFile);
    }


		while (true) {
			if (Gdx.input.isKeyPressed(Input.Keys.P) && music_state) {
				music.pause();
				music_state = false;
				System.out.println("Tocando musica "+music_state);
			}
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (Gdx.input.isKeyPressed(Input.Keys.P) && music_state == false){
				music.play();
				music_state = true;
			}


		}

		//sound.dispose();
	}
	public void play() {
		music.play();
	}
	public void pause() {
		music.pause();
//		if (GameInfo.music_conf == false | Menu.start == 1) {
//			music.setLooping(false);
//			music.pause();
		}

	
	public void dispose () {
		music.dispose();
	}
	
}