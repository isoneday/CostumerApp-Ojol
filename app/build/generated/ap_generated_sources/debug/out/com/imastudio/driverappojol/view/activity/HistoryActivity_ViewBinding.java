// Generated code from Butter Knife. Do not modify!
package com.imastudio.driverappojol.view.activity;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.viewpager.widget.ViewPager;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.google.android.material.tabs.TabLayout;
import com.imastudio.driverappojol.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class HistoryActivity_ViewBinding implements Unbinder {
  private HistoryActivity target;

  @UiThread
  public HistoryActivity_ViewBinding(HistoryActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public HistoryActivity_ViewBinding(HistoryActivity target, View source) {
    this.target = target;

    target.tablayout = Utils.findRequiredViewAsType(source, R.id.tablayout, "field 'tablayout'", TabLayout.class);
    target.pager = Utils.findRequiredViewAsType(source, R.id.pager, "field 'pager'", ViewPager.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    HistoryActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.tablayout = null;
    target.pager = null;
  }
}
