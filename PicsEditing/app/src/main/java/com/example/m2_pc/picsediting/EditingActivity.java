package com.example.m2_pc.picsediting;

import android.app.Dialog;
import android.app.VoiceInteractor;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.ColorMatrixColorFilter;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Environment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.Toast;

import org.adw.library.widgets.discreteseekbar.DiscreteSeekBar;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EditingActivity extends AppCompatActivity {

    int[] images2 = new int[]{R.drawable.i1, R.drawable.i2, R.drawable.i3, R.drawable.i4, R.drawable.i5, R.drawable.i6, R.drawable.i7, R.drawable.i8, R.drawable.i9, R.drawable.i10,
            R.drawable.i11, R.drawable.i12, R.drawable.i13, R.drawable.i14, R.drawable.i15, R.drawable.i16, R.drawable.i17, R.drawable.i18, R.drawable.i19, R.drawable.i20,
            R.drawable.i21, R.drawable.i22, R.drawable.i23, R.drawable.i24, R.drawable.i25, R.drawable.i26, R.drawable.i27, R.drawable.i28, R.drawable.i29, R.drawable.i30,
            R.drawable.i31, R.drawable.i32, R.drawable.i33, R.drawable.i34, R.drawable.i35, R.drawable.i36, R.drawable.i37, R.drawable.i38, R.drawable.i39, R.drawable.i40,
            R.drawable.i41, R.drawable.i42, R.drawable.i43, R.drawable.i44, R.drawable.i45, R.drawable.i46, R.drawable.i47, R.drawable.i48, R.drawable.i49, R.drawable.i50,
            R.drawable.i51, R.drawable.i52, R.drawable.i53, R.drawable.i54, R.drawable.i55, R.drawable.i56, R.drawable.i57, R.drawable.i58, R.drawable.i59, R.drawable.i60,
            R.drawable.i61, R.drawable.i62, R.drawable.i63, R.drawable.i64, R.drawable.i65, R.drawable.i66, R.drawable.i67, R.drawable.i68, R.drawable.i69, R.drawable.i70,
            R.drawable.i71, R.drawable.i72, R.drawable.i73, R.drawable.i74, R.drawable.i75, R.drawable.i76, R.drawable.i77, R.drawable.i78, R.drawable.i79, R.drawable.i80,
            R.drawable.i81, R.drawable.i82, R.drawable.i83, R.drawable.i84, R.drawable.i85, R.drawable.i86, R.drawable.i87, R.drawable.i88, R.drawable.i89, R.drawable.i90,
            R.drawable.i91, R.drawable.i92, R.drawable.i93, R.drawable.i94, R.drawable.i95, R.drawable.i96, R.drawable.i97, R.drawable.i98, R.drawable.i99, R.drawable.i100,
            R.drawable.i111, R.drawable.i112, R.drawable.i113, R.drawable.i114, R.drawable.i115, R.drawable.i116, R.drawable.i117, R.drawable.i118, R.drawable.i119, R.drawable.i120,
            R.drawable.i121, R.drawable.i122, R.drawable.i123, R.drawable.i124, R.drawable.i125, R.drawable.i126, R.drawable.i127};

    int[] images = new int[]{R.drawable.a1, R.drawable.a2, R.drawable.a3, R.drawable.a4, R.drawable.a5, R.drawable.a6, R.drawable.a7, R.drawable.a8, R.drawable.a9, R.drawable.a10,
            R.drawable.a11, R.drawable.a12, R.drawable.a13, R.drawable.a14, R.drawable.a15, R.drawable.a16, R.drawable.a17, R.drawable.a18, R.drawable.a19, R.drawable.a20,
            R.drawable.a21, R.drawable.a22, R.drawable.a23, R.drawable.a24, R.drawable.a25, R.drawable.a26, R.drawable.a27, R.drawable.a28, R.drawable.a29, R.drawable.a30,
            R.drawable.a31, R.drawable.a32, R.drawable.a33, R.drawable.a34, R.drawable.a35, R.drawable.a36, R.drawable.a37, R.drawable.a38, R.drawable.a39, R.drawable.a40,
            R.drawable.a41, R.drawable.a42, R.drawable.a43, R.drawable.a44, R.drawable.a45, R.drawable.a46, R.drawable.a47, R.drawable.a48, R.drawable.a49,
            R.drawable.p1, R.drawable.p2, R.drawable.p3, R.drawable.p4, R.drawable.p5, R.drawable.p6, R.drawable.p7, R.drawable.p8, R.drawable.p9, R.drawable.p10,
            R.drawable.p11, R.drawable.p12, R.drawable.p13, R.drawable.p14, R.drawable.p15, R.drawable.p16, R.drawable.p17, R.drawable.p18, R.drawable.p19, R.drawable.p20,
            R.drawable.p21, R.drawable.p22, R.drawable.p23, R.drawable.p24, R.drawable.p25, R.drawable.p26, R.drawable.p27, R.drawable.p28, R.drawable.p29, R.drawable.p30,
            R.drawable.p31, R.drawable.p32, R.drawable.p33, R.drawable.p34, R.drawable.p35, R.drawable.p36, R.drawable.p37, R.drawable.p38, R.drawable.p39, R.drawable.p40,
            R.drawable.p41, R.drawable.p42, R.drawable.p43, R.drawable.p44, R.drawable.p45, R.drawable.p46, R.drawable.p47, R.drawable.p48, R.drawable.p49, R.drawable.p50};

    int[] ip = new int[]{R.drawable.ip1, R.drawable.ip2, R.drawable.ip3, R.drawable.ip4, R.drawable.ip5, R.drawable.ip6, R.drawable.ip7, R.drawable.ip8, R.drawable.ip9, R.drawable.ip10,
            R.drawable.ip11, R.drawable.ip12, R.drawable.ip13, R.drawable.ip14, R.drawable.ip15, R.drawable.ip16, R.drawable.ip17, R.drawable.ip18, R.drawable.ip19, R.drawable.ip20,
            R.drawable.ip21, R.drawable.ip22, R.drawable.ip23, R.drawable.ip24, R.drawable.ip25, R.drawable.ip26, R.drawable.ip27, R.drawable.ip28, R.drawable.ip29, R.drawable.ip30,
            R.drawable.ip31, R.drawable.ip32, R.drawable.ip33, R.drawable.ip34, R.drawable.ip35, R.drawable.ip36, R.drawable.ip37, R.drawable.ip38, R.drawable.ip39, R.drawable.ip40,
            R.drawable.ip41, R.drawable.ip42, R.drawable.ip43, R.drawable.ip44, R.drawable.ip45, R.drawable.ip46, R.drawable.ip47, R.drawable.ip48, R.drawable.ip49, R.drawable.ip50,
            R.drawable.ip51, R.drawable.ip52, R.drawable.ip53, R.drawable.ip54, R.drawable.ip55, R.drawable.ip56, R.drawable.ip57, R.drawable.ip58, R.drawable.ip59};

    int[] spiderman = new int[]{R.drawable.s1, R.drawable.s2, R.drawable.s3, R.drawable.s4, R.drawable.s5, R.drawable.s6, R.drawable.s7, R.drawable.s8, R.drawable.s9, R.drawable.s10,
            R.drawable.s11, R.drawable.s12, R.drawable.s13, R.drawable.s14, R.drawable.s15, R.drawable.s16, R.drawable.s17, R.drawable.s18, R.drawable.s19, R.drawable.s20,
            R.drawable.s21, R.drawable.s22, R.drawable.s23, R.drawable.s24, R.drawable.s25, R.drawable.s26, R.drawable.s27, R.drawable.s28, R.drawable.s29, R.drawable.s30,
            R.drawable.s31, R.drawable.s32, R.drawable.s33, R.drawable.s34, R.drawable.s35, R.drawable.s36, R.drawable.s37, R.drawable.s38, R.drawable.s39, R.drawable.s40,
            R.drawable.s41, R.drawable.s42, R.drawable.s43, R.drawable.s44, R.drawable.s45, R.drawable.s46, R.drawable.s47, R.drawable.s48, R.drawable.s49};

    int[] captain = new int[]{R.drawable.c1, R.drawable.c2, R.drawable.c3, R.drawable.c4, R.drawable.c5, R.drawable.c6, R.drawable.c7, R.drawable.c8, R.drawable.c9, R.drawable.c10,
            R.drawable.c11, R.drawable.c12, R.drawable.c13, R.drawable.c14, R.drawable.c15, R.drawable.c16, R.drawable.c17, R.drawable.c18, R.drawable.c19, R.drawable.c20,
            R.drawable.c21, R.drawable.c22, R.drawable.c23, R.drawable.c24, R.drawable.c25, R.drawable.c26, R.drawable.c27, R.drawable.c28, R.drawable.c29, R.drawable.c30,
            R.drawable.c31, R.drawable.c32, R.drawable.c33, R.drawable.c34, R.drawable.c35, R.drawable.c36, R.drawable.c37, R.drawable.c38, R.drawable.c39, R.drawable.c40,
            R.drawable.c41, R.drawable.c42, R.drawable.c43, R.drawable.c44, R.drawable.c45, R.drawable.c46};


    RecyclerView recyclerView;
    List<ModelData> dataList = new ArrayList<>();

    public static Bitmap bitmap;
    int bright;
    DiscreteSeekBar brigness_seek;
    ImageView image, emoji, super_hero, save, effect,text,back;
    ImageView a_emoji1,p_emoji1,ironman1,spiderman1,captain1,brigness;
    LinearLayout linear,emoji2,super_hero_view;
    public static FrameLayout frameLayout;
    public static StickerView mCurrentView;
    Animation animation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editing);

        brigness_seek = (DiscreteSeekBar)findViewById(R.id.brighness_seek);
        brigness = (ImageView)findViewById(R.id.brighness);
        ironman1 = (ImageView)findViewById(R.id.ironman);
        spiderman1 = (ImageView)findViewById(R.id.spiderman);
        captain1 = (ImageView)findViewById(R.id.captain);
        super_hero_view = (LinearLayout)findViewById(R.id.super_hero_view);
        a_emoji1 = (ImageView)findViewById(R.id.a_emoji1);
        p_emoji1 = (ImageView)findViewById(R.id.p_emoji1);
        emoji2 = (LinearLayout)findViewById(R.id.emoji2);
        back = (ImageView)findViewById(R.id.back);
        text = (ImageView)findViewById(R.id.text);
        effect = (ImageView) findViewById(R.id.efffect);
        save = (ImageView) findViewById(R.id.save);
        super_hero = (ImageView) findViewById(R.id.super_hero);
        frameLayout = (FrameLayout) findViewById(R.id.framelayout);
        linear = (LinearLayout) findViewById(R.id.linier);
        emoji = (ImageView) findViewById(R.id.emoji);
        image = (ImageView) findViewById(R.id.image);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.move_top);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        brigness.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                recyclerView.setVisibility(View.GONE);
                emoji2.setVisibility(View.GONE);
                super_hero_view.setVisibility(View.GONE);

                if (brigness_seek.getVisibility()==View.GONE)
                {
                    brigness_seek.startAnimation(animation);
                    brigness_seek.setVisibility(View.VISIBLE);
                }
                else
                {
                    brigness_seek.setVisibility(View.GONE);
                }

            }
        });

        brigness_seek.setOnProgressChangeListener(new DiscreteSeekBar.OnProgressChangeListener() {
            @Override
            public void onProgressChanged(DiscreteSeekBar seekBar, int value, boolean fromUser) {
                setBlackAndWhite(image,value+100);
                bright = (value - 5) * 20;
            }

            @Override
            public void onStartTrackingTouch(DiscreteSeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(DiscreteSeekBar seekBar) {

            }
        });

        for (int i=0 ; i<29 ; i++)
        {
            ModelData data = new ModelData();
            data.setEffect(R.drawable.harsh);
            dataList.add(data);
        }
        final effectAdapter adapter = new effectAdapter(EditingActivity.this,dataList);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(EditingActivity.this,LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);

        effect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                brigness_seek.setVisibility(View.GONE);
                emoji2.setVisibility(View.GONE);
                super_hero_view.setVisibility(View.GONE);

                if (recyclerView.getVisibility()==View.GONE)
                {
                    recyclerView.startAnimation(animation);
                    recyclerView.setVisibility(View.VISIBLE);
                }
                else
                {
                    recyclerView.setVisibility(View.GONE);
                }

            }
        });


        emoji.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                brigness_seek.setVisibility(View.GONE);
                super_hero_view.setVisibility(View.GONE);
                recyclerView.setVisibility(View.GONE);

                if (emoji2.getVisibility()==View.GONE)
                {
                    emoji2.startAnimation(animation);
                    emoji2.setVisibility(View.VISIBLE);
                }
                else
                {
                    emoji2.setVisibility(View.GONE);
                }

                a_emoji1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        final Dialog dialog1 = new Dialog(EditingActivity.this);
                        view = getLayoutInflater().inflate(R.layout.dialog_view, null, false);
                        GridView gridview1 = (GridView) view.findViewById(R.id.gridview);
                        EmojiAdapter adapter1 = new EmojiAdapter(EditingActivity.this);
                        gridview1.setAdapter(adapter1);
                        dialog1.setContentView(view);
                        dialog1.show();
                        gridview1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                addStrickerView(images2[position]);
                                dialog1.dismiss();

                            }
                        });

                    }
                });

                p_emoji1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        final Dialog dialog = new Dialog(EditingActivity.this);
                        view = getLayoutInflater().inflate(R.layout.dialog_view, null, false);
                        GridView gridview = (GridView) view.findViewById(R.id.gridview);
                        MyAdapter adapter = new MyAdapter(EditingActivity.this);
                        gridview.setAdapter(adapter);
                        dialog.setContentView(view);
                        dialog.show();
                        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                addStrickerView(images[position]);
                                dialog.dismiss();
                            }
                        });

                    }
                });

