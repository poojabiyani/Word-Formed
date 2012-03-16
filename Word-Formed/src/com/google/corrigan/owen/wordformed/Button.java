package com.google.corrigan.owen.wordformed;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.view.MotionEvent;

public class Button
{
	private RectF outer;
	private RectF inner;
	private boolean hilighted = false;
	int borderWidth = 5;

	Paint borderColor = new Paint();
	Paint bgColor = new Paint();
	Paint textPaint = new Paint();

	public Button(int x, int y, int width, int height)
	{
		outer = new RectF(x, y, x + width, y + height);
		inner = new RectF(x + borderWidth, y + borderWidth, x + width - borderWidth, y + height - borderWidth);

		borderColor.setColor(Color.BLACK);
		bgColor.setColor(Color.argb(192, 204, 204, 204));

		textPaint.setColor(Color.BLACK);
		textPaint.setTextSize(30);
		textPaint.setTypeface(Typeface.MONOSPACE);
	}
	
	public void hilight()
	{
		if(hilighted)
		{
			bgColor.setColor(Color.WHITE);
		}
		else
		{
			bgColor.setColor(Color.argb(192, 204, 204, 204));
		}

		hilighted = !hilighted;
			
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
		switch(event.getAction())
		{
			case MotionEvent.ACTION_DOWN:
				if(outer.contains(event.getX(), event.getY()))
				{
					bgColor.setColor(Color.parseColor("#CCCCCC"));
					score++;
				}
				break;
			case MotionEvent.ACTION_UP:
				bgColor.setColor(Color.WHITE);
				break;
			default:
				break;
		}
		return score;
	}
}