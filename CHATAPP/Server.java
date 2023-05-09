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
public class Server extends JFrame
{    
    ServerSocket server;
    Socket socket;
    BufferedReader br;
    PrintWriter out;
    //delcare components
    private JLabel heading = new JLabel("Server Area");
    private JTextArea messageArea = new JTextArea();
    private JTextField messageInput = new JTextField();
    private Font font = new Font("Roboto",Font.PLAIN,20);
    //Constructor..
    public Server()
    {
      try{
            server =  new ServerSocket(7778);
            System.out.println(" is ready to accept connection");
            System.out.println("waiting...");
            socket = server.accept();
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream());
            createGUI();
            handleEvents();
            startReading();
            // startWriting();
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    private void handleEvents() {
        messageInput.addKeyListener((KeyListener) new KeyListener(){

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
                //System.out.println("Key released "+e.getKeyCode());
                if(e.getKeyChar()==10)
                {
                    //System.out.println("you have pressed enter button");
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
        //gui code..
        this.setTitle("Server Message[END]");
        this.setSize(600,600);
		getContentPane().setBackground(new Color(128, 255, 255));

        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //coding for component
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
        //frame ka Layout set karanga
        this.setLayout(new BorderLayout());
        //adding the components frame
        this.add(heading,BorderLayout.NORTH);
        JScrollPane jScrollPane=new JScrollPane(messageArea);
        this.add(jScrollPane, BorderLayout.CENTER);
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
                        System.out.println("Client termiated the chat");
                        JOptionPane.showMessageDialog(this,"Client Terminated the chat");
                        messageInput.setEnabled(false);
                        socket.close();
                        break;
                    }
                    //System.out.println("Client : "+msg);
                    messageArea.append("Client : "+msg+"\n");
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
        System.out.print("This is server...going to start server");
        new Server();
    }
}