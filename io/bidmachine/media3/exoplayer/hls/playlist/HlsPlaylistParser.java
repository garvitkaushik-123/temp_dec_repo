package io.bidmachine.media3.exoplayer.hls.playlist;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.ironsource.C3040d4;
import io.bidmachine.iab.vast.tags.VastAttributes;
import io.bidmachine.media3.common.C;
import io.bidmachine.media3.common.DrmInitData;
import io.bidmachine.media3.common.Format;
import io.bidmachine.media3.common.Metadata;
import io.bidmachine.media3.common.MimeTypes;
import io.bidmachine.media3.common.ParserException;
import io.bidmachine.media3.common.util.Assertions;
import io.bidmachine.media3.common.util.Log;
import io.bidmachine.media3.common.util.UriUtil;
import io.bidmachine.media3.common.util.Util;
import io.bidmachine.media3.exoplayer.hls.HlsTrackMetadataEntry;
import io.bidmachine.media3.exoplayer.hls.playlist.HlsMediaPlaylist;
import io.bidmachine.media3.exoplayer.hls.playlist.HlsMultivariantPlaylist;
import io.bidmachine.media3.exoplayer.upstream.ParsingLoadable;
import io.bidmachine.media3.extractor.mp4.PsshAtomUtil;
import io.ktor.http.LinkHeader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;

