package io.adn.sdk.internal.data.parser;

import android.util.Xml;
import io.adn.sdk.internal.common.logger.Logger;
import io.adn.sdk.internal.data.dto.VastDto;
import java.io.Closeable;
import java.io.StringReader;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import org.xmlpull.v1.XmlPullParser;

/* compiled from: VastParser.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0086@¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"Lio/adn/sdk/internal/data/parser/VastParser;", "", "<init>", "()V", "parse", "Lio/adn/sdk/internal/data/dto/VastDto;", "vastXml", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class VastParser {
    public static final int $stable = 0;

    /* JADX WARN: Can't wrap try/catch for region: R(14:0|1|(2:3|(10:5|6|7|(1:(2:10|11)(2:24|25))(4:26|27|28|(1:30))|12|13|14|(1:16)|17|(1:22)(2:19|20)))|40|6|7|(0)(0)|12|13|14|(0)|17|(0)(0)|(2:(0)|(1:36))) */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x007b, code lost:
    
        r8 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x007c, code lost:
    
        r9 = kotlin.Result.INSTANCE;
        r8 = kotlin.Result.m10241constructorimpl(kotlin.ResultKt.createFailure(r8));
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:16:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0025  */
    /* JADX WARN: Type inference failed for: r8v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r8v1, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r8v13 */
    /* JADX WARN: Type inference failed for: r8v14 */
    /* JADX WARN: Type inference failed for: r8v8, types: [java.io.Closeable] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object parse(String str, Continuation<? super VastDto> continuation) {
        VastParser$parse$1 vastParser$parse$1;
        int i;
        Object m10241constructorimpl;
        Throwable m10244exceptionOrNullimpl;
        try {
            if (continuation instanceof VastParser$parse$1) {
                vastParser$parse$1 = (VastParser$parse$1) continuation;
                if ((vastParser$parse$1.label & Integer.MIN_VALUE) != 0) {
                    vastParser$parse$1.label -= Integer.MIN_VALUE;
                    Object obj = vastParser$parse$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = vastParser$parse$1.label;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj);
                        Result.Companion companion = Result.INSTANCE;
                        VastParser vastParser = this;
                        StringReader stringReader = new StringReader(str);
                        XmlPullParser newPullParser = Xml.newPullParser();
                        newPullParser.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", false);
                        newPullParser.setInput(stringReader);
                        Intrinsics.checkNotNullExpressionValue(newPullParser, "apply(...)");
                        vastParser$parse$1.L$0 = stringReader;
                        vastParser$parse$1.label = 1;
                        obj = VastParserKt.parseVast(newPullParser, vastParser$parse$1);
                        str = stringReader;
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        Closeable closeable = (Closeable) vastParser$parse$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        str = closeable;
                    }
                    VastDto vastDto = (VastDto) obj;
                    CloseableKt.closeFinally(str, null);
                    m10241constructorimpl = Result.m10241constructorimpl(vastDto);
                    m10244exceptionOrNullimpl = Result.m10244exceptionOrNullimpl(m10241constructorimpl);
                    if (m10244exceptionOrNullimpl != null) {
                        Logger.INSTANCE.e("VastParser", m10244exceptionOrNullimpl);
                    }
                    if (Result.m10247isFailureimpl(m10241constructorimpl)) {
                        return m10241constructorimpl;
                    }
                    return null;
                }
            }
            if (i != 0) {
            }
            VastDto vastDto2 = (VastDto) obj;
            CloseableKt.closeFinally(str, null);
            m10241constructorimpl = Result.m10241constructorimpl(vastDto2);
            m10244exceptionOrNullimpl = Result.m10244exceptionOrNullimpl(m10241constructorimpl);
            if (m10244exceptionOrNullimpl != null) {
            }
            if (Result.m10247isFailureimpl(m10241constructorimpl)) {
            }
        } finally {
        }
        vastParser$parse$1 = new VastParser$parse$1(this, continuation);
        Object obj2 = vastParser$parse$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = vastParser$parse$1.label;
    }
}
