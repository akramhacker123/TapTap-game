package wsdfhjxc.taponium;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import wsdfhjxc.taponium.engine.EngineRunner;

public class MainActivity extends Activity {
    private EngineRunner engineRunner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        engineRunner = new EngineRunner(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        engineRunner.start();
    }

    @Override
    protected void onStop() {
        engineRunner.pause();
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        engineRunner.stop();
        super.onDestroy();
    }

    @Override
    public void onBackPressed() {
        // override default back key press behavior
        engineRunner.backPressed();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.about, menu);

        return true;

    }
    public boolean onOptionsItemSelected(MenuItem item) {

//respond to menu item selection
        switch (item.getItemId()) {

            case R.id.about:
                Toast.makeText(getApplicationContext(),"KSRMCE MAD PROJECT",Toast.LENGTH_LONG).show();
                return true;

            case R.id.help:

                startActivity(new Intent(this, MainActivity.class));

                return true;
            default:

                return super.onOptionsItemSelected(item);

        }

    }
}