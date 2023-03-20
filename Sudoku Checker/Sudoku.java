import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Sudoku extends JFrame implements ActionListener
{
 int[][] attempt = new int[9][9];

 JTextField row1 = new JTextField(26);
 JTextField row2 = new JTextField(26);
 JTextField row3 = new JTextField(26);
 JTextField row4 = new JTextField(26);
 JTextField row5 = new JTextField(26);
 JTextField row6 = new JTextField(26);
 JTextField row7 = new JTextField(26);
 JTextField row8 = new JTextField(26);
 JTextField row9 = new JTextField(26);
 
 JButton check = new JButton("Check Solution");
 JLabel resultLabel = new JLabel("Please replace the zeros with your attempt.");
 final int WIDTH = 350;
 final int HEIGHT= 400;
 public Sudoku()
 {
 
 super("Sudoku Game");
 row1.setFont(new Font("Courier New", Font.PLAIN, 16));
 row2.setFont(new Font("Courier New", Font.PLAIN, 16));
 row3.setFont(new Font("Courier New", Font.PLAIN, 16));
 row4.setFont(new Font("Courier New", Font.PLAIN, 16));
 row5.setFont(new Font("Courier New", Font.PLAIN, 16));
 row6.setFont(new Font("Courier New", Font.PLAIN, 16));
 row7.setFont(new Font("Courier New", Font.PLAIN, 16));
 row8.setFont(new Font("Courier New", Font.PLAIN, 16));
 row9.setFont(new Font("Courier New", Font.PLAIN, 16));

 row1.setText("5, 3, 0, 0, 7, 0, 0, 0, 0");
 row2.setText("6, 0, 0, 1, 9, 5, 0, 0, 0");
 row3.setText("0, 9, 8, 0, 0, 0, 0, 6, 0");
 row4.setText("8, 0, 0, 0, 6, 0, 0, 0, 3");
 row5.setText("4, 0, 0, 8, 0, 3, 0, 0, 1");
 row6.setText("7, 0, 0, 0, 2, 0, 0, 0, 6");
 row7.setText("0, 6, 0, 0, 0, 0, 2, 8, 0");
 row8.setText("0, 0, 0, 4, 1, 9, 0, 0, 0");
 row9.setText("0, 0, 0, 0, 8, 0, 0, 7, 9");
 
 
 
 setSize(WIDTH, HEIGHT);
 setResizable(false);
 setLayout(new FlowLayout());
 add(row1);
 add(row2);
 add(row3);
 add(row4);
 add(row5);
 add(row6);
 add(row7);
 add(row8);
 add(row9);

 
 add(check);
 add(resultLabel);
 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 check.addActionListener(this);
 }
 
 
 @Override
 public void actionPerformed(ActionEvent e)
 {
 parseFields();
 if( checkResult())
   resultLabel.setText("Good Job!");
 else
 resultLabel.setText("Keep Trying");
 
 

 }
 public void parseFields()
 {
 String row1Data = row1.getText().replaceAll("\\D", "");  
 for(int i =0;i<9;i++)
   {
      attempt[0][i] = Character.getNumericValue(row1Data.charAt(i));
   }
 String row2Data = row2.getText().replaceAll("\\D", "");  
 for(int i =0;i<9;i++)
   {
      attempt[1][i] = Character.getNumericValue(row2Data.charAt(i));
   }
  String row3Data = row3.getText().replaceAll("\\D", "");  
 for(int i =0;i<9;i++)
   {
      attempt[2][i] = Character.getNumericValue(row3Data.charAt(i));
   } 
  String row4Data = row4.getText().replaceAll("\\D", "");  
 for(int i =0;i<9;i++)
   {
      attempt[3][i] = Character.getNumericValue(row4Data.charAt(i));
   } 
   String row5Data = row5.getText().replaceAll("\\D", "");  
 for(int i =0;i<9;i++)
   {
      attempt[4][i] = Character.getNumericValue(row5Data.charAt(i));
   } 
   String row6Data = row6.getText().replaceAll("\\D", "");  
 for(int i =0;i<9;i++)
   {
      attempt[5][i] = Character.getNumericValue(row6Data.charAt(i));
   } 
   String row7Data = row7.getText().replaceAll("\\D", "");  
 for(int i =0;i<9;i++)
   {
      attempt[6][i] = Character.getNumericValue(row7Data.charAt(i));
   } 
   String row8Data = row8.getText().replaceAll("\\D", "");  
 for(int i =0;i<9;i++)
   {
      attempt[7][i] = Character.getNumericValue(row8Data.charAt(i));
   }
   String row9Data = row9.getText().replaceAll("\\D", "");  
 for(int i =0;i<9;i++)
   {
      attempt[8][i] = Character.getNumericValue(row9Data.charAt(i));
   }
 }
 

 
 
 public boolean checkResult()
 {

 //check everything is 1-9
 for(int i =0;i<9;i++)
    for (int j=0;j<9;j++)
      if(attempt[i][j] >9 || attempt[i][j]<1)
      return false;
 //check rows
 for(int row =0; row<9; row++)
   {
      for(int col =0; col<8; col++)
         {
            if(attempt[row][col] == attempt[row][col+1])
            return false;

         } 
   
   }
   
   //check columns 
 for(int col =0; col<9; col++)
   {
      for(int row =0; row<8; row++)
         {
            if(attempt[row][col] == attempt[row+1][col])
            return false;
         } 
   
   }      
   
   //check 9x9s... brb, looking into another degree
   for(int row = 0; row<9; row+=3)
      for(int col = 0; col<9;col+=3)
      {
         int place =0;
         int[] temp = new int[9];
         for(int i =row; i< row+3;i++)
            for (int j = col; j<col+3;j++)
            {
               temp[place] = attempt[i][j];
               place++;
            }
            
         for(int k =0 ;k<8;k++)
            for (int m= k+1;m<8;m++)
               if(temp[m] == temp[k])
               return false;
      }         
               


  
   
   
 return true;
 
 }
}