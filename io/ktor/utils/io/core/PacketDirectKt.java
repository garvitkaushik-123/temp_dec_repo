package io.ktor.utils.io.core;

import com.ironsource.D5;
import io.ktor.utils.io.core.internal.ChunkBuffer;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PacketDirect.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a;\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00042\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u0006H\u0081\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\b"}, d2 = {"read", "", "Lio/ktor/utils/io/core/Input;", D5.q, "", "block", "Lkotlin/Function1;", "Lio/ktor/utils/io/core/Buffer;", "ktor-io"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class PacketDirectKt {
    public static /* synthetic */ void read$default(Input input, int i, Function1 block, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 1;
        }
        Intrinsics.checkNotNullParameter(input, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        ChunkBuffer prepareRead = input.prepareRead(i);
        if (prepareRead == null) {
            StringsKt.prematureEndOfStream(i);
            throw new KotlinNothingValueException();
        }
        int readPosition = prepareRead.getReadPosition();
        try {
            block.invoke(prepareRead);
            int readPosition2 = prepareRead.getReadPosition();
            if (readPosition2 < readPosition) {
                throw new IllegalStateException("Buffer's position shouldn't be rewinded");
            }
            if (readPosition2 == prepareRead.getWritePosition()) {
                input.ensureNext(prepareRead);
            } else {
                input.setHeadPosition(readPosition2);
            }
        } catch (Throwable th) {
            int readPosition3 = prepareRead.getReadPosition();
            if (readPosition3 < readPosition) {
                throw new IllegalStateException("Buffer's position shouldn't be rewinded");
            }
            if (readPosition3 == prepareRead.getWritePosition()) {
                input.ensureNext(prepareRead);
            } else {
                input.setHeadPosition(readPosition3);
            }
            throw th;
        }
    }

    public static final void read(Input input, int i, Function1<? super Buffer, Unit> block) {
        Intrinsics.checkNotNullParameter(input, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        ChunkBuffer prepareRead = input.prepareRead(i);
        if (prepareRead == null) {
            StringsKt.prematureEndOfStream(i);
            throw new KotlinNothingValueException();
        }
        int readPosition = prepareRead.getReadPosition();
        try {
            block.invoke(prepareRead);
            int readPosition2 = prepareRead.getReadPosition();
            if (readPosition2 < readPosition) {
                throw new IllegalStateException("Buffer's position shouldn't be rewinded");
            }
            if (readPosition2 == prepareRead.getWritePosition()) {
                input.ensureNext(prepareRead);
            } else {
                input.setHeadPosition(readPosition2);
            }
        } catch (Throwable th) {
            int readPosition3 = prepareRead.getReadPosition();
            if (readPosition3 < readPosition) {
                throw new IllegalStateException("Buffer's position shouldn't be rewinded");
            }
            if (readPosition3 == prepareRead.getWritePosition()) {
                input.ensureNext(prepareRead);
            } else {
                input.setHeadPosition(readPosition3);
            }
            throw th;
        }
    }
}
