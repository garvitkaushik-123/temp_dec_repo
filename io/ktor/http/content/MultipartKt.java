package io.ktor.http.content;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;

/* compiled from: Multipart.kt */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\u001a9\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\"\u0010\u0003\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0004H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\b\u001a\u001b\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\n*\u00020\u0002H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u000b\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\f"}, d2 = {"forEachPart", "", "Lio/ktor/http/content/MultiPartData;", "partHandler", "Lkotlin/Function2;", "Lio/ktor/http/content/PartData;", "Lkotlin/coroutines/Continuation;", "", "(Lio/ktor/http/content/MultiPartData;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "readAllParts", "", "(Lio/ktor/http/content/MultiPartData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ktor-http"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class MultipartKt {
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0070, code lost:
    
        if (r6.invoke(r8, r0) == r1) goto L28;
     */
    /* JADX WARN: Removed duplicated region for block: B:14:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0070 -> B:11:0x0034). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object forEachPart(MultiPartData multiPartData, Function2<? super PartData, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) {
        MultipartKt$forEachPart$1 multipartKt$forEachPart$1;
        int i;
        MultiPartData multiPartData2;
        Function2<? super PartData, ? super Continuation<? super Unit>, ? extends Object> function22;
        PartData partData;
        if (continuation instanceof MultipartKt$forEachPart$1) {
            multipartKt$forEachPart$1 = (MultipartKt$forEachPart$1) continuation;
            if ((multipartKt$forEachPart$1.label & Integer.MIN_VALUE) != 0) {
                multipartKt$forEachPart$1.label -= Integer.MIN_VALUE;
                Object obj = multipartKt$forEachPart$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = multipartKt$forEachPart$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    multipartKt$forEachPart$1.L$0 = multiPartData;
                    multipartKt$forEachPart$1.L$1 = function2;
                    multipartKt$forEachPart$1.label = 1;
                    obj = multiPartData.readPart(multipartKt$forEachPart$1);
                    if (obj != coroutine_suspended) {
                    }
                    return coroutine_suspended;
                }
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    function22 = (Function2) multipartKt$forEachPart$1.L$1;
                    multiPartData2 = (MultiPartData) multipartKt$forEachPart$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    MultiPartData multiPartData3 = multiPartData2;
                    function2 = function22;
                    multiPartData = multiPartData3;
                    multipartKt$forEachPart$1.L$0 = multiPartData;
                    multipartKt$forEachPart$1.L$1 = function2;
                    multipartKt$forEachPart$1.label = 1;
                    obj = multiPartData.readPart(multipartKt$forEachPart$1);
                    if (obj != coroutine_suspended) {
                        Function2<? super PartData, ? super Continuation<? super Unit>, ? extends Object> function23 = function2;
                        multiPartData2 = multiPartData;
                        function22 = function23;
                        partData = (PartData) obj;
                        if (partData == null) {
                            multipartKt$forEachPart$1.L$0 = multiPartData2;
                            multipartKt$forEachPart$1.L$1 = function22;
                            multipartKt$forEachPart$1.label = 2;
                        } else {
                            return Unit.INSTANCE;
                        }
                    }
                    return coroutine_suspended;
                }
                function22 = (Function2) multipartKt$forEachPart$1.L$1;
                multiPartData2 = (MultiPartData) multipartKt$forEachPart$1.L$0;
                ResultKt.throwOnFailure(obj);
                partData = (PartData) obj;
                if (partData == null) {
                }
            }
        }
        multipartKt$forEachPart$1 = new MultipartKt$forEachPart$1(continuation);
        Object obj2 = multipartKt$forEachPart$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = multipartKt$forEachPart$1.label;
        if (i != 0) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0071, code lost:
    
        if (r7 != r1) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0073, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0050, code lost:
    
        if (r7 == r1) goto L26;
     */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0071 -> B:11:0x0074). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object readAllParts(MultiPartData multiPartData, Continuation<? super List<? extends PartData>> continuation) {
        MultipartKt$readAllParts$1 multipartKt$readAllParts$1;
        int i;
        PartData partData;
        MultiPartData multiPartData2;
        ArrayList arrayList;
        if (continuation instanceof MultipartKt$readAllParts$1) {
            multipartKt$readAllParts$1 = (MultipartKt$readAllParts$1) continuation;
            if ((multipartKt$readAllParts$1.label & Integer.MIN_VALUE) != 0) {
                multipartKt$readAllParts$1.label -= Integer.MIN_VALUE;
                Object obj = multipartKt$readAllParts$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = multipartKt$readAllParts$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    multipartKt$readAllParts$1.L$0 = multiPartData;
                    multipartKt$readAllParts$1.label = 1;
                    obj = multiPartData.readPart(multipartKt$readAllParts$1);
                } else if (i == 1) {
                    multiPartData = (MultiPartData) multipartKt$readAllParts$1.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    arrayList = (ArrayList) multipartKt$readAllParts$1.L$1;
                    multiPartData2 = (MultiPartData) multipartKt$readAllParts$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    PartData partData2 = (PartData) obj;
                    if (partData2 == null) {
                        return arrayList;
                    }
                    arrayList.add(partData2);
                    multipartKt$readAllParts$1.L$0 = multiPartData2;
                    multipartKt$readAllParts$1.L$1 = arrayList;
                    multipartKt$readAllParts$1.label = 2;
                    obj = multiPartData2.readPart(multipartKt$readAllParts$1);
                }
                partData = (PartData) obj;
                if (partData != null) {
                    return CollectionsKt.emptyList();
                }
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(partData);
                multiPartData2 = multiPartData;
                arrayList = arrayList2;
                multipartKt$readAllParts$1.L$0 = multiPartData2;
                multipartKt$readAllParts$1.L$1 = arrayList;
                multipartKt$readAllParts$1.label = 2;
                obj = multiPartData2.readPart(multipartKt$readAllParts$1);
            }
        }
        multipartKt$readAllParts$1 = new MultipartKt$readAllParts$1(continuation);
        Object obj2 = multipartKt$readAllParts$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = multipartKt$readAllParts$1.label;
        if (i != 0) {
        }
        partData = (PartData) obj2;
        if (partData != null) {
        }
    }
}
