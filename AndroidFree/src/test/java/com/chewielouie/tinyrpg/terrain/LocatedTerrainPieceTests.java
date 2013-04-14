package com.chewielouie.tinyrpg.terrain;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import org.jmock.*;
import org.jmock.integration.junit4.JMock;
import org.junit.Test;
import org.junit.runner.RunWith;
import com.chewielouie.tinyrpg.Coordinate;

@RunWith(JMock.class)
public class LocatedTerrainPieceTests {

    private Mockery mockery = new Mockery();

    @Test
    public void has_retrievable_coordinate() {
        Coordinate c = mockery.mock( Coordinate.class );
        TerrainPiece piece = new LocatedTerrainPiece( c, null );

        assertThat( piece.coordinate(), is( c ) );
    }

    @Test
    public void has_retrievable_terrain_object() {
        Terrain terrain = mockery.mock( Terrain.class );
        TerrainPiece piece = new LocatedTerrainPiece( null, terrain );

        assertThat( piece.terrain(), is( terrain ) );
    }
}

