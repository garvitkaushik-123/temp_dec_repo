package com.moloco.sdk.internal.services;

import android.content.SharedPreferences;
import com.moloco.sdk.internal.MolocoLogger;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* loaded from: classes6.dex */
public final class D implements w {
    public static final int b = 8;

    /* renamed from: a, reason: collision with root package name */
    public final SharedPreferences f5604a;

    @DebugMetadata(c = "com.moloco.sdk.internal.services.PreferencesDataStoreServiceImpl$getBoolean$2", f = "DataStoreService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f5605a;
        public final /* synthetic */ String c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str, Continuation<? super a> continuation) {
            super(2, continuation);
            this.c = str;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
            return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return D.this.new a(this.c, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f5605a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            if (!D.this.f5604a.contains(this.c)) {
                return null;
            }
            try {
                return Boxing.boxBoolean(D.this.f5604a.getBoolean(this.c, false));
            } catch (ClassCastException unused) {
                MolocoLogger.warn$default(MolocoLogger.INSTANCE, "ContentValues", "Unexpected value type for key: " + this.c, null, false, 12, null);
                return null;
            }
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.internal.services.PreferencesDataStoreServiceImpl$getDouble$2", f = "DataStoreService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Double>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f5606a;
        public final /* synthetic */ String c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(String str, Continuation<? super b> continuation) {
            super(2, continuation);
            this.c = str;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Double> continuation) {
            return ((b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return D.this.new b(this.c, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f5606a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            if (!D.this.f5604a.contains(this.c)) {
                return null;
            }
            try {
                String string = D.this.f5604a.getString(this.c, "0");
                if (string != null) {
                    return Boxing.boxDouble(Double.parseDouble(string));
                }
                return null;
            } catch (ClassCastException e) {
                MolocoLogger.warn$default(MolocoLogger.INSTANCE, "ContentValues", "Unexpected value type for key: " + this.c, e, false, 8, null);
                return null;
            } catch (NumberFormatException e2) {
                MolocoLogger.warn$default(MolocoLogger.INSTANCE, "ContentValues", "Unexpected value type for key: " + this.c, e2, false, 8, null);
                return null;
            }
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.internal.services.PreferencesDataStoreServiceImpl$getFloat$2", f = "DataStoreService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class c extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Float>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f5607a;
        public final /* synthetic */ String c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(String str, Continuation<? super c> continuation) {
            super(2, continuation);
            this.c = str;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Float> continuation) {
            return ((c) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return D.this.new c(this.c, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f5607a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            if (!D.this.f5604a.contains(this.c)) {
                return null;
            }
            try {
                return Boxing.boxFloat(D.this.f5604a.getFloat(this.c, 0.0f));
            } catch (ClassCastException unused) {
                MolocoLogger.warn$default(MolocoLogger.INSTANCE, "ContentValues", "Unexpected value type for key: " + this.c, null, false, 12, null);
                return null;
            }
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.internal.services.PreferencesDataStoreServiceImpl$getInt$2", f = "DataStoreService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class d extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Integer>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f5608a;
        public final /* synthetic */ String c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(String str, Continuation<? super d> continuation) {
            super(2, continuation);
            this.c = str;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Integer> continuation) {
            return ((d) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return D.this.new d(this.c, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f5608a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            if (!D.this.f5604a.contains(this.c)) {
                return null;
            }
            try {
                return Boxing.boxInt(D.this.f5604a.getInt(this.c, 0));
            } catch (ClassCastException unused) {
                MolocoLogger.warn$default(MolocoLogger.INSTANCE, "ContentValues", "Unexpected value type for key: " + this.c, null, false, 12, null);
                return null;
            }
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.internal.services.PreferencesDataStoreServiceImpl$getLong$2", f = "DataStoreService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class e extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Long>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f5609a;
        public final /* synthetic */ String c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(String str, Continuation<? super e> continuation) {
            super(2, continuation);
            this.c = str;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Long> continuation) {
            return ((e) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return D.this.new e(this.c, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f5609a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            if (!D.this.f5604a.contains(this.c)) {
                return null;
            }
            try {
                String string = D.this.f5604a.getString(this.c, "0");
                if (string != null) {
                    return Boxing.boxLong(Long.parseLong(string));
                }
                return null;
            } catch (ClassCastException e) {
                MolocoLogger.warn$default(MolocoLogger.INSTANCE, "ContentValues", "Unexpected value type for key: " + this.c, e, false, 8, null);
                return null;
            } catch (NumberFormatException e2) {
                MolocoLogger.warn$default(MolocoLogger.INSTANCE, "ContentValues", "Unexpected value type for key: " + this.c, e2, false, 8, null);
                return null;
            }
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.internal.services.PreferencesDataStoreServiceImpl$getString$2", f = "DataStoreService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class f extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f5610a;
        public final /* synthetic */ String c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(String str, Continuation<? super f> continuation) {
            super(2, continuation);
            this.c = str;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super String> continuation) {
            return ((f) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return D.this.new f(this.c, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f5610a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            if (!D.this.f5604a.contains(this.c)) {
                return null;
            }
            try {
                return D.this.f5604a.getString(this.c, "");
            } catch (ClassCastException unused) {
                MolocoLogger.warn$default(MolocoLogger.INSTANCE, "ContentValues", "Unexpected value type for key: " + this.c, null, false, 12, null);
                return null;
            }
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.internal.services.PreferencesDataStoreServiceImpl$removeKey$2", f = "DataStoreService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class g extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f5611a;
        public final /* synthetic */ String c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(String str, Continuation<? super g> continuation) {
            super(2, continuation);
            this.c = str;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((g) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return D.this.new g(this.c, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f5611a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            D.this.f5604a.edit().remove(this.c).apply();
            return Unit.INSTANCE;
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.internal.services.PreferencesDataStoreServiceImpl$set$2", f = "DataStoreService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class h extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f5612a;
        public final /* synthetic */ T b;
        public final /* synthetic */ D c;
        public final /* synthetic */ String d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(T t, D d, String str, Continuation<? super h> continuation) {
            super(2, continuation);
            this.b = t;
            this.c = d;
            this.d = str;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((h) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new h(this.b, this.c, this.d, continuation);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f5612a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            T t = this.b;
            if (t instanceof Integer) {
                this.c.f5604a.edit().putInt(this.d, ((Number) this.b).intValue()).apply();
            } else if (t instanceof String) {
                this.c.f5604a.edit().putString(this.d, (String) this.b).apply();
            } else if (t instanceof Float) {
                this.c.f5604a.edit().putFloat(this.d, ((Number) this.b).floatValue()).apply();
            } else if (t instanceof Boolean) {
                this.c.f5604a.edit().putBoolean(this.d, ((Boolean) this.b).booleanValue()).apply();
            } else if (t instanceof Double) {
                this.c.f5604a.edit().putString(this.d, String.valueOf(((Number) this.b).doubleValue())).apply();
            } else if (t instanceof Long) {
                this.c.f5604a.edit().putString(this.d, String.valueOf(((Number) this.b).longValue())).apply();
            } else {
                MolocoLogger.warn$default(MolocoLogger.INSTANCE, "ContentValues", "Unexpected value type: " + this.b + " for key: " + this.d, null, false, 12, null);
            }
            return Unit.INSTANCE;
        }
    }

    public D(SharedPreferences sharedPreferences) {
        Intrinsics.checkNotNullParameter(sharedPreferences, "sharedPreferences");
        this.f5604a = sharedPreferences;
    }

    @Override // com.moloco.sdk.internal.services.w
    public Object b(String str, Continuation<? super Double> continuation) {
        return BuildersKt.withContext(com.moloco.sdk.internal.scheduling.b.a().getIo(), new b(str, null), continuation);
    }

    @Override // com.moloco.sdk.internal.services.w
    public Object c(String str, Continuation<? super Float> continuation) {
        return BuildersKt.withContext(com.moloco.sdk.internal.scheduling.b.a().getIo(), new c(str, null), continuation);
    }

    @Override // com.moloco.sdk.internal.services.w
    public Object d(String str, Continuation<? super String> continuation) {
        return BuildersKt.withContext(com.moloco.sdk.internal.scheduling.b.a().getIo(), new f(str, null), continuation);
    }

    @Override // com.moloco.sdk.internal.services.w
    public Object e(String str, Continuation<? super Integer> continuation) {
        return BuildersKt.withContext(com.moloco.sdk.internal.scheduling.b.a().getIo(), new d(str, null), continuation);
    }

    @Override // com.moloco.sdk.internal.services.w
    public Object f(String str, Continuation<? super Boolean> continuation) {
        return BuildersKt.withContext(com.moloco.sdk.internal.scheduling.b.a().getIo(), new a(str, null), continuation);
    }

    @Override // com.moloco.sdk.internal.services.w
    public Object g(String str, Continuation<? super Long> continuation) {
        return BuildersKt.withContext(com.moloco.sdk.internal.scheduling.b.a().getIo(), new e(str, null), continuation);
    }

    @Override // com.moloco.sdk.internal.services.w
    public Object a(String str, Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(com.moloco.sdk.internal.scheduling.b.a().getIo(), new g(str, null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }

    @Override // com.moloco.sdk.internal.services.w
    public <T> Object a(String str, T t, Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(com.moloco.sdk.internal.scheduling.b.a().getIo(), new h(t, this, str, null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }
}
