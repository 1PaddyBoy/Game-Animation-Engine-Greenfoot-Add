import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Random;
import java.util.ArrayList;
/**
 * The Stickman world. Very simple; just place a stickman.
 * 
 * @author mik
 * @version 1.0
 */
public class MyWorld extends World
{
    public boolean paused = false;
    public static boolean running = true;
    boolean alreadyrunf = false;
    long lastAdded = System.currentTimeMillis();
    long lastAdded2 = System.currentTimeMillis();
    long curTime = System.currentTimeMillis();
    long endtime = 3600;//how long the acheivments stay on screen.
    long endtime2 = 10000;//how long the acheivments stay on screen.
    private boolean heightA = false;
    String acheiveD = "";
    private boolean heightRe = false;
    private boolean heightAHold = false;
    public static double movementspeed = 1; 
    boolean linearG = false;
    
    boolean advancedAn = true;
    
    boolean[] achievements = new boolean[7];
    int earnedA = 0;
    
    //game 1 stuff 
    boolean oneactive = false;
    boolean G1directions = false;
    
    //game 2 stuff
    
    boolean twoactive = false;
    
    
    //game 3 stuff
        boolean threeactive = false;
    
    //game 4 stuff
    boolean fouractive = false;
    
    
    
    //game 5 stuff 
    boolean fiveactive = false;
    
    
    
        //game 6 stuff:
    boolean sixactive = false;
    
    
    //game 7 stuff 
    boolean sevenactive = false;
    boolean G7directions = false;
    
       boolean beginanimation = true;
    long curTimet; 
    long lastTimet = System.currentTimeMillis();
    long framerateT = 1000/40;
       
        boolean firstAnDone = false;
    //GreenfootSound openingS = new GreenfootSound("OpeningAnimatedSequence_audio.wav");
    
