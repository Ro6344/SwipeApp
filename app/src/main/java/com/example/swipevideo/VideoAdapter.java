package com.example.swipevideo;

import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.VideoView;
import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.VideoViewHolder> {
    private List<VideoItem> videoItems;

    /**
     * Constructs a VideAdapter with specified list of video items
     * @param videoItems The list of video items to be displayed
     */
    public VideoAdapter(List<VideoItem> videoItems){
        this.videoItems = videoItems;
    }

    /**
     *Called when RecyclerView needs a new VoewHolder of the given type to represent an item. This method
     *  creates and returns a new VideoViewHolder
     * @param parent The ViewGroup into which the new View will be added after it is bound to
     *               an adapter position.
     * @param viewType The view type of the new View.
     *
     * @return A new VideoViewHolder that holds the view for the item
     */
    @NonNull
    @Override
    public VideoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new VideoViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(R.layout.item_contaainer_video, parent, false)
        );
    }

    /**
     *Called by RecyclerView to display the data at the specified position
     * This method updates the contents of the view holder to reflect the items at the
     * given position
     * @param holder The ViewHolder which should be updated to represent the contents of the
     *        item at the given position in the data set.
     * @param position The position of the item within the adapter's data set.
     */
    @Override
    public void onBindViewHolder(@NonNull VideoViewHolder holder, int position) {
        holder.setVideoData(videoItems.get(position));
    }

    /**
     *Returns the total number of items in the data set held by the adapter
     * @return The number of items in this adapter
     */
    @Override
    public int getItemCount() {
        return videoItems.size();
    }

    /**
     *ViewHolder class for holding view related to each video item
     */
    static class VideoViewHolder extends RecyclerView.ViewHolder {

        TextView textVideoTitle1, textVideoDescription1;
        VideoView videoView;
        ProgressBar progressBar;

        /**
         *Constructs a VideoViewHolder and initializes the view fro a video item
         * @param itemView The view that will hold the video item's layout
         */
        public VideoViewHolder(@NonNull View itemView) {
            super(itemView);
            videoView = itemView.findViewById(R.id.videoView);
            textVideoTitle1 = itemView.findViewById(R.id.textVideoTitle);
            textVideoDescription1 = itemView.findViewById(R.id.textVideoDescription);
            progressBar = itemView.findViewById(R.id.videoProgressBar);
        }

        /**
         *Bind the video data to the view in the ViewHolder
         * @param videoItem The videoItem object containing the data to be displayed
         */
        void setVideoData (VideoItem videoItem){
            textVideoTitle1.setText(videoItem.videoTitle);
            textVideoDescription1.setText(videoItem.videoDescription);
            videoView.setVideoPath(videoItem.videoURL);

            videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                    progressBar.setVisibility(View.GONE);
                    mp.start();

                    float videoRatio = mp.getVideoWidth() / (float) mp.getVideoHeight();
                    float screenRatio = videoView.getWidth() / (float) videoView.getHeight();

                    float scale = videoRatio / screenRatio;
                    if (scale >=1f){
                        videoView.setScaleX(scale);
                    }else{
                        videoView.setScaleY(1f / scale);
                    }

                }
            });
            /**
             *Listener that restarts the video upon completion
             */
            videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                    public void onCompletion(MediaPlayer mp) { mp.start();}
            });
        }
    }
}
