package com.bytedance.sdk.component.MGA.eli.eli.eli.eli;

import android.content.Context;
import com.bytedance.sdk.component.MGA.eli.wC;

/* loaded from: classes3.dex */
public class aGH extends eli {
    @Override // com.bytedance.sdk.component.MGA.eli.eli.eli.eli.eli
    public byte Os() {
        return (byte) 1;
    }

    @Override // com.bytedance.sdk.component.MGA.eli.eli.eli.eli.eli
    public byte aGH() {
        return (byte) 0;
    }

    public aGH(Context context, com.bytedance.sdk.component.MGA.eli.aGH.DbA.eli eliVar) {
        super(context, eliVar);
    }

    @Override // com.bytedance.sdk.component.MGA.eli.eli.eli.eli.eli, com.bytedance.sdk.component.MGA.eli.eli.eli.eli.Os
    public String DbA() {
        com.bytedance.sdk.component.MGA.eli.eli.ui aGH = wC.kb().aGH();
        if (aGH != null) {
            return aGH.eli();
        }
        return null;
    }

    @Override // com.bytedance.sdk.component.MGA.eli.eli.eli.eli.Os
    protected long MGA() {
        return com.bytedance.sdk.component.MGA.eli.kb.eli.DbA();
    }

    public static String Os(String str) {
        return "CREATE TABLE IF NOT EXISTS " + str + " (_id INTEGER PRIMARY KEY AUTOINCREMENT,id TEXT UNIQUE,value TEXT ,gen_time TEXT , retry INTEGER default 0 , encrypt INTEGER default 0)";
    }
}
