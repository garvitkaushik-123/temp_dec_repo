package com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4;

import android.support.v4.media.session.PlaybackStateCompat;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ExtractorInput;
import com.mbridge.msdk.playercommon.exoplayer2.util.ParsableByteArray;
import com.mbridge.msdk.playercommon.exoplayer2.util.Util;
import java.io.IOException;

/* loaded from: classes6.dex */
final class Sniffer {
    private static final int[] COMPATIBLE_BRANDS = {Util.getIntegerCodeForString("isom"), Util.getIntegerCodeForString("iso2"), Util.getIntegerCodeForString("iso3"), Util.getIntegerCodeForString("iso4"), Util.getIntegerCodeForString("iso5"), Util.getIntegerCodeForString("iso6"), Util.getIntegerCodeForString("avc1"), Util.getIntegerCodeForString("hvc1"), Util.getIntegerCodeForString("hev1"), Util.getIntegerCodeForString("mp41"), Util.getIntegerCodeForString("mp42"), Util.getIntegerCodeForString("3g2a"), Util.getIntegerCodeForString("3g2b"), Util.getIntegerCodeForString("3gr6"), Util.getIntegerCodeForString("3gs6"), Util.getIntegerCodeForString("3ge6"), Util.getIntegerCodeForString("3gg6"), Util.getIntegerCodeForString("M4V "), Util.getIntegerCodeForString("M4A "), Util.getIntegerCodeForString("f4v "), Util.getIntegerCodeForString("kddi"), Util.getIntegerCodeForString("M4VP"), Util.getIntegerCodeForString("qt  "), Util.getIntegerCodeForString("MSNV")};
    private static final int SEARCH_LENGTH = 4096;

    private Sniffer() {
    }

    private static boolean isCompatibleBrand(int i) {
        if ((i >>> 8) == Util.getIntegerCodeForString("3gp")) {
            return true;
        }
        for (int i2 : COMPATIBLE_BRANDS) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }

    public static boolean sniffFragmented(ExtractorInput extractorInput) throws IOException, InterruptedException {
        return sniffInternal(extractorInput, true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean sniffInternal(ExtractorInput extractorInput, boolean z) throws IOException, InterruptedException {
        boolean z2;
        int i;
        long length = extractorInput.getLength();
        long j = -1;
        if (length == -1 || length > PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM) {
            length = 4096;
        }
        int i2 = (int) length;
        ParsableByteArray parsableByteArray = new ParsableByteArray(64);
        boolean z3 = false;
        int i3 = 0;
        Object[] objArr = false;
        while (i3 < i2) {
            parsableByteArray.reset(8);
            extractorInput.peekFully(parsableByteArray.data, z3 ? 1 : 0, 8);
            long readUnsignedInt = parsableByteArray.readUnsignedInt();
            int readInt = parsableByteArray.readInt();
            if (readUnsignedInt == 1) {
                extractorInput.peekFully(parsableByteArray.data, 8, 8);
                parsableByteArray.setLimit(16);
                i = 16;
                readUnsignedInt = parsableByteArray.readUnsignedLongToLong();
            } else {
                if (readUnsignedInt == 0) {
                    long length2 = extractorInput.getLength();
                    if (length2 != j) {
                        readUnsignedInt = 8 + (length2 - extractorInput.getPosition());
                    }
                }
                i = 8;
            }
            long j2 = i;
            if (readUnsignedInt < j2) {
                return z3;
            }
            i3 += i;
            if (readInt != Atom.TYPE_moov) {
                if (readInt == Atom.TYPE_moof || readInt == Atom.TYPE_mvex) {
                    z2 = true;
                    break;
                }
                long j3 = (i3 + readUnsignedInt) - j2;
                boolean z4 = z3 ? 1 : 0;
                if (j3 >= i2) {
                    break;
                }
                int i4 = (int) (readUnsignedInt - j2);
                i3 += i4;
                if (readInt == Atom.TYPE_ftyp) {
                    if (i4 < 8) {
                        return z4;
                    }
                    parsableByteArray.reset(i4);
                    extractorInput.peekFully(parsableByteArray.data, z4 ? 1 : 0, i4);
                    int i5 = i4 / 4;
                    int i6 = 0;
                    while (true) {
                        if (i6 >= i5) {
                            break;
                        }
                        if (i6 == 1) {
                            parsableByteArray.skipBytes(4);
                        } else if (isCompatibleBrand(parsableByteArray.readInt())) {
                            objArr = true;
                            break;
                        }
                        i6++;
                    }
                    if (objArr == false) {
                        return false;
                    }
                } else if (i4 != 0) {
                    extractorInput.advancePeekPosition(i4);
                }
                j = -1;
                z3 = false;
            }
        }
        z2 = false;
        return objArr == true && z == z2;
    }

    public static boolean sniffUnfragmented(ExtractorInput extractorInput) throws IOException, InterruptedException {
        return sniffInternal(extractorInput, false);
    }
}
