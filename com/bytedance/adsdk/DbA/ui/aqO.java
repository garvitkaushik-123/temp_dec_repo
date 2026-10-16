package com.bytedance.adsdk.DbA.ui;

import android.graphics.Path;
import android.util.JsonReader;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.io.IOException;
import java.util.Collections;

/* loaded from: classes3.dex */
class aqO {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    static com.bytedance.adsdk.DbA.Os.DbA.ui eli(JsonReader jsonReader, com.bytedance.adsdk.DbA.kb kbVar) throws IOException {
        char c;
        com.bytedance.adsdk.DbA.Os.eli.aGH agh = null;
        Path.FillType fillType = Path.FillType.WINDING;
        String str = null;
        com.bytedance.adsdk.DbA.Os.DbA.kb kbVar2 = null;
        com.bytedance.adsdk.DbA.Os.eli.Os os = null;
        com.bytedance.adsdk.DbA.Os.eli.MGA mga = null;
        com.bytedance.adsdk.DbA.Os.eli.MGA mga2 = null;
        boolean z = false;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            int i = -1;
            switch (nextName.hashCode()) {
                case 101:
                    if (nextName.equals("e")) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                case 103:
                    if (nextName.equals("g")) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case 111:
                    if (nextName.equals("o")) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case 114:
                    if (nextName.equals("r")) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                case 115:
                    if (nextName.equals("s")) {
                        c = 4;
                        break;
                    }
                    c = 65535;
                    break;
                case 116:
                    if (nextName.equals("t")) {
                        c = 5;
                        break;
                    }
                    c = 65535;
                    break;
                case 3324:
                    if (nextName.equals("hd")) {
                        c = 6;
                        break;
                    }
                    c = 65535;
                    break;
                case 3519:
                    if (nextName.equals("nm")) {
                        c = 7;
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    c = 65535;
                    break;
            }
            switch (c) {
                case 0:
                    mga2 = aGH.Os(jsonReader, kbVar);
                    break;
                case 1:
                    jsonReader.beginObject();
                    while (jsonReader.hasNext()) {
                        String nextName2 = jsonReader.nextName();
                        nextName2.hashCode();
                        if (nextName2.equals(CampaignEx.JSON_KEY_AD_K)) {
                            os = aGH.eli(jsonReader, kbVar, i);
                        } else if (nextName2.equals("p")) {
                            i = jsonReader.nextInt();
                        } else {
                            jsonReader.skipValue();
                        }
                    }
                    jsonReader.endObject();
                    break;
                case 2:
                    agh = aGH.DbA(jsonReader, kbVar);
                    break;
                case 3:
                    fillType = jsonReader.nextInt() == 1 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD;
                    break;
                case 4:
                    mga = aGH.Os(jsonReader, kbVar);
                    break;
                case 5:
                    kbVar2 = jsonReader.nextInt() == 1 ? com.bytedance.adsdk.DbA.Os.DbA.kb.LINEAR : com.bytedance.adsdk.DbA.Os.DbA.kb.RADIAL;
                    break;
                case 6:
                    z = jsonReader.nextBoolean();
                    break;
                case 7:
                    str = jsonReader.nextString();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        if (agh == null) {
            agh = new com.bytedance.adsdk.DbA.Os.eli.aGH(Collections.singletonList(new com.bytedance.adsdk.DbA.kb.eli(100)));
        }
        return new com.bytedance.adsdk.DbA.Os.DbA.ui(str, kbVar2, fillType, os, agh, mga, mga2, null, null, z);
    }
}
