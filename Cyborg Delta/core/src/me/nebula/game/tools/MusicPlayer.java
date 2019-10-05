package me.nebula.game.tools;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;

import me.nebula.game.screens.Menu;


public class MusicPlayer extends Thread {
	Music music;
	boolean music_state;

	public MusicPlayer() {
		//music_state = music_conf;

	}
	
	public void run () {
		music = Gdx.audio.newMusic(Gdx.files.internal("./msc/menu.ogg"));
		if (Menu.music_conf == true) {
			music.setLooping(true);
			music.setVolume(0.9f);
			music.play();
		}
		while (true) {
			if (Menu.music_conf == false) {
				music.pause();
			}else {
				music.play();
			}
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
				
		//sound.dispose();
	}
	public void play() {
		music.play();
	}
	public void pause() {
		music.pause();
		//if (Menu.music_conf == false | Menu.start == 1) {
		//	music.setLooping(false);
		//	music.pause();
		}

	
	public void dispose () {
		music.dispose();
	}
	
}