package com.google.corrigan.owen.wordformed;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.graphics.Typeface;
public class WordFormed extends Activity implements OnClickListener
{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) 
	{
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        Typeface tf = Typeface.createFromAsset(getAssets(), "fonts/Roboto-Thin.ttf");
        TextView tv = (TextView) findViewById(R.id.CustomFontText);
        
        tv.setTypeface(tf);
        
        //Set up click listeners for all the buttons
        View newGameButton = findViewById(R.id.new_game_button);
        newGameButton.setOnClickListener(this);
		View multiplayerButton = findViewById(R.id.multiplayer_button);
		multiplayerButton.setOnClickListener(this);
		View how_to_play_button = findViewById(R.id.how_to_play_button);
		how_to_play_button.setOnClickListener(this);
		View highScoresButton = findViewById(R.id.high_scores_button);
		highScoresButton.setOnClickListener(this);
    }

	public void onClick(View v)
	{
		switch(v.getId())
		{
			case R.id.new_game_button:
				startActivity(new Intent(this, SinglePlayerGame.class));
				break;
			case R.id.multiplayer_button:
				startActivity(new Intent(this, MultiplayerGame.class));
				break;
			case R.id.how_to_play_button:
				startActivity(new Intent(this, HowToPlay.class));
				break;
			case R.id.high_scores_button:
				startActivity(new Intent(this, HiScore.class));
				break;
		}
		
	}
}
