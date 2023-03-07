import java.util.Scanner;

class Main {
    public static void main(String[] args) {

        //Prepare objects
        viewerFactory viewerFactory = new viewerFactory();
        Scanner sc = new Scanner(System.in);

        //Salutations Banner
        menu salute = viewerFactory.getOption(null);
        salute.message();

        //Actual stuff
        menu option1 = viewerFactory.getOption(sc.nextLine());
        option1.message();
        option1.sort();




    }
}
