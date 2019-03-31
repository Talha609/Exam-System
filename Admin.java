import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class Admin implements ActionListener
{
    DB_Queries queries;
    JFrame f;
    JPanel p;
    JButton add,del;
    Font font;
    public Admin()
    {
        queries=new DB_Queries();
        font = new Font("SansSerif", Font.BOLD, 16);
        f=new JFrame("Admin");
        f.setSize(500,400);
        p=new JPanel();
        f.add(p);
        p.setLayout(null);
        ImageIcon img= new ImageIcon(new ImageIcon("C:\\Users\\MoHd TaLHa\\Downloads\\Project\\united.png").getImage().getScaledInstance(500, 400, Image.SCALE_DEFAULT));
        JLabel l1=new JLabel();
        l1.setIcon(img);
        f.add(l1);
        add=new JButton("Add Question");
        add.setBounds(160,120,170,50);
        del=new JButton("Delete Question");
        del.setBounds(160,180,170,50);
        add.setBackground(Color.gray);
        add.setForeground(Color.white);
        del.setBackground(Color.gray);
        del.setForeground(Color.white);
        add.setFont(font);
        del.setFont(font);
        l1.add(add);l1.add(del);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(2);
        add.addActionListener(this);
        del.addActionListener(this);
    }

    public void actionPerformed(ActionEvent evt)
    {
        if(evt.getSource()==add)
        {
            AddQues a=new AddQues();
            f.dispose();
            f.setVisible(false);
        }
        if(evt.getSource()==del)
        {
            queries.del();
            queries.close();
        }
    }

    public static void main(String args[])
    {
        new Admin();
    }
}