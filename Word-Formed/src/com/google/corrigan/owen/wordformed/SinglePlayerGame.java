package com.google.corrigan.owen.wordformed;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class SinglePlayerGame extends Activity
{
	private SinglePlayerGameView game;
	
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);		
		game = new SinglePlayerGameView(this);
		setContentView(game);
		game.requestFocus();
	}
}