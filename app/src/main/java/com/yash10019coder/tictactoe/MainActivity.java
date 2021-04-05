package com.yash10019coder.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.yash10019coder.tictactoe.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    boolean currentPlayer = true;// true 1P false 2P
    int winningStates[][] = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, {0, 4, 8}, {2, 4, 6}};
    int gameState[] = {2, 2, 2, 2, 2, 2, 2, 2, 2};
    boolean won=false;
    // 0 is yellow 1 is red 2 is empty
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
//        binding.textView.setTextColor(0xFF00FF00);
        if (currentPlayer == true && won==false) {
            binding.textView.setText("Red player turn");
            binding.textView.setTextColor(0xFFFF0000);
        } else if(currentPlayer != true && won==false){
            binding.textView.setText("Yellow player turn");
            binding.textView.setTextColor(0xFFFFE100);
        }
    }

    public void btn(View view) {
        ImageView imageView = (ImageView) view;
        int tappedCounter = Integer.parseInt(view.getTag().toString());
        Animation aniFade = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in);
        if (gameState[tappedCounter] == 2 && won ==false) {
            if (currentPlayer == true) {
                currentPlayer = false;
//            imageView.setTranslationY(-1000);
//            imageView.animate().alpha(1).setDuration(300);
                gameState[tappedCounter] = 1;
                binding.textView.setText("Yellow player turn");
                binding.textView.setTextColor(0xFFFFE100);
                imageView.startAnimation(aniFade);
                imageView.animate().rotationBy(1000);
                imageView.setImageResource(R.drawable.red);
//            imageView.animate().translationYBy(1000).rotationBy((int)Math.random()*100).setDuration(700);
            } else {
                currentPlayer = true;
//            imageView.setTranslationY(-1000);
//            imageView.animate().alpha(1).setDuration(300);
                gameState[tappedCounter] = 0;
                binding.textView.setText("Red player turn");
                binding.textView.setTextColor(0xFFFF0000);
                imageView.startAnimation(aniFade);
                imageView.animate().rotationBy(1000);
                imageView.setImageResource(R.drawable.yellow);
//            imageView.animate().translationYBy(1000).rotationBy((int)Math.random()*100).setDuration(700);
            }
        }
        for (int winningState[] : winningStates) {
            if (gameState[winningState[0]] == gameState[winningState[1]] && gameState[winningState[1]] == gameState[winningState[2]] && gameState[winningState[0]] != 2)
            {
                won=true;
                binding.button.setVisibility(View.VISIBLE);
                if(currentPlayer==true) {
                    binding.textView.setText("Yellow has won");
                    binding.textView.setTextColor(0xFFFFE100);
                }else{
                    binding.textView.setText("Red has won");
                    binding.textView.setTextColor(0xFFFF0000);
                }
            }
        if(gameState[0]!=2&&gameState[1]!=2&&gameState[2]!=2&&gameState[3]!=2&&gameState[4]!=2&&gameState[5]!=2&&gameState[6]!=2&&gameState[7]!=2&&gameState[8]!=2&&won==false) {
            binding.textView.setText("It's a draw");
            binding.textView.setTextColor(0xFF00FF00);
            binding.button.setVisibility(View.VISIBLE);
        }

        }
    }

    public void clear(View view) {
        binding.button.setVisibility(View.INVISIBLE);
        currentPlayer = true;
        won = false;
        if (currentPlayer == true && won==false) {
            binding.textView.setText("Red player turn");
            binding.textView.setTextColor(0xFFFF0000);
        } else if(currentPlayer != true && won==false){
            binding.textView.setText("Yellow player turn");
            binding.textView.setTextColor(0xFFFFE100);
        }
        binding.imageView1.setImageResource(android.R.color.transparent);
        binding.imageView2.setImageResource(android.R.color.transparent);
        binding.imageView3.setImageResource(android.R.color.transparent);
        binding.imageView4.setImageResource(android.R.color.transparent);
        binding.imageView5.setImageResource(android.R.color.transparent);
        binding.imageView6.setImageResource(android.R.color.transparent);
        binding.imageView7.setImageResource(android.R.color.transparent);
        binding.imageView8.setImageResource(android.R.color.transparent);
        binding.imageView9.setImageResource(android.R.color.transparent);
//        binding.imageView1.setImageResource(android.R.color.transparent);
        for (int i = 0; i < 9; i++) {
            gameState[i] = 2;
        }

    }
}