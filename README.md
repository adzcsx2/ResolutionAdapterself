# android 自动适配所有分辨率

基于720P(720*1280)自行适配的BaseActivity(ListView和自定义控件请参照DEMO)\<br>

目前支持：<br>
LinearLayout <br>
RelativeLayout<br>
FrameLayout<br>
支持的属性：<br>
Margin<br>
Padding<br>
TextSize<br>
Hheight<br>
Width<br>
所有View的宽高间距等用PX为单位 。<br>
标准间距： 720P : 1dp = 2px;<br>
TextView: android:textSize="28px"<br> 
Button等自带padding控件,无法自动适配padding,需要手动设置width和height来满足需求。<br>
####Eclipse中选择720*1280布局<br>
![](https://github.com/adzcsx2/android-autoAdapt/raw/master/11.png)
####效果如下：<br>
![](https://github.com/adzcsx2/android-autoAdapt/raw/master/22.png)

[我的博客](http://blog.csdn.net/adzcsx2)
