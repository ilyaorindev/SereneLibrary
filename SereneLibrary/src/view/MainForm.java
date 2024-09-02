package view;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

public class MainForm {
    JFrame frame;
    JTabbedPane tabbed;
    JTabbedPane tabbedDocs;
    JTabbedPane tabbedBooks;
    public MainForm() {
        initializeFrame();
        initializeTabbed();
        frame.setVisible(true);
    }

    private void initializeFrame() {
        JFrame frame = new JFrame();
        frame.setSize(800, 800);
        frame.setResizable(false);
        frame.setTitle("SereneLib - Home");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame = frame;
    }
    private void initializeTabbed() {
        JTabbedPane tabbedDocs = new JTabbedPane();
        tabbedDocs.addTab("All documents", new JPanel());
        tabbedDocs.addTab("Work docs", new JPanel());
        tabbedDocs.addTab("School docs", new JPanel());
        tabbedDocs.addTab("Other docs", new JPanel());

        JTabbedPane tabbedBooks = new JTabbedPane();
        tabbedBooks.addTab("All books", new JScrollPane());
        tabbedBooks.addTab("Action", new JPanel());
        tabbedBooks.addTab("Horror", new JPanel());
        tabbedBooks.addTab("Mystery", new JPanel());
        tabbedBooks.addTab("Romance", new JPanel());
        tabbedBooks.addTab("Comedy", new JPanel());
        tabbedBooks.addTab("Fantasy", new JPanel());
        tabbedBooks.addTab("Drama", new JPanel());

        this.tabbedBooks = tabbedBooks;
        this.tabbedDocs = tabbedDocs;

        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Documents", this.tabbedDocs);
        tabbedPane.addTab("Books", this.tabbedBooks);
        this.tabbed = tabbedPane;
        frame.add(this.tabbed);
    }
}
