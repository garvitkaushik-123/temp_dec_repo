package com.bytedance.sdk.component.MGA.eli.eli.eli;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/* loaded from: classes3.dex */
public class ui implements com.bytedance.sdk.component.MGA.eli.eli.ui {
    public static final ui eli = new ui();
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
                    this.DbA = new aGH(context).getWritableDatabase();
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
