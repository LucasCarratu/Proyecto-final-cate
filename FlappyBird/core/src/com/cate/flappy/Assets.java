package com.cate.flappy;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Assets {

    public static BitmapFont font;
    private static final GlyphLayout glyphLayout = new GlyphLayout();  //ayuda a conocer el tamaño del texto para centrarlo

    public static Animation<TextureAtlas.AtlasRegion> bird; //importando los assets del atlas

    public static TextureRegion background;
    public static TextureRegion gameOver;
    public static TextureRegion getReady;
    public static TextureRegion tap;
    public static TextureRegion pipeDown;
    public static TextureRegion pipeUp;

    public static void load(){                  //cargar las imagenes
        TextureAtlas atlas = new TextureAtlas(Gdx.files.internal("data/atlasMap.txt"));

        background = atlas.findRegion("background");
        gameOver = atlas.findRegion("gameOver");
        getReady = atlas.findRegion("getReady");
        tap = atlas.findRegion("tap");
        pipeDown = atlas.findRegion("pipeDown");
        pipeUp = atlas.findRegion("pipeUp");

        bird = new Animation<TextureAtlas.AtlasRegion>(
                .3f,                          //especificamos la duracion de cada frame (.3 segundos)
                atlas.findRegion("bird1"),
                atlas.findRegion("bird2"),
                atlas.findRegion("bird3"));

        font = new BitmapFont();
        font.getData().scale(20f);
    }

    public static float getTextWidth(String text){              //esta funcion cuenta los pixeles de un string para poder centrarlo en la UI
        glyphLayout.setText(font,text);
        return glyphLayout.width;
    }
}
