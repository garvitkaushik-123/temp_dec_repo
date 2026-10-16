package com.mbridge.msdk.playercommon.exoplayer2.extractor.wav;

import android.util.Log;
import com.mbridge.msdk.playercommon.exoplayer2.ParserException;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ExtractorInput;
import com.mbridge.msdk.playercommon.exoplayer2.util.Assertions;
import com.mbridge.msdk.playercommon.exoplayer2.util.ParsableByteArray;
import com.mbridge.msdk.playercommon.exoplayer2.util.Util;
import java.io.IOException;

/* loaded from: classes6.dex */
final class WavHeaderReader {
    private static final String TAG = "WavHeaderReader";
    private static final int TYPE_FLOAT = 3;
    private static final int TYPE_PCM = 1;
    private static final int TYPE_WAVE_FORMAT_EXTENSIBLE = 65534;

    private static final class ChunkHeader {
        public static final int SIZE_IN_BYTES = 8;
        public final int id;
        public final long size;

        private ChunkHeader(int i, long j) {
            this.id = i;
            this.size = j;
        }

        public static ChunkHeader peek(ExtractorInput extractorInput, ParsableByteArray parsableByteArray) throws IOException, InterruptedException {
            extractorInput.peekFully(parsableByteArray.data, 0, 8);
            parsableByteArray.setPosition(0);
            return new ChunkHeader(parsableByteArray.readInt(), parsableByteArray.readLittleEndianUnsignedInt());
        }
    }

    private WavHeaderReader() {
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00de  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static WavHeader peek(ExtractorInput extractorInput) throws IOException, InterruptedException {
        int i;
        Assertions.checkNotNull(extractorInput);
        ParsableByteArray parsableByteArray = new ParsableByteArray(16);
        if (ChunkHeader.peek(extractorInput, parsableByteArray).id != Util.getIntegerCodeForString("RIFF")) {
            return null;
        }
        int i2 = 0;
        extractorInput.peekFully(parsableByteArray.data, 0, 4);
        parsableByteArray.setPosition(0);
        int readInt = parsableByteArray.readInt();
        if (readInt != Util.getIntegerCodeForString("WAVE")) {
            Log.e(TAG, "Unsupported RIFF format: " + readInt);
            return null;
        }
        ChunkHeader peek = ChunkHeader.peek(extractorInput, parsableByteArray);
        while (peek.id != Util.getIntegerCodeForString("fmt ")) {
            extractorInput.advancePeekPosition((int) peek.size);
            peek = ChunkHeader.peek(extractorInput, parsableByteArray);
        }
        Assertions.checkState(peek.size >= 16);
        extractorInput.peekFully(parsableByteArray.data, 0, 16);
        parsableByteArray.setPosition(0);
        int readLittleEndianUnsignedShort = parsableByteArray.readLittleEndianUnsignedShort();
        int readLittleEndianUnsignedShort2 = parsableByteArray.readLittleEndianUnsignedShort();
        int readLittleEndianUnsignedIntToInt = parsableByteArray.readLittleEndianUnsignedIntToInt();
        int readLittleEndianUnsignedIntToInt2 = parsableByteArray.readLittleEndianUnsignedIntToInt();
        int readLittleEndianUnsignedShort3 = parsableByteArray.readLittleEndianUnsignedShort();
        int readLittleEndianUnsignedShort4 = parsableByteArray.readLittleEndianUnsignedShort();
        int i3 = (readLittleEndianUnsignedShort2 * readLittleEndianUnsignedShort4) / 8;
        if (readLittleEndianUnsignedShort3 != i3) {
            throw new ParserException("Expected block alignment: " + i3 + "; got: " + readLittleEndianUnsignedShort3);
        }
        if (readLittleEndianUnsignedShort != 1) {
            if (readLittleEndianUnsignedShort == 3) {
                if (readLittleEndianUnsignedShort4 == 32) {
                    i = 4;
                    if (i == 0) {
                        Log.e(TAG, "Unsupported WAV bit depth " + readLittleEndianUnsignedShort4 + " for type " + readLittleEndianUnsignedShort);
                        return null;
                    }
                    extractorInput.advancePeekPosition(((int) peek.size) - 16);
                    return new WavHeader(readLittleEndianUnsignedShort2, readLittleEndianUnsignedIntToInt, readLittleEndianUnsignedIntToInt2, readLittleEndianUnsignedShort3, readLittleEndianUnsignedShort4, i);
                }
                i = i2;
                if (i == 0) {
                }
            } else if (readLittleEndianUnsignedShort != 65534) {
                Log.e(TAG, "Unsupported WAV format type: " + readLittleEndianUnsignedShort);
                return null;
            }
        }
        i2 = Util.getPcmEncoding(readLittleEndianUnsignedShort4);
        i = i2;
        if (i == 0) {
        }
    }

    public static void skipToData(ExtractorInput extractorInput, WavHeader wavHeader) throws IOException, InterruptedException {
        Assertions.checkNotNull(extractorInput);
        Assertions.checkNotNull(wavHeader);
        extractorInput.resetPeekPosition();
        ParsableByteArray parsableByteArray = new ParsableByteArray(8);
        ChunkHeader peek = ChunkHeader.peek(extractorInput, parsableByteArray);
        while (peek.id != Util.getIntegerCodeForString("data")) {
            Log.w(TAG, "Ignoring unknown WAV chunk: " + peek.id);
            long j = peek.size + 8;
            if (peek.id == Util.getIntegerCodeForString("RIFF")) {
                j = 12;
            }
            if (j > 2147483647L) {
                throw new ParserException("Chunk is too large (~2GB+) to skip; id: " + peek.id);
            }
            extractorInput.skipFully((int) j);
            peek = ChunkHeader.peek(extractorInput, parsableByteArray);
        }
        extractorInput.skipFully(8);
        wavHeader.setDataBounds(extractorInput.getPosition(), peek.size);
    }
}
