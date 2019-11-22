// Generated code from Butter Knife. Do not modify!
package com.imastudio.driverappojol.view.activity;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.imastudio.driverappojol.R;
import com.rengwuxian.materialedittext.MaterialEditText;
import java.lang.IllegalStateException;
import java.lang.Override;

public class AuthActivity$ViewHolderLogin_ViewBinding implements Unbinder {
  private AuthActivity.ViewHolderLogin target;

  @UiThread
  public AuthActivity$ViewHolderLogin_ViewBinding(AuthActivity.ViewHolderLogin target,
      View source) {
    this.target = target;

    target.edtEmail = Utils.findRequiredViewAsType(source, R.id.edtEmail, "field 'edtEmail'", MaterialEditText.class);
    target.edtPassword = Utils.findRequiredViewAsType(source, R.id.edtPassword, "field 'edtPassword'", MaterialEditText.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    AuthActivity.ViewHolderLogin target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.edtEmail = null;
    target.edtPassword = null;
  }
}
