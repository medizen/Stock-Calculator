package com.medizen.stockcalc;

import com.google.ads.*;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class MainActivity extends Activity
{
        private EditText txtshares;
        private EditText txtpurchaseprice;
        private EditText txtsellprice;
        private EditText txtbuycommiss;
        private EditText txtsellcommiss;
        private TextView txtpurchasedfor;
        private TextView txtsoldfor;
        private TextView txtresult;
        private Button calcbtn;
        private Button resetbtn;
        private double shares = 0;
        private double purchaseprice = 0;
        private double sellprice = 0;
        private double buycommiss = 0;
        private double sellcommiss = 0;
        private double purchasefor = 0;
        private double soldfor = 0;
        private double result = 0;
        
    @Override
	public void onCreate(Bundle savedInstanceState)
	{
    	super.onCreate(savedInstanceState);
    	setContentView(R.layout.main);
    	initControls();
    	 // Create the adView     
    	AdView adView = new AdView(this, AdSize.BANNER, "a14f6a2870a8fe7");     
    	// Lookup your RelativeLayoutLayout assuming it’s been given     
    	// the attribute android:id="@+id/ad"     
    	RelativeLayout layout = (RelativeLayout)findViewById(R.id.ad);     
    	// Add the adView to it
    	layout.addView(adView);     
    	// Initiate a generic request to load it with an ad     
    	adView.loadAd(new AdRequest());
    	/*
        AdView adView = new AdView(this, AdSize.BANNER, "a14f6a2870a8fe7");
        RelativeLayout layout = (RelativeLayout) findViewById(R.id.adbanner);
        layout.addView(adView);
        AdRequest adRequest = new AdRequest();
        adView.loadAd(adRequest);
        */
    	
	}


	private void initControls()
	{
        	txtshares = (EditText)findViewById(R.id.txtshares);
        	txtpurchaseprice = (EditText)findViewById(R.id.txtpurchaseprice);
        	txtsellprice = (EditText)findViewById(R.id.txtsellprice);
        	txtbuycommiss = (EditText)findViewById(R.id.txtbuycommiss);
        	txtsellcommiss = (EditText)findViewById(R.id.txtsellcommiss);
        	txtpurchasedfor=(TextView)findViewById(R.id.txtpurchasedfor);
        	txtsoldfor=(TextView)findViewById(R.id.txtsoldfor);
        	txtresult=(TextView)findViewById(R.id.txtresult);
        	calcbtn = (Button)findViewById(R.id.calcbtn);
        	resetbtn = (Button)findViewById(R.id.resetbtn);
        	calcbtn.setOnClickListener(new Button.OnClickListener() { public void onClick (View v){ calculate(); }});
        	resetbtn.setOnClickListener(new Button.OnClickListener() { public void onClick (View v){ reset(); }});
        	

	}
	private void calculate()
	{
        	shares=Double.parseDouble(txtshares.getText().toString());
        	purchaseprice=Double.parseDouble(txtpurchaseprice.getText().toString());
        	sellprice=Double.parseDouble(txtsellprice.getText().toString());
        	sellcommiss=Double.parseDouble(txtsellcommiss.getText().toString());
        	buycommiss=Double.parseDouble(txtbuycommiss.getText().toString());
        	
        	
        	if (purchaseprice != 0 )
        	{
        		if (shares !=0)
        		{
        			if (buycommiss != 1)
        			{
        		
        				purchasefor=(purchaseprice*shares+buycommiss);
        			}
        		}
        	}
        	if (shares != 0 )
        	{
        		if (sellprice !=0)
        		{
        			if (sellcommiss != 0)
        			{
        		
        				soldfor=(shares*sellprice-sellcommiss);
        			}
        		}
        	}
        	result=(soldfor-purchasefor);
        	txtpurchasedfor.setText(Double.toString(purchasefor));
        	txtsoldfor.setText(Double.toString(soldfor));
        	txtresult.setText(Double.toString(result));
	}

	private void reset()
	{
			txtshares.setText("0");
			txtpurchaseprice.setText("0");
			txtsellprice.setText("0");
			txtbuycommiss.setText("0");
			txtsellcommiss.setText("0");
			txtpurchasedfor.setText("");
			txtsoldfor.setText("");
			txtresult.setText("");
	}

}


/*
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
public class MainActivity extends Activity {
	EditText shares;
	EditText purchaseprice;
	Button calc;
	TextView result;
    /** Called when the activity is first created. 
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        shares = (EditText) findViewById(R.id.shares);
        purchaseprice = (EditText) findViewById(R.id.purchaseprice);
        calc = (Button)	findViewById(R.id.calc);
        result = (TextView) findViewById(R.id.result);
    }
    
    public void doCalc (View view) {
    	double intshares = Double.parseDouble(shares.getText().toString());
    	double intpurchaseprice = Double.parseDouble(purchaseprice.getText().toString());
    	double mOutput = (intshares*intpurchaseprice);
    	result.setText("Output" + mOutput);
    }
}
*/