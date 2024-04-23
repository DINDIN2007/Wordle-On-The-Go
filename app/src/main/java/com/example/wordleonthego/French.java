package com.example.wordleonthego;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Vector;

public class French extends AppCompatActivity {
    /*╗       ██╗ █████╗ ██████╗ ██████╗   ██╗     ██╗ ██████╗████████╗
    ██║  ██╗  ██║██╔══██╗██╔══██╗██╔══██╗  ██║     ██║██╔════╝╚══██╔══╝
    ╚██╗████╗██╔╝██║  ██║██████╔╝██║  ██║  ██║     ██║╚█████╗    ██║
     ████╔═████║ ██║  ██║██╔══██╗██║  ██║  ██║     ██║ ╚═══██╗   ██║
     ╚██╔╝ ╚██╔╝ ╚█████╔╝██║  ██║██████╔╝  ███████╗██║██████╔╝   ██║
      ╚═╝   ╚═╝   ╚════╝ ╚═╝  ╚═╝╚═════╝   ╚══════╝╚═╝╚═════╝    ╚*/

    public static String[] triedWords = {"", "", "", "", "", "", ""};
    public String chosenWord;

    /*█████╗ ██████╗ ██╗██████╗   ██╗   ██╗ █████╗ ██████╗ ██╗ █████╗ ██████╗ ██╗     ███████╗ ██████╗
    ██╔════╝ ██╔══██╗██║██╔══██╗  ██║   ██║██╔══██╗██╔══██╗██║██╔══██╗██╔══██╗██║     ██╔════╝██╔════╝
    ██║  ██╗ ██████╔╝██║██║  ██║  ╚██╗ ██╔╝███████║██████╔╝██║███████║██████╦╝██║     █████╗  ╚█████╗
    ██║  ╚██╗██╔══██╗██║██║  ██║   ╚████╔╝ ██╔══██║██╔══██╗██║██╔══██║██╔══██╗██║     ██╔══╝   ╚═══██╗
    ╚██████╔╝██║  ██║██║██████╔╝    ╚██╔╝  ██║  ██║██║  ██║██║██║  ██║██████╦╝███████╗███████╗██████╔╝
     ╚═════╝ ╚═╝  ╚═╝╚═╝╚═════╝      ╚═╝   ╚═╝  ╚═╝╚═╝  ╚═╝╚═╝╚═╝  ╚═╝╚═════╝ ╚══════╝╚══════╝╚════*/

    public static int current_row = 0, current_columns = 0;
    final public static int[][] grid_id = {
            {R.id.E11, R.id.E12, R.id.E13, R.id.E14, R.id.E15},
            {R.id.E21, R.id.E22, R.id.E23, R.id.E24, R.id.E25},
            {R.id.E31, R.id.E32, R.id.E33, R.id.E34, R.id.E35},
            {R.id.E41, R.id.E42, R.id.E43, R.id.E44, R.id.E45},
            {R.id.E51, R.id.E52, R.id.E53, R.id.E54, R.id.E55},
            {R.id.E61, R.id.E62, R.id.E63, R.id.E64, R.id.E65},
    };

