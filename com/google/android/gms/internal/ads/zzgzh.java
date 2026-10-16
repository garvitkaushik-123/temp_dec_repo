package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgzb;
import com.google.android.gms.internal.ads.zzgzh;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: com.google.android.gms:play-services-ads-api@@24.5.0 */
/* loaded from: classes5.dex */
public abstract class zzgzh<MessageType extends zzgzh<MessageType, BuilderType>, BuilderType extends zzgzb<MessageType, BuilderType>> extends zzgxi<MessageType, BuilderType> {
    private static final int zza = Integer.MIN_VALUE;
    private static final int zzb = Integer.MAX_VALUE;
    private static Map<Class<?>, zzgzh<?, ?>> zzc = new ConcurrentHashMap();
    static final int zzr = Integer.MAX_VALUE;
    static final int zzs = 0;
    private int zzd = -1;
    protected zzhby zzt = zzhby.zzc();

    protected static zzgzj zzbA() {
        return zzgxp.zzd();
    }

    protected static zzgzj zzbB(zzgzj zzgzjVar) {
        int size = zzgzjVar.size();
        return zzgzjVar.zzf(size + size);
    }

    protected static zzgzk zzbC() {
        return zzgyo.zze();
    }

    protected static zzgzk zzbD(zzgzk zzgzkVar) {
        int size = zzgzkVar.size();
        return zzgzkVar.zzf(size + size);
    }

    protected static zzgzo zzbE() {
        return zzgyy.zze();
    }

    protected static zzgzo zzbF(zzgzo zzgzoVar) {
        int size = zzgzoVar.size();
        return zzgzoVar.zzf(size + size);
    }

    protected static zzgzp zzbG() {
        return zzgzi.zzg();
    }

    protected static zzgzp zzbH(zzgzp zzgzpVar) {
        int size = zzgzpVar.size();
        return zzgzpVar.zzf(size + size);
    }

    protected static zzgzs zzbI() {
        return zzhah.zzh();
    }

    protected static zzgzs zzbJ(zzgzs zzgzsVar) {
        int size = zzgzsVar.size();
        return zzgzsVar.zzf(size + size);
    }

    protected static <E> zzgzt<E> zzbK() {
        return zzhbd.zzd();
    }

    protected static <E> zzgzt<E> zzbL(zzgzt<E> zzgztVar) {
        int size = zzgztVar.size();
        return zzgztVar.zzf(size + size);
    }

