package com.chewielouie.tinyrpg;

import android.app.Activity;
import android.os.Bundle;
import com.chewielouie.tinyrpg.terrain.Grass;
import com.chewielouie.tinyrpg.terrain.TerrainMap;
import com.chewielouie.tinyrpg.terrain.TerrainPiece;

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
        new WorldView().drawTerrain( map );
    }

    class WorldView {
        public void drawTerrain( TerrainMap map ) {
            for( TerrainPiece p : map )
                if( p.terrain() instanceof Grass )
                    drawGrass( p.coordinate() );
        }

        private void drawGrass( Coordinate coord ) {
            //int tileWidth = 20;
            //int tileHeight = 20;
            //CoordinateConverter c = new CoordinateConverter();
            //c.setViewSize( mapViewWidth(), mapViewHeight() );
            //c.setViewUnitSize( tileWidth, tileHeight );
            //Coordinate viewCoord = c.convertWorldToView( coord );
            //fillRect( viewCoord.x(), viewCoord.y(), 20, 20, GREEN );
            //drawRect( viewCoord.x(), viewCoord.y(), 20, 20, RED );
        }
    }
}

