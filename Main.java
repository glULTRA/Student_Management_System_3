import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import java.awt.*;

public class Main 
{
    public static String titles[] = {"ID", "Fullname", "Address", "Stage", "Mobile"};
    public static DefaultTableModel model = new DefaultTableModel(titles, 0);
    public static final String file_name = "students.csv";
    public static final String course_file_name = "courses.txt";
    public static String course_titles[] = {"Courses", "Number of students"};
    public static DefaultTableModel course_model = new DefaultTableModel(course_titles, 0);

    public static void add_new_row_to_model(Student student, DefaultTableModel model){
        model.addRow(
            new Object[]{
                student.getId(),
                student.getFullname(),
                student.getAddress(),
                student.getStage(),
                student.getMobile(),
            }
        );
    }
    public static void add_new_row_to_course_model(Course course, DefaultTableModel model)
    {
        if (course.getNoStudent() == 0) {
            return;
        }
        model.addRow(
            new Object[]{
                course.getCourseName(),
                course.getNoStudent()
            }
        );
    }
    public static void main(String[] args) 
    {
        // My data in arraylist.
        ArrayList<Student> students = new ArrayList<Student>();
        ArrayList<Course> courses = new ArrayList<Course>();

        // Loading all data from the file.
        Reader.load_from_file(students, file_name);
        Reader.load_course_file(courses, course_file_name);

        System.out.println(courses.size());

        // Adding the data from ArrayList to table.
        for (int i = 0; i < students.size(); i++){
            add_new_row_to_model(students.get(i), model);
        }
        for (int i = 0; i < courses.size(); i++){
            add_new_row_to_course_model(courses.get(i), course_model);
        }

        
        // Making a new Window
        JFrame window = new JFrame("ISE Student Management System");

        // Window's configurations
        window.setSize(612,830);
        window.setBounds(500, 20, 612,830);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        
        window.setLayout(null);
        window.setResizable(false);

        // A Background
        JPanel background = new JPanel();
        background.setBackground(new Color(0, 85, 85));
        background.setSize(612,830);
        background.setLayout(null);

        // Title !
        JLabel title = new JLabel("<html><h1 align=\"center\">Welcome to Student Management <br> System</h1></html>");
        title.setForeground(Color.WHITE);
        title.setBounds(110,27, 500, 64);

        // Insider panel
        JPanel insider_panel = new JPanel();
        insider_panel.setLayout(null);
        insider_panel.setBackground(new Color(6, 154, 142));
        insider_panel.setBounds(0, 115, 612, 620);
        insider_panel.setLayout(null);


        // Tap buttons
        JTabbedPane tabs = new JTabbedPane();
        tabs.setBounds(29, 130, 541, 445);
        tabs.setBackground(Color.WHITE);
        Design.font(tabs, 17);
        
        // tap1
        JPanel tap1 = new JPanel();
        tap1.setBackground(new Color(6, 154, 142));
        tap1.setLayout(null);

        // Buttons
        // Add button
        JButton add_button = new JButton("+ Add");
        Design.font(add_button, 17);
        add_button.setFocusPainted(false);
        add_button.setBackground(new Color(180, 225, 151));
        add_button.setBounds(90, 370, 100,30);


        add_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Creating new window for adding a new student.
                JFrame student_window = new JFrame();
                student_window.setLayout(null);
                student_window.setBounds(500, 20, 612,830);
                student_window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                student_window.getContentPane().setBackground(new Color(0, 85, 85));
                student_window.setResizable(false);

                // Title
                JLabel title = new JLabel("<html><h1 align=\"center\">Adding a new Student</h1><hr></html>");
                title.setForeground(Color.WHITE);
                title.setBounds(170,27, 500, 64);

                // Form panel
                JPanel form = new JPanel();
                form.setBounds(0, 100, 612, 600);
                form.setBackground(new Color(6, 154, 142));
                form.setLayout(null);

                // ID label
                JLabel id_label = new JLabel("ID:");
                Design.font(id_label, 20);
                id_label.setBounds(30, 20, 100, 20);
                id_label.setForeground(new Color(210, 252, 245));

                // ID text
                JTextField id_text = new JTextField();
                Design.font(id_text, 17);
                id_text.setBounds(30, 50, 200, 70);
                id_text.setOpaque(false);
                id_text.setBorder(new Design(25));
                id_text.setForeground(new Color(210, 252, 245));

                // Fullname label
                JLabel fullname = new JLabel("Fullname:");
                Design.font(fullname, 20);
                fullname.setBounds(30, 130, 100, 20);
                fullname.setForeground(new Color(210, 252, 245));

                // Fullname text
                JTextField fullname_text = new JTextField();
                Design.font(fullname_text, 17);
                fullname_text.setBounds(30, 160, 200, 70);
                fullname_text.setOpaque(false);
                fullname_text.setBorder(new Design(25));
                fullname_text.setForeground(new Color(210, 252, 245));

                // Address label
                JLabel address = new JLabel("Address:");
                Design.font(address, 20);
                address.setBounds(30, 240, 100, 20);
                address.setForeground(new Color(210, 252, 245));

                // Address text
                JTextField address_text = new JTextField();
                Design.font(address_text, 17);
                address_text.setBounds(30, 270, 200, 70);
                address_text.setOpaque(false);
                address_text.setBorder(new Design(25));
                address_text.setForeground(new Color(210, 252, 245));

                // Address label
                JLabel phone = new JLabel("Phone Number:");
                Design.font(phone, 20);
                phone.setBounds(30, 350, 200, 20);
                phone.setForeground(new Color(210, 252, 245));

                // Address text
                JTextField phone_text = new JTextField();
                Design.font(phone_text, 17);
                phone_text.setBounds(30, 390, 200, 70);
                phone_text.setOpaque(false);
                phone_text.setBorder(new Design(25));
                phone_text.setForeground(new Color(210, 252, 245));

                // Stages
                String stages[] = {"1", "2", "3", "4"};
                JComboBox<String> stage = new JComboBox<>(stages);
                stage.setOpaque(false);
                stage.setFocusable(false);
                stage.setBackground(new Color(210, 252, 245));
                stage.setBorder(new Design(10));
                stage.setBounds(350, 50, 130,50);

                // Check box for courses
                JLabel course_label = new JLabel("Courses:");
                course_label.setBounds(350, 170, 100, 50);
                Design.font(course_label, 18);
                course_label.setForeground(new Color(210, 252, 245));

                JCheckBox course_box[] = new JCheckBox[Student.stage_1_courses.length];  
                for (int i = 0; i < course_box.length; i++) {
                    course_box[i] = new JCheckBox(Student.stage_1_courses[i]);
                    Design.font(course_box[i], 18);
                    course_box[i].setBounds(350, 230 + (45 * i), 250, 20);
                    course_box[i].setOpaque(false);
                    course_box[i].setForeground(Color.WHITE); //247, 255, 147
                }  
                

                // Add button
                JButton add_student = new JButton("Add Student");
                add_student.setBackground(new Color(247, 255, 147));
                add_student.setBounds(190, 510, 200, 50);

                stage.addActionListener(
                    new ActionListener(){
                        @Override
                        public void actionPerformed(ActionEvent e){
                            // showing courses !
                            int selected_item = stage.getSelectedIndex() + 1;
                            switch (selected_item) 
                            {
                                // Stage 1 course
                                case 1:
                                    for (int i = 0; i < course_box.length; i++)
                                        course_box[i].setText(Student.stage_1_courses[i]);
                                    break;
                                case 2:
                                    for (int i = 0; i < 5; i++) 
                                        course_box[i].setText(Student.stage_2_courses[i]);
                                    break;
                                case 3:
                                    for (int i = 0; i < 5; i++) 
                                        course_box[i].setText(Student.stage_3_courses[i]);
                                    break;
                                case 4:
                                    for (int i = 0; i < 5; i++) 
                                        course_box[i].setText(Student.stage_4_courses[i]);
                                    break;
                                default:
                                    break;
                            }
                        }
                    }
                );

                // Adding components to form.
                form.add(id_label);
                form.add(id_text);
                form.add(fullname);
                form.add(fullname_text);
                form.add(address);
                form.add(address_text);
                form.add(phone);
                form.add(phone_text);
                form.add(stage);
                form.add(course_label);
                for (int i = 0; i < course_box.length; i++) {
                    form.add(course_box[i]);                    
                }
                form.add(add_student);

                // Adding components to window.
                student_window.add(form);
                student_window.add(title);
                student_window.setVisible(true);
            }
        });
        
        

        // Table container
        JTable table = new JTable(model);
        table.setBackground(new Color(161, 227, 216));
        table.getTableHeader().setBackground(new Color(210, 252, 245));
        table.setFillsViewportHeight(true);
        table.setShowGrid(false);
        table.setIntercellSpacing(new Dimension(0, 0));
        table.putClientProperty("terminateEditOnFocusLost", true);
        //table.isCellEditable(0, 0);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        table.getColumnModel().getColumn(0).setCellRenderer( centerRenderer );
        
        table.setSelectionBackground(new Color(247, 255, 147));
        

        Design.font(table.getTableHeader(), 17);
        Design.font(table, 17);


        // Scroll panel for table
        JScrollPane scrollPane = new JScrollPane(table);
        JPanel Tpanel=new JPanel();
        Tpanel.setBounds(0, 0, 541, 360);
        Tpanel.setLayout(new BorderLayout());
        Tpanel.setBorder(null);

        Tpanel.add(scrollPane);

        // Edit Button
        JButton save_button = new JButton("Save");
        Design.font(save_button, 17);
        save_button.setFocusPainted(false);
        save_button.setBackground(new Color(233, 239, 192));
        save_button.setBounds(220, 370, 100,30);
        save_button.setVisible(false);

        save_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                table.getSelectionModel().clearSelection();
            }
        });

        // Delete Button
        JButton delete_button = new JButton("Delete");
        Design.font(delete_button, 17);
        delete_button.setFocusPainted(false);
        delete_button.setBackground(new Color(239, 242, 236));
        delete_button.setBounds(350, 370, 100,30);

        delete_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Delete selected item.
            }
        });

        table.addFocusListener(
            new FocusListener(){

                @Override
                public void focusGained(FocusEvent e) {
                    // TODO Auto-generated method stub
                    
                }

                @Override
                public void focusLost(FocusEvent e) {
                    // TODO Auto-generated method stub
                    table.getSelectionModel().clearSelection();
                    //save_button.setVisible(false);
                    
                }
                
            }
        );  
    
        table.getSelectionModel().addListSelectionListener(
            new ListSelectionListener() {
                @Override
                public void valueChanged(ListSelectionEvent e) {
                    if (!e.getValueIsAdjusting()) {
                        if (table.getSelectedRow() > -1) {
                            save_button.setVisible(true);
                        }
                    }              
                }
            }
        );
        

        // tap2
        JPanel tap2 = new JPanel();
        tap2.setBackground(new Color(6, 154, 142));
        tap2.setLayout(null);


        // Table container
        JTable table2 = new JTable(course_model){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false; //Disallow the editing of any cell
            }
        };
        table2.setBackground(new Color(161, 227, 216));
        table2.getTableHeader().setBackground(new Color(210, 252, 245));
        table2.setFillsViewportHeight(true);
        table2.setShowGrid(false);
        table2.setIntercellSpacing(new Dimension(0, 0));
        table2.putClientProperty("terminateEditOnFocusLost", true);
        table2.isCellEditable(0, 1);
        table2.setSelectionBackground(new Color(247, 255, 147));
        table2.getColumnModel().getColumn(1).setCellRenderer( centerRenderer );
        
        Design.font(table2.getTableHeader(), 17);
        Design.font(table2, 17);


        // Scroll panel for table
        JScrollPane scrollPane2 = new JScrollPane(table2);
        JPanel Tpanel2=new JPanel();
        Tpanel2.setBounds(0, 0, 541, 360);
        Tpanel2.setLayout(new BorderLayout());
        Tpanel2.setBorder(null);

        Tpanel2.add(scrollPane2);



        // Search Engines !
        // 1st Search by Selecting stages.
        String stages[] = {"1", "2", "3", "4", "All Stage"};
        JComboBox<String> stage = new JComboBox<>(stages);
        stage.setOpaque(false);
        stage.setFocusable(false);
        stage.setBackground(new Color(255,255,255));
        stage.setBorder(new Design(10));
        stage.setBounds(430, 40, 130,50);
        stage.setSelectedIndex(4);

        stage.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){

            }
        });

        // 2nd Search by typing...
        JTextField search_bar = new JTextField("Search");
        search_bar.setOpaque(false);
        search_bar.setBorder(new Design(25));
        search_bar.setForeground(Color.WHITE);
        search_bar.setBounds(33, 40, 200,70);
        Design.font(search_bar,17);

        search_bar.addKeyListener(new KeyListener(){
            @Override
            public void keyTyped(KeyEvent e) {
                // TODO Auto-generated method stub
                System.out.println("keyTyped");
            }

            @Override
            public void keyReleased(KeyEvent e) {
                // TODO Auto-generated method stub
                System.out.println("keyReleased");
            }

            @Override
            public void keyPressed(KeyEvent e) {
                // TODO Auto-generated method stub
                System.out.println("keyPressed");
            }
        });

        // Adding components to tab1
        tap1.add(add_button);
        tap1.add(save_button);
        tap1.add(delete_button);
        tap1.add(Tpanel);

        // Adding components to tab2
        //tap1.add(add_button);
        //tap1.add(save_button);
        //tap1.add(delete_button);
        tap2.add(Tpanel2);

        // Adding components to taps
        tabs.add("Student", tap1);
        tabs.add("Course", tap2);

        // Adding components to insider
        insider_panel.add(search_bar);
        insider_panel.add(stage);
        insider_panel.add(tabs);

        // Adding components to background
        background.add(title);
        background.add(insider_panel);
        
        // Adding components to window
        window.add(background);

        window.setVisible(true);
    }
}

class Design implements Border
{
    private int r;
    Design(int r) {
        this.r = r;
    }
    public static void font(JComponent comp, int size){
        comp.setFont(new Font("TimesRoman", Font.BOLD | Font.ITALIC, size));
    } 
    public Insets getBorderInsets(Component c) {
        return new Insets(this.r+1, this.r+1, this.r+2, this.r);
    }
    public boolean isBorderOpaque() {
        return true;
    }
    public void paintBorder(Component c, Graphics g, int x, int y, 
    int width, int height) {
        g.drawRoundRect(x, y, width-1, height-1, r, r);
    }
}



    