import java.io.*;
//import java.math.*;

public class repeatrate  {
    public  static  int longestcommon(String str1,String str2) {//求最小公共子序列
        String s1 = "2"+str1;
        String s2 = "1"+str2;
        //给两个字符串头多添一个字符
        //使第一行和第一列都变为0
        int [][]check = new int[str1.length()+1][str2.length()+1];
        for(int i = 0; i < s1.length(); i++) {
            for(int j = 0; j < s2.length(); j++) {
                if(i == 0 || j == 0) {//定义第一个格子为0
                    check[i][j] = 0;
                }
                else if (s1.charAt(i) == s2.charAt(j)) {
                    check[i][j] = (check[i-1][j-1]+1);
                }
                else {
                    //取上一个数和左边的数中大的数
                    if (check[i-1][j] > check[i][j-1])
                        check[i][j] = check[i-1][j];
                    else
                        check[i][j] = check[i][j-1];
                }
            }
        } 
        //返回数组的最后一位
        return  check[s1.length()-1][s2.length()-1];
    }

    static float rate(String path1, String path2) throws IOException {
        float ratee = 0;
        String filePath = path1;
        System.out.println("原文："+path1);
        System.out.println("抄袭："+path2);
        String comparePath = path2;
        //被比较文本与比较文本路径
        String text1 = new String();
        String text2 = new String();
        BufferedReader in1 = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), "UTF8"));
        BufferedReader in2 = new BufferedReader(new InputStreamReader(new FileInputStream(comparePath), "UTF8"));
        String str;
        while ((str = in1.readLine()) != null) {
            text1 += str;
        }
        while ((str = in2.readLine()) != null) {
            text2 += str;
        }
        int comlen = longestcommon(text1, text2);
        int len1 = text1.length();
        int len2 = text2.length();
        in1.close();
        in2.close();
        if (len1 > len2) {
            ratee = (float)comlen/len1;
        }
        else {
            ratee = (float)comlen/len2;
        }
        float  rate1 =  (float)(Math.round(ratee*100))/100;
        return rate1;
    }
}