package com.bytedance.adsdk.DbA.ui;

import android.util.JsonReader;
import com.bytedance.adsdk.DbA.Os.DbA.wC;
import com.ironsource.C3040d4;
import com.ironsource.D5;
import java.io.IOException;

/* loaded from: classes3.dex */
class Vy {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x006a, code lost:
    
        if (r0.equals("s") == false) goto L28;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static com.bytedance.adsdk.DbA.Os.DbA.wC eli(JsonReader jsonReader, com.bytedance.adsdk.DbA.kb kbVar) throws IOException {
        boolean z;
        jsonReader.beginObject();
        wC.eli eliVar = null;
        com.bytedance.adsdk.DbA.Os.eli.wC wCVar = null;
        com.bytedance.adsdk.DbA.Os.eli.aGH agh = null;
        boolean z2 = false;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            char c = 3;
            switch (nextName.hashCode()) {
                case 111:
                    if (nextName.equals("o")) {
                        z = false;
                        break;
                    }
                    z = -1;
                    break;
                case 3588:
                    if (nextName.equals("pt")) {
                        z = true;
                        break;
                    }
                    z = -1;
                    break;
                case 104433:
                    if (nextName.equals("inv")) {
                        z = 2;
                        break;
                    }
                    z = -1;
                    break;
                case 3357091:
                    if (nextName.equals(C3040d4.a.t)) {
                        z = 3;
                        break;
                    }
                    z = -1;
                    break;
                default:
                    z = -1;
                    break;
            }
            switch (z) {
                case false:
                    agh = aGH.DbA(jsonReader, kbVar);
                    break;
                case true:
                    wCVar = aGH.ui(jsonReader, kbVar);
                    break;
                case true:
                    z2 = jsonReader.nextBoolean();
                    break;
                case true:
                    String nextString = jsonReader.nextString();
                    nextString.hashCode();
                    switch (nextString.hashCode()) {
                        case 97:
                            if (nextString.equals("a")) {
                                c = 0;
                                break;
                            }
                            c = 65535;
                            break;
                        case 105:
                            if (nextString.equals("i")) {
                                c = 1;
                                break;
                            }
                            c = 65535;
                            break;
                        case 110:
                            if (nextString.equals(D5.q)) {
                                c = 2;
                                break;
                            }
                            c = 65535;
                            break;
                        case 115:
                            break;
                        default:
                            c = 65535;
                            break;
                    }
                    switch (c) {
                        case 0:
                            eliVar = wC.eli.MASK_MODE_ADD;
                            break;
                        case 1:
                            kbVar.eli("Animation contains intersect masks. They are not supported but will be treated like add masks.");
                            eliVar = wC.eli.MASK_MODE_INTERSECT;
                            break;
                        case 2:
                            eliVar = wC.eli.MASK_MODE_NONE;
                            break;
                        case 3:
                            eliVar = wC.eli.MASK_MODE_SUBTRACT;
                            break;
                        default:
                            eliVar = wC.eli.MASK_MODE_ADD;
                            break;
                    }
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return new com.bytedance.adsdk.DbA.Os.DbA.wC(eliVar, wCVar, agh, z2);
    }
}
