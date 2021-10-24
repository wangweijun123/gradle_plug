package com.darren.optimize.day01;

import org.junit.Test;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void testStreamWrite2() throws IOException {
        long starttime = System.currentTimeMillis();
        // (new FileOutputStream(file, append)) 默认是append=false, 表示清除写,  append 追加写
        DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(new File("temp_stream.txt"))));
        for(int i = 0; i < 3; i++){
            dos.writeChars("b");
        }
        if(dos != null){
            dos.close();
        }
        long endtime = System.currentTimeMillis();
        // testStreamWrite:290ms
        System.out.println("testStreamWrite:"+(endtime-starttime)+"ms");
    }
}