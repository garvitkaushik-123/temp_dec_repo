package com.google.android.gms.internal.ads;

import adn.analytics.AdInfoKtKt;
import com.google.android.gms.internal.ads.zzgxh;
import com.google.android.gms.internal.ads.zzgxi;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-ads-api@@24.5.0 */
/* loaded from: classes5.dex */
public abstract class zzgxh<MessageType extends zzgxi<MessageType, BuilderType>, BuilderType extends zzgxh<MessageType, BuilderType>> implements zzhar {
    private String zza(String str) {
        return "Reading " + getClass().getName() + " from a " + str + " threw an IOException (should never happen).";
    }

    private static <T> void zzb(Iterable<T> iterable, List<? super T> list) {
        if (iterable instanceof Collection) {
            int size = ((Collection) iterable).size();
            if (list instanceof ArrayList) {
                ((ArrayList) list).ensureCapacity(list.size() + size);
            } else if (list instanceof zzhbd) {
                ((zzhbd) list).zze(list.size() + size);
            }
        }
        int size2 = list.size();
        if (!(iterable instanceof List) || !(iterable instanceof RandomAccess)) {
            for (Object obj : iterable) {
                if (obj == null) {
                    zzc(list, size2);
                }
                list.add(obj);
            }
            return;
        }
        List list2 = (List) iterable;
        int size3 = list2.size();
        for (int i = 0; i < size3; i++) {
            AdInfoKtKt adInfoKtKt = (Object) list2.get(i);
            if (adInfoKtKt == null) {
                zzc(list, size2);
            }
            list.add(adInfoKtKt);
        }
    }

    protected static zzhbw zzbb(zzhas zzhasVar) {
        return new zzhbw(zzhasVar);
    }

    @Deprecated
    protected static <T> void zzbc(Iterable<T> iterable, Collection<? super T> collection) {
        zzbd(iterable, (List) collection);
    }

    protected static <T> void zzbd(Iterable<T> iterable, List<? super T> list) {
        byte[] bArr = zzgzu.zzb;
        iterable.getClass();
        if (!(iterable instanceof zzhae)) {
            if (iterable instanceof zzhbb) {
                list.addAll((Collection) iterable);
                return;
            } else {
                zzb(iterable, list);
                return;
            }
        }
        List zza = ((zzhae) iterable).zza();
        zzhae zzhaeVar = (zzhae) list;
        int size = list.size();
        for (Object obj : zza) {
            if (obj == null) {
                String str = "Element at index " + (zzhaeVar.size() - size) + " is null.";
                int size2 = zzhaeVar.size();
                while (true) {
                    size2--;
                    if (size2 < size) {
                        throw new NullPointerException(str);
                    }
                    zzhaeVar.remove(size2);
                }
            } else if (obj instanceof zzgxz) {
                zzhaeVar.zzb();
            } else if (obj instanceof byte[]) {
                byte[] bArr2 = (byte[]) obj;
                zzgxz.zzv(bArr2, 0, bArr2.length);
                zzhaeVar.zzb();
            } else {
                zzhaeVar.add((String) obj);
            }
        }
    }

    private static void zzc(List<?> list, int i) {
        String str = "Element at index " + (list.size() - i) + " is null.";
        int size = list.size();
        while (true) {
            size--;
            if (size < i) {
                throw new NullPointerException(str);
            }
            list.remove(size);
        }
    }

