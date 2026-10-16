package io.adn.sdk.internal.ui.common.design.compose;

import io.adn.sdk.internal.ui.common.model.ClickPosition;
import io.adn.sdk.internal.ui.common.mraid.MraidController;
import io.adn.sdk.internal.ui.common.mraid.MraidControllerEvent;
import io.adn.sdk.publisher.AdnClickElement;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* compiled from: AdHtmlWebView.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.adn.sdk.internal.ui.common.design.compose.AdHtmlWebViewKt$AdHtmlWebView$1$1", f = "AdHtmlWebView.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes7.dex */
final class AdHtmlWebViewKt$AdHtmlWebView$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MraidController $controller;
    final /* synthetic */ Function3<Boolean, AdnClickElement, ClickPosition, Unit> $onClick;
    final /* synthetic */ Function0<Unit> $onDismiss;
    final /* synthetic */ Function0<Unit> $onDisplayed;
    final /* synthetic */ CoroutineScope $scope;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    AdHtmlWebViewKt$AdHtmlWebView$1$1(CoroutineScope coroutineScope, MraidController mraidController, Function0<Unit> function0, Function0<Unit> function02, Function3<? super Boolean, ? super AdnClickElement, ? super ClickPosition, Unit> function3, Continuation<? super AdHtmlWebViewKt$AdHtmlWebView$1$1> continuation) {
        super(2, continuation);
        this.$scope = coroutineScope;
        this.$controller = mraidController;
        this.$onDisplayed = function0;
        this.$onDismiss = function02;
        this.$onClick = function3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AdHtmlWebViewKt$AdHtmlWebView$1$1(this.$scope, this.$controller, this.$onDisplayed, this.$onDismiss, this.$onClick, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AdHtmlWebViewKt$AdHtmlWebView$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* compiled from: AdHtmlWebView.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "io.adn.sdk.internal.ui.common.design.compose.AdHtmlWebViewKt$AdHtmlWebView$1$1$1", f = "AdHtmlWebView.kt", i = {}, l = {37}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: io.adn.sdk.internal.ui.common.design.compose.AdHtmlWebViewKt$AdHtmlWebView$1$1$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ MraidController $controller;
        final /* synthetic */ Function3<Boolean, AdnClickElement, ClickPosition, Unit> $onClick;
        final /* synthetic */ Function0<Unit> $onDismiss;
        final /* synthetic */ Function0<Unit> $onDisplayed;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(MraidController mraidController, Function0<Unit> function0, Function0<Unit> function02, Function3<? super Boolean, ? super AdnClickElement, ? super ClickPosition, Unit> function3, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$controller = mraidController;
            this.$onDisplayed = function0;
            this.$onDismiss = function02;
            this.$onClick = function3;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$controller, this.$onDisplayed, this.$onDismiss, this.$onClick, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Flow<MraidControllerEvent> event = this.$controller.getEvent();
                final Function0<Unit> function0 = this.$onDisplayed;
                final Function0<Unit> function02 = this.$onDismiss;
                final Function3<Boolean, AdnClickElement, ClickPosition, Unit> function3 = this.$onClick;
                this.label = 1;
                if (event.collect(new FlowCollector() { // from class: io.adn.sdk.internal.ui.common.design.compose.AdHtmlWebViewKt.AdHtmlWebView.1.1.1.1
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                        return emit((MraidControllerEvent) obj2, (Continuation<? super Unit>) continuation);
                    }

                    public final Object emit(MraidControllerEvent mraidControllerEvent, Continuation<? super Unit> continuation) {
                        if (mraidControllerEvent instanceof MraidControllerEvent.Displayed) {
                            function0.invoke();
                        } else if (mraidControllerEvent instanceof MraidControllerEvent.Dismiss) {
                            function02.invoke();
                        } else {
                            if (!(mraidControllerEvent instanceof MraidControllerEvent.ClickThrough)) {
                                throw new NoWhenBranchMatchedException();
                            }
                            MraidControllerEvent.ClickThrough clickThrough = (MraidControllerEvent.ClickThrough) mraidControllerEvent;
                            function3.invoke(Boxing.boxBoolean(clickThrough.getHasUserClicked()), clickThrough.getClickElement(), clickThrough.getClickPosition());
                        }
                        return Unit.INSTANCE;
                    }
                }, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            BuildersKt__Builders_commonKt.launch$default(this.$scope, null, null, new AnonymousClass1(this.$controller, this.$onDisplayed, this.$onDismiss, this.$onClick, null), 3, null);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
