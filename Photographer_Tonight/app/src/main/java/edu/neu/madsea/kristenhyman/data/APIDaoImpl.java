package edu.neu.madsea.kristenhyman.data;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.google.gson.Gson;

import org.json.JSONArray;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class APIDaoImpl {

    LiveData<List<Project>> getAllGigs(){

        MutableLiveData<List<Project>> gigsList = new MutableLiveData<>();

        OkHttpClient client = new OkHttpClient();
        Request get = new Request.Builder()
                .url("https://www.photographertonight.com/api/1.1/obj/gig")
                .method("GET", null)
                .addHeader("Authorization", "Bearer 4e2ad17b442815098e0ea222774b0a78")
                .build();

        client.newCall(get).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) {
                try {
                    ResponseBody responseBody = response.body();

                    Log.i("data", responseBody.string());

                     try {
                     //JSONArray jArray = new JSONArray(responseBody);
                     Gson gson = new Gson();
                     ResponseResult responseResult = gson.fromJson(response.body().string(), ResponseResult.class);
                     Log.i("responseResult", responseResult.getData().toString());

                     //get the list of projects out of responseResult to post as the gigList
                     gigsList.postValue(responseResult.getData());

                     }

                     catch (Exception e){
                     Log.e("JSONException", "Error: " + e.toString());
                     }



                    if (!response.isSuccessful()) {
                        throw new IOException("Unexpected code " + response);
                    }


                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        });

        return gigsList;
}

}
