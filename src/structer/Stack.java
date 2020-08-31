package structer;

import java.util.ArrayList;
import java.util.List;

public class Stack {


    public static void main(String[] args) {

        String expression = "1+((2+3)*4)-5";
        List<String> list = toInfixExpressionList(expression);
        System.out.println(list);
    }

    public static List<String> toInfixExpressionList(String s){
        List<String> list = new ArrayList<>();
        int i = 0;
        char ch;
        String str;
        do {
            if ((ch = s.charAt(i)) < 48 || (ch = s.charAt(i)) > 57){
                list.add(""+ch);
                i++;
            }else {
                str = "";
                while ( i < s.length() && (ch = s.charAt(i)) >= 48 && (ch = s.charAt(i)) <= 57){

                    str = str + ch;
                    i++;
                }
                list.add(""+str);
            }
        }while (i < s.length());


        return list;
    }
}
