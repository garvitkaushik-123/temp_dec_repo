package com.bytedance.adsdk.DbA.ui;

import android.util.JsonReader;
import android.util.JsonToken;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
class bf {
    static <T> List<com.bytedance.adsdk.DbA.kb.eli<T>> eli(JsonReader jsonReader, com.bytedance.adsdk.DbA.kb kbVar, float f, FS<T> fs, boolean z) throws IOException {
        JsonReader jsonReader2;
        com.bytedance.adsdk.DbA.kb kbVar2;
        float f2;
        FS<T> fs2;
        boolean z2;
        ArrayList arrayList = new ArrayList();
        if (jsonReader.peek() == JsonToken.STRING) {
            kbVar.eli("Lottie doesn't support expressions.");
            return arrayList;
        }
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            if (nextName.equals(CampaignEx.JSON_KEY_AD_K)) {
                if (jsonReader.peek() == JsonToken.BEGIN_ARRAY) {
                    jsonReader.beginArray();
                    if (jsonReader.peek() == JsonToken.NUMBER) {
                        JsonReader jsonReader3 = jsonReader;
                        com.bytedance.adsdk.DbA.kb kbVar3 = kbVar;
                        float f3 = f;
                        FS<T> fs3 = fs;
                        boolean z3 = z;
                        com.bytedance.adsdk.DbA.kb.eli eli = Xb.eli(jsonReader3, kbVar3, f3, fs3, false, z3);
                        jsonReader2 = jsonReader3;
                        kbVar2 = kbVar3;
                        f2 = f3;
                        fs2 = fs3;
                        z2 = z3;
                        arrayList.add(eli);
                    } else {
                        jsonReader2 = jsonReader;
                        kbVar2 = kbVar;
                        f2 = f;
                        fs2 = fs;
                        z2 = z;
                        while (jsonReader2.hasNext()) {
                            arrayList.add(Xb.eli(jsonReader2, kbVar2, f2, fs2, true, z2));
                        }
                    }
                    jsonReader2.endArray();
                    jsonReader = jsonReader2;
                    kbVar = kbVar2;
                    f = f2;
                    fs = fs2;
                    z = z2;
                } else {
                    JsonReader jsonReader4 = jsonReader;
                    arrayList.add(Xb.eli(jsonReader4, kbVar, f, fs, false, z));
                    jsonReader = jsonReader4;
                }
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        eli(arrayList);
        return arrayList;
    }

    public static <T> void eli(List<? extends com.bytedance.adsdk.DbA.kb.eli<T>> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        while (true) {
            i = size - 1;
            if (i2 >= i) {
                break;
            }
            com.bytedance.adsdk.DbA.kb.eli<T> eliVar = list.get(i2);
            i2++;
            com.bytedance.adsdk.DbA.kb.eli<T> eliVar2 = list.get(i2);
            eliVar.kb = Float.valueOf(eliVar2.MGA);
            if (eliVar.DbA == null && eliVar2.eli != null) {
                eliVar.DbA = eliVar2.eli;
                if (eliVar instanceof com.bytedance.adsdk.DbA.eli.DbA.FC) {
                    ((com.bytedance.adsdk.DbA.eli.DbA.FC) eliVar).eli();
                }
            }
        }
        com.bytedance.adsdk.DbA.kb.eli<T> eliVar3 = list.get(i);
        if ((eliVar3.eli == null || eliVar3.DbA == null) && list.size() > 1) {
            list.remove(eliVar3);
        }
    }
}
