package StudentDbManager;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Register extends javax.swing.JFrame {

    public Register() {
        initComponents();
        //MysqlConnection();
    }
     
    public Connection MysqlConnection()  {
        Connection conn=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdbmanager",
                 "root","");
            JOptionPane.showMessageDialog(null, "Mysql Connection Established Successfully!");
            return conn;
        } catch (Exception e)  {
            JOptionPane.showMessageDialog(null, "Mysql Connection Failed...");
            return null;
        }
    }
    String photopath="";
    public ImageIcon resetImageSize(String photopath, byte[] photo)  {
        ImageIcon myPhoto=null;
        if(photopath!=null)  {
            myPhoto=new ImageIcon(photopath);
        }
        else  {
            myPhoto=new ImageIcon(photo);
        }
        Image img=myPhoto.getImage();
        Image img1=img.getScaledInstance(PhotoLabel.getWidth(), PhotoLabel.getHeight(),Image.SCALE_SMOOTH);
        ImageIcon pic=new ImageIcon(img1);
        return pic;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Backbtn = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        Imagebtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        NameField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        MaleBtn = new javax.swing.JRadioButton();
        FemaleBtn = new javax.swing.JRadioButton();
        MailIdField = new javax.swing.JTextField();
        PhoneField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        AdressArea = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();
        CourseCombo = new javax.swing.JComboBox<>();
        BatchCombo = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        Subj1Field = new javax.swing.JTextField();
        Subj2Field = new javax.swing.JTextField();
        Subj3Field = new javax.swing.JTextField();
        Subj4Field = new javax.swing.JTextField();
        Subj5Field = new javax.swing.JTextField();
        Subj6Field = new javax.swing.JTextField();
        Subj7Field = new javax.swing.JTextField();
        Subj8Field = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        Elective1Field = new javax.swing.JTextField();
        Elective2Field = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        RegnoField = new javax.swing.JTextField();
        RollnoField = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        Grade1Field = new javax.swing.JTextField();
        Grade3Field = new javax.swing.JTextField();
        Grade5Field = new javax.swing.JTextField();
        Grade7Field = new javax.swing.JTextField();
        Grade2Field = new javax.swing.JTextField();
        Grade4Field = new javax.swing.JTextField();
        Grade6Field = new javax.swing.JTextField();
        Grade8Field = new javax.swing.JTextField();
        ElecGrade2Field = new javax.swing.JTextField();
        ElecGrade1Field = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        CgpaField = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        CreditField = new javax.swing.JTextField();
        Savebtn = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        PhotoLabel = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 203, 160));
        jPanel1.setToolTipText("");

        jPanel2.setBackground(new java.awt.Color(16, 16, 16));

        jLabel1.setFont(new java.awt.Font("Book Antiqua", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(236, 153, 73));
        jLabel1.setText("Entry Form");

        Backbtn.setBackground(new java.awt.Color(228, 158, 70));
        Backbtn.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        Backbtn.setForeground(new java.awt.Color(25, 25, 25));
        Backbtn.setText("Back");
        Backbtn.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        Backbtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Backbtn.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                BackbtnComponentAdded(evt);
            }
        });
        Backbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackbtnActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(236, 153, 73));
        jButton1.setFont(new java.awt.Font("Book Antiqua", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(15, 15, 15));
        jButton1.setText("New Form");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(Backbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(46, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Backbtn, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(26, 26, 26))
        );

        Imagebtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/profilepic.png"))); // NOI18N
        Imagebtn.setText("jButton2");
        Imagebtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Imagebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ImagebtnActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Add image");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Name:");

        NameField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        NameField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Email: ");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Gender:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Phone no:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Address:");

        MaleBtn.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        MaleBtn.setText("Male");
        MaleBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MaleBtnActionPerformed(evt);
            }
        });

        FemaleBtn.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        FemaleBtn.setText("Female");
        FemaleBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FemaleBtnActionPerformed(evt);
            }
        });

        MailIdField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        MailIdField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        MailIdField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MailIdFieldActionPerformed(evt);
            }
        });

        PhoneField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PhoneFieldActionPerformed(evt);
            }
        });

        AdressArea.setColumns(20);
        AdressArea.setRows(5);
        jScrollPane1.setViewportView(AdressArea);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Course:");

        CourseCombo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        CourseCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CSE" }));
        CourseCombo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        BatchCombo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        BatchCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1st Year", "2nd Year", "3rd Year", "4rth Year" }));
        BatchCombo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BatchCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BatchComboActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setText("Batch:");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("Subjects:");

        Subj1Field.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Subj1Field.setText("1)");
        Subj1Field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Subj1FieldActionPerformed(evt);
            }
        });

        Subj2Field.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Subj2Field.setText("2)");
        Subj2Field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Subj2FieldActionPerformed(evt);
            }
        });

        Subj3Field.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Subj3Field.setText("3)");

        Subj4Field.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Subj4Field.setText("4)");
        Subj4Field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Subj4FieldActionPerformed(evt);
            }
        });

        Subj5Field.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Subj5Field.setText("5)");

        Subj6Field.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Subj6Field.setText("6)");
        Subj6Field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Subj6FieldActionPerformed(evt);
            }
        });

        Subj7Field.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Subj7Field.setText("7)");
        Subj7Field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Subj7FieldActionPerformed(evt);
            }
        });

        Subj8Field.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Subj8Field.setText("8)");
        Subj8Field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Subj8FieldActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setText("Electives:");

        Elective1Field.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Elective1Field.setText("1)");

        Elective2Field.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Elective2Field.setText("2)");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setText("Registration no:");

        RegnoField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        RollnoField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("Rollno:");

        Grade7Field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Grade7FieldActionPerformed(evt);
            }
        });

        Grade8Field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Grade8FieldActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel14.setText("Total CGPA:");

        CgpaField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel15.setText("Total credits:");

        CreditField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        Savebtn.setBackground(new java.awt.Color(13, 13, 13));
        Savebtn.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        Savebtn.setForeground(new java.awt.Color(204, 204, 204));
        Savebtn.setText("Save Form");
        Savebtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Savebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SavebtnActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel16.setText("Grade:");

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel17.setText("Grade:");

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel18.setText("Grade:");

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel19.setText("Grade:");

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel20.setText("Date of birth:");

        jLabel21.setText("(--/--/----)");

        jDateChooser1.setDateFormatString("dd-MM-yyyy");

        PhotoLabel.setBackground(new java.awt.Color(255, 255, 255));
        PhotoLabel.setOpaque(true);

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel22.setText("*photo should be <1mb");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(106, 106, 106)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel10)
                                .addComponent(jLabel12)
                                .addComponent(jLabel14)
                                .addComponent(jLabel13)))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(Imagebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(jLabel2)
                                .addGap(54, 54, 54)
                                .addComponent(jLabel7)))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(PhotoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jLabel8)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel22)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(CourseCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(RegnoField, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(56, 56, 56)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(BatchCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(RollnoField, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(Subj3Field, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(Subj1Field, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(Subj5Field, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(Subj7Field, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                                                    .addComponent(Grade5Field)
                                                    .addComponent(Grade1Field)
                                                    .addComponent(Grade3Field)
                                                    .addComponent(Grade7Field))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(Subj4Field, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                                                    .addComponent(Subj2Field)
                                                    .addComponent(Subj6Field)
                                                    .addComponent(Subj8Field)))
                                            .addComponent(jLabel18)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(CgpaField, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel15)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(CreditField, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(Elective1Field, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(ElecGrade1Field, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(Elective2Field, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(32, 32, 32)
                                                .addComponent(Savebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE)))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(Grade8Field, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Grade6Field, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Grade4Field, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Grade2Field, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ElecGrade2Field, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                                    .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.LEADING))))
                        .addContainerGap(26, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(MaleBtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(FemaleBtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(PhoneField, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(NameField, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(MailIdField, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel20)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel21)))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(MailIdField, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel20)
                            .addComponent(jLabel21)
                            .addComponent(jLabel3)
                            .addComponent(NameField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(FemaleBtn)
                                .addComponent(MaleBtn)
                                .addComponent(jLabel5)
                                .addComponent(jLabel6)
                                .addComponent(PhoneField, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Imagebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CourseCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(jLabel11)
                            .addComponent(BatchCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel22)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PhotoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RegnoField, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(RollnoField, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel16)
                    .addComponent(jLabel17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Subj1Field, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Subj2Field, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Grade1Field, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Grade2Field, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Grade3Field, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Grade4Field, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Subj3Field, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Subj4Field, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Grade5Field, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Subj6Field, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Grade6Field, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Subj5Field, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Grade7Field, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Grade8Field, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Subj7Field, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Subj8Field, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(3, 3, 3)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18)
                    .addComponent(jLabel19))
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Elective1Field, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Elective2Field, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ElecGrade2Field, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ElecGrade1Field, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(53, 53, 53)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(CreditField, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Savebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel15))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(CgpaField, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel14)))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void MailIdFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MailIdFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MailIdFieldActionPerformed

    private void PhoneFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PhoneFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PhoneFieldActionPerformed

    private void MaleBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MaleBtnActionPerformed
        if(MaleBtn.isSelected())  {
            FemaleBtn.setSelected(false);
        }
    }//GEN-LAST:event_MaleBtnActionPerformed

    private void Subj6FieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Subj6FieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Subj6FieldActionPerformed

    private void Subj4FieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Subj4FieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Subj4FieldActionPerformed

    private void Subj8FieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Subj8FieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Subj8FieldActionPerformed

    private void Subj1FieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Subj1FieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Subj1FieldActionPerformed

    private void Subj2FieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Subj2FieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Subj2FieldActionPerformed

    private void BatchComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BatchComboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BatchComboActionPerformed

    private void Subj7FieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Subj7FieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Subj7FieldActionPerformed

    private void Grade7FieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Grade7FieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Grade7FieldActionPerformed

    private void Grade8FieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Grade8FieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Grade8FieldActionPerformed

    private void BackbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackbtnActionPerformed
        Manager manage = new Manager();
        manage.setVisible(true);
        dispose();
    }//GEN-LAST:event_BackbtnActionPerformed

    private void BackbtnComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_BackbtnComponentAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_BackbtnComponentAdded

    private void ImagebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ImagebtnActionPerformed
        JFileChooser chooser=new JFileChooser();
        chooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        FileNameExtensionFilter fil=new FileNameExtensionFilter("*.images", "jpd", "png");
        chooser.addChoosableFileFilter(fil);
        int ans=chooser.showSaveDialog(null);
        if(ans==JFileChooser.APPROVE_OPTION)  {
            File selectedPhoto=chooser.getSelectedFile();
            String path=selectedPhoto.getAbsolutePath();
            PhotoLabel.setIcon(resetImageSize(path, null));
            this.photopath=path;
        }
    }//GEN-LAST:event_ImagebtnActionPerformed

    private void SavebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SavebtnActionPerformed
        if(NameField.getText().length()==0||MailIdField.getText().length()==0||
                PhoneField.getText().length()==0||AdressArea.getText().length()==0){
            JOptionPane.showMessageDialog(this, "Please check if name, email, address, phoneno fields are filled or not!");
        }
        else if(RegnoField.getText().length()==0||RollnoField.getText().length()==0||
                CgpaField.getText().length()==0||CreditField.getText().length()==0)  {
            JOptionPane.showMessageDialog(this, "Please fill Regno,Rollno,CGPA and Credits fields!");
        }
        else if(Subj1Field.getText().length()==0||Subj2Field.getText().length()==0||
                Subj3Field.getText().length()==0||Subj4Field.getText().length()==0||
                Subj5Field.getText().length()==0||Subj6Field.getText().length()==0||
                Subj7Field.getText().length()==0||Subj8Field.getText().length()==0||
                Elective1Field.getText().length()==0||Elective2Field.getText().length()==0)  {
            JOptionPane.showMessageDialog(this, "Please fill all Subject fields including electives!");
        }
        else if(Grade1Field.getText().length()==0||Grade1Field.getText().length()==0||
                Grade1Field.getText().length()==0||Grade1Field.getText().length()==0||
                Grade1Field.getText().length()==0||Grade1Field.getText().length()==0||
                Grade1Field.getText().length()==0||Grade1Field.getText().length()==0||
                ElecGrade1Field.getText().length()==0||ElecGrade2Field.getText().length()==0)  {
            JOptionPane.showMessageDialog(this, "Please fill all Grade fields including Electives!");
        }
        else if(NameField.getText().length()>150||MailIdField.getText().length()>150||
                PhoneField.getText().length()>11||AdressArea.getText().length()>450){
            JOptionPane.showMessageDialog(this, "Please make sure that MAXLENGTH for each field is name-150, "
                    + "email-150, address-450, phoneno-11 characters!");
        }
        else if(RegnoField.getText().length()>5||RollnoField.getText().length()>5||
                CgpaField.getText().length()>5||CreditField.getText().length()>5)  {
            JOptionPane.showMessageDialog(this, "Please make sure that MAXLENGTH for each field is"
                    + " Regno-5,Rollno-5,CGPA-5 and Credits-5 characters!");
        }
        else if(Subj1Field.getText().length()>70||Subj2Field.getText().length()>70||
                Subj3Field.getText().length()>70||Subj4Field.getText().length()>70||
                Subj5Field.getText().length()>70||Subj6Field.getText().length()>70||
                Subj7Field.getText().length()>70||Subj8Field.getText().length()>70||
                Elective1Field.getText().length()>150||Elective2Field.getText().length()>150)  {
            JOptionPane.showMessageDialog(this, "Please make sure that MAXLENGTH for each suject"
                    + " field is 70 characters and for electives is 150 characters!");
        }
        else if(Grade1Field.getText().length()>2||Grade1Field.getText().length()>2||
                Grade1Field.getText().length()>2||Grade1Field.getText().length()>2||
                Grade1Field.getText().length()>2||Grade1Field.getText().length()>2||
                Grade1Field.getText().length()>2||Grade1Field.getText().length()>2||
                ElecGrade1Field.getText().length()>2||ElecGrade2Field.getText().length()>2)  {
            JOptionPane.showMessageDialog(this, "Please make sure that MAXLENGTH for each grade field is 2 characters!");
        }
        else if(!MaleBtn.isSelected() && !FemaleBtn.isSelected())  {
            JOptionPane.showMessageDialog(this, "Please select the gender!");
        }
        else if(photopath==null)  {
            JOptionPane.showMessageDialog(this, "Please Provide Photo!");
        }
        else  {
            try  {
                Connection conn=MysqlConnection();
                PreparedStatement ps=conn.prepareStatement("insert into students"
                        + "(image,name,mail,phoneno,address,dob,gender,batch,course,regno,rollno,"
                        + "subject1,subject2,subject3,subject4,subject5,subject6,subject7,subject8,"
                        + "grade1,grade2,grade3,grade4,grade5,grade6,grade7,grade8,elective1,elective2,"
                        + "elecgrade1,elecgrade2,cgpa,credits) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                InputStream is=new FileInputStream(new File(photopath));
                ps.setBlob(1, is);
                ps.setString(2, NameField.getText());
                ps.setString(3, MailIdField.getText());
                ps.setString(4, PhoneField.getText());
                ps.setString(5, AdressArea.getText());
                SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
                String dob1=sdf.format(jDateChooser1.getDate());
                ps.setString(6, dob1);
                String gen;
                if(MaleBtn.isSelected())  {
                    gen="Male";
                }
                else  {
                    gen="Female";
                }
                ps.setString(7, gen);
                String batch=BatchCombo.getSelectedItem().toString();
                ps.setString(8, batch);
                String course=CourseCombo.getSelectedItem().toString();
                ps.setString(9, course);
                ps.setString(10, RegnoField.getText());
                ps.setString(11, RollnoField.getText());
                ps.setString(12, Subj1Field.getText());
                ps.setString(13, Subj2Field.getText());
                ps.setString(14, Subj3Field.getText());
                ps.setString(15, Subj4Field.getText());
                ps.setString(16, Subj5Field.getText());
                ps.setString(17, Subj6Field.getText());
                ps.setString(18, Subj7Field.getText());
                ps.setString(19, Subj8Field.getText());
                ps.setString(20, Grade1Field.getText());
                ps.setString(21, Grade2Field.getText());
                ps.setString(22, Grade3Field.getText());
                ps.setString(23, Grade4Field.getText());
                ps.setString(24, Grade5Field.getText());
                ps.setString(25, Grade6Field.getText());
                ps.setString(26, Grade7Field.getText());
                ps.setString(27, Grade8Field.getText());
                ps.setString(28, Elective1Field.getText());
                ps.setString(29, Elective2Field.getText());
                ps.setString(30, ElecGrade1Field.getText());
                ps.setString(31, ElecGrade2Field.getText());
                ps.setString(32, CgpaField.getText());
                ps.setString(33, CreditField.getText());
                int res=ps.executeUpdate();
                if(res>=1)  {
                    JOptionPane.showMessageDialog(null, res+"Number of Student inserted into database...");
                }
                else  {
                    JOptionPane.showMessageDialog(null, "Student insertion failed!");
                }
            } catch (SQLException | FileNotFoundException ex) {
                Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception e)  {
                JOptionPane.showMessageDialog(null, e);
            } 
        }
    }//GEN-LAST:event_SavebtnActionPerformed
    
    private void FemaleBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FemaleBtnActionPerformed
        if(FemaleBtn.isSelected())  {
            MaleBtn.setSelected(false);
        }
    }//GEN-LAST:event_FemaleBtnActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Register reg=new Register();
        reg.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea AdressArea;
    private javax.swing.JButton Backbtn;
    private javax.swing.JComboBox<String> BatchCombo;
    private javax.swing.JTextField CgpaField;
    private javax.swing.JComboBox<String> CourseCombo;
    private javax.swing.JTextField CreditField;
    private javax.swing.JTextField ElecGrade1Field;
    private javax.swing.JTextField ElecGrade2Field;
    private javax.swing.JTextField Elective1Field;
    private javax.swing.JTextField Elective2Field;
    private javax.swing.JRadioButton FemaleBtn;
    private javax.swing.JTextField Grade1Field;
    private javax.swing.JTextField Grade2Field;
    private javax.swing.JTextField Grade3Field;
    private javax.swing.JTextField Grade4Field;
    private javax.swing.JTextField Grade5Field;
    private javax.swing.JTextField Grade6Field;
    private javax.swing.JTextField Grade7Field;
    private javax.swing.JTextField Grade8Field;
    private javax.swing.JButton Imagebtn;
    private javax.swing.JTextField MailIdField;
    private javax.swing.JRadioButton MaleBtn;
    private javax.swing.JTextField NameField;
    private javax.swing.JTextField PhoneField;
    private javax.swing.JLabel PhotoLabel;
    private javax.swing.JTextField RegnoField;
    private javax.swing.JTextField RollnoField;
    private javax.swing.JButton Savebtn;
    private javax.swing.JTextField Subj1Field;
    private javax.swing.JTextField Subj2Field;
    private javax.swing.JTextField Subj3Field;
    private javax.swing.JTextField Subj4Field;
    private javax.swing.JTextField Subj5Field;
    private javax.swing.JTextField Subj6Field;
    private javax.swing.JTextField Subj7Field;
    private javax.swing.JTextField Subj8Field;
    private javax.swing.JButton jButton1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
