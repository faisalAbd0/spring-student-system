//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.atypon.student_grading_system.Socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

class Client {
    static Scanner sc;

    Client() {
    }

    public static Character menu() {
        System.out.println("Welcome to Student-Grading System");
        System.out.println("1. student login");
        System.out.println("2. instructor login");
        System.out.println("3. admin login");
        System.out.println("4. exit");
        return !sc.hasNext() ? '4' : sc.nextLine().charAt(0);
    }

    public static void sendCredentials(Character input, PrintWriter out) {
        out.println(input);
        System.out.println("Enter your username: ");
        String email = sc.nextLine();
        System.out.println("Enter your password: ");
        String password = sc.nextLine();
        out.println(email + " " + password);
        out.flush();
    }

    public static void setGrade(BufferedReader in, PrintWriter out, Scanner scanner) throws IOException {
        System.out.println(">>CourseId");
        String first = in.readLine();
        System.out.println(first);
        int courseId = Integer.parseInt(scanner.nextLine());
        out.println(courseId);
        out.flush();
        System.out.println(">>StudentId");
        String second = in.readLine();
        System.out.println(second);
        int studentId = Integer.parseInt(scanner.nextLine());
        out.println(studentId);
        out.flush();
        System.out.println(">>Grade");
        String third = in.readLine();
        System.out.println(third);
        int grade = Integer.parseInt(scanner.nextLine());
        out.println(grade);
        out.flush();
    }

    public static void sendMenuOption(Character input, BufferedReader in, PrintWriter out) throws IOException {
        Scanner scanner = new Scanner(System.in);

        while(true) {
            String line;
            while((line = in.readLine()).equals("Enter your choice:")) {
                System.out.print("> ");
                String choice = scanner.nextLine();
                out.println(choice);
                out.flush();
                if (choice.equals("-1")) {
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                }

                if (input.equals('1')) {
                    receiveResponse(in, out);
                } else if (input.equals('2')) {
                    handleInstructorActions(in, out, scanner, choice);
                } else if (input.equals('3')) {
                    handleAdminActions(in, out, scanner, choice);
                }
            }

            System.out.println(line);
        }
    }

    private static void handleAdminActions(BufferedReader in, PrintWriter out, Scanner scanner, String choice) throws IOException {
        switch (choice) {
            case "1":
                System.out.print("Enter instructor username: ");
                String instUsername = scanner.nextLine();
                System.out.print("Enter instructor password: ");
                String instPassword = scanner.nextLine();
                out.println(instUsername);
                out.println(instPassword);
                out.flush();
                System.out.println(in.readLine());
                break;
            case "2":
                System.out.print("Enter student username: ");
                String stuUsername = scanner.nextLine();
                System.out.print("Enter student password: ");
                String stuPassword = scanner.nextLine();
                System.out.print("Enter student age: ");
                int stuAge = Integer.parseInt(scanner.nextLine());
                System.out.print("Enter student GPA: ");
                double stuGPA = Double.parseDouble(scanner.nextLine());
                out.println(stuUsername);
                out.println(stuPassword);
                out.println(stuAge);
                out.println(stuGPA);
                out.flush();
                System.out.println(in.readLine());
                break;
            case "3":
                System.out.print("Enter course name: ");
                String courseName = scanner.nextLine();
                System.out.print("Enter student limit: ");
                int courseLimit = Integer.parseInt(scanner.nextLine());
                out.println(courseName);
                out.println(courseLimit);
                out.flush();
                System.out.println(in.readLine());
                break;
            case "4":
                System.out.print("Enter student ID to delete: ");
                int stuId = Integer.parseInt(scanner.nextLine());
                out.println(stuId);
                out.flush();
                System.out.println(in.readLine());
                break;
            case "5":
                System.out.print("Enter instructor ID to delete: ");
                int instId = Integer.parseInt(scanner.nextLine());
                out.println(instId);
                out.flush();
                System.out.println(in.readLine());
                break;
            case "6":
                System.out.print("Enter course ID to delete: ");
                int courseId = Integer.parseInt(scanner.nextLine());
                out.println(courseId);
                out.flush();
                System.out.println(in.readLine());
                break;
            default:
                System.out.println("Invalid choice.");
        }

    }

    private static void handleInstructorActions(BufferedReader in, PrintWriter out, Scanner scanner, String choice) throws IOException {
        if (choice.equals("1")) {
            receiveResponse(in, out);
        } else if (choice.equals("2")) {
            setGrade(in, out, scanner);
            String message = in.readLine();
            System.out.println(message);
        }

    }

    public static void receiveResponse(BufferedReader in, PrintWriter out) throws IOException {
        String success = in.readLine();
        if (!success.equals("false")) {
            System.out.println("Received data:");

            String line;
            while((line = in.readLine()) != null && !line.equals("END")) {
                System.out.println(line);
            }

        }
    }

    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 1234)) {
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            Character input = null;

            while(true) {
                input = menu();
                if (input == '4') {
                    sc.close();
                    break;
                }

                sendCredentials(input, out);
                sendMenuOption(input, in, out);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    static {
        sc = new Scanner(System.in);
    }
}