/* loaded from: classes7.dex */
public final class HlsPlaylistParser implements ParsingLoadable.Parser<HlsPlaylist> {
    private static final String ATTR_CLOSED_CAPTIONS_NONE = "CLOSED-CAPTIONS=NONE";
    private static final String BOOLEAN_FALSE = "NO";
    private static final String BOOLEAN_TRUE = "YES";
    private static final String DATERANGE_CLASS_INTERSTITIALS = "com.apple.hls.interstitial";
    private static final String KEYFORMAT_IDENTITY = "identity";
    private static final String KEYFORMAT_PLAYREADY = "com.microsoft.playready";
    private static final String KEYFORMAT_WIDEVINE_PSSH_BINARY = "urn:uuid:edef8ba9-79d6-4ace-a3c8-27dcd51d21ed";
    private static final String KEYFORMAT_WIDEVINE_PSSH_JSON = "com.widevine";
    private static final String LOG_TAG = "HlsPlaylistParser";
    private static final String METHOD_AES_128 = "AES-128";
    private static final String METHOD_NONE = "NONE";
    private static final String METHOD_SAMPLE_AES = "SAMPLE-AES";
    private static final String METHOD_SAMPLE_AES_CENC = "SAMPLE-AES-CENC";
    private static final String METHOD_SAMPLE_AES_CTR = "SAMPLE-AES-CTR";
    private static final String PLAYLIST_HEADER = "#EXTM3U";
    private static final String TAG_BYTERANGE = "#EXT-X-BYTERANGE";
    private static final String TAG_DATERANGE = "#EXT-X-DATERANGE";
    private static final String TAG_DEFINE = "#EXT-X-DEFINE";
    private static final String TAG_DISCONTINUITY = "#EXT-X-DISCONTINUITY";
    private static final String TAG_DISCONTINUITY_SEQUENCE = "#EXT-X-DISCONTINUITY-SEQUENCE";
    private static final String TAG_ENDLIST = "#EXT-X-ENDLIST";
    private static final String TAG_GAP = "#EXT-X-GAP";
    private static final String TAG_IFRAME = "#EXT-X-I-FRAMES-ONLY";
    private static final String TAG_INDEPENDENT_SEGMENTS = "#EXT-X-INDEPENDENT-SEGMENTS";
    private static final String TAG_INIT_SEGMENT = "#EXT-X-MAP";
    private static final String TAG_I_FRAME_STREAM_INF = "#EXT-X-I-FRAME-STREAM-INF";
    private static final String TAG_KEY = "#EXT-X-KEY";
    private static final String TAG_MEDIA = "#EXT-X-MEDIA";
    private static final String TAG_MEDIA_DURATION = "#EXTINF";
    private static final String TAG_MEDIA_SEQUENCE = "#EXT-X-MEDIA-SEQUENCE";
    private static final String TAG_PART = "#EXT-X-PART";
    private static final String TAG_PART_INF = "#EXT-X-PART-INF";
    private static final String TAG_PLAYLIST_TYPE = "#EXT-X-PLAYLIST-TYPE";
    private static final String TAG_PREFIX = "#EXT";
    private static final String TAG_PRELOAD_HINT = "#EXT-X-PRELOAD-HINT";
    private static final String TAG_PROGRAM_DATE_TIME = "#EXT-X-PROGRAM-DATE-TIME";
    private static final String TAG_RENDITION_REPORT = "#EXT-X-RENDITION-REPORT";
    private static final String TAG_SERVER_CONTROL = "#EXT-X-SERVER-CONTROL";
    private static final String TAG_SESSION_KEY = "#EXT-X-SESSION-KEY";
    private static final String TAG_SKIP = "#EXT-X-SKIP";
    private static final String TAG_START = "#EXT-X-START";
    private static final String TAG_STREAM_INF = "#EXT-X-STREAM-INF";
    private static final String TAG_TARGET_DURATION = "#EXT-X-TARGETDURATION";
    private static final String TAG_VERSION = "#EXT-X-VERSION";
    private static final String TYPE_AUDIO = "AUDIO";
    private static final String TYPE_CLOSED_CAPTIONS = "CLOSED-CAPTIONS";
    private static final String TYPE_MAP = "MAP";
    private static final String TYPE_PART = "PART";
    private static final String TYPE_SUBTITLES = "SUBTITLES";
    private static final String TYPE_VIDEO = "VIDEO";
    private final HlsMultivariantPlaylist multivariantPlaylist;
    private final HlsMediaPlaylist previousMediaPlaylist;
    private static final Pattern REGEX_AVERAGE_BANDWIDTH = Pattern.compile("AVERAGE-BANDWIDTH=(\\d+)\\b");
    private static final Pattern REGEX_VIDEO = Pattern.compile("VIDEO=\"(.+?)\"");
    private static final Pattern REGEX_AUDIO = Pattern.compile("AUDIO=\"(.+?)\"");
    private static final Pattern REGEX_SUBTITLES = Pattern.compile("SUBTITLES=\"(.+?)\"");
    private static final Pattern REGEX_CLOSED_CAPTIONS = Pattern.compile("CLOSED-CAPTIONS=\"(.+?)\"");
    private static final Pattern REGEX_BANDWIDTH = Pattern.compile("[^-]BANDWIDTH=(\\d+)\\b");
    private static final Pattern REGEX_CHANNELS = Pattern.compile("CHANNELS=\"(.+?)\"");
    private static final Pattern REGEX_VIDEO_RANGE = Pattern.compile("VIDEO-RANGE=(SDR|PQ|HLG)");
    private static final Pattern REGEX_CODECS = Pattern.compile("CODECS=\"(.+?)\"");
    private static final Pattern REGEX_SUPPLEMENTAL_CODECS = Pattern.compile("SUPPLEMENTAL-CODECS=\"(.+?)\"");
    private static final Pattern REGEX_RESOLUTION = Pattern.compile("RESOLUTION=(\\d+x\\d+)");
    private static final Pattern REGEX_FRAME_RATE = Pattern.compile("FRAME-RATE=([\\d\\.]+)\\b");
    private static final Pattern REGEX_TARGET_DURATION = Pattern.compile("#EXT-X-TARGETDURATION:(\\d+)\\b");
    private static final Pattern REGEX_ATTR_DURATION = Pattern.compile("DURATION=([\\d\\.]+)\\b");
    private static final Pattern REGEX_ATTR_DURATION_PREFIXED = Pattern.compile("[:,]DURATION=([\\d\\.]+)\\b");
    private static final Pattern REGEX_PART_TARGET_DURATION = Pattern.compile("PART-TARGET=([\\d\\.]+)\\b");
    private static final Pattern REGEX_VERSION = Pattern.compile("#EXT-X-VERSION:(\\d+)\\b");
    private static final Pattern REGEX_PLAYLIST_TYPE = Pattern.compile("#EXT-X-PLAYLIST-TYPE:(.+)\\b");
    private static final Pattern REGEX_CAN_SKIP_UNTIL = Pattern.compile("CAN-SKIP-UNTIL=([\\d\\.]+)\\b");
    private static final Pattern REGEX_CAN_SKIP_DATE_RANGES = compileBooleanAttrPattern("CAN-SKIP-DATERANGES");
    private static final Pattern REGEX_SKIPPED_SEGMENTS = Pattern.compile("SKIPPED-SEGMENTS=(\\d+)\\b");
    private static final Pattern REGEX_HOLD_BACK = Pattern.compile("[:|,]HOLD-BACK=([\\d\\.]+)\\b");
    private static final Pattern REGEX_PART_HOLD_BACK = Pattern.compile("PART-HOLD-BACK=([\\d\\.]+)\\b");
    private static final Pattern REGEX_CAN_BLOCK_RELOAD = compileBooleanAttrPattern("CAN-BLOCK-RELOAD");
    private static final Pattern REGEX_MEDIA_SEQUENCE = Pattern.compile("#EXT-X-MEDIA-SEQUENCE:(\\d+)\\b");
    private static final Pattern REGEX_MEDIA_DURATION = Pattern.compile("#EXTINF:([\\d\\.]+)\\b");
    private static final Pattern REGEX_MEDIA_TITLE = Pattern.compile("#EXTINF:[\\d\\.]+\\b,(.+)");
    private static final Pattern REGEX_LAST_MSN = Pattern.compile("LAST-MSN=(\\d+)\\b");
    private static final Pattern REGEX_LAST_PART = Pattern.compile("LAST-PART=(\\d+)\\b");
    private static final Pattern REGEX_TIME_OFFSET = Pattern.compile("TIME-OFFSET=(-?[\\d\\.]+)\\b");
    private static final Pattern REGEX_BYTERANGE = Pattern.compile("#EXT-X-BYTERANGE:(\\d+(?:@\\d+)?)\\b");
    private static final Pattern REGEX_ATTR_BYTERANGE = Pattern.compile("BYTERANGE=\"(\\d+(?:@\\d+)?)\\b\"");
    private static final Pattern REGEX_BYTERANGE_START = Pattern.compile("BYTERANGE-START=(\\d+)\\b");
    private static final Pattern REGEX_BYTERANGE_LENGTH = Pattern.compile("BYTERANGE-LENGTH=(\\d+)\\b");
    private static final Pattern REGEX_METHOD = Pattern.compile("METHOD=(NONE|AES-128|SAMPLE-AES|SAMPLE-AES-CENC|SAMPLE-AES-CTR)\\s*(?:,|$)");
    private static final Pattern REGEX_KEYFORMAT = Pattern.compile("KEYFORMAT=\"(.+?)\"");
    private static final Pattern REGEX_KEYFORMATVERSIONS = Pattern.compile("KEYFORMATVERSIONS=\"(.+?)\"");
    private static final Pattern REGEX_URI = Pattern.compile("URI=\"(.+?)\"");
    private static final Pattern REGEX_IV = Pattern.compile("IV=([^,.*]+)");
    private static final Pattern REGEX_TYPE = Pattern.compile("TYPE=(AUDIO|VIDEO|SUBTITLES|CLOSED-CAPTIONS)");
    private static final Pattern REGEX_PRELOAD_HINT_TYPE = Pattern.compile("TYPE=(PART|MAP)");
    private static final Pattern REGEX_LANGUAGE = Pattern.compile("LANGUAGE=\"(.+?)\"");
    private static final Pattern REGEX_NAME = Pattern.compile("NAME=\"(.+?)\"");
    private static final Pattern REGEX_GROUP_ID = Pattern.compile("GROUP-ID=\"(.+?)\"");
    private static final Pattern REGEX_CHARACTERISTICS = Pattern.compile("CHARACTERISTICS=\"(.+?)\"");
    private static final Pattern REGEX_INSTREAM_ID = Pattern.compile("INSTREAM-ID=\"((?:CC|SERVICE)\\d+)\"");
    private static final Pattern REGEX_AUTOSELECT = compileBooleanAttrPattern("AUTOSELECT");
    private static final Pattern REGEX_DEFAULT = compileBooleanAttrPattern("DEFAULT");
    private static final Pattern REGEX_FORCED = compileBooleanAttrPattern("FORCED");
    private static final Pattern REGEX_INDEPENDENT = compileBooleanAttrPattern("INDEPENDENT");
    private static final Pattern REGEX_GAP = compileBooleanAttrPattern("GAP");
    private static final Pattern REGEX_PRECISE = compileBooleanAttrPattern("PRECISE");
    private static final Pattern REGEX_VALUE = Pattern.compile("VALUE=\"(.+?)\"");
    private static final Pattern REGEX_IMPORT = Pattern.compile("IMPORT=\"(.+?)\"");
    private static final Pattern REGEX_ID = Pattern.compile("[:,]ID=\"(.+?)\"");
    private static final Pattern REGEX_CLASS = Pattern.compile("CLASS=\"(.+?)\"");
    private static final Pattern REGEX_START_DATE = Pattern.compile("START-DATE=\"(.+?)\"");
    private static final Pattern REGEX_CUE = Pattern.compile("CUE=\"(.+?)\"");
    private static final Pattern REGEX_END_DATE = Pattern.compile("END-DATE=\"(.+?)\"");
    private static final Pattern REGEX_PLANNED_DURATION = Pattern.compile("PLANNED-DURATION=([\\d\\.]+)\\b");
    private static final Pattern REGEX_END_ON_NEXT = compileBooleanAttrPattern("END-ON-NEXT");
    private static final Pattern REGEX_ASSET_URI = Pattern.compile("X-ASSET-URI=\"(.+?)\"");
    private static final Pattern REGEX_ASSET_LIST_URI = Pattern.compile("X-ASSET-LIST=\"(.+?)\"");
    private static final Pattern REGEX_RESUME_OFFSET = Pattern.compile("X-RESUME-OFFSET=(-?[\\d\\.]+)\\b");
    private static final Pattern REGEX_PLAYOUT_LIMIT = Pattern.compile("X-PLAYOUT-LIMIT=([\\d\\.]+)\\b");
    private static final Pattern REGEX_SNAP = Pattern.compile("X-SNAP=\"(.+?)\"");
    private static final Pattern REGEX_RESTRICT = Pattern.compile("X-RESTRICT=\"(.+?)\"");
    private static final Pattern REGEX_VARIABLE_REFERENCE = Pattern.compile("\\{\\$([a-zA-Z0-9\\-_]+)\\}");
    private static final Pattern REGEX_CLIENT_DEFINED_ATTRIBUTE_PREFIX = Pattern.compile("\\b(X-[A-Z0-9-]+)=");

