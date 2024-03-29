package com.example.cognizant;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class Items extends AppCompatActivity {

    RecyclerView recycle;
    ItemAdapter itemAdapter;
    List<ModalItems> userLit;
    GridLayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_items);


        Intent intent = getIntent();
        String name = intent.getStringExtra("catname");

        if (name.equals("T-shirt")) {
            userLit = new ArrayList<>();

            recycle = findViewById(R.id.recycleview);
            layoutManager = new GridLayoutManager(this, 2);
            layoutManager.setOrientation(RecyclerView.VERTICAL);
            recycle.setLayoutManager(layoutManager);
            itemAdapter = new ItemAdapter(userLit,getApplicationContext());
            recycle.setAdapter(itemAdapter);
            itemAdapter.notifyDataSetChanged();

            userLit.add(new ModalItems("White Tshirt","Size : M \n Price : 650 Rs.",R.drawable.tshirt1));
            userLit.add(new ModalItems("yellow Tshirt", "Size : L \n Price : 500 Rs.",R.drawable.tshirt2));
            userLit.add(new ModalItems("Classic look","Size : XL \n Price : 650 Rs.", R.drawable.tshirt3));
            userLit.add(new ModalItems("Hoodie","Size : M \n Price : 450 Rs.", R.drawable.tshirt4));
            userLit.add(new ModalItems("Blue Classic","Size : S \n Price : 850 Rs.", R.drawable.tshirt5));
            userLit.add(new ModalItems("Backless red","Size : M \n Price : 950 Rs.", R.drawable.tshirt6));
            userLit.add(new ModalItems("Black lavish", "Size : L \n Price : 450 Rs.",R.drawable.tshirt7));
            userLit.add(new ModalItems("Bluish T-shirt","Size : XL \n Price : 650 Rs.", R.drawable.tshirt8));
        } else if (name.equals("Shirt")) {

            userLit = new ArrayList<>();

            recycle = findViewById(R.id.recycleview);
            layoutManager = new GridLayoutManager(this, 2);
            layoutManager.setOrientation(RecyclerView.VERTICAL);
            recycle.setLayoutManager(layoutManager);
            itemAdapter = new ItemAdapter(userLit,getApplicationContext());
            recycle.setAdapter(itemAdapter);
            itemAdapter.notifyDataSetChanged();

            userLit.add(new ModalItems("Black Shirt", "Size : M \n Price : 650 Rs.",R.drawable.shirt1));
            userLit.add(new ModalItems("Florish white shirt","Size : M \n Price : 650 Rs.", R.drawable.shirt2));
            userLit.add(new ModalItems("Denim Shirt","Size : M \n Price : 650 Rs.", R.drawable.shirt3));
            userLit.add(new ModalItems("Dotted Shirt", "Size : M \n Price : 650 Rs.",R.drawable.shirt4));
            userLit.add(new ModalItems("Pink Shirt","Size : M \n Price : 650 Rs.", R.drawable.shirt5));
            userLit.add(new ModalItems("Two-Side Shirt","Size : M \n Price : 650 Rs.", R.drawable.shirt6));
            userLit.add(new ModalItems("Red Shirt","Size : M \n Price : 650 Rs.", R.drawable.shirt7));
            userLit.add(new ModalItems("Grey Shirt","Size : M \n Price : 650 Rs.", R.drawable.shirt8));
        } else if (name.equals("Jeans")) {

            userLit = new ArrayList<>();

            recycle = findViewById(R.id.recycleview);
            layoutManager = new GridLayoutManager(this, 2);
            layoutManager.setOrientation(RecyclerView.VERTICAL);
            recycle.setLayoutManager(layoutManager);
            itemAdapter = new ItemAdapter(userLit,getApplicationContext());
            recycle.setAdapter(itemAdapter);
            itemAdapter.notifyDataSetChanged();

            userLit.add(new ModalItems("Jeans","Size : 30 \n Price : 950 Rs.", R.drawable.jeans1));
            userLit.add(new ModalItems("Lofi Jeans", "Size : 34 \n Price : 1250 Rs.",R.drawable.jeans2));
            userLit.add(new ModalItems("Blue Jeans", "Size : 32 \n Price : 750 Rs.",R.drawable.jeans3));
            userLit.add(new ModalItems("Bluish Jeans","Size : 36 \n Price : 850 Rs.", R.drawable.jeans4));
            userLit.add(new ModalItems("Latest Jeans", "Size : 30 \n Price : 950 Rs.",R.drawable.jeans5));
            userLit.add(new ModalItems("SkinTight Jeans","Size : 28 \n Price : 1150 Rs.", R.drawable.jeans6));
            userLit.add(new ModalItems("Shaded Jeans","Size : 30 \n Price : 1050 Rs.", R.drawable.jeans7));

        } else if (name.equals("Kurti")) {

            userLit = new ArrayList<>();

            recycle = findViewById(R.id.recycleview);
            layoutManager = new GridLayoutManager(this, 2);
            layoutManager.setOrientation(RecyclerView.VERTICAL);
            recycle.setLayoutManager(layoutManager);
            itemAdapter = new ItemAdapter(userLit,getApplicationContext());
            recycle.setAdapter(itemAdapter);
            itemAdapter.notifyDataSetChanged();

            userLit.add(new ModalItems("Cross Kurti","Size : M \n Price : 950 Rs.", R.drawable.red));
            userLit.add(new ModalItems("Round Kurti","Size : L \n Price : 2150 Rs.", R.drawable.white));
            userLit.add(new ModalItems("skyblue Kurti","Size : XL \n Price : 1150 Rs.", R.drawable.kurtiteal));
            userLit.add(new ModalItems("Shaded Kurti","Size : S \n Price : 1050 Rs.", R.drawable.kurtired));
            userLit.add(new ModalItems("Green Kurti", "Size : M \n Price : 950 Rs.",R.drawable.kurtigreen));
            userLit.add(new ModalItems("White Kurti","Size : XXL \n Price : 1050 Rs.", R.drawable.kurtiwhite));
            userLit.add(new ModalItems("Fancy Kurti", "Size : M \n Price : 1150 Rs.",R.drawable.kurtipink));
            userLit.add(new ModalItems("Chocish Kurti","Size : L \n Price : 1250 Rs.", R.drawable.kurtichocolate));
            userLit.add(new ModalItems("Yellow Kurti","Size : XL \n Price : 1050 Rs.", R.drawable.kurtiyellow));
            userLit.add(new ModalItems("BabyPink Kurti","Size : L \n Price : 950 Rs.", R.drawable.kurtibabypink));
            userLit.add(new ModalItems("Denim Kurti","Size : M \n Price : 850 Rs.", R.drawable.kurtidemin));
        } else if (name.equals("Traditional Wear")) {

            userLit = new ArrayList<>();

            recycle = findViewById(R.id.recycleview);
            layoutManager = new GridLayoutManager(this, 2);
            layoutManager.setOrientation(RecyclerView.VERTICAL);
            recycle.setLayoutManager(layoutManager);
            itemAdapter = new ItemAdapter(userLit,getApplicationContext());
            recycle.setAdapter(itemAdapter);
            itemAdapter.notifyDataSetChanged();

            userLit.add(new ModalItems("IndoWestern","Size : M \n Price : 4550 Rs.", R.drawable.choli));
            userLit.add(new ModalItems("Yellowish Choli","Size : L \n Price : 1050 Rs.", R.drawable.choli1));
            userLit.add(new ModalItems("Bride Choli","Size : M \n Price : 2550 Rs.", R.drawable.choli2));
            userLit.add(new ModalItems("White choli","Size : S \n Price : 1250 Rs.", R.drawable.choli3));
            userLit.add(new ModalItems("pink Pair","Size : XL \n Price : 1550 Rs.", R.drawable.choli4));
            userLit.add(new ModalItems("Red choli","Size : XXL \n Price : 1750 Rs.", R.drawable.choli5));
            userLit.add(new ModalItems("Black Saree","Size : M \n Price : 1050 Rs.", R.drawable.saree));
            userLit.add(new ModalItems("Green Plaza", "Size : S \n Price : 950 Rs.",R.drawable.plaza));
            userLit.add(new ModalItems("BabyPink Plaza", "Size : L \n Price : 1450 Rs.",R.drawable.plaza1));
        } else if (name.equals("Western Wear")) {

            userLit = new ArrayList<>();

            recycle = findViewById(R.id.recycleview);
            layoutManager = new GridLayoutManager(this, 2);
            layoutManager.setOrientation(RecyclerView.VERTICAL);
            recycle.setLayoutManager(layoutManager);
            itemAdapter = new ItemAdapter(userLit,getApplicationContext());
            recycle.setAdapter(itemAdapter);
            itemAdapter.notifyDataSetChanged();

            userLit.add(new ModalItems("black Fork","Size : M \n Price : 650 Rs.", R.drawable.western1));
            userLit.add(new ModalItems("Flourish Onepics","Size : L \n Price : 650 Rs.", R.drawable.western2));
            userLit.add(new ModalItems("Lined Fork","Size : S \n Price : 850 Rs.", R.drawable.wes));
            userLit.add(new ModalItems("Up and Down","Size : XL \n Price : 650 Rs.", R.drawable.western3));
            userLit.add(new ModalItems("Latest fork","Size : M \n Price : 750 Rs.", R.drawable.western4));
            userLit.add(new ModalItems("Yellow shorts","Size : S \n Price : 650 Rs.", R.drawable.western5));
            userLit.add(new ModalItems("B&G Shorts","Size : M \n Price : 950 Rs.", R.drawable.western6));
            userLit.add(new ModalItems("Shorty","Size : L \n Price : 1150 Rs.", R.drawable.western7));
            userLit.add(new ModalItems("W&B Shorts","Size : M \n Price : 1250 Rs.", R.drawable.western8));

        } else if (name.equals("Vegetable")) {

            userLit = new ArrayList<>();

            recycle = findViewById(R.id.recycleview);
            layoutManager = new GridLayoutManager(this, 2);
            layoutManager.setOrientation(RecyclerView.VERTICAL);
            recycle.setLayoutManager(layoutManager);
            itemAdapter = new ItemAdapter(userLit,getApplicationContext());
            recycle.setAdapter(itemAdapter);
            itemAdapter.notifyDataSetChanged();

            userLit.add(new ModalItems("Ginger","Weight : 250gm \n Price : 50 Rs.", R.drawable.ginger));
            userLit.add(new ModalItems("Capsicum","Weight : 500gm \n Price : 50 Rs.", R.drawable.capsicum));
            userLit.add(new ModalItems("Onion","Weight : 1 kg \n Price : 100 Rs.", R.drawable.onion));
            userLit.add(new ModalItems("Drum Stick", "Weight : 250gm \n Price : 50 Rs.",R.drawable.drumstick));
            userLit.add(new ModalItems("Peas","Weight : 500gm \n Price : 50 Rs.", R.drawable.peas));
            userLit.add(new ModalItems("Brocoli","Weight : 500gm \n Price : 200 Rs.", R.drawable.brocoli));
            userLit.add(new ModalItems("Tomato","Weight : 500gm \n Price : 50 Rs.", R.drawable.tomato));
            userLit.add(new ModalItems("Eggplant","Weight : 1 kg \n Price : 50 Rs.", R.drawable.brigal));
            userLit.add(new ModalItems("Carrot","Weight : 250gm \n Price : 30 Rs.", R.drawable.carrot));
            userLit.add(new ModalItems("Spinach","Weight : 250gm \n Price : 20 Rs.", R.drawable.spanish));
            userLit.add(new ModalItems("Cabbage","Weight : 1 kg \n Price : 30 Rs.", R.drawable.cabbage));
            userLit.add(new ModalItems("Purple Cabbage","Weight : 500gm \n Price : 50 Rs.", R.drawable.redcabbage));
        }
        else if (name.equals("Dairy Products")) {

            userLit = new ArrayList<>();

            recycle = findViewById(R.id.recycleview);
            layoutManager = new GridLayoutManager(this, 2);
            layoutManager.setOrientation(RecyclerView.VERTICAL);
            recycle.setLayoutManager(layoutManager);
            itemAdapter = new ItemAdapter(userLit,getApplicationContext());
            recycle.setAdapter(itemAdapter);
            itemAdapter.notifyDataSetChanged();

            userLit.add(new ModalItems("Cheese", "Weight : 250gm \n Price : 100 Rs.",R.drawable.cheese));
            userLit.add(new ModalItems("Diced Cheese","Weight : 500gm \n Price : 150 Rs.", R.drawable.dicedcheese));
            userLit.add(new ModalItems("Cream","Weight : 750gm \n Price : 90 Rs.", R.drawable.cream));
            userLit.add(new ModalItems("Coconut Milk", "Weight : 500ml \n Price : 80 Rs.",R.drawable.coconutmilk));
            userLit.add(new ModalItems("Milk","Weight : 250ml \n Price : 20 Rs.", R.drawable.milk));
            userLit.add(new ModalItems("Butter Milk","Weight : 250ml \n Price : 30 Rs.", R.drawable.masti));
            userLit.add(new ModalItems("Yogurt", "Weight : 250gm \n Price : 20 Rs.",R.drawable.yogurt));
            userLit.add(new ModalItems("Butter","Weight : 250gm \n Price : 50 Rs.", R.drawable.butter));
        } else if (name.equals("Oil")) {

            userLit = new ArrayList<>();

            recycle = findViewById(R.id.recycleview);
            layoutManager = new GridLayoutManager(this, 2);
            layoutManager.setOrientation(RecyclerView.VERTICAL);
            recycle.setLayoutManager(layoutManager);
            itemAdapter = new ItemAdapter(userLit,getApplicationContext());
            recycle.setAdapter(itemAdapter);
            itemAdapter.notifyDataSetChanged();

            userLit.add(new ModalItems("GroundNut Oil","Weight :1 l  \n Price : 100 Rs.", R.drawable.oil1));
            userLit.add(new ModalItems("Gingelly Oil","Weight : 500 ml \n Price : 200 Rs.", R.drawable.oil2));
            userLit.add(new ModalItems("Fortune Oil","Weight : 5 l \n Price : 300 Rs.", R.drawable.oil3));
            userLit.add(new ModalItems("Virgin Oil","Weight : 250 ml \n Price : 150 Rs.", R.drawable.oil4));
            userLit.add(new ModalItems("Figaro Oil","Weight : 250 ml \n Price : 50 Rs.", R.drawable.oil5));
            userLit.add(new ModalItems("Saffola oil","Weight : 750 ml \n Price : 150 Rs.", R.drawable.oil6));
            userLit.add(new ModalItems("Sunflower oil", "Weight : 250 ml \n Price : 200 Rs.",R.drawable.oil7));
            userLit.add(new ModalItems("Dhara oil","Weight : 250 ml \n Price : 50 Rs.", R.drawable.oil8));
        } else if (name.equals("Cosmetic")) {

            userLit = new ArrayList<>();

            recycle = findViewById(R.id.recycleview);
            layoutManager = new GridLayoutManager(this, 2);
            layoutManager.setOrientation(RecyclerView.VERTICAL);
            recycle.setLayoutManager(layoutManager);
            itemAdapter = new ItemAdapter(userLit,getApplicationContext());
            recycle.setAdapter(itemAdapter);
            itemAdapter.notifyDataSetChanged();

            userLit.add(new ModalItems("Mac Lipstick"," Price : 90 Rs.", R.drawable.maclips));
            userLit.add(new ModalItems("Plam Lipstick"," Price : 100 Rs.", R.drawable.plamlips));
            userLit.add(new ModalItems("Mamaearth Lipstick"," Price : 90 Rs.", R.drawable.mamalips));
            userLit.add(new ModalItems("Matte Lip"," Price : 500 Rs.", R.drawable.lipstick));
            userLit.add(new ModalItems("Lakme Foundation", " Price : 550 Rs.",R.drawable.lakme));
            userLit.add(new ModalItems("Plam Foundation", " Price : 850 Rs.",R.drawable.plamfound));
            userLit.add(new ModalItems("Mac Compact"," Price : 950 Rs.", R.drawable.maccompac));
            userLit.add(new ModalItems("Charcoal Facemask"," Price : 350 Rs.", R.drawable.fashmask1));
            userLit.add(new ModalItems("Kiwi Facemask"," Price : 400 Rs.", R.drawable.fashmask));
            userLit.add(new ModalItems("Facemask", " Price : 530 Rs.",R.drawable.facemask));
            userLit.add(new ModalItems("fashwash", " Price : 140 Rs.",R.drawable.fash));
            userLit.add(new ModalItems("Nivea Fashwash"," Price : 150 Rs.", R.drawable.fashwash));
            userLit.add(new ModalItems("Nail Kit"," Price : 60 Rs.", R.drawable.nailkit));
            userLit.add(new ModalItems("nail paint"," Price : 80 Rs.", R.drawable.nail));
            userLit.add(new ModalItems("Teal Nailpolish"," Price : 90 Rs.", R.drawable.nailpolish));
            userLit.add(new ModalItems("Primer"," Price : 500 Rs.", R.drawable.primer));
            userLit.add(new ModalItems("Mascara", " Price : 450 Rs.",R.drawable.mashkara));
            userLit.add(new ModalItems("Lipstick"," Price : 140 Rs.", R.drawable.lip));
            userLit.add(new ModalItems("Makeup Kit", " Price : 5000 Rs.",R.drawable.makeupkit));
        } else if (name.equals("Beverage")) {

            userLit = new ArrayList<>();

            recycle = findViewById(R.id.recycleview);
            layoutManager = new GridLayoutManager(this, 2);
            layoutManager.setOrientation(RecyclerView.VERTICAL);
            recycle.setLayoutManager(layoutManager);
            itemAdapter = new ItemAdapter(userLit,getApplicationContext());
            recycle.setAdapter(itemAdapter);
            itemAdapter.notifyDataSetChanged();

            userLit.add(new ModalItems("Frooti","Weight :1 l  \n Price : 100 Rs.", R.drawable.frooti));
            userLit.add(new ModalItems("Thums Up","Weight :2 l  \n Price : 100 Rs.", R.drawable.thums));
            userLit.add(new ModalItems("Amul Coco","Weight : 250  \n Price : 40 Rs.", R.drawable.amul));
            userLit.add(new ModalItems("Minchy Litchi", "Weight :1 l  \n Price : 100 Rs.",R.drawable.minchy));
            userLit.add(new ModalItems("Slice","Weight :1 l  \n Price : 100 Rs.", R.drawable.slice));
            userLit.add(new ModalItems("Herbal Drink", "Weight :1 l  \n Price : 100 Rs.",R.drawable.herbaldrink));
            userLit.add(new ModalItems("Maaza","Weight :1 l  \n Price : 100 Rs.", R.drawable.maaza));
            userLit.add(new ModalItems("7 up","Weight :1 l  \n Price : 100 Rs.", R.drawable.up7));
            userLit.add(new ModalItems("Sprite", "Weight :1 l  \n Price : 100 Rs.",R.drawable.sprite));
        } else if (name.equals("Flour")) {

            userLit = new ArrayList<>();

            recycle = findViewById(R.id.recycleview);
            layoutManager = new GridLayoutManager(this, 2);
            layoutManager.setOrientation(RecyclerView.VERTICAL);
            recycle.setLayoutManager(layoutManager);
            itemAdapter = new ItemAdapter(userLit,getApplicationContext());
            recycle.setAdapter(itemAdapter);
            itemAdapter.notifyDataSetChanged();

            userLit.add(new ModalItems("Wheat Flour","Weight : 1 kg \n Price : 100 Rs.", R.drawable.aashirvad));
            userLit.add(new ModalItems("Plain Flour","Weight : 1 kg \n Price : 50 Rs.", R.drawable.plain));
            userLit.add(new ModalItems("Rice Flour", "Weight : 1 kg \n Price : 80 Rs.",R.drawable.rice));
            userLit.add(new ModalItems("Soya Flour","Weight : 1 kg \n Price : 250 Rs.", R.drawable.soya));
            userLit.add(new ModalItems("Ragi Flour","Weight : 1 kg \n Price : 400 Rs.", R.drawable.ragi));
        } else if (name.equals("Baby Products")) {

            userLit = new ArrayList<>();

            recycle = findViewById(R.id.recycleview);
            layoutManager = new GridLayoutManager(this, 2);
            layoutManager.setOrientation(RecyclerView.VERTICAL);
            recycle.setLayoutManager(layoutManager);
            itemAdapter = new ItemAdapter(userLit,getApplicationContext());
            recycle.setAdapter(itemAdapter);
            itemAdapter.notifyDataSetChanged();

            userLit.add(new ModalItems("Water Wipes"," Price : 90 Rs.",  R.drawable.wipes));
            userLit.add(new ModalItems("Johnson Oil"," Price : 150 Rs.",  R.drawable.baby));
            userLit.add(new ModalItems("Johnson BodyWash"," Price : 200 Rs.",  R.drawable.bodywash));
            userLit.add(new ModalItems("Lotion"," Price : 250 Rs.",  R.drawable.lotion));
            userLit.add(new ModalItems("Johnson Powder"," Price : 100 Rs.",  R.drawable.powder));
            userLit.add(new ModalItems("Pampers Diaper"," Price : 90 Rs.",  R.drawable.diaper));
            userLit.add(new ModalItems("Nine Diaper", " Price : 70 Rs.", R.drawable.diaper1));
            userLit.add(new ModalItems("Baby CarryBag"," Price : 2500 Rs.",  R.drawable.babycarrybag));
            userLit.add(new ModalItems("Carry Bag"," Price : 5000 Rs.",  R.drawable.carrybag));

        } else if (name.equals("Wallet")) {

            userLit = new ArrayList<>();

            recycle = findViewById(R.id.recycleview);
            layoutManager = new GridLayoutManager(this, 2);
            layoutManager.setOrientation(RecyclerView.VERTICAL);
            recycle.setLayoutManager(layoutManager);
            itemAdapter = new ItemAdapter(userLit,getApplicationContext());
            recycle.setAdapter(itemAdapter);
            itemAdapter.notifyDataSetChanged();

            userLit.add(new ModalItems("Brown Wallet"," Price : 450 Rs.",  R.drawable.wal));
            userLit.add(new ModalItems("Forest Wallet"," Price : 550 Rs.",  R.drawable.wal1));
            userLit.add(new ModalItems("Black Wallet"," Price : 850 Rs.",  R.drawable.wal2));
            userLit.add(new ModalItems("Lined Wallet"," Price : 750 Rs.",  R.drawable.wal3));
            userLit.add(new ModalItems("Multi Wallet"," Price : 650 Rs.",  R.drawable.wal4));
            userLit.add(new ModalItems("Locked Wallet"," Price : 450 Rs.",  R.drawable.wal5));
            userLit.add(new ModalItems("Multiline Wallet"," Price : 350 Rs.",  R.drawable.wal6));
        }  else if (name.equals("School Bag")) {

            userLit = new ArrayList<>();

            recycle = findViewById(R.id.recycleview);
            layoutManager = new GridLayoutManager(this, 2);
            layoutManager.setOrientation(RecyclerView.VERTICAL);
            recycle.setLayoutManager(layoutManager);
            itemAdapter = new ItemAdapter(userLit,getApplicationContext());
            recycle.setAdapter(itemAdapter);
            itemAdapter.notifyDataSetChanged();

            userLit.add(new ModalItems("Pink Bag"," Price : 500 Rs.",  R.drawable.sb));
            userLit.add(new ModalItems("Bag"," Price : 800 Rs.",  R.drawable.sb1));
            userLit.add(new ModalItems("Micky Bag", " Price : 700 Rs.", R.drawable.sb2));
            userLit.add(new ModalItems("Blue Bag"," Price : 600 Rs.",  R.drawable.sb3));
            userLit.add(new ModalItems("Black Bag"," Price : 650 Rs.",  R.drawable.sb4));
            userLit.add(new ModalItems("Blue bag"," Price : 1000 Rs.",  R.drawable.sb5));
            userLit.add(new ModalItems("Bag", " Price : 1500 Rs.", R.drawable.sb7));
            userLit.add(new ModalItems("Brown bag", " Price : 6000 Rs.", R.drawable.sb8));
            userLit.add(new ModalItems("Blue sport Bag"," Price : 4000 Rs.",  R.drawable.sb9));
            userLit.add(new ModalItems("Sky Bag"," Price : 3000 Rs.",  R.drawable.sb10));

        } else if (name.equals("Purse")) {

            userLit = new ArrayList<>();

            recycle = findViewById(R.id.recycleview);
            layoutManager = new GridLayoutManager(this, 2);
            layoutManager.setOrientation(RecyclerView.VERTICAL);
            recycle.setLayoutManager(layoutManager);
            itemAdapter = new ItemAdapter(userLit,getApplicationContext());
            recycle.setAdapter(itemAdapter);
            itemAdapter.notifyDataSetChanged();

            userLit.add(new ModalItems("Black Purse"," Price : 500 Rs.",  R.drawable.pu));
            userLit.add(new ModalItems("White Purse", " Price : 800 Rs.", R.drawable.pu1));
            userLit.add(new ModalItems("Teal Purse", " Price : 750 Rs.", R.drawable.pu2));
            userLit.add(new ModalItems("Brown Purse"," Price : 800 Rs.",  R.drawable.pu3));
            userLit.add(new ModalItems("Mint Purse"," Price : 600 Rs.",  R.drawable.pu4));
            userLit.add(new ModalItems("Red Purse"," Price : 1000 Rs.",  R.drawable.pu5));
            userLit.add(new ModalItems("Forest Purse"," Price : 950 Rs.",  R.drawable.pu6));
            userLit.add(new ModalItems("Orange Purse"," Price : 800 Rs.",  R.drawable.pu7));
            userLit.add(new ModalItems("Yellow Purse", " Price : 650 Rs.", R.drawable.pu8));
            userLit.add(new ModalItems("Heart Purse"," Price : 1200 Rs.",  R.drawable.pu9));

        } else if (name.equals("Picnic Bag")) {

            userLit = new ArrayList<>();

            recycle = findViewById(R.id.recycleview);
            layoutManager = new GridLayoutManager(this, 2);
            layoutManager.setOrientation(RecyclerView.VERTICAL);
            recycle.setLayoutManager(layoutManager);
            itemAdapter = new ItemAdapter(userLit,getApplicationContext());
            recycle.setAdapter(itemAdapter);
            itemAdapter.notifyDataSetChanged();

            userLit.add(new ModalItems("Brown Bag"," Price : 4000 Rs.",  R.drawable.pic1));
            userLit.add(new ModalItems("Black Bag", " Price : 3000 Rs.", R.drawable.pic2));
            userLit.add(new ModalItems("Grey Bag", " Price : 2000 Rs.", R.drawable.pic3));
            userLit.add(new ModalItems("Black Bag"," Price : 1500 Rs.",  R.drawable.pic4));
            userLit.add(new ModalItems("Forest Bag"," Price : 550 Rs.",  R.drawable.pic5));
            userLit.add(new ModalItems("Blue bag"," Price : 250 Rs.",  R.drawable.pic6));
            userLit.add(new ModalItems("Tour bag", " Price : 3500 Rs.", R.drawable.tourbag));

        }
        else if (name.equals("Trolley Bag")) {

            userLit = new ArrayList<>();

            recycle = findViewById(R.id.recycleview);
            layoutManager = new GridLayoutManager(this, 2);
            layoutManager.setOrientation(RecyclerView.VERTICAL);
            recycle.setLayoutManager(layoutManager);
            itemAdapter = new ItemAdapter(userLit,getApplicationContext());
            recycle.setAdapter(itemAdapter);
            itemAdapter.notifyDataSetChanged();

            userLit.add(new ModalItems("Teal Bag", " Price : 2500 Rs.", R.drawable.bag));
            userLit.add(new ModalItems("White Bag"," Price : 3500 Rs.",  R.drawable.bag1));
            userLit.add(new ModalItems("Blue Bag"," Price : 4500 Rs.",  R.drawable.bag2));
            userLit.add(new ModalItems("Red Bag", " Price : 350 Rs.", R.drawable.bag3));
            userLit.add(new ModalItems("Sky Bag"," Price : 3000 Rs.",  R.drawable.bag4));
            userLit.add(new ModalItems("Bag Kit"," Price : 9000 Rs.",  R.drawable.bag5));
            userLit.add(new ModalItems("Red Bag", " Price : 500 Rs.", R.drawable.bag6));
            userLit.add(new ModalItems("Bag kit"," Price : 7000 Rs.",  R.drawable.bag7));
            userLit.add(new ModalItems("Flourish Bag"," Price : 2500 Rs.",  R.drawable.bag8));

        }
        else if (name.equals("Apple")) {

            userLit = new ArrayList<>();

            recycle = findViewById(R.id.recycleview);
            layoutManager = new GridLayoutManager(this, 2);
            layoutManager.setOrientation(RecyclerView.VERTICAL);
            recycle.setLayoutManager(layoutManager);
            itemAdapter = new ItemAdapter(userLit,getApplicationContext());
            recycle.setAdapter(itemAdapter);
            itemAdapter.notifyDataSetChanged();

            userLit.add(new ModalItems("iPhone 6"," Price : 35000 Rs.",  R.drawable.apple6));
            userLit.add(new ModalItems("iPhone 14 pro max", " Price : 85000 Rs.", R.drawable.i14pro));
            userLit.add(new ModalItems("iPhone 14 plus"," Price : 75000 Rs.",  R.drawable.i14plus));
            userLit.add(new ModalItems("iPhone 7"," Price : 45000 Rs.",  R.drawable.i7));

        }
        else if (name.equals("One Plus")) {

            userLit = new ArrayList<>();

            recycle = findViewById(R.id.recycleview);
            layoutManager = new GridLayoutManager(this, 2);
            layoutManager.setOrientation(RecyclerView.VERTICAL);
            recycle.setLayoutManager(layoutManager);
            itemAdapter = new ItemAdapter(userLit,getApplicationContext());
            recycle.setAdapter(itemAdapter);
            itemAdapter.notifyDataSetChanged();

            userLit.add(new ModalItems("One Plue 10r"," Price : 35000 Rs.",  R.drawable.op10r));
            userLit.add(new ModalItems("One Plus 11r"," Price : 72000 Rs.",  R.drawable.op11r));
            userLit.add(new ModalItems("One Plus 10 pro"," Price : 70000 Rs.",  R.drawable.op10pro));
        }
        else if (name.equals("Samsung")) {

            userLit = new ArrayList<>();

            recycle = findViewById(R.id.recycleview);
            layoutManager = new GridLayoutManager(this, 2);
            layoutManager.setOrientation(RecyclerView.VERTICAL);
            recycle.setLayoutManager(layoutManager);
            itemAdapter = new ItemAdapter(userLit,getApplicationContext());
            recycle.setAdapter(itemAdapter);
            itemAdapter.notifyDataSetChanged();

            userLit.add(new ModalItems("Samsung s22"," Price : 150000 Rs.",  R.drawable.s22));
            userLit.add(new ModalItems("Samsung s21", " Price : 95000 Rs.", R.drawable.s21));
            userLit.add(new ModalItems("Samsung a51"," Price : 75000 Rs.",  R.drawable.sa51));
        }
        else if (name.equals("Vivo")) {

            userLit = new ArrayList<>();

            recycle = findViewById(R.id.recycleview);
            layoutManager = new GridLayoutManager(this, 2);
            layoutManager.setOrientation(RecyclerView.VERTICAL);
            recycle.setLayoutManager(layoutManager);
            itemAdapter = new ItemAdapter(userLit,getApplicationContext());
            recycle.setAdapter(itemAdapter);
            itemAdapter.notifyDataSetChanged();

            userLit.add(new ModalItems("Vivo y56"," Price : 35000 Rs.",  R.drawable.vy56));
            userLit.add(new ModalItems("Vivo y01"," Price : 25000 Rs.",  R.drawable.vy01));
            userLit.add(new ModalItems("Vivo 27"," Price : 35000 Rs.",  R.drawable.v27));
            userLit.add(new ModalItems("Vivo y20t", " Price : 25000 Rs.", R.drawable.vy20t));
        }

        else if (name.equals("Oppo")) {

            userLit = new ArrayList<>();

            recycle = findViewById(R.id.recycleview);
            layoutManager = new GridLayoutManager(this, 2);
            layoutManager.setOrientation(RecyclerView.VERTICAL);
            recycle.setLayoutManager(layoutManager);
            itemAdapter = new ItemAdapter(userLit,getApplicationContext());
            recycle.setAdapter(itemAdapter);
            itemAdapter.notifyDataSetChanged();

            userLit.add(new ModalItems("Oppo a17"," Price : 12000 Rs.",  R.drawable.oa17));
            userLit.add(new ModalItems("Oppo f15", " Price : 25000 Rs.", R.drawable.of15));
            userLit.add(new ModalItems("Oppo r17"," Price : 35000 Rs.",  R.drawable.or17));
            userLit.add(new ModalItems("Oppo a53", " Price : 55000 Rs.", R.drawable.oa53));
        }
    }
}

