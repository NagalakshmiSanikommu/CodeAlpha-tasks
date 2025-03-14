
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 class WordCounter extends JFrame {
    public JTextArea textArea;
    public JButton countButton;
    public JLabel wordcountLabel;
    public WordCounter(){
        createGUI();
    }
    private void createGUI(){
        setTitle("Word Counter");
        setSize(400,300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        textArea =new JTextArea();
        textArea.setFont(new Font("italic",Font.PLAIN,100));
        add(new JScrollPane(textArea),BorderLayout.CENTER);
        JPanel buttonpanel =new JPanel();
        add(buttonpanel,BorderLayout.PAGE_END);
        countButton = new JButton("Count Words");
        countButton.addActionListener(new ActionListener(){
        
            public void actionPerformed(ActionEvent e){
                countWords();
            }
        });
        buttonpanel.add(countButton);
        wordcountLabel=new JLabel("word Count:0");
        buttonpanel.add(wordcountLabel);
        setVisible(true);
    }
    private void countWords(){
        String text = textArea.getText();
        String [] words=text.split("\s+");
        int wordCount= words.length;
        wordcountLabel.setText("word count"+ wordCount);
    }
    public static void main (String[]args){
        SwingUtilities.invokeLater(new Runnable(){
            
            public void run(){
                new WordCounter();
            }
        });
    }
}


