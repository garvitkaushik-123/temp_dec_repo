package io.bidmachine.media3.decoder;

import io.bidmachine.media3.decoder.DecoderException;

/* loaded from: classes7.dex */
public interface Decoder<I, O, E extends DecoderException> {
    I dequeueInputBuffer() throws DecoderException;

    O dequeueOutputBuffer() throws DecoderException;

    void flush();

    String getName();

    void queueInputBuffer(I i) throws DecoderException;

    void release();

    void setOutputStartTimeUs(long j);
}
