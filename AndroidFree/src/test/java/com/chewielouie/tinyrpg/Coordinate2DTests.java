package com.chewielouie.tinyrpg;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import org.jmock.*;
import org.jmock.integration.junit4.JMock;
import org.junit.Test;
import org.junit.runner.RunWith;
import com.chewielouie.tinyrpg.Coordinate;

@RunWith(JMock.class)
public class Coordinate2DTests {

    private Mockery mockery = new Mockery();

    @Test
    public void has_x_coordinate() {
        Coordinate coord = new Coordinate2D( 3, 0 );
        assertThat( coord.x(), is( 3 ) );
    }

    @Test
    public void has_y_coordinate() {
        Coordinate coord = new Coordinate2D( 0, 7 );
        assertThat( coord.y(), is( 7 ) );
    }

    @Test
    public void z_coordinate_is_always_zero() {
        Coordinate coord = new Coordinate2D( 2, 3 );
        assertThat( coord.z(), is( 0 ) );
    }

    @Test
    public void translate_x_changes_x_by_supplied_delta() {
        Coordinate coord = new Coordinate2D( 3, 0 );
        coord.translate( new Coordinate2D( 2, 0 ) );
        assertThat( coord.x(), is( 5 ) );
    }

    @Test
    public void translate_y_changes_y_by_supplied_delta() {
        Coordinate coord = new Coordinate2D( 0, 3 );
        coord.translate( new Coordinate2D( 0, 2 ) );
        assertThat( coord.y(), is( 5 ) );
    }

    @Test
    public void translate_has_no_affect_on_z() {
        Coordinate coord = new Coordinate2D( 0, 3 );
        coord.translate( new Coordinate2D( 2, 2 ) );
        assertThat( coord.z(), is( 0 ) );
    }
}

