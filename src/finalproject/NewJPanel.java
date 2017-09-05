/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author mariamanea
 *
 *
 */
package finalproject;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class NewJPanel extends javax.swing.JFrame {

    public NewJPanel() {
        initComponents();
        Populate();
    }

    public Connection getConnection() {
        Connection con;
        try {
            /**
             *  Local DB has user/pass = root/root
             */
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/agenda", "root", "root");
            return con;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<Customer> getPhoneBook() {
        ArrayList<Customer> PhoneBook = new ArrayList<Customer>();
        Connection connection = getConnection();

        String query = "select * from phone_agenda;";
        Statement st;
        ResultSet rs;

        try {
            st = connection.createStatement();
            rs = st.executeQuery(query);
            Customer customer;

            while (rs.next()) {
                customer = new Customer(rs.getInt("ID"), rs.getString("First_Name"), rs.getString("Last_name"), rs.getString("CNP"), rs.getString("Phone_number"), rs.getString("MObile_number"));
                PhoneBook.add(customer);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return PhoneBook;
    }

    public ArrayList<Customer> getPhoneBookSearch(String querySearch) {
        ArrayList<Customer> PhoneBook = new ArrayList<Customer>();
        Connection connection = getConnection();

        Statement st;
        ResultSet rs;

        try {
            st = connection.createStatement();
            rs = st.executeQuery(querySearch);
            Customer customer;

            while (rs.next()) {
                customer = new Customer(rs.getInt("ID"), rs.getString("First_Name "), rs.getString("Last_Name"), rs.getString("CNP"), rs.getString("Phone_number"), rs.getString("Mobile_number"));
                PhoneBook.add(customer);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return PhoneBook;
    }

    public void Populate() {
        List<Customer> customerList = getPhoneBook();

        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

        for (Customer customer : customerList) {
            Object[] row = new Object[6];
            row[0] = customer.getID();
            row[1] = customer.getFirstName();
            row[2] = customer.getLastName();
            row[3] = customer.getCNP();
            row[4] = customer.getPhoneNumber();
            row[5] = customer.getMobileNumber();
            model.addRow(row);
        }

    }

    public void PopulateSearch(String querySearch) {
        List<Customer> customerList = getPhoneBookSearch(querySearch);

        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

        for (Customer customer : customerList) {
            Object[] row = new Object[6];
            row[0] = customer.getID();
            row[1] = customer.getFirstName();
            row[2] = customer.getLastName();
            row[3] = customer.getCNP();
            row[4] = customer.getPhoneNumber();
            row[5] = customer.getMobileNumber();
            model.addRow(row);
        }

    }

    public void executeSQLQuery(String query, String message) {
        Connection con = getConnection();
        Statement st;
        try {
            st = con.createStatement();
            if ((st.executeUpdate(query)) == 1) {
                DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                model.setRowCount(0);
                Populate();
                JOptionPane.showMessageDialog(null, message + " ");

            } else {
                JOptionPane.showMessageDialog(null, message + " ");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void executeSQLQuerySearch(String querySearch, String message) {
        Connection con = getConnection();
        Statement st;

        try {
            st = con.createStatement();
            if ((st.executeQuery(querySearch)) != null) {
                DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                model.setRowCount(0);
                PopulateSearch(querySearch);
                JOptionPane.showMessageDialog(null, message + " ");

            } else {
                DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                model.setRowCount(0);
                PopulateSearch(querySearch);
                JOptionPane.showMessageDialog(null, message + "  No item was found according to search criteria");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldFirstName = new javax.swing.JTextField();
        jTextFieldLastName = new javax.swing.JTextField();
        jTextFieldCNP = new javax.swing.JTextField();
        jTextFieldPhoneNumber = new javax.swing.JTextField();
        jTextFieldMobileNumber = new javax.swing.JTextField();
        bAdd = new javax.swing.JButton();
        bDelete = new javax.swing.JButton();
        bEdit = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        bExit = new javax.swing.JButton();
        jClear = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldID = new javax.swing.JTextField();
        jSearch = new javax.swing.JButton();
        jComboBoxSearch = new javax.swing.JComboBox();
        jTextFieldSearch = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("AGENDA TELEFONICA");
        setMinimumSize(new java.awt.Dimension(1150, 600));

        jLabel1.setText("First Name");

        jLabel2.setText("Last Name");

        jLabel3.setText("CNP");

        jLabel4.setText("Phone Number");

        jLabel5.setText("Mobile Number");

        jTextFieldFirstName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldFirstNameActionPerformed(evt);
            }
        });

        jTextFieldLastName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldLastNameActionPerformed(evt);
            }
        });

        jTextFieldCNP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCNPActionPerformed(evt);
            }
        });

        jTextFieldMobileNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldMobileNumberActionPerformed(evt);
            }
        });

        bAdd.setText("Add");
        bAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAddActionPerformed(evt);
            }
        });

        bDelete.setText("Delete");
        bDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bDeleteActionPerformed(evt);
            }
        });

        bEdit.setText("Edit");
        bEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bEditActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "First Name", "Last Name", "CNP", "Phone Number", "Mobile Number"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        bExit.setText("Exit");
        bExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bExitActionPerformed(evt);
            }
        });

        jClear.setText("Clear");
        jClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jClearActionPerformed(evt);
            }
        });

        jLabel6.setText("ID");

        jTextFieldID.setEditable(false);
        jTextFieldID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldIDActionPerformed(evt);
            }
        });

        jSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/finalproject/resurse/Zoom-icon (4).png"))); // NOI18N
        jSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSearchActionPerformed(evt);
            }
        });

        jComboBoxSearch.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Nume", "Prenume", "CNP", "TelefonFix", "TelefonMobil" }));
        jComboBoxSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxSearchActionPerformed(evt);
            }
        });

        jTextFieldSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jClear, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldFirstName, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                            .addComponent(jTextFieldLastName, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                            .addComponent(jTextFieldCNP, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                            .addComponent(jTextFieldPhoneNumber, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                            .addComponent(jTextFieldMobileNumber, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                            .addComponent(jTextFieldID)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(bAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBoxSearch, 0, 134, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(bDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(bEdit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jTextFieldSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bExit, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 144, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(144, 144, 144))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(bExit)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextFieldID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldCNP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextFieldPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextFieldMobileNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addComponent(jClear)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jComboBoxSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextFieldSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldFirstNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldFirstNameActionPerformed
        String FirstName = jTextFieldFirstName.getText();
    }//GEN-LAST:event_jTextFieldFirstNameActionPerformed

    private void jTextFieldLastNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldLastNameActionPerformed
        String LastName = jTextFieldLastName.getText();
    }//GEN-LAST:event_jTextFieldLastNameActionPerformed

    private void jTextFieldCNPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCNPActionPerformed
        String CNP = jTextFieldCNP.getText();
    }//GEN-LAST:event_jTextFieldCNPActionPerformed

    private void jTextFieldTelFixActionPerformed(java.awt.event.ActionEvent evt) {
        String PhoneNumber = jTextFieldPhoneNumber.getText();
    }


    private void bDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bDeleteActionPerformed
        String query = "DELETE FROM phone_agenda WHERE First_Name='" + jTextFieldFirstName.getText() + "';";
        executeSQLQuery(query, "Deletion was successfully done");
        jTextFieldFirstName.setText(null);
        jTextFieldLastName.setText(null);
        jTextFieldCNP.setText(null);
        jTextFieldPhoneNumber.setText(null);
        jTextFieldMobileNumber.setText(null);
        jTextFieldID.setText(null);
    }//GEN-LAST:event_bDeleteActionPerformed

    private void bEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bEditActionPerformed
        String query = "UPDATE phone_agenda SET Nume='" + jTextFieldFirstName.getText() + "',Last_Name='" + jTextFieldLastName.getText() + "',CNP= '" + jTextFieldCNP.getText() + "',FhoneNumber= '" + jTextFieldPhoneNumber.getText() + "' ,MobileNumber= '" + jTextFieldMobileNumber.getText() + "' WHERE ID='" + jTextFieldID.getText() + "';";
        executeSQLQuery(query, "The change was successfully done");

    }//GEN-LAST:event_bEditActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int i = jTable1.getSelectedRow();
        TableModel model = jTable1.getModel();
        jTextFieldID.setText(model.getValueAt(i, 0).toString());
        jTextFieldFirstName.setText(model.getValueAt(i, 1).toString());
        jTextFieldLastName.setText(model.getValueAt(i, 2).toString());
        jTextFieldCNP.setText(model.getValueAt(i, 3).toString());
        jTextFieldPhoneNumber.setText(model.getValueAt(i, 4).toString());
        jTextFieldMobileNumber.setText(model.getValueAt(i, 5).toString());
    }//GEN-LAST:event_jTable1MouseClicked

    private void bAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAddActionPerformed
        String query = "INSERT INTO phone_agenda (First_Name,Last_name,CNP,PhoneNumber,MobileNumber) VALUES ('" + jTextFieldFirstName.getText() + "', '" + jTextFieldLastName.getText() + "', '" + jTextFieldCNP.getText() + "', '" + jTextFieldPhoneNumber.getText() + "','" + jTextFieldMobileNumber.getText() + "')";

        executeSQLQuery(query, "The insertion was made successfully");


    }//GEN-LAST:event_bAddActionPerformed

    private void jTextFieldMobileNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldMobileNumberActionPerformed
        String tel_mobil = jTextFieldMobileNumber.getText();
    }//GEN-LAST:event_jTextFieldMobileNumberActionPerformed

    private void jClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jClearActionPerformed
        jTextFieldFirstName.setText(null);
        jTextFieldLastName.setText(null);
        jTextFieldCNP.setText(null);
        jTextFieldPhoneNumber.setText(null);
        jTextFieldMobileNumber.setText(null);
        jTextFieldID.setText(null);
        jTextFieldSearch.setText(null);
    }//GEN-LAST:event_jClearActionPerformed

    private void bExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_bExitActionPerformed

    private void jTextFieldIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldIDActionPerformed
        String id = jTextFieldID.getText();
    }//GEN-LAST:event_jTextFieldIDActionPerformed

    private void jComboBoxSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxSearchActionPerformed
        String searchColumn = jComboBoxSearch.getSelectedItem().toString();
    }//GEN-LAST:event_jComboBoxSearchActionPerformed

    private void jTextFieldSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldSearchActionPerformed
        String searchCriteria = jTextFieldSearch.getText(); 
    }//GEN-LAST:event_jTextFieldSearchActionPerformed

    private void jSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSearchActionPerformed

        String querySearching = "select * from phone_agenda where " + jComboBoxSearch.getSelectedItem() + " Like '%" + jTextFieldSearch.getText() + "%';";
        executeSQLQuerySearch(querySearching, "The search was successful ");
    }//GEN-LAST:event_jSearchActionPerformed

    public static void main(String args[]) {
        JFrame.setDefaultLookAndFeelDecorated(true);
        try {
            Driver myDriver = new com.mysql.jdbc.Driver();
            DriverManager.registerDriver(myDriver);
        } catch (SQLException ex) {
            Logger.getLogger(NewJPanel.class.getName()).log(Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewJPanel().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAdd;
    private javax.swing.JButton bDelete;
    private javax.swing.JButton bEdit;
    private javax.swing.JButton bExit;
    private javax.swing.JButton jClear;
    private javax.swing.JComboBox jComboBoxSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jSearch;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextFieldCNP;
    private javax.swing.JTextField jTextFieldFirstName;
    private javax.swing.JTextField jTextFieldID;
    private javax.swing.JTextField jTextFieldLastName;
    private javax.swing.JTextField jTextFieldMobileNumber;
    private javax.swing.JTextField jTextFieldPhoneNumber;
    private javax.swing.JTextField jTextFieldSearch;
    // End of variables declaration//GEN-END:variables

}
