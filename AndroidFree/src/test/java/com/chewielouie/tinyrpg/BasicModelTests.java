package com.chewielouie.tinyrpg;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import com.chewielouie.tinyrpg.terrain.ArrayTerrainMap;
import com.chewielouie.tinyrpg.terrain.Grass;
import com.chewielouie.tinyrpg.terrain.LocatedTerrainPiece;
import com.chewielouie.tinyrpg.terrain.TerrainMap;
import org.jmock.*;
import org.jmock.integration.junit4.JMock;
import org.junit.Test;
import org.junit.runner.RunWith;

public class BasicModelTests {

    private Mockery mockery = new Mockery();

    @Test
    public void model_returns_some_default_terrain() {
        BasicModel model = new BasicModel();
        TerrainMap terrainMap = model.allTerrain();

        assertThat( terrainMap, is( notNullValue() ) );
    }

    @Test
    public void model_has_a_default_player_position() {
        BasicModel model = new BasicModel();
        assertThat( model.playerPosition().x(), is( 1 ) );
        assertThat( model.playerPosition().y(), is( 1 ) );
    }

    private TerrainMap create9x9TerrainGrassOnly() {
        TerrainMap terrainMap = new ArrayTerrainMap();
        terrainMap.add( new LocatedTerrainPiece( new Coordinate2D( -1, -1 ), new Grass() ) );
        terrainMap.add( new LocatedTerrainPiece( new Coordinate2D(  0, -1 ), new Grass() ) );
        terrainMap.add( new LocatedTerrainPiece( new Coordinate2D(  1, -1 ), new Grass() ) );
        terrainMap.add( new LocatedTerrainPiece( new Coordinate2D( -1,  0 ), new Grass() ) );
        terrainMap.add( new LocatedTerrainPiece( new Coordinate2D(  0,  0 ), new Grass() ) );
        terrainMap.add( new LocatedTerrainPiece( new Coordinate2D(  1,  0 ), new Grass() ) );
        terrainMap.add( new LocatedTerrainPiece( new Coordinate2D( -1,  1 ), new Grass() ) );
        terrainMap.add( new LocatedTerrainPiece( new Coordinate2D(  0,  1 ), new Grass() ) );
        terrainMap.add( new LocatedTerrainPiece( new Coordinate2D(  1,  1 ), new Grass() ) );
        return terrainMap;
    }

    @Test
    public void on_successful_user_movement_player_position_is_updated_north() {
        BasicModel model = new BasicModel();
        model.setTerrainMap( create9x9TerrainGrassOnly() );
        model.setPlayerPosition( new Coordinate2D( 0, 0 ) );

        int originalX = model.playerPosition().x();
        int originalY = model.playerPosition().y();
        model.tryToMovePlayer( TinyRPGModel.Direction.North );

        assertThat( model.playerPosition().x(), is( originalX ) );
        assertThat( model.playerPosition().y(), is( originalY-1 ) );
    }

    @Test
    public void on_successful_user_movement_player_position_is_updated_south() {
        BasicModel model = new BasicModel();
        model.setTerrainMap( create9x9TerrainGrassOnly() );
        model.setPlayerPosition( new Coordinate2D( 0, 0 ) );

        int originalX = model.playerPosition().x();
        int originalY = model.playerPosition().y();
        model.tryToMovePlayer( TinyRPGModel.Direction.South );

        assertThat( model.playerPosition().x(), is( originalX ) );
        assertThat( model.playerPosition().y(), is( originalY+1 ) );
    }

    @Test
    public void on_successful_user_movement_player_position_is_updated_east() {
        BasicModel model = new BasicModel();
        model.setTerrainMap( create9x9TerrainGrassOnly() );
        model.setPlayerPosition( new Coordinate2D( 0, 0 ) );

        int originalX = model.playerPosition().x();
        int originalY = model.playerPosition().y();
        model.tryToMovePlayer( TinyRPGModel.Direction.East );

        assertThat( model.playerPosition().x(), is( originalX+1 ) );
        assertThat( model.playerPosition().y(), is( originalY ) );
    }

    @Test
    public void on_successful_user_movement_player_position_is_updated_west() {
        BasicModel model = new BasicModel();
        model.setTerrainMap( create9x9TerrainGrassOnly() );
        model.setPlayerPosition( new Coordinate2D( 0, 0 ) );

        int originalX = model.playerPosition().x();
        int originalY = model.playerPosition().y();
        model.tryToMovePlayer( TinyRPGModel.Direction.West );

        assertThat( model.playerPosition().x(), is( originalX-1 ) );
        assertThat( model.playerPosition().y(), is( originalY ) );
    }

    @Test
    public void on_successful_user_movement_player_position_is_updated_north_east() {
        BasicModel model = new BasicModel();
        model.setTerrainMap( create9x9TerrainGrassOnly() );
        model.setPlayerPosition( new Coordinate2D( 0, 0 ) );

        int originalX = model.playerPosition().x();
        int originalY = model.playerPosition().y();
        model.tryToMovePlayer( TinyRPGModel.Direction.NorthEast );

        assertThat( model.playerPosition().x(), is( originalX+1 ) );
        assertThat( model.playerPosition().y(), is( originalY-1 ) );
    }

