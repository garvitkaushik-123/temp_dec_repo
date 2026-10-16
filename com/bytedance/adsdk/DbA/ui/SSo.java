package com.bytedance.adsdk.DbA.ui;

import android.util.JsonReader;
import com.bytedance.adsdk.DbA.Os.DbA.nGm;
import com.ironsource.D5;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/* loaded from: classes3.dex */
class SSo {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    static com.bytedance.adsdk.DbA.Os.DbA.nGm eli(JsonReader jsonReader, com.bytedance.adsdk.DbA.kb kbVar) throws IOException {
        char c;
        char c2;
        int i;
        ArrayList arrayList = new ArrayList();
        float f = 0.0f;
        com.bytedance.adsdk.DbA.Os.eli.aGH agh = null;
        String str = null;
        com.bytedance.adsdk.DbA.Os.eli.DbA dbA = null;
        com.bytedance.adsdk.DbA.Os.eli.eli eliVar = null;
        com.bytedance.adsdk.DbA.Os.eli.DbA dbA2 = null;
        nGm.eli eliVar2 = null;
        nGm.DbA dbA3 = null;
        boolean z = false;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            int i2 = 1;
            switch (nextName.hashCode()) {
                case 99:
                    if (nextName.equals("c")) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                case 100:
                    if (nextName.equals("d")) {
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
                case JSON_ENCODE_ERROR_VALUE:
                    if (nextName.equals("w")) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                case 3324:
                    if (nextName.equals("hd")) {
                        c = 4;
                        break;
                    }
                    c = 65535;
                    break;
                case 3447:
                    if (nextName.equals("lc")) {
                        c = 5;
                        break;
                    }
                    c = 65535;
                    break;
                case 3454:
                    if (nextName.equals("lj")) {
                        c = 6;
                        break;
                    }
                    c = 65535;
                    break;
                case 3487:
                    if (nextName.equals("ml")) {
                        c = 7;
                        break;
                    }
                    c = 65535;
                    break;
                case 3519:
                    if (nextName.equals("nm")) {
                        c = '\b';
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
                    eliVar = aGH.kb(jsonReader, kbVar);
                    continue;
                case 1:
                    jsonReader.beginArray();
                    while (jsonReader.hasNext()) {
                        jsonReader.beginObject();
                        String str2 = null;
                        com.bytedance.adsdk.DbA.Os.eli.DbA dbA4 = null;
                        while (jsonReader.hasNext()) {
                            String nextName2 = jsonReader.nextName();
                            nextName2.hashCode();
                            if (nextName2.equals(D5.q)) {
                                str2 = jsonReader.nextString();
                            } else if (nextName2.equals("v")) {
                                dbA4 = aGH.eli(jsonReader, kbVar);
                            } else {
                                jsonReader.skipValue();
                            }
                        }
                        jsonReader.endObject();
                        str2.hashCode();
                        switch (str2.hashCode()) {
                            case 100:
                                if (str2.equals("d")) {
                                    c2 = 0;
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case 103:
                                if (str2.equals("g")) {
                                    c2 = 1;
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case 111:
                                if (str2.equals("o")) {
                                    c2 = 2;
                                    break;
                                }
                                c2 = 65535;
                                break;
                            default:
                                c2 = 65535;
                                break;
                        }
                        switch (c2) {
                            case 0:
                            case 1:
                                i = 1;
                                kbVar.eli(true);
                                arrayList.add(dbA4);
                                i2 = i;
                                break;
                            case 2:
                                dbA = dbA4;
                                i2 = 1;
                                break;
                            default:
                                i = 1;
                                i2 = i;
                                break;
                        }
                    }
                    int i3 = i2;
                    jsonReader.endArray();
                    if (arrayList.size() != i3) {
                        break;
                    } else {
                        arrayList.add(arrayList.get(0));
                        break;
                    }
                case 2:
                    agh = aGH.DbA(jsonReader, kbVar);
                    continue;
                case 3:
                    dbA2 = aGH.eli(jsonReader, kbVar);
                    continue;
                case 4:
                    z = jsonReader.nextBoolean();
                    continue;
                case 5:
                    eliVar2 = nGm.eli.values()[jsonReader.nextInt() - 1];
                    continue;
                case 6:
                    dbA3 = nGm.DbA.values()[jsonReader.nextInt() - 1];
                    continue;
                case 7:
                    f = (float) jsonReader.nextDouble();
                    continue;
                case '\b':
                    str = jsonReader.nextString();
                    continue;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        if (agh == null) {
            agh = new com.bytedance.adsdk.DbA.Os.eli.aGH(Collections.singletonList(new com.bytedance.adsdk.DbA.kb.eli(100)));
        }
        return new com.bytedance.adsdk.DbA.Os.DbA.nGm(str, dbA, arrayList, eliVar, agh, dbA2, eliVar2, dbA3, f, z);
    }
}
