package buontyhunter.common;

import java.util.HashMap;
import java.util.Map;

import buontyhunter.core.GameEngine;

public class ImagePathProvider {
    public static Map<ImageType, AssetImage> imagePaths = new HashMap<>() {
        {
            put(ImageType.EARTH, new AssetImage() {
                {
                    setPath("earth.png");
                    setType(ImageType.EARTH);
                    setHeight(GameEngine.RATIO_HEIGHT);
                    setWidth(GameEngine.RATIO_WIDTH);
                }
            });
            put(ImageType.WATER, new AssetImage() {
                {
                    setPath("water.png");
                    setType(ImageType.WATER);
                    setHeight(GameEngine.RATIO_HEIGHT);
                    setWidth(GameEngine.RATIO_WIDTH);
                }
            });
            put(ImageType.GRASS, new AssetImage() {
                {
                    setPath("grass.png");
                    setType(ImageType.GRASS);
                    setHeight(GameEngine.RATIO_HEIGHT);
                    setWidth(GameEngine.RATIO_WIDTH);
                }
            });
            put(ImageType.SAND, new AssetImage() {
                {
                    setPath("sand.png");
                    setType(ImageType.SAND);
                    setHeight(GameEngine.RATIO_HEIGHT);
                    setWidth(GameEngine.RATIO_WIDTH);
                }
            });
            put(ImageType.TREE, new AssetImage() {
                {
                    setPath("tree.png");
                    setType(ImageType.TREE);
                    setHeight(GameEngine.RATIO_HEIGHT);
                    setWidth(GameEngine.RATIO_WIDTH);
                }
            });
            put(ImageType.WALL, new AssetImage() {
                {
                    setPath("wall.png");
                    setType(ImageType.WALL);
                    setHeight(GameEngine.RATIO_HEIGHT);
                    setWidth(GameEngine.RATIO_WIDTH);
                }
            });
            put(ImageType.MAPBG, new AssetImage() {
                {
                    setPath("mapBG.png");
                    setType(ImageType.MAPBG);
                    setHeight(GameEngine.WINDOW_HEIGHT);
                    setWidth(GameEngine.WINDOW_HEIGHT);
                }
            });
            //put all the new images 
            put(ImageType.HUBAllPath,new AssetImage(){
                {
                    setPath("allPath.png");
                    setType(ImageType.HUBAllPath);
                    setHeight(GameEngine.RATIO_HEIGHT);
                    setWidth(GameEngine.RATIO_WIDTH);
                }
            });
            put(ImageType.HUBEarth,new AssetImage(){
                {
                    setPath("HubEarth.png");
                    setType(ImageType.HUBEarth);
                    setHeight(GameEngine.RATIO_HEIGHT);
                    setWidth(GameEngine.RATIO_WIDTH);
                }
            });
            put(ImageType.HubMiddleTopRoof,new AssetImage(){
                {
                    setPath("middleTopRoof.png");
                    setType(ImageType.HubMiddleTopRoof);
                    setHeight(GameEngine.RATIO_HEIGHT);
                    setWidth(GameEngine.RATIO_WIDTH);
                }
            });
            put(ImageType.HubLeftSideTopRoof,new AssetImage(){
                {
                    setPath("LeftSideTopRoof.png");
                    setType(ImageType.HubLeftSideTopRoof);
                    setHeight(GameEngine.RATIO_HEIGHT);
                    setWidth(GameEngine.RATIO_WIDTH);
                }
            });
            put(ImageType.HubRightSideTopRoof,new AssetImage(){
                {
                    setPath("RightSideTopRoof.png");
                    setType(ImageType.HubRightSideTopRoof);
                    setHeight(GameEngine.RATIO_HEIGHT);
                    setWidth(GameEngine.RATIO_WIDTH);
                }
            });
            put(ImageType.LeftSideRoof,new AssetImage(){
                {
                    setPath("LeftSideRoof.png");
                    setType(ImageType.LeftSideRoof);
                    setHeight(GameEngine.RATIO_HEIGHT);
                    setWidth(GameEngine.RATIO_WIDTH);
                }
            });
            put(ImageType.MidleRoof,new AssetImage(){
                {
                    setPath("MiddleRoof.png");
                    setType(ImageType.MidleRoof);
                    setHeight(GameEngine.RATIO_HEIGHT);
                    setWidth(GameEngine.RATIO_WIDTH);
                }
            });
            put(ImageType.RightSideRoof,new AssetImage(){
                {
                    setPath("RightSideRoof.png");
                    setType(ImageType.RightSideRoof);
                    setHeight(GameEngine.RATIO_HEIGHT);
                    setWidth(GameEngine.RATIO_WIDTH);
                }
            });
            put(ImageType.pathParticles,new AssetImage(){
                {
                    setPath("pathParticles.png");
                    setType(ImageType.pathParticles);
                    setHeight(GameEngine.RATIO_HEIGHT);
                    setWidth(GameEngine.RATIO_WIDTH);
                }
            });
            put(ImageType.pathPattern1,new AssetImage(){
                {
                    setPath("pathPattern1.png");
                    setType(ImageType.pathPattern1);
                    setHeight(GameEngine.RATIO_HEIGHT);
                    setWidth(GameEngine.RATIO_WIDTH);
                }
            });
            put(ImageType.houseFace1,new AssetImage(){
                {
                    setPath("houseFace1.png");
                    setType(ImageType.houseFace1);
                    setHeight(GameEngine.RATIO_HEIGHT);
                    setWidth(GameEngine.RATIO_WIDTH);
                }
            });
            put(ImageType.houseFace2,new AssetImage(){
                {
                    setPath("houseFace2.png");
                    setType(ImageType.houseFace2);
                    setHeight(GameEngine.RATIO_HEIGHT);
                    setWidth(GameEngine.RATIO_WIDTH);
                }
            });
            put(ImageType.houseFace3,new AssetImage(){
                {
                    setPath("houseFace3.png");
                    setType(ImageType.houseFace3);
                    setHeight(GameEngine.RATIO_HEIGHT);
                    setWidth(GameEngine.RATIO_WIDTH);
                }
            });
            put(ImageType.houseFace4,new AssetImage(){
                {
                    setPath("houseFace4.png");
                    setType(ImageType.houseFace4);
                    setHeight(GameEngine.RATIO_HEIGHT);
                    setWidth(GameEngine.RATIO_WIDTH);
                }
            });
            put(ImageType.houseFace5,new AssetImage(){
                {
                    setPath("houseFace5.png");
                    setType(ImageType.houseFace5);
                    setHeight(GameEngine.RATIO_HEIGHT);
                    setWidth(GameEngine.RATIO_WIDTH);
                }
            });
            put(ImageType.houseFace6,new AssetImage(){
                {
                    setPath("houseFace6.png");
                    setType(ImageType.houseFace6);
                    setHeight(GameEngine.RATIO_HEIGHT);
                    setWidth(GameEngine.RATIO_WIDTH);
                }
            });
            put(ImageType.houseFace7,new AssetImage(){
                {
                    setPath("houseFace7.png");
                    setType(ImageType.houseFace7);
                    setHeight(GameEngine.RATIO_HEIGHT);
                    setWidth(GameEngine.RATIO_WIDTH);
                }
            });
            put(ImageType.houseFace8,new AssetImage(){
                {
                    setPath("houseFace8.png");
                    setType(ImageType.houseFace8);
                    setHeight(GameEngine.RATIO_HEIGHT);
                    setWidth(GameEngine.RATIO_WIDTH);
                }
            });
            put(ImageType.houseFace9,new AssetImage(){
                {
                    setPath("houseFace9.png");
                    setType(ImageType.houseFace9);
                    setHeight(GameEngine.RATIO_HEIGHT);
                    setWidth(GameEngine.RATIO_WIDTH);
                }
            });
            put(ImageType.houseFace10,new AssetImage(){
                {
                    setPath("houseFace10.png");
                    setType(ImageType.houseFace10);
                    setHeight(GameEngine.RATIO_HEIGHT);
                    setWidth(GameEngine.RATIO_WIDTH);
                }
            });
            put(ImageType.houseFace11,new AssetImage(){
                {
                    setPath("houseFace11.png");
                    setType(ImageType.houseFace11);
                    setHeight(GameEngine.RATIO_HEIGHT);
                    setWidth(GameEngine.RATIO_WIDTH);
                }
            });
            put(ImageType.Cespuglio,new AssetImage(){
                {
                    setPath("Cespuglio.png");
                    setType(ImageType.Cespuglio);
                    setHeight(GameEngine.RATIO_HEIGHT);
                    setWidth(GameEngine.RATIO_WIDTH);
                }
            });
            put(ImageType.middleQuestTable,new AssetImage(){
                {
                    setPath("middleQuestTable.png");
                    setType(ImageType.middleQuestTable);
                    setHeight(GameEngine.RATIO_HEIGHT);
                    setWidth(GameEngine.RATIO_WIDTH);
                }
            });
            put(ImageType.middleQuestTable2,new AssetImage(){
                {
                    setPath("middleQuestTable2.png");
                    setType(ImageType.middleQuestTable2);
                    setHeight(GameEngine.RATIO_HEIGHT);
                    setWidth(GameEngine.RATIO_WIDTH);
                }
            });
            put(ImageType.middleQuestTable3,new AssetImage(){
                {
                    setPath("middleQuestTable3.png");
                    setType(ImageType.middleQuestTable3);
                    setHeight(GameEngine.RATIO_HEIGHT);
                    setWidth(GameEngine.RATIO_WIDTH);
                }
            });
            put(ImageType.middleQuestTable4,new AssetImage(){
                {
                    setPath("middleQuestTable4.png");
                    setType(ImageType.middleQuestTable4);
                    setHeight(GameEngine.RATIO_HEIGHT);
                    setWidth(GameEngine.RATIO_WIDTH);
                }
            });
            put(ImageType.staccionata,new AssetImage(){
                {
                    setPath("staccionata.png");
                    setType(ImageType.staccionata);
                    setHeight(GameEngine.RATIO_HEIGHT);
                    setWidth(GameEngine.RATIO_WIDTH);
                }
            });
            put(ImageType.topQuestTable1,new AssetImage(){
                {
                    setPath("topQuestTable1.png");
                    setType(ImageType.topQuestTable1);
                    setHeight(GameEngine.RATIO_HEIGHT);
                    setWidth(GameEngine.RATIO_WIDTH);
                }
            });
            put(ImageType.topQuestTable2,new AssetImage(){
                {
                    setPath("topQuestTable2.png");
                    setType(ImageType.topQuestTable2);
                    setHeight(GameEngine.RATIO_HEIGHT);
                    setWidth(GameEngine.RATIO_WIDTH);
                }
            });
            put(ImageType.topQuestTable3,new AssetImage(){
                {
                    setPath("topQuestTable3.png");
                    setType(ImageType.topQuestTable3);
                    setHeight(GameEngine.RATIO_HEIGHT);
                    setWidth(GameEngine.RATIO_WIDTH);
                }
            });
            put(ImageType.topQuestTable4,new AssetImage(){
                {
                    setPath("topQuestTable4.png");
                    setType(ImageType.topQuestTable4);
                    setHeight(GameEngine.RATIO_HEIGHT);
                    setWidth(GameEngine.RATIO_WIDTH);
                }
            });
            put(ImageType.cespuglio2,new AssetImage(){
                {
                    setPath("cespuglio2.png");
                    setType(ImageType.cespuglio2);
                    setHeight(GameEngine.RATIO_HEIGHT);
                    setWidth(GameEngine.RATIO_WIDTH);
                }
            });
            put(ImageType.pathPattern2,new AssetImage(){
                {
                    setPath("pathPattern2.png");
                    setType(ImageType.pathPattern2);
                    setHeight(GameEngine.RATIO_HEIGHT);
                    setWidth(GameEngine.RATIO_WIDTH);
                }
            });
            put(ImageType.pathPattern3,new AssetImage(){
                {
                    setPath("pathPattern3.png");
                    setType(ImageType.pathPattern3);
                    setHeight(GameEngine.RATIO_HEIGHT);
                    setWidth(GameEngine.RATIO_WIDTH);
                }
            });
            put(ImageType.pathPattern4,new AssetImage(){
                {
                    setPath("pathPattern4.png");
                    setType(ImageType.pathPattern4);
                    setHeight(GameEngine.RATIO_HEIGHT);
                    setWidth(GameEngine.RATIO_WIDTH);
                }
            });
            put(ImageType.pathPattern5,new AssetImage(){
                {
                    setPath("pathPattern5.png");
                    setType(ImageType.pathPattern5);
                    setHeight(GameEngine.RATIO_HEIGHT);
                    setWidth(GameEngine.RATIO_WIDTH);
                }
            });
            put(ImageType.pathPattern6,new AssetImage(){
                {
                    setPath("pathPattern6.png");
                    setType(ImageType.pathPattern6);
                    setHeight(GameEngine.RATIO_HEIGHT);
                    setWidth(GameEngine.RATIO_WIDTH);
                }
            });
            put(ImageType.BottomQuestTable2,new AssetImage(){
                {
                    setPath("BottomQuestTable2.png");
                    setType(ImageType.BottomQuestTable2);
                    setHeight(GameEngine.RATIO_HEIGHT);
                    setWidth(GameEngine.RATIO_WIDTH);
                }
            });
            put(ImageType.BottomQuestTable3,new AssetImage(){
                {
                    setPath("BottomQuestTable3.png");
                    setType(ImageType.BottomQuestTable3);
                    setHeight(GameEngine.RATIO_HEIGHT);
                    setWidth(GameEngine.RATIO_WIDTH);
                }
            });
            put(ImageType.BottomQuestTable4,new AssetImage(){
                {
                    setPath("BottomQuestTable4.png");
                    setType(ImageType.BottomQuestTable4);
                    setHeight(GameEngine.RATIO_HEIGHT);
                    setWidth(GameEngine.RATIO_WIDTH);
                }
            });
            put(ImageType.BottomQuestTable1,new AssetImage(){
                {
                    setPath("BottomQuestTable1.png");
                    setType(ImageType.BottomQuestTable1);
                    setHeight(GameEngine.RATIO_HEIGHT);
                    setWidth(GameEngine.RATIO_WIDTH);
                }
            });
            put(ImageType.BottomStaccionata,new AssetImage(){
                {
                    setPath("BottomStaccionata.png");
                    setType(ImageType.BottomStaccionata);
                    setHeight(GameEngine.RATIO_HEIGHT);
                    setWidth(GameEngine.RATIO_WIDTH);
                }
            });
            put(ImageType.cespuglio3,new AssetImage(){
                {
                    setPath("cespuglio3.png");
                    setType(ImageType.cespuglio3);
                    setHeight(GameEngine.RATIO_HEIGHT);
                    setWidth(GameEngine.RATIO_WIDTH);
                }
            });
            put(ImageType.topCespuglio1,new AssetImage(){
                {
                    setPath("topCespuglio1.png");
                    setType(ImageType.topCespuglio1);
                    setHeight(GameEngine.RATIO_HEIGHT);
                    setWidth(GameEngine.RATIO_WIDTH);
                }
            });
            put(ImageType.pathPattern7,new AssetImage(){
                {
                    setPath("pathPattern7.png");
                    setType(ImageType.pathPattern7);
                    setHeight(GameEngine.RATIO_HEIGHT);
                    setWidth(GameEngine.RATIO_WIDTH);
                }
            });
            put(ImageType.pathPattern8,new AssetImage(){
                {
                    setPath("pathPattern8.png");
                    setType(ImageType.pathPattern8);
                    setHeight(GameEngine.RATIO_HEIGHT);
                    setWidth(GameEngine.RATIO_WIDTH);
                }
            });
            put(ImageType.pathPattern9,new AssetImage(){
                {
                    setPath("pathPattern9.png");
                    setType(ImageType.pathPattern9);
                    setHeight(GameEngine.RATIO_HEIGHT);
                    setWidth(GameEngine.RATIO_WIDTH);
                }
            });
            put(ImageType.pathPattern10,new AssetImage(){
                {
                    setPath("pathPattern10.png");
                    setType(ImageType.pathPattern10);
                    setHeight(GameEngine.RATIO_HEIGHT);
                    setWidth(GameEngine.RATIO_WIDTH);
                }
            });
        }
    };
}