//                PopupMenu popupMenu = new PopupMenu(EditingActivity.this, emoji);
//                popupMenu.getMenuInflater().inflate(R.menu.menu_main, popupMenu.getMenu());
//                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
//                    @Override
//                    public boolean onMenuItemClick(MenuItem menuItem) {
//
//                        View view;
//                        switch (menuItem.getItemId()) {
//                            case R.id.a_emoji:
//                                break;
//
//                            case R.id.p_emoji:
//                                break;
//
//                        }
//
//                        return true;
//                    }
//                });
//                popupMenu.show();


            }
        });

//        TODO Gallary & Camera image set imageview

        if (MainActivity.a == 1) {
            image.setImageBitmap(MainActivity.bitmap1);
        } else if (MainActivity.a == 2) {
            image.setImageURI(MainActivity.imageurl);
        }

        frameLayout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (mCurrentView !=null)
                {
                    mCurrentView.setInEdit(false);
                }

                return false;
            }
        });


        super_hero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                brigness_seek.setVisibility(View.GONE);
                recyclerView.setVisibility(View.GONE);
                emoji2.setVisibility(View.GONE);

                if (super_hero_view.getVisibility()==View.GONE)
                {
                    super_hero_view.startAnimation(animation);
                    super_hero_view.setVisibility(View.VISIBLE);
                }
                else
                {
                    super_hero_view.setVisibility(View.GONE);
                }

                ironman1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        final Dialog dialog = new Dialog(EditingActivity.this);
                        view = getLayoutInflater().inflate(R.layout.dialog_view, null, false);
                        GridView gridview = (GridView) view.findViewById(R.id.gridview);
                        IpAdapter adapter = new IpAdapter(EditingActivity.this);
                        gridview.setAdapter(adapter);
                        dialog.setContentView(view);
                        dialog.show();
                        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                addStrickerView(ip[position]);
                                dialog.dismiss();
                            }
                        });

                    }
                });

                spiderman1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        final Dialog dialog1 = new Dialog(EditingActivity.this);
                        View view1 = getLayoutInflater().inflate(R.layout.dialog_view, null, false);
                        GridView gridview1 = (GridView) view1.findViewById(R.id.gridview);
                        SpAdapter adapter1 = new SpAdapter(EditingActivity.this);
                        gridview1.setAdapter(adapter1);
                        dialog1.setContentView(view1);
                        dialog1.show();
                        gridview1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                addStrickerView(spiderman[position]);
                                dialog1.dismiss();
                            }
                        });

                    }
                });

                captain1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        final Dialog dialog2 = new Dialog(EditingActivity.this);
                        View view2 = getLayoutInflater().inflate(R.layout.dialog_view, null, false);
                        GridView gridview2 = (GridView) view2.findViewById(R.id.gridview);
                        CaptainAdapter adapter2 = new CaptainAdapter(EditingActivity.this);
                        gridview2.setAdapter(adapter2);
                        dialog2.setContentView(view2);
                        dialog2.show();
                        gridview2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                addStrickerView(captain[position]);
                                dialog2.dismiss();
                            }
                        });

                    }
                });

