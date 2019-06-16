package info.androidhive.retrofit.model.ViewModel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;

import info.androidhive.retrofit.model.pojo.DataObject;
import info.androidhive.retrofit.model.pojo.EpisodesResponse;
import info.androidhive.retrofit.rest.ApiClient;
import info.androidhive.retrofit.rest.ApiInterface;
import io.reactivex.disposables.CompositeDisposable;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivityViewModel extends ViewModel {

    private CompositeDisposable disposable = new CompositeDisposable();
    private String TAG = MainActivityViewModel.class.getSimpleName();
    private MutableLiveData<DataObject> mainResponse;

    public LiveData<DataObject> getMainResponse() {
        if (mainResponse == null) {
            mainResponse = new MutableLiveData<>();
            loadFruits();
        }
        return mainResponse;
    }

    private void loadFruits() {
        // do async operation to fetch users
        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);


        Call<EpisodesResponse> call = apiService.getTopEpisodes();

        call.enqueue(new Callback<EpisodesResponse>() {
            @Override
            public void onResponse(Call<EpisodesResponse> call, Response<EpisodesResponse> response) {
                int statusCode = response.code();
                DataObject movies = response.body().getData();
                mainResponse.setValue(movies);
            }

            @Override
            public void onFailure(Call<EpisodesResponse> call, Throwable t) {
                // Log error here since request failed
                Log.e(TAG, t.toString());
            }
        });

    }

    @Override
    protected void onCleared() {
        super.onCleared();
        Log.d(TAG, "on cleared called");
    }
}
