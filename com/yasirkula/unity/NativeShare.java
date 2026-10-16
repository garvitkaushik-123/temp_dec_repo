package com.yasirkula.unity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.webkit.MimeTypeMap;
import androidx.webkit.internal.AssetHelper;
import com.adjust.sdk.Constants;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;

/* loaded from: classes7.dex */
public class NativeShare {
    public static boolean alwaysUseCustomShareDialog = false;
    public static String authority;
    private static int isXiaomiOrMIUI;
    public static NativeShareResultReceiver shareResultReceiver;

    public static void Share(Context context, NativeShareResultReceiver nativeShareResultReceiver, String[] strArr, String[] strArr2, String[] strArr3, String[] strArr4, String[] strArr5, String str, String str2, String str3) {
        if (strArr3.length > 0 && GetAuthority(context) == null) {
            Log.e("Unity", "Can't find ContentProvider, share not possible!");
            nativeShareResultReceiver.OnShareCompleted(2, "");
            return;
        }
        shareResultReceiver = nativeShareResultReceiver;
        Bundle bundle = new Bundle();
        bundle.putString(NativeShareFragment.SUBJECT_ID, str);
        bundle.putString(NativeShareFragment.TEXT_ID, str2);
        bundle.putString(NativeShareFragment.TITLE_ID, str3);
        bundle.putStringArrayList(NativeShareFragment.FILES_ID, ConvertArrayToArrayList(strArr3));
        bundle.putStringArrayList(NativeShareFragment.MIMES_ID, ConvertArrayToArrayList(strArr4));
        bundle.putStringArrayList(NativeShareFragment.EMAIL_RECIPIENTS_ID, ConvertArrayToArrayList(strArr5));
        bundle.putStringArrayList(NativeShareFragment.TARGET_PACKAGE_ID, ConvertArrayToArrayList(strArr));
        bundle.putStringArrayList(NativeShareFragment.TARGET_CLASS_ID, ConvertArrayToArrayList(strArr2));
        boolean z = true;
        boolean z2 = alwaysUseCustomShareDialog || strArr.length > 1;
        if (!z2 && nativeShareResultReceiver.HasManagedCallback() && "huawei".equalsIgnoreCase(Build.MANUFACTURER)) {
            z2 = true;
        }
        if (z2 || !IsXiaomiOrMIUI() || (Build.VERSION.SDK_INT != 30 && !IsUnityInLandscapeMode((Activity) context))) {
            z = z2;
        }
        if (z) {
            Log.d("Unity", "Creating custom share dialog");
            Intent intent = new Intent(context, (Class<?>) NativeShareCustomShareDialogActivity.class);
            intent.putExtras(bundle);
            intent.setFlags(1073741824);
            context.startActivity(intent);
            return;
        }
        Log.d("Unity", "Creating standard share dialog");
        NativeShareFragment nativeShareFragment = new NativeShareFragment();
        nativeShareFragment.setArguments(bundle);
        ((Activity) context).getFragmentManager().beginTransaction().add(0, nativeShareFragment).commitAllowingStateLoss();
    }

