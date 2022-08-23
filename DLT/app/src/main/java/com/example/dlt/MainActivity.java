package com.example.dlt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.IOException;
import java.net.Socket;
import java.util.HashMap;
import com.google.gson.GsonBuilder;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {
    PrintWriter out;

    String prop=null;
    String clothes=null;
    String foreground=null;
    String mask=null;
    String background=null;

    Socket socket ;

    Button btnProp;
    Button btnClothes;
    Button btnForeground;
    Button btnMask;
    Button btnBackground;

    int count = 0 ;
    int countProp = 0 ;
    int countClothes = 0 ;
    int countForeground = 0 ;
    int countMask = 0 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViewElement();

        connect();

        btnBackground.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (count == 0) {
                    background = "down.jpg";
                    count++;
                } // if()
                else if (count == 1) {
                    background = "gym.jpg";
                    count++;
                } // else if()
                else if (count == 2) {
                    background = "playground.jpg";
                    count++;
                } // else if()
                else if (count == 3) {
                    background = "room.jpg";
                    count++;
                } // else if()
                else if (count == 4) {
                    background = "theater.jpg";
                    count++;
                } // else if()
                else if (count == 5) {
                    background = "treewalk.jpg";
                    count++;
                } // else if()
                else if (count == 6) {
                    background = "up.jpg";
                    count++;
                } // else if()
                else if (count == 7) {
                    background = "worldend.jpg";
                    count = 0 ;
                } // else if()

                SendMessage(setMaterialMsg()); // 連線成功更換背景
            }
        });

        btnProp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (countProp == 0) {
                    prop = "babyball.png";
                    countProp++;
                } // if()
                else if (countProp == 1) {
                    prop = "banana.png";
                    countProp++;
                } // else if()
                else if (countProp == 2) {
                    prop = "baseball.png";
                    countProp++;
                } // else if()
                else if (countProp == 3) {
                    prop = "gun.png";
                    countProp++;
                } // else if()
                else if (countProp == 4) {
                    prop = "microphone.png";
                    countProp++;
                } // else if()
                else if (countProp == 5) {
                    prop = "people1.png";
                    countProp++;
                } // else if()
                else if (countProp == 6) {
                    prop = "pudding.png";
                    countProp++;
                } // else if()
                else if (countProp == 7) {
                    prop = "watermelon.png";
                    countProp = 0 ;
                } // else if()

                SendMessage(setMaterialMsg()); // 連線成功更換背景
            }
        });

        btnClothes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (countClothes == 0) {
                    clothes = "Hakuho_body.png";
                    countClothes++;
                } // if()
                else if (countClothes == 1) {
                    clothes = "howl.png";
                    countClothes++;
                } // else if()
                else if (countClothes == 2) {
                    clothes = "kingdress.png";
                    countClothes++;
                } // else if()
                else if (countClothes == 3) {
                    clothes = "mom.png";
                    countClothes++;
                } // else if()
                else if (countClothes == 4) {
                    clothes = "skelon_bond.png";
                    countClothes++;
                } // else if()
                else if (countClothes == 5) {
                    clothes = "sport_clothes.png";
                    countClothes++;
                } // else if()
                else if (countClothes == 6) {
                    clothes = "vest.png";
                    countClothes++;
                } // else if()
                else if (countClothes == 7) {
                    clothes = "whitesuit.png";
                    countClothes = 0 ;
                } // else if()

                SendMessage(setMaterialMsg()); // 連線成功更換背景
            }
        });

        btnForeground.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (countForeground == 0) {
                    foreground = "anywheredoor.png";
                    countForeground++;
                } // if()
                else if (countForeground == 1) {
                    foreground = "box.png";
                    countForeground++;
                } // else if()
                else if (countForeground == 2) {
                    foreground = "catbus.png";
                    countForeground++;
                } // else if()
                else if (countForeground == 3) {
                    foreground = "fatcat.png";
                    countForeground++;
                } // else if()
                else if (countForeground == 4) {
                    foreground = "fire.png";
                    countForeground++;
                } // else if()
                else if (countForeground == 5) {
                    foreground = "newbed.png";
                    countForeground++;
                } // else if()
                else if (countForeground == 6) {
                    foreground = "zenbo1.png";
                    countForeground++;
                } // else if()
                else if (countForeground == 7) {
                    foreground = "椰子.png";
                    countForeground = 0 ;
                } // else if()

                SendMessage(setMaterialMsg()); // 連線成功更換背景
            }
        });

        btnMask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (countMask == 0) {
                    mask = "5566.png";
                    countMask++;
                } // if()
                else if (countMask == 1) {
                    mask = "deer.png";
                    countMask++;
                } // else if()
                else if (countMask == 2) {
                    mask = "gdchen.png";
                    countMask++;
                } // else if()
                else if (countMask == 3) {
                    mask = "kitty.png";
                    countMask++;
                } // else if()
                else if (countMask == 4) {
                    mask = "mask6.png";
                    countMask++;
                } // else if()
                else if (countMask == 5) {
                    mask = "pika.png";
                    countMask++;
                } // else if()
                else if (countMask == 6) {
                    mask = "zihat.png";
                    countMask++;
                } // else if()
                else if (countMask == 7) {
                    mask = "無臉男.png";
                    countMask = 0 ;
                } // else if()

                SendMessage(setMaterialMsg()); // 連線成功更換背景
            }
        });

    }


    private void initViewElement() {
        btnProp = (Button) findViewById(R.id.btnProp);
        btnClothes = (Button) findViewById(R.id.btnClothes);
        btnForeground = (Button) findViewById(R.id.btnForeground);
        btnMask = (Button) findViewById(R.id.btnMask);
        btnBackground = (Button) findViewById(R.id.btnBackground);

    } // initViewElement()


    public void connect() {
        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                try {
                    socket = new Socket("192.168.56.1", 8002);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        };

        Thread thread = new Thread(runnable1);
        thread.start();
    }

    // Send Message
    public void SendMessage(final String msg) {

        Runnable runnable2 = new Runnable () {
            @Override
            public void run() {

                try {
                    out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
                    out.println(msg);
                    Log.d("socket", msg);
                } // try
                catch (IOException e) {
                    e.printStackTrace();
                }
            } // run()

        };

        Thread thread2 = new Thread(runnable2);

        thread2.start();

    } // sendMessage()

    private String setMaterialMsg() {
        HashMap<String, Object> attribute = new HashMap<String, Object>();
        attribute.put("instruction", "Scene");
        HashMap<String, Object> materials = new HashMap<String, Object>();
        materials.put("background", background==null?null:background); // 背景
        materials.put("foreground", foreground==null?null:foreground); // 前景
        materials.put("prop", prop==null?null:prop); // 道具
        materials.put("clothes", clothes==null?null:clothes); // 衣服
        materials.put("mask", mask==null?null:mask); // 面具
        materials.put("shift_x", 80.0);
        materials.put("shift_y", 80.0);
        materials.put("scale", 1.0);
        materials.put("puppet", null);
        attribute.put("material", materials);
        Log.e("hahatest", new GsonBuilder().create().toJson(attribute));
        return new GsonBuilder().create().toJson(attribute);

    } // setMaterialMsg()

}