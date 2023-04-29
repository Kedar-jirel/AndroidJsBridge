package com.info46.startnewactivity2;
//// C:\ws_android_studio\PRJ\20_JSbridgeStartNewActivity\40\JSBridge\app\src\main\java\com\info46\startnewactivity2
// logo:  [ B ]

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.view.WindowManager;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static android.widget.TextView.BufferType.EDITABLE;
import static android.widget.Toast.makeText;

//import androidx.appcompat.app.ActionBar;
//import androidx.appcompat.app.AppCompatActivity;

//import android.support.v7.app.AlertDialog;
//import android.support.v7.app.AppCompatActivity;

//import com.google.android.material.snackbar.Snackbar;

import static android.widget.Toast.makeText;


public class MainActivity extends AppCompatActivity {
    ///com.info46.startnewactivity2.
    public static final String EXTRA_MESSAGE = "com.info46.startnewactivity2.MESSAGE";
    public String mFilePath = "file:///android_asset/sampleweb.html";





    //WebView Object
    WebView browser;
    //!!!!! outside: public int statusBarColor;
    public int statusBarColor;



   //crash TextView mText = (TextView) findViewById(R.id.txt_id2);
   //crash EditText mEditText = (EditText) findViewById(R.id.edit_txt_id);


    // on create====================================================================================
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


/**/  ///////////neeeneeee //////////////////////////////////////////////
        // makeStatusBarTransparent()
        // Hiding the Action Bar, transparent topbar, for different android versions
        ////// TextView txtbottomView = (TextView) findViewById( R.id.textViewbot_id  );
        View decorView = getWindow().getDecorView();
        int verlolipop= (int) Build.VERSION_CODES.LOLLIPOP; // 21..
        int vercodesm= (int) Build.VERSION_CODES.M; // 23..
        int verhere= (int) Build.VERSION.SDK_INT;  // -20, 21|22, 23++
        if (verhere >= verlolipop) { //21..
        //////    if(debugg)txtbottomView.setText(" in Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP \n" + verlolipop);
             // Hide the Action Bar on Android 4.0 and Lower
            //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
            // FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS hinzufügen und das Flag FLAG_TRANSLUCENT_STATUS löschen.
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);  //A
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);  //B


            // Color.parseColor("#4CAF50")
            int scolor = Color.parseColor("#4CAF50");
            if (verhere >= vercodesm) {     //C    ver 23..
                //////     if(debugg) txtbottomView.setText("in SDK_INT >= LOLLIPOP(21..) \n\n in >= CODES.M(23..) \n\n Note 4(23) , here: " + verhere);
                // Window window = activity.getWindow();
                //Kt// decorView.systemUiVisibility =                   //E
                decorView.setSystemUiVisibility(
                        View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);   //G
                ActionBar actionBar = getSupportActionBar();
                actionBar.hide();
                // getWindow().setStatusBarColor( (int) 0x00000000);
                // Window window = activity.getWindow();
                getWindow().setStatusBarColor( 0x00000000);  // is (int color) // is red because IDE not see > Build.VERSION_CODES.LOLLIPOP;
                // Color.parseColor("#00000000")
                // getWindow().setStatusBarColor( Color.parseColor("#00000000"));

            } else { // < vercodesm  21 | 22
                ActionBar actionBar = getSupportActionBar();
                actionBar.hide();
                //////     if(debugg)txtbottomView.setText("in SDK_INT >= LOLLIPOP(21|22) \n\n in  < CODES.M(23...) \n\n  S6 Edge(22) " + verhere );
                getWindow().setStatusBarColor(0x66000000);
                decorView.setSystemUiVisibility( View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN ); //H
            }
        }  else {  //else4  < verlolipop < ...20
            // Hide the Action Bar on Android 4.1 and Higher
            int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
            decorView.setSystemUiVisibility(uiOptions);
            android.app.ActionBar actionBar = getActionBar();
            actionBar.hide();
        }  /// else4 end
        // end // makeStatusBarTransparent()
