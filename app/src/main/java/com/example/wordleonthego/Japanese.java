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
import java.util.HashMap;
import java.util.Vector;

public class Japanese extends AppCompatActivity {
    // EXPLANATION OF THE JAPANESE ALPHABET
    // Japanese is a language that has three official alphabets.
    // The first is Hiragana, which consists of 46 different syllables (its usually used as connecting particles)
    // The second is Katakana, also consisting of 46 syllables but is used for words taken from other languages
    // The third (Kanji) consists of over 4000 characters from China (nouns, pronouns, adjectives and verbs)
    // Since there are too many characters to fit in a keyboard, this app will use romanji
    // Romanji is simply English characters that form those japanese syllables (さ --> sa)
    // The app will require the user to type in Romanji and will convert those into Hiragana
    // Once the word is found or the game is over, the user will receive both the kanji version and its definition
    // Since the most common length of words in Japanese are 3 syllables, we will set this game to three boxes

    /*╗  ██╗ █████╗ ███╗  ██╗ █████╗      ██╗       ██╗██████╗ ██╗████████╗██╗███╗  ██╗ ██████╗ 
    ██║ ██╔╝██╔══██╗████╗ ██║██╔══██╗     ██║  ██╗  ██║██╔══██╗██║╚══██╔══╝██║████╗ ██║██╔════╝ 
    █████═╝ ███████║██╔██╗██║███████║     ╚██╗████╗██╔╝██████╔╝██║   ██║   ██║██╔██╗██║██║  ██╗ 
    ██╔═██╗ ██╔══██║██║╚████║██╔══██║      ████╔═████║ ██╔══██╗██║   ██║   ██║██║╚████║██║  ╚██╗
    ██║ ╚██╗██║  ██║██║ ╚███║██║  ██║      ╚██╔╝ ╚██╔╝ ██║  ██║██║   ██║   ██║██║ ╚███║╚██████╔╝
    ╚═╝  ╚═╝╚═╝  ╚═╝╚═╝  ╚══╝╚═╝  ╚═╝       ╚═╝   ╚═╝  ╚═╝  ╚═╝╚═╝   ╚═╝   ╚═╝╚═╝  ╚══╝ ╚═════╝ 

     ██████╗██╗   ██╗ ██████╗████████╗███████╗███╗   ███╗
    ██╔════╝╚██╗ ██╔╝██╔════╝╚══██╔══╝██╔════╝████╗ ████║
    ╚█████╗  ╚████╔╝ ╚█████╗    ██║   █████╗  ██╔████╔██║
     ╚═══██╗  ╚██╔╝   ╚═══██╗   ██║   ██╔══╝  ██║╚██╔╝██║
    ██████╔╝   ██║   ██████╔╝   ██║   ███████╗██║ ╚═╝ ██║
    ╚═════╝    ╚═╝   ╚═════╝    ╚═╝   ╚══════╝╚═╝     ╚*/
    private static final HashMap<String, String> hiraganaChart = new HashMap<String, String>() {{
        put("あ", "a"); put("a", "あ"); put("い", "i"); put("i", "い"); put("う", "u"); put("u", "う"); put("え", "e"); put("e", "え"); put("お", "o"); put("o", "お");
        put("か", "ka"); put("ka", "か"); put("き", "ki"); put("ki", "き"); put("く", "ku"); put("ku", "く"); put("け", "ke"); put("ke", "け"); put("こ", "ko"); put("ko", "こ");
        put("さ", "sa"); put("sa", "さ"); put("し", "shi"); put("shi", "し"); put("す", "su"); put("su", "す"); put("せ", "se"); put("se", "せ"); put("そ", "so"); put("so", "そ");
        put("た", "ta"); put("ta", "た"); put("ち", "chi"); put("chi", "ち"); put("つ", "tsu"); put("tsu", "つ"); put("て", "te"); put("te", "て"); put("と", "to"); put("to", "と");
        put("な", "na"); put("na", "な"); put("に", "ni"); put("ni", "に"); put("ぬ", "nu"); put("nu", "ぬ"); put("ね", "ne"); put("ne", "ね"); put("の", "no"); put("no", "の");
        put("は", "ha"); put("ha", "は"); put("ひ", "hi"); put("hi", "ひ"); put("ふ", "hu"); put("hu", "ふ"); put("へ", "he"); put("he", "へ"); put("ほ", "ho"); put("ho", "ほ");
        put("ま", "ma"); put("ma", "ま"); put("み", "mi"); put("mi", "み"); put("む", "mu"); put("mu", "む"); put("め", "me"); put("me", "め"); put("も", "mo"); put("mo", "も");
        put("や", "ya"); put("ya", "や"); put("ゆ", "yu"); put("yu", "ゆ"); put("よ", "yo"); put("yo", "よ");
        put("ら", "ra"); put("ra", "ら"); put("り", "ri"); put("ri", "り"); put("る", "ru"); put("ru", "る"); put("れ", "re"); put("re", "れ"); put("ろ", "ro"); put("ro", "ろ");
        put("わ", "wa"); put("wa", "わ"); put("を", "wo"); put("wo", "を"); put("ん", "n"); put("n", "ん");

        put("が", "ga"); put("ga", "が"); put("ぎ", "gi"); put("gi", "ぎ"); put("ぐ", "gu"); put("gu", "ぐ"); put("げ", "ge"); put("ge", "げ"); put("ご", "go"); put("go", "ご");
        put("ざ", "za"); put("za", "ざ"); put("じ", "zi"); put("zi", "じ"); put("ず", "zu"); put("zu", "ず"); put("ぜ", "ze"); put("ze", "ぜ"); put("ぞ", "zo"); put("zo", "ぞ");
        put("だ", "da"); put("da", "だ"); put("ぢ", "di"); put("di", "ぢ"); put("づ", "du"); put("du", "づ"); put("で", "de"); put("de", "づ"); put("ど", "do"); put("do", "ど");
        put("ば", "ba"); put("ba", "ば"); put("び", "bi"); put("bi", "び"); put("ぶ", "bu"); put("bu", "ぶ"); put("べ", "be"); put("be", "べ"); put("ぼ", "bo"); put("bo", "ぼ");
        put("ぱ", "pa"); put("pa", "ぱ"); put("ぴ", "pi"); put("pi", "ぴ"); put("ぷ", "pu"); put("pu", "ぷ"); put("ぺ", "pe"); put("pe", "ぺ"); put("ぽ", "po"); put("po", "ぽ");

        put("きゃ", "kya"); put("kya", "きゃ"); put("しゃ", "sha"); put("sha", "しゃ"); put("ちゃ", "cha"); put("cha", "ちゃ"); put("にゃ", "nya"); put("nya", "にゃ"); put("ひゃ", "hya"); put("hya", "ひゃ"); put("みゃ", "mya"); put("mya", "みゃ"); put("りゃ", "rya"); put("rya", "りゃ"); put("ぎゃ", "gya"); put("gya", "ぎゃ"); put("じゃ", "jya"); put("jya", "じゃ"); put("ぢゃ", "dya"); put("dya", "ぢゃ"); put("びゃ", "bya"); put("bya", "びゃ"); put("ぴゃ", "pya"); put("pya", "ぴゃ");
        put("きゅ", "kyu"); put("kyu", "きゅ"); put("しゅ", "shu"); put("shu", "しゅ"); put("ちゅ", "chu"); put("chu", "ちゅ"); put("にゅ", "nyu"); put("nyu", "にゅ"); put("ひゅ", "hyu"); put("hyu", "ひゅ"); put("みゅ", "myu"); put("myu", "みゅ"); put("りゅ", "ryu"); put("ryu", "りゅ"); put("ぎゅ", "gyu"); put("gyu", "ぎゅ"); put("じゅ", "jyu"); put("jyu", "じゅ"); put("ぢゅ", "dyu"); put("dyu", "ぢゅ"); put("びゅ", "byu"); put("byu", "びゅ"); put("ぴゅ", "pyu"); put("pyu", "ぴゅ");
        put("きょ", "kyo"); put("kyo", "きょ"); put("しょ", "sho"); put("sho", "しょ"); put("ちょ", "cho"); put("cho", "ちょ"); put("にょ", "nyo"); put("nyo", "にょ"); put("ひょ", "hyo"); put("hyo", "ひょ"); put("みょ", "myo"); put("myo", "みょ"); put("りょ", "ryo"); put("ryo", "りょ"); put("ぎょ", "gyo"); put("gyo", "ぎょ"); put("じょ", "jyo"); put("jyo", "じょ"); put("ぢょ", "dyo"); put("dyo", "ぢょ"); put("びょ", "byo"); put("byo", "びょ"); put("ぴょ", "pyo"); put("pyo", "ぴょ");
    }};

