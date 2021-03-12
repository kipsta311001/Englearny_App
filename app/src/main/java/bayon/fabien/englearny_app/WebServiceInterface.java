package bayon.fabien.englearny_app;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface WebServiceInterface {

        @GET("tests.json")
        Call<Tests[]> getListTests();



}
