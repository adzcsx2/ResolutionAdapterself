# ResolutionAdapterself

基于720P(720*1280)自行适配的BaseActivity(不包括ListView，和动态实现的控件。所有非控件需要自行优化适配
，所有View的宽高间距等用PX为单位 。
标准间距： 720P : 1dp = 2px;
TextView: android:textSize="28px" 
Button等自带padding控件,无法适配padding,需要在xml指明padding或width or height。