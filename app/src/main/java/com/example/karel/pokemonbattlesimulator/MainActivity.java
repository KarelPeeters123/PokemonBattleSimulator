package com.example.karel.pokemonbattlesimulator;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.ProgressBar;
import android.content.res.Resources;

import java.util.Iterator;
import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {

    String[] pokemonNames = new String[151];
    Pokemon[] pokemons = new Pokemon[151];

    Button startButton;

    TextView versus;

    Spinner spinner1;
    Spinner spinner2;

    public ArrayAdapter<String> adapter1;
    public ArrayAdapter<String> adapter2;

    ImageView yourSprite;
    ImageView enemySprite;

    Button button1;
    Button button2;
    Button button3;
    Button button4;

    TextView pokemonName1;
    TextView pokemonName2;
    TextView dialogue;

    ProgressBar hp1;
    ProgressBar hp2;

    Pokemon possiblePokemon1;
    Pokemon possiblePokemon2;

    Pokemon pokemon1;
    Pokemon pokemon2;

    Battle myBattle;

    LinkedList<Move> intendedMoves = new LinkedList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_menu);

        //create a standard moveset
        Move move1 = new Move("Tackle", false, 40, 1, new Type("normal"), "atk", 0);
        Move move2 = new Move("Sand Attack", false, 0, 1, new Type("ground"), "acc", 0);
        Move move3 = new Move("Gust", true, 40, 1, new Type("flying"), "atk", 0);
        Move move4 = new Move("Quick Attack", false, 40, 100, new Type("normal"), "atk", 0);
        Move[] myMoves = new Move[] {move1, move2, move3, move4};

        //creates stats
        Stats myStats1 = new Stats(13, 33, 16, 15, 14, 14, 19);
        Stats myStats2 = new Stats(13, 33, 16, 15, 14, 14, 21);

        //create sprites
        Resources res = getResources();
        Drawable pidgey_front = res.getDrawable(R.drawable.pidgey_front);
        Drawable pidgey_back = res.getDrawable(R.drawable.pidgey_back);
        Drawable pidgeotto_front= res.getDrawable(R.drawable.pidgeotto_front);
        Drawable pidgeotto_back = res.getDrawable(R.drawable.pidgeotto_back);

        //create 2 pokemon to add to the "database"
        possiblePokemon1 = new Pokemon("Pidgey", 1.8, new Type("normal"), new Type("flying"), myMoves, myStats1, pidgey_front, pidgey_back);
        possiblePokemon2 = new Pokemon("Pidgeotto", 1.8, new Type("normal"), new Type("flying"), myMoves, myStats2, pidgeotto_front, pidgeotto_back);

        //assign sprites to imageviews
        yourSprite = (ImageView) findViewById(R.id.yourPokemon);
        enemySprite = (ImageView) findViewById(R.id.enemyPokemon);

        // fill array with pidgeys to avoid nullpointer.
        for (int l = 0; l < 151; l++){
            pokemons[l] = new Pokemon("Pidgey", 1.8, new Type("normal"), new Type("flying"), myMoves, myStats1, pidgey_front, pidgey_back);
            pokemonNames[l] = possiblePokemon1.name;
        }

        //add the 2 pokemon to the "database"
        pokemons[0] = possiblePokemon1;
        pokemons[1] = possiblePokemon2;

        //create a 2nd array which contains the names of the pokemon
        for (int j = 0; j < 151; j++) {
            pokemonNames[j] = pokemons[j].name;
        }

        //assign button to button
        startButton = (Button) findViewById(R.id.button);

        //assign textview to textview
        versus = (TextView) findViewById(R.id.textView);

        //link up adapters and spinners
        spinner1 = (Spinner) findViewById(R.id.spinner);
        spinner2 = (Spinner) findViewById(R.id.spinner2);
        adapter1 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, pokemonNames);
        adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, pokemonNames);
        spinner1.setAdapter(adapter1);
        spinner2.setAdapter(adapter2);

        //instructions of spinner1
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                for (int i = 0; i < 151; i++){
                    if (parent.getItemAtPosition(position) == pokemons[i].name){
                        pokemon1 = pokemons[i];
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //instructions of spinner2
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                for (int k = 0; k < 151; k++){
                    if (parent.getItemAtPosition(position) == pokemons[k].name){
                        pokemon2 = pokemons[k];
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //instructions of startbutton
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.battle_layout);
                Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
                setSupportActionBar(toolbar);
                myBattle = new Battle(pokemon1, pokemon2, "no weather");

                pokemonName1 = (TextView) findViewById(R.id.pokemon1);
                pokemonName2 = (TextView) findViewById(R.id.pokemon2);

                yourSprite = (ImageView) findViewById(R.id.yourPokemon);
                enemySprite = (ImageView) findViewById(R.id.enemyPokemon);



                dialogue = (TextView) findViewById(R.id.textView);

                button1 = (Button) findViewById(R.id.button1);
                button2 = (Button) findViewById(R.id.button2);
                button3 = (Button) findViewById(R.id.button3);
                button4 = (Button) findViewById(R.id.button4);

                hp1 = (ProgressBar) findViewById(R.id.progressBar);
                hp2 = (ProgressBar) findViewById(R.id.progressBar2);

                //color the health bar
                Resources res = getResources();
                hp1.setProgressDrawable(res.getDrawable(R.drawable.my_progress_green));
                hp2.setProgressDrawable(res.getDrawable(R.drawable.my_progress_green));

                swapPosition();



                //assign functions to the buttons
                button1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //carry out move and adjust health bar. swap the position of the pokemon
                        intendedMoves.add(myBattle.pokemon1.moves[0]);
                        hp2.setProgress(pokemon2.myStats.hp);
                        myBattle = new Battle(myBattle.pokemon2, myBattle.pokemon1, myBattle.weather);
                        swapPosition();
                        if (intendedMoves.size() == 2){
                            Turn myTurn = new Turn(myBattle, intendedMoves.get(0), intendedMoves.get(1));
                            intendedMoves.clear();
                        }
                        if (pokemon1.myStats.hp == 0){
                            pokemon1.faint();
                        }
                        if (pokemon2.hp == 0){
                            pokemon2.faint();
                        }
                        swapPosition();

                    }
                });

                button2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        myBattle.attack(myBattle.pokemon1, myBattle.pokemon2, myBattle.pokemon1.moves[1]);
                        hp2.setProgress(pokemon2.myStats.hp);
                        dialogue.setText(myBattle.pokemon1.name + " used " + myBattle.pokemon1.moves[1].moveName  + ".");
                        myBattle = new Battle(myBattle.pokemon2, myBattle.pokemon1, myBattle.weather);
                        swapPosition();
                        if (pokemon1.myStats.hp == 0){
                            pokemon1.faint();
                        }
                        if (pokemon2.myStats.hp == 0){
                            pokemon2.faint();
                        }
                    }
                });

                button3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        myBattle.attack(myBattle.pokemon1, myBattle.pokemon2, myBattle.pokemon1.moves[2]);
                        hp2.setProgress(pokemon2.myStats.hp);
                        dialogue.setText(myBattle.pokemon1.name + " used " + myBattle.pokemon1.moves[2].moveName  + ".");
                        myBattle = new Battle(myBattle.pokemon2, myBattle.pokemon1, myBattle.weather);
                        swapPosition();
                        if (pokemon1.myStats.hp == 0){
                            pokemon1.faint();
                        }
                        if (pokemon2.myStats.hp == 0){
                            pokemon2.faint();
                        }
                    }
                });

                button4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        myBattle.attack(myBattle.pokemon1, myBattle.pokemon2, myBattle.pokemon1.moves[3]);
                        hp2.setProgress(pokemon2.myStats.hp);
                        dialogue.setText(myBattle.pokemon1.name + " used " + myBattle.pokemon1.moves[3].moveName  + ".");
                        myBattle = new Battle(myBattle.pokemon2, myBattle.pokemon1, myBattle.weather);
                        swapPosition();
                        if (pokemon1.myStats.hp == 0){
                            pokemon1.faint();
                        }
                        if (pokemon2.myStats.hp == 0){
                            pokemon2.faint();
                        }
                    }
                });
            }
        });

    }
    public void swapPosition(){
        button1.setText(myBattle.pokemon1.moves[0].moveName);
        button2.setText(myBattle.pokemon1.moves[1].moveName);
        button3.setText(myBattle.pokemon1.moves[2].moveName);
        button4.setText(myBattle.pokemon1.moves[3].moveName);

        hp1.setMax((int) myBattle.pokemon1.myStats.maxHp);
        hp1.setProgress(myBattle.pokemon1.myStats.hp);

        Resources res = getResources();
        double hpPercent1 = (double)myBattle.pokemon1.myStats.hp/(double)myBattle.pokemon1.myStats.maxHp;
        if (hpPercent1 <= 0.5) {
            hp1.setProgressDrawable(res.getDrawable(R.drawable.my_progress_yellow));
        }
        if (hpPercent1 <= 0.2) {
            hp1.setProgressDrawable(res.getDrawable(R.drawable.my_progress_red));
        }

        hp2.setMax((int) myBattle.pokemon2.myStats.maxHp);
        hp2.setProgress(myBattle.pokemon2.myStats.hp);

        double hpPercent2 = (double)myBattle.pokemon2.myStats.hp/(double)myBattle.pokemon2.myStats.maxHp;
        if (hpPercent2 <= 0.5) {
            hp2.setProgressDrawable(res.getDrawable(R.drawable.my_progress_yellow));
        }
        if (hpPercent2 <= 0.2) {
            hp2.setProgressDrawable(res.getDrawable(R.drawable.my_progress_red));
        }

        pokemonName1.setText(myBattle.pokemon1.name);
        pokemonName2.setText(myBattle.pokemon2.name);

        assignSprite();
    }

    public void assignSprite(){
        yourSprite.setImageDrawable(myBattle.pokemon1.backSprite);
        enemySprite.setImageDrawable(myBattle.pokemon2.frontSprite);
    }
}