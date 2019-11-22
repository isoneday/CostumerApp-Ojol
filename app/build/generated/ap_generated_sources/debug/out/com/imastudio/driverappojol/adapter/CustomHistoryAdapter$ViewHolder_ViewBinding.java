// Generated code from Butter Knife. Do not modify!
package com.imastudio.driverappojol.adapter;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.imastudio.driverappojol.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class CustomHistoryAdapter$ViewHolder_ViewBinding implements Unbinder {
  private CustomHistoryAdapter.ViewHolder target;

  @UiThread
  public CustomHistoryAdapter$ViewHolder_ViewBinding(CustomHistoryAdapter.ViewHolder target,
      View source) {
    this.target = target;

    target.texttgl = Utils.findRequiredViewAsType(source, R.id.texttgl, "field 'texttgl'", TextView.class);
    target.txtawal = Utils.findRequiredViewAsType(source, R.id.txtawal, "field 'txtawal'", TextView.class);
    target.txtakhir = Utils.findRequiredViewAsType(source, R.id.txtakhir, "field 'txtakhir'", TextView.class);
    target.txtharga = Utils.findRequiredViewAsType(source, R.id.txtharga, "field 'txtharga'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    CustomHistoryAdapter.ViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.texttgl = null;
    target.txtawal = null;
    target.txtakhir = null;
    target.txtharga = null;
  }
}
