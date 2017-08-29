package org.gosky.nga.widget.richtext;

import android.util.Log;

import com.github.promeg.pinyinhelper.Pinyin;

import org.gosky.nga.widget.richtext.Token.BOLD_END;
import org.gosky.nga.widget.richtext.Token.BOLD_START;
import org.gosky.nga.widget.richtext.Token.CENTER_END;
import org.gosky.nga.widget.richtext.Token.CENTER_START;
import org.gosky.nga.widget.richtext.Token.CODE_END;
import org.gosky.nga.widget.richtext.Token.CODE_START;
import org.gosky.nga.widget.richtext.Token.COLOR_END;
import org.gosky.nga.widget.richtext.Token.COLOR_START;
import org.gosky.nga.widget.richtext.Token.CURTAIN_END;
import org.gosky.nga.widget.richtext.Token.CURTAIN_START;
import org.gosky.nga.widget.richtext.Token.DELETE_END;
import org.gosky.nga.widget.richtext.Token.DELETE_START;
import org.gosky.nga.widget.richtext.Token.END;
import org.gosky.nga.widget.richtext.Token.ICON;
import org.gosky.nga.widget.richtext.Token.IMAGE;
import org.gosky.nga.widget.richtext.Token.ITALIC_END;
import org.gosky.nga.widget.richtext.Token.ITALIC_START;
import org.gosky.nga.widget.richtext.Token.LIST_END;
import org.gosky.nga.widget.richtext.Token.LIST_START;
import org.gosky.nga.widget.richtext.Token.PLAIN;
import org.gosky.nga.widget.richtext.Token.QUOTE_END;
import org.gosky.nga.widget.richtext.Token.QUOTE_START;
import org.gosky.nga.widget.richtext.Token.SIZE_END;
import org.gosky.nga.widget.richtext.Token.SIZE_START;
import org.gosky.nga.widget.richtext.Token.TABLE;
import org.gosky.nga.widget.richtext.Token.TITLE_END;
import org.gosky.nga.widget.richtext.Token.TITLE_START;
import org.gosky.nga.widget.richtext.Token.TOKEN;
import org.gosky.nga.widget.richtext.Token.UNDERLINE_END;
import org.gosky.nga.widget.richtext.Token.UNDERLINE_START;
import org.gosky.nga.widget.richtext.Token.URL_END;
import org.gosky.nga.widget.richtext.Token.URL_START;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by daquexian on 17-2-9.
 * The tokenizer
 */

public class Tokenizer {

    private static final String TAG = "Tokenizer";

    private static List<String> colorEndLabels = Arrays.asList("(?i)\\[/c]", "(?i)\\[/color]");
    private static List<String> colorStartLabels = Arrays.asList("(?i)\\[c=(.+?)]", "(?i)\\[color=(.+?)]");
    private static List<String> urlStartLabels = Arrays.asList("(?i)\\[url=(.+?)]", "(?i)\\[url]");
    private static List<String> urlEndLabels = Arrays.asList("(?i)\\[/url]");
    private static List<String> curtainStartLabels = Arrays.asList("(?i)\\[curtain]");
    private static List<String> curtainEndLabels = Arrays.asList("(?i)\\[/curtain]");
    private static List<String> underlineStartLabels = Arrays.asList("(?i)\\[u]");
    private static List<String> underlineEndLabels = Arrays.asList("(?i)\\[/u]");
    private static List<String> boldStartLabels = Arrays.asList("(?i)\\[b]");
    private static List<String> boldEndLabels = Arrays.asList("(?i)\\[/b]");
    private static List<String> italicStartLabels = Arrays.asList("(?i)\\[i]");
    private static List<String> italicEndLabels = Arrays.asList("(?i)\\[/i]");
    private static List<String> deleteStartLabels = Arrays.asList("(?i)\\[del]");
    private static List<String> deleteEndLabels = Arrays.asList("(?i)\\[/del]");
    private static List<String> deleteLabels = Arrays.asList("(?i)\\[del](.+?)\\[/del]");
    private static List<String> centerStartLabels = Arrays.asList("(?i)\\[align=center]");
    private static List<String> centerEndLabels = Arrays.asList("(?i)\\[/align]");
    private static List<String> titleStartLabels = Arrays.asList("(?i)===");
    private static List<String> titleEndLabels = Arrays.asList("(?i)===\n");
    private static List<String> imageLabels = Arrays.asList("(?i)\\[img](.+?)\\[/img]");
    private static List<String> codeStartLabels = Arrays.asList("(?i)\\[code]");
    private static List<String> codeEndLabels = Arrays.asList("(?i)\\[/code]");
    private static List<String> quoteStartLabels = new ArrayList<>();
    private static List<String> quoteEndLabels = new ArrayList<>();

