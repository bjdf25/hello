package heima;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/*
    文件复制：
    所有形式的文件都是以字节的方式形成，所以把一个文件复制到另一个文件只需要把文件读入内存，再写入目的地即可
    用单个字节读写的方式太慢，一般都用数组的方式读写提升速率
    注意while循环是关键
    while((len = fis.read(bytes))!= -1)一步是让字节长度就等于读取的数组的字节长度 等于-1的时候就不再执行代码块中的代码
    这样节省了内存空间 有助于提高效率  ！= -1一步一定要有
    需注意要调用close方法把字节流关闭，不然占用内存资源
    在复制文件的过程，要先关闭写入流再关闭读入流
    因为写入流完成了则读入流一定完成了
    读入流完成了写入流不一定完成了
 */
public class DemoFileCopy {
//    public static void main(String[] args) throws IOException {
//        long l = System.currentTimeMillis();
//        FileInputStream fis = new FileInputStream("D:\\英雄时刻\\14529041\\英雄时刻_20190908-15点10分42s.gif");
//        FileOutputStream fos = new FileOutputStream("D:\\PUBG精彩一刻\\Photo\\a.gif");
//        byte [] bytes = new byte[1024];
//        int len = 0;
//        while ((len=fis.read(bytes))!= -1){
//            fos.write(bytes,0,len);
//        }
//        long e = System.currentTimeMillis();
//        System.out.println(e-l);
//    }


    public static void main(String[] args) throws IOException {
        long s = System.currentTimeMillis();
     FileInputStream fis = new FileInputStream("D:\\英雄时刻\\14529041\\英雄时刻_20190920-22点43分06s.gif");
     FileOutputStream fos = new FileOutputStream("D:\\PUBG精彩一刻\\Photo\\b.gif");
     byte[] bytes = new byte[10240];
     int len = 0;
     while ((len = fis.read(bytes))!= -1){
         fos.write(bytes,0,len);
     }
     fos.close();
     fis.close();
       long e = System.currentTimeMillis();
     long sum = e-s;
        System.out.println("复制过程花了"+ sum + "毫秒");
    }
}
