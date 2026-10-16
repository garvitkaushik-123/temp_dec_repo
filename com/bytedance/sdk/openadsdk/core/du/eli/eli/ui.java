package com.bytedance.sdk.openadsdk.core.du.eli.eli;

import android.content.Context;
import android.text.TextUtils;
import android.util.Xml;
import com.bytedance.sdk.openadsdk.core.du.DbA.Os;
import com.bytedance.sdk.openadsdk.core.du.Os.eli;
import com.bytedance.sdk.openadsdk.core.du.aAs;
import com.bytedance.sdk.openadsdk.core.du.eli.DbA;
import com.bytedance.sdk.openadsdk.core.model.ev;
import io.bidmachine.iab.vast.tags.VastTagName;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes3.dex */
public class ui extends com.bytedance.sdk.openadsdk.core.du.eli.DbA {
    public static final String kb = null;

    public ui(Context context, int i, int i2) {
        super(context, i, i2);
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x005d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.bytedance.sdk.openadsdk.core.du.eli.DbA
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public com.bytedance.sdk.openadsdk.core.du.eli eli(String str, File file, List<com.bytedance.sdk.openadsdk.core.du.DbA.Os> list) {
        InputStream inputStream;
        this.ui = 0;
        InputStream inputStream2 = null;
        if (this.DbA == null) {
            this.ui = -1;
            return null;
        }
        if (TextUtils.isEmpty(str) && file == null) {
            this.ui = -2;
            return null;
        }
        try {
            if (!TextUtils.isEmpty(str)) {
                inputStream = new ByteArrayInputStream(str.getBytes("UTF-8"));
            } else {
                inputStream = new FileInputStream(file);
            }
            try {
                try {
                    XmlPullParser newPullParser = Xml.newPullParser();
                    newPullParser.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", false);
                    newPullParser.setInput(inputStream, "UTF-8");
                    newPullParser.nextTag();
                    com.bytedance.sdk.openadsdk.core.du.eli eli2 = eli(newPullParser, list);
                    eli(eli2);
                    try {
                        inputStream.close();
                    } catch (IOException unused) {
                    }
                    return eli2;
                } catch (Exception unused2) {
                    this.ui = -3;
                    eli((com.bytedance.sdk.openadsdk.core.du.eli) null);
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException unused3) {
                        }
                    }
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                inputStream2 = inputStream;
                if (inputStream2 != null) {
                    try {
                        inputStream2.close();
                    } catch (IOException unused4) {
                    }
                }
                throw th;
            }
        } catch (Exception unused5) {
            inputStream = null;
        } catch (Throwable th2) {
            th = th2;
            if (inputStream2 != null) {
            }
            throw th;
        }
    }

    private void eli(com.bytedance.sdk.openadsdk.core.du.eli eliVar) {
        if (this.MGA == null) {
            this.MGA = new DbA.eli();
        }
        this.MGA.eli = this.ui;
        this.MGA.DbA = this.eli;
        if (eliVar != null) {
            this.MGA.Os = eliVar.eli().DbA.size() <= 0;
        }
    }

