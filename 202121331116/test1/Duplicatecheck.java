import java.io.*;


public class Duplicatecheck {
    public static void main(String[] args) throws IOException {
        float a = repeatrate.rate("D:\\javacode\\test1\\orig.txt","D:\\javacode\\test1\\orig_add.txt");
        String atext = "D:\\javacode\\test1\\result.txt";
        System.out.println("输出结果文件" + atext);
        System.out.println("重复率"+ a);
        File f = new File(atext);
        try {
            if(!f.exists()) {
                f.createNewFile();
            }
            FileWriter fw = new FileWriter(f);
            fw.write("");
            fw.flush();
            fw.write(String.valueOf(a));
            fw.close();
        }catch(IOException e) {
            e.printStackTrace();
        }
    }
}