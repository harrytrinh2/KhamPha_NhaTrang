package phuccoi96.theworst;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;


public class Main_Language extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_language);

    } // end onCreate

    /**
     * This method will decide which activity screen will be opem
     */
    public void menuList(View view){
        Intent i = null;

        switch (view.getId()){
            case R.id.number:
                i = new Intent(this, NumberActivity.class);
                break;
            case  R.id.family:
                i = new Intent(this, FamilyActivity.class);
                break;
            case R.id.color:
                i = new Intent(this, ColorActivity.class);
                break;
            case R.id.phrase:
                i = new Intent(this, PhraseActivity.class);
                break;
            default:
        } // end switch statement

        startActivity(i);

    }// end menuList method

}// end activity