    private static List<QuotePos> quotePosList = new ArrayList<>();

    private static List<String> sizeStartLabels = Arrays.asList("(?i)\\[size=(.+?)]");
    private static List<String> sizeEndLabels = Arrays.asList("(?i)\\[/size]");

    private static List<String> listStartLabels = Arrays.asList("(?i)\\[list]");
    private static List<String> listEndLabels = Arrays.asList("(?i)\\[/list]");

    private static List<String> iconLabels = Arrays.asList("(?i)\\[s:ac:(.+?)]", "(?i)\\[s:a2:(.+?)]", "(?i)\\[s:dt:(.+?)]", " (?i)\\[s:pst:(.+?)]", "(?i)\\[s:pg:(.+?)]");

    static {
        Log.i(TAG, "Tokenizer: init");
        initLabels();
        Log.i(TAG, "static initializer: " + colorEndLabels.toString());
        Log.i(TAG, "static initializer: " + colorStartLabels.toString());
        Log.i(TAG, "static initializer: " + urlStartLabels.toString());
        Log.i(TAG, "static initializer: " + urlEndLabels.toString());
        Log.i(TAG, "static initializer: " + curtainStartLabels.toString());
        Log.i(TAG, "static initializer: " + curtainEndLabels.toString());
        Log.i(TAG, "static initializer: " + underlineStartLabels.toString());
        Log.i(TAG, "static initializer: " + underlineEndLabels.toString());
        Log.i(TAG, "static initializer: " + boldStartLabels.toString());
        Log.i(TAG, "static initializer: " + boldEndLabels.toString());
        Log.i(TAG, "static initializer: " + italicStartLabels.toString());
        Log.i(TAG, "static initializer: " + italicEndLabels.toString());
        Log.i(TAG, "static initializer: " + deleteStartLabels.toString());
        Log.i(TAG, "static initializer: " + deleteEndLabels.toString());
        Log.i(TAG, "static initializer: " + centerStartLabels.toString());
        Log.i(TAG, "static initializer: " + centerEndLabels.toString());
        Log.i(TAG, "static initializer: " + titleStartLabels.toString());
        Log.i(TAG, "static initializer: " + titleEndLabels.toString());
        Log.i(TAG, "static initializer: " + imageLabels.toString());
        Log.i(TAG, "static initializer: " + codeStartLabels.toString());
        Log.i(TAG, "static initializer: " + codeEndLabels.toString());
        Log.i(TAG, "static initializer: " + quoteStartLabels.toString());
        Log.i(TAG, "static initializer: " + quoteEndLabels.toString());
        Log.i(TAG, "static initializer: " + quotePosList.toString());
        Log.i(TAG, "static initializer: " + sizeStartLabels.toString());
        Log.i(TAG, "static initializer: " + sizeEndLabels.toString());
        Log.i(TAG, "static initializer: " + listStartLabels.toString());
        Log.i(TAG, "static initializer: " + listEndLabels.toString());
        Log.i(TAG, "static initializer: " + iconLabels.toString());
    }


