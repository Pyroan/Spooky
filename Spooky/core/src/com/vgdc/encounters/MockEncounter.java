package com.vgdc.encounters;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.vgdc.utils.Constants;

/**
 * A test encounter to make sure this isn't entirely stupid.
 * @author Evan S.
 *
 */
public class MockEncounter extends AbstractEncounter {
	private static final String TAG = AbstractEncounter.class.getName();

	/**
	 * Pretty sure my implementation is hot garbage.
	 */
	public MockEncounter() {
		super("Test Encounter");
	}

	@Override
	public void trigger() {
		isTriggered = true;
		Gdx.app.log(TAG, "Was triggered.");
		currentText = "This is a test.";
	}

	/**
	 * Spoilers: Actual encounters probably shouldn't do their own rendering,
	 * have encounterHandler do that.
	 */

	@Override
	public void render(SpriteBatch batch) {
//		FileHandle fh = new FileHandle("arial-15.fnt");
//		BitmapFont font = new BitmapFont(fh, false);
		BitmapFont font = new BitmapFont();
		font.setColor(Color.BLACK);
		font.draw(batch, title + ": " + currentText, Constants.VIEWPORT_GUI_WIDTH/2, Constants.VIEWPORT_GUI_HEIGHT/2);
		font.dispose();
	}

}