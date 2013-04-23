package com.chewielouie.tinyrpg;

import com.chewielouie.tinyrpg.terrain.ArrayTerrainMap;
import com.chewielouie.tinyrpg.terrain.Grass;
import com.chewielouie.tinyrpg.terrain.LocatedTerrainPiece;
import com.chewielouie.tinyrpg.terrain.TerrainMap;
import com.chewielouie.tinyrpg.terrain.TerrainPiece;

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

    public void setPlayerPosition( Coordinate coord ) {
        playerPosition = coord;
    }

    public void setTerrainMap( TerrainMap map ) {
        terrainMap = map;
    }

    public void addPlayerActivityListener( PlayerActivityListener l ) {
        playerActivityListener = l;
    }

    private boolean terrainIsNavigable( Coordinate coord ) {
        for( TerrainPiece p : allTerrain() )
            if( p.coordinate().x() == coord.x() &&
                p.coordinate().y() == coord.y() )
                return true;
        return false;
    }

    public void tryToMovePlayer( Direction d ) {
        Coordinate newPlayerPosition = new Coordinate2D( playerPosition.x(),
                                                         playerPosition.y() );
        newPlayerPosition.translate( directionDelta( d ) );
        if( terrainIsNavigable( newPlayerPosition ) ) {
            playerPosition = newPlayerPosition;
            if( playerActivityListener != null )
                playerActivityListener.playerPositionChanged();
        }
    }

    public Coordinate directionDelta( Direction d ) {
        if( d == Direction.North )
            return new Coordinate2D(  0, -1 );
        else if( d == Direction.South )
            return new Coordinate2D(  0,  1 );
        else if( d == Direction.East )
            return new Coordinate2D(  1,  0 );
        else if( d == Direction.West )
            return new Coordinate2D( -1,  0 );
        else if( d == Direction.NorthEast )
            return new Coordinate2D(  1, -1 );
        else if( d == Direction.NorthWest )
            return new Coordinate2D( -1, -1 );
        else if( d == Direction.SouthEast )
            return new Coordinate2D(  1,  1 );
        else if( d == Direction.SouthWest )
            return new Coordinate2D( -1,  1 );
        return null;
    }
}

