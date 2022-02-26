import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

import static org.junit.Assert.assertEquals;

public class RleProgramTest {
    @Test
    public void toHexStringTest(){
        byte[] flatData = {3,15,6,4};
        String groups = "3f64";
        assertEquals(groups, RleProgram.toHexString(flatData));
    }

    @Test
    public void countRunsTest() {
        byte[] flatData = {1,2,3,4,5};
        int groups = 5;
        assertEquals(groups, RleProgram.countRuns(flatData));

    }

    @Test
    public void encodeRleTest() {
        byte[] flatData = {15, 15, 15, 8, 5, 5, 6, 6, 6, 6, 6, 6, 2, 2, 2, 2, 2};
        byte[] groups = {3, 15, 1, 8, 2, 5, 6, 6, 5, 2};
        assertArrayEquals(groups, RleProgram.encodeRle(flatData));

    }

    @Test
    public void getDecodedLengthTest() {
        byte[] flatData = {3, 15, 2, 5, 7, 8};
        int groups = 12;
        assertEquals(groups, RleProgram.getDecodedLength(flatData));

    }

    @Test
    public void decodeRleTest() {
        byte[] flatData = {3, 15, 6, 4};
        byte[] groups = {15, 15, 15, 4, 4, 4, 4, 4, 4};
        assertArrayEquals(groups, RleProgram.decodeRle(flatData));

    }

    @Test
    public void stringToDataTest() {
        String flatData = "3f64";
        byte[] groups = {3, 15, 6, 4,};
        assertArrayEquals(groups, RleProgram.stringToData(flatData));
    }

    @Test
    public void stringToDataTestMixed() {
        String flatData = "16181f1e1d1c1b1a191817";
        byte[] groups = {1, 6, 1, 8, 1, 15, 1, 14, 1, 13, 1, 12, 1, 11, 1, 10, 1, 9, 1 ,8, 1, 7};
        assertArrayEquals(groups, RleProgram.stringToData(flatData));
    }

    @Test
    public void toRleStringTest() {
        byte[] flatData = {15, 15, 6, 4, 12, 3, 4, 13, 1, 2, 2, 1, 1, 2, 1, 1, 1, 2, 12, 10};
        String groups = "15f:64:123:4d:12:21:12:11:12:12a";
        assertEquals(groups, RleProgram.toRleString(flatData));
    }

    @Test
    public void stringToRleTest() {
        String flatData = "9f:64";
        byte[] groups = {9, 15, 6, 4};
        assertArrayEquals(groups, RleProgram.stringToRle(flatData));
    }

}
