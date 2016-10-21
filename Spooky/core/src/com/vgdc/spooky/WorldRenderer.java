package com.vgdc.spooky;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Disposable;
import com.vgdc.utils.Constants;

/**
 * Draws our world
 * @author Evan S.
 * also
 * @author Lis O.
 * to make box2d work
 */
public class WorldRenderer extends Box2DDebugRenderer implements Disposable {

	private OrthographicCamera camera;
	private SpriteBatch batch;
	private WorldController worldController;

	public WorldRenderer(WorldController worldController) {
		super();
		this.worldController = worldController;
		init();
	}

	/*
	 *  Sets up our camera and our SpriteBatch
	 */
	private void init() {
		batch = new SpriteBatch();
		camera = new OrthographicCamera (Gdx.graphics.getWidth() / Constants.PPM, Gdx.graphics.getHeight() / Constants.PPM);
		camera.position.set(0,0,0);
		camera.update();
	}

	public void render(World world) {

		super.render(world, camera.combined);
		renderWorld(batch);
	}



	private void renderWorld(SpriteBatch batch) {
		worldController.cameraHelper.applyTo(camera);
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		worldController.level.render(batch);
		batch.end();
	}

	public void resize(int width, int height) {
		camera.viewportWidth = (Gdx.graphics.getWidth()/ height) * width/ Constants.PPM;
		camera.update();
	}


	/**
	 * Frees resources used in this class.
	 */
	@Override
	public void dispose() {
		batch.dispose();
	}

}
