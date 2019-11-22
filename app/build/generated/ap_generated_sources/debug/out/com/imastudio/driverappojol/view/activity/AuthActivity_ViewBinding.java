// Generated code from Butter Knife. Do not modify!
package com.imastudio.driverappojol.view.activity;

import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.imastudio.driverappojol.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class AuthActivity_ViewBinding implements Unbinder {
  private AuthActivity target;

  private View view7f08002e;

  private View view7f08002c;

  @UiThread
  public AuthActivity_ViewBinding(AuthActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public AuthActivity_ViewBinding(final AuthActivity target, View source) {
    this.target = target;

    View view;
    target.txtRiderApp = Utils.findRequiredViewAsType(source, R.id.txt_rider_app, "field 'txtRiderApp'", TextView.class);
    view = Utils.findRequiredView(source, R.id.btnSignIn, "field 'btnSignIn' and method 'onViewClicked'");
    target.btnSignIn = Utils.castView(view, R.id.btnSignIn, "field 'btnSignIn'", Button.class);
    view7f08002e = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btnRegister, "field 'btnRegister' and method 'onViewClicked'");
    target.btnRegister = Utils.castView(view, R.id.btnRegister, "field 'btnRegister'", Button.class);
    view7f08002c = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.rootlayout = Utils.findRequiredViewAsType(source, R.id.rootlayout, "field 'rootlayout'", RelativeLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    AuthActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.txtRiderApp = null;
    target.btnSignIn = null;
    target.btnRegister = null;
    target.rootlayout = null;

    view7f08002e.setOnClickListener(null);
    view7f08002e = null;
    view7f08002c.setOnClickListener(null);
    view7f08002c = null;
  }
}
