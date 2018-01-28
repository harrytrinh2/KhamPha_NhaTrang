/********************************************************************************************************
 * This is the word class that will be holding both English and Vietnamese words.
 * Created by: Nathan Nguyem
 * Date: 1/15/17.
 ********************************************************************************************************/
package phuccoi96.theworst;


public class Word  {

    // Variables
    private String engWord;
    private String vietWord;
    private int imageId = -1;
    private int soundId;
    private int playIcon;


    // Constructor w/o img
    public Word(String eng, String viet){
        this.engWord = eng;
        this.vietWord = viet;
    }

    // Constructor w/o img
    public Word(String eng, String viet, int sound, boolean image, int play){
        this.engWord = eng;
        this.vietWord = viet;
        this.soundId = sound;
        this.playIcon = play;
    }

    // Constructor w/ img
    public Word(String eng, String viet, int source){
        this.engWord = eng;
        this.vietWord = viet;
        this.imageId = source;
    }

    // Constructor w/ img & sound
    public Word(String eng, String viet, int source, int sound){
        this.engWord = eng;
        this.vietWord = viet;
        this.imageId = source;
        this.soundId = sound;
    }

    // Constructor w/ play button
    public Word(String eng, String viet, int source, int sound, int play){
        this.engWord = eng;
        this.vietWord = viet;
        this.imageId = source;
        this.soundId = sound;
        this.playIcon = play;
    }

    /**
     * Getter & Setter for variables
     */
    public String getVietWord() {
        return vietWord;
    }

    public String getEngWord() {
        return engWord;
    }

    public int getImageId() {
        return imageId;
    }

    public boolean hasImage(){
        return imageId != -1;
    }

    public int getSoundId() {
        return soundId;
    }

    public int getPlayIcon() {
        return playIcon;

    }
}// end Word class
