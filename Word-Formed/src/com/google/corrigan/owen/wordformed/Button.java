package com.google.corrigan.owen.wordformed;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.util.Log;
import android.view.MotionEvent;

public class Button
{
	private static boolean clickable = false;
	private Dropbox answer;
	RectF outer;
	RectF inner;
	int borderWidth = 5;
	
	static Paint borderColor = new Paint();
	static Paint bgColor = new Paint();
	static Paint textPaint = new Paint();
	
	public static void opaque()
	{
		bgColor.setAlpha(255);
		borderColor.setAlpha(255);
		textPaint.setAlpha(255);
		clickable = true;
	}
	
	public static void fade()
	{
		bgColor.setAlpha(50);
		borderColor.setAlpha(50);
		textPaint.setAlpha(50);
		clickable = false;
	}
	
	public Button(Dropbox answer, int x, int y, int width, int height)
	{
		this.answer = answer;
		outer = new RectF(x, y, x + width, y + height);
		inner = new RectF(x + borderWidth, y + borderWidth, x + width - borderWidth, y + height - borderWidth);
		
		borderColor.setColor(Color.BLACK);
		bgColor.setColor(Color.WHITE);
		textPaint.setColor(Color.BLACK);
		textPaint.setTextSize(30);
		textPaint.setTypeface(Typeface.MONOSPACE);
		fade();
	}
	
	public void draw(Canvas canvas)
	{
		canvas.drawRect(outer, borderColor);
		canvas.drawRect(inner, bgColor);
		
		canvas.drawText("Submit", inner.left + 35, inner.top + 60, textPaint);
	}
	
	public boolean contains(float x, float y)
	{
		return outer.contains(x, y);
	}
	
	public int onTouchEvent(MotionEvent event)
	{
		int score = 0;
	
		if(clickable)
		{
			switch(event.getAction())
			{
				case MotionEvent.ACTION_DOWN:
					if(outer.contains(event.getX(), event.getY()))
					{
						bgColor.setColor(Color.parseColor("#CCCCCC"));
						if(Dictionary.isWord(answer.tilesToString()))
						{
							score += answer.getScore();
							try
							{
								answer.removeAll();
							}
							catch(Exception e){
								Log.d("ExceptionS", e.getMessage()+"");
							}
						}
					}
					break;
				case MotionEvent.ACTION_UP:
					bgColor.setColor(Color.WHITE);
					break;
				default:
					break;
			}
		}
		
		return score;
	}
}
