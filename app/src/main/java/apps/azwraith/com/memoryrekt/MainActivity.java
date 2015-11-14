package apps.azwraith.com.memoryrekt;

import android.content.Intent;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import android.os.Handler;


public class MainActivity extends AppCompatActivity {

    //declarations and init
    public int currentimage2index=0;
    public int lives_counter = 3;
    ImageView border_img;
    ImageView hero_p;
    TextView skill;
    ImageView circle;
    TextView countd;
    public int test=0;
    public int test2 = 0;
    CountDownTimer ct;
    ScrollView scroll;
    private RelativeLayout main_layout;
    private LinearLayout verticalOuterLayout2;
    private ScrollView verticalScrollView2;
    private ScrollView modeScrollView;
    private LinearLayout verticalOuterLayout;
    private ScrollView verticalScrollview;
    private TableLayout table_mode;
    private TableRow table_mode_row2;
    private int verticalScrollMax;
    private Timer scrollTimer		=	null;
    private TimerTask clickSchedule;
    private TimerTask scrollerSchedule;
    private TimerTask faceAnimationSchedule;
    private int scrollPos =	0;
    private Boolean isFaceDown      =   true;
    private Timer clickTimer		=	null;
    private Timer faceTimer         =   null;
    private ImageView clickedButton    =   null;
    private ImageView clickedButton2 = null;
    private ImageView lives_count;
    private TextView lives_text;
    private ImageView level1;



    TextView[] views =  new TextView[3];







    String[] levels = {"1.Beginner", "2.Casual", "3.Intermediate", "4.Enthusiast", "5.Expert", "6.Professional"};
    String[] SKILLS1_NAME = {"Storm Hammer", "Fissure", "X Marks the Spot", "Avalanche", "Toss", "Power Cogs", "Rocket Flare",
            "Hookshot", "Purification", "Repel", "Acid Spray", "Greevil's Greed", "Burning Spear", "Tether",
            "Hoofstomp", "Stampede", "Ice shards", "Snowball", "Walrus PUNCH!", "Duel", "Battle Hunger", "Culling Blade",
            "Meat Hook", "Rot", "Burrowstrike", "Sand storm", "Epicenter", "Amplify Damage", "Ravage",
            "Reincarnation", "Charge of Darkness", "Doom", "Tombstone", "Reverse Polarity", "Borrowed Time",
            "Blink", "Frost Arrows", "Healing ward", "Omnislash", "Smoke screen", "Permanent Invisibility",
            "Shrapnel", "Headshot", "Take Aim", "Assasinate", "Eclipse", "Shuriken toss",
            "Track", "Song of the siren", "Thirst", "Rupture", "Shadowraze", "Necromastery",
            "Backtrack", "Chronosphere", "Stifling dagger", "Blur", "Poof", "Pounce", "Frostbite",
            "Dream coil", "Ball lightning", "Shackleshot", "Powershot", "Thundergod's wrath",
            "Laguna blade", "Hex", "Mass serpent ward", "Shackles", "Laser", "March of the machines",
            "Rearm", "Sprout", "Teleportation", "Global silence", "Multicast", "Spell steal",
            "Glimpse", "Chakra magic", "Ice armor", "Sacrifice", "Finger of death", "Hex", "Mana drain", "Death ward",
            "Black hole", "Heartstopper Aura", "Blink", "Exorcism", "Shallow grave", "Ion shell", "Vacuum",
            "Cold feet", "Cold snap", "Exort", "Ghost walk", "Invoke", "Quas", "Sunstrike", "Wex"};

