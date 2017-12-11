/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airline;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Mohamed Ibrahem
 */
public class AirLine_Client {

    private static LoginGUI gui;
    private static ClientProfile CGUI = new ClientProfile();
    private static ReservationMenu RGUI = new ReservationMenu();
    private static AdminProfile AGUI = new AdminProfile();
    private static UserInterFace c;
    private static adminInterFace ai;
    private static int counter = 0;

    public static void main(String[] args) {
        try {
            // Connecting to the RMI Registry created on the server
            Registry registry = LocateRegistry.getRegistry(2100);
            c = (UserInterFace) registry.lookup("Log");
            ai = (adminInterFace) registry.lookup("admin");

            gui = new LoginGUI();

            gui.getLoginButton().addActionListener(new LogButtonListener());
            gui.getExitButton().addActionListener(new ExButtonListener());
            CGUI.getupdatePasButton().addActionListener(new UpdatePassButtonListener());
            CGUI.getEButton().addActionListener(new ExButtonListener());
            CGUI.getsoButton().addActionListener(new ExButtonListener());
            CGUI.getNButton().addActionListener(new NButtonListener());
            CGUI.getsave1Button().addActionListener(new sa1ButtonListener());
            CGUI.getrsButton().addActionListener(new resButtonListener());
            RGUI.getcButton().addActionListener(new cButtonListener());
            RGUI.getbButton().addActionListener(new bButtonListener());
            RGUI.getfButton().addActionListener(new fButtonListener());
            AGUI.getsaButton1().addActionListener(new saveButtonListener());
            AGUI.getsaButton().addActionListener(new saveButton1Listener());
            AGUI.getaddStaffButton().addActionListener(new addSButtonListener());
            AGUI.getBanButton().addActionListener(new BanUserButtonListener());

            gui.setLocationRelativeTo(null);
            gui.setVisible(true);

        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    static class LogButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String mail, password;
            try {
                counter = 0 ;
                mail = gui.getmail();
                password = gui.getpassword();
                CGUI.Notify.setEditable(false);
                
                if (password.equals("123") && mail.equals("AHMON"))
                    {
                        JOptionPane.showMessageDialog(null, "Welcome Admin", "Hello", JOptionPane.PLAIN_MESSAGE);
                        AGUI.AddStaffmember.setVisible(false);
                        AGUI.BanUser.setVisible(false);
                        AGUI.setVisible(true);
                        gui.dispose();
                    }
                else 
                {
                    c.Login(mail, password);
                    JOptionPane.showMessageDialog(null, "Welcome", "Hello", JOptionPane.INFORMATION_MESSAGE);
                    if (c.ReturnType().equals("c")) {
                    CGUI.setLocationRelativeTo(null);
                    CGUI.PasswordChange.setVisible(false);
                    CGUI.NotificationPanel.setVisible(false);
                    CGUI.setVisible(true);

                } 
                }
                
                         
                
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Something went wrong", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    static class ExButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                System.exit(0);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Something went wrong", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    static class UpdatePassButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                CGUI.PasswordChange.setVisible(true);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Something went wrong", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }


    static class soButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                gui.setVisible(true);
                CGUI.dispose();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Something went wrong", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    static class resButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                RGUI.BookFlight.setVisible(false);
                RGUI.BookFlight1.setVisible(false);
                RGUI.BookFlight2.setVisible(false);
                RGUI.setVisible(true);
                CGUI.dispose();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Something went wrong", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    static class NButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                counter++;
                if (counter % 2 == 0) {
                    CGUI.NotificationPanel.setVisible(false);
                } else {
                    CGUI.NotificationPanel.setVisible(true);
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Something went wrong", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    static class sa1ButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                String Pass = CGUI.getnpass();
                if (c.RestPassword(Pass))
                {
                CGUI.setnpass(" ");
                JOptionPane.showMessageDialog(null, "Eshta esht3'lt yacta", "information", JOptionPane.INFORMATION_MESSAGE);
                gui.setVisible(true);
                CGUI.dispose();
                }     
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Something went wrong", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    static class sa2ButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                String Pass = CGUI.getnpass();
                if (c.RestPassword(Pass))
                {
                CGUI.setnpass(" ");
                JOptionPane.showMessageDialog(null, "Eshta esht3'lt yacta", "information", JOptionPane.INFORMATION_MESSAGE);
                gui.setVisible(true);
                CGUI.dispose();
                }     
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Something went wrong", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
        
        static class cButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                
                RGUI.BookFlight.setVisible(true);
                RGUI.BookFlight1.setVisible(false);
                RGUI.BookFlight2.setVisible(false);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Something went wrong", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
        static class bButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                
                RGUI.BookFlight.setVisible(false);
                RGUI.BookFlight1.setVisible(true);
                RGUI.BookFlight2.setVisible(false);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Something went wrong", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
        static class fButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                
                RGUI.BookFlight.setVisible(false);
                RGUI.BookFlight1.setVisible(false);
                RGUI.BookFlight2.setVisible(true);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Something went wrong", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
        static class addSButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                AGUI.AddStaffmember.setVisible(true);
                AGUI.BanUser.setVisible(false);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Something went wrong", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
        static class BanUserButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                AGUI.AddStaffmember.setVisible(false);
                AGUI.BanUser.setVisible(true);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Something went wrong", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
        static class saveButton1Listener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                String mail = AGUI.getmail();
                String tele = AGUI.gettele();
                int age = Integer.parseInt(AGUI.getage());
                String address = AGUI.getaddress();
                String Name = AGUI.getname();
                String Pass = AGUI.getnpass();
                AGUI.setDa("");
                JOptionPane.showMessageDialog(null, "Done", "Info", JOptionPane.INFORMATION_MESSAGE);
                ai.Add_staffmember(address, age, mail, Name, Pass, tele);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Something went wrong", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
        static class saveButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                 String mail = AGUI.getbmail();
                 ai.Ban_User(mail);
                 AGUI.setbm("");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Something went wrong", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
 }
