import java.awt.*;
import java.util.Scanner;
import javax.swing.*;
public class potLuck {
    
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n;
        System.out.println("Enter a number n: ");
        n = scan.nextInt();

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