    @Override // 
    /* renamed from: zzaC, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public abstract BuilderType zzaP();

    protected abstract BuilderType zzaD(MessageType messagetype);

    public BuilderType zzaE(zzgxz zzgxzVar) throws zzgzw {
        try {
            zzgyf zzl = zzgxzVar.zzl();
            zzaR(zzl);
            zzl.zzy(0);
            return this;
        } catch (zzgzw e) {
            throw e;
        } catch (IOException e2) {
            throw new RuntimeException(zza("ByteString"), e2);
        }
    }

    /* renamed from: zzaF, reason: merged with bridge method [inline-methods] */
    public BuilderType zzaR(zzgyf zzgyfVar) throws IOException {
        int i = zzgyr.zzb;
        int i2 = zzhbc.zza;
        return zzaW(zzgyfVar, zzgyr.zza);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: zzaG, reason: merged with bridge method [inline-methods] */
    public BuilderType zzaS(zzhas zzhasVar) {
        if (zzbt().getClass().isInstance(zzhasVar)) {
            return (BuilderType) zzaD((zzgxi) zzhasVar);
        }
        throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
    }

    public BuilderType zzaH(InputStream inputStream) throws IOException {
        zzgyf zzG = zzgyf.zzG(inputStream, 4096);
        zzaR(zzG);
        zzG.zzy(0);
        return this;
    }

    /* renamed from: zzaI, reason: merged with bridge method [inline-methods] */
    public BuilderType zzaU(byte[] bArr) throws zzgzw {
        return zzaZ(bArr, 0, bArr.length);
    }

    public BuilderType zzaJ(zzgxz zzgxzVar, zzgyr zzgyrVar) throws zzgzw {
        try {
            zzgyf zzl = zzgxzVar.zzl();
            zzaW(zzl, zzgyrVar);
            zzl.zzy(0);
            return this;
        } catch (zzgzw e) {
            throw e;
        } catch (IOException e2) {
            throw new RuntimeException(zza("ByteString"), e2);
        }
    }

    @Override // 
    /* renamed from: zzaK, reason: merged with bridge method [inline-methods] */
    public abstract BuilderType zzaW(zzgyf zzgyfVar, zzgyr zzgyrVar) throws IOException;

    public BuilderType zzaL(InputStream inputStream, zzgyr zzgyrVar) throws IOException {
        zzgyf zzG = zzgyf.zzG(inputStream, 4096);
        zzaW(zzG, zzgyrVar);
        zzG.zzy(0);
        return this;
    }

    /* renamed from: zzaM, reason: merged with bridge method [inline-methods] */
    public BuilderType zzaY(byte[] bArr, zzgyr zzgyrVar) throws zzgzw {
        return zzba(bArr, 0, bArr.length, zzgyrVar);
    }

    @Override // 
    /* renamed from: zzaN, reason: merged with bridge method [inline-methods] */
    public BuilderType zzaZ(byte[] bArr, int i, int i2) throws zzgzw {
        try {
            zzgyf zzH = zzgyf.zzH(bArr, i, i2, false);
            zzaR(zzH);
            zzH.zzy(0);
            return this;
        } catch (zzgzw e) {
            throw e;
        } catch (IOException e2) {
            throw new RuntimeException(zza("byte array"), e2);
        }
    }

    @Override // 
    /* renamed from: zzaO, reason: merged with bridge method [inline-methods] */
    public BuilderType zzba(byte[] bArr, int i, int i2, zzgyr zzgyrVar) throws zzgzw {
        try {
            zzgyf zzH = zzgyf.zzH(bArr, i, i2, false);
            zzaW(zzH, zzgyrVar);
            zzH.zzy(0);
            return this;
        } catch (zzgzw e) {
            throw e;
        } catch (IOException e2) {
            throw new RuntimeException(zza("byte array"), e2);
        }
    }

    public /* bridge */ /* synthetic */ zzhar zzaQ(zzgxz zzgxzVar) throws zzgzw {
        zzaE(zzgxzVar);
        return this;
    }

    public /* bridge */ /* synthetic */ zzhar zzaT(InputStream inputStream) throws IOException {
        zzaH(inputStream);
        return this;
    }

    public /* bridge */ /* synthetic */ zzhar zzaV(zzgxz zzgxzVar, zzgyr zzgyrVar) throws zzgzw {
        zzaJ(zzgxzVar, zzgyrVar);
        return this;
    }

    public /* bridge */ /* synthetic */ zzhar zzaX(InputStream inputStream, zzgyr zzgyrVar) throws IOException {
        zzaL(inputStream, zzgyrVar);
        return this;
    }

    public boolean zzbe(InputStream inputStream) throws IOException {
        int i = zzgyr.zzb;
        int i2 = zzhbc.zza;
        return zzbf(inputStream, zzgyr.zza);
    }

    public boolean zzbf(InputStream inputStream, zzgyr zzgyrVar) throws IOException {
        int read = inputStream.read();
        if (read == -1) {
            return false;
        }
        zzaL(new zzgxg(inputStream, zzgyf.zzE(read, inputStream)), zzgyrVar);
        return true;
    }
}
