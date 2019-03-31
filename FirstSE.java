import java.util.ArrayList;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
class FirstSE implements ActionListener
{
    JFrame f;
    JPanel p;
    JLabel l1,que,o1,o2,o3,o4;
    JRadioButton c1,c2,c3,c4;
    JButton flag,sub,timer;
    static JButton next,prev;
    ArrayList<Integer> num;
    ArrayList<Integer> temp;
    ArrayList<String> list_ques ;
    Font font1,font2;
    static int i=0;
    String retque="",retans1="";
    String retans2="",retans3="";
    String retans4="";
    static int retval=0;
    JFrame screen[]=new JFrame[GetQues.GetQues()];
    Time time;
    public FirstSE()
    {
        font1 = new Font("SansSerif", Font.BOLD, 16);
        font2 = new Font("TimesNewRoman", Font.BOLD, 18);
        f=new JFrame("Exam System");
        f.setSize(1100,600);
        p=new JPanel();
        p.setLayout(null);
        ImageIcon img= new ImageIcon(new ImageIcon("united.png").getImage().getScaledInstance(1100, 600, Image.SCALE_DEFAULT));
        l1=new JLabel();
        que=new JLabel();
        l1.setIcon(img);
        f.add(p);
        f.add(l1);

        sub=new JButton("Submit");
        prev=new JButton("Prev");
        next=new JButton("Next");
        //flag=new JButton("Flag");
        Questions();
        if(i==GetQues.GetQues())
        {
            next.setEnabled(false);
            next.setVisible(false);
            sub.setVisible(true);
        }
        else
        {
            sub.setVisible(false);
        }
        prev.setFont(font2);
        next.setFont(font2);
        sub.setFont(font2);
        //flag.setFont(font2);
        prev.setBounds(850,500,110,50);
        next.setBounds(970,500,110,50);
        sub.setBounds(970,500,110,50);
        //flag.setBounds(20,500,110,50);
        next.setBackground(Color.gray);
        sub.setBackground(Color.gray);
        prev.setBackground(Color.gray);
        next.setForeground(Color.white);
        prev.setForeground(Color.white);
        sub.setForeground(Color.white);
        //flag.setBackground(Color.gray);
        //flag.setForeground(Color.white);
        f.setLocationRelativeTo(null);
        l1.add(next);l1.add(prev);
        l1.add(sub);//l1.add(flag);
        f.setVisible(true);
        f.setDefaultCloseOperation(2);
        f.setResizable(false);
        next.addActionListener(this);
        prev.addActionListener(this);
        sub.addActionListener(this);
        //flag.addActionListener(this);
    }

    public void actionPerformed(ActionEvent evt)
    {
        if(evt.getSource()==next && c1.isSelected())
        {
            retval+=AnsSE.AnsCheck(retque,retans1);
            screen[i]=f;
            f.dispose();
            f.setVisible(false);
            new FirstSE();
        }

        if(evt.getSource()==next && c2.isSelected())
        {
            retval+=AnsSE.AnsCheck(retque,retans2);
            screen[i]=f;
            f.dispose();
            f.setVisible(false);
            new FirstSE();
        }

        if(evt.getSource()==next && c3.isSelected())
        {
            retval+=AnsSE.AnsCheck(retque,retans3);
            screen[i]=f;
            f.dispose();
            f.setVisible(false);
            new FirstSE();
        }

        if(evt.getSource()==next && c4.isSelected())
        {
            retval+=AnsSE.AnsCheck(retque,retans4);
            screen[i]=f;
            f.dispose();
            f.setVisible(false);
            new FirstSE();
        }
        try
        {
            if(evt.getSource()==prev)
            {
                if(i>=1)
                {
                    f.setVisible(false);
                    --i;
                    --i;
                    //f=screen[i];
                }
                if(i<=-1)
                {
                    JOptionPane.showMessageDialog(f,"Unable to go back","Error",1);
                    i++;
                }
                new FirstSE();
                //f.setVisible(true);
            }
        }
        catch(Exception e)
        {
            /*i++;
            --i;
            new FirstSE();*/
        }
        if(evt.getSource()==sub)
        {
            if(c1.isSelected())
            {
                retval+=AnsSE.AnsCheck(retque,retans1);
            }

            if(c2.isSelected())
            {
                retval+=AnsSE.AnsCheck(retque,retans2);
            }

            if(c3.isSelected())
            {
                retval+=AnsSE.AnsCheck(retque,retans3);
            }

            if(c4.isSelected())
            {
                retval+=AnsSE.AnsCheck(retque,retans4);
            }
            if(retval==GetQues.GetQues())
            {
                JOptionPane.showMessageDialog(f,"Excellent","Excellent",1);
            }
            if(retval<GetQues.GetQues())
            {
                JOptionPane.showMessageDialog(f," Your Score is " + retval+".\n\tRetry","Score",1);
            }
            f.dispose();
            f.setVisible(false);
            DB_Queries queries=new DB_Queries();
            queries.close();
        }
        if(evt.getSource()==next)
        {
            f.dispose();
            f.setVisible(false);
            new FirstSE();
        }
    }

    public void Questions()
    {   
        try
        {
            if(i==GetQues.GetQues())
            {
                --i;
            }
            que=new JLabel((++i)+ ". "+QuesSE.Ques(i));
            retque=QuesSE.Ques(i);
            que.setBounds(15,10,1100,20);
            que.setFont(font2);

            c1=new JRadioButton();
            retans1=QuesSE.Ans(i);
            o1=new JLabel("      " + retans1);
            o1.setFont(font1);
            o1.setBounds(20,50,1100,20);
            c1.setBounds(15,52,20,20);

            c2=new JRadioButton();
            retans2=QuesSE.Ans(i);
            o2=new JLabel("      " + retans2);
            o2.setFont(font1);
            o2.setBounds(20,80,1100,20);
            c2.setBounds(15,82,20,20);

            c3=new JRadioButton();  
            retans3=QuesSE.Ans(i);
            o3=new JLabel("      " + retans3);
            o3.setFont(font1);
            o3.setBounds(20,110,1100,20);
            c3.setBounds(15,112,20,20);

            c4=new JRadioButton();
            retans4=QuesSE.Ans(i);
            o4=new JLabel("      " + retans4);
            o4.setFont(font1);
            o4.setBounds(20,140,1100,20);
            c4.setBounds(15,142,20,20);
            l1.add(que);
            l1.add(c1);l1.add(c2);
            l1.add(c3);l1.add(c4);
            l1.add(o1);l1.add(o3);
            l1.add(o2);l1.add(o4);
        }
        catch(Exception e)
        {
        }
    }

    public static void main(String args[])
    {
        new FirstSE();
    }
}