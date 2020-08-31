package heima;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Showkaiping {
    public static void main(String[] args) throws IOException {
//
        long s = System.currentTimeMillis();
        FileInputStream fis = new FileInputStream("D:\\英雄时刻\\14529041\\英雄时刻_20190922-20点41分20s.gif");
        FileOutputStream fos = new FileOutputStream("D:\\PUBG精彩一刻\\Photo\\kaiping.gif");
        byte[] bytes = new byte[1024];
        int len = 0;
        while ((len = fis.read(bytes)) != -1){
            fos.write(bytes,0,len);
        }
        long e = System.currentTimeMillis();
        long sum = e - s;
        System.out.println("整个复制过程总时长为" + sum);
    }
}