    // This method converts romanji words up to 5 letters long to hiragana characters
    private static String convertWord(String romanji) {
        String firstHalf, secondHalf;
        switch (romanji.length()) {
            case 1:
                return (hiraganaChart.containsKey(romanji)) ? hiraganaChart.get(romanji) : romanji;
            case 2:
                if (hiraganaChart.containsKey(romanji)) return hiraganaChart.get(romanji);
                firstHalf = hiraganaChart.get(String.valueOf(romanji.charAt(0)));
                secondHalf = hiraganaChart.get(String.valueOf(romanji.charAt(1)));
                if (hiraganaChart.containsKey(firstHalf) && hiraganaChart.containsKey(secondHalf)) {
                    return firstHalf + secondHalf;
                }
                return romanji;
            case 3:
                if (hiraganaChart.containsKey(romanji)) return hiraganaChart.get(romanji);
                firstHalf = String.valueOf(romanji.charAt(0));
                secondHalf = romanji.substring(1, 3);
                if (hiraganaChart.containsKey(firstHalf) && !convertWord(secondHalf).equals(secondHalf)) {
                    return hiraganaChart.get(firstHalf) + convertWord(secondHalf);
                }
                firstHalf = romanji.substring(0, 2);
                secondHalf = String.valueOf(romanji.charAt(2));
                if (hiraganaChart.containsKey(secondHalf) && !convertWord(firstHalf).equals(firstHalf)) {
                    return convertWord(firstHalf) + hiraganaChart.get(secondHalf);
                }
                return romanji;
            case 4:
                firstHalf = romanji.substring(0, 3);
                secondHalf = String.valueOf(romanji.charAt(3));
                if (!convertWord(firstHalf).equals(firstHalf) && hiraganaChart.containsKey(secondHalf)) {
                    return convertWord(firstHalf) + hiraganaChart.get(secondHalf);
                }
                firstHalf = romanji.substring(1, 4);
                secondHalf = String.valueOf(romanji.charAt(0));
                if (!convertWord(firstHalf).equals(firstHalf) && hiraganaChart.containsKey(secondHalf)) {
                    return hiraganaChart.get(secondHalf) + convertWord(firstHalf);
                }
                firstHalf = romanji.substring(0, 2);
                secondHalf = romanji.substring(2, 4);
                if (!convertWord(firstHalf).equals(firstHalf) && !convertWord(secondHalf).equals(secondHalf)) {
                    return convertWord(firstHalf) + convertWord(secondHalf);
                }
                return romanji;
            case 5:
                firstHalf = romanji.substring(0, 4);
                secondHalf = String.valueOf(romanji.charAt(4));
                if (!convertWord(firstHalf).equals(firstHalf) && hiraganaChart.containsKey(secondHalf)) {
                    return convertWord(firstHalf) + hiraganaChart.get(secondHalf);
                }
                firstHalf = romanji.substring(0, 3);
                secondHalf = romanji.substring(3, 5);
                if (!convertWord(firstHalf).equals(firstHalf) && !convertWord(secondHalf).equals(secondHalf)) {
                    return convertWord(firstHalf) + convertWord(secondHalf);
                }
                firstHalf = romanji.substring(0, 2);
                secondHalf = romanji.substring(2, 5);
                if (!convertWord(firstHalf).equals(firstHalf) && !convertWord(secondHalf).equals(secondHalf)) {
                    return convertWord(firstHalf) + convertWord(secondHalf);
                }
        }

        return convertWord(romanji.substring(0, romanji.length() - 1)) + romanji.charAt(romanji.length() - 1);
    }

