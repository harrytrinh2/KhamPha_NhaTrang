/********************************************************************************************************
 * This is out phrase screen activty page.  It declares a private media player. Once the page is created,
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

public class PhraseActivity extends AppCompatActivity {

    private MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.phrase_list_view);

        // Create ArrayList of words
        final ArrayList<Word> phraseList = new ArrayList<Word>();

        // Adding words into the adaptar
        phraseList.add(new Word("Hello", "Chào anh", R.raw.hello, false, R.drawable.ic_play_arrow_black_24dp));
        phraseList.add(new Word("How are you?", "Chị khỏe không?", R.raw.howareyou, false, R.drawable.ic_play_arrow_black_24dp));
        phraseList.add(new Word("I'm fine, thank you", "Tôi khỏe, cảm ơn", R.raw.imfine, false, R.drawable.ic_play_arrow_black_24dp));
        phraseList.add(new Word("Nice to meet you", "Hân hạnh được biết chị", R.raw.niceto, false, R.drawable.ic_play_arrow_black_24dp));
        phraseList.add(new Word("Goodbye", "Tạm biệt", R.raw.goodbye, false, R.drawable.ic_play_arrow_black_24dp));
        phraseList.add(new Word("Do you speak English?", "Anh có nói tiếng Anh không?", R.raw.english, false, R.drawable.ic_play_arrow_black_24dp));
        phraseList.add(new Word("Yes, I speak English.", "Có, tôi nói tiếng Anh.", R.raw.yesenglish, false, R.drawable.ic_play_arrow_black_24dp));
        phraseList.add(new Word("No, I don't speak English.", "Không, tôi không nói tiếng Anh.", R.raw.noenglish, false, R.drawable.ic_play_arrow_black_24dp));


        // Create Array Adapter for List
        WordAdapter<Word> adapter =
                new WordAdapter<Word>(this, phraseList, R.color.phraseColor);

        // Create ListView
        ListView myListView = (ListView) findViewById(R.id.phraseListView);

        // Add the Array adapter into the ListView
        myListView.setAdapter(adapter);

        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Word currentWordItem = phraseList.get(position);

                mp = MediaPlayer.create(PhraseActivity.this, currentWordItem.getSoundId());
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
