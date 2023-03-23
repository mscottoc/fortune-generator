import java.util.Scanner;

public class fortunegen {
    public static void main(String[] args) {
        Scanner myScan = new Scanner(System.in);
        System.out.print("Hello traveler, what is your name?\n> ");
        String userName = myScan.nextLine();
        System.out.println("Nice to meet you "+ userName);
        String birthMonth = getMonth(myScan);
        int birthDate = getDay(myScan, birthMonth);
        String sign = getSign(birthMonth, birthDate);

        horoscope today = new horoscope(sign, userName);
        today.display();
    }

    // Gets birth month from the user to later calculate their birth sign
    public static String getMonth(Scanner myScan){
        boolean valid = false;
        String birthMonth;
        // takes user input and ensures a valid month to ensure recognition with other functions
        do{
            System.out.print("What month were you born? (three letter abbreviation ex:  jan, feb, mar...)\n> ");
            birthMonth = myScan.nextLine().toLowerCase();
            if (birthMonth.equals("jan")||birthMonth.equals("feb")||birthMonth.equals("mar")||birthMonth.equals("apr")||
                birthMonth.equals("may")||birthMonth.equals("jun")||birthMonth.equals("jul")||birthMonth.equals("aug")||
                birthMonth.equals("sep")||birthMonth.equals("oct")||birthMonth.equals("nov")||birthMonth.equals("dec")) {
                valid = true;
            } else {
                    System.out.println(birthMonth + ")is not a valid month.");
            }
        }while(!valid);
        return birthMonth;
    }
    // Gets birth day from the user to later calculate their birth sign
    public static int getDay(Scanner myScan, String birthMonth){
        boolean valid = false;
        int birthDate = 0;
        // takes user input and ensures day is both an int and within bounds for accuracy with sing calculation
        do{
            System.out.print("What day of the month were you born?\n> ");
            try {
                birthDate = Integer.parseInt(myScan.nextLine());
                if ((birthMonth.equals("jan")||birthMonth.equals("mar")||birthMonth.equals("may")||
                     birthMonth.equals("jul")||birthMonth.equals("aug")||birthMonth.equals("oct")||
                     birthMonth.equals("dec") && birthDate > 0 && birthDate <= 31)){
                    valid = true;
                } else if ((birthMonth.equals("apr")||birthMonth.equals("jun")||birthMonth.equals("sep")||
                          birthMonth.equals("nov") && birthDate > 0 && birthDate <= 30)){
                    valid = true;
                } else if (birthMonth.equals("feb")&& birthDate > 0 && birthDate <= 29){
                    valid = true;
                } else {
                    System.out.println("This date does not exist");
                }
            } catch(Exception e) {
                System.out.println("Something went wrong. Please try again. Make sure you enter only whole numbers.");
            }
        } while(!valid);
        return birthDate;
    }

    // uses month and day to find star sign to personalize fortune
    public static String getSign(String month, int day){
        switch(month){
            case "jan":
                if(day < 20) return "capricorn";
                else return "aquarius";
            case "feb":
                if(day < 19) return "aquarius";
                else return "pisces";
            case "mar":
                if(day < 21) return "pisces";
                else return "aries";
            case "apr":
                if(day < 20) return "aries";
                else return "taurus";
            case "may":
                if(day < 21) return "taurus";
                else return "gemini";
            case "jun":
                if(day < 22) return "gemini";
                else return "cancer";
            case "jul":
                if(day < 23) return "cancer";
                else return "leo";
            case "aug":
                if(day < 24) return "leo";
                else return "virgo";
            case "sep":
                if(day < 23) return "virgo";
                else return "libra";
            case "oct":
                if(day < 24) return "libra";
                else return "scorpio";
            case "nov":
                if(day < 22) return "scorpio";
                else return "sagittarius";
            case "dec":
                if(day < 22) return "sagittarius";
                else return "capricorn";
            default:
                assert false;
                return "error";
        }
    }

}

