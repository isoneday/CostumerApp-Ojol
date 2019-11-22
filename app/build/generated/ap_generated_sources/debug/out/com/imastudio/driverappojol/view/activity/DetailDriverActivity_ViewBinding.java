// Generated code from Butter Knife. Do not modify!
package com.imastudio.driverappojol.view.activity;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.imastudio.driverappojol.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class DetailDriverActivity_ViewBinding implements Unbinder {
  private DetailDriverActivity target;

  @UiThread
  public DetailDriverActivity_ViewBinding(DetailDriverActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public DetailDriverActivity_ViewBinding(DetailDriverActivity target, View source) {
    this.target = target;

    target.lokasiawal = Utils.findRequiredViewAsType(source, R.id.lokasiawal, "field 'lokasiawal'", TextView.class);
    target.lokasitujuan = Utils.findRequiredViewAsType(source, R.id.lokasitujuan, "field 'lokasitujuan'", TextView.class);
    target.txtnamadriver = Utils.findRequiredViewAsType(source, R.id.txtnamadriver, "field 'txtnamadriver'", TextView.class);
    target.linear2 = Utils.findRequiredViewAsType(source, R.id.linear2, "field 'linear2'", LinearLayout.class);
    target.txthpdriver = Utils.findRequiredViewAsType(source, R.id.txthpdriver, "field 'txthpdriver'", TextView.class);
    target.linear1 = Utils.findRequiredViewAsType(source, R.id.linear1, "field 'linear1'", LinearLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    DetailDriverActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.lokasiawal = null;
    target.lokasitujuan = null;
    target.txtnamadriver = null;
    target.linear2 = null;
    target.txthpdriver = null;
    target.linear1 = null;
  }
}
