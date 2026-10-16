package io.bidmachine.iab.vast.tags;

import android.text.TextUtils;
import android.util.Xml;
import io.bidmachine.iab.vast.VastLog;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.Charset;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: classes7.dex */
public class VastParser {
    public static VastTag parseVast(String xmlData) {
        ByteArrayInputStream byteArrayInputStream;
        if (TextUtils.isEmpty(xmlData)) {
            throw new Exception();
        }
        ByteArrayInputStream byteArrayInputStream2 = null;
        try {
            try {
                byteArrayInputStream = new ByteArrayInputStream(xmlData.getBytes(Charset.defaultCharset().name()));
            } catch (Exception e) {
                e = e;
            }
        } catch (Throwable th) {
            th = th;
            byteArrayInputStream = byteArrayInputStream2;
        }
        try {
            VastTag parseVast = parseVast(byteArrayInputStream);
            try {
                byteArrayInputStream.close();
                return parseVast;
            } catch (Exception e2) {
                VastLog.e("VastXmlParser", e2);
                return parseVast;
            }
        } catch (Exception e3) {
            e = e3;
            byteArrayInputStream2 = byteArrayInputStream;
            VastLog.e("VastXmlParser", e);
            throw new Exception();
        } catch (Throwable th2) {
            th = th2;
            if (byteArrayInputStream != null) {
                try {
                    byteArrayInputStream.close();
                } catch (Exception e4) {
                    VastLog.e("VastXmlParser", e4);
                }
            }
            throw th;
        }
    }

    public static VastTag parseVast(InputStream inputStream) {
        if (inputStream != null) {
            XmlPullParser newPullParser = Xml.newPullParser();
            newPullParser.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", false);
            newPullParser.setInput(inputStream, null);
            int next = newPullParser.next();
            if (next == 1) {
                throw new Exception();
            }
            while (next != 3 && next != 1) {
                if (newPullParser.getEventType() != 2) {
                    next = newPullParser.next();
                } else {
                    if (VastXmlTag.a(newPullParser.getName(), VastTagName.VAST)) {
                        return new VastTag(newPullParser);
                    }
                    next = newPullParser.next();
                }
            }
            return null;
        }
        throw new Exception();
    }
}