    /*█████╗ ██████╗ ██╗██████╗   ██╗   ██╗ █████╗ ██████╗ ██╗ █████╗ ██████╗ ██╗     ███████╗ ██████╗
    ██╔════╝ ██╔══██╗██║██╔══██╗  ██║   ██║██╔══██╗██╔══██╗██║██╔══██╗██╔══██╗██║     ██╔════╝██╔════╝
    ██║  ██╗ ██████╔╝██║██║  ██║  ╚██╗ ██╔╝███████║██████╔╝██║███████║██████╦╝██║     █████╗  ╚█████╗
    ██║  ╚██╗██╔══██╗██║██║  ██║   ╚████╔╝ ██╔══██║██╔══██╗██║██╔══██║██╔══██╗██║     ██╔══╝   ╚═══██╗
    ╚██████╔╝██║  ██║██║██████╔╝    ╚██╔╝  ██║  ██║██║  ██║██║██║  ██║██████╦╝███████╗███████╗██████╔╝
     ╚═════╝ ╚═╝  ╚═╝╚═╝╚═════╝      ╚═╝   ╚═╝  ╚═╝╚═╝  ╚═╝╚═╝╚═╝  ╚═╝╚═════╝ ╚══════╝╚══════╝╚════*/

    public static String[] triedWords = {"", "", "", "", "", "", ""};
    public static String chosenWord;
    public static int current_row = 0, current_columns = 0;
    final public static int[][] grid_id = {
            {R.id.E12, R.id.E13, R.id.E14},
            {R.id.E22, R.id.E23, R.id.E24},
            {R.id.E32, R.id.E33, R.id.E34},
            {R.id.E42, R.id.E43, R.id.E44},
            {R.id.E52, R.id.E53, R.id.E54},
            {R.id.E62, R.id.E63, R.id.E64},
    };

