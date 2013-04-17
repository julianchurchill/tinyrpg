package com.chewielouie.tinyrpg;

import android.app.Activity;
import android.os.Bundle;
import com.chewielouie.tinyrpg.terrain.TerrainMap;

public class TinyRPGActivity extends Activity implements TinyRPGView {
    private RendersView rendersView;

    public TinyRPGActivity() {
        TinyRPGPresenter presenter = new TinyRPGPresenter( this, new BasicModel() );
        this.rendersView = presenter;
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
    }

    @Override
    public void onResume() {
        super.onResume();

        rendersView.render();
    }

    @Override
    public void showTerrain( TerrainMap map ) {
        WorldView worldView = (WorldView)findViewById( R.id.world_view );
        worldView.setTerrain( map );
    }
}

