package org.gosky.nga.widget.richtext;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.gosky.nga.R;

import java.util.List;

/**
 * 用于显示帖子中的引用
 * Created by jianhao on 16-8-26.
 */
public class QuoteView extends LinearLayout {
    TextView mTextView;
    FlexibleRichTextView mFlexibleRichTextView;
    View mButton;
    Boolean mCollapsed;
    Context mContext;
    FlexibleRichTextView.OnViewClickListener mOnButtonClickListener;
    int mLayoutId;
    int mButtonId;

    int mRichTextViewHeight = -1;
    int mTextViewHeight = -1;
    final int HEIGHT_THRESHOLD = 10;

    List<Token.TOKEN> mTokens;

    private static final String TAG = "QuoteView";

    public QuoteView(Context context) {
        super(context);
        init(context);
    }

    public QuoteView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QuoteView(Context context, AttributeSet attributeSet, int defStyleAttr) {
        super(context, attributeSet, defStyleAttr);
        TypedArray array = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.QuoteView, 0, 0);
        try {
            mButtonId = array.getResourceId(R.styleable.QuoteView_buttonId, -1);
        } finally {
            array.recycle();
        }
        init(context);
    }

    static QuoteView newInstance(ViewGroup parent, int layoutId) {
        final QuoteView quoteView = (QuoteView) LayoutInflater.from(parent.getContext()).inflate(layoutId, parent, false);
        quoteView.mLayoutId = layoutId;
        return quoteView;
    }

    private void collapse() {
        mTextView.setVisibility(VISIBLE);
        mTextView.setText(mTextView.getText()); // without it, textview will show the last three lines
        mTextView.setEllipsize(TextUtils.TruncateAt.END);
        mFlexibleRichTextView.setVisibility(GONE);
        mCollapsed = true;
    }

    private void expand() {
        mTextView.setVisibility(GONE);
        mFlexibleRichTextView.setVisibility(VISIBLE);
        mCollapsed = false;
    }

    private void init(final Context context) {
        post(new Runnable() {
            @Override
            public void run() {
                mContext = context;
                mCollapsed = false;
                mTextView = new TextView(context);
                mFlexibleRichTextView = FlexibleRichTextView.newInstance(context, "", mOnButtonClickListener, false);

                LayoutParams params = new LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.WRAP_CONTENT);
                mTextView.setLayoutParams(params);
                mTextView.setTextIsSelectable(true);
                mTextView.setVisibility(INVISIBLE);

                FrameLayout container = (FrameLayout) getChildAt(0);

                container.addView(mTextView);
                container.addView(mFlexibleRichTextView);

                mButton = findViewById(mButtonId);
                if (mButton != null) {
                    mButton.setOnClickListener(new OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            if (mCollapsed) {
                                expand();
                            } else {
                                collapse();
                            }
                            ((Button) mButton).setText(getResources().getString(mCollapsed ? R.string.expand : R.string.collapse));
                        }
                    });
                }
            }
        });
    }

    public void setTokens(final List<Token.TOKEN> tokens) {
        post(new Runnable() {
            @Override
            public void run() {
                mTokens = tokens;
                mFlexibleRichTextView.setToken(tokens);
                mFlexibleRichTextView.post(new Runnable() {
                    @Override
                    public void run() {
                        mRichTextViewHeight = mFlexibleRichTextView.getHeight();
                        if (mTextViewHeight != -1 && mRichTextViewHeight - mTextViewHeight < HEIGHT_THRESHOLD) {
                            mButton.setVisibility(GONE);
                        }
                    }
                });
                mTextView.setText(Token.TOKEN.getString(tokens));
                mTextView.setMaxLines(3);
                mTextView.setEllipsize(TextUtils.TruncateAt.END);
                mTextView.post(new Runnable() {
                    @Override
                    public void run() {
                        mTextViewHeight = mTextView.getHeight();
                        if (mRichTextViewHeight != -1 && mRichTextViewHeight - mTextViewHeight < HEIGHT_THRESHOLD) {
                            mButton.setVisibility(GONE);
                        }
                    }
                });
            }
        });
    }


    public void setOnButtonClickListener(FlexibleRichTextView.OnViewClickListener onButtonClickListener) {
        mOnButtonClickListener = onButtonClickListener;
    }

}
