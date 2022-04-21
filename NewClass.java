import java.io.*;

// --------------------------------------------------------------

// BufferedReader in = new BufferedReader(new FileReader("in.txt"));
// String str;
// while ((str=in.readLine()) != null) {
// // faire quelque chose avec la ligne
// System.out.println(str);
// }
// in.close();
// /*************************************************************/
// BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
// PrintWriter out = new PrintWriter(new FileWriter("in.txt"));
// out.println(in.readLine().toLowerCase().toString());
// out.println(in.readLine().toString());
// out.close();

// public class NewClass {
// public static void main(String[] args) throws IOException {
// File inputFile = new File("in.txt");
// File outputFile = new File("out.txt");
// FileReader in = new FileReader(inputFile);// FileNotFoundException il faut
// verifier si les fichiers existent
// FileWriter out = new FileWriter(outputFile);// FileNotFoundException il faut
// verifier si les fichiers existent
// int c;
// while ((c = in.read()) != -1)
// out.write(c);
// in.close();
// out.close();
// }
// }

// --------------------------------------------------------------
// public class Tp5_File {
// // public static void main(string[] args) {
// // string name = "todo.txt";
// // file f = new file(name); // nullpointer exception quand le name n'est pas
// definie
// // system.out.println("f.exists()" + f.exists());
// // system.out.println("f.isdirectory()" + f.isdirectory());
// // if (f.isdirectory()) {
// // string[] list = f.list();
// // for (int i = 0; i < list.length; i++) { system.out.println(" " + list[i]);
// }
// // }
// // }
// // }

// --------------------------------------------------------------
// public class Tp3_ex3 {
// public static void main(String args[]) {
// int x = 1;//-1
// int y = 1;//0
// int z[]= new int[3];
// // Runtime Exceptions System.out.println(" x/y="+(x/y)); System.out.println("
// z[x]="+z[x]);
// // Checked Exception
// try{
// FileInputStream f = new
// FileInputStream("todo.txt");
// }catch(IOException ioe)
// {
// ioe.printStackTrace();
// }
// // Error
// int M = 1000000000;
// Double[] d = new Double[M];

// }}

// --------------------------------------------------------------
// class CompteException extends Exception {
// String motif;

// CompteException(String s) {
// super(s);
// motif = s;

// }
// }
// public class NewClass {
// private int compte;

// NewClass(int montant) {
// this.compte = montant;
// }

// void retireArgeant(int montant) throws CompteException { // methode qui leve
// une exception
// if (montant > compte) {
// throw new CompteException("Possibilités de retrait épuise"); // lever notre
// classe d'exception
// } else {
// compte = compte - montant;
// }
// }

// public static void main(String[] args) {
// NewClass compte1 = new NewClass(1000);
// try {
// compte1.retireArgeant(2000); // Methode qui leve l'exception CompteException
// } catch (CompteException ce) {
// ce.printStackTrace();
// }
// }
// }

// --------------------------------------------------------------
// class Test1 {
// void test1() {
// try {
// throw new Exception();
// } catch (Exception e) {
// System.out.println("first exception a"); // cette methode ne leve pas
// d'exception car elle contient un block
// // catch
// }
// }

// void test2() throws Exception {
// throw new Exception();// cette methode leve une exception au method appelante
// }
// }

// public class NewClass {
// public static void main(String args[]) {
// new Test1().test1();
// try {
// new Test1().test1();
// } catch (Exception e) {
// System.out.println("first exception b"); // not exectued no exception
// }
// }
// }

// --------------------------------------------------------------
// public static void main(String[] args) {
// String fileName = "todo.txt";
// String nString = "12sss0";
// FileInputStream fis;

// int a;
// try {
// a = 1;
// a = 1 / 0; // On ne peut pas diviser par 0
// } catch (Exception e) {
// System.out.println("Number Exception"); // Dans le cas d'un excetpion
// } finally {
// a = -1; // In all cases exception or not a=-1
// }
// System.out.println(a); // prints -1;

// try {
// System.out.println("#1");
// fis = new FileInputStream(fileName);
// System.out.println("#2");

// Integer n = Integer.parseInt(nString);
// System.out.println("#3");
// } catch (IOException ioe) {
// System.out.println(" E/S problem :" + ioe);
// } catch (NumberFormatException nfe) {
// System.out.println(" NumberFormat problem " + nfe);
// } finally {
// System.out.println("#4");

// }
// }}

// incompatible types int cannot be converted to String
// FileNotFound if the file doesn't exist
// Number Format problem java.lang.NumberFormatException: For input string :
// tadad
