package com.inmobi.media;

import android.text.TextUtils;
import android.webkit.URLUtil;
import androidx.datastore.preferences.protobuf.DescriptorProtos;
import com.inmobi.commons.core.configs.AdConfig;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.vungle.ads.internal.Constants;
import com.vungle.ads.internal.protos.Sdk;
import io.bidmachine.iab.vast.tags.VastAttributes;
import io.bidmachine.iab.vast.tags.VastTagName;
import java.io.IOException;
import java.io.StringReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/* loaded from: classes4.dex */
public final class Pe {
    public static final HashMap f = MapsKt.hashMapOf(TuplesKt.to("Error", "error"), TuplesKt.to("Impression", "Impression"), TuplesKt.to("ClickTracking", "click"), TuplesKt.to("creativeView", "creativeView"), TuplesKt.to("start", "start"), TuplesKt.to("firstQuartile", "firstQuartile"), TuplesKt.to(CampaignEx.JSON_NATIVE_VIDEO_MIDPOINT, CampaignEx.JSON_NATIVE_VIDEO_MIDPOINT), TuplesKt.to("thirdQuartile", "thirdQuartile"), TuplesKt.to(CampaignEx.JSON_NATIVE_VIDEO_COMPLETE, CampaignEx.JSON_NATIVE_VIDEO_COMPLETE), TuplesKt.to(CampaignEx.JSON_NATIVE_VIDEO_MUTE, CampaignEx.JSON_NATIVE_VIDEO_MUTE), TuplesKt.to(CampaignEx.JSON_NATIVE_VIDEO_UNMUTE, CampaignEx.JSON_NATIVE_VIDEO_UNMUTE), TuplesKt.to(CampaignEx.JSON_NATIVE_VIDEO_PAUSE, CampaignEx.JSON_NATIVE_VIDEO_PAUSE), TuplesKt.to(CampaignEx.JSON_NATIVE_VIDEO_RESUME, CampaignEx.JSON_NATIVE_VIDEO_RESUME), TuplesKt.to(Constants.TEMPLATE_TYPE_FULLSCREEN, Constants.TEMPLATE_TYPE_FULLSCREEN), TuplesKt.to("exitFullscreen", "exitFullscreen"), TuplesKt.to("closeEndCard", "closeEndCard"));

    /* renamed from: a, reason: collision with root package name */
    public final AdConfig.VastVideoConfig f2402a;
    public final InterfaceC2971z5 b;
    public final Ue c;
    public boolean d;
    public int e;

    public Pe(AdConfig.VastVideoConfig mVastVideoConfig, InterfaceC2971z5 interfaceC2971z5) {
        Intrinsics.checkNotNullParameter(mVastVideoConfig, "mVastVideoConfig");
        this.f2402a = mVastVideoConfig;
        this.b = interfaceC2971z5;
        this.c = new Ue(CollectionsKt.emptyList(), mVastVideoConfig);
    }

    public static boolean b(int i) {
        return i == 3;
    }

    public final Ue a(String str) {
        InterfaceC2971z5 interfaceC2971z5 = this.b;
        if (interfaceC2971z5 != null) {
            ((A5) interfaceC2971z5).c("Pe", I6.a("Pe", "TAG", "vastXML = ", str));
        }
        try {
        } catch (XmlPullParserException e) {
            c(100);
            S5 s5 = S5.f2425a;
            C2640f2 event = new C2640f2(e);
            Intrinsics.checkNotNullParameter(event, "event");
            S5.d.a(event);
        } catch (Exception e2) {
            c(DescriptorProtos.Edition.EDITION_LEGACY_VALUE);
            S5 s52 = S5.f2425a;
            S5.d.a(AbstractC2920w5.a(e2, "event"));
        }
        if (TextUtils.isEmpty(str)) {
            c(303);
            return this.c;
        }
        XmlPullParser newPullParser = XmlPullParserFactory.newInstance().newPullParser();
        newPullParser.setInput(new StringReader(str));
        String[] strArr = {"Wrapper", "InLine"};
        Intrinsics.checkNotNull(newPullParser);
        a(newPullParser, VastTagName.VAST);
        if (Intrinsics.areEqual(VastTagName.VAST, newPullParser.getName())) {
            a(newPullParser, "Ad");
            if (Intrinsics.areEqual("Ad", newPullParser.getName())) {
                a(newPullParser, strArr);
                if (Intrinsics.areEqual("InLine", newPullParser.getName())) {
                    c(newPullParser);
                } else if (Intrinsics.areEqual("Wrapper", newPullParser.getName())) {
                    f(newPullParser);
                } else {
                    InterfaceC2971z5 interfaceC2971z52 = this.b;
                    if (interfaceC2971z52 != null) {
                        Intrinsics.checkNotNullExpressionValue("Pe", "TAG");
                        ((A5) interfaceC2971z52).b("Pe", "VAST Schema validation error: InLine node or Wrapper node at appropriate hierarchy not found");
                    }
                    c(101);
                }
            } else {
                InterfaceC2971z5 interfaceC2971z53 = this.b;
                if (interfaceC2971z53 != null) {
                    Intrinsics.checkNotNullExpressionValue("Pe", "TAG");
                    ((A5) interfaceC2971z53).b("Pe", "VAST Schema validation error: Ad node at appropriate hierarchy not found");
                }
                c(303);
            }
        } else {
            InterfaceC2971z5 interfaceC2971z54 = this.b;
            if (interfaceC2971z54 != null) {
                Intrinsics.checkNotNullExpressionValue("Pe", "TAG");
                ((A5) interfaceC2971z54).b("Pe", "VAST Schema validation error: VAST node at appropriate hierarchy not found");
            }
            c(101);
        }
        return this.c;
    }