    private com.bytedance.sdk.openadsdk.core.du.eli eli(XmlPullParser xmlPullParser, List<com.bytedance.sdk.openadsdk.core.du.DbA.Os> list) throws IOException, XmlPullParserException {
        XmlPullParser xmlPullParser2;
        List<com.bytedance.sdk.openadsdk.core.du.DbA.Os> list2;
        XmlPullParser xmlPullParser3;
        List<com.bytedance.sdk.openadsdk.core.du.DbA.Os> list3;
        xmlPullParser.require(2, kb, VastTagName.VAST);
        boolean z = false;
        String str = null;
        while (xmlPullParser.next() != 1) {
            if (xmlPullParser.getEventType() == 2) {
                String name = xmlPullParser.getName();
                if ("Error".equals(name)) {
                    str = DbA(xmlPullParser, name);
                } else {
                    if ("Ad".equals(name)) {
                        if (eli(xmlPullParser.getAttributeValue(kb, "sequence"))) {
                            while (true) {
                                if (xmlPullParser.next() == 3 && "Ad".equals(xmlPullParser.getName())) {
                                    xmlPullParser2 = xmlPullParser;
                                    list2 = list;
                                    z = true;
                                    break;
                                }
                                if (xmlPullParser.getEventType() == 2) {
                                    String name2 = xmlPullParser.getName();
                                    if ("InLine".equals(name2)) {
                                        xmlPullParser3 = xmlPullParser;
                                        list3 = list;
                                        com.bytedance.sdk.openadsdk.core.du.eli eli2 = DbA.eli(this.DbA, xmlPullParser3, list3, this.Os, this.aGH);
                                        if (eli2 != null) {
                                            if (!TextUtils.isEmpty(eli2.kb())) {
                                                return eli2;
                                            }
                                            this.ui = -6;
                                            return null;
                                        }
                                    } else {
                                        xmlPullParser3 = xmlPullParser;
                                        list3 = list;
                                        if ("Wrapper".equals(name2)) {
                                            com.bytedance.sdk.openadsdk.core.du.eli DbA = DbA(xmlPullParser3, list3);
                                            if (DbA != null) {
                                                return DbA;
                                            }
                                        } else {
                                            eli(xmlPullParser3);
                                        }
                                    }
                                    xmlPullParser = xmlPullParser3;
                                    list = list3;
                                }
                            }
                        } else {
                            eli(xmlPullParser);
                            z = true;
                        }
                    } else {
                        xmlPullParser2 = xmlPullParser;
                        list2 = list;
                        eli(xmlPullParser2);
                    }
                    xmlPullParser = xmlPullParser2;
                    list = list2;
                }
            }
        }
        if (!z) {
            this.ui = -4;
            Os(str);
        }
        if (this.ui == 0) {
            this.ui = -5;
        }
        return null;
    }

    private void Os(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.du.DbA.Os.eli(com.bytedance.sdk.openadsdk.core.du.DbA.Os.eli((ev) null, (List<com.bytedance.sdk.openadsdk.core.du.DbA.Os>) Collections.singletonList(new Os.eli(str).eli()), this.eli > 0 ? com.bytedance.sdk.openadsdk.core.du.eli.eli.NO_ADS_VAST_RESPONSE : com.bytedance.sdk.openadsdk.core.du.eli.eli.UNDEFINED_ERROR, -1L, (String) null, (String) null), (Os.DbA) null);
    }

    static class eli {
        eli.EnumC0190eli DbA;
        eli.DbA Os;
        String aGH;
        String eli;
        final List<com.bytedance.sdk.openadsdk.core.du.DbA.Os> ui = new ArrayList();
        final List<com.bytedance.sdk.openadsdk.core.du.DbA.Os> MGA = new ArrayList();
        float kb = Float.MIN_VALUE;

        public eli() {
        }

        public eli(String str, eli.EnumC0190eli enumC0190eli, eli.DbA dbA) {
            eli(str, enumC0190eli, dbA);
        }

        public void eli(String str, eli.EnumC0190eli enumC0190eli, eli.DbA dbA) {
            this.eli = str;
            this.DbA = enumC0190eli;
            this.Os = dbA;
        }

        public void eli(String str) {
            this.ui.add(new Os.eli(str).eli());
        }

        public void DbA(String str) {
            this.MGA.add(new Os.eli(str).eli());
        }
    }

    public static List<com.bytedance.sdk.openadsdk.core.du.DbA.Os> eli(XmlPullParser xmlPullParser, String str) throws IOException, XmlPullParserException {
        return eli(xmlPullParser, str, false);
    }

    public static List<com.bytedance.sdk.openadsdk.core.du.DbA.Os> eli(XmlPullParser xmlPullParser, String str, boolean z) throws IOException, XmlPullParserException {
        return eli(DbA(xmlPullParser, str), z);
    }

