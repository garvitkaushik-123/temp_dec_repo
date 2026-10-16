package com.bytedance.sdk.openadsdk.core.du.eli.eli;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.du.aAs;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import io.bidmachine.iab.vast.tags.VastAttributes;
import io.bidmachine.iab.vast.tags.VastTagName;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes3.dex */
public class aGH {
    public static Set<aAs> eli(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        aAs eli;
        if (xmlPullParser == null) {
            return new HashSet();
        }
        HashSet hashSet = new HashSet();
        while (xmlPullParser.next() != 3) {
            if (xmlPullParser.getEventType() == 2) {
                if (VastTagName.VERIFICATION.equals(xmlPullParser.getName())) {
                    String attributeValue = xmlPullParser.getAttributeValue(ui.kb, VastAttributes.VENDOR);
                    String str = null;
                    String str2 = null;
                    String str3 = null;
                    while (true) {
                        if (xmlPullParser.getEventType() != 3 || !VastTagName.VERIFICATION.equals(xmlPullParser.getName())) {
                            xmlPullParser.next();
                            if (xmlPullParser.getEventType() == 2) {
                                String name = xmlPullParser.getName();
                                name.hashCode();
                                switch (name) {
                                    case "Tracking":
                                        if (!"verificationNotExecuted".equals(xmlPullParser.getAttributeValue(ui.kb, "event"))) {
                                            break;
                                        } else {
                                            str3 = ui.DbA(xmlPullParser, "Tracking");
                                            break;
                                        }
                                    case "JavaScriptResource":
                                        if (!CampaignEx.KEY_OMID.equals(xmlPullParser.getAttributeValue(ui.kb, VastAttributes.API_FRAMEWORK))) {
                                            break;
                                        } else {
                                            str = ui.DbA(xmlPullParser, VastTagName.JAVA_SCRIPT_RESOURCE);
                                            break;
                                        }
                                    case "VerificationParameters":
                                        str2 = ui.DbA(xmlPullParser, VastTagName.VERIFICATION_PARAMETERS);
                                        break;
                                }
                            }
                        } else if (!TextUtils.isEmpty(str) && (eli = aAs.eli(str, attributeValue, str2, str3)) != null) {
                            hashSet.add(eli);
                        }
                    }
                } else {
                    ui.eli(xmlPullParser);
                }
            }
        }
        return hashSet;
    }
}