    public static final class DeltaUpdateException extends IOException {
    }

    public HlsPlaylistParser() {
        this(HlsMultivariantPlaylist.EMPTY, null);
    }

    public HlsPlaylistParser(HlsMultivariantPlaylist hlsMultivariantPlaylist, HlsMediaPlaylist hlsMediaPlaylist) {
        this.multivariantPlaylist = hlsMultivariantPlaylist;
        this.previousMediaPlaylist = hlsMediaPlaylist;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // io.bidmachine.media3.exoplayer.upstream.ParsingLoadable.Parser
    public HlsPlaylist parse(Uri uri, InputStream inputStream) throws IOException {
        String trim;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        ArrayDeque arrayDeque = new ArrayDeque();
        try {
            if (!checkPlaylistHeader(bufferedReader)) {
                throw ParserException.createForMalformedManifest("Input does not start with the #EXTM3U header.", null);
            }
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    trim = readLine.trim();
                    if (!trim.isEmpty()) {
                        if (trim.startsWith(TAG_STREAM_INF)) {
                            arrayDeque.add(trim);
                            return parseMultivariantPlaylist(new LineIterator(arrayDeque, bufferedReader), uri.toString());
                        }
                        if (trim.startsWith(TAG_TARGET_DURATION) || trim.startsWith(TAG_MEDIA_SEQUENCE) || trim.startsWith(TAG_MEDIA_DURATION) || trim.startsWith(TAG_KEY) || trim.startsWith(TAG_BYTERANGE) || trim.equals(TAG_DISCONTINUITY) || trim.equals(TAG_DISCONTINUITY_SEQUENCE) || trim.equals(TAG_ENDLIST)) {
                            break;
                        }
                        arrayDeque.add(trim);
                    }
                } else {
                    Util.closeQuietly(bufferedReader);
                    throw ParserException.createForMalformedManifest("Failed to parse the playlist, could not identify any tags.", null);
                }
            }
            arrayDeque.add(trim);
            return parseMediaPlaylist(this.multivariantPlaylist, this.previousMediaPlaylist, new LineIterator(arrayDeque, bufferedReader), uri.toString());
        } finally {
            Util.closeQuietly(bufferedReader);
        }
    }

    private static boolean checkPlaylistHeader(BufferedReader bufferedReader) throws IOException {
        int read = bufferedReader.read();
        if (read == 239) {
            if (bufferedReader.read() != 187 || bufferedReader.read() != 191) {
                return false;
            }
            read = bufferedReader.read();
        }
        int skipIgnorableWhitespace = skipIgnorableWhitespace(bufferedReader, true, read);
        int length = PLAYLIST_HEADER.length();
        for (int i = 0; i < length; i++) {
            if (skipIgnorableWhitespace != PLAYLIST_HEADER.charAt(i)) {
                return false;
            }
            skipIgnorableWhitespace = bufferedReader.read();
        }
        return Util.isLinebreak(skipIgnorableWhitespace(bufferedReader, false, skipIgnorableWhitespace));
    }

    private static int skipIgnorableWhitespace(BufferedReader bufferedReader, boolean z, int i) throws IOException {
        while (i != -1 && Character.isWhitespace(i) && (z || !Util.isLinebreak(i))) {
            i = bufferedReader.read();
        }
        return i;
    }

    private static boolean isDolbyVisionFormat(String str, String str2, String str3, String str4) {
        if (!MimeTypes.isDolbyVisionCodec(str2, str3)) {
            return false;
        }
        if (str3 == null) {
            return true;
        }
        if (str == null || str4 == null) {
            return false;
        }
        return (!str.equals("PQ") || str4.equals("db1p")) && (!str.equals("SDR") || str4.equals("db2g")) && (!str.equals("HLG") || str4.startsWith("db4"));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x017b  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x01a8  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x022e  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01d6  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01ad  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x019e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static HlsMultivariantPlaylist parseMultivariantPlaylist(LineIterator lineIterator, String str) throws IOException {
        char c;
        ArrayList arrayList;
        String str2;
        ArrayList arrayList2;
        int parseInt;
        String str3;
        ArrayList arrayList3;
        HlsMultivariantPlaylist.Variant variant;
        String str4;
        ArrayList arrayList4;
        ArrayList arrayList5;
        ArrayList arrayList6;
        ArrayList arrayList7;
        ArrayList arrayList8;
        ArrayList arrayList9;
        int i;
        String str5;
        String str6;
        String codecsOfType;
        String parseOptionalStringAttr;
        int i2;
        int i3;
        Uri resolveToUri;
        ArrayList arrayList10;
        int i4;
        String str7 = str;
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        ArrayList arrayList11 = new ArrayList();
        ArrayList arrayList12 = new ArrayList();
        ArrayList arrayList13 = new ArrayList();
        ArrayList arrayList14 = new ArrayList();
        ArrayList arrayList15 = new ArrayList();
        ArrayList arrayList16 = new ArrayList();
        ArrayList arrayList17 = new ArrayList();
        ArrayList arrayList18 = new ArrayList();
        boolean z = false;
        boolean z2 = false;
        while (true) {
            ArrayList arrayList19 = arrayList15;
            if (lineIterator.hasNext()) {
                String next = lineIterator.next();
                if (next.startsWith(TAG_PREFIX)) {
                    arrayList18.add(next);
                }
                boolean startsWith = next.startsWith(TAG_I_FRAME_STREAM_INF);
                if (next.startsWith(TAG_DEFINE)) {
                    hashMap2.put(parseStringAttr(next, REGEX_NAME, hashMap2), parseStringAttr(next, REGEX_VALUE, hashMap2));
                } else {
                    if (next.equals(TAG_INDEPENDENT_SEGMENTS)) {
                        arrayList8 = arrayList16;
                        arrayList9 = arrayList12;
                        arrayList7 = arrayList13;
                        arrayList6 = arrayList14;
                        arrayList4 = arrayList18;
                        arrayList5 = arrayList17;
                        z2 = true;
                    } else if (next.startsWith(TAG_MEDIA)) {
                        arrayList16.add(next);
                    } else if (next.startsWith(TAG_SESSION_KEY)) {
                        DrmInitData.SchemeData parseDrmSchemeData = parseDrmSchemeData(next, parseOptionalStringAttr(next, REGEX_KEYFORMAT, KEYFORMAT_IDENTITY, hashMap2), hashMap2);
                        if (parseDrmSchemeData != null) {
                            arrayList17.add(new DrmInitData(parseEncryptionScheme(parseStringAttr(next, REGEX_METHOD, hashMap2)), parseDrmSchemeData));
                        }
                    } else if (next.startsWith(TAG_STREAM_INF) || startsWith) {
                        boolean contains = z | next.contains(ATTR_CLOSED_CAPTIONS_NONE);
                        int i5 = startsWith ? 16384 : 0;
                        arrayList4 = arrayList18;
                        int parseIntAttr = parseIntAttr(next, REGEX_BANDWIDTH);
                        arrayList5 = arrayList17;
                        int parseOptionalIntAttr = parseOptionalIntAttr(next, REGEX_AVERAGE_BANDWIDTH, -1);
                        String parseOptionalStringAttr2 = parseOptionalStringAttr(next, REGEX_VIDEO_RANGE, hashMap2);
                        boolean z3 = z2;
                        String parseOptionalStringAttr3 = parseOptionalStringAttr(next, REGEX_CODECS, hashMap2);
                        arrayList6 = arrayList14;
                        String parseOptionalStringAttr4 = parseOptionalStringAttr(next, REGEX_SUPPLEMENTAL_CODECS, hashMap2);
                        arrayList7 = arrayList13;
                        if (parseOptionalStringAttr4 != null) {
                            String[] split = Util.split(Util.splitAtFirst(parseOptionalStringAttr4, ",")[0], RemoteSettings.FORWARD_SLASH_STRING);
                            String str8 = split[0];
                            if (split.length > 1) {
                                str6 = split[1];
                                arrayList8 = arrayList16;
                                arrayList9 = arrayList12;
                                str5 = str8;
                                i = 2;
                                codecsOfType = Util.getCodecsOfType(parseOptionalStringAttr3, i);
                                if (isDolbyVisionFormat(parseOptionalStringAttr2, codecsOfType, str5, str6)) {
                                    if (str5 == null) {
                                        str5 = codecsOfType;
                                    }
                                    String codecsWithoutType = Util.getCodecsWithoutType(parseOptionalStringAttr3, i);
                                    parseOptionalStringAttr3 = codecsWithoutType != null ? str5 + "," + codecsWithoutType : str5;
                                }
                                parseOptionalStringAttr = parseOptionalStringAttr(next, REGEX_RESOLUTION, hashMap2);
                                if (parseOptionalStringAttr == null) {
                                    String[] split2 = Util.split(parseOptionalStringAttr, VastAttributes.HORIZONTAL_POSITION);
                                    int parseInt2 = Integer.parseInt(split2[0]);
                                    int parseInt3 = Integer.parseInt(split2[1]);
                                    if (parseInt2 <= 0 || parseInt3 <= 0) {
                                        parseInt3 = -1;
                                        i4 = -1;
                                    } else {
                                        i4 = parseInt2;
                                    }
                                    i3 = parseInt3;
                                    i2 = i4;
                                } else {
                                    i2 = -1;
                                    i3 = -1;
                                }
                                String parseOptionalStringAttr5 = parseOptionalStringAttr(next, REGEX_FRAME_RATE, hashMap2);
                                float parseFloat = parseOptionalStringAttr5 == null ? Float.parseFloat(parseOptionalStringAttr5) : -1.0f;
                                String parseOptionalStringAttr6 = parseOptionalStringAttr(next, REGEX_VIDEO, hashMap2);
                                String parseOptionalStringAttr7 = parseOptionalStringAttr(next, REGEX_AUDIO, hashMap2);
                                String parseOptionalStringAttr8 = parseOptionalStringAttr(next, REGEX_SUBTITLES, hashMap2);
                                String parseOptionalStringAttr9 = parseOptionalStringAttr(next, REGEX_CLOSED_CAPTIONS, hashMap2);
                                if (!startsWith) {
                                    resolveToUri = UriUtil.resolveToUri(str7, parseStringAttr(next, REGEX_URI, hashMap2));
                                } else {
                                    if (!lineIterator.hasNext()) {
                                        throw ParserException.createForMalformedManifest("#EXT-X-STREAM-INF must be followed by another line", null);
                                    }
                                    resolveToUri = UriUtil.resolveToUri(str7, replaceVariableReferences(lineIterator.next(), hashMap2));
                                }
                                Uri uri = resolveToUri;
                                arrayList11.add(new HlsMultivariantPlaylist.Variant(uri, new Format.Builder().setId(arrayList11.size()).setContainerMimeType("application/x-mpegURL").setCodecs(parseOptionalStringAttr3).setAverageBitrate(parseOptionalIntAttr).setPeakBitrate(parseIntAttr).setWidth(i2).setHeight(i3).setFrameRate(parseFloat).setRoleFlags(i5).build(), parseOptionalStringAttr6, parseOptionalStringAttr7, parseOptionalStringAttr8, parseOptionalStringAttr9));
                                arrayList10 = (ArrayList) hashMap.get(uri);
                                if (arrayList10 == null) {
                                    arrayList10 = new ArrayList();
                                    hashMap.put(uri, arrayList10);
                                }
                                arrayList10.add(new HlsTrackMetadataEntry.VariantInfo(parseOptionalIntAttr, parseIntAttr, parseOptionalStringAttr6, parseOptionalStringAttr7, parseOptionalStringAttr8, parseOptionalStringAttr9));
                                z = contains;
                                z2 = z3;
                            } else {
                                arrayList8 = arrayList16;
                                arrayList9 = arrayList12;
                                str5 = str8;
                                i = 2;
                            }
                        } else {
                            arrayList8 = arrayList16;
                            arrayList9 = arrayList12;
                            i = 2;
                            str5 = null;
                        }
                        str6 = null;
                        codecsOfType = Util.getCodecsOfType(parseOptionalStringAttr3, i);
                        if (isDolbyVisionFormat(parseOptionalStringAttr2, codecsOfType, str5, str6)) {
                        }
                        parseOptionalStringAttr = parseOptionalStringAttr(next, REGEX_RESOLUTION, hashMap2);
                        if (parseOptionalStringAttr == null) {
                        }
                        String parseOptionalStringAttr52 = parseOptionalStringAttr(next, REGEX_FRAME_RATE, hashMap2);
                        if (parseOptionalStringAttr52 == null) {
                        }
                        String parseOptionalStringAttr62 = parseOptionalStringAttr(next, REGEX_VIDEO, hashMap2);
                        String parseOptionalStringAttr72 = parseOptionalStringAttr(next, REGEX_AUDIO, hashMap2);
                        String parseOptionalStringAttr82 = parseOptionalStringAttr(next, REGEX_SUBTITLES, hashMap2);
                        String parseOptionalStringAttr92 = parseOptionalStringAttr(next, REGEX_CLOSED_CAPTIONS, hashMap2);
                        if (!startsWith) {
                        }
                        Uri uri2 = resolveToUri;
                        arrayList11.add(new HlsMultivariantPlaylist.Variant(uri2, new Format.Builder().setId(arrayList11.size()).setContainerMimeType("application/x-mpegURL").setCodecs(parseOptionalStringAttr3).setAverageBitrate(parseOptionalIntAttr).setPeakBitrate(parseIntAttr).setWidth(i2).setHeight(i3).setFrameRate(parseFloat).setRoleFlags(i5).build(), parseOptionalStringAttr62, parseOptionalStringAttr72, parseOptionalStringAttr82, parseOptionalStringAttr92));
                        arrayList10 = (ArrayList) hashMap.get(uri2);
                        if (arrayList10 == null) {
                        }
                        arrayList10.add(new HlsTrackMetadataEntry.VariantInfo(parseOptionalIntAttr, parseIntAttr, parseOptionalStringAttr62, parseOptionalStringAttr72, parseOptionalStringAttr82, parseOptionalStringAttr92));
                        z = contains;
                        z2 = z3;
                    }
                    arrayList15 = arrayList19;
                    arrayList18 = arrayList4;
                    arrayList17 = arrayList5;
                    arrayList14 = arrayList6;
                    arrayList13 = arrayList7;
                    arrayList12 = arrayList9;
                    arrayList16 = arrayList8;
                }
                arrayList8 = arrayList16;
                arrayList9 = arrayList12;
                arrayList7 = arrayList13;
                arrayList6 = arrayList14;
                arrayList4 = arrayList18;
                arrayList5 = arrayList17;
                arrayList15 = arrayList19;
                arrayList18 = arrayList4;
                arrayList17 = arrayList5;
                arrayList14 = arrayList6;
                arrayList13 = arrayList7;
                arrayList12 = arrayList9;
                arrayList16 = arrayList8;
            } else {
                ArrayList arrayList20 = arrayList16;
                ArrayList arrayList21 = arrayList12;
                ArrayList arrayList22 = arrayList13;
                ArrayList arrayList23 = arrayList14;
                ArrayList arrayList24 = arrayList18;
                ArrayList arrayList25 = arrayList17;
                boolean z4 = z2;
                ArrayList arrayList26 = new ArrayList();
                HashSet hashSet = new HashSet();
                for (int i6 = 0; i6 < arrayList11.size(); i6++) {
                    HlsMultivariantPlaylist.Variant variant2 = (HlsMultivariantPlaylist.Variant) arrayList11.get(i6);
                    if (hashSet.add(variant2.url)) {
                        Assertions.checkState(variant2.format.metadata == null);
                        arrayList26.add(variant2.copyWithFormat(variant2.format.buildUpon().setMetadata(new Metadata(new HlsTrackMetadataEntry(null, null, (List) Assertions.checkNotNull((ArrayList) hashMap.get(variant2.url))))).build()));
                    }
                }
                ArrayList arrayList27 = null;
                Format format = null;
                int i7 = 0;
                while (i7 < arrayList20.size()) {
                    ArrayList arrayList28 = arrayList20;
                    String str9 = (String) arrayList28.get(i7);
                    String parseStringAttr = parseStringAttr(str9, REGEX_GROUP_ID, hashMap2);
                    String parseStringAttr2 = parseStringAttr(str9, REGEX_NAME, hashMap2);
                    ArrayList arrayList29 = arrayList27;
                    Format.Builder language = new Format.Builder().setId(parseStringAttr + ":" + parseStringAttr2).setLabel(parseStringAttr2).setContainerMimeType("application/x-mpegURL").setSelectionFlags(parseSelectionFlags(str9)).setRoleFlags(parseRoleFlags(str9, hashMap2)).setLanguage(parseOptionalStringAttr(str9, REGEX_LANGUAGE, hashMap2));
                    String parseOptionalStringAttr10 = parseOptionalStringAttr(str9, REGEX_URI, hashMap2);
                    Uri resolveToUri2 = parseOptionalStringAttr10 == null ? null : UriUtil.resolveToUri(str7, parseOptionalStringAttr10);
                    ArrayList arrayList30 = arrayList26;
                    int i8 = i7;
                    Metadata metadata = new Metadata(new HlsTrackMetadataEntry(parseStringAttr, parseStringAttr2, Collections.emptyList()));
                    String parseStringAttr3 = parseStringAttr(str9, REGEX_TYPE, hashMap2);
                    parseStringAttr3.hashCode();
                    switch (parseStringAttr3.hashCode()) {
                        case -959297733:
                            if (parseStringAttr3.equals(TYPE_SUBTITLES)) {
                                c = 0;
                                break;
                            }
                            c = 65535;
                            break;
                        case -333210994:
                            if (parseStringAttr3.equals(TYPE_CLOSED_CAPTIONS)) {
                                c = 1;
                                break;
                            }
                            c = 65535;
                            break;
                        case 62628790:
                            if (parseStringAttr3.equals(TYPE_AUDIO)) {
                                c = 2;
                                break;
                            }
                            c = 65535;
                            break;
                        case 81665115:
                            if (parseStringAttr3.equals(TYPE_VIDEO)) {
                                c = 3;
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
                            arrayList = arrayList21;
                            HlsMultivariantPlaylist.Variant variantWithSubtitleGroup = getVariantWithSubtitleGroup(arrayList11, parseStringAttr);
                            if (variantWithSubtitleGroup != null) {
                                String codecsOfType2 = Util.getCodecsOfType(variantWithSubtitleGroup.format.codecs, 3);
                                language.setCodecs(codecsOfType2);
                                str2 = MimeTypes.getMediaMimeType(codecsOfType2);
                            } else {
                                str2 = null;
                            }
                            if (str2 == null) {
                                str2 = "text/vtt";
                            }
                            language.setSampleMimeType(str2).setMetadata(metadata);
                            if (resolveToUri2 != null) {
                                HlsMultivariantPlaylist.Rendition rendition = new HlsMultivariantPlaylist.Rendition(resolveToUri2, language.build(), parseStringAttr, parseStringAttr2);
                                arrayList2 = arrayList23;
                                arrayList2.add(rendition);
                            } else {
                                arrayList2 = arrayList23;
                                Log.w(LOG_TAG, "EXT-X-MEDIA tag with missing mandatory URI attribute: skipping");
                            }
                            arrayList3 = arrayList29;
                            break;
                        case 1:
                            ArrayList arrayList31 = arrayList22;
                            arrayList = arrayList21;
                            String parseStringAttr4 = parseStringAttr(str9, REGEX_INSTREAM_ID, hashMap2);
                            if (parseStringAttr4.startsWith("CC")) {
                                parseInt = Integer.parseInt(parseStringAttr4.substring(2));
                                str3 = "application/cea-608";
                            } else {
                                parseInt = Integer.parseInt(parseStringAttr4.substring(7));
                                str3 = "application/cea-708";
                            }
                            arrayList3 = arrayList29 == null ? new ArrayList() : arrayList29;
                            language.setSampleMimeType(str3).setAccessibilityChannel(parseInt);
                            arrayList3.add(language.build());
                            arrayList22 = arrayList31;
                            arrayList2 = arrayList23;
                            break;
                        case 2:
                            arrayList = arrayList21;
                            HlsMultivariantPlaylist.Variant variantWithAudioGroup = getVariantWithAudioGroup(arrayList11, parseStringAttr);
                            if (variantWithAudioGroup != null) {
                                variant = variantWithAudioGroup;
                                String codecsOfType3 = Util.getCodecsOfType(variantWithAudioGroup.format.codecs, 1);
                                language.setCodecs(codecsOfType3);
                                str4 = MimeTypes.getMediaMimeType(codecsOfType3);
                            } else {
                                variant = variantWithAudioGroup;
                                str4 = null;
                            }
                            String parseOptionalStringAttr11 = parseOptionalStringAttr(str9, REGEX_CHANNELS, hashMap2);
                            if (parseOptionalStringAttr11 != null) {
                                language.setChannelCount(Integer.parseInt(Util.splitAtFirst(parseOptionalStringAttr11, RemoteSettings.FORWARD_SLASH_STRING)[0]));
                                if ("audio/eac3".equals(str4) && parseOptionalStringAttr11.endsWith("/JOC")) {
                                    language.setCodecs("ec+3");
                                    str4 = "audio/eac3-joc";
                                }
                            }
                            language.setSampleMimeType(str4);
                            if (resolveToUri2 != null) {
                                language.setMetadata(metadata);
                                arrayList22.add(new HlsMultivariantPlaylist.Rendition(resolveToUri2, language.build(), parseStringAttr, parseStringAttr2));
                            } else {
                                ArrayList arrayList32 = arrayList22;
                                if (variant != null) {
                                    arrayList3 = arrayList29;
                                    format = language.build();
                                    arrayList22 = arrayList32;
                                    arrayList2 = arrayList23;
                                    break;
                                } else {
                                    arrayList22 = arrayList32;
                                }
                            }
                            arrayList2 = arrayList23;
                            arrayList3 = arrayList29;
                            break;
                        case 3:
                            HlsMultivariantPlaylist.Variant variantWithVideoGroup = getVariantWithVideoGroup(arrayList11, parseStringAttr);
                            if (variantWithVideoGroup != null) {
                                Format format2 = variantWithVideoGroup.format;
                                String codecsOfType4 = Util.getCodecsOfType(format2.codecs, 2);
                                language.setCodecs(codecsOfType4).setSampleMimeType(MimeTypes.getMediaMimeType(codecsOfType4)).setWidth(format2.width).setHeight(format2.height).setFrameRate(format2.frameRate);
                            }
                            if (resolveToUri2 != null) {
                                language.setMetadata(metadata);
                                arrayList = arrayList21;
                                arrayList.add(new HlsMultivariantPlaylist.Rendition(resolveToUri2, language.build(), parseStringAttr, parseStringAttr2));
                                arrayList2 = arrayList23;
                                arrayList3 = arrayList29;
                                break;
                            }
                        default:
                            arrayList2 = arrayList23;
                            arrayList = arrayList21;
                            arrayList3 = arrayList29;
                            break;
                    }
                    i7 = i8 + 1;
                    str7 = str;
                    arrayList23 = arrayList2;
                    arrayList21 = arrayList;
                    arrayList20 = arrayList28;
                    arrayList27 = arrayList3;
                    arrayList26 = arrayList30;
                }
                return new HlsMultivariantPlaylist(str, arrayList24, arrayList26, arrayList21, arrayList22, arrayList23, arrayList19, format, z ? Collections.emptyList() : arrayList27, z4, hashMap2, arrayList25);
            }
        }
    }

    private static HlsMultivariantPlaylist.Variant getVariantWithAudioGroup(ArrayList<HlsMultivariantPlaylist.Variant> arrayList, String str) {
        for (int i = 0; i < arrayList.size(); i++) {
            HlsMultivariantPlaylist.Variant variant = arrayList.get(i);
            if (str.equals(variant.audioGroupId)) {
                return variant;
            }
        }
        return null;
    }

    private static HlsMultivariantPlaylist.Variant getVariantWithVideoGroup(ArrayList<HlsMultivariantPlaylist.Variant> arrayList, String str) {
        for (int i = 0; i < arrayList.size(); i++) {
            HlsMultivariantPlaylist.Variant variant = arrayList.get(i);
            if (str.equals(variant.videoGroupId)) {
                return variant;
            }
        }
        return null;
    }

    private static HlsMultivariantPlaylist.Variant getVariantWithSubtitleGroup(ArrayList<HlsMultivariantPlaylist.Variant> arrayList, String str) {
        for (int i = 0; i < arrayList.size(); i++) {
            HlsMultivariantPlaylist.Variant variant = arrayList.get(i);
            if (str.equals(variant.subtitleGroupId)) {
                return variant;
            }
        }
        return null;
    }

    /*  JADX ERROR: Types fix failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:96)
        */
    private static io.bidmachine.media3.exoplayer.hls.playlist.HlsMediaPlaylist parseMediaPlaylist(io.bidmachine.media3.exoplayer.hls.playlist.HlsMultivariantPlaylist r111, io.bidmachine.media3.exoplayer.hls.playlist.HlsMediaPlaylist r112, io.bidmachine.media3.exoplayer.hls.playlist.HlsPlaylistParser.LineIterator r113, java.lang.String r114) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 2602
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.bidmachine.media3.exoplayer.hls.playlist.HlsPlaylistParser.parseMediaPlaylist(io.bidmachine.media3.exoplayer.hls.playlist.HlsMultivariantPlaylist, io.bidmachine.media3.exoplayer.hls.playlist.HlsMediaPlaylist, io.bidmachine.media3.exoplayer.hls.playlist.HlsPlaylistParser$LineIterator, java.lang.String):io.bidmachine.media3.exoplayer.hls.playlist.HlsMediaPlaylist");
    }

    private static DrmInitData getPlaylistProtectionSchemes(String str, DrmInitData.SchemeData[] schemeDataArr) {
        DrmInitData.SchemeData[] schemeDataArr2 = new DrmInitData.SchemeData[schemeDataArr.length];
        for (int i = 0; i < schemeDataArr.length; i++) {
            schemeDataArr2[i] = schemeDataArr[i].copyWithData(null);
        }
        return new DrmInitData(str, schemeDataArr2);
    }

    private static String getSegmentEncryptionIV(long j, String str, String str2) {
        if (str == null) {
            return null;
        }
        return str2 != null ? str2 : Long.toHexString(j);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [int] */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6 */
    private static int parseSelectionFlags(String str) {
        boolean parseOptionalBooleanAttribute = parseOptionalBooleanAttribute(str, REGEX_DEFAULT, false);
        ?? r0 = parseOptionalBooleanAttribute;
        if (parseOptionalBooleanAttribute(str, REGEX_FORCED, false)) {
            r0 = (parseOptionalBooleanAttribute ? 1 : 0) | 2;
        }
        return parseOptionalBooleanAttribute(str, REGEX_AUTOSELECT, false) ? r0 | 4 : r0;
    }

    private static int parseRoleFlags(String str, Map<String, String> map) {
        String parseOptionalStringAttr = parseOptionalStringAttr(str, REGEX_CHARACTERISTICS, map);
        if (TextUtils.isEmpty(parseOptionalStringAttr)) {
            return 0;
        }
        String[] split = Util.split(parseOptionalStringAttr, ",");
        int i = Util.contains(split, "public.accessibility.describes-video") ? 512 : 0;
        if (Util.contains(split, "public.accessibility.transcribes-spoken-dialog")) {
            i |= 4096;
        }
        if (Util.contains(split, "public.accessibility.describes-music-and-sound")) {
            i |= 1024;
        }
        return Util.contains(split, "public.easy-to-read") ? i | 8192 : i;
    }

    private static DrmInitData.SchemeData parseDrmSchemeData(String str, String str2, Map<String, String> map) throws ParserException {
        String parseOptionalStringAttr = parseOptionalStringAttr(str, REGEX_KEYFORMATVERSIONS, "1", map);
        if (KEYFORMAT_WIDEVINE_PSSH_BINARY.equals(str2)) {
            String parseStringAttr = parseStringAttr(str, REGEX_URI, map);
            return new DrmInitData.SchemeData(C.WIDEVINE_UUID, "video/mp4", Base64.decode(parseStringAttr.substring(parseStringAttr.indexOf(44)), 0));
        }
        if (KEYFORMAT_WIDEVINE_PSSH_JSON.equals(str2)) {
            return new DrmInitData.SchemeData(C.WIDEVINE_UUID, "hls", Util.getUtf8Bytes(str));
        }
        if (!KEYFORMAT_PLAYREADY.equals(str2) || !"1".equals(parseOptionalStringAttr)) {
            return null;
        }
        String parseStringAttr2 = parseStringAttr(str, REGEX_URI, map);
        return new DrmInitData.SchemeData(C.PLAYREADY_UUID, "video/mp4", PsshAtomUtil.buildPsshAtom(C.PLAYREADY_UUID, Base64.decode(parseStringAttr2.substring(parseStringAttr2.indexOf(44)), 0)));
    }

    private static HlsMediaPlaylist.ServerControl parseServerControl(String str) {
        double parseOptionalDoubleAttr = parseOptionalDoubleAttr(str, REGEX_CAN_SKIP_UNTIL, -9.223372036854776E18d);
        long j = parseOptionalDoubleAttr == -9.223372036854776E18d ? -9223372036854775807L : (long) (parseOptionalDoubleAttr * 1000000.0d);
        boolean parseOptionalBooleanAttribute = parseOptionalBooleanAttribute(str, REGEX_CAN_SKIP_DATE_RANGES, false);
        double parseOptionalDoubleAttr2 = parseOptionalDoubleAttr(str, REGEX_HOLD_BACK, -9.223372036854776E18d);
        long j2 = parseOptionalDoubleAttr2 == -9.223372036854776E18d ? -9223372036854775807L : (long) (parseOptionalDoubleAttr2 * 1000000.0d);
        double parseOptionalDoubleAttr3 = parseOptionalDoubleAttr(str, REGEX_PART_HOLD_BACK, -9.223372036854776E18d);
        return new HlsMediaPlaylist.ServerControl(j, parseOptionalBooleanAttribute, j2, parseOptionalDoubleAttr3 != -9.223372036854776E18d ? (long) (parseOptionalDoubleAttr3 * 1000000.0d) : -9223372036854775807L, parseOptionalBooleanAttribute(str, REGEX_CAN_BLOCK_RELOAD, false));
    }

    private static String parseEncryptionScheme(String str) {
        if (METHOD_SAMPLE_AES_CENC.equals(str) || METHOD_SAMPLE_AES_CTR.equals(str)) {
            return "cenc";
        }
        return "cbcs";
    }

    private static int parseIntAttr(String str, Pattern pattern) throws ParserException {
        return Integer.parseInt(parseStringAttr(str, pattern, Collections.emptyMap()));
    }

    private static int parseOptionalIntAttr(String str, Pattern pattern, int i) {
        Matcher matcher = pattern.matcher(str);
        return matcher.find() ? Integer.parseInt((String) Assertions.checkNotNull(matcher.group(1))) : i;
    }

    private static long parseLongAttr(String str, Pattern pattern) throws ParserException {
        return Long.parseLong(parseStringAttr(str, pattern, Collections.emptyMap()));
    }

    private static long parseOptionalLongAttr(String str, Pattern pattern, long j) {
        Matcher matcher = pattern.matcher(str);
        return matcher.find() ? Long.parseLong((String) Assertions.checkNotNull(matcher.group(1))) : j;
    }

    private static long parseTimeSecondsToUs(String str, Pattern pattern) throws ParserException {
        return new BigDecimal(parseStringAttr(str, pattern, Collections.emptyMap())).multiply(new BigDecimal(1000000L)).longValue();
    }

    private static double parseDoubleAttr(String str, Pattern pattern) throws ParserException {
        return Double.parseDouble(parseStringAttr(str, pattern, Collections.emptyMap()));
    }

    private static String parseStringAttr(String str, Pattern pattern, Map<String, String> map) throws ParserException {
        String parseOptionalStringAttr = parseOptionalStringAttr(str, pattern, map);
        if (parseOptionalStringAttr != null) {
            return parseOptionalStringAttr;
        }
        throw ParserException.createForMalformedManifest("Couldn't match " + pattern.pattern() + " in " + str, null);
    }

    private static String parseOptionalStringAttr(String str, Pattern pattern, Map<String, String> map) {
        return parseOptionalStringAttr(str, pattern, null, map);
    }

    private static String parseOptionalStringAttr(String str, Pattern pattern, String str2, Map<String, String> map) {
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            str2 = (String) Assertions.checkNotNull(matcher.group(1));
        }
        return (map.isEmpty() || str2 == null) ? str2 : replaceVariableReferences(str2, map);
    }

    private static double parseOptionalDoubleAttr(String str, Pattern pattern, double d) {
        Matcher matcher = pattern.matcher(str);
        return matcher.find() ? Double.parseDouble((String) Assertions.checkNotNull(matcher.group(1))) : d;
    }

    private static HlsMediaPlaylist.ClientDefinedAttribute parseClientDefinedAttribute(String str, String str2, Map<String, String> map) throws ParserException {
        String str3 = str2 + C3040d4.i.b;
        int indexOf = str.indexOf(str3) + str3.length();
        String substring = str.substring(indexOf, (str.length() == indexOf + 1 ? 1 : 2) + indexOf);
        if (substring.startsWith("\"")) {
            return new HlsMediaPlaylist.ClientDefinedAttribute(str2, parseStringAttr(str, Pattern.compile(str2 + "=\"(.+?)\""), map), 0);
        }
        if (substring.equals("0x") || substring.equals("0X")) {
            return new HlsMediaPlaylist.ClientDefinedAttribute(str2, parseStringAttr(str, Pattern.compile(str2 + "=(0[xX][A-F0-9]+)"), map), 1);
        }
        return new HlsMediaPlaylist.ClientDefinedAttribute(str2, parseDoubleAttr(str, Pattern.compile(str2 + "=([\\d\\.]+)\\b")));
    }

    private static String replaceVariableReferences(String str, Map<String, String> map) {
        Matcher matcher = REGEX_VARIABLE_REFERENCE.matcher(str);
        StringBuffer stringBuffer = new StringBuffer();
        while (matcher.find()) {
            String group = matcher.group(1);
            if (map.containsKey(group)) {
                matcher.appendReplacement(stringBuffer, Matcher.quoteReplacement(map.get(group)));
            }
        }
        matcher.appendTail(stringBuffer);
        return stringBuffer.toString();
    }

    private static boolean parseOptionalBooleanAttribute(String str, Pattern pattern, boolean z) {
        Matcher matcher = pattern.matcher(str);
        return matcher.find() ? BOOLEAN_TRUE.equals(matcher.group(1)) : z;
    }

    private static Pattern compileBooleanAttrPattern(String str) {
        return Pattern.compile(str + "=(NO|YES)");
    }

    private static class LineIterator {
        private final Queue<String> extraLines;
        private String next;
        private final BufferedReader reader;

        public LineIterator(Queue<String> queue, BufferedReader bufferedReader) {
            this.extraLines = queue;
            this.reader = bufferedReader;
        }

        @EnsuresNonNullIf(expression = {LinkHeader.Rel.Next}, result = true)
        public boolean hasNext() throws IOException {
            String trim;
            if (this.next != null) {
                return true;
            }
            if (!this.extraLines.isEmpty()) {
                this.next = (String) Assertions.checkNotNull(this.extraLines.poll());
                return true;
            }
            do {
                String readLine = this.reader.readLine();
                this.next = readLine;
                if (readLine == null) {
                    return false;
                }
                trim = readLine.trim();
                this.next = trim;
            } while (trim.isEmpty());
            return true;
        }

        public String next() throws IOException {
            if (hasNext()) {
                String str = this.next;
                this.next = null;
                return str;
            }
            throw new NoSuchElementException();
        }
    }
}
