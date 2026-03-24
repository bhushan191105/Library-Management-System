import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class LibraryManagementSystem___GUI implements ActionListener {

    JFrame frame;
    JPanel container;
    CardLayout cardLayout;
    JButton b1, b2, b3, b4;
    JButton logIn;
    JTextField adminField;
    JPasswordField passField;
    
    JTextField tf1 , tf2,tf3 ,tf4 ;
    JTextField copiesField ;
    JButton addBtn , backBookBtn ;
    
    JTextField stf1 , stf2 , stf3 , stf4 ;
    JButton search ,add ,delete , back;
    
    
    JButton issueBtn , returnBtn ,backBtn ; 
    
   
    
    public LibraryManagementSystem___GUI() {

        frame = new JFrame("Library Management System Application");
        frame.setSize(1000,700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.GRAY); // frame color
        //frame.setLocationRelativeTo(null);

        // CardLayout container
        cardLayout = new CardLayout();
        container = new JPanel(cardLayout);

        container.add(createLoginScreen(), "Login");
        container.add(dashboardPanel(), "Dashboard");
        container.add(addBookPanel(),"AddBook");
        container.add(addStudentPanel(),"AddStudent");
        container.add(issueReturnPanel(), "IssueReturn");


        frame.add(container);
        frame.setVisible(true);
    }

    

	// -------- LOGIN SCREEN (CENTERED) --------
    private JPanel createLoginScreen() {

        JPanel wrapper = new JPanel(new GridBagLayout());
        wrapper.setBackground(Color.GRAY); // gray background

        JPanel loginPanel = new JPanel(null);
        loginPanel.setPreferredSize(new Dimension(500,500));
        loginPanel.setBackground(Color.WHITE);

        JLabel label = new JLabel("ADMIN LOGIN PAGE", JLabel.CENTER);
        label.setBounds(0,30,500,40);
        label.setFont(new Font("Arial", Font.BOLD, 26));
        loginPanel.add(label);

        JLabel admin_id = new JLabel("Admin ID:");
        admin_id.setBounds(50,120,150,30);
        admin_id.setFont(new Font("Dialog", Font.PLAIN, 20));
        loginPanel.add(admin_id);

        adminField = new JTextField();
        adminField.setBounds(180,115,250,40);
        adminField.setFont(new Font("Dialog", Font.PLAIN, 18));
        loginPanel.add(adminField);

        JLabel admin_pass = new JLabel("Password:");
        admin_pass.setBounds(50,200,150,30);
        admin_pass.setFont(new Font("Dialog", Font.PLAIN, 20));
        loginPanel.add(admin_pass);

        passField = new JPasswordField();
        passField.setBounds(180,195,250,40);
        passField.setFont(new Font("Dialog", Font.PLAIN, 18));
        loginPanel.add(passField);

        logIn = new JButton("Login");
        logIn.setBounds(200,300,100,45);
        logIn.setFont(new Font("Dialog", Font.BOLD, 18));
        logIn.setBackground(Color.RED);
        logIn.setForeground(Color.WHITE);
        logIn.addActionListener(this);
        loginPanel.add(logIn);

        wrapper.add(loginPanel); // centered automatically
        return wrapper;
    }

    // -------- DASHBOARD --------
    private JPanel dashboardPanel() {

        JPanel bgPanel = new BackgroundPanel("image.jpg");
        bgPanel.setLayout(new BorderLayout());

        JLabel label = new JLabel("Welcome to Library Management System",JLabel.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 28));
        label.setForeground(Color.BLACK);
        label.setBorder(BorderFactory.createEmptyBorder(30, 0, 30, 0));
        label.setFont(new Font("Arial", Font.BOLD, 28));
        bgPanel.add(label, BorderLayout.NORTH);
        
        JPanel leftPanel = new JPanel();
        leftPanel.setOpaque(false); // IMPORTANT for background image
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        leftPanel.setBorder(BorderFactory.createEmptyBorder(150, 50, 150, 0));

        b1 = new JButton("Enroll / Delete a Student");
        b2 = new JButton("Add a Book");
        b3 = new JButton("Issue / Return a Book");

        styleButton(b1);
        styleButton(b2);
        styleButton(b3);
        
        b1.addActionListener(this);
        b2.addActionListener(this); 
        b3.addActionListener(this);
        
        
        leftPanel.add(b1);
        leftPanel.add(Box.createVerticalStrut(20));
        leftPanel.add(b2);
        leftPanel.add(Box.createVerticalStrut(20));
        leftPanel.add(b3);

        bgPanel.add(leftPanel, BorderLayout.WEST);

        // ---------- LOGOUT BUTTON (BOTTOM RIGHT) ----------
        JPanel logoutPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        logoutPanel.setOpaque(false);
        logoutPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 20));

        b4 = new JButton(" LOGOUT ");
        b4.setBackground(Color.red);
        b4.setForeground(Color.white);
        b4.setFont(new Font("Dialog", Font.BOLD, 16));
        b4.setFocusable(false);
        logoutPanel.add(b4);
        b4.setPreferredSize(new Dimension(250 , 50));
        b4.addActionListener(this);
        bgPanel.add(logoutPanel, BorderLayout.SOUTH);
        
        
        
        return bgPanel;
    }
    private void styleButton(JButton btn) {
        btn.setFont(new Font("Dialog", Font.BOLD, 16));
        btn.setFocusable(false);
        btn.setMaximumSize(new Dimension(260, 45));
    }
    
    // Add Book Panel
    private JPanel addBookPanel() {

        JPanel bookPanel = new JPanel();
        bookPanel.setLayout(null);
        bookPanel.setBackground(Color.WHITE);

        // ---------- TITLE ----------
        JLabel heading = new JLabel("Add Book To Library", JLabel.CENTER);
        heading.setFont(new Font("Arial", Font.BOLD, 30));
        heading.setBounds(0, 30, 1000, 40);
        bookPanel.add(heading);

        // ---------- LABELS ----------
        JLabel book_id = new JLabel("Book ID:");
        JLabel title = new JLabel("Title:");
        JLabel author = new JLabel("Author Name:");
        JLabel isbn = new JLabel("ISBN:");

        Font labelFont = new Font("Arial", Font.PLAIN, 20);

        book_id.setFont(labelFont);
        title.setFont(labelFont);
        author.setFont(labelFont);
        isbn.setFont(labelFont);

        book_id.setBounds(300, 120, 150, 30);
        title.setBounds(300, 170, 150, 30);
        author.setBounds(300, 220, 150, 30);
        isbn.setBounds(300, 270, 150, 30);

        // ---------- TEXT FIELDS ----------
         tf1 = new JTextField();
         tf2 = new JTextField();
        tf3 = new JTextField();
         tf4 = new JTextField();

        tf1.setBounds(450, 120, 220, 35);
        tf2.setBounds(450, 170, 220, 35);
        tf3.setBounds(450, 220, 220, 35);
        tf4.setBounds(450, 270, 220, 35);

        tf1.setFont(new Font("Dialog", Font.PLAIN, 18));
        tf2.setFont(new Font("Dialog", Font.PLAIN, 18));
        tf3.setFont(new Font("Dialog", Font.PLAIN, 18));
        tf4.setFont(new Font("Dialog", Font.PLAIN, 18));

        // ---------- BUTTONS ----------
         addBtn = new JButton("Add Book");
         backBookBtn = new JButton("Back");

        addBtn.setBounds(400, 350, 140, 45);
        backBookBtn.setBounds(560, 350, 110, 45);

        addBtn.setFont(new Font("Dialog", Font.BOLD, 16));
        backBookBtn.setFont(new Font("Dialog", Font.BOLD, 16));

        addBtn.setBackground(new Color(0, 153, 76));
        addBtn.setForeground(Color.WHITE);

        backBookBtn.setBackground(Color.RED);
        backBookBtn.setForeground(Color.WHITE);

        addBtn.setFocusable(false);
        backBookBtn.setFocusable(false);

        addBtn.addActionListener(this);
        backBookBtn.addActionListener(this);
        
        JLabel copiesLabel = new JLabel("No. of Copies:");
        copiesLabel.setBounds(300, 320, 150, 30);
        copiesLabel.setFont(new Font("Arial", Font.PLAIN, 20));

         copiesField = new JTextField();
        copiesField.setBounds(450, 320, 220, 35);
        copiesField.setFont(new Font("Dialog", Font.PLAIN, 18));

        
        
        // ---------- ADD COMPONENTS ----------
        bookPanel.add(book_id);
        bookPanel.add(title);
        bookPanel.add(author);
        bookPanel.add(isbn);
        bookPanel.add(copiesLabel);
        bookPanel.add(copiesField);

        bookPanel.add(tf1);
        bookPanel.add(tf2);
        bookPanel.add(tf3);
        bookPanel.add(tf4);

        bookPanel.add(addBtn);
        bookPanel.add(backBookBtn);
        
        

        return bookPanel;
    }
    
    // ADD Student Panel
    private JPanel addStudentPanel() {
    	JPanel studentPanel = new JPanel();
    	studentPanel.setLayout(null);
    	studentPanel.setBackground(Color.white);
    	
    	 JLabel heading = new JLabel("Manage The Student Database ", JLabel.CENTER);
         heading.setFont(new Font("Arial", Font.BOLD, 30));
         heading.setBounds(0, 30, 1000, 40);
         studentPanel.add(heading);
         
         JLabel student_id = new JLabel("Student Id :");
         JLabel name = new JLabel("Student Name : ");
         JLabel course = new JLabel("Course Name : ");
         JLabel branch = new JLabel("Branch : ");
         
         Font labelFont = new Font("Arial", Font.PLAIN, 20);

         student_id.setFont(labelFont);
         name.setFont(labelFont);
         course.setFont(labelFont);
         branch.setFont(labelFont);

         student_id.setBounds(300, 120, 150, 30);
         name.setBounds(300, 170, 150, 30);
         course.setBounds(300, 220, 150, 30);
         branch.setBounds(300, 270, 150, 30);
         
         
        stf1 = new JTextField();
        stf2 = new JTextField();
        stf3 = new JTextField();
        stf4 = new JTextField();
        
        stf1.setBounds(450, 120, 220, 35);
        stf2.setBounds(450, 170, 220, 35);
        stf3.setBounds(450, 220, 220, 35);
        stf4.setBounds(450, 270, 220, 35);

        stf1.setFont(new Font("Dialog", Font.PLAIN, 18));
        stf2.setFont(new Font("Dialog", Font.PLAIN, 18));
        stf3.setFont(new Font("Dialog", Font.PLAIN, 18));
        stf4.setFont(new Font("Dialog", Font.PLAIN, 18));
        
        // buttons 
        search = new JButton("Search by ID");
        add = new JButton("Add Student ");
        delete = new JButton("Delete by ID");
        back = new JButton("Back to Dashboard");
        
        search.setBounds(300, 350, 140, 45);
        add.setBounds(450, 350, 110, 45);
        delete.setBounds(560 , 350 , 110 , 45);
        back.setBounds(450, 450 , 160 , 45);
        
        search.setBackground(Color.cyan);
        
        add.setBackground(new Color(0, 153, 76));
        add.setForeground(Color.WHITE);

        delete.setBackground(Color.RED);
        delete.setForeground(Color.WHITE);
        
        search.setFocusable(false);
        add.setFocusable(false);
        delete.setFocusable(false);
        back.setFocusable(false);
        
        search.addActionListener(this);
        add.addActionListener(this);
        delete.addActionListener(this);
        back.addActionListener(this);
        
       studentPanel.add(student_id);
       studentPanel.add(name);
       studentPanel.add(course);
       studentPanel.add(branch);
       
       
       studentPanel.add(stf1);
       studentPanel.add(stf2);
       studentPanel.add(stf3);
       studentPanel.add(stf4);
       
       studentPanel.add(search);
       studentPanel.add(add);
       studentPanel.add(delete);
       studentPanel.add(back);
        
         
    	return studentPanel ;
    }

    
    // ISSUE OR RETUN BOOK PANEL with Logic Embedded using Lambda Functions 
    private JPanel issueReturnPanel() {
    	JPanel panel = new JPanel(null);
        panel.setBackground(Color.WHITE);

        JLabel title = new JLabel("Issue / Return Book", JLabel.CENTER);
        title.setBounds(0,30,1000,40);
        title.setFont(new Font("Arial",Font.BOLD,28));
        panel.add(title);

        JLabel sidLbl = new JLabel("Student ID:");
        sidLbl.setBounds(300,120,150,30);
        panel.add(sidLbl);

        JTextField sidField = new JTextField();
        sidField.setBounds(450,120,200,30);
        panel.add(sidField);

        JLabel bidLbl = new JLabel("Book ID:");
        bidLbl.setBounds(300,170,150,30);
        panel.add(bidLbl);

        JTextField bidField = new JTextField();
        bidField.setBounds(450,170,200,30);
        panel.add(bidField);

        issueBtn = new JButton("Issue Book");
        issueBtn.setBounds(350,250,130,40);
        issueBtn.addActionListener(e -> {

            String sidText = sidField.getText().trim();
            String bidText = bidField.getText().trim();

            // ✅ Required field validation
            if(sidText.isEmpty() || bidText.isEmpty()){
                JOptionPane.showMessageDialog(frame,
                        "Please enter both Student ID and Book ID!",
                        "Missing Fields",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }

            try(Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/librarydb",
                    "root","BsT45678")){

                int studentId = Integer.parseInt(sidText);
                int bookId = Integer.parseInt(bidText);

                // Check if student exists
                PreparedStatement checkStudent =
                        con.prepareStatement("SELECT * FROM students WHERE student_id=?");
                checkStudent.setInt(1, studentId);
                ResultSet studentRs = checkStudent.executeQuery();

                if(!studentRs.next()){
                    JOptionPane.showMessageDialog(frame,
                            "Student does not exist!",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Find available copy
                PreparedStatement ps1 = con.prepareStatement(
                    "SELECT copy_id FROM book_copies WHERE book_id=? AND status='Available' LIMIT 1");

                ps1.setInt(1, bookId);
                ResultSet rs = ps1.executeQuery();

                if(!rs.next()){
                    JOptionPane.showMessageDialog(frame,
                            "No copies available!",
                            "Unavailable",
                            JOptionPane.INFORMATION_MESSAGE);
                    return;
                }

                int copyId = rs.getInt("copy_id");

                // Update copy status
                PreparedStatement ps2 = con.prepareStatement(
                    "UPDATE book_copies SET status='Issued' WHERE copy_id=?");
                ps2.setInt(1, copyId);
                ps2.executeUpdate();

                // Insert transaction
                PreparedStatement ps3 = con.prepareStatement(
                    "INSERT INTO transactions(student_id, copy_id, issue_date, due_date) " +
                    "VALUES(?, ?, CURDATE(), DATE_ADD(CURDATE(), INTERVAL 7 DAY))");

                ps3.setInt(1, studentId);
                ps3.setInt(2, copyId);
                ps3.executeUpdate();

                JOptionPane.showMessageDialog(frame,"Book Issued Successfully!");

                sidField.setText("");
                bidField.setText("");

            }catch(NumberFormatException ex){
                JOptionPane.showMessageDialog(frame,
                        "Student ID and Book ID must be numeric!",
                        "Invalid Input",
                        JOptionPane.ERROR_MESSAGE);
            }catch(Exception ex){
                JOptionPane.showMessageDialog(frame,
                        "Error: " + ex.getMessage());
            }
        });

        JButton returnBtn = new JButton("Return Book");
        returnBtn.setBounds(500,250,150,40);
        returnBtn.addActionListener(e -> {

            String sidText = sidField.getText().trim();
            String bidText = bidField.getText().trim();

            if(sidText.isEmpty() || bidText.isEmpty()){
                JOptionPane.showMessageDialog(frame,
                        "Please enter both Student ID and Book ID!",
                        "Missing Fields",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }

            try(Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/librarydb",
                    "root","BsT45678")){

                int bookId = Integer.parseInt(bidText);

                PreparedStatement ps1 = con.prepareStatement(
                    "SELECT t.transaction_id, t.copy_id, t.due_date " +
                    "FROM transactions t " +
                    "JOIN book_copies b ON t.copy_id=b.copy_id " +
                    "WHERE b.book_id=? AND t.return_date IS NULL LIMIT 1");

                ps1.setInt(1, bookId);
                ResultSet rs = ps1.executeQuery();

                if(!rs.next()){
                    JOptionPane.showMessageDialog(frame,
                            "No active issue record found!",
                            "Error",
                            JOptionPane.INFORMATION_MESSAGE);
                    return;
                }

                int transactionId = rs.getInt("transaction_id");
                int copyId = rs.getInt("copy_id");
                Date dueDate = rs.getDate("due_date");

                long diff = System.currentTimeMillis() - dueDate.getTime();
                long daysLate = diff / (1000*60*60*24);

                double fine = (daysLate > 0) ? daysLate * 5 : 0;

                PreparedStatement ps2 = con.prepareStatement(
                    "UPDATE transactions SET return_date=CURDATE(), fine_amount=? WHERE transaction_id=?");
                ps2.setDouble(1, fine);
                ps2.setInt(2, transactionId);
                ps2.executeUpdate();

                PreparedStatement ps3 = con.prepareStatement(
                    "UPDATE book_copies SET status='Available' WHERE copy_id=?");
                ps3.setInt(1, copyId);
                ps3.executeUpdate();

                JOptionPane.showMessageDialog(frame,
                        "Book Returned Successfully!\nFine = ₹" + fine);

                sidField.setText("");
                bidField.setText("");

            }catch(NumberFormatException ex){
                JOptionPane.showMessageDialog(frame,
                        "Student ID and Book ID must be numeric!",
                        "Invalid Input",
                        JOptionPane.ERROR_MESSAGE);
            }catch(Exception ex){
                JOptionPane.showMessageDialog(frame,
                        "Error: " + ex.getMessage());
            }
        });

        backBtn = new JButton("Back");
        backBtn.setBounds(430,320,120,35);
        backBtn.addActionListener(e -> {
        	cardLayout.show(container,"Dashboard");   // Lambda Function 
        });

        panel.add(issueBtn);
        panel.add(returnBtn);
        panel.add(backBtn);

		return panel;
	}
    

    //All Action Performed Logic for every JButton 
    @Override
    public void actionPerformed(ActionEvent e) {

        String admin_id = adminField.getText();
        String password = new String(passField.getPassword());

        if (e.getSource() == logIn) {

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/librarydb",
                        "root",
                        "BsT45678");

                PreparedStatement prep = con.prepareStatement(
                        "SELECT * FROM admin_info WHERE admin_id=? AND admin_pass=?");

                prep.setString(1, admin_id);
                prep.setString(2, password);

                ResultSet rs = prep.executeQuery();

                if (rs.next()) {
                    JOptionPane.showMessageDialog(frame, "Login Successful!");
                    cardLayout.show(container, "Dashboard");
                } else {
                    JOptionPane.showMessageDialog(frame, "Invalid Credentials","Incorrect ", JOptionPane.WARNING_MESSAGE);
                    adminField.setText("");
                    passField.setText("");
                    adminField.requestFocus(); 
                }
                
                rs.close();
                prep.close();
                con.close();
                

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        
        
        if(e.getSource() == b4) {
        	JOptionPane.showMessageDialog(frame, "LogOut Successful!");
            cardLayout.show(container, "Login");
            adminField.setText("");
            passField.setText("");
            adminField.requestFocus(); 
        	
        }
        
        if(e.getSource()==b2) {
        	cardLayout.show(container, "AddBook");
        }
        
        
        String book_id = tf1.getText() ;
        String book_title  = tf2.getText();
        String author_name = tf3.getText() ;
        String isbn = tf4.getText();
        
        
        if(e.getSource() == addBtn){

             book_id = tf1.getText().trim();
            String title = tf2.getText().trim();
            String author = tf3.getText().trim();
             isbn = tf4.getText().trim();
            String copiesText = copiesField.getText().trim();

            if(book_id.isEmpty() || title.isEmpty() || author.isEmpty() || 
               isbn.isEmpty() || copiesText.isEmpty()){

                JOptionPane.showMessageDialog(frame,
                    "Please enter all book details including copies!",
                    "Missing Fields",
                    JOptionPane.WARNING_MESSAGE);
                return;
            }

            try(Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/librarydb",
                    "root","BsT45678")){

                con.setAutoCommit(false); // 🔥 TRANSACTION START

                int bookId = Integer.parseInt(book_id);
                int copies = Integer.parseInt(copiesText);

                // 1️⃣ Insert book
                PreparedStatement ps1 = con.prepareStatement(
                    "INSERT INTO books VALUES (?,?,?,?)");

                ps1.setInt(1, bookId);
                ps1.setString(2, title);
                ps1.setString(3, author);
                ps1.setString(4, isbn);
                ps1.executeUpdate();

                // 2️⃣ Insert copies automatically
                PreparedStatement ps2 = con.prepareStatement(
                    "INSERT INTO book_copies(copy_id, book_id, status) VALUES (?,?,?)");

                // generate copy_id dynamically
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("SELECT IFNULL(MAX(copy_id),0) FROM book_copies");

                int startId = 1;
                if(rs.next()){
                    startId = rs.getInt(1) + 1;
                }

                for(int i = 0; i < copies; i++){
                    ps2.setInt(1, startId + i);
                    ps2.setInt(2, bookId);
                    ps2.setString(3, "Available");
                    ps2.addBatch();
                }

                ps2.executeBatch();

                con.commit(); // ✅ SAVE ALL

                JOptionPane.showMessageDialog(frame,
                    "Book and Copies Added Successfully!");

                // clear fields
                tf1.setText("");
                tf2.setText("");
                tf3.setText("");
                tf4.setText("");
                copiesField.setText("");

            }catch(Exception ex){
                ex.printStackTrace();
                JOptionPane.showMessageDialog(frame,
                    "Error: " + ex.getMessage());
            }
        }

        if(e.getSource() == backBookBtn){
        	cardLayout.show(container, "Dashboard");
        }
        
        if(e.getSource()==b1) {
        	cardLayout.show(container, "AddStudent");
        }
        
        
        // students database edit buttons
        	
        
        if(e.getSource() == back) {
        	cardLayout.show(container, "Dashboard");
        }
        
        String student_id="" , student_name ="",  student_course ="", student_branch ="";
        if(e.getSource()== add) {

            student_id = stf1.getText().trim();
            student_name = stf2.getText().trim();
            student_course = stf3.getText().trim();
            student_branch = stf4.getText().trim();

            // ✅ Validation FIRST
            if(student_id.isEmpty() || student_name.isEmpty() ||
               student_course.isEmpty() || student_branch.isEmpty()){

                JOptionPane.showMessageDialog(frame,
                    "Please enter all student details!",
                    "Missing Fields",
                    JOptionPane.WARNING_MESSAGE);
                return;
            }

            try(Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/librarydb",
                    "root","BsT45678")){

                PreparedStatement prepstat = con.prepareStatement(
                    "INSERT INTO students(student_id, student_name, student_course, student_branch) VALUES (?,?,?,?)");

                prepstat.setInt(1, Integer.parseInt(student_id));
                prepstat.setString(2, student_name);
                prepstat.setString(3, student_course);
                prepstat.setString(4, student_branch);

                prepstat.executeUpdate();

                JOptionPane.showMessageDialog(frame,
                        "Student Added Successfully!");

                // clear fields
                stf1.setText("");
                stf2.setText("");
                stf3.setText("");
                stf4.setText("");

            }catch(Exception ex){
                JOptionPane.showMessageDialog(frame,
                        "Error: " + ex.getMessage());
            }
        }
        
        if(e.getSource() == delete){

             student_id = stf1.getText().trim();

            if(student_id.isEmpty()){
                JOptionPane.showMessageDialog(frame,
                    "Enter Student ID to delete!",
                    "Missing Field",
                    JOptionPane.WARNING_MESSAGE);
                return;
            }

            try(Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/librarydb",
                    "root","BsT45678")){

                PreparedStatement prepstat =
                    con.prepareStatement("DELETE FROM students WHERE student_id=?");

                prepstat.setInt(1, Integer.parseInt(student_id));

                int rows = prepstat.executeUpdate();

                if(rows == 1){
                    JOptionPane.showMessageDialog(frame,
                        "Student Deleted Successfully!");
                }else{
                    JOptionPane.showMessageDialog(frame,
                        "Student not found!");
                }

            }catch(SQLException ex){

                // ✅ FOREIGN KEY ERROR HANDLING
                if(ex.getErrorCode() == 1451){
                    JOptionPane.showMessageDialog(frame,
                        "Cannot delete student!\nThis student has issued books.\nReturn all books first.",
                        "Foreign Key Constraint",
                        JOptionPane.ERROR_MESSAGE);
                }else{
                    JOptionPane.showMessageDialog(frame,
                        "Database Error: " + ex.getMessage());
                }
            }
        }
        
        
        if(e.getSource() == search){
        	try {
        		Class.forName("com.mysql.cj.jdbc.Driver");
        	}catch(ClassNotFoundException cnfe) {
        		System.out.println(cnfe.getMessage());
        	}
        	try {
        		Connection con = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/librarydb",
                        "root",
                        "BsT45678");
        		
        		PreparedStatement prepstat = con.prepareStatement("select * from students where student_id = ?");
        		if(stf1.getText()!="") {
        		student_id = stf1.getText();
        		prepstat.setString(1, student_id);
        		}
        		ResultSet rs = prepstat.executeQuery();
        		
        		if(rs.next()) {
        			JOptionPane.showMessageDialog(frame, " Students Record Found ");
        			stf2.setText(rs.getString(2));
        			stf3.setText(rs.getString(3));
        			stf4.setText(rs.getString(4));
        			
        		}
        		else {
        			JOptionPane.showMessageDialog(frame, " Students Record Not Found in Database  ");
        		}
        	
        		rs.close();
        		prepstat.close();
        		con.close();
        		
        	}catch(SQLException sqle) {
        		System.out.println(sqle.getMessage());
        	}
        }
        
        if(e.getSource() == b3){
            cardLayout.show(container, "IssueReturn");
        }

        
        
        
        
        
        
        
}
    public static void main(String[] args) {
        new LibraryManagementSystem___GUI();
    }
}


// for the background of the dashboard panel 
class BackgroundPanel extends JPanel {

    private Image bgImage;

    public BackgroundPanel(String imagePath) {
        bgImage = new ImageIcon(imagePath).getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(bgImage, 0, 0, getWidth(), getHeight(), this);
    }
}

