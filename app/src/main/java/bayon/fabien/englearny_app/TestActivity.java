package bayon.fabien.englearny_app;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TestActivity extends AppCompatActivity implements OnTestListClickListener {

    private RecyclerView testListRecyclerView;
    private RecyclerView.Adapter testListAdapter;
    private RecyclerView.LayoutManager testListLayoutManager;

    TextView textView;
    private List<Tests> testList;



    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);


        testListRecyclerView = findViewById(R.id.testRecyclerView);

        testListRecyclerView.setHasFixedSize(true);


        testListLayoutManager = new LinearLayoutManager(this);
        testListRecyclerView.setLayoutManager(testListLayoutManager);


        testList = new ArrayList<>();


        Call<Tests[]> testCall = ApiClient.getResultsApi().getListTests();
        testCall.enqueue(new Callback<Tests[]>() {
            @Override
            public void onResponse(Call<Tests[]> call, Response<Tests[]> response) {

                for(int i = 0; i < response.body().length ; i++ ){
                    testList.add(new Tests(response.body()[i].getTestName()));
                }
                testListRecyclerView.setAdapter(new TestListAdapter(testList,(TestActivity.this)));

            }

            @Override
            public void onFailure(Call<Tests[]> call, Throwable t) {
                System.out.println(t.getMessage());
            }
        });

    }

    @Override
    public void OnTestListClickListener(Tests tests) {
        System.out.println(" IL A CLIQUEEEEE ");
    }
}



