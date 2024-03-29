package com.example.mobilenumberlocator;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ISDCodes extends AppCompatActivity {

    RecyclerView recycleView;
    ImageView back;
    SAdapter sAdapter;
    List<ModalStd> userList;
    LinearLayoutManager linearLayoutManager;
   // final String TAG = "data";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_isdcodes);

        recycleView = findViewById(R.id.recycleView);
        back = findViewById(R.id.back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        initData();
        initRecyclerView();
    }

    private void initData() {
        userList = new ArrayList<>();

                userList.add(new ModalStd("Åland Islands","+358 18"));
                userList.add(new ModalStd("Afghanistan","+93"));
                userList.add(new ModalStd("Albania","+355"));
                userList.add(new ModalStd("Algeria","+213"));
                userList.add(new ModalStd("American Samoa","+1 684"));
                userList.add(new ModalStd("Andorra","+376"));
                userList.add(new ModalStd("Angola","+244"));
                userList.add(new ModalStd("Anguilla","+1 264"));
                userList.add(new ModalStd("Antigua and Barbuda","+1 268"));
                userList.add(new ModalStd("Argentina","+54"));
                userList.add(new ModalStd("Armenia","+374"));
                userList.add(new ModalStd("Aruba","+297"));
                userList.add(new ModalStd("Ascension Island","+247"));
                userList.add(new ModalStd("Australia","+61"));
                userList.add(new ModalStd("Australian Antarctic Territory","+672 1"));
                userList.add(new ModalStd("Austria","+43"));
                userList.add(new ModalStd("Azerbaijan","+994"));
                userList.add(new ModalStd("Bahamas","+1 242"));
                userList.add(new ModalStd("Bahrain","+973"));
                userList.add(new ModalStd("Bangladesh","+880"));
                userList.add(new ModalStd("Barbados","+1 246"));
                userList.add(new ModalStd("Belarus","+375"));
                userList.add(new ModalStd("Belgium","+32"));
                userList.add(new ModalStd("Belize","+501"));
                userList.add(new ModalStd("Benin","+229"));
                userList.add(new ModalStd("Bermuda","+1 441"));
                userList.add(new ModalStd("Bhutan","+975"));
                userList.add(new ModalStd("Bolivia","+591"));
                userList.add(new ModalStd("Bosnia and Herzegovina","+387"));
                userList.add(new ModalStd("Botswana","+267"));
                userList.add(new ModalStd("Bouvet Island","+47"));
                userList.add(new ModalStd("Brazil","+55"));
                userList.add(new ModalStd("British Indian Ocean Territory","+246"));
                userList.add(new ModalStd("British Virgin Islands","+1 284"));
                userList.add(new ModalStd("Brunei","+673"));
                userList.add(new ModalStd("Bulgaria","+359"));
                userList.add(new ModalStd("Burkina Faso","+226"));
                userList.add(new ModalStd("Burundi","+257"));
                userList.add(new ModalStd("Cambodia","+855"));
                userList.add(new ModalStd("Cameroon","+237"));
                userList.add(new ModalStd("Canada","+1"));
                userList.add(new ModalStd("Cape Verde","+238"));
                userList.add(new ModalStd("Caribbean Netherlands","+599"));
                userList.add(new ModalStd("Cayman Islands","+1 345"));
                userList.add(new ModalStd("Central African Republic","+236"));
                userList.add(new ModalStd("Chad","+235"));
                userList.add(new ModalStd("Chile","+56"));
                userList.add(new ModalStd("China","+86"));
                userList.add(new ModalStd("Christmas Island","+89164"));
                userList.add(new ModalStd("Cocos (Keeling) Islands","+89162"));

                userList.add(new ModalStd("Colombia","+57"));
                userList.add(new ModalStd("Comoros","+269"));
                userList.add(new ModalStd("Cook Islands","+682"));
                userList.add(new ModalStd("Costa Rica","+506"));
                userList.add(new ModalStd("Croatia","+385"));
                userList.add(new ModalStd("Cuba","+53"));
                userList.add(new ModalStd("Curaçao","+599 9"));
                userList.add(new ModalStd("Cyprus","+357"));
                userList.add(new ModalStd("Czech Republic","+420"));
                userList.add(new ModalStd("Democratic Republic of the Congo","+243"));
                userList.add(new ModalStd("Denmark","+45"));
                userList.add(new ModalStd("Djibouti","+253"));
                userList.add(new ModalStd("Dominica","+1 767"));
                userList.add(new ModalStd("Dominican Republic","+1 809"));
                userList.add(new ModalStd("East Timor","+670"));
                userList.add(new ModalStd("Ecuador","+593"));
                userList.add(new ModalStd("Egypt","+20"));
                userList.add(new ModalStd("El Salvador","+503"));
                userList.add(new ModalStd("Equatorial Guinea","+240"));
                userList.add(new ModalStd("Eritrea","+291"));
                userList.add(new ModalStd("Estonia","+372"));
                userList.add(new ModalStd("Eswatini","+268"));
                userList.add(new ModalStd("Ethiopia","+251"));
                userList.add(new ModalStd("Falkland Islands (Malvinas)","+500"));
                userList.add(new ModalStd("Faroe Islands","+298"));
                userList.add(new ModalStd("Fiji","+679"));
                userList.add(new ModalStd("Finland","+358"));
                userList.add(new ModalStd("France","+33"));
                userList.add(new ModalStd("French Guiana","+594"));
                userList.add(new ModalStd("French Polynesia","+689"));
                userList.add(new ModalStd("French Southern and Antarctic Lands","+262"));
                userList.add(new ModalStd("Gabon","+241"));
                userList.add(new ModalStd("Gambia","+220"));
                userList.add(new ModalStd("Georgia","+995"));
                userList.add(new ModalStd("Germany","+49"));
                userList.add(new ModalStd("Ghana","+233"));
                userList.add(new ModalStd("Gibraltar","+350"));
                userList.add(new ModalStd("Greece","+30"));
                userList.add(new ModalStd("Greenland","+299"));
                userList.add(new ModalStd("Grenada","+1 473"));
                userList.add(new ModalStd("Guadeloupe","+590"));
                userList.add(new ModalStd("Guam","+1 671"));
                userList.add(new ModalStd("Guatemala","+502"));
                userList.add(new ModalStd("Guernsey","+44 1481"));
                userList.add(new ModalStd("Guinea","+224"));
                userList.add(new ModalStd("Guinea-Bissau","+245"));
                userList.add(new ModalStd("Guyana","+592"));
                userList.add(new ModalStd("Haiti","+509"));
                userList.add(new ModalStd("Heard Island and McDonald Islands","+1 672"));
                userList.add(new ModalStd("Honduras","+504"));
                userList.add(new ModalStd("Hong Kong","+852"));
                userList.add(new ModalStd("Hungary","+36"));
                userList.add(new ModalStd("Iceland","+354"));
                userList.add(new ModalStd("India","+91"));

                userList.add(new ModalStd("Indonesia", "+62" ));
                userList.add(new ModalStd("Iran", "+98" ));
                userList.add(new ModalStd("Iraq", "+964" ));
                userList.add(new ModalStd("Ireland", "+353" ));
                userList.add(new ModalStd("Isle of Man", "+7924" ));
                userList.add(new ModalStd("Israel", "+972" ));
                userList.add(new ModalStd("Italy", "+39" ));
                userList.add(new ModalStd("Ivory Coast", "+225" ));
                userList.add(new ModalStd("Jamaica", "+1 876" ));
                userList.add(new ModalStd("Japan", "+81" ));
                userList.add(new ModalStd("Jersey", "+1534" ));
                userList.add(new ModalStd("Jordan", "+962" ));
                userList.add(new ModalStd("Kazakhstan", "+7 6" ));
                userList.add(new ModalStd("Kenya", "+254" ));
                userList.add(new ModalStd("Kiribati", "+686" ));
                userList.add(new ModalStd("Kosovo", "+383" ));
                userList.add(new ModalStd("Kuwait", "+965" ));
                userList.add(new ModalStd("Kyrgyzstan", "+996" ));
                userList.add(new ModalStd("Laos", "+856" ));
                userList.add(new ModalStd("Latvia", "+371" ));
                userList.add(new ModalStd("Lebanon", "+961" ));
                userList.add(new ModalStd("Lesotho", "+266" ));
                userList.add(new ModalStd("Liberia", "+231" ));
                userList.add(new ModalStd("Libya", "+218" ));
                userList.add(new ModalStd("Liechtenstein", "+423" ));
                userList.add(new ModalStd("Lithuania", "+370" ));
                userList.add(new ModalStd("Luxembourg", "+352" ));
                userList.add(new ModalStd("Macao", "+853" ));
                userList.add(new ModalStd("Madagascar", "+261" ));
                userList.add(new ModalStd("Malawi", "+265" ));
                userList.add(new ModalStd("Malaysia", "+60" ));
                userList.add(new ModalStd("Maldives", "+960" ));
                userList.add(new ModalStd("Mali", "+223" ));
                userList.add(new ModalStd("Malta", "+356" ));
                userList.add(new ModalStd("Marshall Islands", "+692" ));
                userList.add(new ModalStd("Martinique", "+596" ));
                userList.add(new ModalStd("Mauritania", "+222" ));
                userList.add(new ModalStd("Mauritius", "+230" ));
                userList.add(new ModalStd("Mayotte", "+262 269" ));
                userList.add(new ModalStd("Mexico", "+52" ));
                userList.add(new ModalStd("Micronesia", "+691" ));
                userList.add(new ModalStd("Moldova", "+373" ));
                userList.add(new ModalStd("Monaco", "+377" ));
                userList.add(new ModalStd("Mongolia", "+976" ));

                userList.add(new ModalStd("Montenegro", "+382"));
                userList.add(new ModalStd("Montserrat", "+1 664"));
                userList.add(new ModalStd("Morocco", "+212"));
                userList.add(new ModalStd("Mozambique", "+258"));
                userList.add(new ModalStd("Myanmar", "+95"));
                userList.add(new ModalStd("Namibia", "+264"));
                userList.add(new ModalStd("Nauru", "+674"));
                userList.add(new ModalStd("Nepal", "+977"));
                userList.add(new ModalStd("Netherlands", "+31"));
                userList.add(new ModalStd("Netherlands Antilles", "+599"));
                userList.add(new ModalStd("New Caledonia", "+687"));
                userList.add(new ModalStd("New Zealand", "+64"));
                userList.add(new ModalStd("Nicaragua", "+505"));
                userList.add(new ModalStd("Niger", "+227"));
                userList.add(new ModalStd("Nigeria", "+234"));
                userList.add(new ModalStd("Niue", "+683"));
                userList.add(new ModalStd("Norfolk Island", "+672 3"));
                userList.add(new ModalStd("North Korea", "+850"));
                userList.add(new ModalStd("North Macedonia", "+389"));
                userList.add(new ModalStd("Northern Ireland", "+44 28"));
                userList.add(new ModalStd("Northern Mariana Islands", "+1 670"));
                userList.add(new ModalStd("Norway", "+47"));
                userList.add(new ModalStd("Oman", "+968"));
                userList.add(new ModalStd("Pakistan", "+92"));
                userList.add(new ModalStd("Palau", "+680"));
                userList.add(new ModalStd("Palestine", "+970"));
                userList.add(new ModalStd("Panama", "+507"));
                userList.add(new ModalStd("Papua New Guinea", "+675"));
                userList.add(new ModalStd("Paraguay", "+595"));
                userList.add(new ModalStd("Peru", "+51"));
                userList.add(new ModalStd("Philippines", "+63"));
                userList.add(new ModalStd("Pitcairn", "+64"));
                userList.add(new ModalStd("Poland", "+48"));
                userList.add(new ModalStd("Portugal", "+351"));
                userList.add(new ModalStd("Puerto Rico", "+1 787"));
                userList.add(new ModalStd("Qatar", "+974"));
                userList.add(new ModalStd("Réunion", "+262"));
                userList.add(new ModalStd("Republic of the Congo", "+242"));
                userList.add(new ModalStd("Romania", "+40"));
                userList.add(new ModalStd("Russia", "+7"));
                userList.add(new ModalStd("Rwanda", "+250"));
                userList.add(new ModalStd("Saint Barthélemy", "+590"));
                userList.add(new ModalStd("Saint Helena", "+290"));
                userList.add(new ModalStd("Saint Kitts and Nevis", "+1 869"));
                userList.add(new ModalStd("Saint Lucia", "+1 758"));
                userList.add(new ModalStd("Saint Martin (French part)", "+590"));
                userList.add(new ModalStd("Saint Pierre and Miquelon", "+508"));
                userList.add(new ModalStd("Saint Vincent and the Grenadines", "+1 784"));
                userList.add(new ModalStd("Samoa", "+685"));
                userList.add(new ModalStd("San Marino", "+378"));
                userList.add(new ModalStd("Sao Tome and Principe", "+239"));
                userList.add(new ModalStd("Saudi Arabia", "+966"));
                userList.add(new ModalStd("Senegal", "+221"));
                userList.add(new ModalStd("Serbia", "+381"));
                userList.add(new ModalStd("Seychelles", "+248"));
                userList.add(new ModalStd("Sierra Leone", "+232"));
                userList.add(new ModalStd("Singapore","+65"));
                userList.add(new ModalStd("Slovakia","+421"));
                userList.add(new ModalStd("Slovenia","+386"));
                userList.add(new ModalStd("Solomon Islands","+677"));
                userList.add(new ModalStd("Somalia","+252"));
                userList.add(new ModalStd("South Africa","+27"));
                userList.add(new ModalStd("South Georgia and the South Sandwich Islands","+500"));
                userList.add(new ModalStd("South Korea","+82"));
                userList.add(new ModalStd("South Sudan","+211"));
                userList.add(new ModalStd("Spain","+34"));
                userList.add(new ModalStd("Sri Lanka","+94"));
                userList.add(new ModalStd("Sudan","+249"));
                userList.add(new ModalStd("Suriname","+597"));
                userList.add(new ModalStd("Svalbard and Jan Mayen","+47 79"));
                userList.add(new ModalStd("Sweden","+46"));
                userList.add(new ModalStd("Switzerland","+41"));
                userList.add(new ModalStd("Syria","+963"));
                userList.add(new ModalStd("Taiwan","+886"));
                userList.add(new ModalStd("Tajikistan","+992"));
                userList.add(new ModalStd("Tanzania","+255"));
                userList.add(new ModalStd("Thailand","+66"));
                userList.add(new ModalStd("Togo","+228"));
                userList.add(new ModalStd("Tokelau","+690"));
                userList.add(new ModalStd("Tonga","+676"));
                userList.add(new ModalStd("Trinidad and Tobago","+1 868"));
                userList.add(new ModalStd("Tunisia","+216"));
                userList.add(new ModalStd("Turkey","+90"));
                userList.add(new ModalStd("Turkmenistan","+993"));
                userList.add(new ModalStd("Turks and Caicos Islands","+1 649"));
                userList.add(new ModalStd("Tuvalu","+688"));
                userList.add(new ModalStd("Uganda","+256"));
                userList.add(new ModalStd("Ukraine","+380"));
                userList.add(new ModalStd("United Arab Emirates","+971"));
                userList.add(new ModalStd("United Kingdom","+44"));
                userList.add(new ModalStd("United States","+1"));
                userList.add(new ModalStd("United States Minor Outlying Islands","+246"));
                userList.add(new ModalStd("Uruguay","+598"));
                userList.add(new ModalStd("Uzbekistan","+998"));
                userList.add(new ModalStd("Vanuatu","+678"));
                userList.add(new ModalStd("Vatican City","+379"));
                userList.add(new ModalStd("Venezuela","+58"));
                userList.add(new ModalStd("Vietnam","+84"));
                userList.add(new ModalStd("Virgin Islands, U.S.","+1 340"));
                userList.add(new ModalStd("Wallis and Futuna","+681"));
                userList.add(new ModalStd("Western Sahara","+212"));
                userList.add(new ModalStd("Yemen","+967"));
                userList.add(new ModalStd("Zambia","+260"));
                userList.add(new ModalStd("Zimbabwe","+263"));


    }
    private void initRecyclerView() {

        recycleView=findViewById(R.id.recycleView);
        linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        recycleView.setLayoutManager(linearLayoutManager);
        sAdapter = new SAdapter(userList,getApplicationContext());
        recycleView.setAdapter(sAdapter);
        sAdapter.notifyDataSetChanged();

    }
}