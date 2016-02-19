package generalassembly.yuliyakaleda.startercode;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

  ArrayList<String> mWishList;
  ArrayAdapter<String> mAdapter;
  ListView wishListOut;
  TextView wishOut;
  EditText userInput;
  Button wishButton;
  Animation mSpinIn;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    mSpinIn = AnimationUtils.loadAnimation(MainActivity.this,R.anim.animation);
    wishListOut = (ListView)findViewById(R.id.wishListView);
    mWishList = new ArrayList<String>();
    mAdapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, mWishList);
    wishListOut.setAdapter(mAdapter);
    wishOut = (TextView) findViewById(R.id.wishOutTv);
    userInput = (EditText) findViewById(R.id.userInput);
    wishButton = (Button) findViewById(R.id.wishMakerButton);
    wishButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        wishOut.setText(userInput.getText());
        wishOut.startAnimation(mSpinIn);
        mWishList.add(userInput.getText().toString());
        mAdapter.notifyDataSetChanged();
        userInput.setText("");
      }
    });
    wishListOut.setOnItemClickListener(new AdapterView.OnItemClickListener() {
      @Override
      public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        mWishList.remove(position);
        mAdapter.notifyDataSetChanged();
      }
    });
  }
}