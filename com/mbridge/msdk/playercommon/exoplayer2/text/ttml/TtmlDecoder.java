package com.mbridge.msdk.playercommon.exoplayer2.text.ttml;

import android.text.Layout;
import android.util.Log;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.mbridge.msdk.playercommon.exoplayer2.text.SimpleSubtitleDecoder;
import com.mbridge.msdk.playercommon.exoplayer2.text.SubtitleDecoderException;
import com.mbridge.msdk.playercommon.exoplayer2.util.ColorParser;
import com.mbridge.msdk.playercommon.exoplayer2.util.Util;
import com.mbridge.msdk.playercommon.exoplayer2.util.XmlPullParserUtil;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/* loaded from: classes6.dex */
public final class TtmlDecoder extends SimpleSubtitleDecoder {
    private static final String ATTR_BEGIN = "begin";
    private static final String ATTR_DURATION = "dur";
    private static final String ATTR_END = "end";
    private static final String ATTR_REGION = "region";
    private static final String ATTR_STYLE = "style";
    private static final int DEFAULT_FRAME_RATE = 30;
    private static final String TAG = "TtmlDecoder";
    private static final String TTP = "http://www.w3.org/ns/ttml#parameter";
    private final XmlPullParserFactory xmlParserFactory;
    private static final Pattern CLOCK_TIME = Pattern.compile("^([0-9][0-9]+):([0-9][0-9]):([0-9][0-9])(?:(\\.[0-9]+)|:([0-9][0-9])(?:\\.([0-9]+))?)?$");
    private static final Pattern OFFSET_TIME = Pattern.compile("^([0-9]+(?:\\.[0-9]+)?)(h|m|s|ms|f|t)$");
    private static final Pattern FONT_SIZE = Pattern.compile("^(([0-9]*.)?[0-9]+)(px|em|%)$");
    private static final Pattern PERCENTAGE_COORDINATES = Pattern.compile("^(\\d+\\.?\\d*?)% (\\d+\\.?\\d*?)%$");
    private static final Pattern CELL_RESOLUTION = Pattern.compile("^(\\d+) (\\d+)$");
    private static final FrameAndTickRate DEFAULT_FRAME_AND_TICK_RATE = new FrameAndTickRate(30.0f, 1, 1);
    private static final CellResolution DEFAULT_CELL_RESOLUTION = new CellResolution(32, 15);

    private static final class CellResolution {
        final int columns;
        final int rows;

        CellResolution(int i, int i2) {
            this.columns = i;
            this.rows = i2;
        }
    }

    private static final class FrameAndTickRate {
        final float effectiveFrameRate;
        final int subFrameRate;
        final int tickRate;

        FrameAndTickRate(float f, int i, int i2) {
            this.effectiveFrameRate = f;
            this.subFrameRate = i;
            this.tickRate = i2;
        }
    }

    public TtmlDecoder() {
        super(TAG);
        try {
            XmlPullParserFactory newInstance = XmlPullParserFactory.newInstance();
            this.xmlParserFactory = newInstance;
            newInstance.setNamespaceAware(true);
        } catch (XmlPullParserException e) {
            throw new RuntimeException("Couldn't create XmlPullParserFactory instance", e);
        }
    }

    private TtmlStyle createIfNull(TtmlStyle ttmlStyle) {
        return ttmlStyle == null ? new TtmlStyle() : ttmlStyle;
    }

    private static boolean isSupportedTag(String str) {
        return str.equals("tt") || str.equals("head") || str.equals("body") || str.equals("div") || str.equals("p") || str.equals("span") || str.equals("br") || str.equals("style") || str.equals("styling") || str.equals("layout") || str.equals("region") || str.equals("metadata") || str.equals(TtmlNode.TAG_SMPTE_IMAGE) || str.equals(TtmlNode.TAG_SMPTE_DATA) || str.equals(TtmlNode.TAG_SMPTE_INFORMATION);
    }

