package heima;
/*
    总结：
        遍历文件的流程：
        1.在main方法里先调用遍历文件的方法getAllFiles,并且在构造参数里输入自己想要遍历的哪个文件夹的路径名字，
          注意路径名字是String类型，要加引号
        2.在getAllFiles方法里先在构造参数里创建文件对象：File dir,然后再用方法listFiles把当前文件夹下的所有文件和文件夹都
          封装为一个个的对象并储存在数组里，即:File []files = dir.listFiles
        3.然后再对数组File进行for遍历，即：
          for(File f : files)对数组内的对象一个个的进行操作，即对文件夹dir内的一个个文件或文件夹进行操作
        4.if（f.isDirectory）{getAllFiles(f)}:当遍历到某一个对象是文件夹时，就把这个对象送到getAllFiles方法里把这个对象
          当成第二个dir再次进行1.2.3的操作,当来到第四步再次判定若还是文件夹则再次执行getAllFiles方法
        5.最后输出文件.sout(f)
      注意：遍历文件夹首先保证该文件夹的绝对路径应该真实存在
           当想要筛选文件的时候可以在File []files = dir.listFiles一步添加过滤器
           即:File []files = dir.listFiles(FileFilter)
           注意过滤器只是个接口，没有实现类，所以应该用内部匿名法重写接口内的accept方法输入自己想要的筛选方法
           又因为过滤器接口FileFilter内只有一个方法所以可以用Lambda表达式简写

 */

import java.io.File;
import java.io.FileFilter;

public class DemoFileFilter {
    public static void main(String[] args) {
        
        getAllFiles(new File("D:\\JavaFile"));
    }

    private static void getAllFiles(File dir) {
//        File[] files = dir.listFiles(new FileFilter() {//dir是一个File的对象，listFiles方法的作用就是把这个文件夹内的所有文件
//            //和文件夹封装成一个个的对象，装到数组File里，然后在下面对数组File遍历对象就是遍历一个个的文件或者文件夹
//            @Override
//            public boolean accept(File pathname) {
//                return pathname.getName().endsWith(".txt");//endsWith方法必须得是一个String类型的才能调用，所以pathname得先
//                //使用getName方法把pathname转化为String类型，pathname是一个file类的对象
//            }
//        });
        File[] files = dir.listFiles((pathname -> pathname.isDirectory()||pathname.getName().endsWith(".txt")));
        //Lambda表达式的简洁写法
        //return pathname.isDirectory() 如果pathname还是一个文件夹的话就返回真，继续执行方法体，遇到if(f.isDirectory())就
        // 再次执行getAllFiles方法，再次把这个文件夹当成dir对象再次在过滤器里筛选
        for (File f : files) {//这里的f是一个文件或者文件夹，被listFiles方法封装成了对象
            if(f.isDirectory()){//如果是文件夹则再次把这个文件夹内的文件或文件夹封装成对象一个个的遍历，直到没有文件夹为止
                getAllFiles(f);//getAllFiles方法调用的是File类的对象
            }else {
                System.out.println(f);
            }
            
        }
    }
}
