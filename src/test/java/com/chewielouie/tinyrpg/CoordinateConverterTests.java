package com.chewielouie.tinyrpg;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import org.junit.Test;
import org.junit.runner.RunWith;

public class CoordinateConverterTests {

    @Test
    public void converts_world_origin_to_center_of_view() {
        CoordinateConverter c = new CoordinateConverter();
        int viewWidth = 100;
        int viewHeight = 200;
        c.setViewSize( viewWidth, viewHeight );
        Coordinate viewCoord = c.convertWorldToView( new Coordinate2D( 0, 0 ) );

        assertThat( viewCoord.x(), is( viewWidth/2 ) );
        assertThat( viewCoord.y(), is( viewHeight/2 ) );
    }

    @Test
    public void converts_world_origin_offset_by_view_unit_size() {
        CoordinateConverter c = new CoordinateConverter();
        int viewUnitWidth = 20;
        int viewUnitHeight = 40;
        c.setViewUnitSize( viewUnitWidth, viewUnitHeight );
        Coordinate viewCoord = c.convertWorldToView( new Coordinate2D( 0, 0 ) );

        assertThat( viewCoord.x(), is( -viewUnitWidth/2 ) );
        assertThat( viewCoord.y(), is( -viewUnitHeight/2 ) );
    }

    @Test
    public void converts_world_to_view_coordinates_offset_from_world_origin() {
        CoordinateConverter c = new CoordinateConverter();
        int viewUnitWidth = 20;
        int viewUnitHeight = 40;
        c.setViewUnitSize( viewUnitWidth, viewUnitHeight );
        Coordinate viewCoord = c.convertWorldToView( new Coordinate2D( -1, -1 ) );

        assertThat( viewCoord.x(), is( -30 ) );
        assertThat( viewCoord.y(), is( -60 ) );
    }

    @Test
    public void converts_world_to_view_when_centred_on_non_origin() {
        CoordinateConverter c = new CoordinateConverter();
        int viewUnitWidth = 20;
        int viewUnitHeight = 40;
        c.setViewUnitSize( viewUnitWidth, viewUnitHeight );
        c.centerViewOnWorldCoord( new Coordinate2D( 1, 2 ) );
        Coordinate viewCoord = c.convertWorldToView( new Coordinate2D( 0, 0 ) );

        assertThat( viewCoord.x(), is( -30 ) );
        assertThat( viewCoord.y(), is( -100 ) );
    }
}


