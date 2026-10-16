package com.bytedance.sdk.openadsdk.Os;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.utils.SSo;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class MGA extends ScrollView {
    private final com.bytedance.sdk.openadsdk.core.ui.ui DbA;
    private final aAs eli;

    public MGA(Context context, aAs aas) {
        super(context);
        this.eli = aas;
        com.bytedance.sdk.openadsdk.core.ui.ui uiVar = new com.bytedance.sdk.openadsdk.core.ui.ui(context);
        this.DbA = uiVar;
        uiVar.setOrientation(1);
        addView(uiVar, new FrameLayout.LayoutParams(-1, -2));
        if (aas.wC() == 0) {
            eli();
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0);
        layoutParams.weight = 1.0f;
        setLayoutParams(layoutParams);
        setVerticalScrollBarEnabled(false);
    }

    private void eli() {
        if (this.eli.wC() != 0) {
            return;
        }
        this.eli.eli(SSo.Os(getContext()), SSo.ui(getContext()));
    }

    public void eli(List<FilterWord> list) {
        List<FilterWord> Os = Os(list);
        if (Os == null) {
            return;
        }
        DbA(Os);
    }

    private void DbA(List<FilterWord> list) {
        this.DbA.removeAllViews();
        for (int i = 0; i < list.size(); i++) {
            FilterWord filterWord = list.get(i);
            if (filterWord != null) {
                this.DbA.addView(new kb(getContext(), filterWord, this.eli));
            }
            if (i < list.size() - 1) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                int DbA = SSo.DbA(getContext(), this.eli.FC() ? 16.0f : 8.0f);
                layoutParams.topMargin = DbA;
                layoutParams.bottomMargin = DbA;
                this.DbA.addView(new du(getContext()), layoutParams);
            }
        }
    }

    private static List<FilterWord> Os(List<FilterWord> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        int i = 0;
        int i2 = -1;
        for (int i3 = 0; i3 < list.size(); i3++) {
            if (list.get(i3).hasSecondOptions()) {
                i2 = i3;
            }
        }
        if (i2 != -1 && i2 <= list.size()) {
            i = i2;
        }
        FilterWord filterWord = list.get(i);
        Iterator<FilterWord> it = list.iterator();
        while (it.hasNext()) {
            FilterWord next = it.next();
            if (!next.hasSecondOptions()) {
                filterWord.addOption(next);
                it.remove();
            }
        }
        return list;
    }
}
