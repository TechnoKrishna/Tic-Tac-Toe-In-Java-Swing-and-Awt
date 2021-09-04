package tictactoe;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class Game extends JFrame implements ActionListener{
    
    JLabel TextField;
    JPanel TextField_Panel,Button_Panel;
    JButton[] buttons = new JButton[9];
    
    int no=0;
    
    Random random;
    
    int rand;
    Boolean player_turn = true;
    
    Game()
    {        
        TextField_Panel = new JPanel();
        TextField_Panel.setBackground(Color.BLACK); 
        
        TextField = new JLabel("TIC TAC TOE");
        TextField.setFont(new Font("MV BOLI",Font.PLAIN,35));
        TextField.setForeground(Color.GREEN);        
        
        Button_Panel = new JPanel();
        Button_Panel.setBackground(Color.red);
        Button_Panel.setLayout(new GridLayout(3,3));      
        
        
        for(int i = 0 ; i < 9  ; i++)
        {
            buttons[i] = new JButton();
            buttons[i].addActionListener(this);
            buttons[i].setFont(new Font("MV BOLI",Font.PLAIN,45));
            buttons[i].setFocusable(false);
            Button_Panel.add(buttons[i]);
        }              
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500,500);
        this.setTitle("TIC TAC TOE");
        this.setLayout(new BorderLayout());
        this.setLocationRelativeTo(null); 
        
        this.add(TextField_Panel,BorderLayout.NORTH);        
        this.add(Button_Panel);
        
        TextField_Panel.add(TextField);
        
        this.setVisible(true); 
        
        try {
            Thread.sleep(1500);
        } catch (InterruptedException ex) {
            
        }
        
        RandomNumberGenereter();
    }
    
    public void RandomNumberGenereter()
    {
        random = new Random();
        rand = random.nextInt(2)+1;
        
        System.out.println(rand);
        
        Player_Turns();
    }
    
    public void Player_Turns()
    {
        if(rand == 1)
        {
            player_turn = true;
            TextField.setText("PLAYER 1 TURN");
        }
        else if(rand == 2)
        {
            player_turn = false;
            TextField.setText("PLAYER 2 TURN");
        }
        else
        {
            
        }
    }
    
    public void WinnerCombination()
    {
        // 0 1 2
        // 3 4 5
        // 6 7 8
        
        // PLAYER 1 WINS COMBINATIONS
        
        if( (buttons[0].getText() == "X") && (buttons[1].getText() == "X") && (buttons[2].getText() == "X") )
        {
            XWins(0,1,2);
        }
        else if( (buttons[3].getText() == "X") && (buttons[4].getText() == "X") && (buttons[5].getText() == "X") )
        {
            XWins(3,4,5);
        }
        else if( (buttons[6].getText() == "X") && (buttons[7].getText() == "X") && (buttons[8].getText() == "X") )
        {
            XWins(6,7,8);
        }
        else if( (buttons[0].getText() == "X") && (buttons[3].getText() == "X") && (buttons[6].getText() == "X") )
        {
            XWins(0,3,6);
        }
        else if( (buttons[1].getText() == "X") && (buttons[4].getText() == "X") && (buttons[7].getText() == "X") )
        {
            XWins(1,4,7);
        }
        else if( (buttons[2].getText() == "X") && (buttons[5].getText() == "X") && (buttons[8].getText() == "X") )
        {
            XWins(2,5,8);
        }
        else if( (buttons[0].getText() == "X") && (buttons[4].getText() == "X") && (buttons[8].getText() == "X") )
        {
            XWins(0,4,8);
        }
        else if( (buttons[2].getText() == "X") && (buttons[4].getText() == "X") && (buttons[6].getText() == "X") )
        {
            XWins(2,4,6);
        }         
        
        // PLAYER 2 WINS COMBINATIONS
        
        else if( (buttons[0].getText() == "O") && (buttons[1].getText() == "O") && (buttons[2].getText() == "O") )
        {
            OWins(0,1,2);
        }
        else if( (buttons[3].getText() == "O") && (buttons[4].getText() == "O") && (buttons[5].getText() == "O") )
        {
            OWins(3,4,5);
        }
        else if( (buttons[6].getText() == "O") && (buttons[7].getText() == "O") && (buttons[8].getText() == "O") )
        {
            OWins(6,7,8);
        }
        else if( (buttons[0].getText() == "O") && (buttons[3].getText() == "O") && (buttons[6].getText() == "O") )
        {
            OWins(0,3,6);
        }
        else if( (buttons[1].getText() == "O") && (buttons[4].getText() == "O") && (buttons[7].getText() == "O") )
        {
            OWins(1,4,7);
        }
        else if( (buttons[2].getText() == "O") && (buttons[5].getText() == "O") && (buttons[8].getText() == "O") )
        {
            OWins(2,5,8);
        }
        else if( (buttons[0].getText() == "O") && (buttons[4].getText() == "O") && (buttons[8].getText() == "O") )
        {
            OWins(0,4,8);
        }
        else if( (buttons[2].getText() == "O") && (buttons[4].getText() == "O") && (buttons[6].getText() == "O") )
        {
            OWins(2,4,6);
        }         
        else if(no == 9)
        {
            TextField.setText("MATCH TIE");
            for(int i = 0 ; i < 9 ; i++)
            {
                buttons[i].setEnabled(false);
            } 
        }
    }
    
    public void XWins(int a , int b ,int c)
    { 
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);
        
        TextField.setText("PLAYER 1 WINS");
        
        for(int i = 0 ; i < 9 ; i++)
        {
            buttons[i].setEnabled(false); 
        }
    }
    
    public void OWins(int a , int b , int c)
    {
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);
        
        TextField.setText("PLAYER 2 WINS");        
        
        for(int i = 0 ; i < 9 ; i++)
        {
            buttons[i].setEnabled(false); 
        }
    }
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i = 0 ; i < 9 ; i++)
        {
            if(e.getSource() == buttons[i])
            {
                if(buttons[i].getText() == "")
                {
                    if(player_turn)
                    {
                        WinnerCombination();                        
                        buttons[i].setText("X");
                        buttons[i].setForeground(Color.BLUE);
                        player_turn = false;
                        TextField.setText("PLAYER 2 TURN");
                        no++;
                        WinnerCombination();                        

                    }
                    else
                    {
                        WinnerCombination();                        
                        buttons[i].setText("O");
                        buttons[i].setForeground(Color.RED);
                        player_turn = true;
                        TextField.setText("PLAYER 1 TURN");
                        no++;
                        WinnerCombination();                        
                    }
                }
                else
                {
                    
                }
            }
        }
    }
}

public class TicTacToe {
    public static void main(String[] args) {
       
        Game game = new Game();
        
    }    
}