//                PopupMenu popupMenu = new PopupMenu(EditingActivity.this, emoji);
//                popupMenu.getMenuInflater().inflate(R.menu.super_hero, popupMenu.getMenu());
//                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
//                    @Override
//                    public boolean onMenuItemClick(MenuItem menuItem) {
//
//                        switch (menuItem.getItemId()) {
//                            case R.id.ironman:
//                                break;
//
//                            case R.id.spiderman:
//                                break;
//
//                            case R.id.captain:
//
//                        }
//
//                        return true;
//                    }
//                });
//                popupMenu.show();





            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                brigness_seek.setVisibility(View.GONE);
                recyclerView.setVisibility(View.GONE);
                emoji2.setVisibility(View.GONE);
                super_hero_view.setVisibility(View.GONE);
                if (mCurrentView != null) {
                    mCurrentView.setInEdit(false);
                }

                finalEditedImage = getMainFrameBitmap(frameLayout);
//                frameLayout.setDrawingCacheEnabled(true);
//                frameLayout.buildDrawingCache();
//                bitmap = frameLayout.getDrawingCache();

                Intent intent = new Intent(EditingActivity.this,CropActivity.class);
                startActivity(intent);

            }
        });

        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                super_hero_view.setVisibility(View.GONE);
                recyclerView.setVisibility(View.GONE);

                Intent intent = new Intent(EditingActivity.this,TextActivity.class);
                startActivity(intent);

            }
        });

    }

    public static Bitmap finalEditedImage;

    private Bitmap getMainFrameBitmap(View view) {

        Bitmap bitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
        view.draw(new Canvas(bitmap));
        return bitmap;
    }

    private void setBlackAndWhite(ImageView iv, int value)
    {
        float brigtness2 = (float)(value-100);
        Effects.effectmatrix[4] = brigtness2;
        Effects.effectmatrix[9] = brigtness2;
        Effects.effectmatrix[14] = brigtness2;
        ColorFilter colorFilter = new ColorMatrixColorFilter(Effects.effectmatrix);
        iv.setColorFilter(colorFilter);
    }

    public void setEffect(int position) {
        switch (position) {

            case 0:
                Effects.applyEffectNone(image);
                break;

            case 1:
                Effects.harsh1(image);
                break;

            case 2:
                Effects.harsh2(image);
                break;

            case 3:
                Effects.harsh3(image);
                break;

            case 4:
                Effects.harsh4(image);
                break;

            case 5:
                Effects.harsh5(image);
                break;

            case 6:
                Effects.harsh6(image);
                break;

            case 7:
                Effects.applyEffect1(image);
                break;

            case 8:
                Effects.applyEffect2(image);
                break;

            case 9:
                Effects.applyEffect3(image);
                break;

            case 10:
                Effects.applyEffect4(image);
                break;

            case 11:
                Effects.applyEffect5(image);
                break;

            case 12:
                Effects.applyEffect6(image);
                break;

            case 13:
                Effects.applyEffect7(image);
                break;

            case 14:
                Effects.applyEffect8(image);
                break;

            case 15:
                Effects.applyEffect9(image);
                break;

            case 16:
                Effects.applyEffect10(image);
                break;

            case 17:
                Effects.applyEffect11(image);
                break;

            case 18:
                Effects.applyEffect12(image);
                break;

            case 19:
                Effects.applyEffect13(image);
                break;

            case 20:
                Effects.applyEffect14(image);
                break;

            case 21:
                Effects.applyEffect15(image);
                break;

            case 22:
                Effects.applyEffect16(image);
                break;

            case 23:
                Effects.applyEffect17(image);
                break;

            case 24:
                Effects.applyEffect18(image);
                break;

            case 25:
                Effects.applyEffect19(image);
                break;

            case 26:
                Effects.applyEffect20(image);
                break;

            case 27:
                Effects.applyEffect21(image);
                break;

            case 28:
                Effects.applyEffect22(image);
                break;


        }

    }





    private void addStrickerView(int sticker) {
        final StickerView stickerView = new StickerView(this);
        stickerView.setImageResource(sticker);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT);
        frameLayout.addView(stickerView, layoutParams);
        setCurrentEdit(stickerView);
        stickerView.setOperationListener(new StickerView.OperationListener() {
            @Override
            public void onDeleteClick() {
                frameLayout.removeView(stickerView);
            }

            @Override
            public void onEdit(StickerView stickerView) {
                mCurrentView.setInEdit(false);
                mCurrentView = stickerView;
                mCurrentView.setInEdit(true);
            }

            @Override
            public void onTop(StickerView stickerView) {
            }
        });
    }

    private void setCurrentEdit(final StickerView stickerView) {
        if (mCurrentView != null) {
            mCurrentView.setInEdit(false);
        }
        mCurrentView = stickerView;
        stickerView.setInEdit(true);

//        if (seekBar.getVisibility() == View.INVISIBLE) {
//            seekBar.setVisibility(View.VISIBLE);
//        }

//        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
//            @Override
//            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
//                mCurrentView.setAlpha(i);
//            }
//
//            @Override
//            public void onStartTrackingTouch(SeekBar seekBar) {
//
//            }
//
//            @Override
//            public void onStopTrackingTouch(SeekBar seekBar) {
//
//            }
//        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode==1)
        {
            Toast.makeText(this, "done", Toast.LENGTH_SHORT).show();
        }

    }
}



