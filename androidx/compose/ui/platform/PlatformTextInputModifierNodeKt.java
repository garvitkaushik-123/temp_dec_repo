package androidx.compose.ui.platform;

import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.Owner;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* compiled from: PlatformTextInputModifierNode.kt */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a;\u0010\u0007\u001a\u00020\b*\u00020\t2'\u0010\n\u001a#\b\u0001\u0012\u0004\u0012\u00020\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u000b¢\u0006\u0002\b\u000fH\u0086@¢\u0006\u0002\u0010\u0010\"$\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"LocalPlatformTextInputMethodOverride", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/compose/ui/platform/PlatformTextInputSessionHandler;", "getLocalPlatformTextInputMethodOverride$annotations", "()V", "getLocalPlatformTextInputMethodOverride", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "establishTextInputSession", "", "Landroidx/compose/ui/platform/PlatformTextInputModifierNode;", "block", "Lkotlin/Function2;", "Landroidx/compose/ui/platform/PlatformTextInputSessionScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/ui/platform/PlatformTextInputModifierNode;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class PlatformTextInputModifierNodeKt {
    private static final ProvidableCompositionLocal<PlatformTextInputSessionHandler> LocalPlatformTextInputMethodOverride = CompositionLocalKt.staticCompositionLocalOf(new Function0<PlatformTextInputSessionHandler>() { // from class: androidx.compose.ui.platform.PlatformTextInputModifierNodeKt$LocalPlatformTextInputMethodOverride$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final PlatformTextInputSessionHandler invoke() {
            return null;
        }
    });

    public static /* synthetic */ void getLocalPlatformTextInputMethodOverride$annotations() {
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object establishTextInputSession(PlatformTextInputModifierNode platformTextInputModifierNode, Function2<? super PlatformTextInputSessionScope, ? super Continuation<?>, ? extends Object> function2, Continuation<?> continuation) {
        PlatformTextInputModifierNodeKt$establishTextInputSession$1 platformTextInputModifierNodeKt$establishTextInputSession$1;
        int i;
        if (continuation instanceof PlatformTextInputModifierNodeKt$establishTextInputSession$1) {
            platformTextInputModifierNodeKt$establishTextInputSession$1 = (PlatformTextInputModifierNodeKt$establishTextInputSession$1) continuation;
            if ((platformTextInputModifierNodeKt$establishTextInputSession$1.label & Integer.MIN_VALUE) != 0) {
                platformTextInputModifierNodeKt$establishTextInputSession$1.label -= Integer.MIN_VALUE;
                Object obj = platformTextInputModifierNodeKt$establishTextInputSession$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = platformTextInputModifierNodeKt$establishTextInputSession$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    if (!platformTextInputModifierNode.getNode().getIsAttached()) {
                        throw new IllegalArgumentException("establishTextInputSession called from an unattached node".toString());
                    }
                    PlatformTextInputModifierNode platformTextInputModifierNode2 = platformTextInputModifierNode;
                    Owner owner = (PlatformTextInputSessionHandler) DelegatableNodeKt.requireLayoutNode(platformTextInputModifierNode2).getCompositionLocalMap().get(LocalPlatformTextInputMethodOverride);
                    if (owner == null) {
                        owner = DelegatableNodeKt.requireOwner(platformTextInputModifierNode2);
                    }
                    platformTextInputModifierNodeKt$establishTextInputSession$1.label = 1;
                    if (owner.textInputSession(function2, platformTextInputModifierNodeKt$establishTextInputSession$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                throw new KotlinNothingValueException();
            }
        }
        platformTextInputModifierNodeKt$establishTextInputSession$1 = new PlatformTextInputModifierNodeKt$establishTextInputSession$1(continuation);
        Object obj2 = platformTextInputModifierNodeKt$establishTextInputSession$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = platformTextInputModifierNodeKt$establishTextInputSession$1.label;
        if (i != 0) {
        }
        throw new KotlinNothingValueException();
    }

    public static final ProvidableCompositionLocal<PlatformTextInputSessionHandler> getLocalPlatformTextInputMethodOverride() {
        return LocalPlatformTextInputMethodOverride;
    }
}
