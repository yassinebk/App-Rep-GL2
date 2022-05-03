import java.io.*;

public class FileCopier {

    static void copySrcToDest(String src, String dest) {
        FileReader in = null;
        BufferedReader br = null;
        FileWriter out = null;
        BufferedWriter bw = null;

        try {
            in = new FileReader(src);
            br = new BufferedReader(in);
            out = new FileWriter(dest);
            bw = new BufferedWriter(out);
            String str;
            while ((str = br.readLine()) != null && str.length() != 0) {
                String strin2 = str;
                strin2 = strin2.strip();
                if (!strin2.startsWith("//") && !strin2.startsWith("/*") && !str.startsWith("*/"))
                    bw.append("\n" + str);
            }
            bw.close();
            out.close();
            br.close();
            in.close();
        } catch (FileNotFoundException exception) {
            exception.printStackTrace();
            System.out.println("Dest file is not flund");
        } catch (IOException exception) {
            exception.printStackTrace();
            System.out.println("Exception: Check the write,read, close operators");
        } catch (Exception exception) {
            exception.printStackTrace();
        }

    }

    public static void main(String[] args) {
        FileCopier.copySrcToDest("todo.txt", "notDo.txt");

    }

}
