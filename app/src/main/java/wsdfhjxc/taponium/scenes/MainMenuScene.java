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

public class MainMenuScene extends Scene {
    private Bitmap titleTextBitmap;
    private Rect titleTextRect;
    private Flex titleTextFlex;

    private Bitmap highscoreBitmap;
    private Rect highscoreRect;
    private Flex highscoreFlex;

    private Flex HIGHSCOREFlex;

    private Bitmap menuPanelBitmap;
    private Rect menuPanelRect;
    private Flex menuPanelFlex;

    private Flex playButtonFlex;
    private Flex quitButtonFlex;

    public MainMenuScene(SceneKeeper sceneKeeper, ResourceKeeper resourceKeeper, FlexConfig flexConfig) {
        super(sceneKeeper, resourceKeeper, flexConfig, 1, 1);
    }

    @Override
    public void load() {
        titleTextBitmap = resourceKeeper.getBitmap("title_text");
        titleTextRect = new Rect(0, 0, titleTextBitmap.getWidth(), titleTextBitmap.getHeight());
        titleTextFlex = new Flex(new PointF(0.5f, 0.1f), false,
                                 new PointF(titleTextBitmap.getWidth(), titleTextBitmap.getHeight()), true,
                                 new Point(-titleTextBitmap.getWidth() / 2, 0), flexConfig);

        menuPanelBitmap = resourceKeeper.getBitmap("menu_panel");
        menuPanelRect = new Rect(0, 0, menuPanelBitmap.getWidth(), menuPanelBitmap.getHeight());
        menuPanelFlex = new Flex(new PointF(0.5f, 0.88f), false,
                                 new PointF(menuPanelBitmap.getWidth(), menuPanelBitmap.getHeight()), true,
                                 new Point(-menuPanelBitmap.getWidth() / 2, -menuPanelBitmap.getHeight()),
                                 flexConfig);

        playButtonFlex = new Flex(new PointF(0.5f, 1f), false,
                                  new PointF(840f, 330f), true,
                                  new Point(-840 / 2, -1300), flexConfig);

        quitButtonFlex = new Flex(new PointF(0.5f, 1f), false,
                                  new PointF(840f, 330f), true,
                                  new Point(-840 / 2, -800), flexConfig);

        highscoreBitmap = resourceKeeper.getBitmap("highscore");
        highscoreRect = new Rect(0, 0, highscoreBitmap.getWidth(), highscoreBitmap.getHeight());
        highscoreFlex = new Flex(new PointF(0.5f, 0.9f), false,
                                 new PointF(highscoreBitmap.getWidth(), highscoreBitmap.getHeight()), true,
                                 new Point(-highscoreBitmap.getWidth() / 2, -highscoreBitmap.getHeight()),
                                 flexConfig);

        HIGHSCOREFlex = new Flex(new PointF(0.5f, 1f), false,
                                 new PointF(324f, 156f), true,
                                 new Point(-324/2 , -360), flexConfig);
    }

    @Override
    public void unload() {}

    @Override
    public void backPressed() {
        sceneKeeper.removeAllScenes();
    }

    @Override
    public void handleInput(MotionEvent motionEvent) {
        if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
            if (playButtonFlex.getRect().contains((int) motionEvent.getX(),
                                                  (int) motionEvent.getY())) {
                sceneKeeper.removeScene(this);
                sceneKeeper.addScene(new GameScene(sceneKeeper, resourceKeeper, flexConfig));
            }
            else if (quitButtonFlex.getRect().contains((int) motionEvent.getX(),
                                                         (int) motionEvent.getY())) {
                sceneKeeper.removeAllScenes();
            }
            else if (HIGHSCOREFlex.getRect().contains((int) motionEvent.getX(),
                                                      (int) motionEvent.getY())) {
                sceneKeeper.removeScene(this);
                sceneKeeper.addScene(new about(sceneKeeper, resourceKeeper, flexConfig));


            }

        }
    }

    @Override
    public void handleUpdate ( double deltaTime){}

    @Override
    public void handleRender(Canvas canvas, Paint paint,double alpha){
        canvas.drawBitmap(titleTextBitmap, titleTextRect, titleTextFlex.getRect(), paint);
        canvas.drawBitmap(menuPanelBitmap, menuPanelRect, menuPanelFlex.getRect(), paint);
        canvas.drawBitmap(highscoreBitmap, highscoreRect, highscoreFlex.getRect(), paint);
    }
}