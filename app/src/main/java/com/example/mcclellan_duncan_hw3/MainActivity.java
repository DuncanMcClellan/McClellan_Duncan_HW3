package com.example.mcclellan_duncan_hw3;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private boolean mGameStatus;
    private boolean compWin;
    private boolean userWin;
    private boolean tie;
    private Button[] mGameButtons;
    private Button btnNewGame;
    private TextView status;
    private char[] mBoard;
    //private mGame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mGameButtons = new Button[9];
        mGameButtons[0] = (Button) findViewById(R.id.btn_1);
        mGameButtons[1] = (Button) findViewById(R.id.btn_2);
        mGameButtons[2] = (Button) findViewById(R.id.btn_3);
        mGameButtons[3] = (Button) findViewById(R.id.btn_4);
        mGameButtons[4] = (Button) findViewById(R.id.btn_5);
        mGameButtons[5] = (Button) findViewById(R.id.btn_6);
        mGameButtons[6] = (Button) findViewById(R.id.btn_7);
        mGameButtons[7] = (Button) findViewById(R.id.btn_8);
        mGameButtons[8] = (Button) findViewById(R.id.btn_9);
        btnNewGame = findViewById(R.id.btn_new_game);
        status = findViewById(R.id.status);

        setOnClick();

        newGame();
    }

    private void newGame(){
        mGameStatus = true;
        compWin = false;
        userWin = false;
        tie = false;
        mBoard = new char[9];
        status.setText("Game in Progress");
        for(int i = 0; i < 9; i++) {
            mGameButtons[i].setText("");
        }
    }

    private void setPlayerMove(int pos){
        mGameButtons[pos].setText("X");
        mBoard[pos] = 'X';
        mGameButtons[pos].setTextColor(getResources().getColor(R.color.crimson));
    }

    private void getComputerMove(){
        Random random = new Random();
        int rand;
        while(true){
            rand = random.nextInt(9);
            if(mGameButtons[rand].getText() == ""){
                mGameButtons[rand].setText("O");
                mBoard[rand] = 'O';
                mGameButtons[rand].setTextColor(getResources().getColor(R.color.dodger_blue));
                break;
            }
        }
    }

    private int checkForWinner() {
        boolean full = true;

        for (int i = 0; i < 9; i++)
            if (mGameButtons[i].getText() == "")
                full = false;

        if ((mBoard[0] == mBoard[1] && mBoard[0] == mBoard[2] && mGameButtons[0].getText() != "")
                || (mBoard[3] == mBoard[4] && mBoard[3] == mBoard[5] && mGameButtons[3].getText() != "")
                || (mBoard[6] == mBoard[7] && mBoard[6] == mBoard[8] && mGameButtons[6].getText() != "")
                || (mBoard[0] == mBoard[3] && mBoard[0] == mBoard[6] && mGameButtons[0].getText() != "")
                || (mBoard[1] == mBoard[4] && mBoard[1] == mBoard[7] && mGameButtons[1].getText() != "")
                || (mBoard[2] == mBoard[5] && mBoard[2] == mBoard[8] && mGameButtons[2].getText() != "")
                || (mBoard[0] == mBoard[4] && mBoard[0] == mBoard[8] && mGameButtons[0].getText() != "")
                || (mBoard[2] == mBoard[4] && mBoard[2] == mBoard[6] && mGameButtons[2].getText() != ""))
            mGameStatus = false;

        if (!mGameStatus){
            return 1; //winner
        }else if(full){
            mGameStatus = false;
            return 0; //tie
        }else{
            return 2; //continue
        }
    }

    private void onPlayButtonClick(int pos){
        setPlayerMove(pos);
        int check = checkForWinner();
        if(check == 2){
            getComputerMove();
            check = checkForWinner();
            if(check == 1){
                compWin = true;
            }else if(check == 0){
                tie = true;
            }else if(check == 2){
                //continue
            }else{
                //error state
            }
        }else if(check == 1){
            userWin = true;
        }else if(check == 0){
            tie = true;
        }else{
            //error state
        }

        if(tie){
            status.setText("Tie");
        }else if(userWin){
            status.setText("Player Won");
        }else if(compWin){
            status.setText("Computer Won");
        }else{
            //error
        }
    }

    private boolean isGameOver(){
        if(mGameStatus)
            return false;
        else
            return true;
    }

    private void onNewGameClick(){
        newGame();
    }

    private void setOnClick(){
        mGameButtons[0].setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(mGameButtons[0].getText() == "" && !isGameOver()){
                    onPlayButtonClick(0);
                }
            }
        });

        mGameButtons[1].setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(mGameButtons[1].getText() == "" && !isGameOver()){
                    onPlayButtonClick(1);
                }
            }
        });

        mGameButtons[2].setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(mGameButtons[2].getText() == "" && !isGameOver()){
                    onPlayButtonClick(2);
                }
            }
        });

        mGameButtons[3].setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(mGameButtons[3].getText() == "" && !isGameOver()){
                    onPlayButtonClick(3);
                }
            }
        });

        mGameButtons[4].setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(mGameButtons[4].getText() == "" && !isGameOver()){
                    onPlayButtonClick(4);
                }
            }
        });

        mGameButtons[5].setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(mGameButtons[5].getText() == "" && !isGameOver()){
                    onPlayButtonClick(5);
                }
            }
        });

        mGameButtons[6].setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(mGameButtons[6].getText() == "" && !isGameOver()){
                    onPlayButtonClick(6);
                }
            }
        });

        mGameButtons[7].setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(mGameButtons[7].getText() == "" && !isGameOver()){
                    onPlayButtonClick(7);
                }
            }
        });

        mGameButtons[8].setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(mGameButtons[8].getText() == "" && !isGameOver()){
                    onPlayButtonClick(8);
                }
            }
        });

        btnNewGame.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                onNewGameClick();
            }
        });
    }
}
