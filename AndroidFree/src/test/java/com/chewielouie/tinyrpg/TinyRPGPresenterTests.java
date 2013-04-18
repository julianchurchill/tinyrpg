package com.chewielouie.tinyrpg;

import static org.junit.Assert.*;

import com.chewielouie.tinyrpg.terrain.TerrainMap;
import org.jmock.*;
import org.jmock.integration.junit4.JMock;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JMock.class)
public class TinyRPGPresenterTests {

    private Mockery mockery = new Mockery();

    @Test
    public void render_tells_view_to_show_terrain() {
        final TinyRPGView view = mockery.mock( TinyRPGView.class );
        final TinyRPGModel model = mockery.mock( TinyRPGModel.class );
        final TerrainMap terrainMap = mockery.mock( TerrainMap.class );
        TinyRPGPresenter p = new TinyRPGPresenter( view, model );

        mockery.checking( new Expectations() {{
            allowing( model ).allTerrain();
            will( returnValue( terrainMap ) );
            ignoring( model );
            oneOf( view ).showTerrain( terrainMap );
            ignoring( view );
        }});

        p.render();
    }

    @Test
    public void render_tells_view_about_player_position() {
        final TinyRPGView view = mockery.mock( TinyRPGView.class );
        final TinyRPGModel model = mockery.mock( TinyRPGModel.class );
        TinyRPGPresenter p = new TinyRPGPresenter( view, model );
        final Coordinate playerCoord = mockery.mock( Coordinate.class );

        mockery.checking( new Expectations() {{
            allowing( model ).playerPosition();
            will( returnValue( playerCoord ) );
            ignoring( model );
            oneOf( view ).showPlayerAt( playerCoord );
            ignoring( view );
        }});

        p.render();
    }

    @Test
    public void on_player_movement_attempted_model_is_informed() {
        final TinyRPGModel model = mockery.mock( TinyRPGModel.class );
        TinyRPGPresenter p = new TinyRPGPresenter( null, model );

        mockery.checking( new Expectations() {{
            oneOf( model ).tryToMovePlayer( TinyRPGModel.Direction.North );
        }});

        p.playerMovementAttempted( TinyRPGModel.Direction.North );
    }
}

