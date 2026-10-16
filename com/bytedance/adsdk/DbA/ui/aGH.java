package com.bytedance.adsdk.DbA.ui;

import android.util.JsonReader;
import java.io.IOException;
import java.util.List;

/* loaded from: classes3.dex */
public class aGH {
    public static com.bytedance.adsdk.DbA.Os.eli.DbA eli(JsonReader jsonReader, com.bytedance.adsdk.DbA.kb kbVar) throws IOException {
        return eli(jsonReader, kbVar, true);
    }

    public static com.bytedance.adsdk.DbA.Os.eli.DbA eli(JsonReader jsonReader, com.bytedance.adsdk.DbA.kb kbVar, boolean z) throws IOException {
        return new com.bytedance.adsdk.DbA.Os.eli.DbA(eli(jsonReader, z ? com.bytedance.adsdk.DbA.MGA.MGA.eli() : 1.0f, kbVar, nlS.eli));
    }

    static com.bytedance.adsdk.DbA.Os.eli.aGH DbA(JsonReader jsonReader, com.bytedance.adsdk.DbA.kb kbVar) throws IOException {
        return new com.bytedance.adsdk.DbA.Os.eli.aGH(eli(jsonReader, kbVar, nGm.eli));
    }

    static com.bytedance.adsdk.DbA.Os.eli.MGA Os(JsonReader jsonReader, com.bytedance.adsdk.DbA.kb kbVar) throws IOException {
        return new com.bytedance.adsdk.DbA.Os.eli.MGA(bf.eli(jsonReader, kbVar, com.bytedance.adsdk.DbA.MGA.MGA.eli(), KM.eli, true));
    }

    static com.bytedance.adsdk.DbA.Os.eli.kb aGH(JsonReader jsonReader, com.bytedance.adsdk.DbA.kb kbVar) throws IOException {
        return new com.bytedance.adsdk.DbA.Os.eli.kb(eli(jsonReader, kbVar, nro.eli));
    }

    static com.bytedance.adsdk.DbA.Os.eli.wC ui(JsonReader jsonReader, com.bytedance.adsdk.DbA.kb kbVar) throws IOException {
        return new com.bytedance.adsdk.DbA.Os.eli.wC(eli(jsonReader, com.bytedance.adsdk.DbA.MGA.MGA.eli(), kbVar, Cp.eli));
    }

    static com.bytedance.adsdk.DbA.Os.eli.aAs MGA(JsonReader jsonReader, com.bytedance.adsdk.DbA.kb kbVar) throws IOException {
        return new com.bytedance.adsdk.DbA.Os.eli.aAs(eli(jsonReader, com.bytedance.adsdk.DbA.MGA.MGA.eli(), kbVar, FC.eli));
    }

    static com.bytedance.adsdk.DbA.Os.eli.eli kb(JsonReader jsonReader, com.bytedance.adsdk.DbA.kb kbVar) throws IOException {
        return new com.bytedance.adsdk.DbA.Os.eli.eli(eli(jsonReader, kbVar, kb.eli));
    }

    static com.bytedance.adsdk.DbA.Os.eli.Os eli(JsonReader jsonReader, com.bytedance.adsdk.DbA.kb kbVar, int i) throws IOException {
        return new com.bytedance.adsdk.DbA.Os.eli.Os(eli(jsonReader, kbVar, new Dfc(i)));
    }

    private static <T> List<com.bytedance.adsdk.DbA.kb.eli<T>> eli(JsonReader jsonReader, com.bytedance.adsdk.DbA.kb kbVar, FS<T> fs) throws IOException {
        return bf.eli(jsonReader, kbVar, 1.0f, fs, false);
    }

    private static <T> List<com.bytedance.adsdk.DbA.kb.eli<T>> eli(JsonReader jsonReader, float f, com.bytedance.adsdk.DbA.kb kbVar, FS<T> fs) throws IOException {
        return bf.eli(jsonReader, kbVar, f, fs, false);
    }
}
