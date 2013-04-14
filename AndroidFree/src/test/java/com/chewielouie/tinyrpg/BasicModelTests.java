package com.chewielouie.tinyrpg;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import com.chewielouie.tinyrpg.terrain.TerrainMap;
import org.junit.Test;
import org.junit.runner.RunWith;

public class BasicModelTests {

    @Test
    public void model_returns_some_default_terrain() {
        BasicModel model = new BasicModel();
        TerrainMap terrainMap = model.allTerrain();

        assertThat( terrainMap, is( notNullValue() ) );
    }
}

