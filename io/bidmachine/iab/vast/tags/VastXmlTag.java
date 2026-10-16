package io.bidmachine.iab.vast.tags;

import android.graphics.Color;
import android.text.TextUtils;
import com.ironsource.C3040d4;
import io.bidmachine.iab.utils.IabElementStyle;
import io.bidmachine.iab.utils.Utils;
import io.bidmachine.iab.vast.VastLog;
import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes7.dex */
public class VastXmlTag implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    private String f6925a;
    private HashMap<String, String> b;

    public VastXmlTag() {
    }

    static String c(XmlPullParser xmlPullParser) {
        if (xmlPullParser.next() != 4) {
            return null;
        }
        String text = xmlPullParser.getText();
        if (!TextUtils.isEmpty(text)) {
            text = text.trim();
        }
        xmlPullParser.nextTag();
        return text;
    }

    private boolean d(String name) {
        for (String str : getSupportedAttributes()) {
            if (str.equals(name)) {
                return true;
            }
        }
        return false;
    }

    static int e(String hoursTime) {
        if (hoursTime == null) {
            return -1;
        }
        int indexOf = hoursTime.indexOf(".");
        if (indexOf > 0) {
            hoursTime = hoursTime.substring(0, indexOf);
        }
        String[] split = hoursTime.split(":");
        if (split.length <= 2) {
            return -1;
        }
        try {
            return (Integer.parseInt(split[0]) * 3600) + (Integer.parseInt(split[1]) * 60) + Integer.parseInt(split[2]);
        } catch (Exception e) {
            VastLog.e("VastXmlTag", e);
            return -1;
        }
    }

    static int f(String minTime) {
        if (minTime == null) {
            return -1;
        }
        String[] split = minTime.split(":");
        if (split.length <= 1) {
            return -1;
        }
        try {
            return (Integer.parseInt(split[0]) * 60) + Integer.parseInt(split[1]);
        } catch (Exception e) {
            VastLog.e("VastXmlTag", e);
            return -1;
        }
    }

    static Integer g(String orientation) {
        if (TextUtils.isEmpty(orientation)) {
            return null;
        }
        String lowerCase = orientation.toLowerCase();
        lowerCase.hashCode();
        if (lowerCase.equals(C3040d4.h.D)) {
            return 1;
        }
        return !lowerCase.equals(C3040d4.h.C) ? null : 2;
    }

    static Integer h(String positionString) {
        if (TextUtils.isEmpty(positionString)) {
            return null;
        }
        String lowerCase = positionString.toLowerCase();
        lowerCase.hashCode();
        lowerCase.hashCode();
        switch (lowerCase) {
            case "center":
                return 1;
            case "left":
                return 3;
            case "right":
                return 5;
            default:
                return null;
        }
    }

    static Integer i(String positionString) {
        if (TextUtils.isEmpty(positionString)) {
            return null;
        }
        String lowerCase = positionString.toLowerCase();
        lowerCase.hashCode();
        lowerCase.hashCode();
        switch (lowerCase) {
            case "bottom":
                return 80;
            case "center":
                return 16;
            case "top":
                return 48;
            default:
                return null;
        }
    }

    static boolean j(String value) {
        if (value != null) {
            return value.equalsIgnoreCase("false") || value.equalsIgnoreCase("0");
        }
        return false;
    }

    static boolean k(String value) {
        if (value != null) {
            return value.equalsIgnoreCase("true") || value.equalsIgnoreCase("1");
        }
        return false;
    }

    protected void a(XmlPullParser xmlPullParser) {
    }

    final int b(String name) {
        String a2 = a(name);
        if (TextUtils.isEmpty(a2)) {
            VastLog.d("VastXmlTag", "Error parse attribute value - %s, by name - %s", a2, name);
            return -1;
        }
        try {
            return Integer.parseInt(a2);
        } catch (Exception unused) {
            VastLog.e("VastXmlTag", "Error parse attribute value - %s, by name - %s", a2, name);
            return -1;
        }
    }

    public final boolean getBooleanAttributeValueByName(String name, boolean defValue) {
        String a2 = a(name);
        if (k(a2)) {
            return true;
        }
        if (j(a2)) {
            return false;
        }
        return defValue;
    }

    public String[] getSupportedAttributes() {
        return new String[0];
    }

    public final String getText() {
        return this.f6925a;
    }

    public boolean isTextSupported() {
        return false;
    }

    public boolean isValidTag() {
        return true;
    }

    public void parse(XmlPullParser xmlPullParser) {
        a(a(this, xmlPullParser));
        if (isTextSupported()) {
            setText(c(xmlPullParser));
        }
        a(xmlPullParser);
    }

    public final void setText(String text) {
        this.f6925a = text;
    }

    public VastXmlTag(XmlPullParser xmlPullParser) {
        parse(xmlPullParser);
    }

    private void a(HashMap<String, String> attributes) {
        this.b = attributes;
    }

    final String a(String name) {
        HashMap<String, String> hashMap = this.b;
        if (hashMap != null) {
            return hashMap.get(name);
        }
        return null;
    }

    static void d(XmlPullParser parser) {
        if (parser.getEventType() != 2) {
            throw new IllegalStateException();
        }
        int i = 1;
        while (i != 0) {
            int next = parser.next();
            if (next == 2) {
                i++;
            } else if (next == 3) {
                i--;
            }
        }
    }

    private static HashMap<String, String> a(VastXmlTag vastXmlTag, XmlPullParser xmlPullParser) {
        if (xmlPullParser.getAttributeCount() <= 0) {
            return null;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        for (int i = 0; i < xmlPullParser.getAttributeCount(); i++) {
            if (vastXmlTag.d(xmlPullParser.getAttributeName(i))) {
                hashMap.put(xmlPullParser.getAttributeName(i), xmlPullParser.getAttributeValue(i));
            }
        }
        return hashMap;
    }

    static Integer c(String colorString) {
        if (TextUtils.isEmpty(colorString)) {
            return null;
        }
        try {
            return Integer.valueOf(Color.parseColor(colorString));
        } catch (Exception e) {
            VastLog.e("VastXmlTag", e.getMessage(), new Object[0]);
            return null;
        }
    }

    static boolean b(XmlPullParser xmlPullParser) {
        return k(c(xmlPullParser));
    }

    static boolean a(String value1, String value2) {
        return value1 != null && value1.equalsIgnoreCase(value2);
    }

    static void a(XmlPullParser xmlPullParser, IabElementStyle targetStyle) {
        for (int i = 0; i < xmlPullParser.getAttributeCount(); i++) {
            String attributeName = xmlPullParser.getAttributeName(i);
            String attributeValue = xmlPullParser.getAttributeValue(i);
            if (!TextUtils.isEmpty(attributeValue)) {
                try {
                    if (VastAttributes.STROKE_COLOR.equals(attributeName)) {
                        targetStyle.setStrokeColor(c(attributeValue));
                    } else if (VastAttributes.FILL_COLOR.equals(attributeName)) {
                        targetStyle.setFillColor(c(attributeValue));
                    } else if (VastAttributes.OUTLINED.equals(attributeName)) {
                        targetStyle.setOutlined(Boolean.valueOf(k(attributeValue)));
                    } else if (VastAttributes.VISIBLE.equals(attributeName)) {
                        targetStyle.setVisible(Boolean.valueOf(k(attributeValue)));
                    } else if (VastAttributes.HORIZONTAL_POSITION.equals(attributeName)) {
                        targetStyle.setHorizontalPosition(h(attributeValue));
                    } else if (VastAttributes.VERTICAL_POSITION.equals(attributeName)) {
                        targetStyle.setVerticalPosition(i(attributeValue));
                    } else if ("style".equals(attributeName)) {
                        targetStyle.setStyle(attributeValue);
                    } else if (VastAttributes.OPACITY.equals(attributeName)) {
                        targetStyle.setOpacity(Float.valueOf(Float.parseFloat(attributeValue)));
                    } else if (VastAttributes.HIDE_AFTER.equals(attributeName)) {
                        targetStyle.setHideAfter(Float.valueOf(Float.parseFloat(attributeValue)));
                    } else if (VastAttributes.PADDING.equals(attributeName)) {
                        targetStyle.setPadding(attributeValue);
                    } else if (VastAttributes.MARGIN.equals(attributeName)) {
                        targetStyle.setMargin(attributeValue);
                    } else if (VastAttributes.STROKE_WIDTH.equals(attributeName)) {
                        targetStyle.setStrokeWidth(Utils.convertCssSizeToPx(attributeValue));
                    } else if ("width".equals(attributeName)) {
                        targetStyle.setWidth(Utils.convertCssSizeToPx(attributeValue));
                    } else if ("height".equals(attributeName)) {
                        targetStyle.setHeight(Utils.convertCssSizeToPx(attributeValue));
                    } else if (VastAttributes.FONT_STYLE.equals(attributeName)) {
                        targetStyle.setFontStyle(Integer.valueOf(Integer.parseInt(attributeValue)));
                    } else if (VastAttributes.FONT_SIZE.equals(attributeName)) {
                        targetStyle.setFontSize(Utils.convertCssSizeToPx(attributeValue));
                    }
                } catch (Throwable th) {
                    VastLog.e("VastXmlTag", th);
                }
            }
        }
        try {
            targetStyle.setContent(c(xmlPullParser));
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            xmlPullParser.require(3, null, xmlPullParser.getName());
        } catch (IOException e2) {
            e2.printStackTrace();
        } catch (XmlPullParserException e3) {
            e3.printStackTrace();
        }
    }
}
