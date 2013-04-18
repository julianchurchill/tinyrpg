package com.chewielouie.tinyrpg;

import com.chewielouie.tinyrpg.terrain.ArrayTerrainMap;
import com.chewielouie.tinyrpg.terrain.Grass;
import com.chewielouie.tinyrpg.terrain.LocatedTerrainPiece;
import com.chewielouie.tinyrpg.terrain.TerrainMap;

public class BasicModel implements TinyRPGModel {
    private Coordinate playerPosition;
    private TerrainMap terrainMap;
    private PlayerActivityListener playerActivityListener = null;

    public BasicModel() {
        this.playerPosition = new Coordinate2D( 1, 1 );
        populateTerrain();
    }

    private void populateTerrain() {
        terrainMap = new ArrayTerrainMap();
        terrainMap.add( new LocatedTerrainPiece( new Coordinate2D( -1, -1 ), new Grass() ) );
        terrainMap.add( new LocatedTerrainPiece( new Coordinate2D(  0, -1 ), new Grass() ) );
        terrainMap.add( new LocatedTerrainPiece( new Coordinate2D(  1, -1 ), new Grass() ) );
        terrainMap.add( new LocatedTerrainPiece( new Coordinate2D( -1,  0 ), new Grass() ) );
        terrainMap.add( new LocatedTerrainPiece( new Coordinate2D(  0,  0 ), new Grass() ) );
        terrainMap.add( new LocatedTerrainPiece( new Coordinate2D(  1,  0 ), new Grass() ) );
        terrainMap.add( new LocatedTerrainPiece( new Coordinate2D( -1,  1 ), new Grass() ) );
        terrainMap.add( new LocatedTerrainPiece( new Coordinate2D(  0,  1 ), new Grass() ) );
        terrainMap.add( new LocatedTerrainPiece( new Coordinate2D(  1,  1 ), new Grass() ) );
    }

    public TerrainMap allTerrain() {
        return terrainMap;
    }

    public Coordinate playerPosition() {
        return playerPosition;
    }

    public void setTerrainMap( TerrainMap map ) {
        terrainMap = map;
    }

    public void addPlayerActivityListener( PlayerActivityListener l ) {
        playerActivityListener = l;
    }

    public void tryToMovePlayer( Direction d ) {
        if( d == Direction.North )
            playerPosition.translate( new Coordinate2D(  0, -1 ) );
        else if( d == Direction.South )
            playerPosition.translate( new Coordinate2D(  0,  1 ) );
        else if( d == Direction.East )
            playerPosition.translate( new Coordinate2D(  1,  0 ) );
        else if( d == Direction.West )
            playerPosition.translate( new Coordinate2D( -1,  0 ) );
        else if( d == Direction.NorthEast )
            playerPosition.translate( new Coordinate2D(  1, -1 ) );
        else if( d == Direction.NorthWest )
            playerPosition.translate( new Coordinate2D( -1, -1 ) );
        else if( d == Direction.SouthEast )
            playerPosition.translate( new Coordinate2D(  1,  1 ) );
        else if( d == Direction.SouthWest )
            playerPosition.translate( new Coordinate2D( -1,  1 ) );

        if( playerActivityListener != null )
            playerActivityListener.playerPositionChanged();
    }
}

