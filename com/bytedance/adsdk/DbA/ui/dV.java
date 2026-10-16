package com.bytedance.adsdk.DbA.ui;

import android.util.JsonReader;
import com.bytedance.adsdk.DbA.Os.DbA.nGm;
import com.ironsource.D5;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/* loaded from: classes3.dex */
class dV {
    static com.bytedance.adsdk.DbA.Os.DbA.MGA eli(JsonReader jsonReader, com.bytedance.adsdk.DbA.kb kbVar) throws IOException {
        int i;
        char c;
        com.bytedance.adsdk.DbA.Os.eli.Os os;
        com.bytedance.adsdk.DbA.Os.eli.MGA mga;
        ArrayList arrayList = new ArrayList();
        String str = null;
        com.bytedance.adsdk.DbA.Os.DbA.kb kbVar2 = null;
        com.bytedance.adsdk.DbA.Os.eli.Os os2 = null;
        com.bytedance.adsdk.DbA.Os.eli.MGA mga2 = null;
        com.bytedance.adsdk.DbA.Os.eli.MGA mga3 = null;
        com.bytedance.adsdk.DbA.Os.eli.DbA dbA = null;
        nGm.eli eliVar = null;
        nGm.DbA dbA2 = null;
        com.bytedance.adsdk.DbA.Os.eli.DbA dbA3 = null;
        float f = 0.0f;
        boolean z = false;
        com.bytedance.adsdk.DbA.Os.eli.aGH agh = null;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            String str2 = str;
            com.bytedance.adsdk.DbA.Os.eli.aGH agh2 = agh;
            com.bytedance.adsdk.DbA.Os.DbA.kb kbVar3 = kbVar2;
            switch (nextName.hashCode()) {
                case 100:
                    i = 1;
                    if (nextName.equals("d")) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                case 101:
                    i = 1;
                    if (nextName.equals("e")) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case 103:
                    i = 1;
                    if (nextName.equals("g")) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case 111:
                    i = 1;
                    if (nextName.equals("o")) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                case 115:
                    i = 1;
                    if (nextName.equals("s")) {
                        c = 4;
                        break;
                    }
                    c = 65535;
                    break;
                case 116:
                    i = 1;
                    if (nextName.equals("t")) {
                        c = 5;
                        break;
                    }
                    c = 65535;
                    break;
                case JSON_ENCODE_ERROR_VALUE:
                    i = 1;
                    if (nextName.equals("w")) {
                        c = 6;
                        break;
                    }
                    c = 65535;
                    break;
                case 3324:
                    i = 1;
                    if (nextName.equals("hd")) {
                        c = 7;
                        break;
                    }
                    c = 65535;
                    break;
                case 3447:
                    i = 1;
                    if (nextName.equals("lc")) {
                        c = '\b';
                        break;
                    }
                    c = 65535;
                    break;
                case 3454:
                    i = 1;
                    if (nextName.equals("lj")) {
                        c = '\t';
                        break;
                    }
                    c = 65535;
                    break;
                case 3487:
                    i = 1;
                    if (nextName.equals("ml")) {
                        c = '\n';
                        break;
                    }
                    c = 65535;
                    break;
                case 3519:
                    i = 1;
                    if (nextName.equals("nm")) {
                        c = 11;
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    c = 65535;
                    i = 1;
                    break;
            }
            switch (c) {
                case 0:
                    JsonReader jsonReader2 = jsonReader;
                    jsonReader2.beginArray();
                    while (jsonReader2.hasNext()) {
                        jsonReader2.beginObject();
                        com.bytedance.adsdk.DbA.Os.eli.DbA dbA4 = null;
                        String str3 = null;
                        while (jsonReader.hasNext()) {
                            com.bytedance.adsdk.DbA.Os.eli.Os os3 = os2;
                            String nextName2 = jsonReader.nextName();
                            nextName2.hashCode();
                            com.bytedance.adsdk.DbA.Os.eli.MGA mga4 = mga2;
                            if (nextName2.equals(D5.q)) {
                                str3 = jsonReader.nextString();
                            } else if (nextName2.equals("v")) {
                                dbA4 = aGH.eli(jsonReader, kbVar);
                            } else {
                                jsonReader.skipValue();
                            }
                            os2 = os3;
                            mga2 = mga4;
                        }
                        com.bytedance.adsdk.DbA.Os.eli.Os os4 = os2;
                        com.bytedance.adsdk.DbA.Os.eli.MGA mga5 = mga2;
                        jsonReader.endObject();
                        if (str3.equals("o")) {
                            dbA3 = dbA4;
                            os2 = os4;
                            mga2 = mga5;
                            jsonReader2 = jsonReader;
                        } else {
                            if (str3.equals("d") || str3.equals("g")) {
                                kbVar.eli(true);
                                arrayList.add(dbA4);
                            }
                            jsonReader2 = jsonReader;
                            os2 = os4;
                            mga2 = mga5;
                        }
                    }
                    os = os2;
                    mga = mga2;
                    jsonReader.endArray();
                    if (arrayList.size() == 1) {
                        arrayList.add(arrayList.get(0));
                        str = str2;
                        agh = agh2;
                        os2 = os;
                        kbVar2 = kbVar3;
                        mga2 = mga;
                        break;
                    }
                    str = str2;
                    agh = agh2;
                    os2 = os;
                    kbVar2 = kbVar3;
                    mga2 = mga;
                    break;
                case 1:
                    mga3 = aGH.Os(jsonReader, kbVar);
                    str = str2;
                    agh = agh2;
                    kbVar2 = kbVar3;
                    break;
                case 2:
                    jsonReader.beginObject();
                    int i2 = -1;
                    while (jsonReader.hasNext()) {
                        String nextName3 = jsonReader.nextName();
                        nextName3.hashCode();
                        if (nextName3.equals(CampaignEx.JSON_KEY_AD_K)) {
                            os2 = aGH.eli(jsonReader, kbVar, i2);
                        } else if (nextName3.equals("p")) {
                            i2 = jsonReader.nextInt();
                        } else {
                            jsonReader.skipValue();
                        }
                    }
                    jsonReader.endObject();
                    str = str2;
                    agh = agh2;
                    kbVar2 = kbVar3;
                    break;
                case 3:
                    agh = aGH.DbA(jsonReader, kbVar);
                    str = str2;
                    kbVar2 = kbVar3;
                    break;
                case 4:
                    mga2 = aGH.Os(jsonReader, kbVar);
                    str = str2;
                    agh = agh2;
                    kbVar2 = kbVar3;
                    break;
                case 5:
                    kbVar2 = jsonReader.nextInt() == i ? com.bytedance.adsdk.DbA.Os.DbA.kb.LINEAR : com.bytedance.adsdk.DbA.Os.DbA.kb.RADIAL;
                    str = str2;
                    agh = agh2;
                    break;
                case 6:
                    dbA = aGH.eli(jsonReader, kbVar);
                    str = str2;
                    agh = agh2;
                    kbVar2 = kbVar3;
                    break;
                case 7:
                    z = jsonReader.nextBoolean();
                    str = str2;
                    agh = agh2;
                    kbVar2 = kbVar3;
                    break;
                case '\b':
                    eliVar = nGm.eli.values()[jsonReader.nextInt() - 1];
                    str = str2;
                    agh = agh2;
                    kbVar2 = kbVar3;
                    break;
                case '\t':
                    dbA2 = nGm.DbA.values()[jsonReader.nextInt() - 1];
                    str = str2;
                    agh = agh2;
                    kbVar2 = kbVar3;
                    break;
                case '\n':
                    f = (float) jsonReader.nextDouble();
                    str = str2;
                    agh = agh2;
                    kbVar2 = kbVar3;
                    break;
                case 11:
                    str = jsonReader.nextString();
                    agh = agh2;
                    kbVar2 = kbVar3;
                    break;
                default:
                    jsonReader.skipValue();
                    os = os2;
                    mga = mga2;
                    str = str2;
                    agh = agh2;
                    os2 = os;
                    kbVar2 = kbVar3;
                    mga2 = mga;
                    break;
            }
        }
        com.bytedance.adsdk.DbA.Os.eli.aGH agh3 = agh;
        return new com.bytedance.adsdk.DbA.Os.DbA.MGA(str, kbVar2, os2, agh3 == null ? new com.bytedance.adsdk.DbA.Os.eli.aGH(Collections.singletonList(new com.bytedance.adsdk.DbA.kb.eli(100))) : agh3, mga2, mga3, dbA, eliVar, dbA2, f, arrayList, dbA3, z);
    }
}
