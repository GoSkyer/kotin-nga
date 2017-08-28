package org.gosky.nga.widget.richtext;

import android.util.Log;

import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * @author guozhong
 * @date 2017/8/25
 */

public class Token {
    private static final String TAG = "Token";

    static abstract class TOKEN implements Comparable<TOKEN> {
        int position;
        int length;
        CharSequence value;

        public TOKEN(int position, int length, CharSequence value) {
            this.position = position;
            this.length = length;
            this.value = value;
        }

        public static String getString(List<TOKEN> tokens) {
            StringBuilder builder = new StringBuilder();
            for (TOKEN token : tokens) {
                builder.append(token.value);
            }
            return builder.toString();
        }

        @Override
        public int compareTo(@NotNull TOKEN token) {
            if (position < token.position) {
                return -1;
            }
            if (position == token.position) {
                /**
                 * tokenA < tokenB when tokenA.position == tokenB.position and
                 * tokenA.length > tokenB.length,
                 * used to remove overlapping tokens
                 */
                if (length < token.length) {
                    return 1;
                } else if (length > token.length) {
                    return -1;
                } else {
                    return 0;
                }
            } else {
                return 1;
            }
        }
    }


    static class PLAIN extends TOKEN {
        PLAIN(int position, CharSequence value) {
            super(position, value.length(), value);
        }
    }

    static class COLOR_START extends TOKEN {
        String color;

        COLOR_START(int position, String value, String color) {
            super(position, value.length(), value);
            this.color = color;
        }
    }

    static class COLOR_END extends TOKEN {
        COLOR_END(int position, String value) {
            super(position, value.length(), value);
        }
    }

    static class SIZE_START extends TOKEN {
        String color;

        SIZE_START(int position, String value, String color) {
            super(position, value.length(), value);
            this.color = color;
        }
    }

    static class SIZE_END extends TOKEN {
        SIZE_END(int position, String value) {
            super(position, value.length(), value);
        }
    }

    static class URL_START extends TOKEN {
        String url;

        URL_START(int position, String url, String value) {
            super(position, value.length(), value);
            this.url = url;
        }
    }

    static class URL_END extends TOKEN {
        URL_END(int position, String value) {
            super(position, value.length(), value);
        }
    }

    static class CURTAIN_START extends TOKEN {
        CURTAIN_START(int position, String value) {
            super(position, value.length(), value);
        }
    }

    static class CURTAIN_END extends TOKEN {
        CURTAIN_END(int position, String value) {
            super(position, value.length(), value);
        }

    }

    static class BOLD_START extends TOKEN {
        BOLD_START(int position, String value) {
            super(position, value.length(), value);
        }
    }

    static class BOLD_END extends TOKEN {

        BOLD_END(int position, String value) {
            super(position, value.length(), value);
        }
    }

    static class ITALIC_START extends TOKEN {
        ITALIC_START(int position, String value) {
            super(position, value.length(), value);
        }
    }

    static class ITALIC_END extends TOKEN {
        ITALIC_END(int position, String value) {
            super(position, value.length(), value);
        }
    }

    static class UNDERLINE_START extends TOKEN {
        UNDERLINE_START(int position, String value) {
            super(position, value.length(), value);
        }
    }

    static class UNDERLINE_END extends TOKEN {
        UNDERLINE_END(int position, String value) {
            super(position, value.length(), value);
        }
    }

    static class DELETE_START extends TOKEN {
        DELETE_START(int position, String value) {
            super(position, value.length(), value);
        }
    }

    static class DELETE_END extends TOKEN {
        DELETE_END(int position, String value) {
            super(position, value.length(), value);
        }
    }

//    static class DELETE extends TOKEN {
//
//        public DELETE(int position, CharSequence value) {
//            super(position, value.length(), value);
//        }
//    }


    static class LIST_START extends TOKEN {
        LIST_START(int position, String content) {
            super(position, content.length(), content);
        }
    }

    static class LIST_END extends TOKEN {
        LIST_END(int position, String value) {
            super(position, value.length(), value);
        }
    }

    static class CENTER_START extends TOKEN {
        CENTER_START(int position, String value) {
            super(position, value.length(), value);
        }
    }

    static class CENTER_END extends TOKEN {
        CENTER_END(int position, String value) {
            super(position, value.length(), value);

        }
    }

    static class TITLE_START extends TOKEN {
        TITLE_START(int position, String value) {
            super(position, value.length(), value);
        }
    }

    static class TITLE_END extends TOKEN {
        TITLE_END(int position, String value) {
            super(position, value.length(), value);
        }
    }

    static class ICON extends TOKEN {
        String iconPath;

        ICON(int position, String iconStr, String iconPath) {
            super(position, iconStr.length(), iconStr);
            this.iconPath = iconPath;
        }
    }

    static class FORMULA extends TOKEN {
        String content;
        int contentStart;

        FORMULA(int position, String content, int contentStart, String value) {
            /*
             * remove all newline character to avoid the ImageSpan shows multiple times when
             * formula content stretches over multiple lines.
             */
            super(position, value.length(), value.replaceAll("[\n\r]", ""));
            this.content = content.replaceAll("[\n\r]", "");
            this.contentStart = contentStart;
        }
    }

    static class CODE_START extends TOKEN {
        CODE_START(int position, String value) {
            super(position, value.length(), value);
        }
    }

    static class CODE_END extends TOKEN {
        CODE_END(int position, String value) {
            super(position, value.length(), value);
        }
    }


    static class QUOTE_START extends TOKEN {
        String quotedUsername;
        String postId;

        QUOTE_START(int position, String value, String quotedUsername, String postId) {
            super(position, value.length(), value);
            this.quotedUsername = quotedUsername;
            this.postId = postId;
        }
    }

    static class QUOTE_END extends TOKEN {
        QUOTE_END(int position, String value) {
            super(position, value.length(), value);
        }
    }

    static class IMAGE extends TOKEN {
        String url;

        IMAGE(int position, String value, String url) {
            super(position, value.length(), value);
            this.url = setRealUrl(url);
        }

        private String setRealUrl(String url) {
            String s = url;
            if (url.startsWith("./"))
                s = "http://img.nga.cn/attachments" + url.replace("./", "/");
            if (!url.endsWith(".medium.jpg") && url.endsWith(".jpg") && url.startsWith("http://img.nga.cn/"))
                s = s + ".medium.jpg";
            Log.i(TAG, "setRealUrl: " + s);
            return s;
        }
    }

    static class TABLE extends TOKEN {
        TABLE(int position, String content) {
            super(position, content.length(), content);
        }
    }


    static class END extends TOKEN {
        END(int position) {
            super(position, 0, "");
        }
    }
}
