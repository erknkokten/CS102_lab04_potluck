import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Buttons extends JPanel implements ActionListener{
    JButton[][] buttons;
    JLabel status;
    JPanel panel, empty;
    int numButtons,n,prize,bomb1, bomb2, prizeRow, prizeColumn, bomb1Row, bomb1Column, bomb2Row, bomb2Column, clickCount;
    boolean bomb_flag;

    //Constructor
    public Buttons(int n){
        bomb_flag = false;
        clickCount = 0;
        panel = new JPanel();


        setLayout(new BorderLayout());
        status = new JLabel("Attempt #" + clickCount, JLabel.CENTER);
        status.setPreferredSize(new Dimension(400,50));
        status.setBackground(Color.YELLOW);
        setPreferredSize( new Dimension(400,300));

        add(status, BorderLayout.NORTH);
        setBackground(Color.CYAN);

        panel.setLayout( new GridLayout(n,n));
        buttons = new JButton[n][n];
        numButtons = n*n;
        this.n = n;
        panel.setPreferredSize(new Dimension(400,200));
        setPrizeAndBombs();
        add(panel, BorderLayout.CENTER);
        initButtons();
        addButtons();
        setBackground(Color.ORANGE);


    }

    /**
     * Sets the locations of 1 prize and 2 bombs.
     */
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

    /**
     * initializes the buttons in the buttons array. Also adds ActionListener to all of the buttons.
     */
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

    /**
     * adds buttons to the panel
     */
    private void addButtons(){
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                panel.add(buttons[i][j]);
            }
        }
    }

    /**
     * when buttons are clicked, this method is called.
     * Increases the number of attempts until the user clicks to a bomb or prize.
     * @param event
     */
    public void actionPerformed(ActionEvent event){
        JButton clicked = (JButton) event.getSource();
        //If you want to learn where the prize is and bombs are, use this if sequence
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

        //If you really want to play the game, uncomment the if sequence below and comment the one above.
        /*
        if(clicked.equals(buttons[prizeRow][prizeColumn]) && !bomb_flag){
            status.setText("You got it in " + clickCount + " attempts!");

        }
        else if(clicked.equals(buttons[bomb1Row][bomb1Column]) && !bomb_flag){
            bomb_flag = true;
            status.setText("Sorry! You are blown up at attempt " + clickCount + "!");
        }
        else if(clicked.equals(buttons[bomb2Row][bomb2Column]) && !bomb_flag){
            bomb_flag = true;
            status.setText("Sorry! You are blown up at attempt " + clickCount + "!");
        }
        else if (!bomb_flag){
            clickCount++;
            status.setText("Attempt #" + clickCount);

        }
         */
    }








}
