package StudentDbManager;

import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class SearchInfo extends javax.swing.JFrame {
    static String srch;
    public SearchInfo(String srch) {
        initComponents();
        this.srch=srch;
        showItem();
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
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
    
    public Connection MysqlConnection()  {
        Connection conn=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdbmanager",
                 "root","");
            //JOptionPane.showMessageDialog(null, "Mysql Connection Established Successfully!");
            return conn;
        } catch (Exception e)  {
            JOptionPane.showMessageDialog(null, "Mysql Connection Failed...");
            return null;
        }
    }
    
    public void showItem()  {
        try {  
            String str = srch;
            Connection con = MysqlConnection();  
            PreparedStatement st = con.prepareStatement("select * from students where name=?");  
            st.setString(1, str);  
            ResultSet rs = st.executeQuery();  
            if (rs.next()) { 
                PhotoLabel.setIcon(resetImageSize(null, rs.getBytes(1)));  
                NameField.setText(rs.getString(2));  
                MailIdField.setText(rs.getString(3));  
                PhoneField.setText(rs.getString(4));
                AddressArea.setText(rs.getString(5));
                GenderField.setText(rs.getString(7));
                DOBField.setText(rs.getString(6));
                BatchField.setText(rs.getString(8));
                CourseField .setText(rs.getString(9));
                RollnoField.setText(rs.getString(11));
                RegnoField.setText(rs.getString(10));
                Subject1Field.setText(rs.getString(12));
                Subject2Field.setText(rs.getString(13));
                Subject3Field.setText(rs.getString(14));
                Subject4Field.setText(rs.getString(15));
                Subject5Field.setText(rs.getString(16));
                Subject6Field.setText(rs.getString(17));
                Subject7Field.setText(rs.getString(18));
                Subject8Field.setText(rs.getString(19));
                Elective1Field.setText(rs.getString(28));
                Elective2Field.setText(rs.getString(29));
                Grade1Field.setText(rs.getString(20));
                Grade2Field.setText(rs.getString(21));
                Grade3Field.setText(rs.getString(22));
                Grade4Field.setText(rs.getString(23));
                Grade5Field.setText(rs.getString(24));
                Grade6Field.setText(rs.getString(25));
                Grade7Field.setText(rs.getString(26));
                Grade8Field.setText(rs.getString(27));
                ElecGrade1Field.setText(rs.getString(30));
                ElecGrade2Field.setText(rs.getString(31));
                CgpaField.setText(rs.getString(32));
                CreditsField.setText(rs.getString(33));
            } else {  
                JOptionPane.showMessageDialog(null, "Name not Found!");
                
            }   
        } catch (Exception ex) {  
            System.out.println(ex);
            dispose();
        };
    }
    
    public void updateItem(String name)  {
        try  {  
                Connection conn=MysqlConnection();
                PreparedStatement ps=conn.prepareStatement("update students set image=?,mail=?,"
                        + "phoneno=?,address=?,dob=?,gender=?,batch=?,course=?,regno=?,rollno=?,subject1=?,"
                        + "subject2=?,subject3=?,subject4=?,subject5=?,subject6=?,subject7=?,subject8=?,grade1=?,"
                        + "grade2=?,grade3=?,grade4=?,grade5=?,grade6=?,grade7=?,grade8=?,elective1=?,elective2=?,"
                        + "elecgrade1=?,elecgrade2=?,cgpa=?,credits=? where name=?");
                InputStream is;
                is=new FileInputStream(new File(photopath));
                ps.setBlob(1, is);            
                ps.setString(2, MailIdField.getText());
                ps.setString(3, PhoneField.getText());
                ps.setString(4, AddressArea.getText());
                ps.setString(5, DOBField.getText());
                ps.setString(6, GenderField.getText());
                ps.setString(7, BatchField.getText());
                ps.setString(8, CourseField.getText());
                ps.setString(9, RegnoField.getText());
                ps.setString(10, RollnoField.getText());
                ps.setString(11, Subject1Field.getText());
                ps.setString(12, Subject2Field.getText());
                ps.setString(13, Subject3Field.getText());
                ps.setString(14, Subject4Field.getText());
                ps.setString(15, Subject5Field.getText());
                ps.setString(16, Subject6Field.getText());
                ps.setString(17, Subject7Field.getText());
                ps.setString(18, Subject8Field.getText());
                ps.setString(19, Grade1Field.getText());
                ps.setString(20, Grade2Field.getText());
                ps.setString(21, Grade3Field.getText());
                ps.setString(22, Grade4Field.getText());
                ps.setString(23, Grade5Field.getText());
                ps.setString(24, Grade6Field.getText());
                ps.setString(25, Grade7Field.getText());
                ps.setString(26, Grade8Field.getText());
                ps.setString(27, Elective1Field.getText());
                ps.setString(28, Elective2Field.getText());
                ps.setString(29, ElecGrade1Field.getText());
                ps.setString(30, ElecGrade2Field.getText());
                ps.setString(31, CgpaField.getText());
                ps.setString(32, CreditsField.getText());
                ps.setString(33, NameField.getText());
                int res=ps.executeUpdate();
                if(res>=1)  {
                    JOptionPane.showMessageDialog(null, res+"th number Student updated into database...");
                }
                else  {
                    JOptionPane.showMessageDialog(null, "Student updation failed!");
                }
            } catch (SQLException | FileNotFoundException ex) {
                Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "FileNotFoundException::Make sure new image is added!");
            } catch (Exception e)  {
                JOptionPane.showMessageDialog(null, e);
            } 
    }
    
     public void deleteItem(String name)  {
        try  {  
                //String str=srch;
                Connection conn=MysqlConnection();
                PreparedStatement ps=conn.prepareStatement("delete from students where name=?");
                ps.setString(1, name);
                int res=ps.executeUpdate();
                if(res>=1)  {
                    JOptionPane.showMessageDialog(null, res+"th number Student deleted from database...");
                }
                else  {
                    JOptionPane.showMessageDialog(null, "Student deletion failed!");
                }
            } catch (Exception e)  {
                JOptionPane.showMessageDialog(null, e);
            }  
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jYearChooser1 = new com.toedter.calendar.JYearChooser();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Updatebtn = new javax.swing.JButton();
        Deletebtn = new javax.swing.JButton();
        PhotoLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        JLabel3 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        AddressArea = new javax.swing.JTextArea();
        NameField = new javax.swing.JTextField();
        MailIdField = new javax.swing.JTextField();
        PhoneField = new javax.swing.JTextField();
        GenderField = new javax.swing.JTextField();
        DOBField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        BatchField = new javax.swing.JTextField();
        CourseField = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        RollnoField = new javax.swing.JTextField();
        RegnoField = new javax.swing.JTextField();
        Subject1Field = new javax.swing.JTextField();
        Subject2Field = new javax.swing.JTextField();
        Subject3Field = new javax.swing.JTextField();
        Subject4Field = new javax.swing.JTextField();
        Subject5Field = new javax.swing.JTextField();
        Subject6Field = new javax.swing.JTextField();
        Subject7Field = new javax.swing.JTextField();
        Subject8Field = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        Elective1Field = new javax.swing.JTextField();
        Elective2Field = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        Grade1Field = new javax.swing.JTextField();
        Grade2Field = new javax.swing.JTextField();
        Grade3Field = new javax.swing.JTextField();
        Grade4Field = new javax.swing.JTextField();
        Grade5Field = new javax.swing.JTextField();
        Grade6Field = new javax.swing.JTextField();
        Grade7Field = new javax.swing.JTextField();
        Grade8Field = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        ElecGrade1Field = new javax.swing.JTextField();
        ElecGrade2Field = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        CgpaField = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        CreditsField = new javax.swing.JTextField();
        Savebtn = new javax.swing.JButton();
        AddPhotobtn = new javax.swing.JButton();

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));

        jPanel2.setBackground(new java.awt.Color(20, 20, 20));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Book Antiqua", 3, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 96, 62));
        jLabel1.setText("Search Info");

        Updatebtn.setBackground(new java.awt.Color(20, 20, 20));
        Updatebtn.setFont(new java.awt.Font("Book Antiqua", 3, 18)); // NOI18N
        Updatebtn.setForeground(new java.awt.Color(255, 96, 62));
        Updatebtn.setText("Update");
        Updatebtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Updatebtn.setContentAreaFilled(false);
        Updatebtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Updatebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdatebtnActionPerformed(evt);
            }
        });

        Deletebtn.setFont(new java.awt.Font("Book Antiqua", 3, 18)); // NOI18N
        Deletebtn.setForeground(new java.awt.Color(255, 96, 62));
        Deletebtn.setText("Delete");
        Deletebtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Deletebtn.setContentAreaFilled(false);
        Deletebtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Deletebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeletebtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Updatebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(Deletebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Deletebtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Updatebtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        PhotoLabel.setBackground(new java.awt.Color(255, 255, 255));
        PhotoLabel.setOpaque(true);

        jLabel2.setFont(new java.awt.Font("Book Antiqua", 1, 15)); // NOI18N
        jLabel2.setText("Name:");

        JLabel3.setFont(new java.awt.Font("Book Antiqua", 1, 14)); // NOI18N
        JLabel3.setText("Mail ID:");

        jLabel3.setFont(new java.awt.Font("Book Antiqua", 1, 14)); // NOI18N
        jLabel3.setText("Phone no:");

        jLabel4.setFont(new java.awt.Font("Book Antiqua", 1, 14)); // NOI18N
        jLabel4.setText("Gender:");

        jLabel5.setFont(new java.awt.Font("Book Antiqua", 1, 14)); // NOI18N
        jLabel5.setText("DOB:");

        jLabel6.setFont(new java.awt.Font("Book Antiqua", 1, 14)); // NOI18N
        jLabel6.setText("Address:");

        AddressArea.setEditable(false);
        AddressArea.setBackground(new java.awt.Color(255, 153, 153));
        AddressArea.setColumns(20);
        AddressArea.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        AddressArea.setRows(5);
        AddressArea.setOpaque(false);
        jScrollPane1.setViewportView(AddressArea);

        NameField.setEditable(false);
        NameField.setBackground(new java.awt.Color(255, 204, 204));
        NameField.setFont(new java.awt.Font("Book Antiqua", 3, 18)); // NOI18N
        NameField.setOpaque(false);
        NameField.setRequestFocusEnabled(false);

        MailIdField.setEditable(false);
        MailIdField.setBackground(new java.awt.Color(255, 204, 204));
        MailIdField.setFont(new java.awt.Font("Book Antiqua", 3, 18)); // NOI18N
        MailIdField.setOpaque(false);

        PhoneField.setEditable(false);
        PhoneField.setBackground(new java.awt.Color(255, 204, 204));
        PhoneField.setFont(new java.awt.Font("Book Antiqua", 3, 18)); // NOI18N
        PhoneField.setOpaque(false);

        GenderField.setEditable(false);
        GenderField.setBackground(new java.awt.Color(255, 204, 204));
        GenderField.setFont(new java.awt.Font("Book Antiqua", 3, 18)); // NOI18N
        GenderField.setOpaque(false);

        DOBField.setEditable(false);
        DOBField.setBackground(new java.awt.Color(255, 204, 204));
        DOBField.setFont(new java.awt.Font("Book Antiqua", 3, 18)); // NOI18N
        DOBField.setOpaque(false);

        jLabel7.setFont(new java.awt.Font("Book Antiqua", 1, 14)); // NOI18N
        jLabel7.setText("Course:");

        jLabel8.setFont(new java.awt.Font("Book Antiqua", 1, 14)); // NOI18N
        jLabel8.setText("Batch:");

        BatchField.setEditable(false);
        BatchField.setBackground(new java.awt.Color(255, 204, 204));
        BatchField.setFont(new java.awt.Font("Book Antiqua", 3, 18)); // NOI18N
        BatchField.setOpaque(false);

        CourseField.setEditable(false);
        CourseField.setBackground(new java.awt.Color(255, 204, 204));
        CourseField.setFont(new java.awt.Font("Book Antiqua", 3, 18)); // NOI18N
        CourseField.setOpaque(false);

        jLabel9.setFont(new java.awt.Font("Book Antiqua", 3, 18)); // NOI18N
        jLabel9.setText("Registered Subjects:");

        jLabel10.setFont(new java.awt.Font("Book Antiqua", 1, 14)); // NOI18N
        jLabel10.setText("Rollno:");

        jLabel11.setFont(new java.awt.Font("Book Antiqua", 1, 14)); // NOI18N
        jLabel11.setText("Regno:");

        RollnoField.setEditable(false);
        RollnoField.setBackground(new java.awt.Color(255, 204, 204));
        RollnoField.setFont(new java.awt.Font("Book Antiqua", 3, 18)); // NOI18N
        RollnoField.setOpaque(false);

        RegnoField.setEditable(false);
        RegnoField.setBackground(new java.awt.Color(255, 204, 204));
        RegnoField.setFont(new java.awt.Font("Book Antiqua", 3, 18)); // NOI18N
        RegnoField.setOpaque(false);

        Subject1Field.setEditable(false);
        Subject1Field.setBackground(new java.awt.Color(255, 204, 204));
        Subject1Field.setFont(new java.awt.Font("Book Antiqua", 3, 18)); // NOI18N
        Subject1Field.setOpaque(false);

        Subject2Field.setEditable(false);
        Subject2Field.setBackground(new java.awt.Color(255, 204, 204));
        Subject2Field.setFont(new java.awt.Font("Book Antiqua", 3, 18)); // NOI18N
        Subject2Field.setOpaque(false);

        Subject3Field.setEditable(false);
        Subject3Field.setBackground(new java.awt.Color(255, 204, 204));
        Subject3Field.setFont(new java.awt.Font("Book Antiqua", 3, 18)); // NOI18N
        Subject3Field.setOpaque(false);

        Subject4Field.setEditable(false);
        Subject4Field.setBackground(new java.awt.Color(255, 204, 204));
        Subject4Field.setFont(new java.awt.Font("Book Antiqua", 3, 18)); // NOI18N
        Subject4Field.setOpaque(false);

        Subject5Field.setEditable(false);
        Subject5Field.setBackground(new java.awt.Color(255, 204, 204));
        Subject5Field.setFont(new java.awt.Font("Book Antiqua", 3, 18)); // NOI18N
        Subject5Field.setOpaque(false);

        Subject6Field.setEditable(false);
        Subject6Field.setBackground(new java.awt.Color(255, 204, 204));
        Subject6Field.setFont(new java.awt.Font("Book Antiqua", 3, 18)); // NOI18N
        Subject6Field.setOpaque(false);

        Subject7Field.setEditable(false);
        Subject7Field.setBackground(new java.awt.Color(255, 204, 204));
        Subject7Field.setFont(new java.awt.Font("Book Antiqua", 3, 18)); // NOI18N
        Subject7Field.setOpaque(false);

        Subject8Field.setEditable(false);
        Subject8Field.setBackground(new java.awt.Color(255, 204, 204));
        Subject8Field.setFont(new java.awt.Font("Book Antiqua", 3, 18)); // NOI18N
        Subject8Field.setOpaque(false);
        Subject8Field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Subject8FieldActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Book Antiqua", 3, 18)); // NOI18N
        jLabel12.setText("Elective Subjects:");

        Elective1Field.setEditable(false);
        Elective1Field.setBackground(new java.awt.Color(255, 204, 204));
        Elective1Field.setFont(new java.awt.Font("Book Antiqua", 3, 18)); // NOI18N
        Elective1Field.setOpaque(false);

        Elective2Field.setEditable(false);
        Elective2Field.setBackground(new java.awt.Color(255, 204, 204));
        Elective2Field.setFont(new java.awt.Font("Book Antiqua", 3, 18)); // NOI18N
        Elective2Field.setOpaque(false);

        jLabel13.setFont(new java.awt.Font("Book Antiqua", 3, 18)); // NOI18N
        jLabel13.setText("Grade:");

        Grade1Field.setEditable(false);
        Grade1Field.setBackground(new java.awt.Color(255, 204, 204));
        Grade1Field.setFont(new java.awt.Font("Arial", 3, 18)); // NOI18N
        Grade1Field.setOpaque(false);

        Grade2Field.setEditable(false);
        Grade2Field.setBackground(new java.awt.Color(255, 204, 204));
        Grade2Field.setFont(new java.awt.Font("Arial", 3, 18)); // NOI18N
        Grade2Field.setOpaque(false);

        Grade3Field.setEditable(false);
        Grade3Field.setBackground(new java.awt.Color(255, 204, 204));
        Grade3Field.setFont(new java.awt.Font("Arial", 3, 18)); // NOI18N
        Grade3Field.setOpaque(false);
        Grade3Field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Grade3FieldActionPerformed(evt);
            }
        });

        Grade4Field.setEditable(false);
        Grade4Field.setBackground(new java.awt.Color(255, 204, 204));
        Grade4Field.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        Grade4Field.setOpaque(false);

        Grade5Field.setEditable(false);
        Grade5Field.setBackground(new java.awt.Color(255, 204, 204));
        Grade5Field.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        Grade5Field.setOpaque(false);
        Grade5Field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Grade5FieldActionPerformed(evt);
            }
        });

        Grade6Field.setEditable(false);
        Grade6Field.setBackground(new java.awt.Color(255, 204, 204));
        Grade6Field.setFont(new java.awt.Font("Arial", 3, 18)); // NOI18N
        Grade6Field.setOpaque(false);

        Grade7Field.setEditable(false);
        Grade7Field.setBackground(new java.awt.Color(255, 204, 204));
        Grade7Field.setFont(new java.awt.Font("Arial", 3, 18)); // NOI18N
        Grade7Field.setOpaque(false);

        Grade8Field.setEditable(false);
        Grade8Field.setBackground(new java.awt.Color(255, 204, 204));
        Grade8Field.setFont(new java.awt.Font("Arial", 3, 18)); // NOI18N
        Grade8Field.setOpaque(false);

        jLabel14.setFont(new java.awt.Font("Book Antiqua", 3, 18)); // NOI18N
        jLabel14.setText("Grade:");

        ElecGrade1Field.setEditable(false);
        ElecGrade1Field.setBackground(new java.awt.Color(255, 204, 204));
        ElecGrade1Field.setFont(new java.awt.Font("Arial", 3, 18)); // NOI18N
        ElecGrade1Field.setOpaque(false);

        ElecGrade2Field.setEditable(false);
        ElecGrade2Field.setBackground(new java.awt.Color(255, 204, 204));
        ElecGrade2Field.setFont(new java.awt.Font("Arial", 3, 18)); // NOI18N
        ElecGrade2Field.setOpaque(false);
        ElecGrade2Field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ElecGrade2FieldActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Book Antiqua", 3, 18)); // NOI18N
        jLabel15.setText("CGPA:");

        CgpaField.setEditable(false);
        CgpaField.setBackground(new java.awt.Color(255, 204, 204));
        CgpaField.setFont(new java.awt.Font("Baskerville Old Face", 3, 24)); // NOI18N
        CgpaField.setOpaque(false);

        jLabel16.setFont(new java.awt.Font("Book Antiqua", 3, 18)); // NOI18N
        jLabel16.setText("Credits:");

        CreditsField.setEditable(false);
        CreditsField.setBackground(new java.awt.Color(255, 204, 204));
        CreditsField.setFont(new java.awt.Font("Baskerville Old Face", 3, 24)); // NOI18N
        CreditsField.setOpaque(false);
        CreditsField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreditsFieldActionPerformed(evt);
            }
        });

        Savebtn.setBackground(new java.awt.Color(20, 20, 20));
        Savebtn.setFont(new java.awt.Font("Book Antiqua", 3, 18)); // NOI18N
        Savebtn.setForeground(new java.awt.Color(255, 204, 204));
        Savebtn.setText("Save");
        Savebtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Savebtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Savebtn.setVisible(false);
        Savebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SavebtnActionPerformed(evt);
            }
        });

        AddPhotobtn.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        AddPhotobtn.setText("Add Photo");
        AddPhotobtn.setVisible(false);
        AddPhotobtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddPhotobtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(PhotoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(PhoneField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(JLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(NameField)
                                            .addComponent(MailIdField, javax.swing.GroupLayout.DEFAULT_SIZE, 391, Short.MAX_VALUE))))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel11))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(DOBField, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(GenderField, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(AddPhotobtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel7)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(CourseField, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
                                    .addComponent(RegnoField))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel8)
                                .addGap(18, 18, 18)
                                .addComponent(BatchField, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(112, 112, 112)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(RollnoField))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(Subject8Field, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE)
                            .addComponent(Subject6Field, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Subject5Field, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Subject4Field, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Subject3Field, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Subject2Field, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Subject1Field, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Subject7Field))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Grade3Field, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Grade4Field, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Grade5Field, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(Grade2Field, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(Elective2Field, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ElecGrade2Field, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(Grade1Field, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(Elective1Field, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ElecGrade1Field, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(Grade6Field, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel15))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(Grade7Field, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(Grade8Field, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addComponent(CgpaField, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(64, 64, 64)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(CreditsField, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(Savebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel16)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(157, 157, 157)
                        .addComponent(jLabel13)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 168, Short.MAX_VALUE)
                        .addComponent(jLabel14)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(NameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JLabel3)
                            .addComponent(MailIdField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(PhoneField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(PhotoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(GenderField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(DOBField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BatchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(CourseField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8)
                        .addComponent(AddPhotobtn)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel10)
                    .addComponent(RollnoField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(RegnoField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel13)
                    .addComponent(jLabel12)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Subject1Field, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Grade1Field)
                    .addComponent(Elective1Field, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ElecGrade1Field, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Elective2Field, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Subject2Field, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Grade2Field)
                        .addComponent(ElecGrade2Field, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Subject3Field, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Grade3Field))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Subject4Field, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Grade4Field))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Subject5Field, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Grade5Field))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Subject6Field, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Grade6Field)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Subject7Field)
                            .addComponent(Grade7Field))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Subject8Field, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Grade8Field, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(CgpaField, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(CreditsField, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(Savebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
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

    private void Subject8FieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Subject8FieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Subject8FieldActionPerformed

    private void CreditsFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreditsFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CreditsFieldActionPerformed

    private void ElecGrade2FieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ElecGrade2FieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ElecGrade2FieldActionPerformed

    private void Grade3FieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Grade3FieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Grade3FieldActionPerformed

    private void Grade5FieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Grade5FieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Grade5FieldActionPerformed

    private void UpdatebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdatebtnActionPerformed
        AddPhotobtn.setVisible(true);
        Deletebtn.setVisible(false);
        Updatebtn.setVisible(false);
        Savebtn.setVisible(true);
        AddressArea.setEditable(true);
        NameField.setEditable(true);
        MailIdField.setEditable(true);
        PhoneField.setEditable(true);
        GenderField.setEditable(true);
        DOBField.setEditable(true);
        BatchField.setEditable(true);
        CourseField.setEditable(true);
        RollnoField.setEditable(true);
        RegnoField.setEditable(true);
        Subject1Field.setEditable(true);
        Subject2Field.setEditable(true);
        Subject3Field.setEditable(true);
        Subject4Field.setEditable(true);
        Subject5Field.setEditable(true);
        Subject6Field.setEditable(true);
        Subject7Field.setEditable(true);
        Subject8Field.setEditable(true);
        Elective1Field.setEditable(true);
        Elective2Field.setEditable(true);
        Grade1Field.setEditable(true);
        Grade2Field.setEditable(true);
        Grade3Field.setEditable(true);
        Grade4Field.setEditable(true);
        Grade5Field.setEditable(true);
        Grade6Field.setEditable(true);
        Grade7Field.setEditable(true);
        Grade8Field.setEditable(true);
        ElecGrade1Field.setEditable(true);
        ElecGrade2Field.setEditable(true);
        CgpaField.setEditable(true);
        CreditsField.setEditable(true);
        //updatedText();
    }//GEN-LAST:event_UpdatebtnActionPerformed
    
    private void SavebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SavebtnActionPerformed
        String str1;
        str1=NameField.getText();
        updateItem(str1);
        dispose();
        new SearchInfo(str1).setVisible(true);
    }//GEN-LAST:event_SavebtnActionPerformed

    private void AddPhotobtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddPhotobtnActionPerformed
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
    }//GEN-LAST:event_AddPhotobtnActionPerformed

    private void DeletebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeletebtnActionPerformed
        String str2;
        str2=NameField.getText();
        deleteItem(str2);
        dispose();
    }//GEN-LAST:event_DeletebtnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddPhotobtn;
    private javax.swing.JTextArea AddressArea;
    private javax.swing.JTextField BatchField;
    private javax.swing.JTextField CgpaField;
    private javax.swing.JTextField CourseField;
    private javax.swing.JTextField CreditsField;
    private javax.swing.JTextField DOBField;
    private javax.swing.JButton Deletebtn;
    private javax.swing.JTextField ElecGrade1Field;
    private javax.swing.JTextField ElecGrade2Field;
    private javax.swing.JTextField Elective1Field;
    private javax.swing.JTextField Elective2Field;
    private javax.swing.JTextField GenderField;
    private javax.swing.JTextField Grade1Field;
    private javax.swing.JTextField Grade2Field;
    private javax.swing.JTextField Grade3Field;
    private javax.swing.JTextField Grade4Field;
    private javax.swing.JTextField Grade5Field;
    private javax.swing.JTextField Grade6Field;
    private javax.swing.JTextField Grade7Field;
    private javax.swing.JTextField Grade8Field;
    private javax.swing.JLabel JLabel3;
    private javax.swing.JTextField MailIdField;
    private javax.swing.JTextField NameField;
    private javax.swing.JTextField PhoneField;
    private javax.swing.JLabel PhotoLabel;
    private javax.swing.JTextField RegnoField;
    private javax.swing.JTextField RollnoField;
    private javax.swing.JButton Savebtn;
    private javax.swing.JTextField Subject1Field;
    private javax.swing.JTextField Subject2Field;
    private javax.swing.JTextField Subject3Field;
    private javax.swing.JTextField Subject4Field;
    private javax.swing.JTextField Subject5Field;
    private javax.swing.JTextField Subject6Field;
    private javax.swing.JTextField Subject7Field;
    private javax.swing.JTextField Subject8Field;
    private javax.swing.JButton Updatebtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private com.toedter.calendar.JYearChooser jYearChooser1;
    // End of variables declaration//GEN-END:variables
}
