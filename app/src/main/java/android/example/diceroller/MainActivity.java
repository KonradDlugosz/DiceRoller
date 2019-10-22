package android.example.diceroller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView tv;
    private TextView score;
    int counter = 0;
    private EditText userInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = this.findViewById(R.id.numberTextView);
        userInput= (EditText) findViewById(R.id.numberToCompare);
        score = this.findViewById(R.id.score);
    }

    public void on_button_click(View view)
    {
        int intuserInput= Integer.parseInt(userInput.getText().toString());

        //Random Dice number
        Random r = new Random();
        int num = r.nextInt(7);
        tv.setText(Integer.toString(num));
        Context context = MainActivity.this;

        //Compare numbers
        if( intuserInput > 6 || intuserInput < 1 ){
            //Display message
            String textToShow = "Enter number from 1 to 6";
            Toast.makeText(context, textToShow, Toast.LENGTH_SHORT).show();

        }
        else if(num == intuserInput){
            //Count score
            counter = counter + 1;
            score.setText(Integer.toString(counter));
            //Display message Scored
            String textToShow = "Congratulations, You matched the dice!";
            Toast.makeText(context, textToShow, Toast.LENGTH_SHORT).show();

        }

    }



}
