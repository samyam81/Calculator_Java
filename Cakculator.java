package Calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;;

public class Cakculator implements ActionListener{
    
    JFrame frame;
    JTextField textfield;
    JButton[] numButtons=new JButton[10];
    JButton[] funcButtons=new JButton[8];
    JButton addButton,subButton,mulButton,divButton;
    JButton decButton,equButton,delButton,clrButton;
    JPanel panel;

    Font myFont=new Font("DialogInput",Font.BOLD,30);
    double num1=0,num2=0,result=0;
    String operator;

    Cakculator(){
            frame =new JFrame("Calculator");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(420,550);
            frame.setLayout(null);

            textfield=new JTextField();
            textfield.setBounds(49,27,291,49);
            textfield.setFont(myFont);
            textfield.setEditable(false);
            
            addButton=new JButton("+");
            subButton=new JButton("-");
            mulButton=new JButton("*");
            divButton=new JButton("/");
            decButton=new JButton(".");
            equButton=new JButton("=");
            delButton=new JButton("del");
            clrButton=new JButton("cls");

            funcButtons[0]=addButton;
            funcButtons[1]=subButton;
            funcButtons[2]=mulButton;
            funcButtons[3]=divButton;
            funcButtons[4]=equButton;
            funcButtons[5]=decButton;
            funcButtons[6]=clrButton;
            funcButtons[7]=delButton;

            for (int i = 0; i < 8; i++) {
                funcButtons[i].addActionListener(this);
                funcButtons[i].setFont(myFont);
                funcButtons[i].setFocusable(false);
            }

            for (int i = 0; i < 10; i++) {
                numButtons[i]=new JButton(String.valueOf(i));
                numButtons[i].addActionListener(this);
                numButtons[i].setFont(myFont);
                numButtons[i].setFocusable(false);
            
            }

            delButton.setBounds(206,421,142,49);
            clrButton.setBounds(50,421,142,49);

            panel=new JPanel();
            panel.setBounds(49,99,299,299);
            panel.setLayout(new GridLayout(4,4,10,10));
            panel.setBackground(Color.pink);

            panel.add(numButtons[0]);
            panel.add(numButtons[3]);
            panel.add(numButtons[8]);
            panel.add(mulButton);

            panel.add(numButtons[2]);
            panel.add(numButtons[7]);
            panel.add(numButtons[9]);
            panel.add(subButton); 

            panel.add(numButtons[4]);
            panel.add(numButtons[5]);
            panel.add(numButtons[6]);
            panel.add(addButton); 
            panel.add(decButton);
            panel.add(numButtons[1]);
            panel.add(equButton);
            panel.add(divButton);


            frame.add(panel);
            frame.add(delButton);
            frame.add(clrButton);
            frame.add(textfield);
            frame.setVisible(true);
    }
    public static void main(String[] args) {
        new Cakculator();
    }


    @Override
    public  void actionPerformed(ActionEvent e){
            
        for (int i = 0; i < 10; i++) {
             if (e.getSource()==numButtons[i]) {
                textfield.setText(textfield.getText().concat(String.valueOf(i))); 
             }   
            }

        if(e.getSource()==decButton){
            textfield.setText(textfield.getText().concat("."));
        }

         if(e.getSource()==addButton){
            num1=Double.parseDouble(textfield.getText());
            operator="+";
            textfield.setText("");
        }
        if(e.getSource()==subButton){
            num1=Double.parseDouble(textfield.getText());
            operator="-";
            textfield.setText("");
        }
        if(e.getSource()==mulButton){
            num1=Double.parseDouble(textfield.getText());
            operator="*";
            textfield.setText("");
        }
        if(e.getSource()==divButton){
            num1=Double.parseDouble(textfield.getText());
            operator="/";
            textfield.setText("");
        }
        if (e.getSource()==equButton) {
            num2=Double.parseDouble(textfield.getText());
            switch (operator) {
                case "+":
                        result=num1+num2;
                    break;
                case "-":
                        result=num1-num2;
                    break;
                case "*":
                        result=num1*num2;
                    break;
                case "/":
                        result=num1/num2;
                    break;
            }
            textfield.setText(String.valueOf(result));
            num1=result;

        }

        if(e.getSource()==clrButton){
            textfield.setText("");
        }

        if(e.getSource()==delButton){
            String string=textfield.getText();
            textfield.setText("");
            for (int i = 0; i < string.length()-1; i++) {
                textfield.setText(textfield.getText()+string.charAt(i));
            }
        }
    }
}
