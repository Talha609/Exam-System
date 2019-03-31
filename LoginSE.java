import java.util.*;
import java.io.File;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.Image;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import javax.swing.ImageIcon;
import static javax.swing.WindowConstants.*;
class LoginSE implements ActionListener
{
    JFrame f;
    JPanel p;
    JTextField id;
    JLabel idd,pas,l;
    JLabel reg;
    JPasswordField pass;
    JButton sub,admin;
    public LoginSE()
    {
        Font font1 = new Font("SansSerif", Font.BOLD, 14);
        Font font2 = new Font("TimesNewRoman", Font.BOLD, 15);
        Font font3 = new Font("TimesNewRoman", Font.BOLD, 18);
        f=new JFrame("Exam System");
        f.setSize(600,400);
        p=new JPanel();
        p.setLayout(null);
        ImageIcon img= new ImageIcon(new ImageIcon("C:\\Users\\MoHd TaLHa\\Downloads\\Project\\united.png").getImage().getScaledInstance(600, 400, Image.SCALE_DEFAULT));
        l=new JLabel();
        l.setIcon(img);
        f.add(p);
        f.add(l);
        id=new JTextField(10);
        id.setFont(font1);
        idd=new JLabel("User ID");
        idd.setForeground(Color.black);
        pas=new JLabel("Password");
        pas.setForeground(Color.black);
        pass=new JPasswordField(10);
        pass.setEchoChar('\u25CF');
        reg=new JLabel("(New User)");
        sub=new JButton("Submit");
        admin=new JButton("Login as Admin");
        sub.setBackground(Color.gray);
        sub.setForeground(Color.white);
        admin.setBackground(Color.gray);
        admin.setForeground(Color.white);
        reg.setForeground(Color.black);
        reg.setFont(font3);
        idd.setFont(font2);
        sub.setFont(font1);
        admin.setFont(font1);
        pas.setFont(font2);

        f.setLocationRelativeTo(null);
        reg.setBounds(290,250,150,25);
        idd.setBounds(180,120,150,25);
        id.setBounds(260,120,150,25);
        pas.setBounds(180,150,150,25);
        pass.setBounds(260,150,150,25);
        sub.setBounds(260,188,150,25);
        admin.setBounds(260,220,150,25);
        l.add(reg);
        l.add(idd);
        l.add(id);
        l.add(pas);
        l.add(pass);
        l.add(sub);
        l.add(admin);
        f.setVisible(true);
        f.setDefaultCloseOperation(2);
        f.setResizable(false);
        sub.addActionListener(this);
        admin.addActionListener(this);
        sub.addKeyListener(new KeyAdapter()
            {
                public void keyPressed(KeyEvent evt)
                {
                    if(evt.getSource()==sub)
                    {
                        if(pass.getText().equals("student") && id.getText().equals("student"))
                        {
                            FirstSE first=new FirstSE();
                            f.setVisible(false);
                            f.dispose();
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(f,"User ID or Password is Incorrect","Error",2);
                        }
                    }
                }
            });
        admin.addKeyListener(new KeyAdapter()
            {
                public void keyPressed(KeyEvent evt)
                {
                    if(evt.getSource()==admin)
                    {
                        if(pass.getText().equals("talha") && id.getText().equals("talha"))
                        {
                            Admin admin=new Admin();
                            f.setVisible(false);
                            f.dispose();
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(f,"User ID or Password is Incorrect","Error",2);
                        }
                    }
                }
            });
        reg.addMouseListener(new MouseAdapter() 
            {
                public void mouseClicked(MouseEvent e) 
                {
                    JOptionPane.showMessageDialog(f,"Hii","Error",2);
                }
            });
    }

    public void actionPerformed(ActionEvent evt)
    {
        if(evt.getSource()==sub)
        {
            if(pass.getText().equals("student") && id.getText().equals("student"))
            {
                FirstSE first=new FirstSE();
                f.setVisible(false);
                f.dispose();
            }
            else
            {
                JOptionPane.showMessageDialog(f,"User ID or Password is Incorrect","Error",2);
            }
        }

        if(evt.getSource()==admin)
        {
            if(pass.getText().equals("talha") && id.getText().equals("talha"))
            {
                Admin admin=new Admin();
                f.setVisible(false);
                f.dispose();
            }
            else
            {
                JOptionPane.showMessageDialog(f,"User ID or Password is Incorrect","Error",2);
            }
        }
    }

    public static void main(String args[])
    {
        new LoginSE();
    }
}