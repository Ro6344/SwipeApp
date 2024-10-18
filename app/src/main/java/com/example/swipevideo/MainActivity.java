package com.example.swipevideo;

import android.os.Bundle;
import android.provider.MediaStore;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager2.widget.ViewPager2;
import java.util.List;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    /**
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        final ViewPager2 videoViewPager = findViewById(R.id.videosViewPager);

        List<VideoItem> videoItemsList = new ArrayList<>();
        VideoItem videoBird = new VideoItem();
        videoBird.videoURL = "https://firebasestorage.googleapis.com/v0/b/fbconnection-f544b.appspot.com/o/202693-918730367_small.mp4?alt=media&token=8c4e902b-4756-448b-a43a-65b14d4109b0";
        videoBird.videoTitle = "Bird     Unique ID: 41205610";
        videoBird.videoDescription = "Bird watching out in nature";
        videoItemsList.add(videoBird);

        VideoItem videdoCity = new VideoItem();
        videdoCity.videoURL = "https://firebasestorage.googleapis.com/v0/b/fbconnection-f544b.appspot.com/o/155109-809859903_small.mp4?alt=media&token=a75ac348-0bb4-4009-bb7c-effa57956bad";
        videdoCity.videoTitle = "City     Unique ID: 41987045";
        videdoCity.videoDescription = "Traffic in the city";
        videoItemsList.add(videdoCity);

        VideoItem videoSunset = new VideoItem();
        videoSunset.videoURL = "https://firebasestorage.googleapis.com/v0/b/fbconnection-f544b.appspot.com/o/127256-738105411_small.mp4?alt=media&token=58dc9993-da9c-45b4-bad1-0a181e824910";
        videoSunset.videoTitle = "Sunset     Unique ID: 1407521";
        videoSunset.videoDescription = "Watching the sunset at the beach";
        videoItemsList.add(videoSunset);

        videoViewPager.setAdapter(new VideoAdapter(videoItemsList));

    }
}