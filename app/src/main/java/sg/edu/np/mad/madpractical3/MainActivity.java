package sg.edu.np.mad.madpractical3;

import static android.view.View.*;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import sg.edu.np.mad.madpractical3.R;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button flbutton = findViewById(R.id.Fbutton);
        Button msgbutton = findViewById(R.id.msgbutton);
        User user = initUser();
        setText(user,flbutton);
        flbutton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if(user.followed == true){
                    user.followed = false;
                    Toast.makeText(getApplicationContext(), "Followed", Toast.LENGTH_SHORT).show();

                }
                else{
                    user.followed = true;
                    Toast.makeText(getApplicationContext(), "Unfollowed", Toast.LENGTH_SHORT).show();

                }
                setText(user,flbutton);
            }

        });
        msgbutton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent act1 = new Intent(MainActivity.this, MessageGroup.class);
                startActivity(act1);
            }
        });
        Intent receivingEnd = getIntent();
        Integer numbers = receivingEnd.getIntExtra("number", 0);
        TextView mText = (TextView) findViewById(R.id.textView2);
        mText.setText("MAD" + " " + numbers.toString());
    }

    public User initUser(){
        User user = new User("username","desc",1,true);
        return user;
    }

    public void setText(User user,Button flbutton){
        TextView txt = flbutton;
        if(user.followed == true){
            txt.setText("Follow");
        }
        else{
            txt.setText("Unfollow");
        }
    }
}