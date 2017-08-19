package org.gosky.nga.widget.richtext;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.text.Layout;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.AlignmentSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.BulletSpan;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.gosky.nga.R;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import io.github.kbiakov.codeview.CodeView;

import static org.gosky.nga.widget.richtext.Tokenizer.ATTACHMENT;
import static org.gosky.nga.widget.richtext.Tokenizer.BOLD_END;
import static org.gosky.nga.widget.richtext.Tokenizer.BOLD_START;
import static org.gosky.nga.widget.richtext.Tokenizer.CENTER_END;
import static org.gosky.nga.widget.richtext.Tokenizer.CENTER_START;
import static org.gosky.nga.widget.richtext.Tokenizer.CODE_END;
import static org.gosky.nga.widget.richtext.Tokenizer.CODE_START;
import static org.gosky.nga.widget.richtext.Tokenizer.COLOR_END;
import static org.gosky.nga.widget.richtext.Tokenizer.COLOR_START;
import static org.gosky.nga.widget.richtext.Tokenizer.CURTAIN_END;
import static org.gosky.nga.widget.richtext.Tokenizer.CURTAIN_START;
import static org.gosky.nga.widget.richtext.Tokenizer.DELETE_END;
import static org.gosky.nga.widget.richtext.Tokenizer.DELETE_START;
import static org.gosky.nga.widget.richtext.Tokenizer.END;
import static org.gosky.nga.widget.richtext.Tokenizer.FORMULA;
import static org.gosky.nga.widget.richtext.Tokenizer.ICON;
import static org.gosky.nga.widget.richtext.Tokenizer.IMAGE;
import static org.gosky.nga.widget.richtext.Tokenizer.ITALIC_END;
import static org.gosky.nga.widget.richtext.Tokenizer.ITALIC_START;
import static org.gosky.nga.widget.richtext.Tokenizer.PLAIN;
import static org.gosky.nga.widget.richtext.Tokenizer.QUOTE_END;
import static org.gosky.nga.widget.richtext.Tokenizer.QUOTE_START;
import static org.gosky.nga.widget.richtext.Tokenizer.TABLE;
import static org.gosky.nga.widget.richtext.Tokenizer.TITLE_END;
import static org.gosky.nga.widget.richtext.Tokenizer.TITLE_START;
import static org.gosky.nga.widget.richtext.Tokenizer.TOKEN;
import static org.gosky.nga.widget.richtext.Tokenizer.UNDERLINE_END;
import static org.gosky.nga.widget.richtext.Tokenizer.UNDERLINE_START;
import static org.gosky.nga.widget.richtext.Tokenizer.URL_END;
import static org.gosky.nga.widget.richtext.Tokenizer.URL_START;
import static org.gosky.nga.widget.richtext.Tokenizer.tokenizer;

/**
 * Created by jianhao on 16-8-26.
 */
public class FlexibleRichTextView extends LinearLayout {
    private final static String TAG = "FlexibleRichTextView";
    static final int MAX_IMAGE_WIDTH = (int) (Resources.getSystem().getDisplayMetrics().widthPixels * 0.8);

    private Context mContext;
    @SuppressWarnings({"unused", "FieldCanBeLocal"})
    private int mConversationId;
    private List<Attachment> mAttachmentList;
    private OnViewClickListener mOnViewClickListener;

    private List<Tokenizer.TOKEN> mTokenList;
    private int mTokenIndex;

    private boolean mCenter;

    private boolean mShowRemainingAtt = true;

    private int mQuoteViewId = R.layout.default_quote_view;

    public FlexibleRichTextView(Context context) {
        this(context, null, true);

    }

    @SuppressWarnings("unused")
    public FlexibleRichTextView(Context context, OnViewClickListener onViewClickListener) {
        this(context, onViewClickListener, true);
    }

    @SuppressWarnings("unused")
    public FlexibleRichTextView(Context context, OnViewClickListener onViewClickListener, boolean showRemainingAtt) {
        super(context);
        init(context, onViewClickListener, showRemainingAtt);
    }

