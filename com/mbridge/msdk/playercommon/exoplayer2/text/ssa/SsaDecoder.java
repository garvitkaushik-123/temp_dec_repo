package com.mbridge.msdk.playercommon.exoplayer2.text.ssa;

import android.text.TextUtils;
import android.util.Log;
import com.mbridge.msdk.playercommon.exoplayer2.text.Cue;
import com.mbridge.msdk.playercommon.exoplayer2.text.SimpleSubtitleDecoder;
import com.mbridge.msdk.playercommon.exoplayer2.util.Assertions;
import com.mbridge.msdk.playercommon.exoplayer2.util.LongArray;
import com.mbridge.msdk.playercommon.exoplayer2.util.ParsableByteArray;
import com.mbridge.msdk.playercommon.exoplayer2.util.Util;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes6.dex */
public final class SsaDecoder extends SimpleSubtitleDecoder {
    private static final String DIALOGUE_LINE_PREFIX = "Dialogue: ";
    private static final String FORMAT_LINE_PREFIX = "Format: ";
    private static final Pattern SSA_TIMECODE_PATTERN = Pattern.compile("(?:(\\d+):)?(\\d+):(\\d+)(?::|\\.)(\\d+)");
    private static final String TAG = "SsaDecoder";
    private int formatEndIndex;
    private int formatKeyCount;
    private int formatStartIndex;
    private int formatTextIndex;
    private final boolean haveInitializationData;

    public SsaDecoder() {
        this(null);
    }

    private void parseDialogueLine(String str, List<Cue> list, LongArray longArray) {
        long j;
        if (this.formatKeyCount == 0) {
            Log.w(TAG, "Skipping dialogue line before complete format: " + str);
            return;
        }
        String[] split = str.substring(10).split(",", this.formatKeyCount);
        if (split.length != this.formatKeyCount) {
            Log.w(TAG, "Skipping dialogue line with fewer columns than format: " + str);
            return;
        }
        long parseTimecodeUs = parseTimecodeUs(split[this.formatStartIndex]);
        if (parseTimecodeUs == -9223372036854775807L) {
            Log.w(TAG, "Skipping invalid timing: " + str);
            return;
        }
        String str2 = split[this.formatEndIndex];
        if (str2.trim().isEmpty()) {
            j = -9223372036854775807L;
        } else {
            j = parseTimecodeUs(str2);
            if (j == -9223372036854775807L) {
                Log.w(TAG, "Skipping invalid timing: " + str);
                return;
            }
        }
        list.add(new Cue(split[this.formatTextIndex].replaceAll("\\{.*?\\}", "").replaceAll("\\\\N", "\n").replaceAll("\\\\n", "\n")));
        longArray.add(parseTimecodeUs);
        if (j != -9223372036854775807L) {
            list.add(null);
            longArray.add(j);
        }
    }

    private void parseEventBody(ParsableByteArray parsableByteArray, List<Cue> list, LongArray longArray) {
        while (true) {
            String readLine = parsableByteArray.readLine();
            if (readLine == null) {
                return;
            }
            if (!this.haveInitializationData && readLine.startsWith(FORMAT_LINE_PREFIX)) {
                parseFormatLine(readLine);
            } else if (readLine.startsWith(DIALOGUE_LINE_PREFIX)) {
                parseDialogueLine(readLine, list, longArray);
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private void parseFormatLine(String str) {
        char c;
        String[] split = TextUtils.split(str.substring(8), ",");
        this.formatKeyCount = split.length;
        this.formatStartIndex = -1;
        this.formatEndIndex = -1;
        this.formatTextIndex = -1;
        for (int i = 0; i < this.formatKeyCount; i++) {
            String lowerInvariant = Util.toLowerInvariant(split[i].trim());
            lowerInvariant.hashCode();
            lowerInvariant.hashCode();
            switch (lowerInvariant.hashCode()) {
                case 100571:
                    if (lowerInvariant.equals("end")) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                case 3556653:
                    if (lowerInvariant.equals("text")) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case 109757538:
                    if (lowerInvariant.equals("start")) {
                        c = 2;
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
                    this.formatEndIndex = i;
                    break;
                case 1:
                    this.formatTextIndex = i;
                    break;
                case 2:
                    this.formatStartIndex = i;
                    break;
            }
        }
        if (this.formatStartIndex == -1 || this.formatEndIndex == -1 || this.formatTextIndex == -1) {
            this.formatKeyCount = 0;
        }
    }

    private void parseHeader(ParsableByteArray parsableByteArray) {
        String readLine;
        do {
            readLine = parsableByteArray.readLine();
            if (readLine == null) {
                return;
            }
        } while (!readLine.startsWith("[Events]"));
    }

    public static long parseTimecodeUs(String str) {
        Matcher matcher = SSA_TIMECODE_PATTERN.matcher(str);
        if (matcher.matches()) {
            return (Long.parseLong(matcher.group(1)) * 3600000000L) + (Long.parseLong(matcher.group(2)) * 60000000) + (Long.parseLong(matcher.group(3)) * 1000000) + (Long.parseLong(matcher.group(4)) * 10000);
        }
        return -9223372036854775807L;
    }

    public SsaDecoder(List<byte[]> list) {
        super(TAG);
        if (list == null || list.isEmpty()) {
            this.haveInitializationData = false;
            return;
        }
        this.haveInitializationData = true;
        String fromUtf8Bytes = Util.fromUtf8Bytes(list.get(0));
        Assertions.checkArgument(fromUtf8Bytes.startsWith(FORMAT_LINE_PREFIX));
        parseFormatLine(fromUtf8Bytes);
        parseHeader(new ParsableByteArray(list.get(1)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mbridge.msdk.playercommon.exoplayer2.text.SimpleSubtitleDecoder
    public SsaSubtitle decode(byte[] bArr, int i, boolean z) {
        ArrayList arrayList = new ArrayList();
        LongArray longArray = new LongArray();
        ParsableByteArray parsableByteArray = new ParsableByteArray(bArr, i);
        if (!this.haveInitializationData) {
            parseHeader(parsableByteArray);
        }
        parseEventBody(parsableByteArray, arrayList, longArray);
        Cue[] cueArr = new Cue[arrayList.size()];
        arrayList.toArray(cueArr);
        return new SsaSubtitle(cueArr, longArray.toArray());
    }
}
