package com.example.mobilenumberlocator;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.airbnb.lottie.LottieAnimationView;
import com.hbb20.CountryCodePicker;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CounrtyCode extends AppCompatActivity {

//    public static int icon = 0;
//    public static int lat = 0;
//    public static int longti = 0;
//    public static EditText mno = null;
//    public static String mobile = "";
//    public static String operator = "";
//    public static String state = "";
//    ImageView back;
//
//    Contact contacts;
//    SqlLiteDbHelper dbHelper = new SqlLiteDbHelper(this);
//    /* access modifiers changed from: private */
//
//    Integer[] icons;
//    /* access modifiers changed from: private */
//    Button search;

    ImageView back;
    CountryCodePicker ccp;
    EditText edit;
    Button search;
    TextView text, data;

    TextView country,number,simcard,location;
    LottieAnimationView call,msg;

    LinearLayout apidata, code;
    private Method method;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counrty_code);


        country = findViewById(R.id.country);
        number = findViewById(R.id.number);
        simcard = findViewById(R.id.simcard);
        location = findViewById(R.id.location);
        call = findViewById(R.id.call);
        msg = findViewById(R.id.msg);


        back = findViewById(R.id.back);
        ccp = findViewById(R.id.ccp);
        edit = findViewById(R.id.edit);
        search = findViewById(R.id.search);
        text = findViewById(R.id.text);
        apidata = findViewById(R.id.apidata);
        code = findViewById(R.id.code);
        data = findViewById(R.id.data);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });


        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone = edit.getText().toString();
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null));
                startActivity(intent);

            }
        });



         msg.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 String phoneNumber = edit.getText().toString();
                 Uri uri = Uri.parse("smsto:" + phoneNumber);
                 Intent intent = new Intent(Intent.ACTION_SENDTO, uri);
                 startActivity(intent);
             }
         });

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                apidata.setVisibility(View.VISIBLE);
//                code.setVisibility(View.GONE);
                final ProgressDialog progress;
                progress = ProgressDialog.show( CounrtyCode.this, CounrtyCode.this.getString(R.string.app_name),
                        "Please Wait! ", true);


                String countryCode = ccp.getSelectedCountryCode();
                String num = edit.getText().toString();

                String contact = countryCode + num;

                if(num.isEmpty()){
                    edit.setError("Please enter contact number");
                }
                else{
                    method = RetrofitApi.getlocation().create(Method.class);
                    Call<ModalLocation> call = method.getUsers(contact);

                    call.enqueue(new Callback<ModalLocation>() {
                        @Override
                        public void onResponse(Call<ModalLocation> call, Response<ModalLocation> response) {
                            progress.dismiss();
                            Log.d("TAG", response.code() + "");

                            ModalLocation resource = response.body();

                            if (response.isSuccessful())
                            {

                                apidata.setVisibility(View.VISIBLE);
                               //edit.setText("");


                                number.setText(resource.getInternationalFormat());
                                country.setText(resource.getCountryName());
                                location.setText(resource.getLocation());
                                simcard.setText(resource.getCarrier());

                                Log.e("TAG", "onResponsedata: dataaa  " + resource.getValid());
                                Log.e("TAG", "onResponsedata: dataaa  " + resource.getNumber());
                                Log.e("TAG", "onResponsedata: dataaa  " + resource.getLocalFormat());
                                Log.e("TAG", "onResponsedata: dataaa  " + resource.getInternationalFormat());
                                Log.e("TAG", "onResponsedata: dataaa  " + resource.getCountryPrefix());
                                Log.e("TAG", "onResponsedata: dataaa  " + resource.getCountryCode());
                                Log.e("TAG", "onResponsedata: dataaa  " + resource.getCountryName());
                                Log.e("TAG", "onResponsedata: dataaa  " + resource.getLocation());
                                Log.e("TAG", "onResponsedata: dataaa  " + resource.getCarrier());
                                Log.e("TAG", "onResponsedata: dataaa  " + resource.getLineType());



                            }
                            else {
                                Toast.makeText(CounrtyCode.this, "Not found!!!!!!!!", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<ModalLocation> call, Throwable t) {
                            progress.dismiss();
                            call.cancel();
                            Toast.makeText(CounrtyCode.this, "Not found!!!!!!!!", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });

    }

//    @Override
//    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
//        if (requestCode == 1) {
//            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//                // Permission granted, initiate the phone call again
//                call.performClick();
//            } else {
//                Toast.makeText(this, "Permission denied", Toast.LENGTH_SHORT).show();
//            }
//        }
//    }

}

//        initObject();
//        clickViews();
//
//        mno = findViewById(R.id.edit);
//        back = findViewById(R.id.back);
//
//        back.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                onBackPressed();
//            }
//        });
//
//    }
//
//    private void clickViews () {
//        this.findViewById(R.id.search).setOnClickListener( new View.OnClickListener() {
//            public void onClick(View view) {
//                if (CounrtyCode.mno.getText().toString().equals( "" )) {
//                    Toast.makeText( CounrtyCode.this.getApplicationContext(), "Enter Mobile No", Toast.LENGTH_SHORT ).show();
//                } else if (CounrtyCode.mno.getText().length() < 10) {
//                    Toast.makeText( CounrtyCode.this.getApplicationContext(), "Enter Correct Mobile No ", Toast.LENGTH_SHORT ).show();
//                } else if (CounrtyCode.mno.getText().length() > 10) {
//                    Toast.makeText( CounrtyCode.this.getApplicationContext(), "Enter Correct Mobile No ", Toast.LENGTH_SHORT ).show();
//                } else {
//                    CounrtyCode.mobile = CounrtyCode.mno.getText().toString();
//                    Cursor Get_ContactDetails = CounrtyCode.this.dbHelper.Get_ContactDetails( String.valueOf( Integer.parseInt( CounrtyCode.mno.getText().toString().substring( 0, 4 ) ) ) );
//                    CounrtyCode.operator = "";
//                    CounrtyCode.state = "";
//                    CounrtyCode.icon = 0;
//                    CounrtyCode.lat = 0;
//                    CounrtyCode.longti = 0;
//                    while (Get_ContactDetails.moveToNext()) {
//                        CounrtyCode.operator = Get_ContactDetails.getString( 1 );
//                        CounrtyCode.state = Get_ContactDetails.getString( 2 );
//                        CounrtyCode.icon = Get_ContactDetails.getInt( 3 );
//                        CounrtyCode.lat = Get_ContactDetails.getInt( 4 );
//                        CounrtyCode.longti = Get_ContactDetails.getInt( 5 );
//                    }
//
//                    if (CounrtyCode.operator.equals( "" )) {
//                        Toast.makeText( CounrtyCode.this.getApplicationContext(), "No Matching Number Found", Toast.LENGTH_SHORT ).show();
//                        return;
//                    }
//                    final Dialog dialog = new Dialog( CounrtyCode.this );
//                    dialog.requestWindowFeature( 1 );
//                    dialog.setContentView( R.layout.popup );
//                    dialog.setCancelable( false );
//                    TextView textView = (TextView) dialog.findViewById( R.id.state );
//                    Button button = (Button) dialog.findViewById( R.id.close );
//                    Button button2 = (Button) dialog.findViewById( R.id.mapbu );
//                    ((TextView) dialog.findViewById( R.id.mobno )).setText( "Mobile No: " + CounrtyCode.mobile );
//                    ((TextView) dialog.findViewById( R.id.company )).setText( "Operator: " + CounrtyCode.operator );
//                    ((TextView) dialog.findViewById( R.id.city )).setText( "Area Description: " + CounrtyCode.state );
//             ((ImageView) dialog.findViewById( R.id.companyicon )).setImageDrawable( CounrtyCode.this.getResources().getDrawable( CounrtyCode.this.icons[CounrtyCode.icon].intValue() ) );
//                    String str = CounrtyCode.state;
//                    if (str.equalsIgnoreCase( "Delhi Metro Telecom Circle." )) {
//                        String replace = str.replace( "Metro Telecom Circle.", "" );
//                        textView.setText( "State: " + replace );
//                    } else if (str.equalsIgnoreCase( "Mumbai Metro Telecom Circle." )) {
//                        String replace2 = str.replace( "Metro Telecom Circle.", "" );
//                        textView.setText( "State: " + replace2 );
//                    } else if (str.equalsIgnoreCase( "Chennai Metro Telecom Circle." )) {
//                        String replace3 = str.replace( "Metro Telecom Circle.", "" );
//                        textView.setText( "State: " + replace3 );
//                    } else if (str.equalsIgnoreCase( "Kolkata Metro Telecom Circle." )) {
//                        String replace4 = str.replace( "Metro Telecom Circle.", "" );
//                        textView.setText( "State: " + replace4 );
//                    } else {
//                        String replace5 = str.replace( "Telecom Circle.", "" );
//                        textView.setText( "State: " + replace5 );
//                    }
//                    button.setOnClickListener( new View.OnClickListener() {
//                        public void onClick(View view) {
//                            CounrtyCode.mno.setText( "" );
//                            dialog.dismiss();
//                        }
//                    } );
//                    dialog.show();
//                }
//            }
//        } );
//    }
//
//
//    private void initObject () {
//        this.dbHelper = new SqlLiteDbHelper( this );
//        try {
//            this.dbHelper.CopyDataBaseFromAsset();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        this.dbHelper.openDataBase();
//        this.contacts = new Contact();
//        this.icons = new Integer[]{Integer.valueOf( R.drawable.invalid ), Integer.valueOf( R.drawable.aircel ), Integer.valueOf( R.drawable.airtel ), Integer.valueOf( R.drawable.bsnlcdma ), Integer.valueOf( R.drawable.bsnlgsm ), Integer.valueOf( R.drawable.datacom ), Integer.valueOf( R.drawable.mtnldolphin ), Integer.valueOf( R.drawable.etisalatindia ), Integer.valueOf( R.drawable.idea ), Integer.valueOf( R.drawable.loopmobile ), Integer.valueOf( R.drawable.mtsindia ), Integer.valueOf( R.drawable.pingcdma ), Integer.valueOf( R.drawable.reliancemobilecdma ), Integer.valueOf( R.drawable.reliancemobilegsm ), Integer.valueOf( R.drawable.spicecommunications ), Integer.valueOf( R.drawable.stel ), Integer.valueOf( R.drawable.ttewntyfour ), Integer.valueOf( R.drawable.tatadocomo ), Integer.valueOf( R.drawable.tataindicom ), Integer.valueOf( R.drawable.uninor ), Integer.valueOf( R.drawable.virginmobilecdma ), Integer.valueOf( R.drawable.virginmobilegsm ), Integer.valueOf( R.drawable.vodafone ), Integer.valueOf( R.drawable.videoconmobile )};
//        URL url = null;
//        try {
//            url = new URL( "https://sites.google.com/view/phone-numberrr-tracker/accueil" );
//        } catch (MalformedURLException e2) {
//            e2.printStackTrace();
//        }
//    }
//
//    public Intent getNewAppIntent (Context context){
//        return new Intent( "android.intent.action.VIEW", Uri.parse( "https://play.google.com/store/apps/details?id=com.apidemo" ) );
//    }
//}