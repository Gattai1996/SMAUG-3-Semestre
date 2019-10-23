package me.nebula.game.tools;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.utils.Timer;

import me.nebula.game.helpers.GameInfo;
//import me.nebula.game.screens.MainMenu;


public class MusicPlayer extends Thread implements Runnable {
	private Music music;
	private boolean music_mode;
	private boolean delay;


	public MusicPlayer() {


		music_mode = GameInfo.music_conf;

	}
	
	public void run () {
	    //carrega musica conforme a fase

       boolean music_state = true;



		while (true) {
			if (Gdx.input.isKeyPressed(Input.Keys.P) && !delay) {
				if (music_state) {
					music.pause();
					music_state = false;
				} else {
					music.play();
					music_state = true;
				}
			}


		}

		//sound.dispose();
	}

	public void playMusic() {

		if (music_mode) {
			music = Gdx.audio.newMusic(Gdx.files.internal(GameInfo.musicPlay));
			music.setLooping(true);
			music.setVolume(0.7f);
			music.play();
			System.out.println("Tocando musica "+GameInfo.musicPlay);
		}
	}
	public void pauseMusic() {
		music.pause();
//		if (GameInfo.music_conf == false | Menu.start == 1) {
//			music.setLooping(false);
//			music.pause();
		}

	
	public void dispose () {

		music.dispose();
	}
	public void stopThread(){
		this.music_mode = false;
	}
	
}