    public FlexibleRichTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public FlexibleRichTextView(Context context, AttributeSet attributeSet, int defStyleAttr) {
        super(context, attributeSet, defStyleAttr);
        init(context);
    }

    public void setToken(List<TOKEN> tokens, List<Attachment> attachmentList) {
        removeAllViews();

        mAttachmentList = attachmentList;
        mTokenList = tokens;

        for (TOKEN token : tokens) {
            if (token instanceof ATTACHMENT) {
                mAttachmentList.remove(((ATTACHMENT) token).attachment);
            }
        }

        resetTokenIndex();
        List<Object> result = until(END.class);

        if (mShowRemainingAtt) {
            // remaining attachments will show at the bottom of view
            for (Attachment att : mAttachmentList) {
                append(result, attachment(att));
            }
        }

        if (result == null) {
            return;
        }

        for (final Object o : result) {
            if (o instanceof TextWithFormula) {
                final TextWithFormula textWithFormula = (TextWithFormula) o;

                final LaTeXtView textView = new LaTeXtView(mContext);

                textView.setTextWithFormula(textWithFormula);

                textView.setMovementMethod(LinkMovementMethod.getInstance());
                myAddView(textView);
            } else if (o instanceof CodeView) {
                myAddView((CodeView) o);
            } else if (o instanceof ImageView) {
                myAddView((ImageView) o);
            } else if (o instanceof HorizontalScrollView) {
                myAddView((HorizontalScrollView) o);
            } else if (o instanceof QuoteView) {
                myAddView((QuoteView) o);
            } else if (o instanceof LinearLayout) {
                myAddView((LinearLayout) o);
            }
        }
    }

    public void setText(@NonNull String text) {
        setText(text, new ArrayList<Attachment>());
    }

    public void setText(String text, List<Attachment> attachmentList) {
        text = text.replaceAll("\u00AD", "");
        //</br> 替换为\n
        text = text.replace("<br/>", "\n");
//        text = BBCodeMaps.bbcodeListParse(text);
        mAttachmentList = attachmentList;
        mTokenList = tokenizer(text, mAttachmentList);

        setToken(mTokenList, attachmentList);
    }

