package me.nebula.game.tools;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.utils.Timer;

import me.nebula.game.helpers.GameInfo;
//import me.nebula.game.screens.MainMenu;


public class MusicPlayer extends Thread {
	private Music music;
	private boolean delay;
	private boolean musicState = false;
	public boolean thisDead = false;


	public MusicPlayer() {


	}
	
	public void run () {
	    //carrega musica conforme a fase


		while (GameInfo.music_conf) {
			if(!GameInfo.isRunning && GameInfo.musicSelect == "Menu"){

				music = Gdx.audio.newMusic(Gdx.files.internal(GameInfo.musicMenu));
				music.setLooping(true);
				music.setVolume(0.7f);
				music.play();
				GameInfo.isRunning = true;
				System.out.println("Tocando musica do Menu");
			}
			if(!GameInfo.isRunning && GameInfo.musicSelect == "Stage"){

				music = Gdx.audio.newMusic(Gdx.files.internal(GameInfo.musicStage));
				music.setLooping(true);
				music.setVolume(0.7f);
				music.play();
				GameInfo.isRunning = true;
				System.out.println("Tocando musica da Fase");
			}
			if(!GameInfo.isRunning && GameInfo.musicSelect == "Boss"){

				music = Gdx.audio.newMusic(Gdx.files.internal(GameInfo.musicBoss));
				music.setLooping(true);
				music.setVolume(0.7f);
				music.play();
				GameInfo.isRunning = true;
				System.out.println("Tocando musica da Fase");
			}

			if (!GameInfo.pauseMusic) {
				System.out.println("Pause");
				music.pause();
				musicState = false;
			} else {
				music.play();
				musicState = true;
			}

			if (thisDead){
				music.dispose();
				thisDead = false;
			}


		}

		//sound.dispose();
	}
	public void playMusic() {
		music.play();
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
	
}