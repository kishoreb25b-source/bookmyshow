import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] loc = new String[5];
        String[] theater = new String[5];
        int[] screen = new int[5];
        String[][] movie = new String[5][5];
        int[][] seat = new int[5][5];
        String[] row=new String[5];
        row[0]="A";
        row[1]="B";
        row[2]="C";
        row[3]="D";
        row[4]="E";
        int lochave = 0;
        int theaterhave = 0;
        while (true) {
            System.out.println("1=>Admin");
            System.out.println("2=>User");
            System.out.println("0=>Exit");
            System.out.print("Enter a Login:");
            int login = sc.nextInt();
            sc.nextLine();
            if (login == 1) {
                System.out.println("1=>Add Location");
                System.out.println("2=>Add Theater");
                System.out.println("3=>Add Movie");
                System.out.println("4=>Show Data");
                System.out.println("5=>Exit");
                System.out.print("Enter choice: ");
                int ch = sc.nextInt();
                sc.nextLine();
                if (ch == 1) {
                    System.out.println("Enter Location Name:");
                    loc[lochave] = sc.nextLine();
                    lochave++;
                    System.out.println("Added Location");
                } else if (ch == 2) {
                    if (lochave == 0) {
                        System.out.println("First Add Location");
                        continue;
                    }
                    System.out.println("Enter Theater Name");
                    theater[theaterhave] = sc.nextLine();
                    System.out.println("Enter Screen:");
                    screen[theaterhave] = sc.nextInt();
                    sc.nextLine();
                    theaterhave++;
                    System.out.println("Added Theater and Screen");
                } else if (ch == 3) {
                    if (theaterhave == 0) {
                        System.out.println("First Add Theater and Screen");
                        continue;
                    }
                    for (int i = 0; i < theaterhave; i++) {
                        System.out.print(i + 1);
                        System.out.print(".");
                        System.out.println(theater[i]);
                    }
                    System.out.print("Select theater number: ");
                    int t = sc.nextInt();
                    sc.nextLine();
                    if (t < 1 || t > theaterhave) {
                        System.out.println("Invalid theater");
                        continue;
                    }
                    System.out.print("Enter screen number: ");
                    int s = sc.nextInt();
                    sc.nextLine();
                    if (s < 1 || s > screen[t - 1]) {
                        System.out.println("Invalid screen");
                        continue;
                    }
                    System.out.print("Enter movie name: ");
                    movie[t - 1][s - 1] = sc.nextLine();
                    System.out.println("Movie added to screen");
                } else if (ch == 4) {
                    for (int i = 0; i < theaterhave; i++) {
                        System.out.println("-----Show-----");
                        System.out.print("Theater:");
                        System.out.println(theater[i]);
                        System.out.print("Screen :");
                        System.out.println(screen[i]);
                        for (int j = 0; j < screen[i]; j++) {
                            System.out.print("Screen :");
                            System.out.print(j + 1);
                            System.out.print("Movie:");
                            System.out.println(movie[i][j]);
                        }
                        System.out.println("--------------");
                    }
                } else if (ch == 5) {
                    System.out.println("Thank you");
                    break;
                } else {
                    System.out.println("Invalid choice");
                }
            } else if (login == 2) {
                System.out.println("1=>Book Ticket");
                System.out.println("2=>Exit");
                System.out.print("Enter choice: ");
                int ch = sc.nextInt();
                sc.nextLine();
                if (ch == 1) {
                    for (int i = 0; i < lochave; i++) {
                        System.out.print(i + 1);
                        System.out.print(".");
                        System.out.println(loc[i]);
                    }
                    System.out.println("Enter Location:");
                    String userloc = sc.nextLine();
                    int check = 0;
                    for (int i = 0; i < lochave; i++) {
                        if (loc[i].equals(userloc)) {
                            check = check + 1;
                            break;
                        }
                    }
                    if (check == 0) {
                        System.out.println("No theater in this location ");
                    } else if (check == 1) {
                        for (int i = 0; i < theaterhave; i++) {
                            System.out.print("Theater:");
                            System.out.println(theater[i]);
                            System.out.print("Screen :");
                            System.out.println(screen[i]);
                            for (int j = 0; j < screen[i]; j++) {
                                System.out.print("Screen :");
                                System.out.print(j + 1);
                                System.out.print("Movie:");
                                System.out.println(movie[i][j]);
                            }
                        }
                        System.out.println("Enter the movie to Book:");
                        String movNo = sc.nextLine();
                        for (int i = 0; i < theaterhave; i++) {
                            if (theater[i].equals(movNo)) {
                                System.out.print(i + 1);
                                System.out.print(".");
                                System.out.println(theater[i]);
                            }
                        }
                        System.out.print("Select row: ");
                        String w = sc.nextLine();
                        int r=0;
                        if(w.equals(row[0])){
                            r=0;
                        }else if(w.equals(row[1])){
                            r=1;
                        }else if(w.equals(row[2])){
                            r=2;
                        }else if(w.equals(row[3])){
                            r=3;
                        } else if(w.equals(row[4])){
                            r=4;
                        }else{
                            System.out.println("Ent correct");
                        }
                        System.out.print("Select col:");
                        int c = sc.nextInt();
                        sc.nextLine();
                        if (r>4 || c>5) {
                            System.out.println("Invalid seat");
                        } else {
                            seat[r][c] = 1;
                            System.out.println("Seat is Booked");
                            for (int i = 0; i < 5; i++) {
                                for (int j = 0; j < 5; j++) {
                                    System.out.print(seat[i][j]);
                                    System.out.print(" ");
                                }
                                System.out.println();
                            }
                        }

                    } else if (ch == 2) {
                        System.out.println("Thank you");
                        break ;
                    } else {
                        System.out.println("Invalid choice");
                    }
                } else {
                    System.out.println("Invalid Choice");
                }
            } else if (login==0) {
                System.out.println("Thanks for visiting...");
                break;
            }else{
                System.out.println("Invalid choice..");
            }
        }
    }
}
