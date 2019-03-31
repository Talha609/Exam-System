import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class AddQues implements ActionListener
{
    DB_Queries dbqueries;
    JFrame f;
    JPanel p;
    JLabel ques,ans,o1,o2,o3;
    JTextField op1,op2,op3;
    JTextArea quess,anss;
    JButton save,clr;
    public AddQues()
    {
        dbqueries=new DB_Queries();
        f=new JFrame("Add Ques");
        f.setSize(750,310);
        p=new JPanel();
        p.setLayout(null);
        f.add(p);

        ques=new JLabel("Question");
        ans=new JLabel("Answer");
        o1=new JLabel("Option 1");
        o2=new JLabel("Option 2");
        o3=new JLabel("Option 3");

        save=new JButton("Save");
        clr=new JButton("Clear");

        quess=new JTextArea();
        anss=new JTextArea();
        op1=new JTextField(20);
        op2=new JTextField(20);
        op3=new JTextField(20);

        ques.setBounds(10,10,300,25);
        quess.setBounds(10,40,300,100);
        o1.setBounds(400,10,300,25);
        op1.setBounds(400,40,300,25);
        o2.setBounds(400,80,300,25);
        op2.setBounds(400,110,300,25);
        o3.setBounds(400,150,300,25);
        op3.setBounds(400,180,300,25);
        ans.setBounds(10,150,300,25);
        anss.setBounds(10,180,300,80);
        save.setBounds(490,235,100,30);
        clr.setBounds(600,235,100,30);

        Font fnt = new Font("TimesNewRoman", Font.BOLD, 15);
        ques.setFont(fnt);
        quess.setFont(fnt);
        ans.setFont(fnt);
        anss.setFont(fnt);
        o1.setFont(fnt);
        op1.setFont(fnt);
        o2.setFont(fnt);
        op2.setFont(fnt);
        o3.setFont(fnt);
        op3.setFont(fnt);
        save.setFont(fnt);
        clr.setFont(fnt);
        p.add(ques);p.add(quess);
        p.add(ans);p.add(anss);p.add(o1);
        p.add(op1);p.add(o2);p.add(op2);
        p.add(o3);p.add(op3);
        p.add(save);p.add(clr);
        f.setVisible(true);
        f.setResizable(false);
        f.setDefaultCloseOperation(2);
        f.setLocationRelativeTo(null);
        save.addActionListener(this);
        clr.addActionListener(this);
    }

    public void actionPerformed(ActionEvent evt)
    {
        if(evt.getSource()==save)
        {
            int result=dbqueries.addQues(quess.getText().toString().trim(),anss.getText().toString().trim(),op1.getText().toString().trim(),op2.getText().toString().trim(),op3.getText().toString().trim());
            if(result==1)
            {
                JOptionPane.showMessageDialog(f,"Question Added","Ques",JOptionPane.PLAIN_MESSAGE);
                f.setVisible(false);
                f.dispose();
                dbqueries.close();
            }
            else
            {
                JOptionPane.showMessageDialog(f,"Question Not Added","Ques",JOptionPane.PLAIN_MESSAGE);
                dbqueries.close();
            }
        }
        if(evt.getSource()==clr)
        {
            quess.setText("");
            anss.setText("");
            op1.setText("");
            op2.setText("");
            op3.setText("");
        }
    }

    public static void main(String args[])
    {
        new AddQues();
    }
}