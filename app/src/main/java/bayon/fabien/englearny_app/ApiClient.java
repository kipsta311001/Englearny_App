package bayon.fabien.englearny_app;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient{
    private static Retrofit getRetrofit() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://serveur1.arras-sio.com/symfony4-4060/englearny/public/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit;
    }

    public static WebServiceInterface getResultsApi(){
        WebServiceInterface webServiceInterface = getRetrofit().create(WebServiceInterface.class);
        return webServiceInterface;
    }




}
