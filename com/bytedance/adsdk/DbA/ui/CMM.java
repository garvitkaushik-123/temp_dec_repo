package com.bytedance.adsdk.DbA.ui;

import android.graphics.Color;
import android.graphics.Rect;
import android.util.JsonReader;
import com.bytedance.adsdk.DbA.Os.Os.ui;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/* loaded from: classes3.dex */
public class CMM {
    public static com.bytedance.adsdk.DbA.Os.Os.ui eli(com.bytedance.adsdk.DbA.kb kbVar) {
        Rect aGH = kbVar.aGH();
        return new com.bytedance.adsdk.DbA.Os.Os.ui(Collections.emptyList(), kbVar, "__container", -1L, ui.eli.PRE_COMP, -1L, null, Collections.emptyList(), new com.bytedance.adsdk.DbA.Os.eli.nlS(), 0, 0, 0, 0.0f, 0.0f, aGH.width(), aGH.height(), null, null, Collections.emptyList(), ui.DbA.NONE, null, false, null, null);
    }

    public static com.bytedance.adsdk.DbA.Os.Os.ui eli(JsonReader jsonReader, com.bytedance.adsdk.DbA.kb kbVar) throws IOException {
        Float f;
        ui.DbA dbA = ui.DbA.NONE;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        jsonReader.beginObject();
        Float valueOf = Float.valueOf(0.0f);
        Float valueOf2 = Float.valueOf(1.0f);
        com.bytedance.adsdk.DbA.Os.eli.aAs aas = null;
        com.bytedance.adsdk.DbA.Os.eli.du duVar = null;
        com.bytedance.adsdk.DbA.Os.eli.DbA dbA2 = null;
        com.bytedance.adsdk.DbA.Os.DbA.eli eliVar = null;
        aAs aas2 = null;
        long j = 0;
        float f2 = 0.0f;
        float f3 = 0.0f;
        float f4 = 0.0f;
        float f5 = 0.0f;
        float f6 = 0.0f;
        ui.DbA dbA3 = dbA;
        long j2 = -1;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        boolean z = false;
        String str = "UNSET";
        String str2 = null;
        String str3 = null;
        ui.eli eliVar2 = null;
        float f7 = 1.0f;
        com.bytedance.adsdk.DbA.Os.eli.nlS nls = null;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            switch (nextName) {
                case "parent":
                    j2 = jsonReader.nextInt();
                    break;
                case "shapes":
                    jsonReader.beginArray();
                    while (jsonReader.hasNext()) {
                        com.bytedance.adsdk.DbA.Os.DbA.Os eli = wC.eli(jsonReader, kbVar);
                        if (eli != null) {
                            arrayList2.add(eli);
                        }
                    }
                    jsonReader.endArray();
                    break;
                case "h":
                    f5 = (float) (jsonReader.nextDouble() * com.bytedance.adsdk.DbA.MGA.MGA.eli());
                    break;
                case "t":
                    jsonReader.beginObject();
                    while (jsonReader.hasNext()) {
                        String nextName2 = jsonReader.nextName();
                        nextName2.hashCode();
                        if (nextName2.equals("a")) {
                            jsonReader.beginArray();
                            if (jsonReader.hasNext()) {
                                duVar = DbA.eli(jsonReader, kbVar);
                            }
                            while (jsonReader.hasNext()) {
                                jsonReader.skipValue();
                            }
                            jsonReader.endArray();
                        } else if (nextName2.equals("d")) {
                            aas = aGH.MGA(jsonReader, kbVar);
                        } else {
                            jsonReader.skipValue();
                        }
                    }
                    jsonReader.endObject();
                    break;
                case "w":
                    f4 = (float) (jsonReader.nextDouble() * com.bytedance.adsdk.DbA.MGA.MGA.eli());
                    break;
                case "cl":
                    str3 = jsonReader.nextString();
                    break;
                case "ef":
                    jsonReader.beginArray();
                    ArrayList arrayList3 = new ArrayList();
                    while (jsonReader.hasNext()) {
                        jsonReader.beginObject();
                        while (jsonReader.hasNext()) {
                            String nextName3 = jsonReader.nextName();
                            nextName3.hashCode();
                            if (nextName3.equals("nm")) {
                                arrayList3.add(jsonReader.nextString());
                            } else if (nextName3.equals("ty")) {
                                int nextInt = jsonReader.nextInt();
                                if (nextInt == 29) {
                                    eliVar = ui.eli(jsonReader, kbVar);
                                } else if (nextInt == 25) {
                                    aas2 = new du().eli(jsonReader, kbVar);
                                }
                            } else {
                                jsonReader.skipValue();
                            }
                        }
                        jsonReader.endObject();
                    }
                    jsonReader.endArray();
                    kbVar.eli("Lottie doesn't support layer effects. If you are using them for  fills, strokes, trim paths etc. then try adding them directly as contents  in your shape. Found: ".concat(String.valueOf(arrayList3)));
                    break;
                case "hd":
                    z = jsonReader.nextBoolean();
                    break;
                case "ip":
                    f2 = (float) jsonReader.nextDouble();
                    break;
                case "ks":
                    nls = Os.eli(jsonReader, kbVar);
                    break;
                case "nm":
                    str = jsonReader.nextString();
                    break;
                case "op":
                    f3 = (float) jsonReader.nextDouble();
                    break;
                case "sc":
                    i3 = Color.parseColor(jsonReader.nextString());
                    break;
                case "sh":
                    i2 = (int) (jsonReader.nextInt() * com.bytedance.adsdk.DbA.MGA.MGA.eli());
                    break;
                case "sr":
                    f7 = (float) jsonReader.nextDouble();
                    break;
                case "st":
                    f6 = (float) jsonReader.nextDouble();
                    break;
                case "sw":
                    i = (int) (jsonReader.nextInt() * com.bytedance.adsdk.DbA.MGA.MGA.eli());
                    break;
                case "tm":
                    dbA2 = aGH.eli(jsonReader, kbVar, false);
                    break;
                case "tt":
                    int nextInt2 = jsonReader.nextInt();
                    if (nextInt2 >= ui.DbA.values().length) {
                        kbVar.eli("Unsupported matte type: ".concat(String.valueOf(nextInt2)));
                        break;
                    } else {
                        dbA3 = ui.DbA.values()[nextInt2];
                        int i4 = AnonymousClass1.eli[dbA3.ordinal()];
                        if (i4 == 1) {
                            kbVar.eli("Unsupported matte type: Luma");
                        } else if (i4 == 2) {
                            kbVar.eli("Unsupported matte type: Luma Inverted");
                        }
                        kbVar.eli(1);
                        break;
                    }
                case "ty":
                    int nextInt3 = jsonReader.nextInt();
                    if (nextInt3 < ui.eli.UNKNOWN.ordinal()) {
                        eliVar2 = ui.eli.values()[nextInt3];
                        break;
                    } else {
                        eliVar2 = ui.eli.UNKNOWN;
                        break;
                    }
                case "ind":
                    j = jsonReader.nextInt();
                    break;
                case "refId":
                    str2 = jsonReader.nextString();
                    break;
                case "masksProperties":
                    jsonReader.beginArray();
                    while (jsonReader.hasNext()) {
                        arrayList.add(Vy.eli(jsonReader, kbVar));
                    }
                    kbVar.eli(arrayList.size());
                    jsonReader.endArray();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        ArrayList arrayList4 = new ArrayList();
        if (f2 > 0.0f) {
            f = valueOf;
            arrayList4.add(new com.bytedance.adsdk.DbA.kb.eli(kbVar, valueOf, valueOf, null, 0.0f, Float.valueOf(f2)));
        } else {
            f = valueOf;
        }
        if (f3 <= 0.0f) {
            f3 = kbVar.kb();
        }
        arrayList4.add(new com.bytedance.adsdk.DbA.kb.eli(kbVar, valueOf2, valueOf2, null, f2, Float.valueOf(f3)));
        arrayList4.add(new com.bytedance.adsdk.DbA.kb.eli(kbVar, f, f, null, f3, Float.valueOf(Float.MAX_VALUE)));
        if (str.endsWith(".ai") || "ai".equals(str3)) {
            kbVar.eli("Convert your Illustrator layers to shape layers.");
        }
        return new com.bytedance.adsdk.DbA.Os.Os.ui(arrayList2, kbVar, str, j, eliVar2, j2, str2, arrayList, nls, i, i2, i3, f7, f6, f4, f5, aas, duVar, arrayList4, dbA3, dbA2, z, eliVar, aas2);
    }

    /* renamed from: com.bytedance.adsdk.DbA.ui.CMM$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] eli;

        static {
            int[] iArr = new int[ui.DbA.values().length];
            eli = iArr;
            try {
                iArr[ui.DbA.LUMA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                eli[ui.DbA.LUMA_INVERTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }
}
