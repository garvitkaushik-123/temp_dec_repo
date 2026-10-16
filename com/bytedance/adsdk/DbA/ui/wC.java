package com.bytedance.adsdk.DbA.ui;

import android.util.JsonReader;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.b;
import java.io.IOException;

/* loaded from: classes3.dex */
class wC {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x00ce, code lost:
    
        if (r2.equals("gf") == false) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static com.bytedance.adsdk.DbA.Os.DbA.Os eli(JsonReader jsonReader, com.bytedance.adsdk.DbA.kb kbVar) throws IOException {
        com.bytedance.adsdk.DbA.Os.DbA.Os os;
        String str;
        jsonReader.beginObject();
        char c = 2;
        int i = 2;
        while (true) {
            os = null;
            if (!jsonReader.hasNext()) {
                str = null;
                break;
            }
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            if (!nextName.equals("d")) {
                if (nextName.equals("ty")) {
                    str = jsonReader.nextString();
                    break;
                }
                jsonReader.skipValue();
            } else {
                i = jsonReader.nextInt();
            }
        }
        if (str == null) {
            return null;
        }
        str.hashCode();
        switch (str.hashCode()) {
            case 3239:
                if (str.equals("el")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case 3270:
                if (str.equals("fl")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 3295:
                break;
            case 3307:
                if (str.equals("gr")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case 3308:
                if (str.equals("gs")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case 3488:
                if (str.equals("mm")) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case 3633:
                if (str.equals(DownloadCommon.DOWNLOAD_REPORT_RETRY_COUNT)) {
                    c = 6;
                    break;
                }
                c = 65535;
                break;
            case 3634:
                if (str.equals("rd")) {
                    c = 7;
                    break;
                }
                c = 65535;
                break;
            case 3646:
                if (str.equals("rp")) {
                    c = '\b';
                    break;
                }
                c = 65535;
                break;
            case 3669:
                if (str.equals(b.JSON_KEY_SH)) {
                    c = '\t';
                    break;
                }
                c = 65535;
                break;
            case 3679:
                if (str.equals("sr")) {
                    c = '\n';
                    break;
                }
                c = 65535;
                break;
            case 3681:
                if (str.equals("st")) {
                    c = 11;
                    break;
                }
                c = 65535;
                break;
            case 3705:
                if (str.equals("tm")) {
                    c = '\f';
                    break;
                }
                c = 65535;
                break;
            case 3710:
                if (str.equals("tr")) {
                    c = '\r';
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
                os = MGA.eli(jsonReader, kbVar, i);
                break;
            case 1:
                os = cyF.eli(jsonReader, kbVar);
                break;
            case 2:
                os = aqO.eli(jsonReader, kbVar);
                break;
            case 3:
                os = eU.eli(jsonReader, kbVar);
                break;
            case 4:
                os = dV.eli(jsonReader, kbVar);
                break;
            case 5:
                os = gG.eli(jsonReader);
                kbVar.eli("Animation contains merge paths. Merge paths are only supported on KitKat+ and must be manually enabled by calling enableMergePathsForKitKatAndAbove().");
                break;
            case 6:
                os = GB.eli(jsonReader, kbVar);
                break;
            case 7:
                os = qj.eli(jsonReader, kbVar);
                break;
            case '\b':
                os = oWW.eli(jsonReader, kbVar);
                break;
            case '\t':
                os = dZ.eli(jsonReader, kbVar);
                break;
            case '\n':
                os = VM.eli(jsonReader, kbVar, i);
                break;
            case 11:
                os = SSo.eli(jsonReader, kbVar);
                break;
            case '\f':
                os = Uv.eli(jsonReader, kbVar);
                break;
            case '\r':
                os = Os.eli(jsonReader, kbVar);
                break;
        }
        while (jsonReader.hasNext()) {
            jsonReader.skipValue();
        }
        jsonReader.endObject();
        return os;
    }
}
