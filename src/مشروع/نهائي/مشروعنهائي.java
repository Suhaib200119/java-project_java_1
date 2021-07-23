/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package مشروع.نهائي;

import java.util.Scanner;

/**
 *
 * @author a
 */
public class مشروعنهائي {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] bus = new int[28];//تعريف المصفوفة
        int choice;//تعريف الاختيار
        int available = 28;//عددالمقاعد المتاحة  طبعا في بداية البرنامج يقوم العدد  ثماني وعشرون مقعد فارغ
        //افعل
        do {

            System.out.println("1.Display number of available seats");
            System.out.println("2.Display seat status for all seats.");
            System.out.println("3.Reserve seats");
            System.out.println("4.Delete reservations");
            System.out.println("5.Exit");
            System.out.println("please select your choice:[1,2,3,4or5]: ");
            choice = input.nextInt();
            //الخيار الاول يعرض عدد المقاعد المتاحة
            if(choice > 5 || choice < 1){
                System.out.println("Invalid choice");
            }
            switch (choice) {
                case 1:
                    available=0;
                    for (int index1 = 0; index1 < bus.length; index1++) {
                        if (bus[index1] == 0) {
                            available++;
                        }
                    }   System.out.println(" number of available seats=" + available);
                    System.out.println("Press Enter key to continue");
                    input.nextLine();//حتى يتم تطبيق خاصية الانتر
                    input.nextLine();//حتى يتم تطبيق خاصية الانتر
                    break;
                case 2:
                    //يعرض حالة المقاعد
                    String fill = "";
                    for (int index2 = 0; index2 < bus.length; index2++) {
                        
                        if (bus[index2] == 0 && (index2 + 1 < 10)) {
                            fill += "[   " + (index2 + 1) + "    ]";
                        } else if (bus[index2] == 0 && (index2 + 1 >= 10)) {
                            fill += "[  " + (index2 + 1) + "    ]";
                        } else {
                            fill += " Reserved ";
                        }

                        if (((index2 + 1) % 4 == 0)) {
                            fill += "\n";
                        }
                        
                    }   System.out.println(fill);
                    System.out.println("press Enter key to continue...");
                    input.nextLine();
                    input.nextLine();
                    break;
                case 3:
                    {
                        //بعرض حالة المقاعد وعدد المقاعد المتاحة واجراء عملية الحجز
                        int availableSeats = 0;//المقاعد المتاحة
                        String fillx = "";
                        for (int index3 = 0; index3 < bus.length; index3++) {
                            
                            if (bus[index3] == 0 && (index3 + 1 < 10)) {
                                fillx += "[   " + (index3 + 1) + "    ]";
                            } else if (bus[index3] == 0 && (index3 + 1 >= 10)) {
                                fillx += "[  " + (index3 + 1) + "    ]";
                            } else {
                                fillx += " Reserved ";
                            }
                            
                            if (((index3 + 1) % 4 == 0)) {
                                fillx += "\n";
                            }
                            
                        }       System.out.println(fillx);
                        for (int index4 = 0; index4 < bus.length; index4++) {
                            if (bus[index4] == 0) {
                                availableSeats++;
                            }
                        }       System.out.print("There are " + availableSeats + " seats available. please enter required number of seats: ");
                        int TheNumberOfSeatsYouWantToReserve = input.nextInt();//عدد المقاعد الذي تريد حجزها
                        int reservedSeats = 0;//المقاعد المحجوزة
                        for (int index5 = 0; index5 < bus.length; index5++) {
                            if (bus[index5] == 1) {
                                reservedSeats++; //بحسب عدد المقاعد المحجوزة
                            }
                        }       if (reservedSeats == 28) {
                            System.out.println("Sorry,there are no available seats.");
                        } else if (TheNumberOfSeatsYouWantToReserve > available) {
                            System.out.println("Error: Insufficient available seats.");
                        } else if (TheNumberOfSeatsYouWantToReserve <= 0) {
                            System.out.println("Error: Invalid number of seats.");
                        } else if (TheNumberOfSeatsYouWantToReserve > 0) {
                            
                            int count1 = 0;// عداد
                            int TheSeatNumberYouWantToReserve = 0;//رقم المقعد اللي بده يحجزه
                            
                            while (count1 != TheNumberOfSeatsYouWantToReserve) {
                                
                                System.out.print("Enter seat number of required seat:  ");
                                TheSeatNumberYouWantToReserve = input.nextInt();//رقم المقعد اللي بده يحجزه
                                if (TheSeatNumberYouWantToReserve < 1 || TheSeatNumberYouWantToReserve > 28) {
                                    System.out.println("Invalid number, please enter number between 1 and 28");
                                    //b
                                } else if (bus[TheSeatNumberYouWantToReserve - 1] == 1) {
                                    System.out.println("Error: One or more required seats is already reserved.");
                                    break;
                                } else {
                                    bus[TheSeatNumberYouWantToReserve - 1] = 1;
                                    count1++;
                                    if (count1 == TheNumberOfSeatsYouWantToReserve) {
                                        System.out.println("Required seats successfully reserved.");
                                        
                                    }
                                }
                                
                            }
                            
                        }       System.out.println("press Enter key to continue...");
                        input.nextLine();
                        input.nextLine();
                        break;
                    }
                case 4:
                    {
                        String fill3 = "";
                        for (int index6 = 0; index6 < bus.length; index6++) {
                            
                            if (bus[index6] == 0 && (index6 + 1 < 10)) {
                                fill3 += "[   " + (index6 + 1) + "    ]";
                            } else if (bus[index6] == 0 && (index6 + 1 >= 10)) {
                                fill3 += "[  " + (index6 + 1) + "    ]";
                            } else {
                                fill3 += " Reserved ";
                            }
                            
                            if (((index6 + 1) % 4 == 0)) {
                                fill3 += "\n";
                            }
                            
                        }       System.out.println(fill3);
                        System.out.print("please enter required number of reservations to delete: ");
                        int TheNumberOfSeatsYouWantToDeleteReserved = input.nextInt();//عدد المقاعد اللي بده يحذف حجزهم
                        int reservedSeats = 0;//مقاعد محجوزة
                        for (int index7 = 0; index7 < bus.length; index7++) {
                            if (bus[index7] == 1) {
                                reservedSeats++;
                            }
                        }       if (TheNumberOfSeatsYouWantToDeleteReserved > reservedSeats) {
                            System.out.println("Error: Invalid number of reservations to delete.");
                            
                        } else if (TheNumberOfSeatsYouWantToDeleteReserved <= 0) {
                            System.out.println("Error: Invalid number of seats.");
                        } else if (TheNumberOfSeatsYouWantToDeleteReserved > 0) {
                            
                            int count2 = 0;//عداد بلزم لطلب ارقام المقاعد اللي بده يحذف حجزها
                            int numberOfRequiredSeatsDelete = 0;//رقم المقعد اللي بده يحذف حجزه
                            
                            while (count2 != TheNumberOfSeatsYouWantToDeleteReserved) {
                                
                                System.out.print("Enter seat number of reservation to be deleted: ");
                                numberOfRequiredSeatsDelete = input.nextInt();
                                if (numberOfRequiredSeatsDelete < 1 || numberOfRequiredSeatsDelete > 28) {
                                    System.out.println("Invalid number, please enter number between 1 and 28");
                                    
                                } else if (bus[numberOfRequiredSeatsDelete - 1] == 0) {
                                    
                                    System.out.println("Error: One or more required seats already empty.");
                                    break;
                                    
                                } else {
                                    bus[numberOfRequiredSeatsDelete - 1] = 0;
                                    count2++;
                                    if (count2 == TheNumberOfSeatsYouWantToDeleteReserved) {
                                        System.out.println("Required reservation(s) successfully deleted");
                                        
                                    }
                                }
                                
                            }
                            
                        }       System.out.println("press Enter key to continue...");
                        input.nextLine();
                        input.nextLine();
                        break;
                    }
                case 5:
                    System.exit(0);
                default:
                    break;
            }
            

        } while (choice>=1&&choice<=5);

    }
    
}
