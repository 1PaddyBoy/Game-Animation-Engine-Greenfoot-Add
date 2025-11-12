import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
//import org.bytedeco.javacpp.opencv_core.IplImage;
import org.bytedeco.javacv.*;
//import org.bytedeco.javacv.FFmpegFrameGrabber;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
//import FFmpegFrameGrabber;
//import java.io*;
/**
 * Write a description of class video here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class video extends advancedGravity
{
    /**
     * Act - do whatever the video wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     * any variable with "C" starting its comment is usually user changeable.  
     * 
     * a cool thing to try would be automatically adjusting which file type to expect
     */
    boolean stop = false; // idk dude 
    int frame = 0;//your guess is as good as mine 
    String brak = ")";//this just makes things work in the file system, usually not to change unless naming convention changes.
    long lastTime  = System.currentTimeMillis();
    long curTime  = System.currentTimeMillis();
    boolean efficency = true; //C turns on any efficiency, this does some effiency shit I don't understand, wait actually turns off gravity, buttons and other unnecessary advanced grav 
    boolean fullarray = false;//C this is almost maximum efficiency processor but stress on ram. 
    //this whole class could really benefit from a better video encoder and multithreading
    ArrayList<String> frames = new ArrayList<String>(); //this has strings of the frames
    boolean fullImageSave = true; //C this is maximum efficiency processor but LARGE stress on ram.
    boolean actAfter = true; // this not to be touched
    
    //usually just touched by constructor:
    public int x; // pos x
    public int y; //pos y 
    int xsize;//size x 
    int ysize;//size y
    boolean forceS = true; // forces image to specified size
    boolean fillScreen = false; //fills screen with image
    double framerate; // frame rate as divider of 60 
    int framerateC; //counter for framerate, not really to change
    String name;//name of the string. file?
    boolean loop = false; // if the video loops
    int percentage = 100; // size percentage 
    boolean scaleBpercentage; // scale force background percentage
    String uponEnd = ""; // this calls to call something after ending 
    ArrayList<GreenfootImage> fullImage = new ArrayList<GreenfootImage>();//where all full images are stored
    boolean useVideo = true;
    //frame rate is FPS
    //brak = ")"
    GreenfootSound audio; // where audio is set 
    boolean actAfter2 = true;
    int ab = 0; // does act after stuff for reasons
    /**
     * this just sets some stuff up the first act after construction.
     */
    public void actAfterSetUp2()
    {
        //System.out.println("act after set up before test " + ab);
        if(ab <= 2)
        {
            System.out.println("act after set up tried");
            if(audio != null)
                audio.playLoop(); // plays audio, handels both loop and not
            insertFrames();
            ab++;
            
        }
        super.actAfterSetUp();
    }
    /**
     * most of this is about finding the file 
     */
    public void act()
    {
        //System.out.println("video act");
        //interacting
        actAfterSetUp2();
        
        
        curTime  = System.currentTimeMillis();
        while(curTime < lastTime + framerate - 10 * (23.943 - 23.809523809))//timing offset for accurate measurements on fps
        {
            curTime  = System.currentTimeMillis();
        }
        
        if(curTime >= lastTime + framerate - 10 * (23.943 - 23.809523809))
        {
            System.out.println("target FPS is " + (1000 / framerate) + " current frameRate is " + ((double)1000/ (curTime - lastTime) + "    frame = " + frame));
            //System.out.println("frame test jpg, new pic = "+name+formatNumber(frame,forceDigit)+brak+".jpg");
                lastTime = System.currentTimeMillis();
            if(audio != null && !audio.isPlaying())
            {
                audio.playLoop();
                //System.out.println("audio replaying, audio = " + audio);
            }
            //framerateC = 0;
            
            if(!efficency && !preloadB)
            {
                if(!stop)
                {
                    //System.out.println("nonefficent part");
                    //System.out.println("no preloading at all used");
                    try
                    {
                        //Dancing Roach Autotune [HD Remaster] - Extended Cut [MConverter.eu]\
                        setImage(name+formatNumber(frame,forceDigit)+brak+".jpg"); 
                        //System.out.println("picture changed png, new pic = "+name+formatNumber(frame,forceDigit)+brak+".jpg");
                        
                        frame ++;
                    }
                    catch (java.lang.IllegalArgumentException iae)
                    {
                        try
                        {
                            setImage(name+formatNumber(frame,forceDigit)+brak+".png"); 
                             
                            //System.out.println("picture changed png, new pic = "+name+formatNumber(frame,forceDigit)+brak+".png");
                            frame ++;
                        }catch(java.lang.IllegalArgumentException iaee)
                        {
                            try
                            {
                                setImage(name+formatNumber(frame,forceDigit)+brak+".GIF"); 
                                frame ++;
                            }catch(java.lang.IllegalArgumentException iaeee)
                            {
                                
                                ending();
                                return;
                            }
                        }
                        
                    }
                }
                
                if(forceS)
                {
                    getImage().scale(xsize, ysize);
                    //System.out.println("resized");
                }
                if(scaleBpercentage)
                {
                    getImage().scale(getImage().getWidth() * percentage,getImage().getHeight() * percentage);
                    //System.out.println("resized");
                }
                if(fillScreen)
                {
                    getImage().scale(getWorld().getWidth(), getWorld().getHeight());
                    //System.out.println("resized");
                }
                
            } else
            {
                System.out.println("efficiency tried");
                if(fullImageSave || preloadB){
                if(frame < frames.size())
                {
                    if(fullImageSave && !preloadB)
                    {
                        setImage(fullImage.get(frame));
                        System.out.println("full image used");
                    }else if (preloadB)
                    {
                        setImage(preload.get(frame));
                        System.out.println("preloadB used");
                    }else{
                        
                        GreenfootImage b = new GreenfootImage(frames.get(frame));
                        if(forceS)
                        {
                            b.scale(xsize, ysize);
                            //System.out.println("resized");
                        }
                        if(scaleBpercentage)
                        {
                            b.scale(getImage().getWidth() * percentage,getImage().getHeight() * percentage);
                            //System.out.println("resized");
                        }
                        if(fillScreen)
                        {
                            b.scale(getWorld().getWidth(), getWorld().getHeight());
                            //System.out.println("resized");
                        }
                        setImage(b);
                        System.out.println("just strings used");
                    }
                    
                    frame++;
                    
                }else
                {
                    ending();
                    System.out.println("video ended");
                }
            } else if(useVideo)
            {
                
            }
            }
            framerateC ++;
            
            //System.out.println("stop is :" + stop + " loop is: " + loop + " frame is:" + frame);
        }else
        {
            System.out.println("video, non max utilization");
        }
        if(!efficency)
        {
            MyWorld myworld = (MyWorld)getWorld();
            if(myworld.running == true)
            {
                if(fixedVGravity == true)
                {
                    gravityNoMove();
                }
                //movingWorld();
            }
            buttonworks();
        }
    }
    
    /**
     * this is called when video ends from the ending and audio forced to stop
     */
    public void videoEnd()
    {
        //System.out.println("auio stop attempted first" + audio);
        if(audio != null && audio.isPlaying())
        {
            audio.stop();
            //System.out.println("auio stop attempted " + audio);
        }
    }
    //afterV syntax, [(video name),(after change usually 0), (after),(force digit Num)]
    /**
     * called when the video ends to handel ending procedure 
     */
    private void ending()
    {
                    //this part does repeat
                    if(audio != null)
                    {
                        audio.stop();
                        audio = null;
                    }
                    if(!loop)
                    {
                        preload = new ArrayList<GreenfootImage>();
                        fullImage = new ArrayList<GreenfootImage>();
                        frames = new ArrayList<String>();
                        stop = true;
                        
                        if(world)
                        {
                            if(!afterVideo)
                            { 
                                ((MyWorld)getWorld()).videoEnd(after);
                            }else
                            {
                                ((MyWorld)getWorld()).playVideo(afterV[0],afterV[1],afterV[2],23.943,Integer.parseInt(afterV[3]),false);
                                //"video/1 Opening Animated Sequence-20240422T200952Z-001Resize/OpeningAnimatedSequence","","menu1",23.943,3,false);
                            }
                        }
                           //getWorld().removeObject(this); 
                        
                    }
                    //System.out.println("no picture found");
                    if(loop)
                    {
                        frame = 1;
                    }else
                    {
                        // other ending other goes here
                        //getWorld().videoEndcode(uponEnd);
                        
                        
                        
                        
                        
                    }
    }
    
    /**
     * sets audio.
     */
    public void setAudio(GreenfootSound audio)
    {
        this.audio = audio;
    }
    
    int forceDigit = -1;// idk dude, probably don't touch it, maybe for when multiple zeros in sequence ie 0001  
    /**
     * formats the number for the file names
     */
    public static String formatNumber(int number, int forceDigit) {
        if(forceDigit != -1)
        {
            // Create a format string with the specified number of zeros
            String format = "%0" + forceDigit + "d";
            // Return the formatted string
            return String.format(format, number);
        }else
        {
            return "" + number;
        }
    }
    GreenfootImage test = new GreenfootImage("download(6).jpeg");
    /**
     * inserts frames as loaded or partial loaded or whatnot
     */
    public void insertFrames()
    {
        
        boolean errored = false;
        System.out.println("frame insert tried " + efficency);
        if(efficency && useVideo)
        {
            //FFmpegFrameGrabber frameGrabber = new FFmpegFrameGrabber(name + ".mp4");
            
        }else if(efficency && !preloadB)
        {
            while(!errored)
            {
                GreenfootImage a = new GreenfootImage("smiley5.png");
                    System.out.println("frames inserting" + ((double)frame/(963))*100 + "%");
                    try{
                        a = new GreenfootImage(name+formatNumber(frame,forceDigit)+brak+".png");
                        frames.add(name+formatNumber(frame,forceDigit)+brak+".png");
                    }catch(java.lang.IllegalArgumentException iae)
                    {
                        try{
                            a = new GreenfootImage(name+formatNumber(frame,forceDigit)+brak+".jpg");
                            frames.add(name+formatNumber(frame,forceDigit)+brak+".jpg");
                        }catch(java.lang.IllegalArgumentException iaee )
                        {
                            errored = true;
                                System.out.println("frames done, size frames = " + frames.size());
                            try
                            {
                                a = new GreenfootImage(name+formatNumber(frame,forceDigit)+brak+".jpeg");
                                frames.add(name+formatNumber(frame,forceDigit)+brak+".jpeg");
                            }catch(java.lang.IllegalArgumentException iaeee)
                            {
                                errored = true;
                                System.out.println("frames done, size frames = " + frames.size());
                                //break;
                                
                            }
                        }
                    }
                    try{
                        if(fullImageSave && !preloadB)
                        {
                            if(forceS)
                            {
                                a.scale(xsize, ysize);
                                //System.out.println("resized");
                            }
                            if(scaleBpercentage)
                            {
                                a.scale(getImage().getWidth() * percentage,getImage().getHeight() * percentage);
                                //System.out.println("resized");
                            }
                            if(fillScreen)
                            {
                                a.scale(getWorld().getWidth(), getWorld().getHeight());
                                //System.out.println("resized");
                            }
                            fullImage.add(a);
                        }else
                        {
                            
                        }
                    }catch(Exception e)
                    {
                        fullImageSave = false;
                        System.out.println("full image save auto disabled because of error ");
                    }
                    a = null;
                    /*if(!a.equals(test))
                    {
                        if(forceS)
                        {
                            a.scale(xsize, ysize);
                            System.out.println("resized");
                        }
                        if(scaleBpercentage)
                        {
                            //a.scale(a.getWidth() * percentage,a.getHeight() * percentage);
                            System.out.println("resized");
                        }
                        if(fillScreen)
                        {
                            a.scale(750, 500);
                            System.out.println("resized");
                        }
                        //frames.add(a);
                    }*/
                frame++;
            }
            System.out.println("frames adding done, outside while");
        }
        frame = 0;
        
    }
    
    //below all constructor bullshit 
    public video(int x, int y, int xsize, int ysize,double framerate, String name, boolean forceS, boolean fillScreen,boolean scaleBpercentage, boolean loop, int percentage)
    {
        this.x = x;
        this.y = y;
        this.xsize = xsize;
        this.ysize = ysize;
        this.framerate = 1000 / framerate;
        this.name = name + " (";
        this.forceS = forceS;
        this.fillScreen = fillScreen;
       // setImage(name + ".png");
       advancedAnimation = false;
       this.loop = loop;
       this.percentage = percentage;
       this.scaleBpercentage = scaleBpercentage;
       colAdd.add(StickMan2.class);
    }
    
    public boolean world;
    public String after;
    public video(int x, int y, int xsize, int ysize,double framerate, String name, boolean forceS, boolean fillScreen,boolean scaleBpercentage, boolean loop, int percentage, boolean world,String after)
    {
        this.x = x;
        this.y = y;
        this.xsize = xsize;
        this.ysize = ysize;
        this.framerate = 1000/ framerate;
        this.name = name + " (";
        this.forceS = forceS;
        this.fillScreen = fillScreen;
       // setImage(name + ".png");
       advancedAnimation = false;
       this.loop = loop;
       this.percentage = percentage;
       this.scaleBpercentage = scaleBpercentage;
       colAdd.add(StickMan2.class);
       this.world = world;
       this.after = after;
    }
    //boolean forceDigitB;
    
    public video(int x, int y, int xsize, int ysize,double framerate, String name, boolean forceS, boolean fillScreen,boolean scaleBpercentage, boolean loop, int percentage, boolean world,String after,String brak, int forceDigit)
    {
        this.forceDigit = forceDigit;
        this.brak = brak;
        this.x = x;
        this.y = y;
        this.xsize = xsize;
        this.ysize = ysize;
        this.framerate = 1000/ framerate;
        this.name = name /*+ " ("*/;
        this.forceS = forceS;
        this.fillScreen = fillScreen;
       // setImage(name + ".png");
       advancedAnimation = false;
       this.loop = loop;
       this.percentage = percentage;
       this.scaleBpercentage = scaleBpercentage;
       colAdd.add(StickMan2.class);
       this.world = world;
       this.after = after;
       insertFrames();
    }
    boolean afterVideo = false;
    String[] afterV;
    public video(int x, int y, int xsize, int ysize,double framerate, String name, boolean forceS, boolean fillScreen,boolean scaleBpercentage, boolean loop, int percentage, boolean world,String[] after,String brak, int forceDigit)
    {
        this.forceDigit = forceDigit;
        this.brak = brak;
        this.x = x;
        this.y = y;
        this.xsize = xsize;
        this.ysize = ysize;
        this.framerate = 1000/ framerate;
        this.name = name /*+ " ("*/;
        this.forceS = forceS;
        this.fillScreen = fillScreen;
       // setImage(name + ".png");
       advancedAnimation = false;
       this.loop = loop;
       this.percentage = percentage;
       this.scaleBpercentage = scaleBpercentage;
       colAdd.add(StickMan2.class);
       this.world = world;
       //this.after = after;
       afterVideo = true;
       afterV = after;
       insertFrames();
    }
    ArrayList<GreenfootImage> preload;
    boolean preloadB = false;
    public video(int x, int y, int xsize, int ysize,double framerate, String name, boolean forceS, boolean fillScreen,boolean scaleBpercentage, boolean loop, int percentage, boolean world,String after,String brak, int forceDigit, ArrayList<GreenfootImage> preload)
    {
        this.forceDigit = forceDigit;
        this.brak = brak;
        this.x = x;
        this.y = y;
        this.xsize = xsize;
        this.ysize = ysize;
        this.framerate = 1000/ framerate;
        this.name = name /*+ " ("*/;
        this.forceS = forceS;
        this.fillScreen = fillScreen;
       // setImage(name + ".png");
       advancedAnimation = false;
       this.loop = loop;
       this.percentage = percentage;
       this.scaleBpercentage = scaleBpercentage;
       colAdd.add(StickMan2.class);
       this.world = world;
       this.after = after;
       insertFrames();
       this.preload = preload;
       this.preloadB = !preload.equals("-1");
       if(preloadB)
       {
            fullImageSave = true;
        }
    }
    
    /**
     * default with the name of the file
     */
    public video(String name)
    {
        //this.x = getWorld().getWidth()/2;
        //this.y = getWorld().getHeight()/2;
        this.xsize = 200;
        this.ysize = 200;
        this.framerate = 1000/ 60;
        this.name = name + " (";
        this.forceS = true;
        this.fillScreen = false;
       // setImage(name + ".png");
       advancedAnimation = false;
       this.loop = false;
       this.percentage = 0;
       this.scaleBpercentage = false;
       colAdd.add(StickMan2.class);
       insertFrames();
    }
}
