package com.chewielouie.tinyrpg;

import com.chewielouie.tinyrpg.terrain.TerrainMap;

public interface TinyRPGView {
    public void showTerrain( TerrainMap map );
    public void showPlayerAt( Coordinate pos );
}