    public static Intent CreateIntentFromBundle(Context context, Bundle bundle, ArrayList<Uri> arrayList) {
        String str;
        int i;
        String mimeTypeFromExtension;
        int indexOf;
        String string = bundle.getString(NativeShareFragment.SUBJECT_ID);
        String string2 = bundle.getString(NativeShareFragment.TEXT_ID);
        String string3 = bundle.getString(NativeShareFragment.TITLE_ID);
        ArrayList<String> stringArrayList = bundle.getStringArrayList(NativeShareFragment.FILES_ID);
        ArrayList<String> stringArrayList2 = bundle.getStringArrayList(NativeShareFragment.MIMES_ID);
        ArrayList<String> stringArrayList3 = bundle.getStringArrayList(NativeShareFragment.EMAIL_RECIPIENTS_ID);
        ArrayList<String> stringArrayList4 = bundle.getStringArrayList(NativeShareFragment.TARGET_PACKAGE_ID);
        ArrayList<String> stringArrayList5 = bundle.getStringArrayList(NativeShareFragment.TARGET_CLASS_ID);
        Intent intent = new Intent();
        if (string.length() > 0) {
            intent.putExtra("android.intent.extra.SUBJECT", string);
        }
        if (string2.length() > 0) {
            intent.putExtra("android.intent.extra.TEXT", string2);
        }
        if (stringArrayList.size() > 0) {
            String str2 = null;
            String str3 = null;
            int i2 = 0;
            while (i2 < stringArrayList.size()) {
                if (stringArrayList2.get(i2).length() > 0) {
                    mimeTypeFromExtension = stringArrayList2.get(i2);
                    i = 1;
                } else {
                    i = 1;
                    int lastIndexOf = stringArrayList.get(i2).lastIndexOf(46);
                    if (lastIndexOf >= 0 && lastIndexOf != stringArrayList.get(i2).length() - 1) {
                        mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(stringArrayList.get(i2).substring(lastIndexOf + 1).toLowerCase(Locale.ENGLISH));
                    }
                    str2 = "*";
                    str3 = str2;
                    break;
                }
                if (mimeTypeFromExtension != null && mimeTypeFromExtension.length() != 0 && (indexOf = mimeTypeFromExtension.indexOf(47)) > 0 && indexOf != mimeTypeFromExtension.length() - 1) {
                    ArrayList<String> arrayList2 = stringArrayList2;
                    String substring = mimeTypeFromExtension.substring(0, indexOf);
                    String substring2 = mimeTypeFromExtension.substring(indexOf + 1);
                    if (str2 == null) {
                        str2 = substring;
                    } else if (!str2.equals(substring)) {
                    }
                    if (str3 == null) {
                        str3 = substring2;
                    } else if (!str3.equals(substring2)) {
                        str3 = "*";
                    }
                    i2++;
                    stringArrayList2 = arrayList2;
                }
                str2 = "*";
                str3 = str2;
            }
            i = 1;
            str = str2 + RemoteSettings.FORWARD_SLASH_STRING + str3;
            if (stringArrayList.size() == i) {
                intent.setAction("android.intent.action.SEND");
                Uri uriForFile = NativeShareContentProvider.getUriForFile(context, authority, new File(stringArrayList.get(0)));
                arrayList.add(uriForFile);
                intent.putExtra("android.intent.extra.STREAM", uriForFile);
            } else {
                intent.setAction("android.intent.action.SEND_MULTIPLE");
                for (int i3 = 0; i3 < stringArrayList.size(); i3++) {
                    arrayList.add(NativeShareContentProvider.getUriForFile(context, authority, new File(stringArrayList.get(i3))));
                }
                intent.putParcelableArrayListExtra("android.intent.extra.STREAM", arrayList);
            }
        } else {
            intent.setAction("android.intent.action.SEND");
            str = AssetHelper.DEFAULT_MIME_TYPE;
        }
        if (stringArrayList3.size() > 0) {
            String[] strArr = new String[stringArrayList3.size()];
            stringArrayList3.toArray(strArr);
            intent.putExtra("android.intent.extra.EMAIL", strArr);
        }
        if (string3.length() > 0) {
            intent.putExtra("android.intent.extra.TITLE", string3);
        }
        intent.setType(str);
        intent.setFlags(1);
        if (stringArrayList4.size() == 1) {
            intent.setPackage(stringArrayList4.get(0));
            if (stringArrayList5.get(0).length() > 0) {
                intent.setClassName(stringArrayList4.get(0), stringArrayList5.get(0));
            }
        }
        return intent;
    }

