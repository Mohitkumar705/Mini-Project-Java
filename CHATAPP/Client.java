import java.net.*;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.*;
public class Client extends JFrame 
{
    //ServerSocket server;
    Socket socket;
    BufferedReader br;
    PrintWriter out;
    //Delcare components
    private JLabel heading = new JLabel("Client Area");
    private JTextArea messageArea = new JTextArea();
    private JTextField messageInput = new JTextField();
    private Font font = new Font("Roboto",Font.PLAIN,20);
    public Client()
    {
        try {
            System.out.println("Sending request to server");
            Socket socket = new Socket("127.0.01",7778);
            System.out.println("connection done.");
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream());
            createGUI();
            handleEvents();
                    
            startReading();
            // startWriting();
        }catch (Exception e) {
         // TODO: handle exception
        }
    }
    private void handleEvents() {
        messageInput.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
                // TODO Auto-generated method stub 
            }

            @Override
            public void keyPressed(KeyEvent e) {
                // TODO Auto-generated method stub   
            }

            @Override
            public void keyReleased(KeyEvent e) {
                // TODO Auto-generated method stub
                if(e.getKeyCode()==10){
                    //System.out.println("You have pressed enter button");
                    String contentToSend=messageInput.getText();
                    messageArea.append("Me :"+contentToSend+"\n");
                    out.println(contentToSend);
                    out.flush();
                    messageInput.setText("");
                    messageInput.requestFocus();
                }
            }
            
        });
    }
    private void createGUI()
    {
        //  gui code...
        this.setTitle("Client Message[END]");
        this.setSize(600,600);
		getContentPane().setBackground(new Color(128, 255, 255));

        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //coding for components
        heading.setFont(font);
        messageArea.setFont(font);
        messageInput.setFont(font);
        heading.setIcon(new ImageIcon("clogo.png"));
        heading.setHorizontalTextPosition(SwingConstants.CENTER);
        heading.setVerticalTextPosition(SwingConstants.BOTTOM);
        heading.setHorizontalAlignment(SwingConstants.CENTER);
        heading.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
        messageArea.setEditable(false);
        messageInput.setHorizontalAlignment(SwingConstants.CENTER);
        //frame ka layout set kranga 
        this.setLayout(new BorderLayout());
        //adding the components to frame
        this.add(heading,BorderLayout.NORTH);
        JScrollPane jScrollPane=new JScrollPane(messageArea);
        this.add(jScrollPane,BorderLayout.CENTER);
        this.add(messageInput,BorderLayout.SOUTH);
        this.setVisible(true);
    }
    public void startReading()
    {
        // thread-read karka daga
        Runnable r1=()->{
            System.out.println("reader started..");
            try{
                while(true)
                {
                    String msg=br.readLine();
                    if(msg.equals("exit"))
                    {
                        System.out.println("Server termiated the chat");
                        JOptionPane.showMessageDialog(this,"Server Terminate the chat..");
                        messageInput.setEnabled(false);
                        socket.close();
                        break;
                    }
                   // System.out.println("Server : "+msg);
                    messageArea.append("Server : "+msg+"\n");
                } 
            }catch(Exception e){
                System.out.println("connection closed");
            }
        };
        new Thread(r1).start();
    }
    public void startWriting()
    {
        // thread-data user lega and the send karega client tak
        Runnable r2=()->{
            System.out.println("Write a start");
            try{
                while(!socket.isClosed())
                {
                    BufferedReader br1 = new BufferedReader(newInputstreamReader(System.in));
                    String content = br1.readLine();
                    out.println(content);
                    out.flush();
                    if(content.equals("exit")){
                        socket.close();
                        break;
                    } 
                }
            }catch(Exception e){
                System.out.println("connection closed");
            }
            System.out.println("connection closed");
        };
        new Thread(r2).start();
    }
    private Reader newInputstreamReader(InputStream in) {
        return null;
    }
    public static void main(String[] args) { 
        System.out.println("This is client...");
        new Client();
        
    } 
}
