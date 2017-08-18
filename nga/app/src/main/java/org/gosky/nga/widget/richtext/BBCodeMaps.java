package org.gosky.nga.widget.richtext;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by panj on 2017/3/17.
 */

public class BBCodeMaps {

    public static Map<String, String> getCovertMap() {
        Map<String, String> bbMap = new HashMap<String, String>();

        bbMap.put("\\[url\\](.+?)\\[/url\\]", "[url=$1]$1[/url]");
        bbMap.put("\\[url=(.+?)\\]\\[img(.+?)\\[/img\\]\\[/url\\]", "[img link=$1$2[/img]");
        bbMap.put("\\[img=(.+?)x(.+?)\\](.+?)\\[/img\\]", "[img width=$1 height=$2]$3[/img]");
        return bbMap;
    }

    /**
     * Parse List Tag: [list] [*]Entry 1 [*]Entry 2 [/list] or [list] *Entry 1 *Entry 2 [/list]
     *
     * @param html html text
     * @return html
     */
    public static String bbcodeListParse(String html) {
        String listTagStart = "[list]";
        String listTagEnd = "[/list]";
        String asteriskTag1 = "[*]";
        String asteriskTag2 = "*";

        int pos = 0;
        // Only replace * which contains in [list]...[/list]
        while (html.indexOf(listTagStart, pos) != -1) {
            int sPos = html.indexOf(listTagStart, pos);
            int ePos = html.indexOf(listTagEnd, sPos) + listTagEnd.length();
            pos = ePos;

            boolean isAsteriskTag = false;

            String str1 = html.substring(sPos, ePos);
            String str2 = html.substring(sPos, ePos);

            // This must be first step
            if (str1.contains(asteriskTag1)) {
                if (str1.contains(asteriskTag1)) {
                    str1 = str1.replaceAll("\\[\\*\\](.+)", "[li]$1[/li]");
                }
                isAsteriskTag = true;
            }
            if (str1.contains(asteriskTag2)) {
                str1 = str1.replaceAll("\\*", asteriskTag1);
                if (str1.contains(asteriskTag1)) {
                    str1 = str1.replaceAll("\\[\\*\\](.+?)\\[\\*", "[li]$1[/li]\\[*");
                }
                isAsteriskTag = true;
            }
            if (isAsteriskTag) {
                html = html.substring(0, html.indexOf(str2)) + str1 + html.substring(html.indexOf(str2) + str2.length(), html.length());
            }
        }
        return html;
    }
}