    int direction = 0;
    int amp = 5;
    int downward = 1;
    int lineamount = 1;
    int startyup = 10;
    int starty = 200;
    int startx = 200;
    public void dodirection()
    {
        if(Greenfoot.isKeyDown("right"))
            {
                direction--;    
            }
        if(Greenfoot.isKeyDown("left"))
        {
                direction++;
        }
        /*List<Integer> x = new ArrayList<Integer>();
        List<Integer> y = new ArrayList<Integer>();
        List<Integer> r = new ArrayList<Integer>();
        
        x.append(0);
        y.append(starty);
        r.append(Math.sin(0));
        while( y.get(y.length() - 1) > 0)
        {
            int a = x.get(x.length() - 1);
            x.append(x.get(x.length() - 1) + 1);
            y.append((int) (-downward* a * a + amp* Math.sin(Math.toRadians(direction))* a + starty));
            r.append((int) (-downward*a + amp* Math.sin(Math.toRadians(direction)) ));
            
        }
        for(int i = 0; i < x.length(); i++ )
        {
            //line line = new line();
            //line.setRotation(r.get(i));
            //addObject(line,x.get(i),y.get(i));
        }*/
    }
    /**
     * Constructor for objects of class MyWorld.
     */
    public void act()
    {
            
            dodirection();
            if(running)
            {
                curTimet = System.currentTimeMillis();
                while(curTimet < lastTimet + framerateT)
                {
                    curTimet = System.currentTimeMillis();
                }
                //System.out.println("action target FPS is " + (1000 / framerateT) + " current frameRate is " + ((double)1000/ (curTimet - lastTimet) ));
                lastTimet = System.currentTimeMillis();
                
                curTime = System.currentTimeMillis();
                if(lastAdded + 30 < curTime)
                {
                    if(heightB() == true && heightAHold == false)
                    {
                        heightA = true;
                        heightAHold = true;
                    }
                }
                if(heightA == true)
                {
                    lastAdded = System.currentTimeMillis();
                    acheiveD = "Acheivement Unlocked: Threw object very very high";
                    heightRe = true;
                    heightA = false;
                    
                }
                if(heightRe == true)
                {
                    if(lastAdded + endtime2 < curTime)
                    {
                        heightRe = false;
                        acheiveD = "";
                    }
                }
                
                //System.out.println(sevenactive);
                //System.out.println(fouractive + " " + running);
                if(oneactive && running)
                {
                    G1act();
                }else if(twoactive && running)
                {
                    
                    G2act();
                }else if(threeactive && running)
                {
                    G3act();
                } else if(fouractive && running)
                {
                    G4act();
                }else if(fiveactive && running)
                {
                    G5act();
                }else if(sixactive && running)
                {
                    G6act();
                }else if(sevenactive && running)
                {
                    //System.out.println("G7 act is run or something");
                    G7act();
                }
                 
                
                
                
                if((oneactive || twoactive || threeactive || fouractive || fiveactive || sixactive || sevenactive) && getObjects(slider.class).size() <= 0)
                {
                    //sliderAdd();
                    //sliderUpdate(0);
                }
                
                
            }
            videoPlay();
            
    }
    /*public void ////makecoin()//keeping but will need to be changed significantly
    {
        removeObjects(getObjects());
        GreenfootImage a = new GreenfootImage("coins/TopBar_coinbag_plain.png");
                    switch(earnedA)
       {

                        case 1:
                            a = new GreenfootImage("coins/TopBar_coinbag_1.png");
                            break;
                        case 2:
                            a = new GreenfootImage("coins/TopBar_coinbag_2.png");
                            break;
                        case 3:
                            a = new GreenfootImage("coins/TopBar_coinbag_3.png");
                            break;
                        case 4:
                            a = new GreenfootImage("coins/TopBar_coinbag_4.png");
                            break;
                        case 5:
                            a = new GreenfootImage("coins/TopBar_coinbag_5.png");
                            break; 
                        case 6:
                            a = new GreenfootImage("coins/TopBar_coinbag_6.png");
                            break;
                        case 7:
                            a = new GreenfootImage("coins/TopBar_coinbag_7.png");
                            break;
                    }
                    achievement ach =  new achievement(50,50,"","achievements",a);
                    addObject(ach,625,40);
    }*/
    boolean animationplaying = false;
    public void videoPlay()
    {
        if(animationplaying == true)
        {
        
        }
    }
    String videofileName;
    String after; 
    double framerate; 
    String audio;
    boolean animationSaved;
    int forceDigit;
    public void animationSave(String fileName, String after, double framerate,int forceDigit, String audio)
    {
        animationSaved = true;
        this.videofileName = fileName;
        this.after = after;
        this.framerate = framerate;
        this.audio = audio;
        this.forceDigit = forceDigit;
    }
    public void animationLoad()
    {
        animationSaved = false;
        //System.out.println("loaded animation now playing, = " + videofileName);
        playVideo(videofileName,"",after,framerate,forceDigit,false,audio);
    }
    public void playVideo(String fileName, String after, double framerate)
    {
        //decloration ref: public video(int x, int y, int xsize, int ysize,int framerate, String name, boolean forceS, boolean fillScreen,boolean scaleBpercentage, boolean loop, int percentage, boolean World)
        //System.out.println("video play start");
        pause();
        
        video video = new video(750/2,500/2, 0, 0, framerate, fileName, false, true,false,false,1,true,after);
        addObject(video,750/2,500/2);
        animationplaying = true;
        plaVideo2();
    }
    public void playVideo(String fileName,String NameBack, String after, double framerate)
    {
        //decloration ref: public video(int x, int y, int xsize, int ysize,int framerate, String name, boolean forceS, boolean fillScreen,boolean scaleBpercentage, boolean loop, int percentage, boolean World)
        pause();
        video video = new video(750/2,500/2, 0, 0,  framerate, fileName, false, true,false,false,1,true,after);
        addObject(video,750/2,500/2);
        animationplaying = true;
        plaVideo2();
    }
    public void playVideo(String fileName,String NameBack, String after, double framerate, int forceDigit)
    {
        //decloration ref: public video(int x, int y, int xsize, int ysize,int framerate, String name, boolean forceS, boolean fillScreen,boolean scaleBpercentage, boolean loop, int percentage, boolean World, int force digits for ending number)
        pause();
        video video = new video(750/2,500/2, 0, 0,  framerate, fileName, false, true,false,false,1,true,after,NameBack, forceDigit);
        addObject(video,750/2,500/2);
        animationplaying = true;
        plaVideo2();
    }
    public void playVideo(String fileName,String NameBack, String after, double framerate, int forceDigit, boolean fillScreen)
    {
        //decloration ref: public video(int x, int y, int xsize, int ysize,int framerate, String name, boolean forceS, boolean fillScreen,boolean scaleBpercentage, boolean loop, int percentage, boolean World, int force digits for ending number)
        pause();
        
        video video = new video(750/2,500/2, 0, 0,  framerate, fileName, false, fillScreen,false,false,1,true,after,NameBack, forceDigit);
        addObject(video,750/2,500/2);
        animationplaying = true;
        plaVideo2();
        
    }
    public void playVideo(String fileName,String NameBack, String[] after, double framerate, int forceDigit, boolean fillScreen)
    {
        //decloration ref: public video(int x, int y, int xsize, int ysize,int framerate, String name, boolean forceS, boolean fillScreen,boolean scaleBpercentage, boolean loop, int percentage, boolean World, int force digits for ending number)
        pause();
        video video = new video(750/2,500/2, 0, 0,  framerate, fileName, false, fillScreen,false,false,1,true,after,NameBack, forceDigit);
        addObject(video,750/2,500/2);
        animationplaying = true;
        plaVideo2();
        //addObject(new home(50,40,"home","menu"),50,40);
    }
    public void playVideo(String fileName,String NameBack, String after, double framerate, int forceDigit, boolean fillScreen, GreenfootSound audio)
    {
        //decloration ref: public video(int x, int y, int xsize, int ysize,int framerate, String name, boolean forceS, boolean fillScreen,boolean scaleBpercentage, boolean loop, int percentage, boolean World, int force digits for ending number)
        pause();
        video video = new video(750/2,500/2, 0, 0,  framerate, fileName, false, fillScreen,false,false,1,true,after,NameBack, forceDigit);
        video.setAudio(audio);
        addObject(video,750/2,500/2);
        animationplaying = true;
        plaVideo2();
        //addObject(new home(50,40,"home","menu"),50,40);
    }
   
     
    public void playVideo(String fileName,String NameBack, String after, double framerate, int forceDigit, boolean fillScreen, String audio)
    {
        //decloration ref: public video(int x, int y, int xsize, int ysize,int framerate, String name, boolean forceS, boolean fillScreen,boolean scaleBpercentage, boolean loop, int percentage, boolean World, int force digits for ending number)
        pause();
        if(after.substring(after.length() -1).equals("C"))
            {
                //playVideo("video/achievement/GameAchievement","",after.substring(0,after.length()-2) + "A",23.976,2,false,"GameAchievement_sound.mp3");
                animationSave(fileName,after.substring(0,after.length()-1),framerate,forceDigit,audio);
                videobackgroundOverRide = true;
                playVideo("video/achievement/GameAchievement","","asdfasdf",23.947,2,false,"GameAchievement_sound.mp3");
                setPaintOrder(video.class);
                videobackgroundOverRide = false;
                GreenfootImage a = new GreenfootImage("video/achievement/GameAchievement00.png");
                a.scale(750,500);
                setBackground(a);
                //////makecoin();//This will need to be returned and updated if coins are readded.
            }else
            {
                video video = new video(750/2,500/2, 0, 0,  framerate, fileName, false, fillScreen,false,false,1,true,after,NameBack, forceDigit);
                addObject(video,750/2,500/2);
                video.setAudio(new GreenfootSound(audio));
                animationplaying = true;
                plaVideo2();
                //Greenfoot.playSound(audio);
            }
        //addObject(new home(50,40,"home","menu"),50,40);
    }
    boolean videobackgroundOverRide;
    public void playVideo(String fileName,String NameBack, String after, double framerate, int forceDigit, boolean fillScreen, ArrayList<GreenfootImage> a)
    {
        //decloration ref: public video(int x, int y, int xsize, int ysize,int framerate, String name, boolean forceS, boolean fillScreen,boolean scaleBpercentage, boolean loop, int percentage, boolean World, int force digits for ending number)
        pause();
        video video = new video(750/2,500/2, 0, 0,  framerate, fileName, false, fillScreen,false,false,1,true,after,NameBack, forceDigit,a);
        addObject(video,750/2,500/2);
        animationplaying = true;
        plaVideo2();
    }
    