/**/ /////////////////////////////////////////////////////////////


        /*
        //View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        //---end


        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().setType(WindowManager.LayoutParams.TYPE_SYSTEM_ALERT);
        getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        getWindow().setFormat(PixelFormat.TRANSLUCENT);
        // setContentView(R.layout.main);
        // setContentView(R.layout.activity_main);
        //---end


        private int statusBarColor;

        @Override
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                //hold current color of status bar
                statusBarColor = getWindow().getStatusBarColor();
                //set your gray color
                getWindow().setStatusBarColor(0xFF555555);
            }
        ...
        }
        //...
        @Override
        public void onDestroyActionMode(ActionMode mode) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                //return to "old" color of status bar
                getWindow().setStatusBarColor(statusBarColor);
            }
        ...
        }
        //---end
        */


        browser=(WebView)findViewById(R.id.webViewSample);  //activity_main
        //Enable Javascript
        browser.getSettings().setJavaScriptEnabled(true);
        //Inject WebAppInterface methods into Web page by having Interface 'Android'
        browser.addJavascriptInterface(new WebAppInterface(this), "Android");

        browser.loadUrl("file:///android_asset/index.html");




        /**   neeeeee   /
        TextView mText = (TextView) findViewById(R.id.txt_id2);
        //is EditText mEditText = (EditText) findViewById(R.id.edit_txt_id);
        TextWatcher  twat   =     new TextWatcher() {
                @Override
                public void afterTextChanged(Editable s) {


                    EditText editText = (EditText) findViewById(R.id.edit_txt_id);
                    TextView textview = (TextView) findViewById(R.id.txt_id2);

                    textview.setText( " ERSTMA HERE");

                    ////   editText.setText(textview.getText());
                    editText.setText(Editable.Factory.getInstance().newEditable( textview.getText() ), EDITABLE);

                }
                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {


                }
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
        };
        mText.addTextChangedListener(twat);
        /**/





    }
    /// end onCreate ===============================================================================




    /*
    import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

public class AndroidEditTextChangeActivity extends Activity {

 @Override
 public void onCreate(Bundle savedInstanceState) {
  super.onCreate(savedInstanceState);
  setContentView(R.layout.main);

  EditText myTextBox = (EditText) findViewById(R.id.myTextBox);
  myTextBox.addTextChangedListener(new TextWatcher() {

   public void afterTextChanged(Editable s) {
   }

   public void beforeTextChanged(CharSequence s, int start,
     int count, int after) {
   }

   public void onTextChanged(CharSequence s, int start, int before, int count) {
   TextView myOutputBox = (TextView) findViewById(R.id.myOutputBox);
   myOutputBox.setText(s);
   }
  });

 }
}

    */


   // EditText mEditText = (EditText) findViewById(R.id.edit_txt_id);
   // TextView mText = (TextView) findViewById(R.id.txt_id2);

    //try
   //neee public void msgTxt2(String str) { mText.setText(str);  }
    //neee public void msgEdit1(String str) {   mEditText.setText(str);  }


     String mstr = "";

    //Class to be injected in Web page
    public class WebAppInterface {
        Context mContext;

        //EditText mEditText = (EditText) findViewById(R.id.edit_txt_id);
        //TextView mText = (TextView) findViewById(R.id.edit_txt_id2);

        /** Instantiate the interface and set the context */
        WebAppInterface(Context c) {
            mContext = c;
        }



        @JavascriptInterface
        public void showToast(String str) {
            makeText(mContext, str, Toast.LENGTH_LONG).show();
        }
        @JavascriptInterface
        public void showSnackbar(String str) {
            Snackbar.make(browser, str, Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
        }


        @JavascriptInterface
        public void showMsgEdit2(String str) {
            makeText(mContext, "showMsgEdit2: " + str, Toast.LENGTH_LONG).show();
            // mstr global to func:
            mstr = str;
            sendMessageEdit2fromWebView(getWindow().getDecorView());
        }

        // try EditText setText but no happy
        @JavascriptInterface
        public void showMessageInEditTextText(String str) {
            CharSequence c1="";
            CharSequence c2="";
            c2 = (CharSequence) str;
            c2 = (CharSequence) c2;

            int test = 3;
            // EditText   not happy
            if(1==test){  EditText editText = (EditText) findViewById(R.id.edit_txt_id);
                ////   editText.setText(c2);
                editText.setText(Editable.Factory.getInstance().newEditable(c2) , EDITABLE );
            }
            if(2==test){  TextView editText = (TextView) findViewById(R.id.txt_id2);
                editText.setText(str); }

            // TextView   always works:
            if(3==test){  TextView textView = (TextView) findViewById(R.id.txt_id2);
                textView.setText(str);
                // int timee=100;
                // while(1 < timee--){}
            }
             /*
            a strange difference:
            textView.setText(str);  // test=3  always works
            editText.setText(str);  // test=1 test=2 only works if the onscreen keyboard is popped up / active, for input in the WebView active, and the send button is clicked exactly during this time, the onscreen keyboard is popped up
            */
        }
        // try EditText setText but no happy
        @JavascriptInterface
        public void showMessageInEditText(String str) {
                CharSequence c2="";
                c2 = (CharSequence) str;
                c2 = (CharSequence) c2;

             int test = 1;
             if(1==test){  EditText editText = (EditText) findViewById(R.id.edit_txt_id);
                 ////   editText.setText(c2);
                editText.setText(Editable.Factory.getInstance().newEditable(c2) , EDITABLE );

             }

             if(2==test){  TextView editText = (TextView) findViewById(R.id.txt_id2);
                 editText.setText(str); }

             if(3==test){  TextView textView = (TextView) findViewById(R.id.txt_id2);
                 textView.setText(str);
                 // int timee=100;
                // while(1 < timee--){}
             }
        }

    }
    /// web app interface




    // Called when the user taps the Android Send button "TO ACTIVITY2",
    // send msg to Edit activity2 in Android
    public void sendMessageEdit2(View view) {
        // Do something in response to button.
        //
        ///Intent intent send to new activity
        // The Intent constructor takes two parameters, a Context and a Class.
        // The Context parameter is used first because the Activity class is a subclass of Context.
        // The Class parameter of the app component, to which the system delivers the Intent, is, in this case, the activity to start.
        //
        ///intent.putExtra() method adds the value of EditText-widget to the intent. An Intent can carry
        // data types as key-value pairs called extras.
        //
        ///startActivity() method starts an instance of the DisplayMessageActivity that's
        // specified by the Intent. Next, you need to create that class.
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.edit_txt_id);
        TextView textView =   findViewById(R.id.txt_id2);

        String message = editText.getText().toString() + "" + textView.getText().toString()  ;

        //old add for send from WebView, now nu. , add function  sendMessageEdit2fromWebView()
        // nu. // if("" != mstr)message = mstr;
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    // Called when the user taps in WebView button "Edit2 Activity2",
    // send msg from browser WevWiew to @JavascriptInterface to Edit in Activity2 in Android
    public void sendMessageEdit2fromWebView(View view) {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        intent.putExtra(EXTRA_MESSAGE, mstr);
        startActivity(intent);
    }



    // Called when the user taps the Send button
    /// * Send data to webview through index.htm>js> function updateFromNative.
    public void sendMessageToWebViewInput(View view) {
        //        // Capture the layout's TextView and set the string as its text
        //        //try  EditText textView2 = findViewById(R.id.edit_txt_id);
        //        //try  textView2.setText(message);
        //        TextView textView = findViewById(R.id.edit_txt_id);
        //        textView.setText(message);
        TextView textView = findViewById(R.id.edit_txt_id);
        String str;
            //str = " in sendMessageToWebView ";
            //textView2.setText(str);
        str = textView.getText().toString();
            //kt: "javascript: " +"sendJsToWebView(\"" + mEdit.text + "\")" ,
        browser.evaluateJavascript(
                "javascript: " +"sendJsToWebView(\"" + str + "\")",
                null  );
    }


}
///end class MainActivity extends AppCompatActivity


