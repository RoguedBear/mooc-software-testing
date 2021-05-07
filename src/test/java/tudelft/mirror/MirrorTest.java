package tudelft.mirror;

/*
- even
- odd
- cann be
- cannot be
 */

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class MirrorTest {
    private Mirror mirror;

    @BeforeEach
    public void initialise(){
        this.mirror = new Mirror();
    }

    @Test
    public void evenTrue(){
        String result = mirror.mirrorEnds("abcdba");
        Assertions.assertEquals("ab", result);
    }
    @Test
    public void evenFalse(){
        String result = mirror.mirrorEnds("abcdef");
        Assertions.assertEquals("", result);
    }
    @Test
    public void oddFalse(){
        String result = mirror.mirrorEnds("abcde");
        Assertions.assertEquals("", result);
    }

    @Test
    public void oddTrue(){
        String result = mirror.mirrorEnds("abCDba");
        Assertions.assertEquals("ab", result);
    }
    @Test
    public void nullInput(){
        String result = mirror.mirrorEnds("");
        Assertions.assertEquals("", result);
    }
    @Test
    public void entireStringIsMirror(){
        String result = mirror.mirrorEnds("abccba");
        Assertions.assertEquals("abc", result);
    }

    @Test
    public void overlapping(){
        String result = mirror.mirrorEnds("abc121cba");
        Assertions.assertEquals("abc12", result);

    }

}