    public void plaVideo2()
    {
        //goal c = new goal("idkman");
        //c.setImage("video/1 Opening Animated Sequence-20240422T200952Z-001Resize/OpeningAnimatedSequence000.jpg");
        //c.getImage().scale(750,500);
        //addObject(c,750/2,500/2);
        if(videobackgroundOverRide == false)
        {
            setBackground("video/1 Opening Animated Sequence-20240422T200952Z-001Resize/OpeningAnimatedSequence000.jpg");
            setPaintOrder(video.class);
        }else
        {
            setPaintOrder(sandbox.class,video.class);
        }
    }
    //playVideo("D:\greenfoot\animation project\animation project 3-11-24\images\video\1 Opening Animated Sequence-20240422T200952Z-001\1 Opening Animated Sequence\OpeningAnimatedSequence000.jpg")
    public void videoEnd(String after)
    {
        unpause();
        animationplaying = false;
        if(animationSaved)
        {
            animationLoad();
        }else
        {
            if(after.equals("vid2G1"))
            {
                //System.out.println("attempts to play 2nd in line sequence");
                if(linearG)
                {
                    playVideo("video/animated2/AnimatedSequence2","","G1",23.973,3,false,"AnimatedSequence2_audio.wav");
                }
                vid2G1 = false;
                return;
            }else if(false)
            {
            
            }
             if(after.substring(after.length() -1).equals("A"))
            {
                //////makecoin();
                reflectBS(after.substring(0,after.length()-2));
            }else if(!after.equals("menu1"))
            {
                reflectBS(after);
            }else
            {
                //System.out.println("menu start from video");
                reflectBS("menu");
            }
        }
    }
    
    
    int    g1instructions = 0;
    public void G1act()
    {
        
    }
    
    public boolean backImageFinished(int offset)
    {
        
        return false;
    }
    public void G2act()
    {
        
    }
    int G3instruction = 0;
    boolean G3Binstructions = true;
    private int G3stage = 1;
    private int G3instructions;
    private boolean spaceRe = false;
    /*List<GreenfootImage> G3images = new ArrayList<GreenfootImage>(){{
        //add();
    }};*/
    public void G3act()
    {
        
    }
    
       
    public void G3prepare(int stage)
    {
        
    }
    public void G4act()
    {
        
    }
    
    
    public void redo()
    {
        
      
    }
 
