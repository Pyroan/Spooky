package com.vgdc.spooky;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.GL20;

public class PlayerControls extends InputAdapter
{
	float imgX;
	float imgY;
	float imgSpeed = 10.0f;

	public PlayerControls()
	{
		Gdx.input.setInputProcessor(this);
	}

	/**
	 * @return true if the correct movement keys are pressed
	 * @return false if the incorrect movement keys are pressed
	 *
	 **/
	@Override
	public boolean keyDown(int keycode)
	{
		if(keycode == Keys.W || keycode == Keys.UP)
		{
			Gdx.app.log(" ", " " + "W or UP was pressed");
			return true;
		}
		if(keycode == Keys.A || keycode == Keys.LEFT)
		{
			Gdx.app.log(" ", " " + "A or LEFT was pressed");
			return true;
		}
		if(keycode == Keys.S || keycode == Keys.DOWN)
		{
			Gdx.app.log(" ", " " + "S or DOWN was pressed");
			return true;
		}
		if(keycode == Keys.D || keycode == Keys.RIGHT)
		{
			Gdx.app.log(" ", " " + "D or RIGHT was pressed");
			return true;
		}
		else
		{
			Gdx.app.log(" ", " " + "That's the wrong key silly! :P");
			return false;
		}
	}


	public void movementStuff()
	{
		if(keyDown(Keys.W) || keyDown(Keys.UP))
		{
			Spooky.img.velocity.y = Spooky.img.terminalVelocity.y;
		}
		if(keyDown(Keys.S) || keyDown(Keys.DOWN))
		{
			Spooky.img.velocity.y = -Spooky.img.terminalVelocity.y;
		}
		if(keyDown(Keys.A) || keyDown(Keys.LEFT))
		{
			Spooky.img.velocity.x = -Spooky.img.terminalVelocity.x;
		}
		if(keyDown(Keys.D) || keyDown(Keys.RIGHT))
		{
			Spooky.img.velocity.x = Spooky.img.terminalVelocity.x;
		}
	}


}
