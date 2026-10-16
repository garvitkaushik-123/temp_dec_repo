package com.google.android.exoplayer2.extractor.mp4;

import android.support.v4.media.session.PlaybackStateCompat;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.io.IOException;

@Deprecated
/* loaded from: classes4.dex */
final class Sniffer {
    public static final int BRAND_HEIC = 1751476579;
    public static final int BRAND_QUICKTIME = 1903435808;
    private static final int[] COMPATIBLE_BRANDS = {1769172845, 1769172786, 1769172787, 1769172788, 1769172789, 1769172790, 1769172793, 1635148593, 1752589105, 1751479857, 1635135537, 1836069937, 1836069938, 862401121, 862401122, 862417462, 862417718, 862414134, 862414646, 1295275552, 1295270176, 1714714144, 1801741417, 1295275600, 1903435808, 1297305174, 1684175153, 1769172332, 1885955686};
    private static final int SEARCH_LENGTH = 4096;

    public static boolean sniffFragmented(ExtractorInput extractorInput) throws IOException {
        return sniffInternal(extractorInput, true, false);
    }

    public static boolean sniffUnfragmented(ExtractorInput extractorInput) throws IOException {
        return sniffInternal(extractorInput, false, false);
    }

    public static boolean sniffUnfragmented(ExtractorInput extractorInput, boolean z) throws IOException {
        return sniffInternal(extractorInput, false, z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean sniffInternal(ExtractorInput extractorInput, boolean z, boolean z2) throws IOException {
        boolean z3;
        boolean z4;
        int i;
        int i2;
        long length = extractorInput.getLength();
        long j = -1;
        int i3 = (length > (-1L) ? 1 : (length == (-1L) ? 0 : -1));
        long j2 = PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
        if (i3 != 0 && length <= PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM) {
            j2 = length;
        }
        int i4 = (int) j2;
        ParsableByteArray parsableByteArray = new ParsableByteArray(64);
        int i5 = 0;
        int i6 = 0;
        boolean z5 = false;
        while (i6 < i4) {
            parsableByteArray.reset(8);
            if (!extractorInput.peekFully(parsableByteArray.getData(), i5, 8, true)) {
                break;
            }
            long readUnsignedInt = parsableByteArray.readUnsignedInt();
            int readInt = parsableByteArray.readInt();
            if (readUnsignedInt == 1) {
                extractorInput.peekFully(parsableByteArray.getData(), 8, 8);
                parsableByteArray.setLimit(16);
                z4 = i5;
                i = i6;
                i2 = 16;
                readUnsignedInt = parsableByteArray.readLong();
            } else {
                if (readUnsignedInt == 0) {
                    long length2 = extractorInput.getLength();
                    if (length2 != j) {
                        readUnsignedInt = (length2 - extractorInput.getPeekPosition()) + 8;
                    }
                }
                z4 = i5;
                i = i6;
                i2 = 8;
            }
            long j3 = i2;
            if (readUnsignedInt < j3) {
                return z4;
            }
            int i7 = i + i2;
            boolean z6 = z4;
            if (readInt == 1836019574) {
                i4 += (int) readUnsignedInt;
                if (i3 != 0 && i4 > length) {
                    i4 = (int) length;
                }
                i6 = i7;
                i5 = z6 ? 1 : 0;
                j = -1;
            } else {
                if (readInt == 1836019558 || readInt == 1836475768) {
                    z3 = true;
                    break;
                }
                int i8 = i3;
                if ((i7 + readUnsignedInt) - j3 >= i4) {
                    break;
                }
                int i9 = (int) (readUnsignedInt - j3);
                i6 = i7 + i9;
                if (readInt == 1718909296) {
                    if (i9 < 8) {
                        return z6;
                    }
                    parsableByteArray.reset(i9);
                    extractorInput.peekFully(parsableByteArray.getData(), z6 ? 1 : 0, i9);
                    int i10 = i9 / 4;
                    int i11 = 0;
                    while (true) {
                        if (i11 >= i10) {
                            break;
                        }
                        if (i11 == 1) {
                            parsableByteArray.skipBytes(4);
                        } else if (isCompatibleBrand(parsableByteArray.readInt(), z2)) {
                            z5 = true;
                            break;
                        }
                        i11++;
                    }
                    if (!z5) {
                        return false;
                    }
                } else if (i9 != 0) {
                    extractorInput.advancePeekPosition(i9);
                }
                i3 = i8;
                j = -1;
                i5 = 0;
            }
        }
        z3 = false;
        return z5 && z == z3;
    }

    private static boolean isCompatibleBrand(int i, boolean z) {
        if ((i >>> 8) == 3368816) {
            return true;
        }
        if (i == 1751476579 && z) {
            return true;
        }
        for (int i2 : COMPATIBLE_BRANDS) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }

    private Sniffer() {
    }
}
