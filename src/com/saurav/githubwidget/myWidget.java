package com.saurav.githubwidget;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.example.widdemo.R;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.RemoteViews;


public class myWidget extends AppWidgetProvider  {

	Context myContext;
	public  ArrayList<String> restDataname = new ArrayList<String>();
	public  ArrayList<String> restDataurl = new ArrayList<String>();
	@Override
	public void onEnabled(Context context) {
		// TODO Auto-generated method stub
		myContext = context;
		Log.d("Saurav", "Starting AsyncTask!");
		new FetchGithubData().execute("https://api.github.com/users/kodered/starred");
	}


	@Override
	public void onUpdate(Context context, AppWidgetManager appWidgetManager,
			int[] appWidgetIds) {
		// TODO Auto-generated method stub
		Log.d("Saurav", "Inside OnUpdate of the Widget!");
		super.onUpdate(context, appWidgetManager, appWidgetIds);
		
	}
	
	public void updateWidgetView()
	{
		Log.d("Saurav", "Updating The widgetView!");
		
		  RemoteViews remoteViews = new RemoteViews(myContext.getPackageName(),
		          R.layout.widget_layout);
		  ComponentName thisWidget = new ComponentName( myContext, myWidget.class );
		      
		  		//contents of first tab
		      	remoteViews.setImageViewResource(R.id.imageView, R.drawable.github1);
		      	remoteViews.setTextViewText(R.id.heading, restDataname.get(0));
		      	remoteViews.setTextViewText(R.id.content, restDataurl.get(0));
		      	
		        //contents of first tab
		      	remoteViews.setImageViewResource(R.id.imageView1, R.drawable.github1);
		      	remoteViews.setTextViewText(R.id.heading1,restDataname.get(1));
		      	remoteViews.setTextViewText(R.id.content1,restDataurl.get(1));
		      	
		        //contents of first tab
		      	remoteViews.setImageViewResource(R.id.imageView2, R.drawable.github1);
		      	remoteViews.setTextViewText(R.id.heading2,restDataname.get(2));
		      	remoteViews.setTextViewText(R.id.content2,restDataurl.get(2));
		      	
		        //contents of first tab
		      	remoteViews.setImageViewResource(R.id.imageView3, R.drawable.github1);
		      	remoteViews.setTextViewText(R.id.heading3,restDataname.get(3));
		      	remoteViews.setTextViewText(R.id.content3,restDataurl.get(3));
		      	
		        //contents of first tab
		      	remoteViews.setImageViewResource(R.id.imageView4, R.drawable.github1);
		      	remoteViews.setTextViewText(R.id.heading4,restDataname.get(4));
		      	remoteViews.setTextViewText(R.id.content4,restDataurl.get(4));
		      	
		      	AppWidgetManager.getInstance(myContext).updateAppWidget(thisWidget, remoteViews);

	}

	
	//class to fetch Github data 
	class FetchGithubData extends AsyncTask<String, String, String>{
		
		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			super.onPreExecute();
		}
		@Override
		protected void onProgressUpdate(String... values) {
			// TODO Auto-generated method stub
			super.onProgressUpdate(values);
		}

		@Override
		protected String doInBackground(String... uri) {
			HttpClient httpclient = new DefaultHttpClient();
			HttpResponse response;
			String responseString = null;
			try {
				response = httpclient.execute(new HttpGet(uri[0]));
				StatusLine statusLine = response.getStatusLine();
				if(statusLine.getStatusCode() == HttpStatus.SC_OK){
					ByteArrayOutputStream out = new ByteArrayOutputStream();
					response.getEntity().writeTo(out);
					out.close();
					responseString = out.toString();
				} else{
					//Closes the connection.
					response.getEntity().getContent().close();
					throw new IOException(statusLine.getReasonPhrase());
				}
			} catch (ClientProtocolException e) {
				//TODO Handle problems..
			} catch (IOException e) {
				//TODO Handle problems..
			}
			return responseString;

		}

		@Override
		protected void onPostExecute(String result) {
			JSONArray jarray = null;
			super.onPostExecute(result);
			try {
				jarray = new JSONArray(result);

				JSONArray json = jarray;
				
				for(int i=0;i<10;i++)
				{
					try{
						JSONObject c = json.getJSONObject(i);
						Log.d("Saurav",c.getString("name"));
						Log.d("Saurav",c.getString("full_name"));
						restDataname.add(c.getString("name"));
						restDataurl.add(c.getString("full_name"));
						
					}
					catch(Exception e)
					{
						Log.d("####","JSon Parsing Exception:"+e);
					}
				}

			} catch (JSONException e) {
				Log.e("JSON Parser", "Error parsing data " + e.toString());
			}
			// Log.d("####",result);
			Log.d("Saurav", "AsyncTask Over");
			updateWidgetView();
		}
	}

}
