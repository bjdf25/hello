package heima;

/*
    当流写入的时候，只需调用write方法然后在括号里写入想写的东西，一般都是"XXXX".getBytes()把想写的东西转化为字节形式
    当流读入的时候，一般需要int len = 0，并且调用while（（len = fos.read(bytes)））{sout(get String(bytes,0,len))}
      注意：
      其中的new String就是把被读文件里的字节转化为字符串形式
      注意：
       .getBytes和new String的使用
           👆写      👆读
     缓冲流有点类似于调用数组的形式，目的就是为了让流读写的速度更加快，另应注意调用之后需要调用flush或者close方法才能使流成功读写

     注意：
     在FileWriter 和 FileReader中就不用.getBytes和new String了，因为可以直接写入汉字
 */
import java.io.*;

public class DemoCopyFileWithBuffered {

    public static void main(String[] args) throws IOException {
//        long s = System.currentTimeMillis();
//        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("D:\\英雄时刻\\14529041\\a.avi"));
//        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("D:\\a.avi"));
//        int len = 0;
//        byte [] bytes = new byte[1024]; 
//        while((len=bis.read(bytes))!= -1){
//            bos.write(bytes,0,len);
//        }
//        long e = System.currentTimeMillis();
//        bos.close();
//        bis.close();
//        System.out.println(e-s + "毫秒");
//        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("D:\\英雄时刻\\14529041\\c.txt"));
//        bos.write("这是在缓冲流作用下的写入".getBytes());
//        bos.close();

        BufferedWriter bw = new BufferedWriter(new FileWriter("D:\\IdeaProjects\\hello\\src\\heima\\a.txt"));
        for (int i = 0; i < 10; i++) {
            bw.write("传智播客");
            bw.newLine();//newline就是换行，在任何系统中都可以换行，不用再注意\r\n了
        }
        bw.close();
    }
}
