package com.example.wordleonthego;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

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

    /*████╗ ██████╗ ██╗██╗   ██╗███████╗██████╗    █████╗  █████╗ ██████╗ ███████╗
    ██╔══██╗██╔══██╗██║██║   ██║██╔════╝██╔══██╗  ██╔══██╗██╔══██╗██╔══██╗██╔════╝
    ██║  ██║██████╔╝██║╚██╗ ██╔╝█████╗  ██████╔╝  ██║  ╚═╝██║  ██║██║  ██║█████╗
    ██║  ██║██╔══██╗██║ ╚████╔╝ ██╔══╝  ██╔══██╗  ██║  ██╗██║  ██║██║  ██║██╔══╝
    ██████╔╝██║  ██║██║  ╚██╔╝  ███████╗██║  ██║  ╚█████╔╝╚█████╔╝██████╔╝███████╗
    ╚═════╝ ╚═╝  ╚═╝╚═╝   ╚═╝   ╚══════╝╚═╝  ╚═╝   ╚════╝  ╚════╝ ╚═════╝ ╚═════*/
    public static Intent makeIntent(Context context) {
        return new Intent(context, Japanese.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_japanese);

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