    @Test
    public void on_successful_user_movement_player_position_is_updated_north_west() {
        BasicModel model = new BasicModel();
        model.setTerrainMap( create9x9TerrainGrassOnly() );
        model.setPlayerPosition( new Coordinate2D( 0, 0 ) );

        int originalX = model.playerPosition().x();
        int originalY = model.playerPosition().y();
        model.tryToMovePlayer( TinyRPGModel.Direction.NorthWest );

        assertThat( model.playerPosition().x(), is( originalX-1 ) );
        assertThat( model.playerPosition().y(), is( originalY-1 ) );
    }

    @Test
    public void on_successful_user_movement_player_position_is_updated_south_east() {
        BasicModel model = new BasicModel();
        model.setTerrainMap( create9x9TerrainGrassOnly() );
        model.setPlayerPosition( new Coordinate2D( 0, 0 ) );

        int originalX = model.playerPosition().x();
        int originalY = model.playerPosition().y();
        model.tryToMovePlayer( TinyRPGModel.Direction.SouthEast );

        assertThat( model.playerPosition().x(), is( originalX+1 ) );
        assertThat( model.playerPosition().y(), is( originalY+1 ) );
    }

    @Test
    public void on_successful_user_movement_player_position_is_updated_south_west() {
        BasicModel model = new BasicModel();
        model.setTerrainMap( create9x9TerrainGrassOnly() );
        model.setPlayerPosition( new Coordinate2D( 0, 0 ) );

        int originalX = model.playerPosition().x();
        int originalY = model.playerPosition().y();
        model.tryToMovePlayer( TinyRPGModel.Direction.SouthWest );

        assertThat( model.playerPosition().x(), is( originalX-1 ) );
        assertThat( model.playerPosition().y(), is( originalY+1 ) );
    }

    @Test
    public void player_position_is_bounded_by_world_edge() {
        BasicModel model = new BasicModel();
        TerrainMap terrainMap = new ArrayTerrainMap();
        terrainMap.add( new LocatedTerrainPiece( new Coordinate2D( 0, 0 ),
                                                 new Grass() ) );
        model.setTerrainMap( terrainMap );
        model.setPlayerPosition( new Coordinate2D( 0, 0 ) );

        model.tryToMovePlayer( TinyRPGModel.Direction.North );
        assertThat( model.playerPosition().x(), is( 0 ) );
        assertThat( model.playerPosition().y(), is( 0 ) );

        model.tryToMovePlayer( TinyRPGModel.Direction.South );
        assertThat( model.playerPosition().x(), is( 0 ) );
        assertThat( model.playerPosition().y(), is( 0 ) );

        model.tryToMovePlayer( TinyRPGModel.Direction.West );
        assertThat( model.playerPosition().x(), is( 0 ) );
        assertThat( model.playerPosition().y(), is( 0 ) );

        model.tryToMovePlayer( TinyRPGModel.Direction.East );
        assertThat( model.playerPosition().x(), is( 0 ) );
        assertThat( model.playerPosition().y(), is( 0 ) );

        model.tryToMovePlayer( TinyRPGModel.Direction.NorthEast );
        assertThat( model.playerPosition().x(), is( 0 ) );
        assertThat( model.playerPosition().y(), is( 0 ) );

        model.tryToMovePlayer( TinyRPGModel.Direction.NorthWest );
        assertThat( model.playerPosition().x(), is( 0 ) );
        assertThat( model.playerPosition().y(), is( 0 ) );

        model.tryToMovePlayer( TinyRPGModel.Direction.SouthEast );
        assertThat( model.playerPosition().x(), is( 0 ) );
        assertThat( model.playerPosition().y(), is( 0 ) );

        model.tryToMovePlayer( TinyRPGModel.Direction.SouthWest );
        assertThat( model.playerPosition().x(), is( 0 ) );
        assertThat( model.playerPosition().y(), is( 0 ) );
    }

    @Test
    public void on_successful_user_movement_call_listeners() {
        final PlayerActivityListener l = mockery.mock( PlayerActivityListener.class );
        mockery.checking( new Expectations() {{
            oneOf( l ).playerPositionChanged();
        }});
        BasicModel model = new BasicModel();
        model.addPlayerActivityListener( l );
        model.setTerrainMap( create9x9TerrainGrassOnly() );

        model.tryToMovePlayer( TinyRPGModel.Direction.North );

        mockery.assertIsSatisfied();
    }

    @Test
    public void on_unsuccessful_user_movement_dont_call_listeners() {
        final PlayerActivityListener l = mockery.mock( PlayerActivityListener.class );
        mockery.checking( new Expectations() {{
            never( l ).playerPositionChanged();
        }});
        BasicModel model = new BasicModel();
        model.addPlayerActivityListener( l );
        TerrainMap terrainMap = new ArrayTerrainMap();
        terrainMap.add( new LocatedTerrainPiece( new Coordinate2D( 0, 0 ),
                                                 new Grass() ) );
        model.setTerrainMap( terrainMap );
        model.setPlayerPosition( new Coordinate2D( 0, 0 ) );

        model.tryToMovePlayer( TinyRPGModel.Direction.North );

        mockery.assertIsSatisfied();
    }
}

