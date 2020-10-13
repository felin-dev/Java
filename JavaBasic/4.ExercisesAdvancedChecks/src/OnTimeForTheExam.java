import java.util.Scanner;

public class OnTimeForTheExam {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int hourOfTheExam = Integer.parseInt(sc.nextLine());
        int minutesOfTheExam = Integer.parseInt(sc.nextLine());
        int hourOfArrival = Integer.parseInt(sc.nextLine());
        int minutesOfArrival = Integer.parseInt(sc.nextLine());

        int differenceInMinutes;
        int differenceInHours;
        int examTime;
        int arrivalTime;
        if (hourOfTheExam <= hourOfArrival) {
            if (hourOfTheExam == hourOfArrival) {
                if (minutesOfTheExam < minutesOfArrival) {
                    System.out.println("Late");
                    examTime = (hourOfTheExam * 60) + minutesOfTheExam;
                    arrivalTime = (hourOfArrival * 60) + minutesOfArrival;
                    differenceInMinutes = examTime - arrivalTime;
                    differenceInMinutes = differenceInMinutes % 60;
                    System.out.printf("%d minutes after the start", Math.abs(differenceInMinutes));
                }
                if (minutesOfArrival == minutesOfTheExam){
                    System.out.println("On time");
                }
            } else {
                differenceInHours = hourOfArrival - hourOfTheExam;
                if (differenceInHours == 1) {
                    if (minutesOfArrival < minutesOfTheExam) {
                        examTime = (hourOfTheExam * 60) + minutesOfTheExam;
                        arrivalTime = (hourOfArrival * 60) + minutesOfArrival;
                        differenceInMinutes = examTime - arrivalTime;
                        differenceInMinutes = differenceInMinutes % 60;
                        System.out.println("Late");
                        System.out.printf("%d minutes after the start", Math.abs(differenceInMinutes));
                    } else {
                        if (minutesOfArrival == minutesOfTheExam) {
                            System.out.println("Late");
                            System.out.println("1:00 hours after the start");
                        } else {
                            examTime = (hourOfTheExam * 60) + minutesOfTheExam;
                            arrivalTime = (hourOfArrival * 60) + minutesOfArrival;
                            differenceInMinutes = examTime - arrivalTime;
                            differenceInMinutes = differenceInMinutes % 60;
                            System.out.println("Late");
                            System.out.printf("%d:%d hours after the start", differenceInHours, Math.abs(differenceInMinutes));
                        }
                    }
                } else {
                    examTime = (hourOfTheExam * 60) + minutesOfTheExam;
                    arrivalTime = (hourOfArrival * 60) + minutesOfArrival;
                    differenceInMinutes = examTime - arrivalTime;
                    differenceInMinutes = differenceInMinutes % 60;
                    System.out.println("Late");
                    System.out.printf("%d:%d hours after the start", differenceInHours, Math.abs(differenceInMinutes));
                }
            }
        }

        if (hourOfTheExam >= hourOfArrival) {
            if (hourOfTheExam == hourOfArrival) {
                if (minutesOfTheExam > minutesOfArrival) {
                    examTime = (hourOfTheExam * 60) + minutesOfTheExam;
                    arrivalTime = (hourOfArrival * 60) + minutesOfArrival;
                    differenceInMinutes = examTime - arrivalTime;
                    differenceInMinutes = differenceInMinutes % 60;
                    if (differenceInMinutes <= 30) {
                        System.out.println("On time");
                    } else {
                        System.out.println("Early");
                    }
                    System.out.printf("%d minutes before the start", Math.abs(differenceInMinutes));
                }
            } else {
                differenceInHours = hourOfTheExam - hourOfArrival;
                if (differenceInHours == 1) {
                    if (minutesOfArrival < minutesOfTheExam) {
                        examTime = (hourOfTheExam * 60) + minutesOfTheExam;
                        arrivalTime = (hourOfArrival * 60) + minutesOfArrival;
                        differenceInMinutes = examTime - arrivalTime;
                        differenceInMinutes = differenceInMinutes % 60;
                        if (differenceInMinutes <= 30) {
                            System.out.println("On time");
                        } else {
                            System.out.println("Early");
                        }
                        System.out.printf("%d minutes before the start", Math.abs(differenceInMinutes));
                    } else {
                        if (minutesOfArrival == minutesOfTheExam) {
                            System.out.println("Early");
                            System.out.println("1:00 hours before the start");
                        } else {
                            examTime = (hourOfTheExam * 60) + minutesOfTheExam;
                            arrivalTime = (hourOfArrival * 60) + minutesOfArrival;
                            arrivalTime = arrivalTime % 60;
                            differenceInMinutes = examTime - arrivalTime;
                            differenceInMinutes = differenceInMinutes % 60;
                            if (differenceInMinutes <= 30) {
                                System.out.println("On time");
                            } else {
                                System.out.println("Early");
                            }
                            System.out.printf("%d minutes before the start", Math.abs(differenceInMinutes));
                        }
                    }
                } else {
                    examTime = (hourOfTheExam * 60) + minutesOfTheExam;
                    arrivalTime = (hourOfArrival * 60) + minutesOfArrival;
                    differenceInMinutes = examTime - arrivalTime;
                    differenceInMinutes = differenceInMinutes % 60;
                    System.out.println("Early");
                    System.out.printf("%d:%d hours before the start", differenceInHours, Math.abs(differenceInMinutes));
                }
            }
        }
    }
}