    private void myAddView(View view) {
        if (view instanceof FImageView && ((FImageView) view).centered) {
            // TODO: 17-2-13 any more efficient way?
            RelativeLayout rl = new RelativeLayout(mContext);
            RelativeLayout.LayoutParams rlLp = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            rlLp.addRule(RelativeLayout.CENTER_IN_PARENT, RelativeLayout.TRUE);
            rl.addView(view);
            rl.setLayoutParams(new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            addView(rl);
        } else {
            addView(view);
        }
    }

    private void resetTokenIndex() {
        mTokenIndex = 0;
    }

    private final Class[] start = {CENTER_START.class, BOLD_START.class, ITALIC_START.class,
            UNDERLINE_START.class, DELETE_START.class, CURTAIN_START.class, TITLE_START.class,
            COLOR_START.class, URL_START.class, Tokenizer.SIZE_START.class, Tokenizer.LIST_START.class};

    private final Class[] end = {CENTER_END.class, BOLD_END.class, ITALIC_END.class,
            UNDERLINE_END.class, DELETE_END.class, CURTAIN_END.class, TITLE_END.class,
            COLOR_END.class, URL_END.class, Tokenizer.SIZE_END.class, Tokenizer.LIST_END.class};

    private final String CENTER_OP = "center";
    private final String BOLD_OP = "bold";
    private final String ITALIC_OP = "italic";
    private final String UNDERLINE_OP = "underline";
    private final String DELETE_OP = "delete";
    private final String CURTAIN_OP = "curtain";
    private final String TITLE_OP = "title";
    private final String COLOR_OP = "color";
    private final String URL_OP = "url";
    private final String SIZE_OP = "size";
    private final String LIST_OP = "list";

    private final String[] operation = {CENTER_OP, BOLD_OP, ITALIC_OP, UNDERLINE_OP, DELETE_OP, CURTAIN_OP, TITLE_OP, COLOR_OP, URL_OP, SIZE_OP, LIST_OP};

    private <T extends TOKEN> List<Object> until(Class<T> endClass) {
        List<Object> ret = new ArrayList<>();

        while (!(thisToken() instanceof END) && !(endClass.isInstance(thisToken()))) {
            boolean flag = false;
            int tmp;

            for (Class anEnd : end) {
                if (anEnd.isInstance(thisToken())) {
                    append(ret, new TextWithFormula(thisToken().value));
                    flag = true;
                    break;
                }
            }

            for (int i = 0; i < start.length; i++) {
                if (start[i].isInstance(thisToken())) {
                    String operand = "";
                    if (thisToken() instanceof CENTER_START) {
                        mCenter = true;
                    } else if (thisToken() instanceof COLOR_START) {
                        operand = ((COLOR_START) thisToken()).color;
                    } else if (thisToken() instanceof URL_START) {
                        operand = ((URL_START) thisToken()).url;
                    } else if (thisToken() instanceof Tokenizer.SIZE_START) {
                        operand = ((Tokenizer.SIZE_START) thisToken()).color;
                    }

                    tmp = getTokenIndex();
                    next();
                    List<Object> shown = until(end[i]);
                    mCenter = false;
                    if (shown != null) {
                        concat(ret, operate(shown, operation[i], operand));
                    } else {
                        setTokenIndex(tmp);
                        append(ret, new TextWithFormula(thisToken().value));
                    }

                    flag = true;
                }
            }

            if (!flag) {
                if (thisToken() instanceof PLAIN) {
                    append(ret, new TextWithFormula(thisToken().value));

                } else if (thisToken() instanceof ICON) {
                    final ICON thisToken = (ICON) thisToken();

                    TextWithFormula textWithFormula = new TextWithFormula(thisToken.value);
                    textWithFormula.setSpan(new ImageSpan(mContext, getBitmapFromAsset(getContext(), thisToken.iconPath)), 0,
                            thisToken.value.length(), Spanned.SPAN_INCLUSIVE_EXCLUSIVE);

                    append(ret, textWithFormula);

                } else if (thisToken() instanceof FORMULA) {

                    FORMULA thisToken = (FORMULA) thisToken();

                    TextWithFormula textWithFormula = new TextWithFormula(thisToken().value);

                    textWithFormula.addFormula(0, thisToken.value.length(),
                            thisToken.content, thisToken.contentStart,
                            thisToken.contentStart + thisToken.content.length());

                    append(ret, textWithFormula);

                } else if (thisToken() instanceof CODE_START) {
                    /**
                     * [code][code][/code][/code][/code] shows [code][/code][/code]
                     */
                    tmp = getTokenIndex();
                    int i = 1;
                    StringBuilder string = new StringBuilder("");
                    StringBuilder substring = new StringBuilder("");
                    next();
                    while (!(thisToken() instanceof END)) {
                        if (thisToken() instanceof CODE_START) {
                            i++;
                        }
                        if (thisToken() instanceof CODE_END) {
                            i--;
                            if (i == 0) {
                                string.append(substring);
                                break;
                            }
                            string.append(substring);
                            substring.delete(0, substring.length());
                            tmp = getTokenIndex() + 1;
                        }
                        substring.append(thisToken().value);
                        next();
                    }

                    if (i == 0) {
                        final CodeView codeView = (CodeView) LayoutInflater.from(mContext).inflate(R.layout.code_view, this, false);
                        codeView.setCode(string.toString());
                        ret.add(codeView);
                    } else if (!TextUtils.isEmpty(string)) {
                        setTokenIndex(tmp);
                        final CodeView codeView = (CodeView) LayoutInflater.from(mContext).inflate(R.layout.code_view, this, false);
                        codeView.setCode(string.toString());
                        ret.add(codeView);
                    } else {
                        setTokenIndex(tmp);
                        append(ret, new TextWithFormula(thisToken().value));
                    }

                } else if (thisToken() instanceof IMAGE) {

                    IMAGE thisToken = (IMAGE) thisToken();
                    FImageView imageView = loadImage(thisToken.url, thisToken.width, thisToken.height);
                    if (mCenter) {
                        imageView.centered = true;
                    }
                    append(ret, imageView);

                } else if (thisToken() instanceof TABLE) {

                    View table = table(thisToken().value);
                    append(ret, table);

                }
//                else if (thisToken() instanceof Tokenizer.LIST) {
//
//                    View list = list(thisToken().value);
//                    append(ret, list);
//
//                }
                else if (thisToken() instanceof ATTACHMENT) {

                    final ATTACHMENT thisToken = (ATTACHMENT) thisToken();

                    append(ret, attachment(thisToken.attachment));

                } else if (thisToken() instanceof QUOTE_START) {
                    int i = 1;
                    List<TOKEN> tokens = new ArrayList<>();
                    next();
                    while (!(thisToken() instanceof END)) {
                        if (thisToken() instanceof QUOTE_START) {
                            i++;
                            while (i > 0) {
                                next();
                                if (thisToken() instanceof QUOTE_START) {
                                    i++;
                                } else if (thisToken() instanceof QUOTE_END) {
                                    i--;
                                }
                            }
                        } else if (thisToken() instanceof QUOTE_END) {
                            tokens.add(new END(thisToken().position));
                            break;
                        } else {
                            tokens.add(thisToken());
                        }
                        next();
                    }

                    if (thisToken() instanceof QUOTE_END) {
                        final QuoteView quoteView = QuoteView.newInstance(this, mQuoteViewId);
                        quoteView.setAttachmentList(mAttachmentList);
                        quoteView.setPadding(0, 8, 0, 8);
                        quoteView.setTokens(tokens);
                        quoteView.setOnButtonClickListener(mOnViewClickListener);
                        ret.add(quoteView);
                    } else {
                        append(ret, new TextWithFormula(thisToken().value));
                    }
                }
            }
            next();
        }

        if (endClass.isInstance(thisToken())) {
            return ret;
        }

        return null;
    }

    private Object attachment(final Attachment attachment) {
        if (attachment.isImage()) {
            String url = attachment.getUrl();
            FImageView imageView = loadImage(url);
            if (mCenter) {
                imageView.centered = true;
            }

            return imageView;
        } else {
            TextWithFormula builder = new TextWithFormula(attachment.getText());
            builder.setSpan(new ClickableSpan() {
                @Override
                public void onClick(View view) {
                    if (mOnViewClickListener != null) {
                        mOnViewClickListener.onAttClick(attachment);
                    }
                }
            }, 0, attachment.getText().length(), Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
            builder.append("\n\n");

            return builder;
        }
    }

    private void append(List<Object> list, Object element) {
        concat(list, Collections.singletonList(element));
    }

    private FImageView loadImage(String url) {
        return loadImage(url, -1);
    }

    private FImageView loadImage(String url, int size) {
        return loadImage(url, size, size);
    }

    private FImageView loadImage(String url, int width, int height) {
        final FImageView imageView = new FImageView(mContext);

        ViewGroup.LayoutParams layoutParams;

        layoutParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        ((RelativeLayout.LayoutParams) layoutParams).addRule(RelativeLayout.CENTER_HORIZONTAL, RelativeLayout.TRUE);
        imageView.setLayoutParams(layoutParams);
        imageView.setAdjustViewBounds(true);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView.setPadding(0, 0, 0, 10);

        Glide.with(mContext)
                .load(url)
                .placeholder(new ColorDrawable(ContextCompat.getColor(mContext, android.R.color.darker_gray)))
                .into(imageView);
        return imageView;
    }

    private List<Object> operate(List<Object> list, String operation, final String... operand) {
        switch (operation) {
            case BOLD_OP:
                for (Object o : list) {
                    if (o instanceof TextWithFormula) {
                        final TextWithFormula textWithFormula = (TextWithFormula) o;
                        textWithFormula.setSpan(new StyleSpan(Typeface.BOLD), 0, textWithFormula.length(), Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
                    }
                }
                break;
            case CENTER_OP:
                for (Object o : list) {
                    if (o instanceof TextWithFormula) {
                        final TextWithFormula textWithFormula = (TextWithFormula) o;
                        textWithFormula.setSpan(new AlignmentSpan.Standard(Layout.Alignment.ALIGN_CENTER), 0, textWithFormula.length(), Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
                    } else if (o instanceof ImageView) {
                        ((ImageView) o).setScaleType(ImageView.ScaleType.CENTER);
                    }
                }
                break;
            case ITALIC_OP:
                for (Object o : list) {
                    if (o instanceof TextWithFormula) {
                        final TextWithFormula textWithFormula = (TextWithFormula) o;
                        textWithFormula.setSpan(new StyleSpan(Typeface.ITALIC), 0, textWithFormula.length(), Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
                    }
                }
                break;
            case UNDERLINE_OP:
                for (Object o : list) {
                    if (o instanceof TextWithFormula) {
                        final TextWithFormula textWithFormula = (TextWithFormula) o;
                        textWithFormula.setSpan(new UnderlineSpan(), 0, textWithFormula.length(), Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
                    }
                }
                break;
            case DELETE_OP:
                for (Object o : list) {
                    if (o instanceof TextWithFormula) {
                        final TextWithFormula textWithFormula = (TextWithFormula) o;
                        textWithFormula.setSpan(new StrikethroughSpan(), 0, textWithFormula.length(), Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
                    }
                }
                break;
            case CURTAIN_OP:
                for (Object o : list) {
                    if (o instanceof TextWithFormula) {
                        final TextWithFormula textWithFormula = (TextWithFormula) o;
                        textWithFormula.setSpan(new BackgroundColorSpan(Color.DKGRAY), 0, textWithFormula.length(), Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
                    }
                }
                break;
            case TITLE_OP:
                for (Object o : list) {
                    if (o instanceof TextWithFormula) {
                        final TextWithFormula textWithFormula = (TextWithFormula) o;
                        textWithFormula.append("\n");
                        textWithFormula.setSpan(new RelativeSizeSpan(1.3f), 0, textWithFormula.length(), Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
                    }
                }
                break;
            case COLOR_OP:
                for (Object o : list) {
                    if (o instanceof TextWithFormula) {
                        final TextWithFormula textWithFormula = (TextWithFormula) o;
                        try {
                            int color = Color.parseColor(operand[0]);
                            textWithFormula.setSpan(new ForegroundColorSpan(color), 0, textWithFormula.length(), Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
                        } catch (IllegalArgumentException e) {
                            // avoid crash caused by illegal color
                        }
                    }
                }
                break;
            case SIZE_OP:
                for (Object o : list) {
                    if (o instanceof TextWithFormula) {
                        final TextWithFormula textWithFormula = (TextWithFormula) o;
                        String ss = operand[0].replaceAll("%", "");
                        Float f = Float.valueOf(ss) / 100;
                        textWithFormula.setSpan(new RelativeSizeSpan(f), 0, textWithFormula.length(), Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
                    }
                }
                break;
            case LIST_OP:
                for (Object o : list) {
                    if (o instanceof TextWithFormula) {
                        final TextWithFormula textWithFormula = (TextWithFormula) o;

//                        List<String> items = getListCellsContent(textWithFormula.toString());
//                        for (String item : items) {
//                            TextView textView = new TextView(this.getContext());
//                            Spannable msp = new SpannableString(item);
//                            msp.setSpan(new BulletSpan(20), 0, 0, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
//                            textView.setText(msp);
//                            layout.addView(textView);
//                        }
                        int i = 0;
                        while (i < textWithFormula.toString().length() && i >= 0) {
                            i = textWithFormula.toString().indexOf("[*]", i + 1);
                            if (i >= 0) {
                                textWithFormula.replace(i, i + 3, " ");
                                textWithFormula.setSpan(new BulletSpan(20), i, i + 1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                            }
                        }
                    }
                }
                break;
            case URL_OP:
                for (Object o : list) {
                    if (o instanceof TextWithFormula) {
                        final TextWithFormula textWithFormula = (TextWithFormula) o;
                        textWithFormula.setSpan(new ClickableSpan() {
                            @Override
                            public void onClick(View widget) {
                                if (!TextUtils.isEmpty(operand[0]))
                                    mContext.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(operand[0])));
                                else
                                    mContext.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(textWithFormula.toString())));
                            }
                        }, 0, textWithFormula.length(), Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
                    }
                }
        }
        return list;
    }

    private <T> void concat(List<Object> list1, List<T> list2) {
        if (list1.size() == 0) {
            list1.addAll(list2);
        } else {
            if (list2.size() > 0) {
                if (list1.get(list1.size() - 1) instanceof TextWithFormula &&
                        list2.get(0) instanceof TextWithFormula) {

                    TextWithFormula a = (TextWithFormula) list1.get(list1.size() - 1);
                    TextWithFormula b = (TextWithFormula) list2.get(0);
                    for (TextWithFormula.Formula formula : b.getFormulas()) {
                        formula.start += a.length();
                        formula.end += a.length();
                        formula.contentStart += a.length();
                        formula.contentEnd += a.length();
                    }
                    a.getFormulas().addAll(b.getFormulas());
                    a.append(b);

                    list1.addAll(list2.subList(1, list2.size()));
                } else {
                    list1.addAll(list2);
                }
            }
        }
    }

    private TOKEN thisToken() {
        return mTokenList.get(mTokenIndex);
    }

    private void next() {
        if (!(thisToken() instanceof END))
            mTokenIndex++;
    }

    public int getTokenIndex() {
        return mTokenIndex;
    }

    public void setTokenIndex(int tokenIndex) {
        this.mTokenIndex = tokenIndex;
    }

    private List<String> getCellsContent(String text) {
        Pattern pattern = Pattern.compile("\\[td\\](.+?)\\[/td\\]");
        Matcher matcher = pattern.matcher(text);

        List<String> cells = new ArrayList<>();
        while (matcher.find()) {
            if (!TextUtils.isEmpty(matcher.group(1))) {
                String cell = matcher.group(1);
                cells.add(cell);
            }
        }
        return cells;
    }

    private View table(CharSequence str) {
        str = str.toString().replace("\n","");
        Pattern pattern = Pattern.compile("\\[th\\](.+?)\\[/th\\]");
        Matcher matcher = pattern.matcher(str);

        List<String> headers = null;
        if (matcher.find()) {
            if (!TextUtils.isEmpty(matcher.group(1))) {
                String wholeHeader = matcher.group(1);

                headers = getCellsContent(wholeHeader);
            }
        }

        pattern = Pattern.compile("\\[tr\\](.+?)\\[/tr\\]");
        matcher = pattern.matcher(str);

        final List<List<String>> content = new ArrayList<>();
        while (matcher.find()) {
            if (!TextUtils.isEmpty(matcher.group(1))) {
                String whole = matcher.group(1);
                content.add(getCellsContent(whole));
            }
        }

        final List<String[]> whole = new ArrayList<>();
        if (headers != null) {
            whole.add(headers.toArray(new String[headers.size()]));
        }
        for (List<String> strings : content) {
            whole.add(strings.toArray(new String[strings.size()]));
        }

        // render table
        HorizontalScrollView scrollView = new HorizontalScrollView(getContext());
        TableLayout tableLayout = new TableLayout(mContext);

        tableLayout.addView(getHorizontalDivider());
        for (int i = 0; i < whole.size(); i++) {
            String[] row = whole.get(i);
            TableRow tableRow = new TableRow(mContext);
            final TableLayout.LayoutParams params = new TableLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            tableRow.setLayoutParams(params);

            tableRow.addView(getVerticalDivider());
            for (int j = 0; j < row.length; j++) {
                String cell = row[j];
                FlexibleRichTextView flexibleRichTextView = FlexibleRichTextView.newInstance(getContext(), cell, mAttachmentList, mOnViewClickListener, false);
                TableRow.LayoutParams pcvParams = new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT);
                pcvParams.gravity = Gravity.CENTER;
                /*switch (margins[j]) {
                    case CENTER:
                        pcvParams.gravity = Gravity.CENTER;
                        break;
                    case LEFT:
                        pcvParams.gravity = Gravity.START;
                        break;
                    case RIGHT:
                        pcvParams.gravity = Gravity.END;
                        break;
                }*/
                flexibleRichTextView.setPadding(10, 10, 10, 10);
                flexibleRichTextView.setLayoutParams(pcvParams);
                tableRow.addView(flexibleRichTextView);
                tableRow.addView(getVerticalDivider());
            }
            tableLayout.addView(tableRow);
            tableLayout.addView(getHorizontalDivider());
        }

        scrollView.addView(tableLayout);

        return scrollView;
    }

    private List<String> getListCellsContent(String text) {
        Pattern pattern = Pattern.compile("\\[li\\](.+?)\\[/li\\]");
        Matcher matcher = pattern.matcher(text);

        List<String> cells = new ArrayList<>();
        while (matcher.find()) {
            if (!TextUtils.isEmpty(matcher.group(1))) {
                String cell = matcher.group(1);
                cells.add(cell);
            }
        }
        return cells;
    }

    private View list(CharSequence str) {
        LinearLayout layout = new LinearLayout(this.getContext());
        layout.setOrientation(VERTICAL);
        List<String> items = getListCellsContent(str.toString());
        for (String item : items) {
            TextView textView = new TextView(this.getContext());
            Spannable msp = new SpannableString(item);
            msp.setSpan(new BulletSpan(20), 0, 0, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            textView.setText(msp);
            layout.addView(textView);
        }
        return layout;
    }

    private List<String> format(List<String> strings) {
        for (int i = strings.size() - 1; i >= 0; i--) {
            String str = strings.get(i);
            if (TextUtils.isEmpty(str) || str.equals("\n")) {
                strings.remove(i);
            }
        }

        for (int i = 0; i < strings.size(); i++) {
            strings.set(i, strings.get(i).trim());
        }

        return strings;
    }

    public static FlexibleRichTextView newInstance(Context context, String string,
                                                   List<Attachment> attachmentList,
                                                   OnViewClickListener onViewClickListener,
                                                   boolean showRemainingAtt) {

        FlexibleRichTextView flexibleRichTextView = new FlexibleRichTextView(context, onViewClickListener, showRemainingAtt);

        if (!TextUtils.isEmpty(string)) {
            flexibleRichTextView.setText(string, attachmentList);
        }

        return flexibleRichTextView;
    }

    private View getHorizontalDivider() {
        View horizontalDivider = new View(mContext);
        horizontalDivider.setLayoutParams(new TableLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 1));
        horizontalDivider.setBackgroundColor(ContextCompat.getColor(mContext, android.R.color.black));

        return horizontalDivider;
    }

    private View getVerticalDivider() {
        View verticalDivider = new View(mContext);
        verticalDivider.setLayoutParams(new TableRow.LayoutParams(1, ViewGroup.LayoutParams.MATCH_PARENT));
        verticalDivider.setBackgroundColor(ContextCompat.getColor(mContext, android.R.color.black));

        return verticalDivider;
    }

    private void init(Context context) {
        init(context, null);
    }

    private void init(Context context, OnViewClickListener onViewClickListener) {
        init(context, onViewClickListener, true);
    }

    private void init(Context context, OnViewClickListener onViewClickListener, boolean showRemainingAtt) {
        setOrientation(VERTICAL);
        mOnViewClickListener = onViewClickListener;
        mContext = context;
        mShowRemainingAtt = showRemainingAtt;
        removeAllViews();
    }

    public void setOnClickListener(OnViewClickListener onViewClickListener) {
        mOnViewClickListener = onViewClickListener;
    }

    public int getConversationId() {
        return mConversationId;
    }

    public void setConversationId(int mConversationId) {
        this.mConversationId = mConversationId;
    }

    public void setQuoteViewId(int quoteViewId) {
        this.mQuoteViewId = quoteViewId;
    }

    public interface OnViewClickListener {
        void onImgClick(ImageView imageView);

        void onAttClick(Attachment attachment);

        void onQuoteButtonClick(View view, boolean collapsed);
    }

    private Bitmap getBitmapFromAsset(Context context, String strName) {
        AssetManager assetManager = context.getAssets();
        InputStream istr = null;
        try {
            istr = assetManager.open(strName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Bitmap bitmap = BitmapFactory.decodeStream(istr);
        try {
            if (istr != null) {
                istr.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bitmap;
    }
}
