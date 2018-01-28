/********************************************************************************************************
 * This class is a custom class that inherits from the parent ArrayAdapter class. This class will allow
 * the user to have multiple text views within a
 * Created by: Nathan Nguyen
 * Date: 1/15/17.
 ********************************************************************************************************/

package phuccoi96.theworst;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class WordAdapter<W> extends ArrayAdapter<Word> {

    private int colorID;

    // Custom constructor that initializes the activity and the list. Since we are using a custom
    // adapter, we will pass the middle arguement as 0.
    public WordAdapter(Activity context, ArrayList<Word> myList, int color){
        super(context, 0, myList);
        colorID = color;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View myView = convertView;

        // check if the view is null, if not, inflate the view
        if(myView == null){
           myView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }


        // Assign position of the list to our Word variable
        Word currentWordView = getItem(position);

        // We create a TextView amd assign it to the position in our list_item xml
        TextView engText = (TextView) myView.findViewById(R.id.engTextView);

        // We set the text to whatever is being passed into the function
        engText.setText(currentWordView.getEngWord());


        // Now we create a text view that will reference to the vietTexrtView in the list_item xml
        TextView vietText = (TextView) myView.findViewById(R.id.vietTextView);

        // Now we set it to the current word
        vietText.setText(currentWordView.getVietWord());

        // Get image reference from Word Object
        ImageView currentImage = (ImageView) myView.findViewById(R.id.listImage);

        if(currentWordView.hasImage()){
            // Assign the current image to the reference point
            currentImage.setImageResource(currentWordView.getImageId());
            currentImage.setVisibility(View.VISIBLE);
        }
        else{
            currentImage.setVisibility(View.GONE);
        }

        // Set background image to match the theme color
        int color = ContextCompat.getColor(getContext(), colorID);
        currentImage.setBackgroundColor(color);

        // get play buttom icon
        ImageView playIcon = (ImageView) myView.findViewById(R.id.playIcon);
        if(currentWordView.hasImage()){
            playIcon.setImageResource(currentWordView.getPlayIcon());
            playIcon.setVisibility(View.VISIBLE);

        }
        else {
            playIcon.setVisibility(View.GONE);
        }

        return myView;
    }
}
