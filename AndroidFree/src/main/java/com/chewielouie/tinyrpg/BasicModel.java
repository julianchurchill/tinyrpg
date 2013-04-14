package com.chewielouie.tinyrpg;

import com.chewielouie.tinyrpg.terrain.ArrayTerrainMap;
import com.chewielouie.tinyrpg.terrain.TerrainMap;

public class BasicModel implements TinyRPGModel {
    public TerrainMap allTerrain() {
        return new ArrayTerrainMap();
    }
}

