package StudentDbManager;
import java.awt.HeadlessException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class CompleteList extends javax.swing.JFrame {

    public CompleteList() {
        initComponents();
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        fillTable();
    }
    
    public Connection MysqlConnection()  {
        Connection conn=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdbmanager",
                 "root","");
            JOptionPane.showMessageDialog(null, "Mysql Connection Established Successfully!");
            return conn;
        } catch (HeadlessException | ClassNotFoundException | SQLException e)  {
            JOptionPane.showMessageDialog(null, "Mysql Connection Failed...");
            return null;
        }
    }
    
    public ArrayList<RegisterBean> retrieveData()  {
        ArrayList<RegisterBean> al=null;
        al=new ArrayList<RegisterBean>();
        try  {
            Connection conn=MysqlConnection();
            //String q="Select name,mail,phoneno,dob,batch,course,regno,rollno,cgpa,course from Students";
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery("Select name,mail,phoneno,dob,batch,course,regno,rollno,cgpa,credits from Students");
            RegisterBean register;
            while(rs.next())  {
                register = new RegisterBean(rs.getString("name"), rs.getString("mail"), 
                        rs.getString("phoneno"),rs.getString("dob"),rs.getString("batch"),rs.getString("course"),
                        rs.getString("regno"),rs.getString("rollno"),rs.getString("cgpa"),rs.getString("credits"));
                al.add(register);
            }
        } catch(SQLException e)  {
            System.out.println("Error in retrieveData method:"+e);
        }
        return al;
    }
    
    public void fillTable()  {
        ArrayList<RegisterBean> al=retrieveData();
        DefaultTableModel model=(DefaultTableModel)jTable1.getModel();
        model.setRowCount(0);
        Object[] row=new Object[10];
        for(int i=0; i<al.size(); i++)  {
            row[0]=al.get(i).getName();
            row[1]=al.get(i).getMail();
            row[2]=al.get(i).getPhoneno();
            row[3]=al.get(i).getDob();
            row[4]=al.get(i).getBatch();
            row[5]=al.get(i).getCourse();
            row[6]=al.get(i).getRegno();
            row[7]=al.get(i).getRollno();
            row[8]=al.get(i).getCgpa();
            row[9]=al.get(i).getCredits();
            model.addRow(row);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(0, 51, 102));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 61, Short.MAX_VALUE)
        );

        jTable1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTable1.setFont(new java.awt.Font("Book Antiqua", 3, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "MailID", "Phoneno", "Date of Birth", "Batch", "Course", "Registration no", "Roll no", "CGPA", "Credits"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1235, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 472, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
