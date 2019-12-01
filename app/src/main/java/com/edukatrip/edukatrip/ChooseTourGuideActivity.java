package com.edukatrip.edukatrip;

import android.os.Bundle;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.edukatrip.edukatrip.adapter.ListTourGuideAdapter;
import com.edukatrip.edukatrip.model.Guide;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class ChooseTourGuideActivity extends AppCompatActivity {
    private ListView listView;
    private ListTourGuideAdapter adapter;
    private ArrayList<Guide> guides = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_tour_guide);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(R.string.choose_tour_guide);

        listView = (ListView) findViewById(R.id.ls_tour_guide);
        getGuidesFromDb();
        adapter = new ListTourGuideAdapter(this, guides, getLayoutInflater());
        listView.setAdapter(adapter);

    }

    private void getGuidesFromDb() {
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("guides")
                .whereEqualTo("guideStatus", "Available")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Guide guide = document.toObject(Guide.class);
                                guides.add(guide);
                                adapter.notifyDataSetChanged();
                            }
                        } else {
                            //Error getting document
                        }
                    }
                });
    }
}