    public void G5act()
    {
        
    }
    public void G6act()
    {
        
    }
    public void G7act()
    {
        
    }
    public boolean heightB()
    {
        boolean re = false;
        for(advancedGravity ob : getObjects(advancedGravity.class))
        {
            if(ob.getExactY() < -4000)
            {
                re = true;
            }
        }
        return re;
    }

    public MyWorld()
    {    
        super(750, 500, 1,false); 
        //addObject(new StickMan2(), 375, 325);
        //sandboxprepare();
        menu();
        running = true;
        
    }
    public void menu()
    {
        for(video a : getObjects(video.class))
        {
            a.videoEnd();
        }
        //setBackground(backgroundImage());
        //sets what games to play. 
        //abcd
        
        
        for(int i = 0; i < 4; i++)//delete all the bullshit text
        {
            //int x, int y,String name, String functionN, GreenfootImage img
            showText("",150*i + 50, 200);
        }
        for(int i = 4; i < 7; i++)
        {
            //int x, int y,String name, String functionN, GreenfootImage img
            showText("",150*i + 50 - 600, 400);
        }
        
        
        
        //for (Object obj : getObjects(null)) ((Actor)obj).getImage().setTransparency(255);//hides all obje\based
        goal a = new goal("menu");
        unpause();
        GreenfootImage skfjdn = new GreenfootImage("StartScreen_landingpage.png");
        skfjdn.scale(750,500);
        a.setImage(skfjdn);
        //a.getImage().scale(1343,500);
        addObject(a,750/2,500/2);
        //addObject(new home(50,40,"home","menu"),50,40);
        ////makecoin();
        addObject(new sandbox(50,90,"sandbox","sandbox",0,new GreenfootImage("genericblank_button.png")),50,100);      
        //System.out.println("imgstuffs");
        addObject(new sandbox(150,70,"","G1",0,new GreenfootImage("Game1_GenericButton.png")),150,100);
        addObject(new sandbox(250,70,"","G2",0,new GreenfootImage("Game2_GenericButton.png")),250,100);
        addObject(new sandbox(350,70,"","G3",0,new GreenfootImage("Game3_GenericButton.png")),350,100);
        addObject(new sandbox(450,70,"","G4test",0,new GreenfootImage("Game4_GenericButton.png")),450,100);
        addObject(new sandbox(550,70,"","G5",0,new GreenfootImage("Game5_GenericButton.png")),550,100);
        addObject(new sandbox(650,70,"","G6",0,new GreenfootImage("Game6_GenericButton.png")),650,100);
        addObject(new sandbox(50,170,"","G7",0,new GreenfootImage("Game7_GenericButton.png")),50,200);
         addObject(new sandbox(250,190,"Start Story","story",0,true,new GreenfootImage("genericblank_button.png")),250,200);
         
        /*StickMan2 bunny = new StickMan2("bunny",45,50,49,-500);
        bunny.setImage("Bunny_left.png");
        bunny.getImage().scale(50,49);
        addObject(bunny,750/2,500/2);
         */
         
         
    }
    public void reflectBS(String functionN)
    {
        if(functionN != null)
        {
            for(video a : getObjects(video.class))
            {
                a.videoEnd();
            }
            clearText();
            removeObjects(getObjects(null));//removes all objects
            //addObject(new home(50,40,"home","menu"),50,40);
            ////makecoin();
        }
        if (functionN.equals("sandbox"))
        {
            sandboxprepare();
            clearText();
        }else if(functionN.equals("story"))
        {
                    playVideo("video/animated1/AnimatedSeuqence1","","vid2G1",23.973,3,false,"AnimatedSequence1_audio.wav");// this will need to be replaced with the story for that one 
                    //playVideo("video/animated5/SMansour_GameCharacterFINAL_","","G4",29.97,3,false,"animation4.mp3");
                    //reflectBS("G1");
                    vid2G1 = true;
                    
        }else if(functionN.equals("G1"))
        {
            //G1prepare();
            oneactive = true;
        }else if (functionN.equals("G2"))
        {
            //System.out.println("G2 set up");
            
            //G2prepare();
            twoactive = true;
        }else if(functionN.equals("G3"))
        {
            //System.out.println("G3 in reflectBS");
            //G3prepare();
            threeactive = true;
        }else if (functionN.equals("G4"))
        {
            //System.out.println("G4");
            //G4prepare();
            fouractive = true;
        }else if (functionN.equals("G4test"))
        {
            //n("G4test");
            //playVideo("video/animated5/SMansour_GameCharacterFINAL_","","G4",29.97,3,false,"animation4.mp3");
        }else if(functionN.equals("G5"))
        {
            //playVideo("Dancing Roach Autotune [HD Remaster] - Extended Cut [MConverter.eu]_shortened/yes","menu",30);
            //G5prepare();
            fiveactive = true;
        }else if (functionN.equals("G6"))
        {
            //G6prepare();
            sixactive = true;
            clearText();
        }else  if (functionN.equals("G7"))
        {
            //clearText();
            //G7prepare();
            sevenactive = true;
            //System.out.println("instatement" + sevenactive);
        }else if(functionN.equals("achievements"))
        {
                for(video a : getObjects(video.class))
            {
                a.videoEnd();
            }
            //achievementsPrepare();
            //achievementsActive = true;
        }else  if (functionN.equals("menu"))
        {
            //System.out.println("audio stop attempted in menu" + getObjects(video.class).size());
            for(video a : getObjects(video.class))
            {
                a.videoEnd();
            }
            menu();
            //for (Object obj : getObjects(null)) ((Actor)obj).getImage().setTransparency(255);
            //setPaintOrder(home.class,achievement.class,sandbox.class);
        }else if(functionN.equals("menuE")){ // this just sets the paint order instead Idk really why
             for(video a : getObjects(video.class))
            {
                a.videoEnd();
            }
            menu();
            //setPaintOrder(sandbox.class,goal.class);
        }
    }
    boolean achievementsActive;
    GreenfootImage done = new GreenfootImage("checkmark_button.png");
    GreenfootImage notDone = new GreenfootImage("x_button.png");
    /*public void widthScale(int width,GreenfootImage a)
    {
        a.scale(width, (int)(((double)width/a.getWidth()) * a.getHeight()));
    }*/
    public void achievementsPrepare()
    {
        //GreenfootImage one = new GreenfootImage("");
        //addObject()
        GreenfootImage skfjdn = new GreenfootImage("StartScreen_landingpage.png");
        skfjdn.scale(750,500);
        setBackground(skfjdn);
        //widthScale(75,done);
        //widthScale(75,notDone);
        for(int i = 0; i < 4; i++)
        {
            //int x, int y,String name, String functionN, GreenfootImage img
            addObject(new sandbox(150*i + 50, 200,"Game " + (i+1),"none",achievements[i] ? done : notDone),150*i + 50, 200);
        }
        for(int i = 4; i < 7; i++)
        {
            //int x, int y,String name, String functionN, GreenfootImage img
            addObject(new sandbox(150*i + 50 - 600, 400,"Game " + (i+1),"none",achievements[i] ? done : notDone),150*i + 50 - 600, 400);
        }
        
    }
    /*public void G3preapare2()
    {
        
        
    }
    public void G3prepare()
    {
        
    }
    public void display(String a )
    {
        GreenfootImage instructions = new GreenfootImage(a);
        instructions.scale(750,500);
        goal b = new goal();
        b.setImage(instructions);
        //b.getImage().scale(750,500);
        addObject(b,750/2,500/2);
    }
    private boolean finalDactive = false;
    
    
    public void G5prepare()
    {
        
    }
    
    /**
     * does stuff for pausing the game in the event of a pausescreen
     */
    public void pausescreen() //
    {
        pause();
        setBackground("download(6).jpeg");
        paused = true;
    }
    /**
     * //unpauses from the pause screen
     */
    public void unpausescreen()
    {
        unpause();
        paused = false;
    }
    /**
     * main pause function called for all pause types
     */
    public void pause() // 
    {
        for (Object obj : getObjects(null)) ((Actor)obj).getImage().setTransparency(0);
        for (Object obj : getObjects(pausebutton.class)) ((Actor)obj).getImage().setTransparency(255);
        if(running == true){alreadyrunf = true;}
        running = false;
        paused = true;
    }
    /**
     * is used for general pause ending
     */
    public void unpause() // 
    {
        setBackground("background2.jpg");
        for (Object obj : getObjects(null)) ((Actor)obj).getImage().setTransparency(255);
        if(alreadyrunf == true)
        {
            running = true;
        } 
        paused = false;
    }
    /**
     * main pause function called for all pause types
     */
    public void Rpause() // 
    {
        if(running == true){alreadyrunf = true;}
        running = false;
        paused = true;
    }
    /**
     *  is used for general pause ending
     */
    public void Runpause() //
    {
        setBackground("background2.jpg");
        for (Object obj : getObjects(null)) ((Actor)obj).getImage().setTransparency(255);
        if(alreadyrunf == true)
        {
            running = true;
        } 
        paused = false;
    }
    public void clearText()
    {
        
        //make this or fill in with common locatiosn 
    }
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    public void sandboxprepare()
    {
        addObject(new video(getWidth()/2,getHeight()/2,100,100,60,"Dancing Roach Autotune [HD Remaster] - Extended Cut [MConverter.eu]/yes",true,false,false,true,0),getWidth()/2,getHeight()/2);
        showText("Pause",100,25);
        showText("Pause Physics",120,110);
        addObject(new StickMan2(), 375, 325);
        alligatgor alligatgor = new alligatgor();
        //alligatgor.setImage( new GreenfootImage("TopBar_Homebutton.png"));
        addObject(alligatgor,70,465);
        platform platform = new platform();
        addObject(platform,567,243);
        bigplat bigplat = new bigplat();
        addObject(bigplat,636,385);
        bigplat bigplat2 = new bigplat();
        addObject(bigplat2,108,398);
        deathBall deathBall = new deathBall();
        addObject(deathBall,507,51);
        bouncyball bouncyball = new bouncyball();
        addObject(bouncyball,235,73);
        bouncyball bouncyball2 = new bouncyball();
        addObject(bouncyball2,615,50);
        pausebutton pausebutton = new pausebutton();
        addObject(pausebutton,25,34);
        Rpausebutton rpausebutton = new Rpausebutton();
        addObject(rpausebutton,29,109);
    }
    