    int[] SKILLS1_IDS = {R.drawable.hammer, R.drawable.fissure, R.drawable.xmark, R.drawable.avalanche, R.drawable.toss, R.drawable.cogs, R.drawable.flare,
            R.drawable.hookshot, R.drawable.purification, R.drawable.repel, R.drawable.spray, R.drawable.greed, R.drawable.spear, R.drawable.tether,
            R.drawable.stomp, R.drawable.stampede, R.drawable.shards, R.drawable.snowball, R.drawable.punch, R.drawable.duel, R.drawable.hunger, R.drawable.culling,
            R.drawable.hook, R.drawable.rot, R.drawable.burrow, R.drawable.sandstorm, R.drawable.epicenter, R.drawable.amplify, R.drawable.ravage,
            R.drawable.reincarnation, R.drawable.charge, R.drawable.doom_, R.drawable.tomb, R.drawable.reverse, R.drawable.borrowed,
            R.drawable.blink, R.drawable.frost, R.drawable.healing, R.drawable.slash, R.drawable.smoke, R.drawable.inv,
            R.drawable.shrapnel, R.drawable.headshot, R.drawable.take, R.drawable.assas, R.drawable.eclipse, R.drawable.shuriken,
            R.drawable.track, R.drawable.song, R.drawable.thirst, R.drawable.rupture, R.drawable.shadowrage, R.drawable.necromastery,
            R.drawable.backtrack, R.drawable.chrono, R.drawable.dagger, R.drawable.blur, R.drawable.poof, R.drawable.pounce, R.drawable.frostbite,
            R.drawable.coil, R.drawable.ball, R.drawable.shackleshot, R.drawable.powershot, R.drawable.thunder,
            R.drawable.laguna, R.drawable.hex, R.drawable.mass, R.drawable.shackles, R.drawable.laser, R.drawable.march,
            R.drawable.rearm, R.drawable.sprout, R.drawable.teleportation, R.drawable.silence, R.drawable.multicast, R.drawable.steal,
            R.drawable.glimpse, R.drawable.magic, R.drawable.armor_lich, R.drawable.sacrifice, R.drawable.finger, R.drawable.hex_lion, R.drawable.drain, R.drawable.death_w,
            R.drawable.black, R.drawable.heartstopper, R.drawable.blink_qop, R.drawable.exorcism, R.drawable.grave, R.drawable.ion, R.drawable.vacuum,
            R.drawable.cold, R.drawable.snap, R.drawable.exort, R.drawable.ghost, R.drawable.invoke, R.drawable.quas, R.drawable.sun, R.drawable.wex};

    int[] IMAGE_IDS = {R.drawable.earthshaker, R.drawable.sven, R.drawable.tiny,
            R.drawable.kunkka, R.drawable.beastmaster, R.drawable.dragon_knight, R.drawable.clockwerk, R.drawable.omniknight, R.drawable.huskar, R.drawable.alchemist, R.drawable.brewmaster, R.drawable.treant_protecter, R.drawable.wisp, R.drawable.centaur_warrunner, R.drawable.timbersaw, R.drawable.bristleback, R.drawable.tusk, R.drawable.elder_titan};
    int[] IMAGE_IDS2 = {R.drawable.legion_commander, R.drawable.earth_spirit, R.drawable.phoenix,
            R.drawable.axe, R.drawable.pudge, R.drawable.sand_king, R.drawable.slardar, R.drawable.tidehunter, R.drawable.wraith_king, R.drawable.lifestealer, R.drawable.night_stalker, R.drawable.doom, R.drawable.spirit_breaker, R.drawable.lycan, R.drawable.chaos_knight, R.drawable.undying, R.drawable.magnus, R.drawable.abaddon};
    int[] IMAGE_IDS3 = {R.drawable.anti_mage, R.drawable.drow_ranger, R.drawable.juggernaut,
            R.drawable.mirana, R.drawable.morphling, R.drawable.phantom_lancer, R.drawable.vengeful_spirit, R.drawable.riki, R.drawable.sniper, R.drawable.templar_assassin, R.drawable.luna, R.drawable.bounty_hunter, R.drawable.ursa, R.drawable.gyrocopter, R.drawable.lone_druid, R.drawable.naga_siren, R.drawable.troll_warlord, R.drawable.ember_spirit};
    int[] IMAGE_IDS4 = {R.drawable.bloodseeker, R.drawable.shadow_fiend, R.drawable.razor,
            R.drawable.venomancer, R.drawable.faceless_void, R.drawable.phantom_assassin, R.drawable.viper, R.drawable.clinkz, R.drawable.broodmother, R.drawable.weaver, R.drawable.spectre, R.drawable.meepo, R.drawable.nyx_assassin, R.drawable.slark, R.drawable.medusa, R.drawable.terrorblade, R.drawable.crystal_maiden, R.drawable.puck};
    int[] IMAGE_IDS5 = {R.drawable.storm_spirit, R.drawable.windranger, R.drawable.zeus,
            R.drawable.lina, R.drawable.shadow_shaman, R.drawable.tinker, R.drawable.enchantress, R.drawable.jakiro, R.drawable.chen, R.drawable.silencer, R.drawable.ogre_magi, R.drawable.rubick, R.drawable.disruptor, R.drawable.keeper_of_the_light, R.drawable.skywrath_mage, R.drawable.oracle, R.drawable.techies};
    int[] IMAGE_IDS6 = {R.drawable.bane, R.drawable.lich, R.drawable.lion,
            R.drawable.witch_doctor, R.drawable.enigma, R.drawable.necrophos, R.drawable.warlock, R.drawable.queen_of_pain, R.drawable.death_prophet, R.drawable.pugna, R.drawable.dazzle, R.drawable.leshrac, R.drawable.dark_seer, R.drawable.batrider, R.drawable.ancient_apparition, R.drawable.invoker, R.drawable.obsidian_destroyer, R.drawable.shadow_demon, R.drawable.visage, R.drawable.winter_wyvern};
    private ImageView img2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        main_layout = (RelativeLayout)findViewById(R.id.main_l);
        img2 = (ImageView) findViewById(R.id.imageView);
        img2.setBackgroundResource(R.drawable.dota_play);
        border_img = (ImageView) findViewById(R.id.intro);
        hero_p = (ImageView) findViewById(R.id.hero_portrait);
        skill = (TextView) findViewById(R.id.what_skill);
        countd = (TextView) findViewById(R.id.timer);
        circle = (ImageView) findViewById(R.id.countdown);
        scroll = (ScrollView) findViewById(R.id.scrollv);
        verticalOuterLayout = (LinearLayout)findViewById(R.id.vertical_outer_layout_id);
        verticalScrollview = (ScrollView) findViewById(R.id.vertical_scrollview_id);
        verticalOuterLayout2 = (LinearLayout)findViewById(R.id.vertical_outer_layout_id2);
        verticalScrollView2 = (ScrollView)findViewById(R.id.vertical_scrollview_id2);
        views[0] = (TextView)findViewById(R.id.ability1);
        views[1] = (TextView)findViewById(R.id.ability2);
        views[2] = (TextView)findViewById(R.id.ability3);
        modeScrollView = (ScrollView)findViewById(R.id.modescroll);
        table_mode = (TableLayout)findViewById(R.id.tablemode);
        table_mode_row2 = (TableRow)findViewById(R.id.rowmode2);
        lives_count = (ImageView)findViewById(R.id.lives);
        lives_text = (TextView)findViewById(R.id.lives_text);
        level1 = (ImageView)findViewById(R.id.level1);


