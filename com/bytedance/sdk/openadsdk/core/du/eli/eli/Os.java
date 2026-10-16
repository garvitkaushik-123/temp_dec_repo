package com.bytedance.sdk.openadsdk.core.du.eli.eli;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.du.DbA.Os;
import com.bytedance.sdk.openadsdk.core.du.Os.eli;
import com.bytedance.sdk.openadsdk.core.du.eli.eli.ui;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k;
import io.bidmachine.iab.vast.tags.VastAttributes;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes3.dex */
public class Os {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0050, code lost:
    
        if (r2.equals(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k.B) == false) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void eli(XmlPullParser xmlPullParser, com.bytedance.sdk.openadsdk.core.du.eli eliVar, int i, double d) throws IOException, XmlPullParserException {
        boolean z = false;
        while (true) {
            char c = 3;
            if (xmlPullParser.next() != 3 || !xmlPullParser.getName().equals("Linear")) {
                if (xmlPullParser.getEventType() == 2) {
                    if (z && TextUtils.isEmpty(eliVar.kb())) {
                        ui.eli(xmlPullParser);
                    }
                    String name = xmlPullParser.getName();
                    name.hashCode();
                    switch (name.hashCode()) {
                        case -2049897434:
                            if (name.equals("VideoClicks")) {
                                c = 0;
                                break;
                            }
                            c = 65535;
                            break;
                        case -1927368268:
                            if (name.equals("Duration")) {
                                c = 1;
                                break;
                            }
                            c = 65535;
                            break;
                        case -385055469:
                            if (name.equals("MediaFiles")) {
                                c = 2;
                                break;
                            }
                            c = 65535;
                            break;
                        case 70476538:
                            break;
                        case 611554000:
                            if (name.equals("TrackingEvents")) {
                                c = 4;
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
                            eli(xmlPullParser, eliVar);
                            break;
                        case 1:
                            eliVar.eli(DbA(xmlPullParser));
                            break;
                        case 2:
                            eli(xmlPullParser, i, d, eliVar);
                            z = true;
                            break;
                        case 3:
                            com.bytedance.sdk.openadsdk.core.du.DbA eli = eli(xmlPullParser);
                            if (eli != null && eliVar.DbA() == null) {
                                eliVar.eli(eli);
                                break;
                            }
                            break;
                        case 4:
                            eli(xmlPullParser, eliVar.eli());
                            break;
                        default:
                            ui.eli(xmlPullParser);
                            break;
                    }
                }
            } else {
                return;
            }
        }
    }

    private static String eli(XmlPullParser xmlPullParser, int i, double d, com.bytedance.sdk.openadsdk.core.du.eli eliVar) throws IOException, XmlPullParserException {
        double d2 = Double.NEGATIVE_INFINITY;
        String str = null;
        int i2 = Integer.MIN_VALUE;
        int i3 = Integer.MIN_VALUE;
        while (true) {
            if (xmlPullParser.next() == 3 && xmlPullParser.getName().equals("MediaFiles")) {
                break;
            }
            if (xmlPullParser.getEventType() == 2 && xmlPullParser.getName().equals("MediaFile")) {
                String attributeValue = xmlPullParser.getAttributeValue(ui.kb, "type");
                int DbA = ui.DbA(xmlPullParser.getAttributeValue(ui.kb, "width"));
                int DbA2 = ui.DbA(xmlPullParser.getAttributeValue(ui.kb, "height"));
                int DbA3 = ui.DbA(xmlPullParser.getAttributeValue(ui.kb, VastAttributes.BITRATE));
                String DbA4 = ui.DbA(xmlPullParser, "MediaFile");
                if (DbA > 0 && DbA2 > 0 && com.bytedance.sdk.openadsdk.core.du.Os.aGH.eli.contains(attributeValue) && !TextUtils.isEmpty(DbA4)) {
                    double eli = com.bytedance.sdk.openadsdk.core.du.Os.aGH.eli(i, d, DbA, DbA2, DbA3, attributeValue);
                    if (eli > d2) {
                        str = DbA4;
                        i2 = DbA;
                        i3 = DbA2;
                        d2 = eli;
                    }
                }
            }
        }
        if (!TextUtils.isEmpty(str)) {
            eliVar.aGH(str);
            eliVar.eli(i2);
            eliVar.DbA(i3);
        }
        return str;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static com.bytedance.sdk.openadsdk.core.du.DbA eli(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        com.bytedance.sdk.openadsdk.core.du.DbA dbA;
        com.bytedance.sdk.openadsdk.core.du.DbA dbA2;
        int i;
        int i2;
        int i3;
        eli.EnumC0190eli enumC0190eli;
        com.bytedance.sdk.openadsdk.core.du.DbA dbA3 = null;
        while (true) {
            int i4 = 3;
            if (xmlPullParser.getEventType() == 3 && xmlPullParser.getName().equals(k.B)) {
                return dbA3;
            }
            xmlPullParser.next();
            int i5 = 2;
            if (xmlPullParser.getEventType() == 2 && xmlPullParser.getName().equals(k.C)) {
                int DbA = ui.DbA(xmlPullParser.getAttributeValue(ui.kb, "width"));
                int DbA2 = ui.DbA(xmlPullParser.getAttributeValue(ui.kb, "height"));
                if (DbA <= 0 || DbA > 300 || DbA2 <= 0 || DbA2 > 300) {
                    dbA = dbA3;
                    ui.eli(xmlPullParser);
                } else {
                    int eli = com.bytedance.sdk.openadsdk.core.du.DbA.eli.eli(xmlPullParser.getAttributeValue(ui.kb, "offset"));
                    int eli2 = com.bytedance.sdk.openadsdk.core.du.DbA.eli.eli(xmlPullParser.getAttributeValue(ui.kb, "duration"));
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    ui.eli eliVar = null;
                    String str = null;
                    while (true) {
                        if (xmlPullParser.next() != i4 || !xmlPullParser.getName().equals(k.C)) {
                            ArrayList arrayList3 = arrayList;
                            ArrayList arrayList4 = arrayList2;
                            if (xmlPullParser.getEventType() == i5) {
                                String name = xmlPullParser.getName();
                                name.hashCode();
                                dbA2 = dbA3;
                                i = eli;
                                switch (name) {
                                    case "IconViewTracking":
                                        i2 = 3;
                                        i3 = 2;
                                        arrayList4.add(new Os.eli(ui.DbA(xmlPullParser, k.J)).eli());
                                        break;
                                    case "IFrameResource":
                                        i2 = 3;
                                        i3 = 2;
                                        if (eliVar == null) {
                                            eliVar = new ui.eli(ui.DbA(xmlPullParser, "IFrameResource"), eli.EnumC0190eli.NONE, eli.DbA.IFRAME_RESOURCE);
                                            break;
                                        }
                                        ui.eli(xmlPullParser);
                                        break;
                                    case "StaticResource":
                                        i2 = 3;
                                        i3 = 2;
                                        eli.EnumC0190eli enumC0190eli2 = eli.EnumC0190eli.NONE;
                                        String lowerCase = xmlPullParser.getAttributeValue(ui.kb, "creativeType").toLowerCase();
                                        String DbA3 = (com.bytedance.sdk.openadsdk.core.du.Os.eli.eli.contains(lowerCase) || com.bytedance.sdk.openadsdk.core.du.Os.eli.DbA.contains(lowerCase)) ? ui.DbA(xmlPullParser, "StaticResource") : null;
                                        if (com.bytedance.sdk.openadsdk.core.du.Os.eli.eli.contains(lowerCase)) {
                                            enumC0190eli = eli.EnumC0190eli.IMAGE;
                                        } else {
                                            enumC0190eli = eli.EnumC0190eli.JAVASCRIPT;
                                        }
                                        eliVar = new ui.eli(DbA3, enumC0190eli, eli.DbA.STATIC_RESOURCE);
                                        break;
                                    case "IconClicks":
                                        while (true) {
                                            i2 = 3;
                                            if (xmlPullParser.next() == 3 && xmlPullParser.getName().equals(k.G)) {
                                                i3 = 2;
                                                break;
                                            } else if (xmlPullParser.getEventType() == 2) {
                                                if (xmlPullParser.getName().equals(k.H)) {
                                                    str = ui.DbA(xmlPullParser, k.H);
                                                } else if (xmlPullParser.getName().equals(k.I)) {
                                                    arrayList3.add(new Os.eli(ui.DbA(xmlPullParser, k.I)).eli());
                                                }
                                            }
                                        }
                                        break;
                                    case "HTMLResource":
                                        if (eliVar == null || eliVar.Os == eli.DbA.IFRAME_RESOURCE) {
                                            eliVar = new ui.eli(ui.DbA(xmlPullParser, "HTMLResource"), eli.EnumC0190eli.NONE, eli.DbA.HTML_RESOURCE);
                                            arrayList = arrayList3;
                                            dbA3 = dbA2;
                                            eli = i;
                                            i4 = 3;
                                            i5 = 2;
                                            break;
                                        }
                                        i2 = 3;
                                        i3 = 2;
                                        ui.eli(xmlPullParser);
                                        break;
                                    default:
                                        i2 = 3;
                                        i3 = 2;
                                        ui.eli(xmlPullParser);
                                        break;
                                }
                                arrayList2 = arrayList4;
                            } else {
                                dbA2 = dbA3;
                                i = eli;
                                i2 = i4;
                                i3 = i5;
                            }
                            arrayList = arrayList3;
                            i4 = i2;
                            i5 = i3;
                            dbA3 = dbA2;
                            eli = i;
                            arrayList2 = arrayList4;
                        } else if (eliVar != null && (dbA3 == null || TextUtils.isEmpty(dbA3.MGA()))) {
                            dbA3 = new com.bytedance.sdk.openadsdk.core.du.DbA(DbA, DbA2, eli, eli2, eliVar.DbA, eliVar.Os, eliVar.eli, arrayList, arrayList2, str);
                            ui.eli(xmlPullParser, k.B, i4);
                        }
                    }
                }
            } else {
                dbA = dbA3;
            }
            dbA3 = dbA;
        }
    }

    public static double DbA(XmlPullParser xmlPullParser) throws IOException, XmlPullParserException {
        if (ui.DbA(xmlPullParser, "Duration").split(":").length != 3) {
            return 0.0d;
        }
        try {
            return (Integer.parseInt(r2[0].trim()) * 3600) + (Integer.parseInt(r2[1].trim()) * 60) + Float.parseFloat(r2[2].trim());
        } catch (Exception unused) {
            return 0.0d;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x00b0, code lost:
    
        if (r0.equals(com.mbridge.msdk.foundation.entity.CampaignEx.JSON_NATIVE_VIDEO_UNMUTE) == false) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void eli(XmlPullParser xmlPullParser, com.bytedance.sdk.openadsdk.core.du.aGH agh) throws IOException, XmlPullParserException {
        while (true) {
            char c = 3;
            if (xmlPullParser.next() == 3 && xmlPullParser.getName().equals("TrackingEvents")) {
                return;
            }
            if (xmlPullParser.getEventType() == 2) {
                if ("Tracking".equals(xmlPullParser.getName())) {
                    String attributeValue = xmlPullParser.getAttributeValue(ui.kb, "event");
                    if (TextUtils.isEmpty(attributeValue)) {
                        ui.eli(xmlPullParser, "Tracking", 3);
                    } else {
                        attributeValue.hashCode();
                        switch (attributeValue.hashCode()) {
                            case -1638835128:
                                if (attributeValue.equals(CampaignEx.JSON_NATIVE_VIDEO_MIDPOINT)) {
                                    c = 0;
                                    break;
                                }
                                c = 65535;
                                break;
                            case -1337830390:
                                if (attributeValue.equals("thirdQuartile")) {
                                    c = 1;
                                    break;
                                }
                                c = 65535;
                                break;
                            case -934426579:
                                if (attributeValue.equals(CampaignEx.JSON_NATIVE_VIDEO_RESUME)) {
                                    c = 2;
                                    break;
                                }
                                c = 65535;
                                break;
                            case -840405966:
                                break;
                            case -599445191:
                                if (attributeValue.equals(CampaignEx.JSON_NATIVE_VIDEO_COMPLETE)) {
                                    c = 4;
                                    break;
                                }
                                c = 65535;
                                break;
                            case 3363353:
                                if (attributeValue.equals(CampaignEx.JSON_NATIVE_VIDEO_MUTE)) {
                                    c = 5;
                                    break;
                                }
                                c = 65535;
                                break;
                            case 3532159:
                                if (attributeValue.equals("skip")) {
                                    c = 6;
                                    break;
                                }
                                c = 65535;
                                break;
                            case 94756344:
                                if (attributeValue.equals("close")) {
                                    c = 7;
                                    break;
                                }
                                c = 65535;
                                break;
                            case 106440182:
                                if (attributeValue.equals(CampaignEx.JSON_NATIVE_VIDEO_PAUSE)) {
                                    c = '\b';
                                    break;
                                }
                                c = 65535;
                                break;
                            case 109757538:
                                if (attributeValue.equals("start")) {
                                    c = '\t';
                                    break;
                                }
                                c = 65535;
                                break;
                            case 560220243:
                                if (attributeValue.equals("firstQuartile")) {
                                    c = '\n';
                                    break;
                                }
                                c = 65535;
                                break;
                            case 1778167540:
                                if (attributeValue.equals("creativeView")) {
                                    c = 11;
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
                                agh.eli(ui.DbA(xmlPullParser, "Tracking"), 0.5f);
                                break;
                            case 1:
                                agh.eli(ui.DbA(xmlPullParser, "Tracking"), 0.75f);
                                break;
                            case 2:
                                agh.Os(eli(xmlPullParser, true));
                                break;
                            case 3:
                                agh.nlS(eli(xmlPullParser, true));
                                break;
                            case 4:
                                agh.aGH(Os(xmlPullParser));
                                break;
                            case 5:
                                agh.du(eli(xmlPullParser, true));
                                break;
                            case 6:
                                agh.MGA(Os(xmlPullParser));
                                break;
                            case 7:
                                agh.ui(Os(xmlPullParser));
                                break;
                            case '\b':
                                agh.DbA(eli(xmlPullParser, true));
                                break;
                            case '\t':
                            case 11:
                                agh.eli(ui.DbA(xmlPullParser, "Tracking"), 0L);
                                break;
                            case '\n':
                                agh.eli(ui.DbA(xmlPullParser, "Tracking"), 0.25f);
                                break;
                        }
                    }
                } else if (xmlPullParser.getEventType() == 4) {
                    xmlPullParser.nextTag();
                } else {
                    ui.eli(xmlPullParser);
                }
            }
        }
    }

    private static void eli(XmlPullParser xmlPullParser, com.bytedance.sdk.openadsdk.core.du.eli eliVar) throws IOException, XmlPullParserException {
        while (true) {
            if (xmlPullParser.next() == 3 && xmlPullParser.getName().equals("VideoClicks")) {
                return;
            }
            if (xmlPullParser.getEventType() == 2) {
                String name = xmlPullParser.getName();
                name.hashCode();
                if (name.equals("ClickThrough")) {
                    eliVar.Os(ui.DbA(xmlPullParser, "ClickThrough"));
                } else if (name.equals("ClickTracking")) {
                    eliVar.eli().kb(ui.eli(xmlPullParser, "ClickTracking"));
                } else {
                    ui.eli(xmlPullParser);
                }
            }
        }
    }

    private static List<com.bytedance.sdk.openadsdk.core.du.DbA.Os> Os(XmlPullParser xmlPullParser) throws IOException, XmlPullParserException {
        return eli(xmlPullParser, false);
    }

    private static List<com.bytedance.sdk.openadsdk.core.du.DbA.Os> eli(XmlPullParser xmlPullParser, boolean z) throws IOException, XmlPullParserException {
        return ui.eli(xmlPullParser, "Tracking", z);
    }
}