    public void G1prepare()
    {
       
        oneactive = true;
        G1directions = true;
               //System.out.println(advancedGravity.anyfindpos(grave.class,advancedGravity.colexcept));
        //System.out.println("col except" + advancedGravity.colexcept.toString());
        showText("press space to continue",750/2,420);
    }
    public void G2prepare()
    {
        

        
    }
    public void G4prepare()
    {
        
        
    }
    public void G6prepare()
    {
        
    }
    public void G7prepare()
    {
       
    }
    
   
    
    public void G7prepare2()
    {
        
    }
    /*
    public void resetB(String use)/** I forget entirely what this was used for */
    /*{
       sandbox pl = new sandbox(50,180,"game 7",use,0,linearG);
        GreenfootImage res = new GreenfootImage("TopBar_RestartGameButton.png");
        res.scale(50,(int)(((double)50/res.getWidth()) * res.getHeight()) );
        pl.button_1 = res;
        pl.button_2 = res;
        addObject(pl,125,40); 
    }*/
    /* 
    public void sliderAdd()/**readded the slider*/
    /*{
        
        slider frame = new slider();
        frame.setImage("progress/ProgressSlider_bar.png");
        frame.getImage().scale(300,(int)(((double)300/frame.getImage().getWidth()) * frame.getImage().getHeight()));
        addObject(frame,750/2,40);
        
        moverS mover = new moverS();
        mover.setImage("progress/ProgressSlider_arrow.png");
        mover.getImage().scale((int)(((double)(frame.getImage().getHeight() * 1.2)/frame.getImage().getWidth()) * mover.getImage().getWidth()),(int)(frame.getImage().getHeight() * 1.2));
        addObject(mover,750/2 - frame.getImage().getWidth()/2 + mover.getImage().getWidth()/4,40);
        
        orangeS or = new orangeS();
        or.setImage("progress/ProgressSlider_orangefill.png");
        or.getImage().scale((int)(frame.getImage().getHeight() * 0.9),1);
        addObject(or,750/2 - frame.getImage().getWidth() + or.getImage().getWidth()/4 -1,40);
        
        setPaintOrder(video.class,moverS.class,slider.class,orangeS.class);
    }
    */
    double lastDone;
    /*public void sliderUpdate(double done)/**this updated the slider at the top to the amount that was done. some of its dependencies may be gone, idk bro figure it out */
    /*{
        if(done != lastDone)
        {
            removeObjects(getObjects(slider.class));
            slider frame = new slider();
            frame.setImage("progress/ProgressSlider_bar.png");
            frame.getImage().scale(300,(int)(((double)300/frame.getImage().getWidth()) * frame.getImage().getHeight()));
            addObject(frame,750/2,40);
            
            moverS mover = new moverS();
            mover.setImage("progress/ProgressSlider_arrow.png");
            mover.getImage().scale((int)(((double)(frame.getImage().getHeight() * 1.2)/frame.getImage().getWidth()) * mover.getImage().getWidth()),(int)(frame.getImage().getHeight() * 1.2));
            addObject(mover,750/2 - frame.getImage().getWidth()/2 + mover.getImage().getWidth()/4 +(int)( frame.getImage().getWidth() * done),40);
            
            orangeS or = new orangeS();
            or.setImage("progress/ProgressSlider_orangefill.png");
            or.getImage().scale(1+ (int)(frame.getImage().getWidth() * done) + (int)(mover.getImage().getWidth()/5),(int)(frame.getImage().getHeight() * 0.9));
            addObject(or,frame.getX() - frame.getImage().getWidth()/2 + or.getImage().getWidth()/2,40);
            
            setPaintOrder(video.class,moverS.class,slider.class,orangeS.class,Buttons.class,StickMan2.class);
            lastDone = done;
        }
    }(*/
    boolean vid2G1 = false;
    //private int G3stage;
    
