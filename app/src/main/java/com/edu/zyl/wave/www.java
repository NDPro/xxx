package com.edu.zyl.wave;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by ZHellPro on 2017/6/2.
 */

public class www extends View {

    //音频数量
    private int mRectCount=10;
    private Paint mRectPaint;
    private int topColor,downColor;
    private int mRectW,mRectH;
    private int offset=10;
    private  int mSpeed=3000;

    public www(Context context) {
        super(context);
    }

    public www(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public www(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
       mRectPaint = new Paint();
        mRectPaint.setColor(Color.BLACK);
      topColor = Color.BLUE;
        downColor=Color.GRAY;

    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        //渐变效果吗
        LinearGradient mLinerGradient;
        int mWidth;
        mWidth = getWidth();
        mRectH = getHeight();
        mRectW = (mWidth-offset)/mRectCount;
        mLinerGradient = new LinearGradient(0,0,mRectW,mRectH,topColor,downColor, Shader.TileMode.CLAMP);
        mRectPaint.setShader(mLinerGradient);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        double mRandom;
        float currentHeight;
        for (int i=0;i<mRectCount;i++){
            mRandom=Math.random();
            currentHeight = (float) (mRectH*mRandom);
            canvas.drawRect(mRectW*i,currentHeight,mRectW*(i+1),mRectH,mRectPaint);
        }
        postInvalidateDelayed(mSpeed);
    }
}