    static Object zzbP(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e);
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            if (cause instanceof Error) {
                throw ((Error) cause);
            }
            throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
        }
    }

    protected static Object zzbQ(zzhas zzhasVar, String str, Object[] objArr) {
        return new zzhbe(zzhasVar, str, objArr);
    }

    static Method zzbR(Class cls, String str, Class... clsArr) {
        try {
            return cls.getMethod(str, clsArr);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException("Generated message class \"" + cls.getName() + "\" missing method \"" + str + "\".", e);
        }
    }

    protected static <T extends zzgzh> void zzbZ(Class<T> cls, T t) {
        t.zzbV();
        zzc.put(cls, t);
    }

    public static <ContainingType extends zzhas, Type> zzgzf<ContainingType, Type> zzbe(ContainingType containingtype, zzhas zzhasVar, zzgzm zzgzmVar, int i, zzhck zzhckVar, boolean z, Class cls) {
        return new zzgzf<>(containingtype, zzhbd.zzd(), zzhasVar, new zzgze(zzgzmVar, i, zzhckVar, true, z), cls);
    }

    public static <ContainingType extends zzhas, Type> zzgzf<ContainingType, Type> zzbf(ContainingType containingtype, Type type, zzhas zzhasVar, zzgzm zzgzmVar, int i, zzhck zzhckVar, Class cls) {
        return new zzgzf<>(containingtype, type, zzhasVar, new zzgze(zzgzmVar, i, zzhckVar, false, false), cls);
    }

    static <T extends zzgzh> T zzbh(Class<T> cls) {
        zzgzh<?, ?> zzgzhVar = zzc.get(cls);
        if (zzgzhVar == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                zzgzhVar = zzc.get(cls);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException("Class initialization cannot fail.", e);
            }
        }
        if (zzgzhVar != null) {
            return zzgzhVar;
        }
        zzgzh<?, ?> zzbt = ((zzgzh) zzhce.zzg(cls)).zzbt();
        if (zzbt == null) {
            throw new IllegalStateException();
        }
        zzc.put(cls, zzbt);
        return zzbt;
    }

    protected static <T extends zzgzh<T, ?>> T zzbk(T t, InputStream inputStream) throws zzgzw {
        int i = zzgyr.zzb;
        int i2 = zzhbc.zza;
        T t2 = (T) zzg(t, inputStream, zzgyr.zza);
        zzf(t2);
        return t2;
    }

    protected static <T extends zzgzh<T, ?>> T zzbl(T t, InputStream inputStream, zzgyr zzgyrVar) throws zzgzw {
        T t2 = (T) zzg(t, inputStream, zzgyrVar);
        zzf(t2);
        return t2;
    }

    protected static <T extends zzgzh<T, ?>> T zzbm(T t, zzgxz zzgxzVar) throws zzgzw {
        int i = zzgyr.zzb;
        int i2 = zzhbc.zza;
        T t2 = (T) zzbr(t, zzgxzVar, zzgyr.zza);
        zzf(t2);
        return t2;
    }

    protected static <T extends zzgzh<T, ?>> T zzbn(T t, zzgyf zzgyfVar) throws zzgzw {
        int i = zzgyr.zzb;
        int i2 = zzhbc.zza;
        return (T) zzbs(t, zzgyfVar, zzgyr.zza);
    }

    protected static <T extends zzgzh<T, ?>> T zzbo(T t, InputStream inputStream) throws zzgzw {
        zzgyf zzG = zzgyf.zzG(inputStream, 4096);
        int i = zzgyr.zzb;
        int i2 = zzhbc.zza;
        T t2 = (T) zzbz(t, zzG, zzgyr.zza);
        zzf(t2);
        return t2;
    }

    protected static <T extends zzgzh<T, ?>> T zzbp(T t, ByteBuffer byteBuffer) throws zzgzw {
        int i = zzgyr.zzb;
        int i2 = zzhbc.zza;
        return (T) zzbv(t, byteBuffer, zzgyr.zza);
    }

    protected static <T extends zzgzh<T, ?>> T zzbq(T t, byte[] bArr) throws zzgzw {
        int length = bArr.length;
        int i = zzgyr.zzb;
        int i2 = zzhbc.zza;
        T t2 = (T) zzi(t, bArr, 0, length, zzgyr.zza);
        zzf(t2);
        return t2;
    }

    protected static <T extends zzgzh<T, ?>> T zzbr(T t, zzgxz zzgxzVar, zzgyr zzgyrVar) throws zzgzw {
        T t2 = (T) zzh(t, zzgxzVar, zzgyrVar);
        zzf(t2);
        return t2;
    }

    protected static <T extends zzgzh<T, ?>> T zzbs(T t, zzgyf zzgyfVar, zzgyr zzgyrVar) throws zzgzw {
        T t2 = (T) zzbz(t, zzgyfVar, zzgyrVar);
        zzf(t2);
        return t2;
    }

    protected static <T extends zzgzh<T, ?>> T zzbu(T t, InputStream inputStream, zzgyr zzgyrVar) throws zzgzw {
        T t2 = (T) zzbz(t, zzgyf.zzG(inputStream, 4096), zzgyrVar);
        zzf(t2);
        return t2;
    }

    protected static <T extends zzgzh<T, ?>> T zzbv(T t, ByteBuffer byteBuffer, zzgyr zzgyrVar) throws zzgzw {
        zzgyf zzH;
        int i = zzgyf.zze;
        boolean z = false;
        if (byteBuffer.hasArray()) {
            zzH = zzgyf.zzH(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining(), false);
        } else {
            if (byteBuffer.isDirect()) {
                int i2 = zzgyd.zza;
                if (zzhce.zzB()) {
                    zzH = new zzgyd(byteBuffer, z, null);
                }
            }
            int remaining = byteBuffer.remaining();
            byte[] bArr = new byte[remaining];
            byteBuffer.duplicate().get(bArr);
            zzH = zzgyf.zzH(bArr, 0, remaining, true);
        }
        T t2 = (T) zzbs(t, zzH, zzgyrVar);
        zzf(t2);
        return t2;
    }

    protected static <T extends zzgzh<T, ?>> T zzbx(T t, byte[] bArr, zzgyr zzgyrVar) throws zzgzw {
        T t2 = (T) zzi(t, bArr, 0, bArr.length, zzgyrVar);
        zzf(t2);
        return t2;
    }

    protected static <T extends zzgzh<T, ?>> T zzby(T t, zzgyf zzgyfVar) throws zzgzw {
        int i = zzgyr.zzb;
        int i2 = zzhbc.zza;
        return (T) zzbz(t, zzgyfVar, zzgyr.zza);
    }

    static <T extends zzgzh<T, ?>> T zzbz(T t, zzgyf zzgyfVar, zzgyr zzgyrVar) throws zzgzw {
        T t2 = (T) t.zzbj();
        try {
            zzhbl zzb2 = zzhbc.zza().zzb(t2.getClass());
            zzb2.zzh(t2, zzgyg.zzq(zzgyfVar), zzgyrVar);
            zzb2.zzf(t2);
            return t2;
        } catch (zzgzw e) {
            if (e.zzb()) {
                throw new zzgzw(e);
            }
            throw e;
        } catch (zzhbw e2) {
            throw e2.zza();
        } catch (IOException e3) {
            if (e3.getCause() instanceof zzgzw) {
                throw ((zzgzw) e3.getCause());
            }
            throw new zzgzw(e3);
        } catch (RuntimeException e4) {
            if (e4.getCause() instanceof zzgzw) {
                throw ((zzgzw) e4.getCause());
            }
            throw e4;
        }
    }

    private int zzc(zzhbl<?> zzhblVar) {
        if (zzhblVar != null) {
            return zzhblVar.zza(this);
        }
        return zzhbc.zza().zzb(getClass()).zza(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <MessageType extends zzgzd<MessageType, BuilderType>, BuilderType, T> zzgzf<MessageType, T> zzd(zzgyp<MessageType, T> zzgypVar) {
        return (zzgzf) zzgypVar;
    }

    private static <T extends zzgzh<T, ?>> T zzf(T t) throws zzgzw {
        if (t == null || t.zzbw()) {
            return t;
        }
        throw t.zzaP().zza();
    }

    private static <T extends zzgzh<T, ?>> T zzg(T t, InputStream inputStream, zzgyr zzgyrVar) throws zzgzw {
        try {
            int read = inputStream.read();
            if (read == -1) {
                return null;
            }
            zzgyf zzG = zzgyf.zzG(new zzgxg(inputStream, zzgyf.zzE(read, inputStream)), 4096);
            T t2 = (T) zzbz(t, zzG, zzgyrVar);
            zzG.zzy(0);
            return t2;
        } catch (zzgzw e) {
            if (e.zzb()) {
                throw new zzgzw(e);
            }
            throw e;
        } catch (IOException e2) {
            throw new zzgzw(e2);
        }
    }

    private static <T extends zzgzh<T, ?>> T zzh(T t, zzgxz zzgxzVar, zzgyr zzgyrVar) throws zzgzw {
        zzgyf zzl = zzgxzVar.zzl();
        T t2 = (T) zzbz(t, zzl, zzgyrVar);
        zzl.zzy(0);
        return t2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <T extends zzgzh<T, ?>> T zzi(T t, byte[] bArr, int i, int i2, zzgyr zzgyrVar) throws zzgzw {
        if (i2 == 0) {
            return t;
        }
        T t2 = (T) t.zzbj();
        try {
            zzhbl zzb2 = zzhbc.zza().zzb(t2.getClass());
            zzb2.zzi(t2, bArr, i, i + i2, new zzgxn(zzgyrVar));
            zzb2.zzf(t2);
            return t2;
        } catch (zzgzw e) {
            if (e.zzb()) {
                throw new zzgzw(e);
            }
            throw e;
        } catch (zzhbw e2) {
            throw e2.zza();
        } catch (IOException e3) {
            if (e3.getCause() instanceof zzgzw) {
                throw ((zzgzw) e3.getCause());
            }
            throw new zzgzw(e3);
        } catch (IndexOutOfBoundsException unused) {
            throw new zzgzw("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
    }

    private void zzj() {
        if (this.zzt == zzhby.zzc()) {
            this.zzt = zzhby.zzf();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T extends zzgzh<T, ?>> boolean zzk(T t, boolean z) {
        byte byteValue = ((Byte) t.zzdd(zzgzg.GET_MEMOIZED_IS_INITIALIZED, null, null)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        boolean zzl = zzhbc.zza().zzb(t.getClass()).zzl(t);
        if (z) {
            t.zzdd(zzgzg.SET_MEMOIZED_IS_INITIALIZED, true != zzl ? null : t, null);
        }
        return zzl;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return zzhbc.zza().zzb(getClass()).zzk(this, (zzgzh) obj);
    }

    public int hashCode() {
        if (zzcd()) {
            return zzaW();
        }
        if (zzcc()) {
            zzca(zzaW());
        }
        return zzaX();
    }

    public String toString() {
        return zzhau.zza(this, super.toString());
    }

    @Override // com.google.android.gms.internal.ads.zzgxi
    int zzaL() {
        return this.zzd & Integer.MAX_VALUE;
    }

    @Override // com.google.android.gms.internal.ads.zzgxi
    int zzaM(zzhbl zzhblVar) {
        if (!zzcd()) {
            if (zzaL() != Integer.MAX_VALUE) {
                return zzaL();
            }
            int zzc2 = zzc(zzhblVar);
            zzaS(zzc2);
            return zzc2;
        }
        int zzc3 = zzc(zzhblVar);
        if (zzc3 >= 0) {
            return zzc3;
        }
        throw new IllegalStateException("serialized size must be non-negative, was " + zzc3);
    }

    @Override // com.google.android.gms.internal.ads.zzgxi
    public zzhax zzaO() {
        throw new UnsupportedOperationException("Lite does not support the mutable API.");
    }

    @Override // com.google.android.gms.internal.ads.zzgxi
    void zzaS(int i) {
        if (i >= 0) {
            this.zzd = i | (this.zzd & Integer.MIN_VALUE);
        } else {
            throw new IllegalStateException("serialized size must be non-negative, was " + i);
        }
    }

    int zzaW() {
        return zzhbc.zza().zzb(getClass()).zzb(this);
    }

    int zzaX() {
        return this.zzq;
    }

    @Override // com.google.android.gms.internal.ads.zzhas
    public int zzaY() {
        return zzaM(null);
    }

    protected final <MessageType2 extends zzgzh<MessageType2, BuilderType2>, BuilderType2 extends zzgzb<MessageType2, BuilderType2>> BuilderType2 zzaZ() {
        return (BuilderType2) zzdd(zzgzg.NEW_BUILDER, null, null);
    }

    public final zzhba<MessageType> zzbN() {
        return (zzhba) zzdd(zzgzg.GET_PARSER, null, null);
    }

    Object zzbO() throws Exception {
        return zzdd(zzgzg.BUILD_MESSAGE_INFO, null, null);
    }

    void zzbS() {
        this.zzq = 0;
    }

    void zzbT() {
        zzaS(Integer.MAX_VALUE);
    }

    protected void zzbU() {
        zzhbc.zza().zzb(getClass()).zzf(this);
        zzbV();
    }

    void zzbV() {
        this.zzd &= Integer.MAX_VALUE;
    }

    protected void zzbW(int i, zzgxz zzgxzVar) {
        zzj();
        zzhby zzhbyVar = this.zzt;
        zzhbyVar.zzg();
        if (i == 0) {
            throw new IllegalArgumentException("Zero is not a valid field number.");
        }
        zzhbyVar.zzj((i << 3) | 2, zzgxzVar);
    }

    protected final void zzbX(zzhby zzhbyVar) {
        this.zzt = zzhby.zze(this.zzt, zzhbyVar);
    }

    protected void zzbY(int i, int i2) {
        zzj();
        zzhby zzhbyVar = this.zzt;
        zzhbyVar.zzg();
        if (i == 0) {
            throw new IllegalArgumentException("Zero is not a valid field number.");
        }
        zzhbyVar.zzj(i << 3, Long.valueOf(i2));
    }

    protected final <MessageType2 extends zzgzh<MessageType2, BuilderType2>, BuilderType2 extends zzgzb<MessageType2, BuilderType2>> BuilderType2 zzba(MessageType2 messagetype2) {
        BuilderType2 buildertype2 = (BuilderType2) zzaZ();
        buildertype2.zzbj(messagetype2);
        return buildertype2;
    }

    @Override // com.google.android.gms.internal.ads.zzhas
    /* renamed from: zzbb, reason: merged with bridge method [inline-methods] */
    public final BuilderType zzcY() {
        return (BuilderType) zzdd(zzgzg.NEW_BUILDER, null, null);
    }

    /* renamed from: zzbc, reason: merged with bridge method [inline-methods] */
    public final BuilderType zzbM() {
        BuilderType buildertype = (BuilderType) zzdd(zzgzg.NEW_BUILDER, null, null);
        buildertype.zzbj(this);
        return buildertype;
    }

    @Override // com.google.android.gms.internal.ads.zzhat
    /* renamed from: zzbi, reason: merged with bridge method [inline-methods] */
    public final MessageType zzbt() {
        return (MessageType) zzdd(zzgzg.GET_DEFAULT_INSTANCE, null, null);
    }

    MessageType zzbj() {
        return (MessageType) zzdd(zzgzg.NEW_MUTABLE_INSTANCE, null, null);
    }

    @Override // com.google.android.gms.internal.ads.zzhat
    public final boolean zzbw() {
        return zzk(this, true);
    }

    @Override // com.google.android.gms.internal.ads.zzhas
    public void zzcZ(zzgym zzgymVar) throws IOException {
        zzhbc.zza().zzb(getClass()).zzj(this, zzgyn.zza(zzgymVar));
    }

    void zzca(int i) {
        this.zzq = i;
    }

    boolean zzcc() {
        return zzaX() == 0;
    }

    boolean zzcd() {
        return (this.zzd & Integer.MIN_VALUE) != 0;
    }

    protected boolean zzce(int i, zzgyf zzgyfVar) throws IOException {
        if ((i & 7) == 4) {
            return false;
        }
        zzj();
        return this.zzt.zzm(i, zzgyfVar);
    }

    protected abstract Object zzdd(zzgzg zzgzgVar, Object obj, Object obj2);
}