    private CellResolution parseCellResolution(XmlPullParser xmlPullParser, CellResolution cellResolution) throws SubtitleDecoderException {
        String attributeValue = xmlPullParser.getAttributeValue(TTP, "cellResolution");
        if (attributeValue == null) {
            return cellResolution;
        }
        Matcher matcher = CELL_RESOLUTION.matcher(attributeValue);
        if (!matcher.matches()) {
            Log.w(TAG, "Ignoring malformed cell resolution: " + attributeValue);
            return cellResolution;
        }
        try {
            int parseInt = Integer.parseInt(matcher.group(1));
            int parseInt2 = Integer.parseInt(matcher.group(2));
            if (parseInt == 0 || parseInt2 == 0) {
                throw new SubtitleDecoderException("Invalid cell resolution " + parseInt + " " + parseInt2);
            }
            return new CellResolution(parseInt, parseInt2);
        } catch (NumberFormatException unused) {
            Log.w(TAG, "Ignoring malformed cell resolution: " + attributeValue);
            return cellResolution;
        }
    }

    private static void parseFontSize(String str, TtmlStyle ttmlStyle) throws SubtitleDecoderException {
        Matcher matcher;
        String group;
        String[] split = Util.split(str, "\\s+");
        if (split.length == 1) {
            matcher = FONT_SIZE.matcher(str);
        } else {
            if (split.length != 2) {
                throw new SubtitleDecoderException("Invalid number of entries for fontSize: " + split.length + ".");
            }
            matcher = FONT_SIZE.matcher(split[1]);
            Log.w(TAG, "Multiple values in fontSize attribute. Picking the second value for vertical font size and ignoring the first.");
        }
        if (!matcher.matches()) {
            throw new SubtitleDecoderException("Invalid expression for fontSize: '" + str + "'.");
        }
        group = matcher.group(3);
        group.hashCode();
        group.hashCode();
        switch (group) {
            case "%":
                ttmlStyle.setFontSizeUnit(3);
                break;
            case "em":
                ttmlStyle.setFontSizeUnit(2);
                break;
            case "px":
                ttmlStyle.setFontSizeUnit(1);
                break;
            default:
                throw new SubtitleDecoderException("Invalid unit for fontSize: '" + group + "'.");
        }
        ttmlStyle.setFontSize(Float.valueOf(matcher.group(1)).floatValue());
    }

    private FrameAndTickRate parseFrameAndTickRates(XmlPullParser xmlPullParser) throws SubtitleDecoderException {
        float f;
        String attributeValue = xmlPullParser.getAttributeValue(TTP, "frameRate");
        int parseInt = attributeValue != null ? Integer.parseInt(attributeValue) : 30;
        String attributeValue2 = xmlPullParser.getAttributeValue(TTP, "frameRateMultiplier");
        if (attributeValue2 != null) {
            if (Util.split(attributeValue2, " ").length != 2) {
                throw new SubtitleDecoderException("frameRateMultiplier doesn't have 2 parts");
            }
            f = Integer.parseInt(r2[0]) / Integer.parseInt(r2[1]);
        } else {
            f = 1.0f;
        }
        FrameAndTickRate frameAndTickRate = DEFAULT_FRAME_AND_TICK_RATE;
        int i = frameAndTickRate.subFrameRate;
        String attributeValue3 = xmlPullParser.getAttributeValue(TTP, "subFrameRate");
        if (attributeValue3 != null) {
            i = Integer.parseInt(attributeValue3);
        }
        int i2 = frameAndTickRate.tickRate;
        String attributeValue4 = xmlPullParser.getAttributeValue(TTP, "tickRate");
        if (attributeValue4 != null) {
            i2 = Integer.parseInt(attributeValue4);
        }
        return new FrameAndTickRate(parseInt * f, i, i2);
    }

    private Map<String, TtmlStyle> parseHeader(XmlPullParser xmlPullParser, Map<String, TtmlStyle> map, Map<String, TtmlRegion> map2, CellResolution cellResolution) throws IOException, XmlPullParserException {
        TtmlRegion parseRegionAttributes;
        do {
            xmlPullParser.next();
            if (XmlPullParserUtil.isStartTag(xmlPullParser, "style")) {
                String attributeValue = XmlPullParserUtil.getAttributeValue(xmlPullParser, "style");
                TtmlStyle parseStyleAttributes = parseStyleAttributes(xmlPullParser, new TtmlStyle());
                if (attributeValue != null) {
                    for (String str : parseStyleIds(attributeValue)) {
                        parseStyleAttributes.chain(map.get(str));
                    }
                }
                if (parseStyleAttributes.getId() != null) {
                    map.put(parseStyleAttributes.getId(), parseStyleAttributes);
                }
            } else if (XmlPullParserUtil.isStartTag(xmlPullParser, "region") && (parseRegionAttributes = parseRegionAttributes(xmlPullParser, cellResolution)) != null) {
                map2.put(parseRegionAttributes.id, parseRegionAttributes);
            }
        } while (!XmlPullParserUtil.isEndTag(xmlPullParser, "head"));
        return map;
    }

