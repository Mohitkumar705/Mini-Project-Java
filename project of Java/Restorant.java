
import java.util.Scanner;

class Restorant 
{
    public static void main(String[] args) 
    {
        
        Scanner in = new Scanner(System.in);
        System.out.println("Welcome To Sir My Restorant..");
        System.out.println("Please Sir Your Adhar no..");
        double n = in.nextDouble();
        System.out.println("Please Sir Your Mobile no..");
        double a = in.nextDouble();
        System.out.println("Sir Your Table No Is 8 ..");
        String S = in.nextLine();
        System.out.println("Please Sir Your Name..");
        String p = in.nextLine();
        System.out.println("Welcome to "+S+" Sir Your table no 8");
        System.out.println("1.BreakFast \n2.Lunch \n3.Dinner ");
        System.out.println("Please Sir Choice Your Meanu");
        int b = in.nextInt();
        switch(b)
        {
            case 1:
            System.out.println("1.Tea Rs.10 \n2.Coffe Rs.20");
            System.out.println("Sir Your Person");
            int c = in.nextInt();
            System.out.println("Sir Your Choise");
            int d = in.nextInt();
            switch(d)
            {
                case 1:
                System.out.println("Ok Sir your choice:: Tea");
                System.out.println("Sir Your Amount pay is::"+c*10);
                break;
                case 2:
                System.out.println("Ok sir your choice:: Coffe");
                System.out.println("Sir Your Amount pay is::"+c*20);
                break;
                default:
                System.out.println("Sorry Sir Your Choise Option is Not Avilable In Meanu");
            }
            break;
            case 2:
            System.out.println("1.Chola Chaval Rs.50 \n2.Panner Rs.100");
            System.out.println("Sir Your Person");
            int e = in.nextInt();
            System.out.println("Sir Your Choice");
            int f = in.nextInt();
            switch(f)
            {
                case 1:
                System.out.println("Ok sir your choise: Chola Chaval");
                System.out.println("Sir Your Amount pay is.."+e*50);
                break;
                case 2:
                System.out.println("Ok sir your choise: Panner");
                System.out.println("Sir Your Amount pay is.."+e*100);
                break;
                default:
                System.out.println("Sorry Sir Your Choise Option is Not Avilable In Meanu");
            }
            break;
            case 3:
            System.out.println("1.Chapp Rs.150 \n2.Kadhi Panner Rs.200");
            System.out.println("Sir Your Person");
            int g = in.nextInt();
            System.out.println("Sir Your Choice");
            int h = in.nextInt();
            switch(h)
            {
                case 1:
                System.out.println("Ok sir your choise: Chapp");
                System.out.println("Sir Your Amount Pay is.."+g*150);
                break;
                case 2:
                System.out.println("Ok sir your choise: Kadhi Panner");
                System.out.println("Sir Your Amount pay is.."+g*200);
                break;
                default:
                System.out.println("Sorry Sir Your Choise Option is Not Avilable In Meanu");
                break;
            }
            break;
            default:
            System.out.println("Sorry Sir Your Choise Option is Not Avilable In Meanu"); 
            break;     
        }
        in.close();
    }
}
