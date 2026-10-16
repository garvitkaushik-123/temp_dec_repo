package com.google.android.exoplayer2.text.ttml;

import android.text.Layout;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.google.android.exoplayer2.text.SimpleSubtitleDecoder;
import com.google.android.exoplayer2.text.Subtitle;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ColorParser;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.util.XmlPullParserUtil;
import com.google.common.base.Ascii;
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

@Deprecated
/* loaded from: classes4.dex */
public final class TtmlDecoder extends SimpleSubtitleDecoder {
    private static final String ATTR_BEGIN = "begin";
    private static final String ATTR_DURATION = "dur";
    private static final String ATTR_END = "end";
    private static final String ATTR_IMAGE = "backgroundImage";
    private static final String ATTR_REGION = "region";
    private static final String ATTR_STYLE = "style";
    private static final int DEFAULT_FRAME_RATE = 30;
    private static final String TAG = "TtmlDecoder";
    private static final String TTP = "http://www.w3.org/ns/ttml#parameter";
    private final XmlPullParserFactory xmlParserFactory;
    private static final Pattern CLOCK_TIME = Pattern.compile("^([0-9][0-9]+):([0-9][0-9]):([0-9][0-9])(?:(\\.[0-9]+)|:([0-9][0-9])(?:\\.([0-9]+))?)?$");
    private static final Pattern OFFSET_TIME = Pattern.compile("^([0-9]+(?:\\.[0-9]+)?)(h|m|s|ms|f|t)$");
    private static final Pattern FONT_SIZE = Pattern.compile("^(([0-9]*.)?[0-9]+)(px|em|%)$");
    static final Pattern SIGNED_PERCENTAGE = Pattern.compile("^([-+]?\\d+\\.?\\d*?)%$");
    static final Pattern PERCENTAGE_COORDINATES = Pattern.compile("^(\\d+\\.?\\d*?)% (\\d+\\.?\\d*?)%$");
    private static final Pattern PIXEL_COORDINATES = Pattern.compile("^(\\d+\\.?\\d*?)px (\\d+\\.?\\d*?)px$");
    private static final Pattern CELL_RESOLUTION = Pattern.compile("^(\\d+) (\\d+)$");
    private static final FrameAndTickRate DEFAULT_FRAME_AND_TICK_RATE = new FrameAndTickRate(30.0f, 1, 1);
    private static final CellResolution DEFAULT_CELL_RESOLUTION = new CellResolution(32, 15);

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