    public void createGrid() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 3; j++) {
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
            {R.id.Enter, R.id.C, R.id.V, R.id.B, R.id.N, R.id.M, R.id.Delete},
    };

    final public static int[][] keyboard_color = new int[4][7];

    final public static String keyboard_position = "QWERTYUIOPASDFGHJKLZX1CVBNM2";

    public void createKeyboard() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 7; j++) {
                TextView key = findViewById(keyboard_id[i][j]);
                key.setBackgroundResource(R.drawable.not_selected);
                key.setOnClickListener(v -> {
                    int key_id = v.getId();
                    String key1 = (getResources().getResourceEntryName(key_id));
                    switch (key1) {
                        case "Enter":
                            enterPressed();
                            break;
                        case "Delete":
                            deletePressed();
                            break;
                        default:
                            keyPressed(key1);
                    }
                });
                // Change key-color
                keyboard_color[i][j] = 0; // 0 = Not Selected, 1 = Not there, 2 = Yellow Tile, 3 = Green Tile
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP && !((i == 3 && j == 0) || (i == 3 && j == 6))) {
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

    public static boolean gameOver = false;

    public void enterPressed() {
        // Don't run if game is over
        if (gameOver) {newGame(); return;}

        // Check if there are enough letters
        if (current_columns < 3) {
            showDialog("There are not enough letters. Please enter a 5 letter word.");
            return;
        }

        String input_word = constructWord().toUpperCase();

        // Check if current word is valid
        if (!listContainsWord(input_word.toLowerCase())) {
            showDialog("The dictionary does not contain this word. Please try again.");
            return;
        }
        if (wordHasBeenTried(input_word)) {
            showDialog("The word has already been tried above ! Try something else...");
            return;
        }

        // Log.d("CHEATER", "TRY : " + input_word);

        // Check Green Tiles
        //String letters_remaining = checkGreenTiles(input_word);

        // Check Yellow Tiles
        //checkYellowTiles(letters_remaining, input_word);

        // No more tries left for player
        if (current_row == 3) {
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

    /*████╗  █████╗  ██╗       ██╗   █████╗ ██╗  ██╗███████╗ █████╗ ██╗  ██╗
    ██╔══██╗██╔══██╗ ██║  ██╗  ██║  ██╔══██╗██║  ██║██╔════╝██╔══██╗██║ ██╔╝
    ██████╔╝██║  ██║ ╚██╗████╗██╔╝  ██║  ╚═╝███████║█████╗  ██║  ╚═╝█████═╝
    ██╔══██╗██║  ██║  ████╔═████║   ██║  ██╗██╔══██║██╔══╝  ██║  ██╗██╔═██╗
    ██║  ██║╚█████╔╝  ╚██╔╝ ╚██╔╝   ╚█████╔╝██║  ██║███████╗╚█████╔╝██║ ╚██╗
    ╚═╝  ╚═╝ ╚════╝    ╚═╝   ╚═╝     ╚════╝ ╚═╝  ╚═╝╚══════╝ ╚════╝ ╚═╝  ╚*/

    public String constructWord() {
        StringBuilder input_word_finder = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            TextView tile = findViewById(grid_id[current_row][i]);
            char letter = tile.getText().charAt(0);
            input_word_finder.append(letter);
        }
        return input_word_finder.toString().toLowerCase();
    }

    public boolean listContainsWord(String word) {
        int firstLetter = word.charAt(0);
        for (String s : wordList) {
            if (s.equals(word)) return true;
            if (firstLetter < (int) (s.charAt(0))) return false;
        }
        return false;
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
                    findViewById(keyboard_id[keyPosition / 7][keyPosition % 7]).setBackgroundTintList(ColorStateList.valueOf(Color.rgb(76, 175, 80)));
                    keyboard_color[keyPosition / 7][keyPosition % 7] = 3;
                }
            }
            // Add remaining letters to check for yellow/gray tiles
            else remaining_letters.append(chosenWord.charAt(i));
        }
        if (correctCounter == chosenWord.length()) {
            gameOver = true;
            showDialog("\uD83C\uDF89 Congratulation \uD83C\uDF89\n You found the word");
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
                    if (keyboard_color[keyPosition / 7][keyPosition % 7] <= 1) {
                        findViewById(keyboard_id[keyPosition / 7][keyPosition % 7]).setBackgroundTintList(ColorStateList.valueOf(Color.rgb(43, 40, 40)));
                        keyboard_color[keyPosition / 7][keyPosition % 7] = 2;
                    }
                }
            }
            tile.setTextColor(Color.WHITE);
        }
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

        Button newGame = dialog.findViewById(R.id.newGame);
        if (gameOver) {
            newGame.setVisibility(View.VISIBLE);
            newGame.setOnClickListener(v -> newGame());
        }
        else newGame.setVisibility(View.GONE);

        dialog.show();
    }

    /*████╗ ██████╗ ██╗██╗   ██╗███████╗██████╗    █████╗  █████╗ ██████╗ ███████╗
    ██╔══██╗██╔══██╗██║██║   ██║██╔════╝██╔══██╗  ██╔══██╗██╔══██╗██╔══██╗██╔════╝
    ██║  ██║██████╔╝██║╚██╗ ██╔╝█████╗  ██████╔╝  ██║  ╚═╝██║  ██║██║  ██║█████╗
    ██║  ██║██╔══██╗██║ ╚████╔╝ ██╔══╝  ██╔══██╗  ██║  ██╗██║  ██║██║  ██║██╔══╝
    ██████╔╝██║  ██║██║  ╚██╔╝  ███████╗██║  ██║  ╚█████╔╝╚█████╔╝██████╔╝███████╗
    ╚═════╝ ╚═╝  ╚═╝╚═╝   ╚═╝   ╚══════╝╚═╝  ╚═╝   ╚════╝  ╚════╝ ╚═════╝ ╚═════*/
    public void newGame() {
        // Create keyboard again
        createKeyboard();

        // Create grid again
        current_columns = 0; current_row = 0;
        createGrid();

        // Chose new word
        chosenWord = wordList.get((int)(Math.random() * wordList.size())).toUpperCase();

        // Resets gameOver boolean
        //gameOver = false;

        // Log new word for debugging ;)
        Log.d("CHEATER", chosenWord);
    }
    public static Intent makeIntent(Context context) {
        return new Intent(context, Japanese.class);
    }

    private void setupEndActivityButton() {
        Button btn = findViewById(R.id.japanese_back_button);
        btn.setOnClickListener(v -> {
            newGame();
            finish();
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_japanese);

        // Create option to go back to menu
        setupEndActivityButton();

        // Load json file
        loadFiles();

        //createHiraganaChart();
        Log.d("CHEATER", "Test Word 1 : " + convertWord("jyaki"));
    }

    private static Vector<String> wordList = new Vector<>();

    private void loadFiles() {
        try {
            InputStream inputStream = getResources().openRawResource(R.raw.words);

            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while ((line = reader.readLine()) != null) {
                wordList.add(line);
            }
            inputStream.close();
        }
        catch (IOException e) {
            Log.d("CHEATER", "ERROR : " + e);
        }
    }
}