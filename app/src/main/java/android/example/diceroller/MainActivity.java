package android.example.diceroller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView tv;
    private TextView score;
    int counter = 0;
    private EditText userInput;
    private int intuserInput;
    private int num ;
    private ArrayList<String> arr = new ArrayList<String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = this.findViewById(R.id.numberTextView);
        userInput= (EditText) findViewById(R.id.numberToCompare);
        score = this.findViewById(R.id.score);
        add_data_to_array();

    }

    public void bt_lucky(View view)
    {
        //get input and display
        intuserInput= Integer.parseInt(userInput.getText().toString());
        tv.setText(Integer.toString(num));
        Context context = MainActivity.this;
        num = roll_the_dice();

        //Compare numbers
        if( intuserInput > 6 || intuserInput < 1){
            //Display message
            String textToShow = "Enter number from 1 to 6";
            Toast.makeText(context, textToShow, Toast.LENGTH_SHORT).show();

        }
        else if(num == intuserInput) {
            //Count score
            counter = counter + 1;
            score.setText(Integer.toString(counter));
            //Display message Scored
            String textToShow = "Congratulations, You matched the dice!";
            Toast.makeText(context, textToShow, Toast.LENGTH_SHORT).show();

        }

    }
    public void d_icebreakers(View view){
        num = roll_the_dice();
        switch (num){
            case 1:
                score.setText(arr.get(0));
                tv.setText(Integer.toString(num));
                break;
            case 2:
                score.setText(arr.get(1));
                tv.setText(Integer.toString(num));
                break;
            case 3:
                score.setText(arr.get(2));
                tv.setText(Integer.toString(num));
                break;
            case 4:
                score.setText(arr.get(3));
                tv.setText(Integer.toString(num));
                break;
            case 5:
                score.setText(arr.get(4));
                tv.setText(Integer.toString(num));
                break;
            case 6:
                score.setText(arr.get(5));
                tv.setText(Integer.toString(num));
                break;

        }

    }

    //Roll the dice method
    public static int roll_the_dice(){
        Random r = new Random();
        int num = r.nextInt(6 )|+1;
        return num;
    }

    public void add_data_to_array(){
        //add data to ArrayList
        arr.add("If you could go anywhere in the world, where would you go?");
        arr.add("If you were stranded on a desert island, what three things would you want to take with you?");
        arr.add("If you could eat only one food for the rest of your life, what would that be?");
        arr.add("If you won a million dollars, what is the first thing you would buy?");
        arr.add("If you could spaned the day with one fictional character, who would it be?");
        arr.add("If you found a magic lantern and a genie gave you three wishes, what would you wish?");

    }



}
