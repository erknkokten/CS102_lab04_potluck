import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Buttons extends JPanel implements ActionListener{
    JButton[][] buttons;
    JTextArea status;
    JPanel panel;
    int numButtons,n,prize,bomb1, bomb2, prizeRow, prizeColumn, bomb1Row, bomb1Column, bomb2Row, bomb2Column, clickCount;
    public Buttons(int n){
        clickCount = 0;
        panel = new JPanel();
        status = new JTextArea("Attempt #" + clickCount);
        panel.setPreferredSize( new Dimension(400,50));
        panel.add(status);
        panel.setBackground(Color.CYAN);

        buttons = new JButton[n][n];
        numButtons = n*n;
        this.n = n;
        setPreferredSize(new Dimension(400,400));
        setPrizeAndBombs();
        add(panel);
        initButtons();
        addButtons();
        setBackground(Color.ORANGE);


    }
    private void setPrizeAndBombs(){
        //index verecek
        prize = (int) (Math.random() * numButtons ) ;
        int index = prize;
        prizeRow = (int) (index/n) ;
        prizeColumn = index%n ;
        //prize location is row,column
        /*System.out.println(prizeRow);
        System.out.println(prizeColumn);
        */
        do{
            bomb1 =(int) (Math.random() * numButtons );
        }while( bomb1 == prize);

        index = bomb1;
        bomb1Row = (int) (index/n) ;
        bomb1Column = index%n ;
        /*System.out.println(bomb1Row);
        System.out.println(bomb1Column);
        */
        do{
            bomb2 =(int) (Math.random() * numButtons );
        }while( bomb2 == prize || bomb2 == bomb1);

        index = bomb2;
        bomb2Row = (int) (index/n) ;
        bomb2Column = index%n ;
        /*System.out.println(bomb2Row);
        System.out.println(bomb2Column);*/
    }

    private void initButtons(){
        int num = 0;
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                String str = "Button " + (num);
                buttons[i][j] = new JButton(str);
                buttons[i][j].addActionListener(this);
                num++;
            }
        }

    }
    private void addButtons(){
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                add(buttons[i][j]);
            }
        }
    }

    public void actionPerformed(ActionEvent event){
        JButton clicked = (JButton) event.getSource();
        if(clicked.equals(buttons[prizeRow][prizeColumn])){
            status.setText("You got it in " + clickCount + " attempts!");

        }
        else if(clicked.equals(buttons[bomb1Row][bomb1Column])){

            status.setText("Sorry! You are blown up at attempt " + clickCount + "!");
        }
        else if(clicked.equals(buttons[bomb2Row][bomb2Column])){
            status.setText("Sorry! You are blown up at attempt " + clickCount + "!");
        }
        else{
            clickCount++;
            status.setText("Attempt #" + clickCount);

        }
    }








}
