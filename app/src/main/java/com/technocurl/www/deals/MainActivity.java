package com.technocurl.www.deals;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    String TAG = "dinesh";
    ProgressDialog progressDialog;
    ArrayList<GetdealData> getdealDataList = new ArrayList<>();
    ArrayList<GetdealData> getdealDataListFood = new ArrayList<>();
    ArrayList<GetdealData> getdealDataListFashion = new ArrayList<>();
    ArrayList<GetdealData> getdealDataListEnt = new ArrayList<>();

    RecyclerView recyclerView;

    LinearLayout food,fashion,ent,misc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));*/
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        food=(LinearLayout) findViewById(R.id.food);
        fashion=(LinearLayout)findViewById(R.id.fashion);
        ent=(LinearLayout)findViewById(R.id.ent);
        misc=(LinearLayout)findViewById(R.id.misc);
        food.setOnClickListener(this);
        fashion.setOnClickListener(this);
        ent.setOnClickListener(this);
        misc.setOnClickListener(this);
        setSupportActionBar(toolbar);
        new GetPost().execute();
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.food:
                Intent intent=new Intent(MainActivity.this,AllActivity.class);
                intent.putExtra("mylist", getdealDataListFood);
                startActivity(intent);

                break;
            case R.id.fashion:
                Intent fashion=new Intent(MainActivity.this,AllActivity.class);
                fashion.putExtra("mylist", getdealDataListFashion);
                startActivity(fashion);
                break;
            case R.id.ent:
                Intent ent=new Intent(MainActivity.this,AllActivity.class);
                ent.putExtra("mylist", getdealDataListEnt);
                startActivity(ent);
                break;
            case R.id.misc:
                Intent misc=new Intent(MainActivity.this,AllActivity.class);
                misc.putExtra("mylist", getdealDataList);
                startActivity(misc);
                break;
        }
    }

    public class GetPost extends AsyncTask<String, String, String> {
        @Override
        protected String doInBackground(String... params) {
            HttpUrlConnectionJson httpUrlConnectionJson = new HttpUrlConnectionJson();
            JSONObject jsonObject = new JSONObject();
            GetdealData getData = new GetdealData();
            try {
                jsonObject.put("cust_id","20234702");
                jsonObject.put("lng","85.332416");
                jsonObject.put("lat","27.700000");
                jsonObject.put("rad","10");
                Log.d(TAG, "get near by deal : " + jsonObject.toString());
                String result = httpUrlConnectionJson.sendHTTPData("https://node.qpaysolutions.net/QPay.svc/getnearbydeals", jsonObject);
                JSONObject jsonObject1 = new JSONObject(result);
                JSONObject jsonObject2 = jsonObject1.getJSONObject("GetNearByDealsResult");
                JSONArray jsonArray = jsonObject2.getJSONArray("nearByDeals");
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject3 = jsonArray.getJSONObject(i);
                    String category = jsonObject3.getString("category");
                    String dealDesc = jsonObject3.getString("dealDesc");
                    String dealId = jsonObject3.getString("dealId");
                    String distance = jsonObject3.getString("distance");
                    String estbName = jsonObject3.getString("estbName");
                    String featureFlag = jsonObject3.getString("featureFlag");
                    String imgUrl1 = jsonObject3.getString("imgUrl1");
                    String imgUrl2 = jsonObject3.getString("imgUrl2");
                    String imgUrl3 = jsonObject3.getString("imgUrl3");
                    String imgUrl4 = jsonObject3.getString("imgurl4");
                    String imgUrl5 = jsonObject3.getString("imgurl5");
                    String imgUrl6 = jsonObject3.getString("imgurl6");
                    String imgUrl7 = jsonObject3.getString("imgurl7");
                    String imgUrl8 = jsonObject3.getString("imgurl8");
                    String locLat = jsonObject3.getString("locLat");
                    String locLng = jsonObject3.getString("locLng");
                    String locPhone = jsonObject3.getString("locPhone");
                    String website = jsonObject3.getString("website");
                    if (category.endsWith("Food")){
                        getData.setDealDesc(dealDesc);
                        getData.setDealId(dealId);
                        getData.setDistance(distance);
                        getData.setEstbName(estbName);
                        getData.setImgUrl1(imgUrl1);
                        getData.setImgUrl2(imgUrl2);
                        getData.setImgUrl3(imgUrl3);
                        getData.setLocLat(locLat);
                        getData.setLocLng(locLng);
                        getData.setLocPhone(locPhone);
                        getData.setWebsite(website);
                        getData.setFeatureFlag(featureFlag);
                        getData.setImgUrl4(imgUrl4);
                        getData.setImgUrl5(imgUrl5);
                        getData.setImgUrl6(imgUrl6);
                        getData.setImgUrl7(imgUrl7);
                        getData.setImgUrl8(imgUrl8);
                        getdealDataListFood.add(getData);
                    }else if (category.equalsIgnoreCase("Fashion")){
                        getData.setDealDesc(dealDesc);
                        getData.setDealId(dealId);
                        getData.setDistance(distance);
                        getData.setEstbName(estbName);
                        getData.setImgUrl1(imgUrl1);
                        getData.setImgUrl2(imgUrl2);
                        getData.setImgUrl3(imgUrl3);
                        getData.setLocLat(locLat);
                        getData.setLocLng(locLng);
                        getData.setLocPhone(locPhone);
                        getData.setWebsite(website);
                        getData.setFeatureFlag(featureFlag);
                        getData.setImgUrl4(imgUrl4);
                        getData.setImgUrl5(imgUrl5);
                        getData.setImgUrl6(imgUrl6);
                        getData.setImgUrl7(imgUrl7);
                        getData.setImgUrl8(imgUrl8);
                        getdealDataListFashion.add(getData);
                    }else if (category.equalsIgnoreCase("Entertainment")){
                        getData.setDealDesc(dealDesc);
                        getData.setDealId(dealId);
                        getData.setDistance(distance);
                        getData.setEstbName(estbName);
                        getData.setImgUrl1(imgUrl1);
                        getData.setImgUrl2(imgUrl2);
                        getData.setImgUrl3(imgUrl3);
                        getData.setLocLat(locLat);
                        getData.setLocLng(locLng);
                        getData.setLocPhone(locPhone);
                        getData.setWebsite(website);
                        getData.setFeatureFlag(featureFlag);
                        getData.setImgUrl4(imgUrl4);
                        getData.setImgUrl5(imgUrl5);
                        getData.setImgUrl6(imgUrl6);
                        getData.setImgUrl7(imgUrl7);
                        getData.setImgUrl8(imgUrl8);
                        getdealDataListEnt.add(getData);
                    }else if (category.equals("")){
                        getData.setDealDesc(dealDesc);
                        getData.setDealId(dealId);
                        getData.setDistance(distance);
                        getData.setEstbName(estbName);
                        getData.setImgUrl1(imgUrl1);
                        getData.setImgUrl2(imgUrl2);
                        getData.setImgUrl3(imgUrl3);
                        getData.setLocLat(locLat);
                        getData.setLocLng(locLng);
                        getData.setLocPhone(locPhone);
                        getData.setWebsite(website);
                        getData.setFeatureFlag(featureFlag);
                        getData.setImgUrl4(imgUrl4);
                        getData.setImgUrl5(imgUrl5);
                        getData.setImgUrl6(imgUrl6);
                        getData.setImgUrl7(imgUrl7);
                        getData.setImgUrl8(imgUrl8);
                        getdealDataList.add(getData);
                    }




                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog = new ProgressDialog(MainActivity.this);
            progressDialog.setIndeterminate(false);
            progressDialog.setCancelable(false);
            progressDialog.show();
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            progressDialog.dismiss();


//            recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
//            adapter = new DealAdapter(MainActivity.this, getdealDataList);
//            recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
//            recyclerView.setAdapter(adapter);
//            recyclerView.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(10), true));
//            recyclerView.setItemAnimator(new DefaultItemAnimator());
//            recyclerView.setAdapter(adapter);
        }
    }


}
