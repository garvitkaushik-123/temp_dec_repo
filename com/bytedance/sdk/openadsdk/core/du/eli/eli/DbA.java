package com.bytedance.sdk.openadsdk.core.du.eli.eli;

import android.content.Context;
import android.text.TextUtils;
import io.bidmachine.iab.vast.tags.VastTagName;
import java.io.IOException;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes3.dex */
public class DbA {
    public static com.bytedance.sdk.openadsdk.core.du.eli eli(Context context, XmlPullParser xmlPullParser, List<com.bytedance.sdk.openadsdk.core.du.DbA.Os> list, int i, double d) throws IOException, XmlPullParserException {
        String name;
        xmlPullParser.require(2, ui.kb, "InLine");
        com.bytedance.sdk.openadsdk.core.du.eli eliVar = new com.bytedance.sdk.openadsdk.core.du.eli();
        while (true) {
            if (xmlPullParser.next() != 3 || !"InLine".equals(xmlPullParser.getName())) {
                if (xmlPullParser.getEventType() == 2) {
                    name = xmlPullParser.getName();
                    name.hashCode();
                    switch (name) {
                        case "AdVerifications":
                            eliVar.eli(aGH.eli(xmlPullParser));
                            context = context;
                            break;
                        case "Creatives":
                            if (TextUtils.isEmpty(eliVar.kb()) || eliVar.Os() == null) {
                                while (xmlPullParser.next() != 3) {
                                    if (xmlPullParser.getEventType() == 2) {
                                        if ("Creative".equals(xmlPullParser.getName())) {
                                            eli(context, xmlPullParser, eliVar, i, d);
                                        } else {
                                            ui.eli(xmlPullParser);
                                        }
                                    }
                                }
                                context = context;
                                xmlPullParser = xmlPullParser;
                                i = i;
                                d = d;
                                break;
                            }
                            ui.eli(xmlPullParser);
                            context = context;
                            xmlPullParser = xmlPullParser;
                            i = i;
                            d = d;
                            break;
                        case "Description":
                            eliVar.DbA(ui.DbA(xmlPullParser, name));
                            break;
                        case "Error":
                            list.addAll(ui.eli(xmlPullParser, name));
                            break;
                        case "Extensions":
                            while (true) {
                                if (xmlPullParser.getEventType() == 3 && VastTagName.EXTENSIONS.equals(xmlPullParser.getName())) {
                                    context = context;
                                    xmlPullParser = xmlPullParser;
                                    i = i;
                                    d = d;
                                    break;
                                } else {
                                    xmlPullParser.next();
                                    if (xmlPullParser.getEventType() == 2 && "AdVerifications".equals(xmlPullParser.getName())) {
                                        eliVar.eli(aGH.eli(xmlPullParser));
                                    }
                                }
                            }
                            break;
                        case "AdTitle":
                            eliVar.eli(ui.DbA(xmlPullParser, name));
                            break;
                        case "Impression":
                            eliVar.eli().eli(ui.eli(xmlPullParser, name));
                            break;
                        default:
                            ui.eli(xmlPullParser);
                            context = context;
                            xmlPullParser = xmlPullParser;
                            i = i;
                            d = d;
                            break;
                    }
                }
            } else {
                eliVar.eli().aAs(list);
                return eliVar;
            }
        }
    }

    public static void eli(Context context, XmlPullParser xmlPullParser, com.bytedance.sdk.openadsdk.core.du.eli eliVar, int i, double d) throws IOException, XmlPullParserException {
        while (xmlPullParser.next() != 3) {
            if (xmlPullParser.getEventType() == 2) {
                if ("Linear".equals(xmlPullParser.getName()) && TextUtils.isEmpty(eliVar.kb())) {
                    Os.eli(xmlPullParser, eliVar, i, d);
                } else if ("CompanionAds".equals(xmlPullParser.getName()) && eliVar.Os() == null) {
                    eliVar.eli(eli.eli(context, xmlPullParser));
                } else {
                    ui.eli(xmlPullParser);
                }
            }
        }
    }
}