    public void succeed(String a)
    {
        if(linearG)
        {
                switch(a)
            {
                case "story":
                   
                    vid2G1 = true;
                    break;
                case "G1":
                    oneactive = false;
                    
                    
                    playVideo("video/animated3/AnimatedSequence3","",achievements[0] ?"G2":"G2C",29.97,3,false,"AnimatedSequence3_audio.wav");
                    
                    earnedA += achievements[0] ? 0:1;
                    achievements[0] = true;
                    
                    break;
                    
                case "G2":
                    break;
                case "G3":
                    
                    break;
                case "G4":
                    
                    earnedA += achievements[3] ? 0:1;
                    achievements[3] = true;
                    break;    
                case "G5": 
                    
                    break;
                case "G6":
                    
                    break;
                case "G7":
                    
                    break;
            }
            
        }else//this was in case it just went back to the menu after
        {
               
            
        
            //removeObjects(getObjects(null));
            switch(a)
            {
                case "G1":
                    
                    oneactive = false;
                    
                    //playVideo("video/animated3/AnimatedSequence3","",achievements[0] ?"menu":"menuC",29.97,3,false,"AnimatedSequence3_audio.wav");
                    earnedA += achievements[0] ? 0:1;
                    achievements[0] = true;
                    break;
                case "G2":

                    break;
                case "G3":
                  
                     break;
              case "G4":

                  break;    
                case "G5":
                  
                    break;
                case "G6":
                    
                    break;
                case "G7":
                    
                    break;
            }
        }
    }
    
   
    
