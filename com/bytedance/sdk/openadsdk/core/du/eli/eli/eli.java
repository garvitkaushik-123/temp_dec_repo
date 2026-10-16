package com.bytedance.sdk.openadsdk.core.du.eli.eli;

import android.content.Context;
import android.graphics.Point;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.bytedance.sdk.openadsdk.core.du.Os.eli;
import com.bytedance.sdk.openadsdk.core.du.eli.eli.ui;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes3.dex */
public class eli {
    /* JADX WARN: Failed to find 'out' block for switch in B:66:0x011e. Please report as an issue. */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static com.bytedance.sdk.openadsdk.core.du.Os eli(Context context, XmlPullParser xmlPullParser) throws IOException, XmlPullParserException {
        float f;
        com.bytedance.sdk.openadsdk.core.du.Os os;
        ui.eli eliVar;
        eli.EnumC0190eli enumC0190eli;
        int i;
        char c;
        if (context == null) {
            ui.eli(xmlPullParser);
            return null;
        }
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        int i2 = displayMetrics.widthPixels;
        int i3 = displayMetrics.heightPixels;
        int i4 = (int) (i2 / displayMetrics.density);
        int i5 = (int) (i3 / displayMetrics.density);
        float f2 = Float.MIN_VALUE;
        com.bytedance.sdk.openadsdk.core.du.Os os2 = null;
        while (true) {
            int i6 = 3;
            if (xmlPullParser.getEventType() == 3 && xmlPullParser.getName().equals("CompanionAds")) {
                return os2;
            }
            xmlPullParser.next();
            int i7 = 2;
            if (xmlPullParser.getEventType() == 2 && xmlPullParser.getName().equals("Companion")) {
                int DbA = ui.DbA(xmlPullParser.getAttributeValue(ui.kb, "width"));
                int DbA2 = ui.DbA(xmlPullParser.getAttributeValue(ui.kb, "height"));
                if (DbA < 300 || DbA2 < 250) {
                    f = f2;
                    os = os2;
                    ui.eli(xmlPullParser);
                } else {
                    ui.eli eliVar2 = new ui.eli();
                    while (true) {
                        if (xmlPullParser.getEventType() != i6 || !xmlPullParser.getName().equals("Companion")) {
                            int i8 = DbA2;
                            xmlPullParser.next();
                            if (xmlPullParser.getEventType() == i7) {
                                String name = xmlPullParser.getName();
                                name.hashCode();
                                float f3 = f2;
                                com.bytedance.sdk.openadsdk.core.du.Os os3 = os2;
                                char c2 = 65535;
                                switch (name.hashCode()) {
                                    case -375340334:
                                        if (name.equals("IFrameResource")) {
                                            c = 0;
                                            c2 = c;
                                            break;
                                        }
                                        break;
                                    case -348198615:
                                        if (name.equals("CompanionClickThrough")) {
                                            c = 1;
                                            c2 = c;
                                            break;
                                        }
                                        break;
                                    case 611554000:
                                        if (name.equals("TrackingEvents")) {
                                            c2 = 2;
                                            break;
                                        }
                                        break;
                                    case 676623548:
                                        if (name.equals("StaticResource")) {
                                            c2 = 3;
                                            break;
                                        }
                                        break;
                                    case 1877773523:
                                        if (name.equals("CompanionClickTracking")) {
                                            c = 4;
                                            c2 = c;
                                            break;
                                        }
                                        break;
                                    case 1928285401:
                                        if (name.equals("HTMLResource")) {
                                            c = 5;
                                            c2 = c;
                                            break;
                                        }
                                        break;
                                }
                                switch (c2) {
                                    case 0:
                                        ui.eli eliVar3 = eliVar2;
                                        i = 2;
                                        Point eli = com.bytedance.sdk.openadsdk.core.du.Os.eli.eli(context, DbA, i8, eli.DbA.HTML_RESOURCE);
                                        float eli2 = com.bytedance.sdk.openadsdk.core.du.Os.eli(i4, i5, eli.x, eli.y, eli.DbA.IFRAME_RESOURCE, eli.EnumC0190eli.NONE);
                                        String DbA3 = ui.DbA(xmlPullParser, "IFrameResource");
                                        if (TextUtils.isEmpty(DbA3) || eli2 <= eliVar3.kb || eli2 <= f3) {
                                            ui.eli(xmlPullParser, "IFrameResource", 3);
                                            eliVar2 = eliVar3;
                                            i7 = 2;
                                            f2 = f3;
                                            os2 = os3;
                                            i6 = 3;
                                        } else {
                                            eliVar3.kb = eli2;
                                            eliVar3.eli(DbA3, eli.EnumC0190eli.NONE, eli.DbA.IFRAME_RESOURCE);
                                            eliVar2 = eliVar3;
                                            i7 = i;
                                            DbA2 = i8;
                                            f2 = f3;
                                            os2 = os3;
                                            i6 = 3;
                                            break;
                                        }
                                        break;
                                    case 1:
                                        i = 2;
                                        eliVar2.aGH = ui.DbA(xmlPullParser, "CompanionClickThrough");
                                        i7 = i;
                                        DbA2 = i8;
                                        f2 = f3;
                                        os2 = os3;
                                        i6 = 3;
                                        break;
                                    case 2:
                                        eliVar = eliVar2;
                                        while (true) {
                                            if (xmlPullParser.next() == 3 && xmlPullParser.getName().equals("TrackingEvents")) {
                                                eliVar2 = eliVar;
                                                DbA2 = i8;
                                                f2 = f3;
                                                os2 = os3;
                                                i6 = 3;
                                                i7 = 2;
                                                break;
                                            } else if (xmlPullParser.getEventType() == 2 && xmlPullParser.getName().equals("Tracking")) {
                                                eliVar.DbA(ui.DbA(xmlPullParser, "Tracking"));
                                            }
                                        }
                                        break;
                                    case 3:
                                        eliVar = eliVar2;
                                        eli.EnumC0190eli enumC0190eli2 = eli.EnumC0190eli.NONE;
                                        String lowerCase = xmlPullParser.getAttributeValue(ui.kb, "creativeType").toLowerCase();
                                        if (com.bytedance.sdk.openadsdk.core.du.Os.eli.eli.contains(lowerCase)) {
                                            enumC0190eli = eli.EnumC0190eli.IMAGE;
                                        } else {
                                            enumC0190eli = eli.EnumC0190eli.JAVASCRIPT;
                                        }
                                        eli.EnumC0190eli enumC0190eli3 = enumC0190eli;
                                        Point eli3 = com.bytedance.sdk.openadsdk.core.du.Os.eli.eli(context, DbA, i8, eli.DbA.STATIC_RESOURCE);
                                        float eli4 = com.bytedance.sdk.openadsdk.core.du.Os.eli(i4, i5, eli3.x, eli3.y, eli.DbA.STATIC_RESOURCE, enumC0190eli3);
                                        String DbA4 = (com.bytedance.sdk.openadsdk.core.du.Os.eli.eli.contains(lowerCase) || com.bytedance.sdk.openadsdk.core.du.Os.eli.DbA.contains(lowerCase)) ? ui.DbA(xmlPullParser, "StaticResource") : null;
                                        if (eli4 < eliVar.kb || eli4 <= f3 || TextUtils.isEmpty(DbA4)) {
                                            ui.eli(xmlPullParser, "StaticResource", 3);
                                            eliVar2 = eliVar;
                                            i6 = 3;
                                            DbA2 = i8;
                                            f2 = f3;
                                            os2 = os3;
                                            i7 = 2;
                                            break;
                                        } else {
                                            eliVar.kb = eli4;
                                            eliVar.eli(DbA4, enumC0190eli3, eli.DbA.STATIC_RESOURCE);
                                            eliVar2 = eliVar;
                                            DbA2 = i8;
                                            f2 = f3;
                                            os2 = os3;
                                            i6 = 3;
                                            i7 = 2;
                                        }
                                        break;
                                    case 4:
                                        eliVar2.eli(ui.DbA(xmlPullParser, "CompanionClickTracking"));
                                        DbA2 = i8;
                                        f2 = f3;
                                        os2 = os3;
                                        i6 = 3;
                                        i7 = 2;
                                        break;
                                    case 5:
                                        Point eli5 = com.bytedance.sdk.openadsdk.core.du.Os.eli.eli(context, DbA, i8, eli.DbA.HTML_RESOURCE);
                                        eliVar = eliVar2;
                                        float eli6 = com.bytedance.sdk.openadsdk.core.du.Os.eli(i4, i5, eli5.x, eli5.y, eli.DbA.HTML_RESOURCE, eli.EnumC0190eli.NONE);
                                        String DbA5 = ui.DbA(xmlPullParser, "HTMLResource");
                                        if (TextUtils.isEmpty(DbA5) || eli6 <= eliVar.kb || eli6 <= f3) {
                                            ui.eli(xmlPullParser, "HTMLResource", 3);
                                            i6 = 3;
                                            eliVar2 = eliVar;
                                            DbA2 = i8;
                                            f2 = f3;
                                            os2 = os3;
                                            i7 = 2;
                                            break;
                                        } else {
                                            eliVar.kb = eli6;
                                            eliVar.eli(DbA5, eli.EnumC0190eli.NONE, eli.DbA.HTML_RESOURCE);
                                            eliVar2 = eliVar;
                                            DbA2 = i8;
                                            f2 = f3;
                                            os2 = os3;
                                            i6 = 3;
                                            i7 = 2;
                                        }
                                        break;
                                    default:
                                        ui.eli(xmlPullParser);
                                        eliVar = eliVar2;
                                        eliVar2 = eliVar;
                                        DbA2 = i8;
                                        f2 = f3;
                                        os2 = os3;
                                        i6 = 3;
                                        i7 = 2;
                                        break;
                                }
                            }
                            DbA2 = i8;
                        } else if (!TextUtils.isEmpty(eliVar2.eli) && eliVar2.kb >= f2) {
                            com.bytedance.sdk.openadsdk.core.du.Os os4 = new com.bytedance.sdk.openadsdk.core.du.Os(DbA, DbA2, eliVar2.DbA, eliVar2.Os, eliVar2.eli, eliVar2.ui, eliVar2.MGA, eliVar2.aGH);
                            f2 = eliVar2.kb;
                            os2 = os4;
                        }
                    }
                }
            } else {
                f = f2;
                os = os2;
            }
            f2 = f;
            os2 = os;
        }
    }
}
