package buontyhunter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import buontyhunter.common.Point2d;

class Point2dTest {
    
    @Test
    void testPoint2d() {
        Point2d p1 = new Point2d(1, 2);
        Point2d p2 = new Point2d(1, 2);
        Point2d p3 = new Point2d(2, 3);
        Assertions.assertEquals(p1, p2);
        Assertions.assertNotEquals(p1, p3);
        Assertions.assertEquals(p1.hashCode(), p2.hashCode());
        Assertions.assertNotEquals(p1.hashCode(), p3.hashCode());
    }
}