    public void fail(String a)
    {
        if(linearG)//this switches based on linear.
        {
            switch(a)
            {
                case "G1":
                    oneactive = false;
                    reflectBS("G1");
                    break;
                case "G2":

                     
                    break;
                case "G3":
                    
                    break;
                case "G4":
                    
                    break;    
                case "G5":

                    break;
                case "G6":
                    
                    break;
                case "G7":
                    
                    
                    break;
            }
            
        }else // this is if not linear 
        {
            // all sent back to the menu. 
            reflectBS("menu");
        
            switch(a)
            {
                case "G1":
                    oneactive = false;
                    break;
                case "G2":
                    twoactive = false;
                    break;
                case "G3":
                    threeactive = false;
                    break;
                case "G4":
                    fouractive = false;
                    break;    
                case "G5":
                    fiveactive = false;
                    break;
                case "G6":
                    sixactive = false;
                    break;
                case "G7":
                    sevenactive = false;
                    break;
            }
        }
    }
    
        
    // below is some code dumbs about at time generated cut scenes, not that important/ 
    /*
       public void eraseintrotests() //erases introduction test 
    {
        for(int i=0; i < introtextss.length; i++)
        {
            introtextss[i] = "";
        }
    }
    public void addscore(int add) //adds score by amount specified by par
    {
        score = score + add;
        showText("score:" + score, 100,20);
    }
    public void startscreensetup() //sets up the start screen 
    {
        running = false;
        startscreentext();
        addObject(new missionm() , 195 , 200);
        addObject(new infinate() , 585 , 200);
    }
    public void startscreentext() // puts some text on start scree n
    {
        showText(introtextss[0],195, 150);
        showText(introtextss[1],585,150);
        showText(introtextss[2], 390, 50);
    }
    public void missionstart() // starts mission mode and all the text and stuff that happens 
    {
        for (Object obj : getObjects(Buttons.class)) if(((Actor)obj).getClass() != pausebutton.class){removeObject(((Actor)obj));};
        running = false;
        score = 0;
        sugcoll = 1;
        showText("score:" + score, 100,20);
        showText("SugarCollect:" + sugcoll, 250, 20);
        showText("Antibodies left:"+antibodycount, 550, 20);
        gameprepare();
    }
    public void infinatestart() // starts infinate mode 
    {
        for (Object obj : getObjects(Buttons.class)) if(((Actor)obj).getClass() != pausebutton.class){removeObject(((Actor)obj));};
        running = false;
        score = 0;
        sugcoll = 1;
        showText("score:" + score, 100,20);
        showText("SugarCollect:" + sugcoll, 250, 20);
        showText("Antibodies left:"+antibodycount, 550, 20);
        gameprepare();
    }
    //string for virus explanation 
    String v0 = "Fire antibodies with b.";
    String v1 = "If enough antibodies hit a virus it will die. \n and give you a few points.";
    String v2 = "But don't let the virus hit you \nbecuase if so you will lose a lot of sugar.";
    String v3 = "You also have a limited amount of antibodies.";
    String v4 = "Run out and you may only be able to replenish later.";
    //below used for text and stuff
    //below text is for the beginning of the mission mode
    String t0 = "It seems like the body has sustained several wounds.";
    String t1 = "You must help the body fight the infection and repair the wounds.";
    String t2 = "press C to turn left, V to turn right.";
    String t3 = "Press space to direct platelets to a wound and stop it from bleeding.";
    String t4 = "Move with the arrow keys to direct the white blood cell \nto the bacteria to destroy it.";
    String t5 = "Collect different chemicals for different effects.";
    String t6 = "Sugar is a vital resource,\nit can be used to make more cells to help fight along side \nyou or repair the current ones deployed\n however, viruses touching the white blood cell \nand bacteria escaping to the rest of the body \n deminish your sugar";
    String t7 = "Run out of sugar and the cell dies ending the game.";
    String t8 = "Alcohol damages the immune system, \nslowing it down and making it less effective, avoid alcohol at all costs.";
    String t9 = "Throughout your adventure you may find cuts \nin the lining of the bloodstream";
    String t10 = "To stop the flow of foreign invaders \ndirect the platelets towards the injury";
    String t11 = "By plugging the wound the invaders are minimized \n (and a heafty amount will be added to your score and sugar as a reward.)";
    String t12 = "See how long you can survive \n or the score you can obtain during that time.";
    String t13 = "When all the cuts are plugged or you run out of platelets\nyou will return to the bonemarrow to prepare for the next mission.";
    Integer[] i = {1,0};
    List<String> begintext = new ArrayList<String>() {{
            add(t0);
            add(t1);
            add(t2);
            add(t3);
            add(t4);
            add(t5);
            add(t6);
            add(t7);
            add(t8);
            add(t9);
            add(t10);
            add(t11);
            add(v0);
            add(v1);
            add(v2);
            add(v3);
            add(v4);
        }};
    String textmovedisplay = "press the x key to continue"; // is the variable for display of continue text 
    //logic so varius repeats don't happen
    int textshow = 0;
    String tdisplayf = "0";
    boolean waspressed = false;
    boolean starttext = true;
    String begintextreal = "a";
    int sugarconsuptionrate = 600; // how often sugar is consumed by the cell naturally, divide number by 60 for approxamate time in seconds
    int sugarconsuptionhelp = 0;
    //repeat detection too 
    boolean alreadyrunf = false;
    //detects start of mission mode
    boolean missiontextstart = false;
    //strings for the welcome screen 
    String startscreentextmis = "click button to start mission mode, \n see how much score you can get \nin 1 minute(WIP)";
    String infintext = "Click this button to start infinite mode, \nsee how long you can survive \nand how much score you can obtain.";
    String introtext = "Welcome to White Blood Cell vs \na Guy Who Seems to Get Alot of Injuries";
    String[] introtextss = new String[]{startscreentextmis,infintext,introtext};
    boolean infanitetextstart = false;
    //special infinate text
    String inft1 = "In this mode the game will continue infinitely until you die. ";
    String inft2 = "See how long you can survive and how much score you can obtain.";
    //the below text controls the text for infinate mode
    boolean startcutdeadtext = false; //starts cuts initial dieing text
    List<String> infanitebegintext = new ArrayList<String>() {{
            add(inft1);
            add(inft2);
            add(t4);
            add(t5);
            add(t6);
            add(t7);
            add(t8);
            add(v0);
            add(v1);
            add(v2);
            add(v3);
            add(v4);
        }};
        
        //the below text controls text for coming across a cut. 
        String cutb1 = "Uh oh";
        String cutb2 = "It looks like you have come across a cut in the circulitory system,";
        String cutb3 = "While this is not the only one \nit is part of the reason for all these nasty \nviruses and bacteria in the body";
        String cutb4 = "Throughout your trip through the circulitory system\n you may encounter many of these cuts which will spew \nviruses and bacteria out of them";
        String cutb5 = "Use space button to direct platelets to the cut, \n the platelets will block up the cut \npreventing more nasty things from entering the body";
        String cutb6 = "(and giving you a healthy point bonance)";
        String cutb7 = "Turn the white blood cell with c and v.";
        String cutb8 = "Good luck :).";
    List<String> cuttextbegin = new ArrayList<String>() {{
            add(cutb1);
            add(cutb2);
            add(cutb3);
            add(cutb4);
            add(cutb5);
            add(cutb6);
            add(cutb7);
            add(cutb8);
        }};
        //the below text runs if you killed the cut 
        String cutf1 = "You successfully repaired the cut.";
        String cutf2 = "Good job!";
        String cutf3 = "But this will not be the only one you will find.";
    List<String> cuttextdead = new ArrayList<String>() {{
            add(cutf1);
            add(cutf2);
            add(cutf3);
        }};
        
        
        //text for if the cut passes you WIP
        String cuttd1 = "It seems like the cut survived";
        String cuttd2 = "that's ok but remember more will be coming";
        String cuttd3 = "try to block their flow for extra points";
    List<String> cuttextalivepast = new ArrayList<String>() {{
            add(cuttd1);
            add(cuttd2);
            add(cuttd3);
        }};
        //varius cut detections 
    boolean cutspawned = false;
    boolean cutdied = false;
    int cuttime = 600; // time till text after cut appears 
    boolean cutfirst = true;
    int cuttexttimer = 300;
    int cutexttimework = 0;
    boolean cutexttimestart = false;
    boolean noseccut = false;
    boolean oldcutgone = true;
    //marrow start stuff 
    boolean mismarrowready = false;
    boolean startmarrowtimer = false;
    public int antibodycount = 10;
    boolean cutallowed = false;
    boolean cutallowed2 = false;
    
    
    
    
     cutdeathtextrepeat();
        misbeginningtext(); 
        infanitebeginningtext();
        cuttext();
        //below in if all the things that happen if the world is running 
        if(running == true )
        {
            sugarconsumption();
            if( sugcoll < 1)
            {
                deathscreen();
                Greenfoot.stop();
            }
            timer();
            spawnstuff();
            
        }
       */
}
