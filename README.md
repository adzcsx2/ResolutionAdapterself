# android 自动适配所有分辨率

基于720P(720*1280)自行适配的BaseActivity(ListView和自定义控件请参照DEMO)

目前支持：
LinearLayout
RelativeLayout
FrameLayout
支持的属性：
Margin
Padding
Textsize
height
width

，所有View的宽高间距等用PX为单位 。
标准间距： 720P : 1dp = 2px;
TextView: android:textSize="28px" 
Button等自带padding控件,无法自动适配padding,需要手动设置width和height来满足需求。