    public final void b(XmlPullParser xmlPullParser) {
        int d = d(xmlPullParser);
        while (true) {
            if (xmlPullParser.getName() != null && Intrinsics.areEqual(xmlPullParser.getName(), VastTagName.EXTENSIONS) && b(d)) {
                return;
            }
            if (xmlPullParser.getName() != null && !b(d)) {
                String name = xmlPullParser.getName();
                if (Intrinsics.areEqual(name, "CompanionAdTracking")) {
                    int d2 = d(xmlPullParser);
                    while (true) {
                        if (xmlPullParser.getName() == null || !Intrinsics.areEqual(xmlPullParser.getName(), "CompanionAdTracking") || !b(d2)) {
                            if (xmlPullParser.getName() != null && !b(d2) && Intrinsics.areEqual("TrackingEvents", xmlPullParser.getName())) {
                                e(xmlPullParser);
                            }
                            d2 = d(xmlPullParser);
                        }
                    }
                } else if (Intrinsics.areEqual(name, VastTagName.EXTENSION) && Intrinsics.areEqual(xmlPullParser.getAttributeValue(null, "type"), "AdVerifications")) {
                    a(xmlPullParser);
                }
            }
            d = d(xmlPullParser);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:248:0x0403  */
    /* JADX WARN: Removed duplicated region for block: B:567:0x0861  */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void c(XmlPullParser xmlPullParser) {
        String str;
        boolean z;
        String name;
        String str2;
        boolean z2;
        boolean z3;
        String str3;
        int i;
        char c;
        boolean z4;
        int i2;
        String name2;
        String str4;
        String name3;
        String text;
        String str5;
        String str6;
        int i3;
        String str7;
        AdConfig.BitRateConfig bitRateConfig;
        int i4;
        String str8;
        String str9;
        boolean z5;
        boolean z6;
        String str10;
        boolean z7;
        int i5;
        int i6;
        int i7;
        String str11;
        String str12;
        int i8;
        int i9;
        String name4;
        String str13;
        int i10;
        String str14;
        int i11;
        String str15;
        String str16;
        String str17 = "getAttributeValue(...)";
        int d = d(xmlPullParser);
        boolean z8 = false;
        boolean z9 = false;
        while (true) {
            int i12 = 101;
            if (xmlPullParser.getName() != null && Intrinsics.areEqual(xmlPullParser.getName(), "InLine") && b(d)) {
                if (z8 && z9) {
                    return;
                }
                InterfaceC2971z5 interfaceC2971z5 = this.b;
                if (interfaceC2971z5 != null) {
                    Intrinsics.checkNotNullExpressionValue("Pe", "TAG");
                    ((A5) interfaceC2971z5).b("Pe", "VAST Schema validation error: Creatives at appropriate hierarchy  not found");
                }
                c(101);
                return;
            }
            if (xmlPullParser.getName() != null && !b(d) && (name = xmlPullParser.getName()) != null) {
                char c2 = 4;
                switch (name.hashCode()) {
                    case -2077435339:
                        str = str17;
                        z = z9;
                        if (name.equals("AdVerifications")) {
                            a(xmlPullParser);
                        }
                        z9 = z;
                        d = d(xmlPullParser);
                        str17 = str;
                    case -1692490108:
                        String str18 = "Creatives";
                        if (name.equals("Creatives")) {
                            int d2 = d(xmlPullParser);
                            boolean z10 = false;
                            boolean z11 = false;
                            int i13 = 0;
                            while (true) {
                                if (xmlPullParser.getName() != null && Intrinsics.areEqual(xmlPullParser.getName(), str18) && b(d2)) {
                                    if (!z10) {
                                        InterfaceC2971z5 interfaceC2971z52 = this.b;
                                        if (interfaceC2971z52 != null) {
                                            Intrinsics.checkNotNullExpressionValue("Pe", "TAG");
                                            ((A5) interfaceC2971z52).b("Pe", "VAST Schema validation error: Creative at appropriate hierarchy not found");
                                        }
                                        c(i12);
                                    }
                                    if (!z11) {
                                        InterfaceC2971z5 interfaceC2971z53 = this.b;
                                        if (interfaceC2971z53 != null) {
                                            Intrinsics.checkNotNullExpressionValue("Pe", "TAG");
                                            ((A5) interfaceC2971z53).b("Pe", "VAST Schema validation error: Linear Node at appropriate hierarchy not found");
                                        }
                                        c(201);
                                    }
                                    if (z10 && z11 && i13 != 0) {
                                        str = str17;
                                        z8 = true;
                                        d = d(xmlPullParser);
                                        str17 = str;
                                    }
                                } else {
                                    if (xmlPullParser.getName() == null || b(d2) || (name2 = xmlPullParser.getName()) == null) {
                                        str2 = str17;
                                        z2 = z10;
                                        z3 = z9;
                                        str3 = str18;
                                        i = i12;
                                        c = c2;
                                        z4 = z11;
                                        i2 = i13;
                                    } else {
                                        int hashCode = name2.hashCode();
                                        int i14 = 1;
                                        if (hashCode != -2018804923) {
                                            if (hashCode == 1150879268) {
                                                String str19 = "CompanionAds";
                                                if (name2.equals("CompanionAds")) {
                                                    int d3 = d(xmlPullParser);
                                                    int i15 = 0;
                                                    while (true) {
                                                        if (xmlPullParser.getName() != null && Intrinsics.areEqual(xmlPullParser.getName(), str19) && b(d3)) {
                                                            int size = this.c.i.size();
                                                            if (size == 0 && this.d) {
                                                                a(604);
                                                            } else if (i15 > 0 && size == 0) {
                                                                a(600);
                                                            }
                                                        } else {
                                                            if (xmlPullParser.getName() != null) {
                                                                int i16 = d3;
                                                                String str20 = "Companion";
                                                                if (Intrinsics.areEqual("Companion", xmlPullParser.getName()) && !b(i16)) {
                                                                    int i17 = i15 + 1;
                                                                    str9 = str19;
                                                                    try {
                                                                        String attributeValue = xmlPullParser.getAttributeValue(null, "width");
                                                                        Intrinsics.checkNotNullExpressionValue(attributeValue, str17);
                                                                        i6 = Integer.parseInt(attributeValue);
                                                                        z5 = z10;
                                                                        try {
                                                                            String attributeValue2 = xmlPullParser.getAttributeValue(null, "height");
                                                                            Intrinsics.checkNotNullExpressionValue(attributeValue2, str17);
                                                                            i7 = Integer.parseInt(attributeValue2);
                                                                        } catch (Exception unused) {
                                                                            InterfaceC2971z5 interfaceC2971z54 = this.b;
                                                                            if (interfaceC2971z54 != null) {
                                                                                Intrinsics.checkNotNullExpressionValue("Pe", "TAG");
                                                                                ((A5) interfaceC2971z54).b("Pe", "Invalid width or height encountered for a companion and ignoring that.");
                                                                            }
                                                                            i7 = 0;
                                                                            if (i6 > 0) {
                                                                            }
                                                                            z7 = z11;
                                                                            i5 = i13;
                                                                            d3 = d(xmlPullParser);
                                                                            str19 = str9;
                                                                            z10 = z5;
                                                                            str17 = str17;
                                                                            z9 = z9;
                                                                            str18 = str18;
                                                                            i15 = i17;
                                                                            z11 = z7;
                                                                            i13 = i5;
                                                                            i14 = 1;
                                                                        }
                                                                    } catch (Exception unused2) {
                                                                        z5 = z10;
                                                                        i6 = 0;
                                                                    }
                                                                    if (i6 > 0 || i7 <= 0) {
                                                                        z7 = z11;
                                                                        i5 = i13;
                                                                        d3 = d(xmlPullParser);
                                                                        str19 = str9;
                                                                        z10 = z5;
                                                                        str17 = str17;
                                                                        z9 = z9;
                                                                        str18 = str18;
                                                                        i15 = i17;
                                                                        z11 = z7;
                                                                        i13 = i5;
                                                                        i14 = 1;
                                                                    } else {
                                                                        str8 = str17;
                                                                        Le companion = new Le(i6, i7, xmlPullParser.getAttributeValue(null, "ID"));
                                                                        int d4 = d(xmlPullParser);
                                                                        String str21 = null;
                                                                        while (true) {
                                                                            if (xmlPullParser.getName() != null && Intrinsics.areEqual(xmlPullParser.getName(), str20) && b(d4)) {
                                                                                z6 = z9;
                                                                                str10 = str18;
                                                                                i8 = i17;
                                                                                z7 = z11;
                                                                            } else {
                                                                                if (xmlPullParser.getName() != null && !b(d4) && (name4 = xmlPullParser.getName()) != null) {
                                                                                    str11 = str20;
                                                                                    str12 = str21;
                                                                                    z6 = z9;
                                                                                    str10 = str18;
                                                                                    switch (name4.hashCode()) {
                                                                                        case -375340334:
                                                                                            i8 = i17;
                                                                                            z7 = z11;
                                                                                            i9 = i13;
                                                                                            if (name4.equals("IFrameResource") && d(xmlPullParser) == 4) {
                                                                                                String text2 = xmlPullParser.getText();
                                                                                                if (!TextUtils.isEmpty(text2)) {
                                                                                                    Ke resource = new Ke((byte) 3, text2);
                                                                                                    Intrinsics.checkNotNullParameter(resource, "resource");
                                                                                                    companion.e.add(resource);
                                                                                                }
                                                                                            }
                                                                                            str21 = str12;
                                                                                            d4 = d(xmlPullParser);
                                                                                            str20 = str11;
                                                                                            z9 = z6;
                                                                                            str18 = str10;
                                                                                            i17 = i8;
                                                                                            z11 = z7;
                                                                                            i13 = i9;
                                                                                            i14 = 1;
                                                                                            break;
                                                                                        case -348198615:
                                                                                            i8 = i17;
                                                                                            z7 = z11;
                                                                                            i9 = i13;
                                                                                            if (name4.equals("CompanionClickThrough") && d(xmlPullParser) == 4) {
                                                                                                String text3 = xmlPullParser.getText();
                                                                                                if (text3 == null || text3.length() == 0) {
                                                                                                    str13 = null;
                                                                                                } else {
                                                                                                    int length = text3.length() - 1;
                                                                                                    boolean z12 = false;
                                                                                                    int i18 = 0;
                                                                                                    while (i18 <= length) {
                                                                                                        boolean z13 = Intrinsics.compare((int) text3.charAt(!z12 ? i18 : length), 32) <= 0;
                                                                                                        if (z12) {
                                                                                                            if (z13) {
                                                                                                                length--;
                                                                                                            } else {
                                                                                                                str13 = I7.a(length, 1, text3, i18);
                                                                                                            }
                                                                                                        } else if (z13) {
                                                                                                            i18++;
                                                                                                        } else {
                                                                                                            z12 = true;
                                                                                                        }
                                                                                                    }
                                                                                                    str13 = I7.a(length, 1, text3, i18);
                                                                                                }
                                                                                                if (URLUtil.isValidUrl(str13)) {
                                                                                                    companion.c = str13;
                                                                                                }
                                                                                            }
                                                                                            str21 = str12;
                                                                                            d4 = d(xmlPullParser);
                                                                                            str20 = str11;
                                                                                            z9 = z6;
                                                                                            str18 = str10;
                                                                                            i17 = i8;
                                                                                            z11 = z7;
                                                                                            i13 = i9;
                                                                                            i14 = 1;
                                                                                            break;
                                                                                        case 611554000:
                                                                                            i8 = i17;
                                                                                            z7 = z11;
                                                                                            if (name4.equals("TrackingEvents")) {
                                                                                                int d5 = d(xmlPullParser);
                                                                                                while (true) {
                                                                                                    if (xmlPullParser.getName() == null || !Intrinsics.areEqual(xmlPullParser.getName(), "TrackingEvents") || !b(d5)) {
                                                                                                        if (Intrinsics.areEqual("Tracking", xmlPullParser.getName()) && !b(d5)) {
                                                                                                            int attributeCount = xmlPullParser.getAttributeCount();
                                                                                                            int i19 = 0;
                                                                                                            while (true) {
                                                                                                                if (i19 < attributeCount) {
                                                                                                                    if (Intrinsics.areEqual(xmlPullParser.getAttributeName(i19), "event")) {
                                                                                                                        String attributeValue3 = xmlPullParser.getAttributeValue(i19);
                                                                                                                        if (d(xmlPullParser) == 4) {
                                                                                                                            String text4 = xmlPullParser.getText();
                                                                                                                            if (text4 != null) {
                                                                                                                                int length2 = text4.length() - 1;
                                                                                                                                int i20 = 0;
                                                                                                                                boolean z14 = false;
                                                                                                                                while (true) {
                                                                                                                                    if (i20 <= length2) {
                                                                                                                                        boolean z15 = z14;
                                                                                                                                        i10 = i13;
                                                                                                                                        boolean z16 = Intrinsics.compare((int) text4.charAt(!z14 ? i20 : length2), 32) <= 0;
                                                                                                                                        if (z15) {
                                                                                                                                            if (z16) {
                                                                                                                                                length2--;
                                                                                                                                            }
                                                                                                                                        } else if (z16) {
                                                                                                                                            i20++;
                                                                                                                                        } else {
                                                                                                                                            i13 = i10;
                                                                                                                                            z14 = true;
                                                                                                                                        }
                                                                                                                                        z14 = z15;
                                                                                                                                        i13 = i10;
                                                                                                                                    } else {
                                                                                                                                        i10 = i13;
                                                                                                                                    }
                                                                                                                                }
                                                                                                                                str14 = I7.a(length2, 1, text4, i20);
                                                                                                                            } else {
                                                                                                                                i10 = i13;
                                                                                                                                str14 = null;
                                                                                                                            }
                                                                                                                            if (URLUtil.isValidUrl(str14)) {
                                                                                                                                String str22 = (String) f.get(attributeValue3);
                                                                                                                                if (str22 == null) {
                                                                                                                                    str22 = "unknown";
                                                                                                                                }
                                                                                                                                String text5 = xmlPullParser.getText();
                                                                                                                                Intrinsics.checkNotNullExpressionValue(text5, "getText(...)");
                                                                                                                                U8 tracker = new U8(text5, 0, str22, null);
                                                                                                                                Intrinsics.checkNotNullParameter(tracker, "tracker");
                                                                                                                                companion.f.add(tracker);
                                                                                                                            } else {
                                                                                                                                InterfaceC2971z5 interfaceC2971z55 = this.b;
                                                                                                                                if (interfaceC2971z55 != null) {
                                                                                                                                    Intrinsics.checkNotNullExpressionValue("Pe", "TAG");
                                                                                                                                    ((A5) interfaceC2971z55).b("Pe", "Malformed URL: " + text4 + "; Discarding this tracker");
                                                                                                                                }
                                                                                                                            }
                                                                                                                        }
                                                                                                                    } else {
                                                                                                                        i19++;
                                                                                                                    }
                                                                                                                }
                                                                                                            }
                                                                                                        }
                                                                                                        i10 = i13;
                                                                                                        d5 = d(xmlPullParser);
                                                                                                        i13 = i10;
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                            i9 = i13;
                                                                                            str21 = str12;
                                                                                            d4 = d(xmlPullParser);
                                                                                            str20 = str11;
                                                                                            z9 = z6;
                                                                                            str18 = str10;
                                                                                            i17 = i8;
                                                                                            z11 = z7;
                                                                                            i13 = i9;
                                                                                            i14 = 1;
                                                                                            break;
                                                                                        case 676623548:
                                                                                            i8 = i17;
                                                                                            z7 = z11;
                                                                                            if (name4.equals("StaticResource")) {
                                                                                                String attributeValue4 = xmlPullParser.getAttributeValue(null, "creativeType");
                                                                                                if (d(xmlPullParser) == 4) {
                                                                                                    String text6 = xmlPullParser.getText();
                                                                                                    if (text6 == null || text6.length() == 0) {
                                                                                                        i11 = 1;
                                                                                                        str15 = null;
                                                                                                    } else {
                                                                                                        int length3 = text6.length() - 1;
                                                                                                        int i21 = 0;
                                                                                                        boolean z17 = false;
                                                                                                        while (i21 <= length3) {
                                                                                                            boolean z18 = Intrinsics.compare((int) text6.charAt(!z17 ? i21 : length3), 32) <= 0;
                                                                                                            if (z17) {
                                                                                                                if (z18) {
                                                                                                                    length3--;
                                                                                                                } else {
                                                                                                                    i11 = 1;
                                                                                                                    str15 = I7.a(length3, 1, text6, i21);
                                                                                                                }
                                                                                                            } else if (z18) {
                                                                                                                i21++;
                                                                                                            } else {
                                                                                                                z17 = true;
                                                                                                            }
                                                                                                        }
                                                                                                        i11 = 1;
                                                                                                        str15 = I7.a(length3, 1, text6, i21);
                                                                                                    }
                                                                                                } else {
                                                                                                    i11 = 1;
                                                                                                    str15 = str12;
                                                                                                }
                                                                                                if (attributeValue4 != null) {
                                                                                                    int length4 = attributeValue4.length() - i11;
                                                                                                    int i22 = 0;
                                                                                                    boolean z19 = false;
                                                                                                    while (i22 <= length4) {
                                                                                                        boolean z20 = Intrinsics.compare((int) attributeValue4.charAt(!z19 ? i22 : length4), 32) <= 0;
                                                                                                        if (z19) {
                                                                                                            if (z20) {
                                                                                                                length4--;
                                                                                                            } else if (attributeValue4.subSequence(i22, length4 + 1).toString().length() > 0) {
                                                                                                                int size2 = Le.h.size();
                                                                                                                int i23 = 0;
                                                                                                                while (true) {
                                                                                                                    if (i23 >= size2) {
                                                                                                                        this.d = true;
                                                                                                                    } else if (StringsKt.equals(attributeValue4, (String) Le.h.get(i23), true)) {
                                                                                                                        Ke resource2 = new Ke((byte) 1, str15);
                                                                                                                        Intrinsics.checkNotNullParameter(resource2, "resource");
                                                                                                                        companion.e.add(resource2);
                                                                                                                    } else {
                                                                                                                        i23++;
                                                                                                                    }
                                                                                                                }
                                                                                                            }
                                                                                                        } else if (z20) {
                                                                                                            i22++;
                                                                                                        } else {
                                                                                                            z19 = true;
                                                                                                        }
                                                                                                    }
                                                                                                    if (attributeValue4.subSequence(i22, length4 + 1).toString().length() > 0) {
                                                                                                    }
                                                                                                }
                                                                                                str21 = str15;
                                                                                                i9 = i13;
                                                                                                d4 = d(xmlPullParser);
                                                                                                str20 = str11;
                                                                                                z9 = z6;
                                                                                                str18 = str10;
                                                                                                i17 = i8;
                                                                                                z11 = z7;
                                                                                                i13 = i9;
                                                                                                i14 = 1;
                                                                                            } else {
                                                                                                i9 = i13;
                                                                                                str21 = str12;
                                                                                                d4 = d(xmlPullParser);
                                                                                                str20 = str11;
                                                                                                z9 = z6;
                                                                                                str18 = str10;
                                                                                                i17 = i8;
                                                                                                z11 = z7;
                                                                                                i13 = i9;
                                                                                                i14 = 1;
                                                                                            }
                                                                                            break;
                                                                                        case 1877773523:
                                                                                            if (name4.equals("CompanionClickTracking") && d(xmlPullParser) == 4) {
                                                                                                String text7 = xmlPullParser.getText();
                                                                                                if (text7 == null || text7.length() == 0) {
                                                                                                    i8 = i17;
                                                                                                    z7 = z11;
                                                                                                    str16 = null;
                                                                                                } else {
                                                                                                    int length5 = text7.length() - 1;
                                                                                                    int i24 = 0;
                                                                                                    int i25 = 0;
                                                                                                    while (true) {
                                                                                                        i8 = i17;
                                                                                                        if (i24 <= length5) {
                                                                                                            z7 = z11;
                                                                                                            int i26 = Intrinsics.compare((int) text7.charAt(i25 == 0 ? i24 : length5), 32) <= 0 ? i14 : 0;
                                                                                                            if (i25 == 0) {
                                                                                                                if (i26 == 0) {
                                                                                                                    i25 = i14;
                                                                                                                } else {
                                                                                                                    i24++;
                                                                                                                }
                                                                                                            } else if (i26 != 0) {
                                                                                                                length5--;
                                                                                                            }
                                                                                                            i17 = i8;
                                                                                                            z11 = z7;
                                                                                                        } else {
                                                                                                            z7 = z11;
                                                                                                        }
                                                                                                    }
                                                                                                    str16 = I7.a(length5, i14, text7, i24);
                                                                                                }
                                                                                                if (!URLUtil.isValidUrl(str16)) {
                                                                                                    InterfaceC2971z5 interfaceC2971z56 = this.b;
                                                                                                    if (interfaceC2971z56 != null) {
                                                                                                        Intrinsics.checkNotNullExpressionValue("Pe", "TAG");
                                                                                                        ((A5) interfaceC2971z56).b("Pe", "Malformed URL: " + str16 + "; Discarding this tracker");
                                                                                                        break;
                                                                                                    }
                                                                                                } else {
                                                                                                    Intrinsics.checkNotNull(str16);
                                                                                                    U8 tracker2 = new U8(str16, 0, "click", null);
                                                                                                    Intrinsics.checkNotNullParameter(tracker2, "tracker");
                                                                                                    companion.f.add(tracker2);
                                                                                                    str21 = str16;
                                                                                                    i9 = i13;
                                                                                                    d4 = d(xmlPullParser);
                                                                                                    str20 = str11;
                                                                                                    z9 = z6;
                                                                                                    str18 = str10;
                                                                                                    i17 = i8;
                                                                                                    z11 = z7;
                                                                                                    i13 = i9;
                                                                                                    i14 = 1;
                                                                                                }
                                                                                            }
                                                                                            break;
                                                                                        case 1928285401:
                                                                                            if (name4.equals("HTMLResource") && d(xmlPullParser) == 4) {
                                                                                                String text8 = xmlPullParser.getText();
                                                                                                if (!TextUtils.isEmpty(text8)) {
                                                                                                    Ke resource3 = new Ke((byte) 2, text8);
                                                                                                    Intrinsics.checkNotNullParameter(resource3, "resource");
                                                                                                    companion.e.add(resource3);
                                                                                                    break;
                                                                                                }
                                                                                            }
                                                                                            break;
                                                                                    }
                                                                                } else {
                                                                                    str11 = str20;
                                                                                    str12 = str21;
                                                                                    z6 = z9;
                                                                                    str10 = str18;
                                                                                }
                                                                                i8 = i17;
                                                                                z7 = z11;
                                                                                i9 = i13;
                                                                                str21 = str12;
                                                                                d4 = d(xmlPullParser);
                                                                                str20 = str11;
                                                                                z9 = z6;
                                                                                str18 = str10;
                                                                                i17 = i8;
                                                                                z11 = z7;
                                                                                i13 = i9;
                                                                                i14 = 1;
                                                                            }
                                                                        }
                                                                        if (companion.e.isEmpty()) {
                                                                            d3 = i16;
                                                                            str19 = str9;
                                                                            z10 = z5;
                                                                            str17 = str8;
                                                                            z9 = z6;
                                                                            str18 = str10;
                                                                            i15 = i8;
                                                                            z11 = z7;
                                                                            i14 = 1;
                                                                        } else {
                                                                            Ue ue = this.c;
                                                                            ue.getClass();
                                                                            Intrinsics.checkNotNullParameter(companion, "companion");
                                                                            ue.i.add(companion);
                                                                            i5 = i13;
                                                                            i15 = i8;
                                                                            d3 = d(xmlPullParser);
                                                                            str19 = str9;
                                                                            z10 = z5;
                                                                            str17 = str8;
                                                                            z9 = z6;
                                                                            str18 = str10;
                                                                            z11 = z7;
                                                                            i13 = i5;
                                                                            i14 = 1;
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                            str8 = str17;
                                                            str9 = str19;
                                                            z5 = z10;
                                                            z6 = z9;
                                                            str10 = str18;
                                                            z7 = z11;
                                                            i5 = i13;
                                                            d3 = d(xmlPullParser);
                                                            str19 = str9;
                                                            z10 = z5;
                                                            str17 = str8;
                                                            z9 = z6;
                                                            str18 = str10;
                                                            z11 = z7;
                                                            i13 = i5;
                                                            i14 = 1;
                                                        }
                                                    }
                                                }
                                            } else if (hashCode == 1885066191 && name2.equals("Creative")) {
                                                str2 = str17;
                                                z3 = z9;
                                                str3 = str18;
                                                z4 = z11;
                                                z10 = true;
                                                i = 101;
                                                c = 4;
                                            }
                                            str2 = str17;
                                            z2 = z10;
                                            z3 = z9;
                                            str3 = str18;
                                            z4 = z11;
                                            i2 = i13;
                                            i = 101;
                                            c = 4;
                                            z10 = z2;
                                            i13 = i2;
                                        } else {
                                            str2 = str17;
                                            z2 = z10;
                                            z3 = z9;
                                            str3 = str18;
                                            z4 = z11;
                                            i2 = i13;
                                            String str23 = null;
                                            int i27 = 0;
                                            String str24 = "Linear";
                                            if (name2.equals("Linear")) {
                                                int d6 = d(xmlPullParser);
                                                boolean z21 = false;
                                                int i28 = 0;
                                                boolean z22 = false;
                                                while (true) {
                                                    if (xmlPullParser.getName() != null && Intrinsics.areEqual(xmlPullParser.getName(), str24) && b(d6)) {
                                                        if (!z22 || !z21) {
                                                            InterfaceC2971z5 interfaceC2971z57 = this.b;
                                                            if (interfaceC2971z57 != null) {
                                                                Intrinsics.checkNotNullExpressionValue("Pe", "TAG");
                                                                ((A5) interfaceC2971z57).b("Pe", "VAST Schema Validation Error.Duration tag not found");
                                                            }
                                                            c(101);
                                                        }
                                                        if (z22 && z21 && i28 != 0) {
                                                            i = 101;
                                                            c = 4;
                                                            i13 = 1;
                                                        } else {
                                                            i13 = i27;
                                                            i = 101;
                                                            c = 4;
                                                        }
                                                    } else {
                                                        if (xmlPullParser.getName() != null && !b(d6) && (name3 = xmlPullParser.getName()) != null) {
                                                            int hashCode2 = name3.hashCode();
                                                            if (hashCode2 == -2049897434) {
                                                                str4 = str24;
                                                                if (name3.equals("VideoClicks")) {
                                                                    a(xmlPullParser, true);
                                                                    d6 = d(xmlPullParser);
                                                                    str24 = str4;
                                                                    str23 = null;
                                                                    i27 = 0;
                                                                }
                                                            } else if (hashCode2 == -1927368268) {
                                                                str4 = str24;
                                                                if (name3.equals("Duration")) {
                                                                    c = 4;
                                                                    if (d(xmlPullParser) == 4) {
                                                                        text = xmlPullParser.getText();
                                                                        if (!TextUtils.isEmpty(text)) {
                                                                            Intrinsics.checkNotNull(text);
                                                                            if (new Regex("^(?:[01]\\d|2[0-3]):[0-5]\\d:[0-5]\\d(?:\\.\\d{1,3})?$").matches(text)) {
                                                                                this.c.g = text;
                                                                                z22 = true;
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            } else if (hashCode2 == -385055469) {
                                                                String str25 = "MediaFiles";
                                                                if (name3.equals("MediaFiles")) {
                                                                    int d7 = d(xmlPullParser);
                                                                    int i29 = i27;
                                                                    while (true) {
                                                                        if (xmlPullParser.getName() != null && Intrinsics.areEqual(xmlPullParser.getName(), str25) && b(d7)) {
                                                                            if (i29 == 0) {
                                                                                c(401);
                                                                            } else if (this.c.e.isEmpty()) {
                                                                                c(403);
                                                                            } else {
                                                                                i4 = 1;
                                                                                str4 = str24;
                                                                                i28 = i4;
                                                                                z21 = true;
                                                                            }
                                                                            i4 = i27;
                                                                            str4 = str24;
                                                                            i28 = i4;
                                                                            z21 = true;
                                                                        } else {
                                                                            if (xmlPullParser.getName() == null || !Intrinsics.areEqual("MediaFile", xmlPullParser.getName()) || b(d7)) {
                                                                                str5 = str24;
                                                                                str6 = str25;
                                                                            } else {
                                                                                AdConfig.BitRateConfig bitRate = this.f2402a.getBitRate();
                                                                                int attributeCount2 = xmlPullParser.getAttributeCount();
                                                                                String str26 = str23;
                                                                                String str27 = str26;
                                                                                int i30 = i27;
                                                                                int i31 = i30;
                                                                                while (i31 < attributeCount2) {
                                                                                    String attributeName = xmlPullParser.getAttributeName(i31);
                                                                                    String str28 = str24;
                                                                                    if (attributeName != null) {
                                                                                        int hashCode3 = attributeName.hashCode();
                                                                                        bitRateConfig = bitRate;
                                                                                        if (hashCode3 != -102270099) {
                                                                                            if (hashCode3 != 3575610) {
                                                                                                if (hashCode3 == 823466996 && attributeName.equals("delivery")) {
                                                                                                    str26 = xmlPullParser.getAttributeValue(i31);
                                                                                                }
                                                                                            } else if (attributeName.equals("type")) {
                                                                                                str27 = xmlPullParser.getAttributeValue(i31);
                                                                                            }
                                                                                        } else if (attributeName.equals(VastAttributes.BITRATE)) {
                                                                                            try {
                                                                                                Integer valueOf = Integer.valueOf(xmlPullParser.getAttributeValue(i31));
                                                                                                Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(...)");
                                                                                                i30 = valueOf.intValue();
                                                                                            } catch (Exception unused3) {
                                                                                                InterfaceC2971z5 interfaceC2971z58 = this.b;
                                                                                                if (interfaceC2971z58 != null) {
                                                                                                    Intrinsics.checkNotNullExpressionValue("Pe", "TAG");
                                                                                                    ((A5) interfaceC2971z58).b("Pe", "Invalid value found for BitRate.");
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    } else {
                                                                                        bitRateConfig = bitRate;
                                                                                    }
                                                                                    i31++;
                                                                                    str24 = str28;
                                                                                    bitRate = bitRateConfig;
                                                                                }
                                                                                str5 = str24;
                                                                                AdConfig.BitRateConfig bitRateConfig2 = bitRate;
                                                                                int d8 = d(xmlPullParser);
                                                                                if (d8 == 4) {
                                                                                    String text9 = xmlPullParser.getText();
                                                                                    if (text9 == null || text9.length() == 0) {
                                                                                        i3 = d8;
                                                                                        str6 = str25;
                                                                                        str7 = null;
                                                                                    } else {
                                                                                        int length6 = text9.length() - 1;
                                                                                        int i32 = 0;
                                                                                        boolean z23 = false;
                                                                                        while (true) {
                                                                                            i3 = d8;
                                                                                            if (i32 <= length6) {
                                                                                                str6 = str25;
                                                                                                boolean z24 = Intrinsics.compare((int) text9.charAt(!z23 ? i32 : length6), 32) <= 0;
                                                                                                if (z23) {
                                                                                                    if (z24) {
                                                                                                        length6--;
                                                                                                    }
                                                                                                } else if (z24) {
                                                                                                    i32++;
                                                                                                } else {
                                                                                                    d8 = i3;
                                                                                                    str25 = str6;
                                                                                                    z23 = true;
                                                                                                }
                                                                                                d8 = i3;
                                                                                                str25 = str6;
                                                                                            } else {
                                                                                                str6 = str25;
                                                                                            }
                                                                                        }
                                                                                        str7 = I7.a(length6, 1, text9, i32);
                                                                                    }
                                                                                    if (URLUtil.isValidUrl(str7) && ((!bitRateConfig2.getBitrate_mandatory() || i30 > 0) && str26 != null)) {
                                                                                        int length7 = str26.length() - 1;
                                                                                        int i33 = 0;
                                                                                        boolean z25 = false;
                                                                                        while (i33 <= length7) {
                                                                                            boolean z26 = Intrinsics.compare((int) str26.charAt(!z25 ? i33 : length7), 32) <= 0;
                                                                                            if (z25) {
                                                                                                if (z26) {
                                                                                                    length7--;
                                                                                                } else {
                                                                                                    boolean z27 = true;
                                                                                                    if (StringsKt.equals(I7.a(length7, 1, str26, i33), "Progressive", true)) {
                                                                                                        List<String> allowedContentType = this.f2402a.getAllowedContentType();
                                                                                                        if (str27 != null) {
                                                                                                            int size3 = allowedContentType.size();
                                                                                                            int i34 = 0;
                                                                                                            while (i34 < size3) {
                                                                                                                if (StringsKt.equals(str27, allowedContentType.get(i34), z27)) {
                                                                                                                    Ue ue2 = this.c;
                                                                                                                    Intrinsics.checkNotNull(str7);
                                                                                                                    Me vastMediaFile = new Me(str7, i30);
                                                                                                                    ue2.getClass();
                                                                                                                    Intrinsics.checkNotNullParameter(vastMediaFile, "vastMediaFile");
                                                                                                                    ue2.e.add(vastMediaFile);
                                                                                                                }
                                                                                                                i34++;
                                                                                                                z27 = true;
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            } else if (z26) {
                                                                                                i33++;
                                                                                            } else {
                                                                                                z25 = true;
                                                                                            }
                                                                                        }
                                                                                        boolean z272 = true;
                                                                                        if (StringsKt.equals(I7.a(length7, 1, str26, i33), "Progressive", true)) {
                                                                                        }
                                                                                    }
                                                                                    str24 = str5;
                                                                                    d7 = i3;
                                                                                    str25 = str6;
                                                                                    i29 = 1;
                                                                                    str23 = null;
                                                                                    i27 = 0;
                                                                                } else {
                                                                                    str6 = str25;
                                                                                }
                                                                                i29 = 1;
                                                                            }
                                                                            d7 = d(xmlPullParser);
                                                                            str24 = str5;
                                                                            str25 = str6;
                                                                            str23 = null;
                                                                            i27 = 0;
                                                                        }
                                                                    }
                                                                }
                                                            } else if (hashCode2 == 611554000 && name3.equals("TrackingEvents")) {
                                                                e(xmlPullParser);
                                                            }
                                                            d6 = d(xmlPullParser);
                                                            str24 = str4;
                                                            str23 = null;
                                                            i27 = 0;
                                                        }
                                                        str4 = str24;
                                                        d6 = d(xmlPullParser);
                                                        str24 = str4;
                                                        str23 = null;
                                                        i27 = 0;
                                                    }
                                                }
                                                InterfaceC2971z5 interfaceC2971z59 = this.b;
                                                if (interfaceC2971z59 != null) {
                                                    Intrinsics.checkNotNullExpressionValue("Pe", "TAG");
                                                    ((A5) interfaceC2971z59).b("Pe", "VAST Schema Validation Error. " + text + " Media Duration invalid.");
                                                }
                                                i = 101;
                                                c(101);
                                                i13 = 0;
                                                z10 = z2;
                                                z4 = true;
                                            } else {
                                                i = 101;
                                                c = 4;
                                            }
                                        }
                                        d2 = d(xmlPullParser);
                                        i12 = i;
                                        c2 = c;
                                        str17 = str2;
                                        z9 = z3;
                                        str18 = str3;
                                        z11 = z4;
                                    }
                                    z10 = z2;
                                    i13 = i2;
                                    d2 = d(xmlPullParser);
                                    i12 = i;
                                    c2 = c;
                                    str17 = str2;
                                    z9 = z3;
                                    str18 = str3;
                                    z11 = z4;
                                }
                            }
                        }
                        break;
                    case 67232232:
                        if (name.equals("Error")) {
                            d(xmlPullParser);
                            String text10 = xmlPullParser.getText();
                            Intrinsics.checkNotNullExpressionValue(text10, "getText(...)");
                            a("error", text10);
                            break;
                        }
                        break;
                    case 184043572:
                        if (name.equals(VastTagName.EXTENSIONS)) {
                            b(xmlPullParser);
                            break;
                        }
                        break;
                    case 2114088489:
                        if (name.equals("Impression")) {
                            int d9 = d(xmlPullParser);
                            if (d9 != 4) {
                                InterfaceC2971z5 interfaceC2971z510 = this.b;
                                if (interfaceC2971z510 != null) {
                                    ((A5) interfaceC2971z510).b("Pe", X8.a("Pe", "TAG", "VAST Schema Error: VastAdTagUri at appropriate hierarchy not found or invalid - ", d9));
                                    break;
                                }
                            } else {
                                String text11 = xmlPullParser.getText();
                                Intrinsics.checkNotNullExpressionValue(text11, "getText(...)");
                                a("Impression", text11);
                                str = str17;
                                z9 = true;
                                d = d(xmlPullParser);
                                str17 = str;
                            }
                        }
                        break;
                }
                return;
            }
            str = str17;
            z = z9;
            z9 = z;
            d = d(xmlPullParser);
            str17 = str;
        }
    }

    public final int d(XmlPullParser xmlPullParser) {
        try {
            return xmlPullParser.next();
        } catch (IOException unused) {
            InterfaceC2971z5 interfaceC2971z5 = this.b;
            if (interfaceC2971z5 == null) {
                return -1;
            }
            Intrinsics.checkNotNullExpressionValue("Pe", "TAG");
            ((A5) interfaceC2971z5).b("Pe", "Parsing failed.");
            return -1;
        } catch (XmlPullParserException unused2) {
            InterfaceC2971z5 interfaceC2971z52 = this.b;
            if (interfaceC2971z52 == null) {
                return -1;
            }
            Intrinsics.checkNotNullExpressionValue("Pe", "TAG");
            ((A5) interfaceC2971z52).b("Pe", "VAST Schema validation error: VAST node at appropriate hierarchy not found.");
            return -1;
        }
    }

    public final void e(XmlPullParser xmlPullParser) {
        int d = d(xmlPullParser);
        while (true) {
            if (xmlPullParser.getName() != null && Intrinsics.areEqual(xmlPullParser.getName(), "TrackingEvents") && b(d)) {
                return;
            }
            if (xmlPullParser.getName() != null && Intrinsics.areEqual("Tracking", xmlPullParser.getName()) && !b(d)) {
                int attributeCount = xmlPullParser.getAttributeCount();
                int i = 0;
                while (true) {
                    if (i >= attributeCount) {
                        break;
                    }
                    if (Intrinsics.areEqual(xmlPullParser.getAttributeName(i), "event")) {
                        String attributeValue = xmlPullParser.getAttributeValue(i);
                        if (d(xmlPullParser) == 4) {
                            HashMap hashMap = f;
                            if (hashMap.containsKey(attributeValue)) {
                                Object obj = hashMap.get(attributeValue);
                                Intrinsics.checkNotNull(obj);
                                String text = xmlPullParser.getText();
                                Intrinsics.checkNotNullExpressionValue(text, "getText(...)");
                                a((String) obj, text);
                            }
                        }
                    } else {
                        i++;
                    }
                }
            }
            d = d(xmlPullParser);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:137:0x01b3, code lost:
    
        continue;
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void f(XmlPullParser xmlPullParser) {
        String name;
        String str;
        int i = this.e + 1;
        this.e = i;
        if (i > this.f2402a.getMaxWrapperLimit()) {
            InterfaceC2971z5 interfaceC2971z5 = this.b;
            if (interfaceC2971z5 != null) {
                Intrinsics.checkNotNullExpressionValue("Pe", "TAG");
                ((A5) interfaceC2971z5).b("Pe", "Schema Validation Error:Max VAST wrapper limit exceeded");
            }
            c(Sdk.SDKError.Reason.INVALID_IFA_STATUS_VALUE);
            return;
        }
        int d = d(xmlPullParser);
        boolean z = false;
        boolean z2 = false;
        while (true) {
            if (xmlPullParser.getName() != null && Intrinsics.areEqual(xmlPullParser.getName(), "Wrapper") && b(d)) {
                if (z && z2) {
                    return;
                }
                InterfaceC2971z5 interfaceC2971z52 = this.b;
                if (interfaceC2971z52 != null) {
                    Intrinsics.checkNotNullExpressionValue("Pe", "TAG");
                    ((A5) interfaceC2971z52).b("Pe", "VAST Wrapper Error: VastAdTagUri at appropriate hierarchy not found or invalid");
                }
                c(101);
                return;
            }
            if (xmlPullParser.getName() != null && !b(d) && (name = xmlPullParser.getName()) != null) {
                switch (name.hashCode()) {
                    case -2077435339:
                        if (!name.equals("AdVerifications")) {
                            break;
                        } else {
                            a(xmlPullParser);
                            break;
                        }
                    case -2049897434:
                        if (!name.equals("VideoClicks")) {
                            break;
                        } else {
                            a(xmlPullParser, false);
                            break;
                        }
                    case -587420703:
                        if (!name.equals("VASTAdTagURI")) {
                            continue;
                        } else {
                            if (d(xmlPullParser) != 4) {
                                InterfaceC2971z5 interfaceC2971z53 = this.b;
                                if (interfaceC2971z53 != null) {
                                    Intrinsics.checkNotNullExpressionValue("Pe", "TAG");
                                    ((A5) interfaceC2971z53).b("Pe", "VAST Wrapper Error: VastAdTagUri at appropriate hierarchy not found or invalid");
                                }
                                c(101);
                                return;
                            }
                            String text = xmlPullParser.getText();
                            if (text == null || text.length() == 0) {
                                str = null;
                            } else {
                                Intrinsics.checkNotNull(text);
                                int length = text.length() - 1;
                                int i2 = 0;
                                boolean z3 = false;
                                while (i2 <= length) {
                                    boolean z4 = Intrinsics.compare((int) text.charAt(!z3 ? i2 : length), 32) <= 0;
                                    if (z3) {
                                        if (z4) {
                                            length--;
                                        } else {
                                            str = I7.a(length, 1, text, i2);
                                        }
                                    } else if (z4) {
                                        i2++;
                                    } else {
                                        z3 = true;
                                    }
                                }
                                str = I7.a(length, 1, text, i2);
                            }
                            if (str != null) {
                                if (URLUtil.isValidUrl(str)) {
                                    N9 mRequest = new N9(str, this.b);
                                    mRequest.t = false;
                                    mRequest.u = false;
                                    mRequest.x = false;
                                    mRequest.r = true;
                                    Intrinsics.checkNotNullParameter(mRequest, "mRequest");
                                    P9 b = mRequest.b();
                                    if (b.b()) {
                                        c(Sdk.SDKError.Reason.MRAID_ERROR_VALUE);
                                    } else {
                                        a(b.a());
                                    }
                                } else {
                                    c(300);
                                }
                                if (this.c.l == 0) {
                                    z = true;
                                    break;
                                } else {
                                    return;
                                }
                            } else {
                                InterfaceC2971z5 interfaceC2971z54 = this.b;
                                if (interfaceC2971z54 != null) {
                                    Intrinsics.checkNotNullExpressionValue("Pe", "TAG");
                                    ((A5) interfaceC2971z54).b("Pe", "VAST Wrapper Error: VastAdTagUri at appropriate hierarchy not found or invalid");
                                }
                                c(300);
                                return;
                            }
                        }
                    case 67232232:
                        if (name.equals("Error") && d(xmlPullParser) == 4) {
                            String text2 = xmlPullParser.getText();
                            Intrinsics.checkNotNullExpressionValue(text2, "getText(...)");
                            a("error", text2);
                            break;
                        }
                        break;
                    case 184043572:
                        if (!name.equals(VastTagName.EXTENSIONS)) {
                            break;
                        } else {
                            b(xmlPullParser);
                            break;
                        }
                    case 611554000:
                        if (!name.equals("TrackingEvents")) {
                            break;
                        } else {
                            e(xmlPullParser);
                            break;
                        }
                    case 2114088489:
                        if (!name.equals("Impression")) {
                            break;
                        } else {
                            int d2 = d(xmlPullParser);
                            if (d2 != 4) {
                                InterfaceC2971z5 interfaceC2971z55 = this.b;
                                if (interfaceC2971z55 == null) {
                                    break;
                                } else {
                                    ((A5) interfaceC2971z55).b("Pe", X8.a("Pe", "TAG", "VAST Wrapper Error: VastAdTagUri at appropriate hierarchy not found or invalid - ", d2));
                                    break;
                                }
                            } else {
                                String text3 = xmlPullParser.getText();
                                Intrinsics.checkNotNullExpressionValue(text3, "getText(...)");
                                a("Impression", text3);
                                z2 = true;
                                break;
                            }
                        }
                }
            }
            d = d(xmlPullParser);
        }
    }

    public final void a(XmlPullParser xmlPullParser, String str) {
        InterfaceC2971z5 interfaceC2971z5 = this.b;
        if (interfaceC2971z5 != null) {
            Intrinsics.checkNotNullExpressionValue("Pe", "TAG");
            ((A5) interfaceC2971z5).c("Pe", "name=".concat(str));
        }
        int i = 0;
        while (true) {
            try {
                i = xmlPullParser.next();
            } catch (IOException e) {
                InterfaceC2971z5 interfaceC2971z52 = this.b;
                if (interfaceC2971z52 != null) {
                    ((A5) interfaceC2971z52).b("Pe", H6.a("Pe", "TAG", "Parsing failed. ").append(Arrays.toString(e.getStackTrace())).toString());
                }
            } catch (XmlPullParserException e2) {
                InterfaceC2971z5 interfaceC2971z53 = this.b;
                if (interfaceC2971z53 != null) {
                    ((A5) interfaceC2971z53).b("Pe", H6.a("Pe", "TAG", "VAST Schema validation error: VAST node at appropriate hierarchy not found. ").append(Arrays.toString(e2.getStackTrace())).toString());
                }
            }
            if (i == 1) {
                return;
            }
            if (xmlPullParser.getName() != null && Intrinsics.areEqual(xmlPullParser.getName(), str)) {
                return;
            }
        }
    }

    public final void a(XmlPullParser xmlPullParser, String[] strArr) {
        int i = 0;
        boolean z = false;
        do {
            try {
                i = xmlPullParser.next();
            } catch (IOException unused) {
                InterfaceC2971z5 interfaceC2971z5 = this.b;
                if (interfaceC2971z5 != null) {
                    Intrinsics.checkNotNullExpressionValue("Pe", "TAG");
                    ((A5) interfaceC2971z5).b("Pe", "Parsing failed.");
                }
            } catch (XmlPullParserException unused2) {
                InterfaceC2971z5 interfaceC2971z52 = this.b;
                if (interfaceC2971z52 != null) {
                    Intrinsics.checkNotNullExpressionValue("Pe", "TAG");
                    ((A5) interfaceC2971z52).b("Pe", "VAST Schema validation error: VAST node at appropriate hierarchy not found.");
                }
            }
            if (i == 1) {
                return;
            }
            if (xmlPullParser.getName() != null) {
                int length = strArr.length;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        break;
                    }
                    if (Intrinsics.areEqual(xmlPullParser.getName(), strArr[i2])) {
                        z = true;
                        break;
                    }
                    i2++;
                }
            }
        } while (!z);
    }

    public final void a(XmlPullParser xmlPullParser, boolean z) {
        String str;
        int d = d(xmlPullParser);
        while (true) {
            if (xmlPullParser.getName() != null && Intrinsics.areEqual(xmlPullParser.getName(), "VideoClicks") && b(d)) {
                return;
            }
            if (xmlPullParser.getName() != null && !b(d)) {
                String name = xmlPullParser.getName();
                if (Intrinsics.areEqual(name, "ClickThrough")) {
                    if (!z) {
                        return;
                    }
                    if (d(xmlPullParser) == 4) {
                        String text = xmlPullParser.getText();
                        if (text == null || text.length() == 0) {
                            str = null;
                        } else {
                            Intrinsics.checkNotNull(text);
                            int length = text.length() - 1;
                            int i = 0;
                            boolean z2 = false;
                            while (i <= length) {
                                boolean z3 = Intrinsics.compare((int) text.charAt(!z2 ? i : length), 32) <= 0;
                                if (z2) {
                                    if (!z3) {
                                        break;
                                    } else {
                                        length--;
                                    }
                                } else if (z3) {
                                    i++;
                                } else {
                                    z2 = true;
                                }
                            }
                            str = I7.a(length, 1, text, i);
                        }
                        this.c.k = str;
                    }
                } else if (Intrinsics.areEqual(name, "ClickTracking") && d(xmlPullParser) == 4) {
                    String text2 = xmlPullParser.getText();
                    Intrinsics.checkNotNullExpressionValue(text2, "getText(...)");
                    a("click", text2);
                }
            }
            d = d(xmlPullParser);
        }
    }

    public final void a(XmlPullParser vastParser) {
        String vendor;
        int d;
        int d2 = d(vastParser);
        while (true) {
            if (vastParser.getName() != null && Intrinsics.areEqual(vastParser.getName(), "AdVerifications") && b(d2)) {
                return;
            }
            if (vastParser.getName() != null && !b(d2) && Intrinsics.areEqual(vastParser.getName(), VastTagName.VERIFICATION) && (vendor = vastParser.getAttributeValue(null, VastAttributes.VENDOR)) != null) {
                Intrinsics.checkNotNullParameter(vastParser, "vastParser");
                Intrinsics.checkNotNullParameter(vendor, "vendor");
                int d3 = d(vastParser);
                String str = null;
                String str2 = null;
                while (true) {
                    if (vastParser.getName() != null && Intrinsics.areEqual(vastParser.getName(), VastTagName.VERIFICATION) && b(d3)) {
                        break;
                    }
                    if (vastParser.getName() != null && !b(d3)) {
                        String name = vastParser.getName();
                        if (Intrinsics.areEqual(name, VastTagName.JAVA_SCRIPT_RESOURCE)) {
                            String attributeValue = vastParser.getAttributeValue(null, VastAttributes.API_FRAMEWORK);
                            if (attributeValue != null && StringsKt.startsWith$default(attributeValue, CampaignEx.KEY_OMID, false, 2, (Object) null) && d(vastParser) == 4) {
                                String text = vastParser.getText();
                                if (text == null || text.length() == 0) {
                                    str = null;
                                } else {
                                    int length = text.length() - 1;
                                    int i = 0;
                                    boolean z = false;
                                    while (i <= length) {
                                        boolean z2 = Intrinsics.compare((int) text.charAt(!z ? i : length), 32) <= 0;
                                        if (z) {
                                            if (!z2) {
                                                break;
                                            } else {
                                                length--;
                                            }
                                        } else if (z2) {
                                            i++;
                                        } else {
                                            z = true;
                                        }
                                    }
                                    str = I7.a(length, 1, text, i);
                                }
                            }
                        } else if (Intrinsics.areEqual(name, VastTagName.VERIFICATION_PARAMETERS) && ((d = d(vastParser)) == 4 || d == 5)) {
                            String text2 = vastParser.getText();
                            if (text2 == null || text2.length() == 0) {
                                str2 = null;
                            } else {
                                String text3 = vastParser.getText();
                                Intrinsics.checkNotNullExpressionValue(text3, "getText(...)");
                                str2 = StringsKt.trim((CharSequence) text3).toString();
                            }
                        }
                    }
                    d3 = d(vastParser);
                }
                if (URLUtil.isValidUrl(str)) {
                    Intrinsics.checkNotNull(str);
                    C2683ha tracker = new C2683ha(vendor, str2, str, null);
                    Ue ue = this.c;
                    ue.getClass();
                    Intrinsics.checkNotNullParameter(tracker, "tracker");
                    ue.h.add(tracker);
                    InterfaceC2971z5 interfaceC2971z5 = this.b;
                    if (interfaceC2971z5 != null) {
                        Intrinsics.checkNotNullExpressionValue("Pe", "TAG");
                        ((A5) interfaceC2971z5).b("Pe", "Omid JavaScript URL found inside VAST : ".concat(str));
                    }
                }
            }
            d2 = d(vastParser);
        }
    }

    public final void a(int i) {
        HashMap hashMap = new HashMap();
        hashMap.put("[ERRORCODE]", String.valueOf(i));
        Iterator it = this.c.h.iterator();
        while (it.hasNext()) {
            U8 u8 = (U8) it.next();
            if (Intrinsics.areEqual("error", u8.b)) {
                String str = u8.d;
                boolean z = T9.f2439a;
                C2933x2.f2748a.a(T9.a(str, hashMap), u8.c, true, null, Ta.c, this.b);
            }
        }
    }

    public final void a(String str, String str2) {
        String a2;
        if (str2.length() == 0) {
            a2 = null;
        } else {
            int length = str2.length() - 1;
            int i = 0;
            boolean z = false;
            while (i <= length) {
                boolean z2 = Intrinsics.compare((int) str2.charAt(!z ? i : length), 32) <= 0;
                if (z) {
                    if (!z2) {
                        break;
                    } else {
                        length--;
                    }
                } else if (z2) {
                    i++;
                } else {
                    z = true;
                }
            }
            a2 = I7.a(length, 1, str2, i);
        }
        if (!URLUtil.isValidUrl(a2)) {
            InterfaceC2971z5 interfaceC2971z5 = this.b;
            if (interfaceC2971z5 != null) {
                Intrinsics.checkNotNullExpressionValue("Pe", "TAG");
                ((A5) interfaceC2971z5).b("Pe", "Malformed URL " + a2 + " Discarding this tracker");
            }
            Intrinsics.areEqual(str, "Impression");
            return;
        }
        Intrinsics.checkNotNull(a2);
        U8 tracker = new U8(a2, 0, str, null);
        Ue ue = this.c;
        ue.getClass();
        Intrinsics.checkNotNullParameter(tracker, "tracker");
        ue.h.add(tracker);
    }

    public final void c(int i) {
        this.c.l = i;
        a(i);
    }
}