        border_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                border_img.setBackgroundResource(R.drawable.whatsthatskill_final_clicked);
                table_mode_row2.setBackgroundColor(Color.WHITE);
            }
        });
        for(int ic = 1; ic <=5; ic++)
        {
            addImagesToView();
        }

        ViewTreeObserver vto = verticalOuterLayout.getViewTreeObserver();
        vto.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                modeScrollView.scrollTo(0, modeScrollView.getBottom()/2);
                if (android.os.Build.VERSION.SDK_INT < 16) {
                    verticalOuterLayout.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                } else {
                    verticalOuterLayout.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                }
                getScrollMaxAmount();
                startAutoScrolling();
            }
        });



    }





    public void onClick2(View v)
    {
        finish();
        System.exit(0);
    }

    public void onClick3(View v)
    {
        Intent quitIntent = new Intent(Intent.ACTION_MAIN);
        quitIntent.addCategory(Intent.CATEGORY_HOME);
        quitIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(quitIntent);
    }







    public void onClick(View v) {

        main_layout.setBackgroundResource(R.drawable.sf);
        img2.setBackgroundResource(R.drawable.playc);
        modeScrollView.setVisibility(View.GONE);
        scroll.setVisibility(View.VISIBLE);




    }

    public void onClickLevel(View v)
    {
        main_layout.setBackgroundResource(R.drawable.axe_w);
        scroll.setVisibility(View.GONE);
        hero_p.setVisibility(View.VISIBLE);
        skill.setVisibility(View.VISIBLE);
        countd.setVisibility(View.VISIBLE);
        circle.setVisibility(View.VISIBLE);
        views[0].setVisibility(View.VISIBLE);
        views[1].setVisibility(View.VISIBLE);
        views[2].setVisibility(View.VISIBLE);
        lives_count.setVisibility(View.VISIBLE);
        lives_text.setVisibility(View.VISIBLE);
        portrait();

    }

    public void portrait() {

        ct = new CountDownTimer(50000, 1000) {

            public void onTick(long millisUntilFinished) {
                countd.setText("" + millisUntilFinished / 1000);
            }

            public void onFinish() {
                countd.setText("");
                portrait();
            }
        }.start();

        hero_p.setImageResource(SKILLS1_IDS[currentimage2index % SKILLS1_IDS.length]);

        test = 1;
        Random r = new Random();
        int random = r.nextInt(3);
        Random r2 = new Random();

        if(lives_counter==3)
        {
            lives_count.setImageResource(R.drawable.lives3);
        }
        else if(lives_counter==2)
        {
            lives_count.setImageResource(R.drawable.lives2);
        }
        else
        {
            lives_count.setImageResource(R.drawable.lives1);
        }


        views[random].setVisibility(View.VISIBLE);
        views[random].setText(SKILLS1_NAME[currentimage2index % SKILLS1_NAME.length]);

        views[random].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(), "Correct!", Toast.LENGTH_SHORT).show();
                currentimage2index++;
                ct.cancel();
                portrait();
            }
        });


        for(TextView vz : views)
        {
            if(vz != views[random])
            {


                int random2 = r2.nextInt(SKILLS1_NAME.length);
                if(SKILLS1_NAME[random2] != SKILLS1_NAME[currentimage2index % SKILLS1_NAME.length])
                {
                    vz.setVisibility(View.VISIBLE);
                    vz.setText(SKILLS1_NAME[random2]);

                }
            }
        }

        for(int itest=0; itest<=2; itest++)
        {
          if(views[itest] != views[random])
          {
              views[itest].setOnClickListener(new View.OnClickListener() {
                  @Override
                  public void onClick(View v) {
                      Toast.makeText(getBaseContext(), "Try Again!", Toast.LENGTH_SHORT).show();
                      lives_counter--;
                      if (lives_counter == 3) {
                          lives_count.setImageResource(R.drawable.lives3);
                      } else if (lives_counter == 2) {
                          lives_count.setImageResource(R.drawable.lives2);
                      } else {
                          lives_count.setImageResource(R.drawable.lives1);


                      }
                  }
              });
          }
        }



        currentimage2index++;


    }

        public void onClick5(View v)
    {


    }



    public void addImagesToView(){



        int i =0;
        while(i<IMAGE_IDS.length){
            final ImageView img = new ImageView(this);
            img.setImageResource(IMAGE_IDS[i]);
            img.setTag(i);
            img.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View arg0) {
                    if(isFaceDown){
                        if(clickTimer!= null){
                            clickTimer.cancel();
                            clickTimer			=	null;
                        }
                        clickedButton			=	(ImageView)arg0;
                        stopAutoScrolling();
                        clickedButton.startAnimation(scaleFaceUpAnimation());
                        clickedButton.setSelected(true);
                        clickTimer				=	new Timer();

                        if(clickSchedule != null) {
                            clickSchedule.cancel();
                            clickSchedule = null;
                        }

                        clickSchedule = new TimerTask(){
                            public void run() {
                                startAutoScrolling();
                            }
                        };

                        clickTimer.schedule( clickSchedule, 1500);
                    }
                }
            });

            LinearLayout.LayoutParams params 	=	new LinearLayout.LayoutParams(150,150);
            img.setLayoutParams(params);
            verticalOuterLayout.addView(img);
            i++;
        }
            i=0;

        while(i<IMAGE_IDS2.length){
            final ImageView img = new ImageView(this);
            img.setImageResource(IMAGE_IDS2[i]);
            img.setTag(i);
            img.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View arg0) {
                    if(isFaceDown){
                        if(clickTimer!= null){
                            clickTimer.cancel();
                            clickTimer			=	null;
                        }
                        clickedButton			=	(ImageView)arg0;
                        stopAutoScrolling();
                        clickedButton.startAnimation(scaleFaceUpAnimation());
                        clickedButton.setSelected(true);
                        clickTimer				=	new Timer();

                        if(clickSchedule != null) {
                            clickSchedule.cancel();
                            clickSchedule = null;
                        }

                        clickSchedule = new TimerTask(){
                            public void run() {
                                startAutoScrolling();
                            }
                        };

                        clickTimer.schedule( clickSchedule, 1500);
                    }
                }
            });

            LinearLayout.LayoutParams params 	=	new LinearLayout.LayoutParams(150,150);
            img.setLayoutParams(params);
            verticalOuterLayout.addView(img);
            i++;
        }
            i=0;

        while(i<IMAGE_IDS3.length){
            final ImageView img = new ImageView(this);
            img.setImageResource(IMAGE_IDS3[i]);
            img.setTag(i);
            img.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View arg0) {
                    if(isFaceDown){
                        if(clickTimer!= null){
                            clickTimer.cancel();
                            clickTimer			=	null;
                        }
                        clickedButton			=	(ImageView)arg0;
                        stopAutoScrolling();
                        clickedButton.startAnimation(scaleFaceUpAnimation());
                        clickedButton.setSelected(true);
                        clickTimer				=	new Timer();

                        if(clickSchedule != null) {
                            clickSchedule.cancel();
                            clickSchedule = null;
                        }

                        clickSchedule = new TimerTask(){
                            public void run() {
                                startAutoScrolling();
                            }
                        };

                        clickTimer.schedule( clickSchedule, 1500);
                    }
                }
            });

            LinearLayout.LayoutParams params 	=	new LinearLayout.LayoutParams(150,150);
            img.setLayoutParams(params);
            verticalOuterLayout.addView(img);
            i++;
        }

        i=0;

        while(i<IMAGE_IDS4.length){
            test2 = 1;
            final ImageView img = new ImageView(this);
            img.setImageResource(IMAGE_IDS4[i]);
            img.setTag(i);
            img.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View arg0) {
                    if(isFaceDown){
                        if(clickTimer!= null){
                            clickTimer.cancel();
                            clickTimer			=	null;
                        }
                        clickedButton			=	(ImageView)arg0;
                        stopAutoScrolling();
                        clickedButton.startAnimation(scaleFaceUpAnimation());
                        clickedButton.setSelected(true);
                        clickTimer				=	new Timer();

                        if(clickSchedule != null) {
                            clickSchedule.cancel();
                            clickSchedule = null;
                        }

                        clickSchedule = new TimerTask(){
                            public void run() {
                                startAutoScrolling();
                            }
                        };

                        clickTimer.schedule( clickSchedule, 1500);
                    }
                }
            });

            LinearLayout.LayoutParams params 	=	new LinearLayout.LayoutParams(150,150);
            img.setLayoutParams(params);
            verticalOuterLayout2.addView(img);
            i++;
        }

            i =0;

        while(i<IMAGE_IDS5.length){
            test2 = 1;
            final ImageView img = new ImageView(this);
            img.setImageResource(IMAGE_IDS5[i]);
            img.setTag(i);
            img.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View arg0) {
                    if(isFaceDown){
                        if(clickTimer!= null){
                            clickTimer.cancel();
                            clickTimer			=	null;
                        }
                        clickedButton		=	(ImageView)arg0;
                        stopAutoScrolling();
                        clickedButton.startAnimation(scaleFaceUpAnimation());
                        clickedButton.setSelected(true);
                        clickTimer				=	new Timer();

                        if(clickSchedule != null) {
                            clickSchedule.cancel();
                            clickSchedule = null;
                        }

                        clickSchedule = new TimerTask(){
                            public void run() {
                                startAutoScrolling();
                            }
                        };

                        clickTimer.schedule( clickSchedule, 1500);
                    }
                }
            });

            LinearLayout.LayoutParams params 	=	new LinearLayout.LayoutParams(150,150);
            img.setLayoutParams(params);
            verticalOuterLayout2.addView(img);
            i++;
        }

        i=0;

        while(i<IMAGE_IDS6.length){
            test2=1;
            final ImageView img = new ImageView(this);
            img.setImageResource(IMAGE_IDS6[i]);
            img.setTag(i);
            img.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View arg0) {
                    if(isFaceDown){
                        if(clickTimer!= null){
                            clickTimer.cancel();
                            clickTimer			=	null;
                        }
                        clickedButton2			=	(ImageView)arg0;
                        stopAutoScrolling();
                        clickedButton2.startAnimation(scaleFaceUpAnimation());
                        clickedButton2.setSelected(true);
                        clickTimer				=	new Timer();

                        if(clickSchedule != null) {
                            clickSchedule.cancel();
                            clickSchedule = null;
                        }

                        clickSchedule = new TimerTask(){
                            public void run() {
                                startAutoScrolling();
                            }
                        };

                        clickTimer.schedule( clickSchedule, 1500);
                    }
                }
            });

            LinearLayout.LayoutParams params 	=	new LinearLayout.LayoutParams(150,150);
            img.setLayoutParams(params);
            verticalOuterLayout2.addView(img);
            i++;
        }

    }

    public void getScrollMaxAmount(){
        int actualWidth = (verticalOuterLayout.getMeasuredHeight()-(256*3));
        verticalScrollMax   = actualWidth;
    }


    public void startAutoScrolling(){
        if (scrollTimer == null) {
            scrollTimer					=	new Timer();
            final Runnable Timer_Tick 	= 	new Runnable() {
                public void run() {
                    moveScrollView();
                }
            };

            if(scrollerSchedule != null){
                scrollerSchedule.cancel();
                scrollerSchedule = null;
            }
            scrollerSchedule = new TimerTask(){
                @Override
                public void run(){
                    runOnUiThread(Timer_Tick);
                }
            };

            scrollTimer.schedule(scrollerSchedule, 30, 30);
        }
    }


    public void moveScrollView(){
            scrollPos = (int) (verticalScrollview.getScrollY() + 1.0);
            verticalScrollview.scrollTo(0, scrollPos);
            Log.e("moveScrollView", "moveScrollView");

            scrollPos = (int) (verticalScrollView2.getScrollY() + 1.0);
            verticalScrollView2.scrollTo(0, scrollPos);
            Log.e("moveScrollView", "moveScrollView");

    }


    public void stopAutoScrolling(){
        if (scrollTimer != null) {
            scrollTimer.cancel();
            scrollTimer	=	null;
        }
    }

    public Animation scaleFaceUpAnimation(){
        Animation scaleFace = new ScaleAnimation(1.0f, 1.2f, 1.0f, 1.2f, Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
        scaleFace.setDuration(500);
        scaleFace.setFillAfter(true);
        scaleFace.setInterpolator(new AccelerateInterpolator());
        Animation.AnimationListener	scaleFaceAnimationListener = new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation arg0) {
                isFaceDown = false;
            }
            @Override
            public void onAnimationRepeat(Animation arg0) {}
            @Override
            public void onAnimationEnd(Animation arg0) {
                if(faceTimer != null){
                    faceTimer.cancel();
                    faceTimer = null;
                }

                faceTimer = new Timer();
                if(faceAnimationSchedule != null){
                    faceAnimationSchedule.cancel();
                    faceAnimationSchedule = null;
                }
                faceAnimationSchedule = new TimerTask() {
                    @Override
                    public void run() {
                        faceScaleHandler.sendEmptyMessage(0);
                    }
                };

                faceTimer.schedule(faceAnimationSchedule, 750);
            }
        };
        scaleFace.setAnimationListener(scaleFaceAnimationListener);
        return scaleFace;
    }

    private Handler faceScaleHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            if(clickedButton.isSelected() == true)
                clickedButton.startAnimation(scaleFaceDownAnimation(500));
        }
    };

    public Animation scaleFaceDownAnimation(int duration){
        Animation scaleFace = new ScaleAnimation(1.2f, 1.0f, 1.2f, 1.0f, Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
        scaleFace.setDuration(duration);
        scaleFace.setFillAfter(true);
        scaleFace.setInterpolator(new AccelerateInterpolator());
        Animation.AnimationListener	scaleFaceAnimationListener = new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation arg0) {}
            @Override
            public void onAnimationRepeat(Animation arg0) {}
            @Override
            public void onAnimationEnd(Animation arg0) {
                isFaceDown = true;
            }
        };
        scaleFace.setAnimationListener(scaleFaceAnimationListener);
        return scaleFace;
    }

    public void onBackPressed(){
        super.onBackPressed();
    }

    public void onPause() {
        super.onPause();
    }

    public void onDestroy(){
        clearTimerTaks(clickSchedule);
        clearTimerTaks(scrollerSchedule);
        clearTimerTaks(faceAnimationSchedule);
        clearTimers(scrollTimer);
        clearTimers(clickTimer);
        clearTimers(faceTimer);

        clickSchedule         = null;
        scrollerSchedule      = null;
        faceAnimationSchedule = null;
        scrollTimer           = null;
        clickTimer            = null;
        faceTimer             = null;

        super.onDestroy();
    }

    private void clearTimers(Timer timer){
        if(timer != null) {
            timer.cancel();
            timer = null;
        }
    }

    private void clearTimerTaks(TimerTask timerTask){
        if(timerTask != null) {
            timerTask.cancel();
            timerTask = null;
        }
    }

}




