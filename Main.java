import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

import java.awt.*;

public class Main 
{
    public static String titles[] = {"ID", "Fullname", "Address", "Mobile", "Stage"};
    static DefaultTableModel model = new DefaultTableModel(titles, 0);
    public static void main(String[] args) 
    {
        // Making a new Window
        JFrame window = new JFrame("ISE Student Management System");
        window.setSize(612,830);
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
        Design.font(tabs);
        
        // tap1
        JPanel tap1 = new JPanel();
        tap1.setBackground(new Color(6, 154, 142));
        tap1.setLayout(null);

        // Buttons
        // Add button
        JButton add_button = new JButton("+ Add");
        Design.font(add_button);
        add_button.setFocusPainted(false);
        add_button.setBackground(new Color(180, 225, 151));
        add_button.setBounds(90, 370, 100,30);
        
        // Edit Button
        JButton edit_button = new JButton("Edit");
        Design.font(edit_button);
        edit_button.setFocusPainted(false);
        edit_button.setBackground(new Color(233, 239, 192));
        edit_button.setBounds(220, 370, 100,30);

        // Delete Button
        JButton delete_button = new JButton("Delete");
        Design.font(delete_button);
        delete_button.setFocusPainted(false);
        delete_button.setBackground(new Color(239, 242, 236));
        delete_button.setBounds(350, 370, 100,30);

        // Table container
        JTable table = new JTable(model);
        table.setBackground(new Color(161, 227, 216));
        table.getTableHeader().setBackground(new Color(210, 252, 245));
        table.setFillsViewportHeight(true);
        table.setShowGrid(false);
        table.setIntercellSpacing(new Dimension(0, 0));
        Design.font(table.getTableHeader());
        Design.font(table);


        // Scroll panel for table
        JScrollPane scrollPane = new JScrollPane(table);
        JPanel Tpanel=new JPanel();
        Tpanel.setBounds(0, 0, 541, 360);
        Tpanel.setLayout(new BorderLayout());
        Tpanel.setBorder(null);

        Tpanel.add(scrollPane);
        

        // tap2
        JPanel tap2 = new JPanel();
        tap2.setBackground(new Color(6, 154, 142));
        tap2.setLayout(null);


        // Course Model
        String course_titles[] = {"Courses", "Number of students"};
        DefaultTableModel course_model = new DefaultTableModel(course_titles, 0);


        // Table container
        JTable table2 = new JTable(course_model);
        table2.setBackground(new Color(161, 227, 216));
        table2.getTableHeader().setBackground(new Color(210, 252, 245));
        table2.setFillsViewportHeight(true);
        table2.setShowGrid(false);
        table2.setIntercellSpacing(new Dimension(0, 0));
        Design.font(table2.getTableHeader());
        Design.font(table2);


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

        // 2nd Search by typing...
        JTextField search_bar = new JTextField("Search");
        search_bar.setOpaque(false);
        search_bar.setBorder(new Design(25));
        search_bar.setForeground(Color.WHITE);
        search_bar.setBounds(33, 40, 200,70);
        Design.font(search_bar);

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

        model.addRow(new Object[]{
            "Hello World"
        });

        // Adding components to tab1
        tap1.add(add_button);
        tap1.add(edit_button);
        tap1.add(delete_button);
        tap1.add(Tpanel);

        // Adding components to tab2
        //tap1.add(add_button);
        //tap1.add(edit_button);
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
    public static void font(JComponent comp){
        comp.setFont(new Font("TimesRoman", Font.BOLD | Font.ITALIC, 17));
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



    