    private static class ImgPos {
        byte widthPos = -1;
        byte heightPos = -1;
        byte urlPos = -1;
        byte sizePos = -1;

        public ImgPos(byte widthPos, byte heightPos, byte urlPos) {
            this.widthPos = widthPos;
            this.heightPos = heightPos;
            this.urlPos = urlPos;
        }

        public ImgPos(byte sizePos, byte urlPos) {
            this.sizePos = sizePos;
            this.urlPos = urlPos;
        }
    }

    private static class QuotePos {
        byte postIdPos = -1;
        byte memberPos = -1;

        public QuotePos(byte postIdPos, byte memberPos) {
            this.postIdPos = postIdPos;
            this.memberPos = memberPos;
        }
    }

    private static final Pattern IMG_REG = Pattern.compile("(?i)\\[img(=\\d+)?](.*?)\\[/img]");
    private static final Pattern TABLE_REG = Pattern.compile("\\[table\\]([\\s\\S]+?)\\[/table\\]");
    private static final Pattern LIST_REG = Pattern.compile("\\[list\\]([\\s\\S]+?)\\[/list\\]");


    private static int setColorStartLabel(String... labels) {
        int ret = labels.length;

        colorStartLabels = new ArrayList<>();
        for (String label : labels) {
            if (label.contains("\\s")) {
                colorStartLabels.add(formatLabel(label)
                        .replaceAll("\\\\s", "(.+?)"));
                ret--;
            }
        }

        return ret;
    }


    private static int setQuoteStartLabels(String... labels) {
        int ret = labels.length;

        quoteStartLabels = new ArrayList<>();
        quotePosList = new ArrayList<>();

        for (String label : labels) {
            byte tmp = 1, postIdPos = -1, memberPos = -1;

            for (int i = 0; i < label.length() - 1; i++) {
                if (label.substring(i).startsWith("\\m")) {
                    memberPos = tmp++;
                } else if (label.substring(i).startsWith("\\p")) {
                    postIdPos = tmp++;
                }
            }
            quoteStartLabels.add(formatLabel(label)
                    .replaceAll("\\\\m", "(.+?)")
                    .replaceAll("\\\\p", "(.+?)"));
            quotePosList.add(new QuotePos(postIdPos, memberPos));
            ret--;
        }

        return ret;
    }

    private static int setQuoteEndLabels(String... labels) {
        int ret = labels.length;

        quoteEndLabels = new ArrayList<>();
        for (String label : labels) {
            quoteEndLabels.add(formatLabel(label));
            ret--;
        }

        return ret;
    }


    private static String formatLabel(String label) {
        return "(?i)" + label.replaceAll("\\[", "\\\\[").replaceAll("\\(", "\\\\(");
    }

    private static void initLabels() {
        setColorStartLabel("[c=\\s]", "[color=\\s]");
        setQuoteStartLabels("[quote]", "[quote=\\p:@\\m]");
        setQuoteEndLabels("[/quote]");
    }

//    private void addTokenList(List<TOKEN> tokens, CharSequence text, List<String> labels, TOKEN token) {
//
//        for (String colorStartLabel : labels) {
//            Pattern pattern = Pattern.compile(colorStartLabel);
//            Matcher matcher = pattern.matcher(text);
//            while (matcher.find()) {
//                tokens.add(new COLOR_START(matcher.start(), matcher.group(), matcher.group(1)));
//            }
//        }
//    }

