package com.example.hero;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.SearchView;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link femalefragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class femalefragment extends Fragment implements  RecyclerViewAdapterFemale.OnItemClickListener{
    private DrawerLayout drawer;
    private RecyclerView recyclerView;
    private ArrayList<basic> recyclerDataArrayList;
    private RecyclerViewAdapterFemale recyclerViewAdapterFemale;
    private ProgressBar progressBar;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public femalefragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment femalefragment.
     */
    // TODO: Rename and change types and number of parameters
    public static femalefragment newInstance(String param1, String param2) {
        femalefragment fragment = new femalefragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_femalefragment, container, false);
        drawer = view.findViewById(R.id.drawer_layout);
        recyclerView = view.findViewById(R.id.heroes_list_female);
        progressBar = view.findViewById(R.id.progress_bar);
        recyclerDataArrayList = new ArrayList<>();
        setHasOptionsMenu(true);

        getAllCourses();

        return view;
    }

    private void getAllCourses(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://akabab.github.io/superhero-api/api/")

                .addConverterFactory(GsonConverterFactory.create())

                .build();

        Api retrofitAPI = retrofit.create(Api.class);


        Call<ArrayList<basic>> call = retrofitAPI.getAllCourses();


        call.enqueue(new Callback<ArrayList<basic>>() {
            @Override
            public void onResponse(Call<ArrayList<basic>> call, Response<ArrayList<basic>> response) {

                if (response.isSuccessful()) {


                    progressBar.setVisibility(View.GONE);


                    recyclerDataArrayList = response.body();


                    for (int i = 0; i < Objects.requireNonNull(recyclerDataArrayList).size(); i++) {
                        recyclerViewAdapterFemale = new RecyclerViewAdapterFemale   (recyclerDataArrayList,getContext());


                        LinearLayoutManager manager = new LinearLayoutManager(getContext());


                        recyclerView.setLayoutManager(manager);


                        recyclerView.setAdapter(recyclerViewAdapterFemale);
                        recyclerViewAdapterFemale.setOnItemClickListener(femalefragment.this);

                    }


                }



            }



            @Override
            public void onFailure(Call<ArrayList<basic>> call, Throwable t) {

                Toast.makeText(getContext(), "Fail to get data", Toast.LENGTH_SHORT).show();
            }
        });
    }








    @Override
    public void onItemClick(int position) {

        Intent detailIntent = new Intent(femalefragment.this.getActivity(),DetailActivity.class);

        detailIntent.putExtra("selected_note",recyclerDataArrayList.get(position));
        startActivity(detailIntent);



    }


    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {

        MenuInflater inflater1 = requireActivity().getMenuInflater();
        inflater1.inflate(R.menu.example_search,menu);


        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) searchItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if(recyclerViewAdapterFemale != null){
                    recyclerViewAdapterFemale.getFilter().filter(newText);

                }

                return false;
            }
        });

        super.onCreateOptionsMenu(menu, inflater);



    }


}