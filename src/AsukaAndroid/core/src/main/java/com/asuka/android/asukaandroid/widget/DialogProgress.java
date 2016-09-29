package com.asuka.android.asukaandroid.widget;

import android.app.Dialog;
import android.content.Context;
import android.view.MotionEvent;

import com.asuka.android.asukaandroid.R;


/**
 * 
 * @author 高露
 * 进度条对话框 ：请稍后...
 */
public class DialogProgress {

	private static DialogProgress mDialogProgress = null;
	private progress pd = null;

	private DialogProgress() {
		
	}

	public static DialogProgress getInstance() {
		if (mDialogProgress == null) {
			mDialogProgress = new DialogProgress();
		}
		return mDialogProgress;
	}

	public void registDialogProgress(Context context) {
		if (context != null) {
			//if(JugementDialog()){
				unRegistDialogProgress();
			//	return;
			//}
			pd = progress.showDialog(context);
		}
	}

	public void unRegistDialogProgress() {
		if (pd != null && pd.isShowing()) {
			pd.dismiss();
			pd = null;
		}
	}

	public boolean JugementDialog() {
		if (pd != null && pd.isShowing()) {
			return true;
		}
		return false;
	}

	static class progress extends Dialog {

		public progress(Context context, int theme) {
			super(context, theme);
		}

		@Override
		public boolean onTouchEvent(MotionEvent event) {
			if (event.getAction() == MotionEvent.ACTION_DOWN) {
				return true;
			}
			return false;
		}
		public static progress showDialog(Context context) {
			
			progress dialog = new progress(context, R.style.activity_dialog);
			dialog.setContentView(R.layout.dialog_progressbar);
			dialog.show();
			// dialog.setCancelable(false);
			return dialog;
		}
	}

	public void setCancleable(boolean isCan) {
		if (pd != null) {
			pd.setCancelable(isCan);
		}
	}
}