    public static List<TOKEN> tokenizer(CharSequence text) {

        List<TOKEN> tokenList = new ArrayList<>();

        Pattern pattern;
        Matcher matcher;
        int start;

        for (String colorStartLabel : colorStartLabels) {
            pattern = Pattern.compile(colorStartLabel);
            matcher = pattern.matcher(text);

            while (matcher.find()) {
                tokenList.add(new COLOR_START(matcher.start(), matcher.group(), matcher.group(1)));
            }
        }

        for (String urlStartLabel : urlStartLabels) {
            pattern = Pattern.compile(urlStartLabel);
            matcher = pattern.matcher(text);

            while (matcher.find()) {
                if (matcher.groupCount() > 1) {
                    String url = matcher.group(1).toLowerCase();
                    if (!url.startsWith("http://") && !url.startsWith("https://")) {
                        url = "http://" + url;
                        tokenList.add(new URL_START(matcher.start(), url, matcher.group()));
                    }
                } else {
                    tokenList.add(new URL_START(matcher.start(), "", matcher.group()));
                }

            }

        }

        for (String urlEndLabel : urlEndLabels) {
            pattern = Pattern.compile(urlEndLabel);
            matcher = pattern.matcher(text);


            while (matcher.find()) {
                tokenList.add(new URL_END(matcher.start(), matcher.group()));
            }
        }

        for (String centerStartLabel : centerStartLabels) {
            pattern = Pattern.compile(centerStartLabel);
            matcher = pattern.matcher(text);


            while (matcher.find()) {
                tokenList.add(new CENTER_START(matcher.start(), matcher.group()));

            }
        }

        for (String centerEndLabel : centerEndLabels) {
            pattern = Pattern.compile(centerEndLabel);
            matcher = pattern.matcher(text);

            while (matcher.find()) {
                tokenList.add(new CENTER_END(matcher.start(), matcher.group()));
            }
        }

        for (String curtainStartLabel : curtainStartLabels) {
            pattern = Pattern.compile(curtainStartLabel);
            matcher = pattern.matcher(text);

            while (matcher.find()) {
                tokenList.add(new CURTAIN_START(matcher.start(), matcher.group()));
            }
        }

        for (String curtainEndLabel : curtainEndLabels) {
            pattern = Pattern.compile(curtainEndLabel);
            matcher = pattern.matcher(text);

            while (matcher.find()) {
                tokenList.add(new CURTAIN_END(matcher.start(), matcher.group()));
            }
        }

        for (String colorEndLabel : colorEndLabels) {
            pattern = Pattern.compile(colorEndLabel);
            matcher = pattern.matcher(text);

            while (matcher.find()) {
                tokenList.add(new COLOR_END(matcher.start(), matcher.group()));
            }
        }
        for (String sizeEndLabel : sizeEndLabels) {
            pattern = Pattern.compile(sizeEndLabel);
            matcher = pattern.matcher(text);

            while (matcher.find()) {
                tokenList.add(new SIZE_END(matcher.start(), matcher.group()));
            }
        }

        for (String italicStartLabel : italicStartLabels) {
            pattern = Pattern.compile(italicStartLabel);
            matcher = pattern.matcher(text);

            while (matcher.find()) {
                tokenList.add(new ITALIC_START(matcher.start(), matcher.group()));
            }
        }

        for (String italicEndLabel : italicEndLabels) {
            pattern = Pattern.compile(italicEndLabel);
            matcher = pattern.matcher(text);

            while (matcher.find()) {
                tokenList.add(new ITALIC_END(matcher.start(), matcher.group()));
            }
        }

        for (String boldStartLabel : boldStartLabels) {
            pattern = Pattern.compile(boldStartLabel);
            matcher = pattern.matcher(text);

            while (matcher.find()) {
                tokenList.add(new BOLD_START(matcher.start(), matcher.group()));
            }
        }

        for (String boldEndLabel : boldEndLabels) {
            pattern = Pattern.compile(boldEndLabel);
            matcher = pattern.matcher(text);

            while (matcher.find()) {
                tokenList.add(new BOLD_END(matcher.start(), matcher.group()));
            }
        }

        for (String deleteStartLabel : deleteStartLabels) {
            pattern = Pattern.compile(deleteStartLabel);
            matcher = pattern.matcher(text);

            while (matcher.find()) {
                Log.i(TAG, "deleteStartLabel: group: " + matcher.group() + "\nstart" + matcher.start());
                tokenList.add(new DELETE_START(matcher.start(), matcher.group()));
            }
        }

//        for (String deleteLabel :deleteLabels){
//            pattern = Pattern.compile(deleteLabel);
//            matcher = pattern.matcher(text);
//
//            while (matcher.find()) {
//                tokenList.add(new Token.DELETE(matcher.start(), matcher.group(1)));
//            }
//        }

        for (String deleteEndLabel : deleteEndLabels) {
            pattern = Pattern.compile(deleteEndLabel);
            matcher = pattern.matcher(text);

            while (matcher.find()) {
                tokenList.add(new DELETE_END(matcher.start(), matcher.group()));
            }
        }

        for (String underlineStartLabel : underlineStartLabels) {
            pattern = Pattern.compile(underlineStartLabel);
            matcher = pattern.matcher(text);

            while (matcher.find()) {
                tokenList.add(new UNDERLINE_START(matcher.start(), matcher.group()));
            }
        }

        for (String underlineEndLabel : underlineEndLabels) {
            pattern = Pattern.compile(underlineEndLabel);
            matcher = pattern.matcher(text);

            while (matcher.find()) {
                tokenList.add(new UNDERLINE_END(matcher.start(), matcher.group()));
            }
        }

        for (String titleStartLabel : titleStartLabels) {
            pattern = Pattern.compile(titleStartLabel);
            matcher = pattern.matcher(text);

            while (matcher.find()) {
                tokenList.add(new TITLE_START(matcher.start(), matcher.group()));
            }
        }

        for (String titleEndLabel : titleEndLabels) {
            pattern = Pattern.compile(titleEndLabel);
            matcher = pattern.matcher(text);

            while (matcher.find()) {
                tokenList.add(new TITLE_END(matcher.start(), matcher.group()));
            }
        }

        for (String codeStartLabel : codeStartLabels) {
            pattern = Pattern.compile(codeStartLabel);
            matcher = pattern.matcher(text);

            while (matcher.find()) {
                tokenList.add(new CODE_START(matcher.start(), matcher.group()));
            }
        }

        for (String codeEndLabel : codeEndLabels) {
            pattern = Pattern.compile(codeEndLabel);
            matcher = pattern.matcher(text);

            while (matcher.find()) {
                tokenList.add(new CODE_END(matcher.start(), matcher.group()));
            }
        }
        for (String colorStartLabel : colorStartLabels) {
            pattern = Pattern.compile(colorStartLabel);
            matcher = pattern.matcher(text);

            while (matcher.find()) {
                tokenList.add(new COLOR_START(matcher.start(), matcher.group(), matcher.group(1)));
            }
        }
        for (String sizeStartLabel : sizeStartLabels) {
            pattern = Pattern.compile(sizeStartLabel);
            matcher = pattern.matcher(text);

            while (matcher.find()) {
                tokenList.add(new SIZE_START(matcher.start(), matcher.group(), matcher.group(1)));
            }
        }
        for (String listStartLabel : listStartLabels) {
            pattern = Pattern.compile(listStartLabel);
            matcher = pattern.matcher(text);

            while (matcher.find()) {
                tokenList.add(new LIST_START(matcher.start(), matcher.group()));
            }
        }

        for (String listEndLabel : listEndLabels) {
            pattern = Pattern.compile(listEndLabel);
            matcher = pattern.matcher(text);

            while (matcher.find()) {
                tokenList.add(new LIST_END(matcher.start(), matcher.group()));
            }
        }

        for (int i = 0; i < quoteStartLabels.size(); i++) {
            String quoteStartLabel = quoteStartLabels.get(i);
            QuotePos quotePos = quotePosList.get(i);
            pattern = Pattern.compile(quoteStartLabel);
            matcher = pattern.matcher(text);

            while (matcher.find()) {
                if (quotePos.postIdPos == -1 && quotePos.memberPos == -1) {
                    tokenList.add(new QUOTE_START(matcher.start(), matcher.group(), "", ""));
                } else if (quotePos.postIdPos == -1) {
                    tokenList.add(new QUOTE_START(matcher.start(), matcher.group(), matcher.group(1), ""));
                } else if (quotePos.memberPos == -1) {
                    tokenList.add(new QUOTE_START(matcher.start(), matcher.group(), "", matcher.group(1)));
                } else {
                    tokenList.add(new QUOTE_START(matcher.start(), matcher.group(), matcher.group(quotePos.memberPos), matcher.group(quotePos.postIdPos)));
                }
            }
        }

        for (String quoteEndLabel : quoteEndLabels) {
            pattern = Pattern.compile(quoteEndLabel);
            matcher = pattern.matcher(text);

            while (matcher.find()) {
                tokenList.add(new QUOTE_END(matcher.start(), matcher.group()));
            }
        }

        String str = text.toString();

        for (int i = 0; i < iconLabels.size(); i++) {
            String iconLabel = iconLabels.get(i);
            pattern = Pattern.compile(iconLabel);
            matcher = pattern.matcher(text);
            while (matcher.find()) {
                Log.i(TAG, "icon: " + matcher.group());
                String replace = matcher.group(1).replace("ac:", "");
                replace = Pinyin.toPinyin(replace, "").toLowerCase();
                String s = "";
                if (i == 0)
                    s = "emotions/ac/emotion_1_" + replace + ".png";
                if (i == 1)
                    s = "emotions/a2/a2_" + replace + ".png";
                if (i == 2)
                    s = "emotions/zrdm/" + replace + ".png";
                if (i == 3)
                    s = "emotions/panst/" + replace + ".png";
                if (i == 4)
                    s = "emotions/penguin/pg" + replace + ".png";
                tokenList.add(new ICON(matcher.start(), matcher.group(), s));
            }
        }

        for (int i = 0; i < imageLabels.size(); i++) {
            String imageLabel = imageLabels.get(i);
            pattern = Pattern.compile(imageLabel);
            matcher = pattern.matcher(text);

            while (matcher.find()) {
                tokenList.add(new IMAGE(matcher.start(), matcher.group(), matcher.group(1)));
            }
        }

        pattern = TABLE_REG;
        matcher = pattern.matcher(text);

        while (matcher.find()) {
            tokenList.add(new TABLE(matcher.start(), matcher.group()));
        }


        Collections.sort(tokenList);

        for (int i = 0; i < tokenList.size(); i++) {
            TOKEN token = tokenList.get(i);

            if (token instanceof TABLE) {
                for (int j = 0; j < tokenList.size(); j++) {
                    TOKEN token1 = tokenList.get(j);

                    if (token1.position >= token.position + token.length) {
                        break;
                    }

                    if (token1.position > token.position) {
                        tokenList.remove(j);
                        j--;
                    }
                }
            }
        }

        tokenList.add(new END(text.length()));
        removeOverlappingTokens(tokenList);

        start = 0;
        for (int i = 0; i < tokenList.size(); i++) {
            TOKEN token = tokenList.get(i);
            if (token.position > start) {
                CharSequence value = text.subSequence(start, token.position);
                tokenList.add(i, new PLAIN(start, value));
                Log.i(TAG, "PLAIN: " + value);
                i++;
            }
            start = token.position + token.length;
        }

        return tokenList;
    }

    /**
     * @param tokenList a sorted list
     */
    private static void removeOverlappingTokens(List<TOKEN> tokenList) {
        for (int i = tokenList.size() - 1; i >= 1; i--) {
            TOKEN thisToken = tokenList.get(i);
            TOKEN prevToken = tokenList.get(i - 1);

            if (thisToken.position < prevToken.position + prevToken.length) {
                tokenList.remove(thisToken);
            }
        }
    }
}