    public static int DbA(String str) {
        if (TextUtils.isEmpty(str)) {
            return Integer.MIN_VALUE;
        }
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            return Integer.MIN_VALUE;
        }
    }

    public static String DbA(XmlPullParser xmlPullParser, String str) throws IOException, XmlPullParserException {
        String str2;
        String str3 = kb;
        xmlPullParser.require(2, str3, str);
        if (xmlPullParser.next() != 4) {
            str2 = "";
        } else {
            str2 = xmlPullParser.getText().trim();
            xmlPullParser.nextTag();
        }
        xmlPullParser.require(3, str3, str);
        return str2;
    }

    public static void eli(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        if (xmlPullParser.getEventType() != 2) {
            throw new IllegalStateException();
        }
        int i = 1;
        while (i != 0) {
            int next = xmlPullParser.next();
            if (next == 2) {
                i++;
            } else if (next == 3) {
                i--;
            }
        }
    }

    public static void eli(XmlPullParser xmlPullParser, String str, int i) throws XmlPullParserException, IOException {
        while (xmlPullParser.getEventType() != 1) {
            if (str.equals(xmlPullParser.getName()) && xmlPullParser.getEventType() == i) {
                return;
            } else {
                xmlPullParser.next();
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:81:0x012c, code lost:
    
        continue;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r16v0 */
    /* JADX WARN: Type inference failed for: r16v1 */
    /* JADX WARN: Type inference failed for: r16v2, types: [com.bytedance.sdk.openadsdk.core.du.eli] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private com.bytedance.sdk.openadsdk.core.du.eli DbA(XmlPullParser xmlPullParser, List<com.bytedance.sdk.openadsdk.core.du.DbA.Os> list) throws XmlPullParserException, IOException {
        ?? r16;
        String name;
        File file = null;
        if (this.eli >= 5) {
            eli(xmlPullParser);
            return null;
        }
        com.bytedance.sdk.openadsdk.core.du.aGH agh = new com.bytedance.sdk.openadsdk.core.du.aGH();
        String str = null;
        com.bytedance.sdk.openadsdk.core.du.Os os = null;
        Set<aAs> set = null;
        while (true) {
            if (xmlPullParser.getEventType() != 3 || !"Wrapper".equals(xmlPullParser.getName())) {
                xmlPullParser.next();
                if (xmlPullParser.getEventType() == 2) {
                    name = xmlPullParser.getName();
                    name.hashCode();
                    r16 = file;
                    switch (name) {
                        case "VASTAdTagURI":
                            String eli2 = eli(DbA(xmlPullParser, "VASTAdTagURI"), list);
                            if (TextUtils.isEmpty(eli2)) {
                                eli(xmlPullParser, "Wrapper", 3);
                                this.ui = -2;
                                return r16;
                            }
                            str = eli2;
                            continue;
                        case "Error":
                            list.add(new Os.eli(DbA(xmlPullParser, "Error")).eli());
                            continue;
                        case "TrackingEvents":
                            Os.eli(xmlPullParser, agh);
                            continue;
                        case "CompanionAds":
                            os = com.bytedance.sdk.openadsdk.core.du.eli.eli.eli.eli(this.DbA, xmlPullParser);
                            continue;
                        case "ClickTracking":
                            agh.kb(eli(xmlPullParser, "ClickTracking"));
                            continue;
                        case "Impression":
                            agh.eli(eli(xmlPullParser, name));
                            continue;
                    }
                    while (true) {
                        if (xmlPullParser.getEventType() != 3 || !VastTagName.EXTENSIONS.equals(xmlPullParser.getName())) {
                            xmlPullParser.next();
                            if (xmlPullParser.getEventType() == 2 && "AdVerifications".equals(xmlPullParser.getName())) {
                                set = aGH.eli(xmlPullParser);
                            }
                        }
                    }
                } else {
                    r16 = file;
                }
                file = r16;
            } else {
                com.bytedance.sdk.openadsdk.core.du.eli eli3 = eli(str, file, list);
                if (eli3 != null) {
                    if (eli3.Os() == null) {
                        eli3.eli(os);
                    }
                    eli3.eli().eli(agh);
                    if (set != null) {
                        eli3.eli(set);
                    }
                }
                return eli3;
            }
        }
    }

    private static List<com.bytedance.sdk.openadsdk.core.du.DbA.Os> eli(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return new ArrayList();
        }
        return Collections.singletonList(new Os.eli(str).eli(z).eli());
    }
}
