import java.awt.*;
import java.util.Scanner;
import javax.swing.*;
public class potLuck {
    
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n;
        do {
            System.out.println("Enter a number n (bigger than 1): ");
            n = scan.nextInt();
        }while(n<= 1);

        Buttons buttons = new Buttons(n);

        JFrame frame = new JFrame();
        frame.setTitle("POT LUCK");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(buttons);
        frame.setBackground(Color.RED);
        frame.setSize(400,500);
        frame.setVisible(true);


    }
}