    private TtmlRegion parseRegionAttributes(XmlPullParser xmlPullParser, CellResolution cellResolution) {
        float f;
        String attributeValue = XmlPullParserUtil.getAttributeValue(xmlPullParser, "id");
        if (attributeValue == null) {
            return null;
        }
        String attributeValue2 = XmlPullParserUtil.getAttributeValue(xmlPullParser, "origin");
        if (attributeValue2 == null) {
            Log.w(TAG, "Ignoring region without an origin");
            return null;
        }
        Pattern pattern = PERCENTAGE_COORDINATES;
        Matcher matcher = pattern.matcher(attributeValue2);
        if (!matcher.matches()) {
            Log.w(TAG, "Ignoring region with unsupported origin: " + attributeValue2);
            return null;
        }
        int i = 1;
        try {
            float parseFloat = Float.parseFloat(matcher.group(1)) / 100.0f;
            float parseFloat2 = Float.parseFloat(matcher.group(2)) / 100.0f;
            String attributeValue3 = XmlPullParserUtil.getAttributeValue(xmlPullParser, "extent");
            if (attributeValue3 == null) {
                Log.w(TAG, "Ignoring region without an extent");
                return null;
            }
            Matcher matcher2 = pattern.matcher(attributeValue3);
            if (!matcher2.matches()) {
                Log.w(TAG, "Ignoring region with unsupported extent: " + attributeValue2);
                return null;
            }
            try {
                float parseFloat3 = Float.parseFloat(matcher2.group(1)) / 100.0f;
                float parseFloat4 = Float.parseFloat(matcher2.group(2)) / 100.0f;
                String attributeValue4 = XmlPullParserUtil.getAttributeValue(xmlPullParser, "displayAlign");
                if (attributeValue4 != null) {
                    String lowerInvariant = Util.toLowerInvariant(attributeValue4);
                    lowerInvariant.hashCode();
                    if (lowerInvariant.equals("center")) {
                        parseFloat2 += parseFloat4 / 2.0f;
                        f = parseFloat2;
                        return new TtmlRegion(attributeValue, parseFloat, f, 0, i, parseFloat3, 1, 1.0f / cellResolution.rows);
                    }
                    if (lowerInvariant.equals("after")) {
                        f = parseFloat2 + parseFloat4;
                        i = 2;
                        return new TtmlRegion(attributeValue, parseFloat, f, 0, i, parseFloat3, 1, 1.0f / cellResolution.rows);
                    }
                }
                i = 0;
                f = parseFloat2;
                return new TtmlRegion(attributeValue, parseFloat, f, 0, i, parseFloat3, 1, 1.0f / cellResolution.rows);
            } catch (NumberFormatException unused) {
                Log.w(TAG, "Ignoring region with malformed extent: " + attributeValue2);
                return null;
            }
        } catch (NumberFormatException unused2) {
            Log.w(TAG, "Ignoring region with malformed origin: " + attributeValue2);
            return null;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x012e, code lost:
    
        if (r3.equals("linethrough") == false) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0197, code lost:
    
        if (r3.equals("start") == false) goto L87;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private TtmlStyle parseStyleAttributes(XmlPullParser xmlPullParser, TtmlStyle ttmlStyle) {
        char c;
        int attributeCount = xmlPullParser.getAttributeCount();
        for (int i = 0; i < attributeCount; i++) {
            String attributeValue = xmlPullParser.getAttributeValue(i);
            String attributeName = xmlPullParser.getAttributeName(i);
            attributeName.hashCode();
            attributeName.hashCode();
            char c2 = 4;
            char c3 = 3;
            switch (attributeName.hashCode()) {
                case -1550943582:
                    if (attributeName.equals("fontStyle")) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                case -1224696685:
                    if (attributeName.equals("fontFamily")) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case -1065511464:
                    if (attributeName.equals("textAlign")) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case -879295043:
                    if (attributeName.equals("textDecoration")) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                case -734428249:
                    if (attributeName.equals("fontWeight")) {
                        c = 4;
                        break;
                    }
                    c = 65535;
                    break;
                case 3355:
                    if (attributeName.equals("id")) {
                        c = 5;
                        break;
                    }
                    c = 65535;
                    break;
                case 94842723:
                    if (attributeName.equals("color")) {
                        c = 6;
                        break;
                    }
                    c = 65535;
                    break;
                case 365601008:
                    if (attributeName.equals("fontSize")) {
                        c = 7;
                        break;
                    }
                    c = 65535;
                    break;
                case 1287124693:
                    if (attributeName.equals("backgroundColor")) {
                        c = '\b';
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
                    ttmlStyle = createIfNull(ttmlStyle).setItalic("italic".equalsIgnoreCase(attributeValue));
                    break;
                case 1:
                    ttmlStyle = createIfNull(ttmlStyle).setFontFamily(attributeValue);
                    break;
                case 2:
                    String lowerInvariant = Util.toLowerInvariant(attributeValue);
                    lowerInvariant.hashCode();
                    lowerInvariant.hashCode();
                    switch (lowerInvariant.hashCode()) {
                        case -1364013995:
                            if (lowerInvariant.equals("center")) {
                                c2 = 0;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case 100571:
                            if (lowerInvariant.equals("end")) {
                                c2 = 1;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case 3317767:
                            if (lowerInvariant.equals("left")) {
                                c2 = 2;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case 108511772:
                            if (lowerInvariant.equals("right")) {
                                c2 = 3;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case 109757538:
                            break;
                        default:
                            c2 = 65535;
                            break;
                    }
                    switch (c2) {
                        case 0:
                            ttmlStyle = createIfNull(ttmlStyle).setTextAlign(Layout.Alignment.ALIGN_CENTER);
                            break;
                        case 1:
                            ttmlStyle = createIfNull(ttmlStyle).setTextAlign(Layout.Alignment.ALIGN_OPPOSITE);
                            break;
                        case 2:
                            ttmlStyle = createIfNull(ttmlStyle).setTextAlign(Layout.Alignment.ALIGN_NORMAL);
                            break;
                        case 3:
                            ttmlStyle = createIfNull(ttmlStyle).setTextAlign(Layout.Alignment.ALIGN_OPPOSITE);
                            break;
                        case 4:
                            ttmlStyle = createIfNull(ttmlStyle).setTextAlign(Layout.Alignment.ALIGN_NORMAL);
                            break;
                    }
                case 3:
                    String lowerInvariant2 = Util.toLowerInvariant(attributeValue);
                    lowerInvariant2.hashCode();
                    lowerInvariant2.hashCode();
                    switch (lowerInvariant2.hashCode()) {
                        case -1461280213:
                            if (lowerInvariant2.equals("nounderline")) {
                                c3 = 0;
                                break;
                            }
                            c3 = 65535;
                            break;
                        case -1026963764:
                            if (lowerInvariant2.equals("underline")) {
                                c3 = 1;
                                break;
                            }
                            c3 = 65535;
                            break;
                        case 913457136:
                            if (lowerInvariant2.equals("nolinethrough")) {
                                c3 = 2;
                                break;
                            }
                            c3 = 65535;
                            break;
                        case 1679736913:
                            break;
                        default:
                            c3 = 65535;
                            break;
                    }
                    switch (c3) {
                        case 0:
                            ttmlStyle = createIfNull(ttmlStyle).setUnderline(false);
                            break;
                        case 1:
                            ttmlStyle = createIfNull(ttmlStyle).setUnderline(true);
                            break;
                        case 2:
                            ttmlStyle = createIfNull(ttmlStyle).setLinethrough(false);
                            break;
                        case 3:
                            ttmlStyle = createIfNull(ttmlStyle).setLinethrough(true);
                            break;
                    }
                case 4:
                    ttmlStyle = createIfNull(ttmlStyle).setBold("bold".equalsIgnoreCase(attributeValue));
                    break;
                case 5:
                    if ("style".equals(xmlPullParser.getName())) {
                        ttmlStyle = createIfNull(ttmlStyle).setId(attributeValue);
                        break;
                    } else {
                        break;
                    }
                case 6:
                    ttmlStyle = createIfNull(ttmlStyle);
                    try {
                        ttmlStyle.setFontColor(ColorParser.parseTtmlColor(attributeValue));
                        break;
                    } catch (IllegalArgumentException unused) {
                        Log.w(TAG, "Failed parsing color value: " + attributeValue);
                        break;
                    }
                case 7:
                    try {
                        ttmlStyle = createIfNull(ttmlStyle);
                        parseFontSize(attributeValue, ttmlStyle);
                        break;
                    } catch (SubtitleDecoderException unused2) {
                        Log.w(TAG, "Failed parsing fontSize value: " + attributeValue);
                        break;
                    }
                case '\b':
                    ttmlStyle = createIfNull(ttmlStyle);
                    try {
                        ttmlStyle.setBackgroundColor(ColorParser.parseTtmlColor(attributeValue));
                        break;
                    } catch (IllegalArgumentException unused3) {
                        Log.w(TAG, "Failed parsing background value: " + attributeValue);
                        break;
                    }
            }
        }
        return ttmlStyle;
    }

    private String[] parseStyleIds(String str) {
        String trim = str.trim();
        return trim.isEmpty() ? new String[0] : Util.split(trim, "\\s+");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00a1, code lost:
    
        if (r13.equals("ms") == false) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static long parseTimeExpression(String str, FrameAndTickRate frameAndTickRate) throws SubtitleDecoderException {
        double d;
        double d2;
        Matcher matcher = CLOCK_TIME.matcher(str);
        char c = 4;
        if (matcher.matches()) {
            double parseLong = (Long.parseLong(matcher.group(1)) * 3600) + (Long.parseLong(matcher.group(2)) * 60) + Long.parseLong(matcher.group(3));
            String group = matcher.group(4);
            return (long) ((parseLong + (group != null ? Double.parseDouble(group) : 0.0d) + (matcher.group(5) != null ? Long.parseLong(r13) / frameAndTickRate.effectiveFrameRate : 0.0d) + (matcher.group(6) != null ? (Long.parseLong(r13) / frameAndTickRate.subFrameRate) / frameAndTickRate.effectiveFrameRate : 0.0d)) * 1000000.0d);
        }
        Matcher matcher2 = OFFSET_TIME.matcher(str);
        if (!matcher2.matches()) {
            throw new SubtitleDecoderException("Malformed time expression: " + str);
        }
        double parseDouble = Double.parseDouble(matcher2.group(1));
        String group2 = matcher2.group(2);
        group2.hashCode();
        group2.hashCode();
        switch (group2.hashCode()) {
            case 102:
                if (group2.equals(InneractiveMediationDefs.GENDER_FEMALE)) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case 104:
                if (group2.equals("h")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 109:
                if (group2.equals("m")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case 116:
                if (group2.equals("t")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case 3494:
                break;
            default:
                c = 65535;
                break;
        }
        switch (c) {
            case 0:
                d = frameAndTickRate.effectiveFrameRate;
                parseDouble /= d;
                break;
            case 1:
                d2 = 3600.0d;
                break;
            case 2:
                d2 = 60.0d;
                break;
            case 3:
                d = frameAndTickRate.tickRate;
                parseDouble /= d;
                break;
            case 4:
                d = 1000.0d;
                parseDouble /= d;
                break;
        }
        parseDouble *= d2;
        return (long) (parseDouble * 1000000.0d);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mbridge.msdk.playercommon.exoplayer2.text.SimpleSubtitleDecoder
    public TtmlSubtitle decode(byte[] bArr, int i, boolean z) throws SubtitleDecoderException {
        try {
            XmlPullParser newPullParser = this.xmlParserFactory.newPullParser();
            HashMap hashMap = new HashMap();
            HashMap hashMap2 = new HashMap();
            TtmlSubtitle ttmlSubtitle = null;
            hashMap2.put("", new TtmlRegion(null));
            int i2 = 0;
            newPullParser.setInput(new ByteArrayInputStream(bArr, 0, i), null);
            ArrayDeque arrayDeque = new ArrayDeque();
            FrameAndTickRate frameAndTickRate = DEFAULT_FRAME_AND_TICK_RATE;
            CellResolution cellResolution = DEFAULT_CELL_RESOLUTION;
            for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.getEventType()) {
                TtmlNode ttmlNode = (TtmlNode) arrayDeque.peek();
                if (i2 == 0) {
                    String name = newPullParser.getName();
                    if (eventType == 2) {
                        if ("tt".equals(name)) {
                            frameAndTickRate = parseFrameAndTickRates(newPullParser);
                            cellResolution = parseCellResolution(newPullParser, DEFAULT_CELL_RESOLUTION);
                        }
                        if (!isSupportedTag(name)) {
                            Log.i(TAG, "Ignoring unsupported tag: " + newPullParser.getName());
                        } else if ("head".equals(name)) {
                            parseHeader(newPullParser, hashMap, hashMap2, cellResolution);
                        } else {
                            try {
                                TtmlNode parseNode = parseNode(newPullParser, ttmlNode, hashMap2, frameAndTickRate);
                                arrayDeque.push(parseNode);
                                if (ttmlNode != null) {
                                    ttmlNode.addChild(parseNode);
                                }
                            } catch (SubtitleDecoderException e) {
                                Log.w(TAG, "Suppressing parser error", e);
                            }
                        }
                        i2++;
                    } else if (eventType == 4) {
                        ttmlNode.addChild(TtmlNode.buildTextNode(newPullParser.getText()));
                    } else if (eventType == 3) {
                        if (newPullParser.getName().equals("tt")) {
                            ttmlSubtitle = new TtmlSubtitle((TtmlNode) arrayDeque.peek(), hashMap, hashMap2);
                        }
                        arrayDeque.pop();
                    }
                } else {
                    if (eventType != 2) {
                        if (eventType == 3) {
                            i2--;
                        }
                    }
                    i2++;
                }
                newPullParser.next();
            }
            return ttmlSubtitle;
        } catch (IOException e2) {
            throw new IllegalStateException("Unexpected error when reading input.", e2);
        } catch (XmlPullParserException e3) {
            throw new SubtitleDecoderException("Unable to decode source", e3);
        }
    }

    private TtmlNode parseNode(XmlPullParser xmlPullParser, TtmlNode ttmlNode, Map<String, TtmlRegion> map, FrameAndTickRate frameAndTickRate) throws SubtitleDecoderException {
        long j;
        String attributeValue;
        int attributeCount = xmlPullParser.getAttributeCount();
        TtmlStyle parseStyleAttributes = parseStyleAttributes(xmlPullParser, null);
        String[] strArr = null;
        String str = "";
        long j2 = -9223372036854775807L;
        long j3 = -9223372036854775807L;
        long j4 = -9223372036854775807L;
        for (int i = 0; i < attributeCount; i++) {
            String attributeName = xmlPullParser.getAttributeName(i);
            attributeValue = xmlPullParser.getAttributeValue(i);
            attributeName.hashCode();
            attributeName.hashCode();
            switch (attributeName) {
                case "region":
                    if (!map.containsKey(attributeValue)) {
                        break;
                    } else {
                        str = attributeValue;
                        continue;
                    }
                case "dur":
                    j4 = parseTimeExpression(attributeValue, frameAndTickRate);
                    break;
                case "end":
                    j3 = parseTimeExpression(attributeValue, frameAndTickRate);
                    break;
                case "begin":
                    j2 = parseTimeExpression(attributeValue, frameAndTickRate);
                    break;
                case "style":
                    String[] parseStyleIds = parseStyleIds(attributeValue);
                    if (parseStyleIds.length > 0) {
                        strArr = parseStyleIds;
                        break;
                    }
                    break;
            }
        }
        if (ttmlNode != null) {
            long j5 = ttmlNode.startTimeUs;
            if (j5 != -9223372036854775807L) {
                if (j2 != -9223372036854775807L) {
                    j2 += j5;
                }
                if (j3 != -9223372036854775807L) {
                    j3 += j5;
                }
            }
        }
        long j6 = j2;
        if (j3 == -9223372036854775807L) {
            if (j4 != -9223372036854775807L) {
                j3 = j6 + j4;
            } else if (ttmlNode != null) {
                long j7 = ttmlNode.endTimeUs;
                if (j7 != -9223372036854775807L) {
                    j = j7;
                    return TtmlNode.buildNode(xmlPullParser.getName(), j6, j, parseStyleAttributes, strArr, str);
                }
            }
        }
        j = j3;
        return TtmlNode.buildNode(xmlPullParser.getName(), j6, j, parseStyleAttributes, strArr, str);
    }
}
