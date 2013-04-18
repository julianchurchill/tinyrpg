package com.chewielouie.tinyrpg;

import android.app.Activity;
import android.os.Bundle;
import com.chewielouie.tinyrpg.terrain.TerrainMap;

public class TinyRPGActivity extends Activity {
    private RendersView rendersView = null;

    public TinyRPGActivity() {
    }

    public TinyRPGActivity( RendersView v ) {
        this.rendersView = v;
    }

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        createPresenter();
    }

    private void createPresenter() {
        if( rendersView == null ) {
            TinyRPGPresenter presenter = new TinyRPGPresenter( worldView(), new BasicModel() );
            rendersView = presenter;
        }
    }

    private WorldView worldView() {
       return (WorldView)findViewById( R.id.world_view );
    }

    @Override
    public void onResume() {
        super.onResume();

        rendersView.render();
    }
}

