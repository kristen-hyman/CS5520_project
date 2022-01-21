package edu.neu.madsea.kristenhyman.data;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.io.IOException;
import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class APIDaoImpl {

    String DEV_URL = "https://www.photographertonight.com/version-test/api/1.1/obj/gig";
    String PRODUCTION_URL = "https://www.photographertonight.com/api/1.1/obj/gig";

    LiveData<List<Project>> getAllGigs(){

        MutableLiveData<List<Project>> gigsList = new MutableLiveData<>();

        OkHttpClient client = new OkHttpClient();
        Request get = new Request.Builder()
                .url(PRODUCTION_URL)
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
                    String responseBodyString = responseBody.string();
                    Log.i("data", responseBodyString);

                    Gson gson = new GsonBuilder().registerTypeAdapter(LocalDateTime.class, new JsonDeserializer<LocalDateTime>() {
                        @Override
                        public LocalDateTime deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
                                throws JsonParseException {
                            return LocalDateTime.from(DateTimeFormatter.ISO_OFFSET_DATE_TIME.parse(json.getAsString()));
                        }
                    }).create();
                    APIResponseResult responseResult = gson.fromJson(responseBodyString, APIResponseResult.class);
                    List<Project> projects = responseResult.getAPIResponse().getData();

                    Log.i("APIResponseResult", responseResult.toString());

                    // Log.i("PROJECTS:", responseResult.getData().toString());
                    gigsList.postValue(projects);

                    if (!response.isSuccessful()) {
                        throw new IOException("Unexpected code " + response);
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
                response.body().close();
            }
        });

        return gigsList;
}

    void postProject(Project project) {


        try {
            OkHttpClient client = new OkHttpClient().newBuilder()
                    .build();
            MediaType mediaType = MediaType.parse("application/json");

            GsonBuilder gsonBuilder = new GsonBuilder();
            gsonBuilder.registerTypeAdapter(LocalDateTime.class, new LocalDateTimeSerializer());
            Gson gson = gsonBuilder.setPrettyPrinting().create();
            String jsonInString = gson.toJson(project);

            Log.i("project date", project.getDate().toString());
            Log.i("jsonInString: ", jsonInString);

            RequestBody body = RequestBody.create(mediaType, jsonInString);

            Log.i("project body toString(): ", body.toString());

            Request request = new Request.Builder()
                    .url(PRODUCTION_URL)
                    // .url(DEV_URL)
                    .method("POST", body)
                    .addHeader("Authorization", "Bearer 4e2ad17b442815098e0ea222774b0a78")
                    .addHeader("Content-Type", "application/json")
                    .build();

            Response response = client.newCall(request).execute();
            response.body().close();
        }
    catch (Exception e) {
            System.out.print("error posting new gig to API");
            e.printStackTrace();
    }

        return;
    }

}
