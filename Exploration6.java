package explorePack;

import java.awt.*;
import java.awt.event.*;
import java.io.*;


public class Sound extends Frame implements ActionListener, WindowListener
{
    

    private static final long serialVersionUID = 1;
    
    
    
    public final int c0=48, d0=50, e0=52, f0=53, g0=55, a0=57, b0=59,
            c =60, d =62, e =64, f =65, g =67, a =69, b =71,
            c1=72, d1=74, e1=76, f1=77, g1=79, a1=81, b1=83,
            c2=84, rest=0;
    
    public static void main(String [] args)
    {
    	new Sound().setVisible(true);
    }
    
    public void score()
    {
        
    	play(c, 4);
    	
    	play(c, 4);
    }

    


    
    static int sharp(int x)
    {
        return x+1;
    }
    static int flat(int x)
    {
        return x-1;
    }
    static int high(int x)
    {
        return x+12;
    }
    static int low(int x)
    {
        return x-12;
    }


    


    TextField filenameText, tpqText, slope, yAxis;
    Button    genButton;
    Label     messageLabel;

    
    
    final byte NoteOn = (byte) 144;
    final byte NoteOff = (byte) 128;
    final byte defaultVolume = (byte) 100;
    final int  defaultTPQ = 480;

    int timeSinceLastNote;
    int tpq;

    ByteArrayOutputStream track;




    public Sound()
    {
        this.setSize(400,400);
        this.setTitle("Midi file generator");
        
    	
    	//creates button object
    	//Button button = new Button("Submit");
    	
    	//creates panel objects
    	
    	
        
        filenameText = new TextField("music.midi", 20 );
        tpqText      = new TextField(defaultTPQ+"", 5 );
        genButton    = new Button("Generate");
        messageLabel = new Label("enter file name and press button");

        this.setLayout(new FlowLayout());
        this.add( new Label("Filename:") );
        this.add( filenameText );
        this.add( new Label("ticks per quart:") );
        this.add( tpqText );
        this.add( genButton );
        System.out.println("hi");
        
        this.add( messageLabel );
        genButton.addActionListener(this);
        this.addWindowListener(this);

        track = new ByteArrayOutputStream();
        
       
    }

    public void actionPerformed(ActionEvent ae)
    {
    	System.out.println("hi");
        if (ae.getSource()==genButton)
        {
        	
            messageLabel.setText("generating track");
            track.reset();
            tpq = Integer.parseInt(tpqText.getText());
            timeSinceLastNote = 0;
           
            System.out.println("hi");

            try
            {
                messageLabel.setText("writing file");
                System.out.println("hi");
                DataOutputStream data;
                data = new DataOutputStream(new FileOutputStream(filenameText.getText()));
                
            	score();
                data.writeBytes("MThd");
                data.writeInt(6);
                data.writeInt(1);
                data.writeShort((short)defaultTPQ);
                data.writeBytes("MTrk");
                data.writeInt( track.size() + 4);
                data.write( track.toByteArray() );
                data.writeInt(16723712);
                data.close();

                
            	//points.xArray.add(100);
            	//points.print();
            	
                messageLabel.setText("file written!");
            }
            catch (Exception e)
            {
                messageLabel.setText("error writing file: " + e);
                System.out.println(e);
            }
        }
    }

    void play(int pitch, double duration)
    {
        int durat;
        durat = (int)(duration*tpq/4);

        if (pitch==0)
            timeSinceLastNote += durat;
        else
        {
            sendLength(timeSinceLastNote);
            sendByte( NoteOn );
            sendByte( (byte) pitch );
            sendByte( defaultVolume );

            sendLength(durat);
            sendByte( NoteOff );
            sendByte( (byte) pitch );
            sendByte( defaultVolume );
            timeSinceLastNote = 0;
        }
    }

    void sendLength(int x)
    {
        if (x>=2097152)
        {
            sendByte((byte)(128+x/2097152));
            x %= 2097152;
        }
        if (x>=16384)
        {
            sendByte((byte)(128+x/16384));
            x %= 16384;
        }
        if (x>=128)
        {
            sendByte((byte)(128+x/128));
            x %= 128;
        }
        sendByte( (byte)x );
    }

    void sendByte(byte b)
    {
        track.write(b);
    }

    public void windowClosing (WindowEvent e)
    {   System.exit(0);
    }
    public void windowClosed     (WindowEvent e) {}
    public void windowOpened     (WindowEvent e) {}
    public void windowIconified  (WindowEvent e) {}
    public void windowDeiconified(WindowEvent e) {}
    public void windowActivated  (WindowEvent e) {}
    public void windowDeactivated(WindowEvent e) {}
}
