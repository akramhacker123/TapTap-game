package wsdfhjxc.taponium.scenes;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.view.MotionEvent;


import wsdfhjxc.taponium.engine.Flex;
import wsdfhjxc.taponium.engine.FlexConfig;
import wsdfhjxc.taponium.engine.ResourceKeeper;
import wsdfhjxc.taponium.engine.Scene;
import wsdfhjxc.taponium.engine.SceneKeeper;

public class about extends Scene {
    private Bitmap ksrmceBitmap;
    private Rect ksrmceRect;
    private Flex ksrmceFlex;


    public about(SceneKeeper sceneKeeper, ResourceKeeper resourceKeeper, FlexConfig flexConfig) {
        super(sceneKeeper, resourceKeeper, flexConfig, 5, 1);
    }
    @Override
    public void load(){
        ksrmceBitmap= resourceKeeper.getBitmap("ksrmcelogo");
        ksrmceRect = new Rect(0, 0, ksrmceBitmap.getWidth(), ksrmceBitmap.getHeight());
        ksrmceFlex = new Flex(new PointF(0.5f, 0.5f), false,
                              new PointF(ksrmceBitmap.getWidth(), ksrmceBitmap.getHeight()), true,
                              new Point(-ksrmceBitmap.getWidth() / 2, -ksrmceBitmap.getHeight() -1000), flexConfig);
        ksrmceFlex = new Flex(new PointF(0f, 0f), false,
                new PointF(1f, 1f), false,
                new Point(), flexConfig);


    }
    @Override
    public void unload() {}

    @Override
    public void backPressed() {
        sceneKeeper.removeScene(this);
        sceneKeeper.addScene(new MainMenuScene(sceneKeeper, resourceKeeper, flexConfig));
    }
    @Override
    public void handleInput(MotionEvent motionEvent) {

    }
    @Override
    public void handleUpdate ( double deltaTime){

    }

    @Override
    public void handleRender(Canvas canvas, Paint paint,double alpha){
        canvas.drawBitmap(ksrmceBitmap, ksrmceRect, ksrmceFlex.getRect(), paint);

    }
}