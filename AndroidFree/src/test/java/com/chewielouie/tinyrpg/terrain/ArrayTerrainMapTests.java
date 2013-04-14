package com.chewielouie.tinyrpg.terrain;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import org.jmock.*;
import org.jmock.integration.junit4.JMock;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JMock.class)
public class ArrayTerrainMapTests {

    private Mockery mockery = new Mockery();

    @Test
    public void terrain_map_can_be_added_to() {
        TerrainMap terrainMap = new ArrayTerrainMap();
        TerrainPiece t1 = mockery.mock( TerrainPiece.class, "piece1" );
        TerrainPiece t2 = mockery.mock( TerrainPiece.class, "piece2" );

        terrainMap.add( t1 );
        terrainMap.add( t2 );

        assertThat( terrainMap.size(), is( 2 ) );
    }

    //@Test
    //public void terrain_map_can_be_enumerated() {
        //TerrainMap terrainMap = new ArrayTerrainMap();

        //for( TerrainPiece t : terrainMap )
            //assertThat( t, instanceof( TerrainPiece ) );
    //}
}

