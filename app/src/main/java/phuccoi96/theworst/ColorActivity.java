/********************************************************************************************************
 * This is out color screen activty page.  It declares a private media player. Once the page is created,
 * we call create a custome arrayList of word objects that we pass in information for the family page.
 * We then set the activity up with ListView adapter.
 * Created By: Nathan Nguyen
 * Date: 1/15/17
 ********************************************************************************************************/

package phuccoi96.theworst;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorActivity extends AppCompatActivity {

    private MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.color_list_view);

        // Create new arrayList
        final ArrayList<Word> colorList = new ArrayList<Word>();

        // Add elements into our array list
        colorList.add(new Word("Black", "đen", R.drawable.color_black, R.raw.black, R.drawable.ic_play_arrow_black_24dp));
        colorList.add(new Word("Brown", "Xanh", R.drawable.color_brown, R.raw.brown, R.drawable.ic_play_arrow_black_24dp));
        colorList.add(new Word("Gray", "Xám", R.drawable.color_gray, R.raw.gray, R.drawable.ic_play_arrow_black_24dp));
        colorList.add(new Word("Green", "Xanh Lá Cây", R.drawable.color_green, R.raw.green, R.drawable.ic_play_arrow_black_24dp));
        colorList.add(new Word("Red", "đỏ", R.drawable.color_red, R.raw.red, R.drawable.ic_play_arrow_black_24dp));
        colorList.add(new Word("White", "Trắng", R.drawable.color_white, R.raw.white, R.drawable.ic_play_arrow_black_24dp));
        colorList.add(new Word("Yellow", "Vàng", R.drawable.color_dusty_yellow, R.raw.yellow, R.drawable.ic_play_arrow_black_24dp));

        // Create a word adapter
        final WordAdapter<Word> colorAdapter =
                new WordAdapter<Word>(this, colorList, R.color.colorColor);

        // Create the listView
        ListView colorView = (ListView) findViewById(R.id.colorListView);

        // Set the adapter to the listView
        colorView.setAdapter(colorAdapter);

        colorView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Word currentWordItem = colorList.get(position);

                mp = MediaPlayer.create(ColorActivity.this, currentWordItem.getSoundId());
                mp.start();

                // Release the resource after the audio is done playing
                mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
            }
        });
    }// end onCreate


}// end activity
