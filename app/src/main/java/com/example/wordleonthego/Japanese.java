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
        put("だ", "da"); put("da", "だ"); put("ぢ", "di"); put("di", "ぢ"); put("づ", "du"); put("du", "づ"); put("で", "de"); put("de", "で"); put("ど", "do"); put("do", "ど");
        put("ば", "ba"); put("ba", "ば"); put("び", "bi"); put("bi", "び"); put("ぶ", "bu"); put("bu", "ぶ"); put("べ", "be"); put("be", "べ"); put("ぼ", "bo"); put("bo", "ぼ");
        put("ぱ", "pa"); put("pa", "ぱ"); put("ぴ", "pi"); put("pi", "ぴ"); put("ぷ", "pu"); put("pu", "ぷ"); put("ぺ", "pe"); put("pe", "ぺ"); put("ぽ", "po"); put("po", "ぽ");

        put("きゃ", "kya"); put("kya", "きゃ"); put("しゃ", "sha"); put("sha", "しゃ"); put("ちゃ", "cha"); put("cha", "ちゃ"); put("にゃ", "nya"); put("nya", "にゃ"); put("ひゃ", "hya"); put("hya", "ひゃ"); put("みゃ", "mya"); put("mya", "みゃ"); put("りゃ", "rya"); put("rya", "りゃ"); put("ぎゃ", "gya"); put("gya", "ぎゃ"); put("じゃ", "jya"); put("jya", "じゃ"); put("ぢゃ", "dya"); put("dya", "ぢゃ"); put("びゃ", "bya"); put("bya", "びゃ"); put("ぴゃ", "pya"); put("pya", "ぴゃ");
        put("きゅ", "kyu"); put("kyu", "きゅ"); put("しゅ", "shu"); put("shu", "しゅ"); put("ちゅ", "chu"); put("chu", "ちゅ"); put("にゅ", "nyu"); put("nyu", "にゅ"); put("ひゅ", "hyu"); put("hyu", "ひゅ"); put("みゅ", "myu"); put("myu", "みゅ"); put("りゅ", "ryu"); put("ryu", "りゅ"); put("ぎゅ", "gyu"); put("gyu", "ぎゅ"); put("じゅ", "jyu"); put("jyu", "じゅ"); put("ぢゅ", "dyu"); put("dyu", "ぢゅ"); put("びゅ", "byu"); put("byu", "びゅ"); put("ぴゅ", "pyu"); put("pyu", "ぴゅ");
        put("きょ", "kyo"); put("kyo", "きょ"); put("しょ", "sho"); put("sho", "しょ"); put("ちょ", "cho"); put("cho", "ちょ"); put("にょ", "nyo"); put("nyo", "にょ"); put("ひょ", "hyo"); put("hyo", "ひょ"); put("みょ", "myo"); put("myo", "みょ"); put("りょ", "ryo"); put("ryo", "りょ"); put("ぎょ", "gyo"); put("gyo", "ぎょ"); put("じょ", "jyo"); put("jyo", "じょ"); put("ぢょ", "dyo"); put("dyo", "ぢょ"); put("びょ", "byo"); put("byo", "びょ"); put("ぴょ", "pyo"); put("pyo", "ぴょ");
    }};

    // Japanese also has this weird system where adding small つ
    // in front of another kana makes the consonant part sound longer.
    // So っ(small tsu) + か (ka) = っか (kka)
    private static void addSmallTsu() {
        String neededConsonants = "kstnhmyrwgzdbp";
        String neededVowels = "aeiou";
        for (int i = 0; i < neededConsonants.length(); i++) {
        for (int j = 0; j < neededVowels.length(); j++) {
            String consonant = String.valueOf(neededConsonants.charAt(i));
            String vowel = String.valueOf(neededVowels.charAt(j));
            String secondKana = hiraganaChart.get(consonant + vowel);
            hiraganaChart.put(consonant + consonant + vowel, "っ" + secondKana);
        }}
    }

    // This method converts romanji words up to 5 letters long to hiragana characters
    private static String convertWord(String romanji) {
        if (hiraganaChart.containsKey(romanji)) return hiraganaChart.get(romanji);

        StringBuilder kanaVersion = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            String currentScan = romanji.substring(0, i + 1);
            if (hiraganaChart.containsKey(currentScan)) {
                kanaVersion.append(hiraganaChart.get(currentScan));
                kanaVersion.append(convertWord(romanji.substring(i + 1)));
                break;
            }
        }

        return kanaVersion.toString();
    }

    private static String convertBack(String kana) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < Math.min(kana.length(), 3); i++) {
            String currentSearch = String.valueOf(kana.charAt(i));
            if (i < 2) {
                switch (kana.charAt(i + 1)) {
                    case 'ゃ': case 'ゅ': case 'ょ':
                        currentSearch += kana.charAt(i + 1); i++;
                }
                if (kana.charAt(i) == 'っ') {
                    currentSearch += kana.charAt(i + 1); i++;
                }
            }
            if (!hiraganaChart.containsKey(currentSearch)) return "error";
            result.append(hiraganaChart.get(currentSearch));
        }
        return result.toString();
    }

    /*█████╗ ██████╗ ██╗██████╗   ██╗   ██╗ █████╗ ██████╗ ██╗ █████╗ ██████╗ ██╗     ███████╗ ██████╗
    ██╔════╝ ██╔══██╗██║██╔══██╗  ██║   ██║██╔══██╗██╔══██╗██║██╔══██╗██╔══██╗██║     ██╔════╝██╔════╝
    ██║  ██╗ ██████╔╝██║██║  ██║  ╚██╗ ██╔╝███████║██████╔╝██║███████║██████╦╝██║     █████╗  ╚█████╗
    ██║  ╚██╗██╔══██╗██║██║  ██║   ╚████╔╝ ██╔══██║██╔══██╗██║██╔══██║██╔══██╗██║     ██╔══╝   ╚═══██╗
    ╚██████╔╝██║  ██║██║██████╔╝    ╚██╔╝  ██║  ██║██║  ██║██║██║  ██║██████╦╝███████╗███████╗██████╔╝
     ╚═════╝ ╚═╝  ╚═╝╚═╝╚═════╝      ╚═╝   ╚═╝  ╚═╝╚═╝  ╚═╝╚═╝╚═╝  ╚═╝╚═════╝ ╚══════╝╚══════╝╚════*/

    private static String[] triedWords = {"", "", "", "", "", "", ""};
    private static String chosenWord, kanaWord = "!";
    private static int current_row = 0, current_columns = 0, start_column = 1, end_column = 3;
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
                grid_tile.setTextColor(getResources().getColor(R.color.black));
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

    // final public static String keyboard_position = "QWERTYUIOPASDFGHJKLZX1CVBNM2";

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
            }}
    }

    /*╗  ██╗███████╗██╗   ██╗     █████╗  █████╗ ███╗  ██╗████████╗██████╗  █████╗ ██╗      ██████╗
    ██║ ██╔╝██╔════╝╚██╗ ██╔╝    ██╔══██╗██╔══██╗████╗ ██║╚══██╔══╝██╔══██╗██╔══██╗██║     ██╔════╝
    █████═╝ █████╗   ╚████╔╝     ██║  ╚═╝██║  ██║██╔██╗██║   ██║   ██████╔╝██║  ██║██║     ╚█████╗
    ██╔═██╗ ██╔══╝    ╚██╔╝      ██║  ██╗██║  ██║██║╚████║   ██║   ██╔══██╗██║  ██║██║      ╚═══██╗
    ██║ ╚██╗███████╗   ██║       ╚█████╔╝╚█████╔╝██║ ╚███║   ██║   ██║  ██║╚█████╔╝███████╗██████╔╝
    ╚═╝  ╚═╝╚══════╝   ╚═╝        ╚════╝  ╚════╝ ╚═╝  ╚══╝   ╚═╝   ╚═╝  ╚═╝ ╚════╝ ╚══════╝╚════*/

    public void keyPressed(String key) {
        if (current_columns >= 3) {current_columns = 3; return;}
        TextView tile = findViewById(grid_id[current_row][current_columns]);
        String currentTextInRow = (tile.getText().toString() + key).toLowerCase();

        if ((currentTextInRow + key).contains("nn")) {
            tile.setText(hiraganaChart.get("n"));
            current_columns++;
            return;
        }

        if (hiraganaChart.containsKey(currentTextInRow) && !key.equalsIgnoreCase("n")) {
            String kana = hiraganaChart.get(currentTextInRow);
            assert kana != null;
            if (kana.length() > 1) {
                tile.setText(String.valueOf(kana.charAt(0)));
                current_columns++;
                tile = findViewById(grid_id[current_row][current_columns]);
                tile.setText(String.valueOf(kana.charAt(1)));
            }
            else {
                tile.setText(hiraganaChart.get(currentTextInRow));
            }
            current_columns++;
        }
        else {
            tile.setText(currentTextInRow.toUpperCase());
        }
    }

    public static boolean gameOver = false;

    public void enterPressed() {
        // Don't run if game is over
        if (gameOver) {newGame(); return;}

        // Check if there are enough letters
        if (current_columns < end_column) {
            showDialog("There are not enough letters. Please enter a 5 letter word.");
            return;
        }

        String input_word = constructWord();
        String kanaVersion = convertBack(input_word);

        // Check if current word is valid
        if (kanaVersion.equals("error")) {
            showDialog("The word is not formatted correctly. Please try again");
            return;
        }
        if (!wordList.contains(kanaVersion)) {
            showDialog("The dictionary does not contain this word. Please try again.");
            return;
        }
        if (wordHasBeenTried(input_word)) {
            showDialog("The word has already been tried above ! Try something else...");
            return;
        }

        // Check Green Tiles
        String letters_remaining = checkGreenTiles(input_word);

        // Check Yellow Tiles
        checkYellowTiles(letters_remaining, input_word);

        // No more tries left for player
        if (current_row == 6 && !gameOver) {
            // Execute Ending Code            gameOver = true;
            showDialog("GAME OVER, THE WORD WAS " + input_word);
        }
        // Proceed to next row
        else {
            triedWords[current_row] = input_word;
            current_row++;
            current_columns = start_column;
        }
    }

    public void deletePressed() {
        TextView tile = findViewById(grid_id[current_row][current_columns]);
        String currentLetters = tile.getText().toString();
        if (currentLetters.length() > 1) {
            tile.setText(currentLetters.substring(0, currentLetters.length() - 1));
        }
        else {
            if (currentLetters.length() != 1) current_columns = Math.max(start_column, current_columns - 1);
            tile = findViewById(grid_id[current_row][current_columns]);
            tile.setText("");
        }
    }

    /*████╗  █████╗  ██╗       ██╗   █████╗ ██╗  ██╗███████╗ █████╗ ██╗  ██╗
    ██╔══██╗██╔══██╗ ██║  ██╗  ██║  ██╔══██╗██║  ██║██╔════╝██╔══██╗██║ ██╔╝
    ██████╔╝██║  ██║ ╚██╗████╗██╔╝  ██║  ╚═╝███████║█████╗  ██║  ╚═╝█████═╝
    ██╔══██╗██║  ██║  ████╔═████║   ██║  ██╗██╔══██║██╔══╝  ██║  ██╗██╔═██╗
    ██║  ██║╚█████╔╝  ╚██╔╝ ╚██╔╝   ╚█████╔╝██║  ██║███████╗╚█████╔╝██║ ╚██╗
    ╚═╝  ╚═╝ ╚════╝    ╚═╝   ╚═╝     ╚════╝ ╚═╝  ╚═╝╚══════╝ ╚════╝ ╚═╝  ╚*/

    private String constructWord() {
        StringBuilder input_word_finder = new StringBuilder();
        for (int i = 0; i < kanaWord.length(); i++) {
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
        Log.d("CHEATER", "WORD = " + input + " " + kanaWord);
        for (int i = 0; i < input.length(); i++) {
            // Search for correct letters at correct position
            if (input.charAt(i) == kanaWord.charAt(i)) {
                // Change tile into green tile
                TextView tile = findViewById(grid_id[current_row][i]);
                tile.setBackgroundResource(R.drawable.green_tile);
                tile.setTextColor(Color.WHITE);
                // Add placeholder in char array
                remaining_letters.append("*");
                // Add 1 to correctCounter
                correctCounter++;
            }
            // Add remaining letters to check for yellow/gray tiles
            else remaining_letters.append(kanaWord.charAt(i));
        }
        if (correctCounter == kanaWord.length()) {
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
            }
            // Detects a letter that is not present in the word
            else {
                // Change tile to gray tile
                tile.setBackgroundResource(R.drawable.grey_tile);
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
        while (kanaWord.length() != 3) {
            chosenWord = wordList.get((int)(Math.random() * wordList.size()));
            kanaWord = convertWord(chosenWord);
        }

        // Resets gameOver boolean
        gameOver = false;

        // Log new word for debugging ;)
        Log.d("CHEATER", "CHOSEN WORD : " + chosenWord);

        for (int i = 0; i < 10; i++) Log.d("CHEATER", "GOOFY AAA " + i + " : " + wordList.get(i));
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

        // Start new Game
        newGame();

        // Add small tsu to hiragana chart
        addSmallTsu();

        //createHiraganaChart();
        Log.d("CHEATER", "CHOSEN WORD : " + convertWord("akita"));
    }

    private static Vector<String> wordList = new Vector<>();

    private void loadFiles() {
        String line;
        try {
            InputStream inputStream = getResources().openRawResource(R.raw.words);

            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            while ((line = reader.readLine()) != null) {
                wordList.add(line);
            }
            inputStream.close();
        }
        catch (IOException e) {
            Log.d("CHEATER", "ERROR : " + e);
        }
    }

    /*█╗       ██╗ █████╗ ███╗  ██╗██╗  ██╗  ██╗ █████╗ ███╗  ██╗██╗  ██████╗ ██╗ █████╗ ████████╗██╗ █████╗ ███╗  ██╗███╗  ██╗ █████╗ ██████╗ ██╗   ██╗
     ██║  ██╗  ██║██╔══██╗████╗ ██║██║  ██║ ██╔╝██╔══██╗████╗ ██║██║  ██╔══██╗██║██╔══██╗╚══██╔══╝██║██╔══██╗████╗ ██║████╗ ██║██╔══██╗██╔══██╗╚██╗ ██╔╝
     ╚██╗████╗██╔╝███████║██╔██╗██║██║  █████═╝ ███████║██╔██╗██║██║  ██║  ██║██║██║  ╚═╝   ██║   ██║██║  ██║██╔██╗██║██╔██╗██║███████║██████╔╝ ╚████╔╝
      ████╔═████║ ██╔══██║██║╚████║██║  ██╔═██╗ ██╔══██║██║╚████║██║  ██║  ██║██║██║  ██╗   ██║   ██║██║  ██║██║╚████║██║╚████║██╔══██║██╔══██╗  ╚██╔╝
      ╚██╔╝ ╚██╔╝ ██║  ██║██║ ╚███║██║  ██║ ╚██╗██║  ██║██║ ╚███║██║  ██████╔╝██║╚█████╔╝   ██║   ██║╚█████╔╝██║ ╚███║██║ ╚███║██║  ██║██║  ██║   ██║
       ╚═╝   ╚═╝  ╚═╝  ╚═╝╚═╝  ╚══╝╚═╝  ╚═╝  ╚═╝╚═╝  ╚═╝╚═╝  ╚══╝╚═╝  ╚═════╝ ╚═╝ ╚════╝    ╚═╝   ╚═╝ ╚════╝ ╚═╝  ╚══╝╚═╝  ╚══╝╚═╝  ╚═╝╚═╝  ╚═╝   ╚*/

    /*
    private static String[][] kanjiWords = {
            {"上"},
            {},
    };
    */
}