    public void createGrid() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 5; j++) {
                TextView grid_tile = findViewById(grid_id[i][j]);
                grid_tile.setText("");
                grid_tile.setBackgroundResource(R.drawable.border);
            }}
    }

    /*╗  ██╗███████╗██╗   ██╗██████╗  █████╗  █████╗ ██████╗ ██████╗
    ██║ ██╔╝██╔════╝╚██╗ ██╔╝██╔══██╗██╔══██╗██╔══██╗██╔══██╗██╔══██╗
    █████═╝ █████╗   ╚████╔╝ ██████╦╝██║  ██║███████║██████╔╝██║  ██║
    ██╔═██╗ ██╔══╝    ╚██╔╝  ██╔══██╗██║  ██║██╔══██║██╔══██╗██║  ██║
    ██║ ╚██╗███████╗   ██║   ██████╦╝╚█████╔╝██║  ██║██║  ██║██████╔╝
    ╚═╝  ╚═╝╚══════╝   ╚═╝   ╚═════╝  ╚════╝ ╚═╝  ╚═╝╚═╝  ╚═╝╚════*/

    final public static int[][] keyboard_id = {
            {R.id.Q, R.id.W, R.id.E, R.id.R, R.id.T, R.id.Y, R.id.U},
            {R.id.I, R.id.O, R.id.P, R.id.A, R.id.S, R.id.D, R.id.F},
            {R.id.G, R.id.H, R.id.J, R.id.K, R.id.L, R.id.Z, R.id.X},
            {R.id.Enter, R.id.C, R.id.V, R.id.B, R.id.N, R.id.M, R.id.eAccentAigu, R.id.accentCirconflexe, R.id.accentGrave, R.id.Delete},
    };

    final public static int[][] keyboard_color = new int[4][10];

    final public static String keyboard_position = "QWERTYUIOPASDFGHJKLZX1CVBNMÑ2";

    public void createKeyboard() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < keyboard_id[i].length; j++) {
                TextView key = findViewById(keyboard_id[i][j]);
                key.setBackgroundResource(R.drawable.not_selected);
                key.setOnClickListener(v -> {
                    int key_id = v.getId();
                    String key1 = (getResources().getResourceEntryName(key_id));
                    TextView tile = findViewById(grid_id[current_row][Math.max(0, current_columns - 1)]);
                    switch (key1) {
                        case "Enter":
                            enterPressed();
                            break;
                        case "Delete":
                            deletePressed();
                            break;
                        case "eAccentAigu":
                            keyPressed("É");
                            break;
                        case "accentCirconflexe":
                            tile.setText(addAccent(tile.getText().charAt(0), '^'));
                            break;
                        case "accentGrave":
                            tile.setText(addAccent(tile.getText().charAt(0), '`'));
                            break;
                        default:
                            keyPressed(key1);
                    }
                });
                // Change key-color
                keyboard_color[i][j] = 0; // 0 = Not Selected, 1 = Not there, 2 = Yellow Tile, 3 = Green Tile
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP && !((i == 3 && j == 0) || (i == 3 && j >= 6))) {
                    key.setBackgroundTintList(ColorStateList.valueOf(Color.rgb(174,174,174)));
                }
            }}
    }

    /*╗  ██╗███████╗██╗   ██╗     █████╗  █████╗ ███╗  ██╗████████╗██████╗  █████╗ ██╗      ██████╗
    ██║ ██╔╝██╔════╝╚██╗ ██╔╝    ██╔══██╗██╔══██╗████╗ ██║╚══██╔══╝██╔══██╗██╔══██╗██║     ██╔════╝
    █████═╝ █████╗   ╚████╔╝     ██║  ╚═╝██║  ██║██╔██╗██║   ██║   ██████╔╝██║  ██║██║     ╚█████╗
    ██╔═██╗ ██╔══╝    ╚██╔╝      ██║  ██╗██║  ██║██║╚████║   ██║   ██╔══██╗██║  ██║██║      ╚═══██╗
    ██║ ╚██╗███████╗   ██║       ╚█████╔╝╚█████╔╝██║ ╚███║   ██║   ██║  ██║╚█████╔╝███████╗██████╔╝
    ╚═╝  ╚═╝╚══════╝   ╚═╝        ╚════╝  ╚════╝ ╚═╝  ╚══╝   ╚═╝   ╚═╝  ╚═╝ ╚════╝ ╚══════╝╚════*/

    public void keyPressed(String key) {
        if (current_columns == 5) return;
        TextView tile = findViewById(grid_id[current_row][current_columns]);
        tile.setText(key);
        current_columns++;
    }

    private static String addAccent(char letter, char accent) {
        if (accent == '`') {
            switch(letter) {
                case 'A': return "À";
                case 'E': return "È";
                case 'U': return "Ù";
            }
        }
        else if (accent == '^') {
            switch(letter) {
                case 'A': return "Â";
                case 'E': return "Ê";
                case 'I': return "Î";
                case 'O': return "Ô";
                case 'U': return "Û";
            }
        }
        else {
            switch(letter) {
                case 'Â': case 'À': return "A";
                case 'Ê': case 'È': return "E";
                case 'Î': return "I";
                case 'Ô': return "O";
                case 'Û': case 'Ù': return "U";
            }
        }


        return String.valueOf(letter);
    }

    public static boolean gameOver = false;

    public void enterPressed() {
        // Don't run if game is over
        if (gameOver) {newGame(); return;}

        // Check if there are enough letters
        if (current_columns < 5) {
            showDialog("There are not enough letters. Please enter a 5 letter word.");
            return;
        }

        String input_word = constructWord().toUpperCase();

        // Check if current word is valid
        if (!wordList.contains(input_word.toLowerCase())) {
            showDialog("The dictionary does not contain this word. Please try again.");
            return;
        }
        if (wordHasBeenTried(input_word)) {
            showDialog("The word has already been tried above ! Try something else...");
            return;
        }

        Log.d("CHEATER", "TRY : " + input_word);

        // Check Green Tiles
        String letters_remaining = checkGreenTiles(input_word);

        // Check Yellow Tiles
        checkYellowTiles(letters_remaining, input_word);

        // No more tries left for player
        if (current_row == 5 && !gameOver) {
            // Execute Ending Code
            gameOver = true;
            showDialog("GAME OVER, THE WORD WAS " + chosenWord);
        }
        // Proceed to next row
        else {
            triedWords[current_row] = input_word;
            current_row++;
            current_columns = 0;
        }
    }

    public void deletePressed() {
        current_columns = Math.max(0, current_columns - 1);
        TextView tile = findViewById(grid_id[current_row][current_columns]);
        tile.setText("");
    }

    /*╗███╗  ██╗██╗   ██╗ █████╗ ██╗     ██╗██████╗     ██╗   ██╗ █████╗ ██╗     ██╗   ██╗███████╗ ██████╗
    ██║████╗ ██║██║   ██║██╔══██╗██║     ██║██╔══██╗    ██║   ██║██╔══██╗██║     ██║   ██║██╔════╝██╔════╝
    ██║██╔██╗██║╚██╗ ██╔╝███████║██║     ██║██║  ██║    ╚██╗ ██╔╝███████║██║     ██║   ██║█████╗  ╚█████╗
    ██║██║╚████║ ╚████╔╝ ██╔══██║██║     ██║██║  ██║     ╚████╔╝ ██╔══██║██║     ██║   ██║██╔══╝   ╚═══██╗
    ██║██║ ╚███║  ╚██╔╝  ██║  ██║███████╗██║██████╔╝      ╚██╔╝  ██║  ██║███████╗╚██████╔╝███████╗██████╔╝
    ╚═╝╚═╝  ╚══╝   ╚═╝   ╚═╝  ╚═╝╚══════╝╚═╝╚═════╝        ╚═╝   ╚═╝  ╚═╝╚══════╝ ╚═════╝ ╚══════╝╚════*/

    public void showDialog(String error) {
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.not_enough_letters);

        TextView message = (dialog.findViewById(R.id.alert));
        message.setText(error);

        Button newGameButton = dialog.findViewById(R.id.newGame);
        if (gameOver) {
            newGameButton.setVisibility(View.VISIBLE);
            newGameButton.setOnClickListener(v -> newGame());
        }
        else newGameButton.setVisibility(View.GONE);

        dialog.show();
    }

    /*████╗  █████╗  ██╗       ██╗   █████╗ ██╗  ██╗███████╗ █████╗ ██╗  ██╗
    ██╔══██╗██╔══██╗ ██║  ██╗  ██║  ██╔══██╗██║  ██║██╔════╝██╔══██╗██║ ██╔╝
    ██████╔╝██║  ██║ ╚██╗████╗██╔╝  ██║  ╚═╝███████║█████╗  ██║  ╚═╝█████═╝
    ██╔══██╗██║  ██║  ████╔═████║   ██║  ██╗██╔══██║██╔══╝  ██║  ██╗██╔═██╗
    ██║  ██║╚█████╔╝  ╚██╔╝ ╚██╔╝   ╚█████╔╝██║  ██║███████╗╚█████╔╝██║ ╚██╗
    ╚═╝  ╚═╝ ╚════╝    ╚═╝   ╚═╝     ╚════╝ ╚═╝  ╚═╝╚══════╝ ╚════╝ ╚═╝  ╚*/

    public String constructWord() {
        StringBuilder input_word_finder = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            TextView tile = findViewById(grid_id[current_row][i]);
            char letter = tile.getText().charAt(0);
            input_word_finder.append(letter);
        }
        return input_word_finder.toString().toLowerCase();
    }

    public boolean wordHasBeenTried(String word) {
        for (String s : triedWords) {
            if (s.equals(word)) return true;
        }
        return false;
    }

    public String checkGreenTiles(String input) {
        StringBuilder remaining_letters = new StringBuilder();
        int correctCounter = 0;
        for (int i = 0; i < input.length(); i++) {
            // Search for correct letters at correct position
            if (input.charAt(i) == chosenWord.charAt(i)) {
                // Change tile into green tile
                TextView tile = findViewById(grid_id[current_row][i]);
                tile.setBackgroundResource(R.drawable.green_tile);
                tile.setTextColor(Color.WHITE);
                // Add placeholder in char array
                remaining_letters.append("*");
                // Add 1 to correctCounter
                correctCounter++;
                // Change matching key to green color
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    int keyPosition = keyboard_position.indexOf(input.charAt(i));
                    if (keyPosition == -1) keyPosition = keyboard_position.indexOf(addAccent(input.charAt(i), 'a'));
                    findViewById(keyboard_id[keyPosition / 7][keyPosition % 7]).setBackgroundTintList(ColorStateList.valueOf(Color.rgb(76, 175, 80)));
                    keyboard_color[keyPosition / 7][keyPosition % 7] = 3;
                }
            }
            // Add remaining letters to check for yellow/gray tiles
            else remaining_letters.append(chosenWord.charAt(i));
        }
        if (correctCounter == chosenWord.length()) {
            showDialog("\uD83C\uDF89 Congratulation \uD83C\uDF89\n You found the word");
            gameOver = true;
        }
        return remaining_letters.toString();
    }

    public void checkYellowTiles(String lettersToCheck, String input) {
        String remainder = lettersToCheck;
        for (int i = 0; i < remainder.length(); i++) {
            // Find the current tile to change color
            TextView tile = findViewById(grid_id[current_row][i]);

            if (remainder.charAt(i) == '*') continue;

            // Detects a correct letter at the wrong spot
            if (remainder.contains(String.valueOf(input.charAt(i)))) {
                // Change tile to yellow tile
                tile.setBackgroundResource(R.drawable.yellow_tile);

                StringBuilder newString = new StringBuilder();
                // String.replaceFirst() is weird in Android Studio
                for (int j = 0; j < remainder.length(); j++) {
                    if (remainder.charAt(j) == input.charAt(i)) {
                        newString.append("-"); continue;
                    }
                    newString.append(remainder.charAt(j));
                }
                remainder = newString.toString();

                // Change corresponding key with yellow tint
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    int keyPosition = keyboard_position.indexOf(input.charAt(i));
                    if (keyPosition == -1) keyPosition = keyboard_position.indexOf(addAccent(input.charAt(i), 'a'));
                    if (keyboard_color[keyPosition / 7][keyPosition % 7] != 3) {
                        findViewById(keyboard_id[keyPosition / 7][keyPosition % 7]).setBackgroundTintList(ColorStateList.valueOf(Color.rgb(255, 193, 7)));
                        keyboard_color[keyPosition / 7][keyPosition % 7] = 2;
                    }
                }
            }
            // Detects a letter that is not present in the word
            else {
                // Change tile to gray tile
                tile.setBackgroundResource(R.drawable.grey_tile);

                // Change corresponding key with gray tint
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    int keyPosition = keyboard_position.indexOf(input.charAt(i));
                    if (keyPosition == -1) keyPosition = keyboard_position.indexOf(addAccent(input.charAt(i), 'a'));
                    if (keyboard_color[keyPosition / 7][keyPosition % 7] <= 1) {
                        findViewById(keyboard_id[keyPosition / 7][keyPosition % 7]).setBackgroundTintList(ColorStateList.valueOf(Color.rgb(43, 40, 40)));
                        keyboard_color[keyPosition / 7][keyPosition % 7] = 2;
                    }
                }
            }
            tile.setTextColor(Color.WHITE);
        }
    }

    /*████╗ ██████╗ ██╗██╗   ██╗███████╗██████╗    █████╗  █████╗ ██████╗ ███████╗
    ██╔══██╗██╔══██╗██║██║   ██║██╔════╝██╔══██╗  ██╔══██╗██╔══██╗██╔══██╗██╔════╝
    ██║  ██║██████╔╝██║╚██╗ ██╔╝█████╗  ██████╔╝  ██║  ╚═╝██║  ██║██║  ██║█████╗
    ██║  ██║██╔══██╗██║ ╚████╔╝ ██╔══╝  ██╔══██╗  ██║  ██╗██║  ██║██║  ██║██╔══╝
    ██████╔╝██║  ██║██║  ╚██╔╝  ███████╗██║  ██║  ╚█████╔╝╚█████╔╝██████╔╝███████╗
    ╚═════╝ ╚═╝  ╚═╝╚═╝   ╚═╝   ╚══════╝╚═╝  ╚═╝   ╚════╝  ╚════╝ ╚═════╝ ╚═════*/

    public void newGame() {
        // Resets tried words
        for (String word : triedWords) word = "";

        // Create keyboard again
        createKeyboard();

        // Create grid again
        current_columns = 0; current_row = 0;
        createGrid();

        // Chose new word
        chosenWord = wordList.get((int)(Math.random() * wordList.size())).toUpperCase();

        // Resets gameOver boolean
        gameOver = false;
    }

    public static Intent makeIntent(Context context) {
        return new Intent(context, French.class);
    }

    private void setupEndActivityButton() {
        Button btn = findViewById(R.id.french_back_button);
        btn.setOnClickListener(v -> {
            newGame(); finish();
        });
    }

    // When page is initially created

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_french);

        // Create option to go back to menu
        setupEndActivityButton();

        // Load the words
        loadFiles();

        // Create new game
        newGame();
    }

    private static Vector<String> wordList = new Vector<>();

    private static String addFrenchAccents(String fromTxtFile) {
        char[] letters = {'ë', 'é', 'à', 'è', 'ù', 'â', 'ê', 'î', 'ô', 'û'};
        for (int i = 0; i < 10; i++) {
            fromTxtFile = fromTxtFile.replace((char)('0' + i), letters[i]);
        }
        return fromTxtFile;
    }

    private void loadFiles() {
        String line;
        try {
            InputStream inputStream = getResources().openRawResource(R.raw.french_words);

            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            while ((line = reader.readLine()) != null) {
                wordList.add(addFrenchAccents(line));
            }
            inputStream.close();
        }
        catch (IOException e) {
            Log.d("CHEATER", "ERROR : " + e);
        }
    }
}