    @Override // com.google.android.exoplayer2.text.SimpleSubtitleDecoder
    protected Subtitle decode(byte[] bArr, int i, boolean z) throws SubtitleDecoderException {
        try {
            XmlPullParser newPullParser = this.xmlParserFactory.newPullParser();
            HashMap hashMap = new HashMap();
            HashMap hashMap2 = new HashMap();
            HashMap hashMap3 = new HashMap();
            hashMap2.put("", new TtmlRegion(""));
            int i2 = 0;
            TtsExtent ttsExtent = null;
            newPullParser.setInput(new ByteArrayInputStream(bArr, 0, i), null);
            ArrayDeque arrayDeque = new ArrayDeque();
            FrameAndTickRate frameAndTickRate = DEFAULT_FRAME_AND_TICK_RATE;
            CellResolution cellResolution = DEFAULT_CELL_RESOLUTION;
            TtmlSubtitle ttmlSubtitle = null;
            for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.getEventType()) {
                TtmlNode ttmlNode = (TtmlNode) arrayDeque.peek();
                if (i2 == 0) {
                    String name = newPullParser.getName();
                    if (eventType == 2) {
                        if ("tt".equals(name)) {
                            frameAndTickRate = parseFrameAndTickRates(newPullParser);
                            cellResolution = parseCellResolution(newPullParser, DEFAULT_CELL_RESOLUTION);
                            ttsExtent = parseTtsExtent(newPullParser);
                        }
                        FrameAndTickRate frameAndTickRate2 = frameAndTickRate;
                        TtsExtent ttsExtent2 = ttsExtent;
                        CellResolution cellResolution2 = cellResolution;
                        if (!isSupportedTag(name)) {
                            Log.i(TAG, "Ignoring unsupported tag: " + newPullParser.getName());
                        } else {
                            if ("head".equals(name)) {
                                parseHeader(newPullParser, hashMap, cellResolution2, ttsExtent2, hashMap2, hashMap3);
                            } else {
                                try {
                                    TtmlNode parseNode = parseNode(newPullParser, ttmlNode, hashMap2, frameAndTickRate2);
                                    arrayDeque.push(parseNode);
                                    if (ttmlNode != null) {
                                        ttmlNode.addChild(parseNode);
                                    }
                                } catch (SubtitleDecoderException e) {
                                    Log.w(TAG, "Suppressing parser error", e);
                                }
                            }
                            cellResolution = cellResolution2;
                            ttsExtent = ttsExtent2;
                            frameAndTickRate = frameAndTickRate2;
                        }
                        i2++;
                        cellResolution = cellResolution2;
                        ttsExtent = ttsExtent2;
                        frameAndTickRate = frameAndTickRate2;
                    } else if (eventType == 4) {
                        ((TtmlNode) Assertions.checkNotNull(ttmlNode)).addChild(TtmlNode.buildTextNode(newPullParser.getText()));
                    } else if (eventType == 3) {
                        if (newPullParser.getName().equals("tt")) {
                            ttmlSubtitle = new TtmlSubtitle((TtmlNode) Assertions.checkNotNull((TtmlNode) arrayDeque.peek()), hashMap, hashMap2, hashMap3);
                        }
                        arrayDeque.pop();
                    }
                } else if (eventType == 2) {
                    i2++;
                } else if (eventType == 3) {
                    i2--;
                }
                newPullParser.next();
            }
            if (ttmlSubtitle != null) {
                return ttmlSubtitle;
            }
            throw new SubtitleDecoderException("No TTML subtitles found");
        } catch (IOException e2) {
            throw new IllegalStateException("Unexpected error when reading input.", e2);
        } catch (XmlPullParserException e3) {
            throw new SubtitleDecoderException("Unable to decode source", e3);
        }
    }

    private static FrameAndTickRate parseFrameAndTickRates(XmlPullParser xmlPullParser) throws SubtitleDecoderException {
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

    private static CellResolution parseCellResolution(XmlPullParser xmlPullParser, CellResolution cellResolution) throws SubtitleDecoderException {
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
            int parseInt = Integer.parseInt((String) Assertions.checkNotNull(matcher.group(1)));
            int parseInt2 = Integer.parseInt((String) Assertions.checkNotNull(matcher.group(2)));
            if (parseInt == 0 || parseInt2 == 0) {
                throw new SubtitleDecoderException("Invalid cell resolution " + parseInt + " " + parseInt2);
            }
            return new CellResolution(parseInt, parseInt2);
        } catch (NumberFormatException unused) {
            Log.w(TAG, "Ignoring malformed cell resolution: " + attributeValue);
            return cellResolution;
        }
    }

    private static TtsExtent parseTtsExtent(XmlPullParser xmlPullParser) {
        String attributeValue = XmlPullParserUtil.getAttributeValue(xmlPullParser, "extent");
        if (attributeValue == null) {
            return null;
        }
        Matcher matcher = PIXEL_COORDINATES.matcher(attributeValue);
        if (!matcher.matches()) {
            Log.w(TAG, "Ignoring non-pixel tts extent: " + attributeValue);
            return null;
        }
        try {
            return new TtsExtent(Integer.parseInt((String) Assertions.checkNotNull(matcher.group(1))), Integer.parseInt((String) Assertions.checkNotNull(matcher.group(2))));
        } catch (NumberFormatException unused) {
            Log.w(TAG, "Ignoring malformed tts extent: " + attributeValue);
            return null;
        }
    }

    private static Map<String, TtmlStyle> parseHeader(XmlPullParser xmlPullParser, Map<String, TtmlStyle> map, CellResolution cellResolution, TtsExtent ttsExtent, Map<String, TtmlRegion> map2, Map<String, String> map3) throws IOException, XmlPullParserException {
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
                String id = parseStyleAttributes.getId();
                if (id != null) {
                    map.put(id, parseStyleAttributes);
                }
            } else if (XmlPullParserUtil.isStartTag(xmlPullParser, "region")) {
                TtmlRegion parseRegionAttributes = parseRegionAttributes(xmlPullParser, cellResolution, ttsExtent);
                if (parseRegionAttributes != null) {
                    map2.put(parseRegionAttributes.id, parseRegionAttributes);
                }
            } else if (XmlPullParserUtil.isStartTag(xmlPullParser, "metadata")) {
                parseMetadata(xmlPullParser, map3);
            }
        } while (!XmlPullParserUtil.isEndTag(xmlPullParser, "head"));
        return map;
    }

    private static void parseMetadata(XmlPullParser xmlPullParser, Map<String, String> map) throws IOException, XmlPullParserException {
        String attributeValue;
        do {
            xmlPullParser.next();
            if (XmlPullParserUtil.isStartTag(xmlPullParser, "image") && (attributeValue = XmlPullParserUtil.getAttributeValue(xmlPullParser, "id")) != null) {
                map.put(attributeValue, xmlPullParser.nextText());
            }
        } while (!XmlPullParserUtil.isEndTag(xmlPullParser, "metadata"));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x01a2, code lost:
    
        if (r0.equals("tb") == false) goto L50;
     */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0175  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static TtmlRegion parseRegionAttributes(XmlPullParser xmlPullParser, CellResolution cellResolution, TtsExtent ttsExtent) {
        float parseFloat;
        float parseFloat2;
        float parseFloat3;
        float parseFloat4;
        CellResolution cellResolution2;
        int i;
        float f;
        String attributeValue;
        int i2;
        String attributeValue2 = XmlPullParserUtil.getAttributeValue(xmlPullParser, "id");
        if (attributeValue2 == null) {
            return null;
        }
        String attributeValue3 = XmlPullParserUtil.getAttributeValue(xmlPullParser, "origin");
        if (attributeValue3 == null) {
            Log.w(TAG, "Ignoring region without an origin");
            return null;
        }
        Pattern pattern = PERCENTAGE_COORDINATES;
        Matcher matcher = pattern.matcher(attributeValue3);
        Pattern pattern2 = PIXEL_COORDINATES;
        Matcher matcher2 = pattern2.matcher(attributeValue3);
        int i3 = 2;
        if (matcher.matches()) {
            try {
                parseFloat = Float.parseFloat((String) Assertions.checkNotNull(matcher.group(1))) / 100.0f;
                parseFloat2 = Float.parseFloat((String) Assertions.checkNotNull(matcher.group(2))) / 100.0f;
            } catch (NumberFormatException unused) {
                Log.w(TAG, "Ignoring region with malformed origin: " + attributeValue3);
                return null;
            }
        } else {
            if (!matcher2.matches()) {
                Log.w(TAG, "Ignoring region with unsupported origin: " + attributeValue3);
                return null;
            }
            if (ttsExtent == null) {
                Log.w(TAG, "Ignoring region with missing tts:extent: " + attributeValue3);
                return null;
            }
            try {
                int parseInt = Integer.parseInt((String) Assertions.checkNotNull(matcher2.group(1)));
                float f2 = parseInt / ttsExtent.width;
                float parseInt2 = Integer.parseInt((String) Assertions.checkNotNull(matcher2.group(2))) / ttsExtent.height;
                parseFloat = f2;
                parseFloat2 = parseInt2;
            } catch (NumberFormatException unused2) {
                Log.w(TAG, "Ignoring region with malformed origin: " + attributeValue3);
                return null;
            }
        }
        String attributeValue4 = XmlPullParserUtil.getAttributeValue(xmlPullParser, "extent");
        if (attributeValue4 == null) {
            Log.w(TAG, "Ignoring region without an extent");
            return null;
        }
        Matcher matcher3 = pattern.matcher(attributeValue4);
        Matcher matcher4 = pattern2.matcher(attributeValue4);
        if (matcher3.matches()) {
            try {
                parseFloat3 = Float.parseFloat((String) Assertions.checkNotNull(matcher3.group(1))) / 100.0f;
                parseFloat4 = Float.parseFloat((String) Assertions.checkNotNull(matcher3.group(2))) / 100.0f;
            } catch (NumberFormatException unused3) {
                Log.w(TAG, "Ignoring region with malformed extent: " + attributeValue3);
                return null;
            }
        } else {
            if (!matcher4.matches()) {
                Log.w(TAG, "Ignoring region with unsupported extent: " + attributeValue3);
                return null;
            }
            if (ttsExtent == null) {
                Log.w(TAG, "Ignoring region with missing tts:extent: " + attributeValue3);
                return null;
            }
            try {
                int parseInt3 = Integer.parseInt((String) Assertions.checkNotNull(matcher4.group(1)));
                float f3 = parseInt3 / ttsExtent.width;
                parseFloat4 = Integer.parseInt((String) Assertions.checkNotNull(matcher4.group(2))) / ttsExtent.height;
                parseFloat3 = f3;
            } catch (NumberFormatException unused4) {
                Log.w(TAG, "Ignoring region with malformed extent: " + attributeValue3);
                return null;
            }
        }
        float f4 = parseFloat4;
        String attributeValue5 = XmlPullParserUtil.getAttributeValue(xmlPullParser, "displayAlign");
        boolean z = false;
        if (attributeValue5 != null) {
            String lowerCase = Ascii.toLowerCase(attributeValue5);
            lowerCase.hashCode();
            if (lowerCase.equals("center")) {
                cellResolution2 = cellResolution;
                f = parseFloat2 + (f4 / 2.0f);
                i = 1;
            } else if (lowerCase.equals("after")) {
                cellResolution2 = cellResolution;
                f = parseFloat2 + f4;
                i = 2;
            }
            float f5 = 1.0f / cellResolution2.rows;
            attributeValue = XmlPullParserUtil.getAttributeValue(xmlPullParser, "writingMode");
            if (attributeValue != null) {
                String lowerCase2 = Ascii.toLowerCase(attributeValue);
                lowerCase2.hashCode();
                switch (lowerCase2.hashCode()) {
                    case 3694:
                        break;
                    case 3553396:
                        if (lowerCase2.equals("tblr")) {
                            z = true;
                            break;
                        }
                        z = -1;
                        break;
                    case 3553576:
                        if (lowerCase2.equals("tbrl")) {
                            z = 2;
                            break;
                        }
                        z = -1;
                        break;
                    default:
                        z = -1;
                        break;
                }
                switch (z) {
                    case false:
                    case true:
                        i2 = i3;
                        break;
                    case true:
                        i2 = 1;
                        break;
                }
                return new TtmlRegion(attributeValue2, parseFloat, f, 0, i, parseFloat3, f4, 1, f5, i2);
            }
            i3 = Integer.MIN_VALUE;
            i2 = i3;
            return new TtmlRegion(attributeValue2, parseFloat, f, 0, i, parseFloat3, f4, 1, f5, i2);
        }
        cellResolution2 = cellResolution;
        i = 0;
        f = parseFloat2;
        float f52 = 1.0f / cellResolution2.rows;
        attributeValue = XmlPullParserUtil.getAttributeValue(xmlPullParser, "writingMode");
        if (attributeValue != null) {
        }
        i3 = Integer.MIN_VALUE;
        i2 = i3;
        return new TtmlRegion(attributeValue2, parseFloat, f, 0, i, parseFloat3, f4, 1, f52, i2);
    }

    private static String[] parseStyleIds(String str) {
        String trim = str.trim();
        return trim.isEmpty() ? new String[0] : Util.split(trim, "\\s+");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x01da, code lost:
    
        if (r3.equals("text") == false) goto L100;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static TtmlStyle parseStyleAttributes(XmlPullParser xmlPullParser, TtmlStyle ttmlStyle) {
        char c;
        int attributeCount = xmlPullParser.getAttributeCount();
        for (int i = 0; i < attributeCount; i++) {
            String attributeValue = xmlPullParser.getAttributeValue(i);
            String attributeName = xmlPullParser.getAttributeName(i);
            attributeName.hashCode();
            char c2 = 5;
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
                case 3511770:
                    if (attributeName.equals("ruby")) {
                        c = 6;
                        break;
                    }
                    c = 65535;
                    break;
                case 94842723:
                    if (attributeName.equals("color")) {
                        c = 7;
                        break;
                    }
                    c = 65535;
                    break;
                case 109403361:
                    if (attributeName.equals("shear")) {
                        c = '\b';
                        break;
                    }
                    c = 65535;
                    break;
                case 110138194:
                    if (attributeName.equals("textCombine")) {
                        c = '\t';
                        break;
                    }
                    c = 65535;
                    break;
                case 365601008:
                    if (attributeName.equals("fontSize")) {
                        c = '\n';
                        break;
                    }
                    c = 65535;
                    break;
                case 921125321:
                    if (attributeName.equals("textEmphasis")) {
                        c = 11;
                        break;
                    }
                    c = 65535;
                    break;
                case 1115953443:
                    if (attributeName.equals("rubyPosition")) {
                        c = '\f';
                        break;
                    }
                    c = 65535;
                    break;
                case 1287124693:
                    if (attributeName.equals("backgroundColor")) {
                        c = '\r';
                        break;
                    }
                    c = 65535;
                    break;
                case 1754920356:
                    if (attributeName.equals("multiRowAlign")) {
                        c = 14;
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
                    ttmlStyle = createIfNull(ttmlStyle).setTextAlign(parseAlignment(attributeValue));
                    break;
                case 3:
                    String lowerCase = Ascii.toLowerCase(attributeValue);
                    lowerCase.hashCode();
                    switch (lowerCase) {
                        case "nounderline":
                            ttmlStyle = createIfNull(ttmlStyle).setUnderline(false);
                            break;
                        case "underline":
                            ttmlStyle = createIfNull(ttmlStyle).setUnderline(true);
                            break;
                        case "nolinethrough":
                            ttmlStyle = createIfNull(ttmlStyle).setLinethrough(false);
                            break;
                        case "linethrough":
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
                    String lowerCase2 = Ascii.toLowerCase(attributeValue);
                    lowerCase2.hashCode();
                    switch (lowerCase2.hashCode()) {
                        case -618561360:
                            if (lowerCase2.equals("baseContainer")) {
                                c2 = 0;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case -410956671:
                            if (lowerCase2.equals("container")) {
                                c2 = 1;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case -250518009:
                            if (lowerCase2.equals("delimiter")) {
                                c2 = 2;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case -136074796:
                            if (lowerCase2.equals("textContainer")) {
                                c2 = 3;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case 3016401:
                            if (lowerCase2.equals("base")) {
                                c2 = 4;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case 3556653:
                            break;
                        default:
                            c2 = 65535;
                            break;
                    }
                    switch (c2) {
                        case 0:
                        case 4:
                            ttmlStyle = createIfNull(ttmlStyle).setRubyType(2);
                            break;
                        case 1:
                            ttmlStyle = createIfNull(ttmlStyle).setRubyType(1);
                            break;
                        case 2:
                            ttmlStyle = createIfNull(ttmlStyle).setRubyType(4);
                            break;
                        case 3:
                        case 5:
                            ttmlStyle = createIfNull(ttmlStyle).setRubyType(3);
                            break;
                    }
                case 7:
                    ttmlStyle = createIfNull(ttmlStyle);
                    try {
                        ttmlStyle.setFontColor(ColorParser.parseTtmlColor(attributeValue));
                        break;
                    } catch (IllegalArgumentException unused) {
                        Log.w(TAG, "Failed parsing color value: " + attributeValue);
                        break;
                    }
                case '\b':
                    ttmlStyle = createIfNull(ttmlStyle).setShearPercentage(parseShear(attributeValue));
                    break;
                case '\t':
                    String lowerCase3 = Ascii.toLowerCase(attributeValue);
                    lowerCase3.hashCode();
                    if (lowerCase3.equals("all")) {
                        ttmlStyle = createIfNull(ttmlStyle).setTextCombine(true);
                        break;
                    } else if (lowerCase3.equals("none")) {
                        ttmlStyle = createIfNull(ttmlStyle).setTextCombine(false);
                        break;
                    } else {
                        break;
                    }
                case '\n':
                    try {
                        ttmlStyle = createIfNull(ttmlStyle);
                        parseFontSize(attributeValue, ttmlStyle);
                        break;
                    } catch (SubtitleDecoderException unused2) {
                        Log.w(TAG, "Failed parsing fontSize value: " + attributeValue);
                        break;
                    }
                case 11:
                    ttmlStyle = createIfNull(ttmlStyle).setTextEmphasis(TextEmphasis.parse(attributeValue));
                    break;
                case '\f':
                    String lowerCase4 = Ascii.toLowerCase(attributeValue);
                    lowerCase4.hashCode();
                    if (lowerCase4.equals("before")) {
                        ttmlStyle = createIfNull(ttmlStyle).setRubyPosition(1);
                        break;
                    } else if (lowerCase4.equals("after")) {
                        ttmlStyle = createIfNull(ttmlStyle).setRubyPosition(2);
                        break;
                    } else {
                        break;
                    }
                case '\r':
                    ttmlStyle = createIfNull(ttmlStyle);
                    try {
                        ttmlStyle.setBackgroundColor(ColorParser.parseTtmlColor(attributeValue));
                        break;
                    } catch (IllegalArgumentException unused3) {
                        Log.w(TAG, "Failed parsing background value: " + attributeValue);
                        break;
                    }
                case 14:
                    ttmlStyle = createIfNull(ttmlStyle).setMultiRowAlign(parseAlignment(attributeValue));
                    break;
            }
        }
        return ttmlStyle;
    }

    private static TtmlStyle createIfNull(TtmlStyle ttmlStyle) {
        return ttmlStyle == null ? new TtmlStyle() : ttmlStyle;
    }

    private static Layout.Alignment parseAlignment(String str) {
        String lowerCase = Ascii.toLowerCase(str);
        lowerCase.hashCode();
        switch (lowerCase) {
            case "center":
                return Layout.Alignment.ALIGN_CENTER;
            case "end":
            case "right":
                return Layout.Alignment.ALIGN_OPPOSITE;
            case "left":
            case "start":
                return Layout.Alignment.ALIGN_NORMAL;
            default:
                return null;
        }
    }

    private static TtmlNode parseNode(XmlPullParser xmlPullParser, TtmlNode ttmlNode, Map<String, TtmlRegion> map, FrameAndTickRate frameAndTickRate) throws SubtitleDecoderException {
        String attributeValue;
        XmlPullParser xmlPullParser2 = xmlPullParser;
        int attributeCount = xmlPullParser2.getAttributeCount();
        String str = null;
        TtmlStyle parseStyleAttributes = parseStyleAttributes(xmlPullParser2, null);
        long j = -9223372036854775807L;
        long j2 = -9223372036854775807L;
        long j3 = -9223372036854775807L;
        String[] strArr = null;
        String str2 = "";
        int i = 0;
        while (i < attributeCount) {
            String attributeName = xmlPullParser2.getAttributeName(i);
            int i2 = attributeCount;
            attributeValue = xmlPullParser2.getAttributeValue(i);
            attributeName.hashCode();
            switch (attributeName) {
                case "region":
                    if (!map.containsKey(attributeValue)) {
                        break;
                    } else {
                        str2 = attributeValue;
                        continue;
                    }
                case "dur":
                    j3 = parseTimeExpression(attributeValue, frameAndTickRate);
                    break;
                case "end":
                    j2 = parseTimeExpression(attributeValue, frameAndTickRate);
                    break;
                case "begin":
                    j = parseTimeExpression(attributeValue, frameAndTickRate);
                    break;
                case "style":
                    String[] parseStyleIds = parseStyleIds(attributeValue);
                    if (parseStyleIds.length > 0) {
                        strArr = parseStyleIds;
                        break;
                    }
                    break;
                case "backgroundImage":
                    if (attributeValue.startsWith("#")) {
                        str = attributeValue.substring(1);
                        break;
                    }
                    break;
            }
            i++;
            xmlPullParser2 = xmlPullParser;
            attributeCount = i2;
        }
        if (ttmlNode != null && ttmlNode.startTimeUs != -9223372036854775807L) {
            if (j != -9223372036854775807L) {
                j += ttmlNode.startTimeUs;
            }
            if (j2 != -9223372036854775807L) {
                j2 += ttmlNode.startTimeUs;
            }
        }
        long j4 = j;
        if (j2 == -9223372036854775807L) {
            if (j3 != -9223372036854775807L) {
                j2 = j4 + j3;
            } else if (ttmlNode != null && ttmlNode.endTimeUs != -9223372036854775807L) {
                j2 = ttmlNode.endTimeUs;
            }
        }
        return TtmlNode.buildNode(xmlPullParser.getName(), j4, j2, parseStyleAttributes, strArr, str2, str, ttmlNode);
    }

    private static boolean isSupportedTag(String str) {
        return str.equals("tt") || str.equals("head") || str.equals("body") || str.equals("div") || str.equals("p") || str.equals("span") || str.equals("br") || str.equals("style") || str.equals("styling") || str.equals("layout") || str.equals("region") || str.equals("metadata") || str.equals("image") || str.equals("data") || str.equals("information");
    }

    private static void parseFontSize(String str, TtmlStyle ttmlStyle) throws SubtitleDecoderException {
        Matcher matcher;
        String str2;
        String[] split = Util.split(str, "\\s+");
        if (split.length == 1) {
            matcher = FONT_SIZE.matcher(str);
        } else if (split.length == 2) {
            matcher = FONT_SIZE.matcher(split[1]);
            Log.w(TAG, "Multiple values in fontSize attribute. Picking the second value for vertical font size and ignoring the first.");
        } else {
            throw new SubtitleDecoderException("Invalid number of entries for fontSize: " + split.length + ".");
        }
        if (matcher.matches()) {
            str2 = (String) Assertions.checkNotNull(matcher.group(3));
            str2.hashCode();
            switch (str2) {
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
                    throw new SubtitleDecoderException("Invalid unit for fontSize: '" + str2 + "'.");
            }
            ttmlStyle.setFontSize(Float.parseFloat((String) Assertions.checkNotNull(matcher.group(1))));
            return;
        }
        throw new SubtitleDecoderException("Invalid expression for fontSize: '" + str + "'.");
    }

    private static float parseShear(String str) {
        Matcher matcher = SIGNED_PERCENTAGE.matcher(str);
        if (!matcher.matches()) {
            Log.w(TAG, "Invalid value for shear: " + str);
            return Float.MAX_VALUE;
        }
        try {
            return Math.min(100.0f, Math.max(-100.0f, Float.parseFloat((String) Assertions.checkNotNull(matcher.group(1)))));
        } catch (NumberFormatException e) {
            Log.w(TAG, "Failed to parse shear: " + str, e);
            return Float.MAX_VALUE;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00bc, code lost:
    
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
            double parseLong = (Long.parseLong((String) Assertions.checkNotNull(matcher.group(1))) * 3600) + (Long.parseLong((String) Assertions.checkNotNull(matcher.group(2))) * 60) + Long.parseLong((String) Assertions.checkNotNull(matcher.group(3)));
            String group = matcher.group(4);
            return (long) ((parseLong + (group != null ? Double.parseDouble(group) : 0.0d) + (matcher.group(5) != null ? Long.parseLong(r13) / frameAndTickRate.effectiveFrameRate : 0.0d) + (matcher.group(6) != null ? (Long.parseLong(r13) / frameAndTickRate.subFrameRate) / frameAndTickRate.effectiveFrameRate : 0.0d)) * 1000000.0d);
        }
        Matcher matcher2 = OFFSET_TIME.matcher(str);
        if (matcher2.matches()) {
            double parseDouble = Double.parseDouble((String) Assertions.checkNotNull(matcher2.group(1)));
            String str2 = (String) Assertions.checkNotNull(matcher2.group(2));
            str2.hashCode();
            switch (str2.hashCode()) {
                case 102:
                    if (str2.equals(InneractiveMediationDefs.GENDER_FEMALE)) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                case 104:
                    if (str2.equals("h")) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case 109:
                    if (str2.equals("m")) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case 116:
                    if (str2.equals("t")) {
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
        throw new SubtitleDecoderException("Malformed time expression: " + str);
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

    private static final class CellResolution {
        final int columns;
        final int rows;

        CellResolution(int i, int i2) {
            this.columns = i;
            this.rows = i2;
        }
    }

    private static final class TtsExtent {
        final int height;
        final int width;

        TtsExtent(int i, int i2) {
            this.width = i;
            this.height = i2;
        }
    }
}
