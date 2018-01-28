/********************************************************************************************************
 * This is out number screen activty page.  It declares a private media player. Once the page is created,
 * we call create a custome arrayList of word objects that we pass in information for the family page.
 * We then set the activity up with ListView adapter.
 * Created By: Nathan Nguyen
 * Date: 1/15/17
 ********************************************************************************************************/

package phuccoi96.theworst;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import static android.media.AudioManager.AUDIOFOCUS_LOSS_TRANSIENT;
import static android.media.AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK;

public class NumberActivity extends AppCompatActivity {

    // create a media player
    private MediaPlayer mp;
    private AudioManager am;
    AudioManager.OnAudioFocusChangeListener amChangeListener =
            new AudioManager.OnAudioFocusChangeListener() {
                public void onAudioFocusChange(int focusChange) {
                    if (focusChange == AudioManager.AUDIOFOCUS_LOSS ||
                            focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                        // Lost audio focus, pause the audio file and change to the beggining
                        mp.pause();
                        mp.seekTo(0);
                    } else if (focusChange == AUDIOFOCUS_LOSS_TRANSIENT) {
                        // Pause playback
                    } else if (focusChange == AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                        // Lower the volume, keep playing
                    } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                        // Your app has been granted audio focus again
                        // Raise volume to normal, restart playback if necessary
                        mp.release();
                    }
                }
            };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.number_list_view);

        // Create ArrayList of words
        final ArrayList<Word> wordList = new ArrayList<Word>();

        // Get System Service
        am = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

        // Adding words into the adaptar
        wordList.add(new Word("One", "Một", R.drawable.number_one, R.raw.one, R.drawable.ic_play_arrow_black_24dp));
        wordList.add(new Word("Two", "Hai", R.drawable.number_two, R.raw.two, R.drawable.ic_play_arrow_black_24dp));
        wordList.add(new Word("Three", "Ba", R.drawable.number_three, R.raw.three, R.drawable.ic_play_arrow_black_24dp));
        wordList.add(new Word("Four", "Bốn", R.drawable.number_four, R.raw.four, R.drawable.ic_play_arrow_black_24dp));
        wordList.add(new Word("Five", "Năm", R.drawable.number_five, R.raw.five, R.drawable.ic_play_arrow_black_24dp));
        wordList.add(new Word("Six", "Sáu", R.drawable.number_six, R.raw.six, R.drawable.ic_play_arrow_black_24dp));
        wordList.add(new Word("Seven", "Bảy", R.drawable.number_seven, R.raw.seven, R.drawable.ic_play_arrow_black_24dp));
        wordList.add(new Word("Eight", "Tám", R.drawable.number_eight, R.raw.eight, R.drawable.ic_play_arrow_black_24dp));
        wordList.add(new Word("Nine", "Chín", R.drawable.number_nine, R.raw.nine, R.drawable.ic_play_arrow_black_24dp));
        wordList.add(new Word("Ten", "Mười", R.drawable.number_ten, R.raw.ten, R.drawable.ic_play_arrow_black_24dp));


        // Create Array Adapter for List
        WordAdapter<Word> adapter =
                new WordAdapter<Word>(this, wordList, R.color.numColor);

        // Create ListView object
        ListView myListView = (ListView) findViewById(R.id.numberListView);

        // Add the Array adapter into the ListView
        myListView.setAdapter(adapter);

        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Word currentWordItem = wordList.get(position);

                // Request audio focus for playback
                int result = am.requestAudioFocus(amChangeListener,
                        // Use the music stream.
                        AudioManager.STREAM_MUSIC,
                        // Request permanent focus.
                        AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    // Start when we have audio focus
                    mp = MediaPlayer.create(NumberActivity.this, currentWordItem.getSoundId());
                    mp.start();

                }

                // Release the resource after the audio is done playing
                mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                        am.abandonAudioFocus(amChangeListener);
                    }
                });
            }
        });



    }// end onCreate


}// end activity
