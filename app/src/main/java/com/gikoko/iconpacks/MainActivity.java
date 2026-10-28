package com.gikoko.iconpacks;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
  private final int gold = Color.rgb(255,190,35);
  @Override public void onCreate(Bundle state) {
    super.onCreate(state);
    getWindow().setStatusBarColor(Color.rgb(8,7,5)); getWindow().setNavigationBarColor(Color.BLACK);
    ScrollView scroll = new ScrollView(this);
    LinearLayout root = new LinearLayout(this); root.setOrientation(LinearLayout.VERTICAL); root.setPadding(24,28,24,28); root.setBackgroundColor(Color.rgb(10,9,7)); scroll.addView(root);
    TextView title = new TextView(this); title.setText("G.I KO KO\nROYAL GOLD ICONS"); title.setTextColor(gold); title.setTextSize(28); title.setTypeface(Typeface.DEFAULT,Typeface.BOLD); title.setGravity(Gravity.CENTER); root.addView(title);
    TextView subtitle = new TextView(this); subtitle.setText("BRIGHT 3D MYANMAR FLORAL FILIGREE"); subtitle.setTextColor(Color.WHITE); subtitle.setGravity(Gravity.CENTER); subtitle.setPadding(0,12,0,24); root.addView(subtitle);
    TextView status = new TextView(this); status.setText("One-tap apply for supported launchers"); status.setTextColor(Color.LTGRAY); status.setTextSize(15); status.setPadding(0,0,0,12); root.addView(status);
    Button apply = button("ONE-CLICK APPLY"); root.addView(apply); apply.setOnClickListener(v -> showLaunchers());
    String[] names={"Nova Launcher","ADW Launcher","Action Launcher","Apex Launcher"};
    String[] packages={"com.teslacoilsw.launcher","org.adw.launcher","com.actionlauncher.playstore","com.anddoes.launcher"};
    for(int i=0;i<names.length;i++){ final String name=names[i], pkg=packages[i]; Button b=button("APPLY WITH  "+name.toUpperCase()); root.addView(b); b.setOnClickListener(v -> launchTheme(name,pkg)); }
    TextView note = new TextView(this); note.setText("IMPORTANT\nAndroid does not allow a normal app to replace every icon system-wide. Supported launchers apply this icon pack in one action. MIUI stock launcher may not support third-party icon packs; use a compatible launcher if needed."); note.setTextColor(Color.rgb(235,205,140)); note.setTextSize(13); note.setPadding(0,24,0,12); root.addView(note);
    TextView footer = new TextView(this); footer.setText("Powered By I KO KO"); footer.setTextColor(gold); footer.setGravity(Gravity.CENTER); footer.setPadding(0,20,0,8); root.addView(footer);
    setContentView(scroll);
  }
  private Button button(String text){ Button b=new Button(this); b.setText(text); b.setTextColor(Color.BLACK); b.setAllCaps(false); b.setTextSize(14); b.setBackgroundTintList(android.content.res.ColorStateList.valueOf(gold)); LinearLayout.LayoutParams p=new LinearLayout.LayoutParams(-1,-2); p.setMargins(0,7,0,7); b.setLayoutParams(p); return b; }
  private void showLaunchers(){
    String[][] targets={{"Nova Launcher","com.teslacoilsw.launcher","com.novalauncher.THEME"},{"ADW Launcher","org.adw.launcher","org.adw.launcher.THEMES"},{"Apex Launcher","com.anddoes.launcher","com.anddoes.launcher.THEME"},{"Action Launcher","com.actionlauncher.playstore","com.actionlauncher.THEME"}};
    for(String[] t:targets){
      try { Intent i=new Intent(t[2]); i.setPackage(t[1]); i.addCategory(Intent.CATEGORY_DEFAULT); if(i.resolveActivity(getPackageManager())!=null){startActivity(i);return;} } catch(Exception ignored){}
    }
    Toast.makeText(this,"No supported launcher theme picker was found. Install a compatible launcher, then select G.I KO KO Gold Icons in its Icon/Theme settings. MIUI stock launcher may not support icon packs.",Toast.LENGTH_LONG).show();
  }
  private void launchTheme(String name,String pkg){
    String action="com.novalauncher.THEME";
    if(pkg.equals("org.adw.launcher")) action="org.adw.launcher.THEMES";
    else if(pkg.equals("com.anddoes.launcher")) action="com.anddoes.launcher.THEME";
    else if(pkg.equals("com.actionlauncher.playstore")) action="com.actionlauncher.THEME";
    try { Intent i = new Intent(action); i.setPackage(pkg); i.addCategory(Intent.CATEGORY_DEFAULT); if(i.resolveActivity(getPackageManager())!=null){startActivity(i);return;} }
    catch(Exception ignored){}
    try { Intent i = getPackageManager().getLaunchIntentForPackage(pkg); if(i!=null){startActivity(i);Toast.makeText(this,"Open the launcher's icon/theme settings and select G.I KO KO Gold Icons.",Toast.LENGTH_LONG).show();return;} }
    catch(Exception ignored){}
    Toast.makeText(this,name+" is not installed or does not expose a theme picker. Install a compatible launcher first.",Toast.LENGTH_LONG).show();
  }
}
