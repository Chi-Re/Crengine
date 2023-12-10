package crengine;

import crengine.base.FileType;
import crengine.util.io.CRFile;

import java.awt.*;

public class Settings {
    protected String appName = "app";
    /**数据储存路径*/
    protected CRFile dataDirectory;//外

    protected int width, height;

    public Settings(){
    }

    public String getAppName(){
        return this.appName;
    }
    public void setAppName(String name){
        appName = name;
    }

    public CRFile getDataDirectory() {
        return this.dataDirectory;
    }
    public void setDataDirectory(CRFile file){
        this.dataDirectory = file;
    }

    public int getAppWidth(){
        return this.width;
    }
    public int getAppHeight(){
        return this.height;
    }

    public void setSize(int width, int height){
        this.width = width;
        this.height = height;
    }
}
