// Generated code from Butter Knife. Do not modify!
package com.imastudio.driverappojol.view.activity;

import android.view.View;
import android.widget.Button;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.imastudio.driverappojol.R;
import java.lang.IllegalStateException;
import java.lang.Override;
import pl.bclogic.pulsator4droid.library.PulsatorLayout;

public class WaitingDriverActivity_ViewBinding implements Unbinder {
  private WaitingDriverActivity target;

  private View view7f08002f;

  @UiThread
  public WaitingDriverActivity_ViewBinding(WaitingDriverActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public WaitingDriverActivity_ViewBinding(final WaitingDriverActivity target, View source) {
    this.target = target;

    View view;
    target.pulsator = Utils.findRequiredViewAsType(source, R.id.pulsator, "field 'pulsator'", PulsatorLayout.class);
    view = Utils.findRequiredView(source, R.id.buttoncancel, "field 'buttoncancel' and method 'onViewClicked'");
    target.buttoncancel = Utils.castView(view, R.id.buttoncancel, "field 'buttoncancel'", Button.class);
    view7f08002f = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    WaitingDriverActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.pulsator = null;
    target.buttoncancel = null;

    view7f08002f.setOnClickListener(null);
    view7f08002f = null;
  }
}
