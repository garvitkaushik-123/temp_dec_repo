package com.bytedance.sdk.component.MGA.eli.eli.eli.eli;

import android.content.Context;
import com.bytedance.sdk.component.MGA.eli.wC;

/* loaded from: classes3.dex */
public class MGA extends kb {
    @Override // com.bytedance.sdk.component.MGA.eli.eli.eli.eli.kb
    public byte Os() {
        return (byte) 3;
    }

    @Override // com.bytedance.sdk.component.MGA.eli.eli.eli.eli.kb
    public byte eli() {
        return (byte) 1;
    }

    public MGA(Context context, com.bytedance.sdk.component.MGA.eli.aGH.DbA.eli eliVar) {
        super(context, eliVar);
    }

    @Override // com.bytedance.sdk.component.MGA.eli.eli.eli.eli.kb, com.bytedance.sdk.component.MGA.eli.eli.eli.eli.Os
    public String DbA() {
        return wC.kb().aGH().ui();
    }

    public static String eli(String str) {
        return "CREATE TABLE IF NOT EXISTS " + str + " (_id INTEGER PRIMARY KEY AUTOINCREMENT,id TEXT UNIQUE,value TEXT ,gen_time TEXT , retry INTEGER default 0 , encrypt INTEGER default 0)";
    }
}
