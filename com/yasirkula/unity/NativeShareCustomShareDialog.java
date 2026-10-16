package com.yasirkula.unity;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.ComponentName;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes7.dex */
public class NativeShareCustomShareDialog extends DialogFragment {
    private boolean sentShareResult;

    private static class CustomShareDialogAdapter extends ArrayAdapter<ResolveInfo> {
        private PackageManager packageManager;
        private Activity unityActivity;

        private static class ViewHolder {
            private final ImageView icon;
            private final TextView label;

            public ViewHolder(TextView textView, ImageView imageView) {
                this.label = textView;
                this.icon = imageView;
            }
        }

        private CustomShareDialogAdapter(Activity activity, List<ResolveInfo> list) {
            super(activity, com.yasirkula.nativeshare.R.layout.native_share_grid_element, list);
            this.unityActivity = activity;
            this.packageManager = activity.getPackageManager();
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = this.unityActivity.getLayoutInflater().inflate(com.yasirkula.nativeshare.R.layout.native_share_grid_element, viewGroup, false);
                view.setTag(new ViewHolder((TextView) view.findViewById(com.yasirkula.nativeshare.R.id.native_share_app_name), (ImageView) view.findViewById(com.yasirkula.nativeshare.R.id.native_share_app_icon)));
            }
            ResolveInfo item = getItem(i);
            ViewHolder viewHolder = (ViewHolder) view.getTag();
            viewHolder.label.setText(item.loadLabel(this.packageManager));
            viewHolder.icon.setImageDrawable(item.loadIcon(this.packageManager));
            return view;
        }
    }

    @Override // android.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        if (getArguments() == null) {
            return new AlertDialog.Builder(getActivity()).setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() { // from class: com.yasirkula.unity.NativeShareCustomShareDialog.1
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    NativeShareCustomShareDialog.this.dismissAllowingStateLoss();
                }
            }).setMessage("Unknown error occurred, please try again.").create();
        }
        ArrayList arrayList = new ArrayList();
        final Intent CreateIntentFromBundle = NativeShare.CreateIntentFromBundle(getActivity(), getArguments(), arrayList);
        String string = getArguments().getString(NativeShareFragment.TITLE_ID);
        ArrayList<String> stringArrayList = getArguments().getStringArrayList(NativeShareFragment.TARGET_PACKAGE_ID);
        ArrayList<String> stringArrayList2 = getArguments().getStringArrayList(NativeShareFragment.TARGET_CLASS_ID);
        PackageManager packageManager = getActivity().getPackageManager();
        List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(CreateIntentFromBundle, 65536);
        for (int size = queryIntentActivities.size() - 1; size >= 0; size--) {
            if (!queryIntentActivities.get(size).activityInfo.exported) {
                queryIntentActivities.remove(size);
            }
        }
        if (arrayList.size() > 0) {
            NativeShare.GrantURIPermissionsToShareIntentTargets(getActivity(), queryIntentActivities, arrayList);
        }
        if (stringArrayList.size() > 1) {
            for (int size2 = queryIntentActivities.size() - 1; size2 >= 0; size2--) {
                ActivityInfo activityInfo = queryIntentActivities.get(size2).activityInfo;
                String str = activityInfo.applicationInfo.packageName;
                String str2 = activityInfo.name;
                int size3 = stringArrayList.size() - 1;
                while (true) {
                    if (size3 >= 0) {
                        if (!str.equals(stringArrayList.get(size3)) || (stringArrayList2.get(size3).length() != 0 && !str2.equals(stringArrayList2.get(size3)))) {
                            size3--;
                        }
                    } else {
                        queryIntentActivities.remove(size2);
                        break;
                    }
                }
            }
        }
        if (queryIntentActivities.size() == 0) {
            return new AlertDialog.Builder(getActivity()).setTitle(string).setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() { // from class: com.yasirkula.unity.NativeShareCustomShareDialog.2
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    NativeShareCustomShareDialog.this.dismissAllowingStateLoss();
                }
            }).setMessage("No apps can perform this action.").create();
        }
        if (queryIntentActivities.size() == 1) {
            StartTargetActivity(CreateIntentFromBundle, queryIntentActivities.get(0).activityInfo);
            dismissAllowingStateLoss();
        } else {
            Collections.sort(queryIntentActivities, new ResolveInfo.DisplayNameComparator(packageManager));
        }
        final CustomShareDialogAdapter customShareDialogAdapter = new CustomShareDialogAdapter(getActivity(), queryIntentActivities);
        View inflate = getActivity().getLayoutInflater().inflate(com.yasirkula.nativeshare.R.layout.native_share_grid_view, (ViewGroup) null);
        GridView gridView = (GridView) inflate.findViewById(com.yasirkula.nativeshare.R.id.native_share_grid_view_holder);
        gridView.setAdapter((ListAdapter) customShareDialogAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.yasirkula.unity.NativeShareCustomShareDialog.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                NativeShareCustomShareDialog.this.StartTargetActivity(CreateIntentFromBundle, customShareDialogAdapter.getItem(i).activityInfo);
                NativeShareCustomShareDialog.this.dismissAllowingStateLoss();
            }
        });
        return new AlertDialog.Builder(getActivity()).setTitle(string).setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() { // from class: com.yasirkula.unity.NativeShareCustomShareDialog.4
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                NativeShareCustomShareDialog.this.dismissAllowingStateLoss();
            }
        }).setView(inflate).create();
    }

    @Override // android.app.Fragment
    public void onPause() {
        super.onPause();
        dismissAllowingStateLoss();
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.sentShareResult) {
            return;
        }
        this.sentShareResult = true;
        if (NativeShare.shareResultReceiver != null) {
            NativeShare.shareResultReceiver.OnShareCompleted(2, "");
        }
    }

    @Override // android.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        Log.d("Unity", "Dismissed custom share dialog");
        if (!this.sentShareResult) {
            this.sentShareResult = true;
            if (NativeShare.shareResultReceiver != null) {
                NativeShare.shareResultReceiver.OnShareCompleted(2, "");
            }
        }
        Activity activity = getActivity();
        if (activity == null || !(activity instanceof NativeShareCustomShareDialogActivity)) {
            return;
        }
        activity.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void StartTargetActivity(Intent intent, ActivityInfo activityInfo) {
        ComponentName componentName = new ComponentName(activityInfo.applicationInfo.packageName, activityInfo.name);
        String flattenToString = componentName.flattenToString();
        Log.d("Unity", "Shared on app: " + flattenToString);
        if (NativeShare.shareResultReceiver != null) {
            NativeShare.shareResultReceiver.OnShareCompleted(1, flattenToString);
        }
        this.sentShareResult = true;
        intent.setFlags(268435456);
        intent.setComponent(componentName);
        try {
            startActivity(intent);
        } catch (Exception e) {
            Log.e("Unity", "Exception:", e);
            if (NativeShare.shareResultReceiver != null) {
                NativeShare.shareResultReceiver.OnShareCompleted(2, "");
            }
        }
        this.sentShareResult = true;
    }
}
