package org.gosky.nga.widget.richtext;

import android.content.Context;

/**
 * Created by daquexian on 17-2-16.
 */

public class LaTeXtView extends android.support.v7.widget.AppCompatTextView {
    public LaTeXtView(Context context) {
        super(context);
    }

    public void setTextWithFormula(TextWithFormula textWithFormula) {
        setText(textWithFormula);
    }

}