    public static void GrantURIPermissionsToShareIntentTargets(Context context, List<ResolveInfo> list, ArrayList<Uri> arrayList) {
        try {
            for (int size = list.size() - 1; size >= 0; size--) {
                for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
                    context.grantUriPermission(list.get(size).activityInfo.packageName, arrayList.get(size2), 1);
                }
            }
        } catch (Exception e) {
            Log.e("Unity", "NativeShare couldn't call grantUriPermission:", e);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x004a, code lost:
    
        com.yasirkula.unity.NativeShare.authority = r3.authority;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static String GetAuthority(Context context) {
        if (authority == null) {
            try {
                ProviderInfo[] providerInfoArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 8).providers;
                if (providerInfoArr != null) {
                    int length = providerInfoArr.length;
                    int i = 0;
                    while (true) {
                        if (i >= length) {
                            break;
                        }
                        ProviderInfo providerInfo = providerInfoArr[i];
                        if (providerInfo.name != null && providerInfo.packageName != null && providerInfo.authority != null && providerInfo.name.equals(NativeShareContentProvider.class.getName()) && providerInfo.packageName.equals(context.getPackageName()) && providerInfo.authority.length() > 0) {
                            break;
                        }
                        i++;
                    }
                }
            } catch (Exception e) {
                Log.e("Unity", "Exception:", e);
            }
        }
        return authority;
    }

    private static ArrayList<String> ConvertArrayToArrayList(String[] strArr) {
        ArrayList<String> arrayList = new ArrayList<>(strArr.length);
        for (String str : strArr) {
            arrayList.add(str);
        }
        return arrayList;
    }

    private static boolean IsUnityInLandscapeMode(Activity activity) {
        return activity.getResources().getConfiguration().orientation == 2;
    }

    private static boolean IsXiaomiOrMIUI() {
        BufferedReader bufferedReader;
        int i = isXiaomiOrMIUI;
        if (i > 0) {
            return true;
        }
        if (i < 0) {
            return false;
        }
        if (Constants.REFERRER_API_XIAOMI.equalsIgnoreCase(Build.MANUFACTURER)) {
            isXiaomiOrMIUI = 1;
            return true;
        }
        BufferedReader bufferedReader2 = null;
        try {
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop ro.miui.ui.version.name").getInputStream()), 1024);
            } catch (Throwable th) {
                th = th;
            }
        } catch (Exception unused) {
        }
        try {
            String readLine = bufferedReader.readLine();
            if (readLine != null && readLine.length() > 0) {
                isXiaomiOrMIUI = 1;
                try {
                    bufferedReader.close();
                } catch (Exception unused2) {
                }
                return true;
            }
            isXiaomiOrMIUI = -1;
            try {
                bufferedReader.close();
            } catch (Exception unused3) {
            }
            return false;
        } catch (Exception unused4) {
            bufferedReader2 = bufferedReader;
            isXiaomiOrMIUI = -1;
            if (bufferedReader2 != null) {
                try {
                    bufferedReader2.close();
                } catch (Exception unused5) {
                }
            }
            return false;
        } catch (Throwable th2) {
            th = th2;
            bufferedReader2 = bufferedReader;
            if (bufferedReader2 != null) {
                try {
                    bufferedReader2.close();
                } catch (Exception unused6) {
                }
            }
            throw th;
        }
    }

    public static boolean TargetExists(Context context, String str, String str2) {
        if (str2.length() == 0) {
            context.getPackageManager().getPackageInfo(str, 0);
            return true;
        }
        ActivityInfo[] activityInfoArr = context.getPackageManager().getPackageInfo(str, 1).activities;
        if (activityInfoArr != null) {
            for (ActivityInfo activityInfo : activityInfoArr) {
                if (activityInfo.name.equals(str2)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static String FindMatchingTarget(Context context, String str, String str2) {
        ActivityInfo[] activityInfoArr;
        List<PackageInfo> installedPackages = context.getPackageManager().getInstalledPackages(1);
        if (installedPackages != null) {
            Pattern compile = Pattern.compile(str);
            Pattern compile2 = str2.length() > 0 ? Pattern.compile(str2) : null;
            for (PackageInfo packageInfo : installedPackages) {
                if (compile.matcher(packageInfo.packageName).find() && (activityInfoArr = packageInfo.activities) != null) {
                    for (ActivityInfo activityInfo : activityInfoArr) {
                        if (compile2 == null || compile2.matcher(activityInfo.name).find()) {
                            return packageInfo.packageName + ">" + activityInfo.name;
                        }
                    }
                }
            }
            return "";
        }
        return "";
    }
}
