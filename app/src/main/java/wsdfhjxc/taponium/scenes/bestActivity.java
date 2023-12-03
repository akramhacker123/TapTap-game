package wsdfhjxc.taponium.scenes;

import android.content.Context;

class PreferenceExample extends Game {

    @Override
    public void create() {
        // Initialize the preferences
        Preferences preferences = (Preferences) Gdx.app.getPreferences(Context.MODE_PRIVATE);
        // Go to your game screen sending this LibGDX Game and the LibGDX Preferences
        setScreen(new GameScreen(this, preferences));
    }

    private void setScreen(GameScreen gameScreen) {
    }
}