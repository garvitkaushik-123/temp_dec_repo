package com.bytedance.sdk.openadsdk.aGH.eli;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/* loaded from: classes3.dex */
public class wC implements com.bytedance.sdk.component.MGA.eli.eli.ui {
    public static final wC eli = new wC();
    private volatile SQLiteDatabase DbA;

    @Override // com.bytedance.sdk.component.MGA.eli.eli.ui
    public String MGA() {
        return null;
    }

    @Override // com.bytedance.sdk.component.MGA.eli.eli.ui
    public String Os() {
        return null;
    }

    @Override // com.bytedance.sdk.component.MGA.eli.eli.ui
    public SQLiteDatabase eli(Context context) {
        if (this.DbA == null) {
            synchronized (this) {
                if (this.DbA == null) {
                    this.DbA = com.bytedance.sdk.openadsdk.core.ui.eli(context).eli().eli();
                }
            }
        }
        return this.DbA;
    }

    @Override // com.bytedance.sdk.component.MGA.eli.eli.ui
    public String eli() {
        return "loghighpriority";
    }

    @Override // com.bytedance.sdk.component.MGA.eli.eli.ui
    public String DbA() {
        return "adevent";
    }

    @Override // com.bytedance.sdk.component.MGA.eli.eli.ui
    public String aGH() {
        return "logstats";
    }

    @Override // com.bytedance.sdk.component.MGA.eli.eli.ui
    public String ui() {
        return "logstatsbatch";
    }
}
