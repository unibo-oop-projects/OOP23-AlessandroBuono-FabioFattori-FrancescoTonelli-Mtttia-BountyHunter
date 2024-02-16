package buontyhunter.common;

import java.util.HashMap;
import java.util.Map;

import buontyhunter.core.GameEngine;

public class ImagePathProvider {
    public static Map<ImageType, AssetImage> imagePaths = new HashMap<>() {
        {
            put(ImageType.title, new AssetImage() {
                {
                    setPath("utility/title.png");
                    setType(ImageType.title);
                    setHeight(GameEngine.RESIZATOR.getRATIO_HEIGHT());
                    setWidth(GameEngine.RESIZATOR.getRATIO_WIDTH());
                }
            });
            put(ImageType.EARTH, new AssetImage() {
                {
                    setPath("earth.png");
                    setType(ImageType.EARTH);
                    setHeight(GameEngine.RESIZATOR.getRATIO_HEIGHT());
                    setWidth(GameEngine.RESIZATOR.getRATIO_WIDTH());
                }
            });
            put(ImageType.WATER, new AssetImage() {
                {
                    setPath("water.png");
                    setType(ImageType.WATER);
                    setHeight(GameEngine.RESIZATOR.getRATIO_HEIGHT());
                    setWidth(GameEngine.RESIZATOR.getRATIO_WIDTH());
                }
            });
            put(ImageType.GRASS, new AssetImage() {
                {
                    setPath("grass.png");
                    setType(ImageType.GRASS);
                    setHeight(GameEngine.RESIZATOR.getRATIO_HEIGHT());
                    setWidth(GameEngine.RESIZATOR.getRATIO_WIDTH());
                }
            });
            put(ImageType.SAND, new AssetImage() {
                {
                    setPath("sand.png");
                    setType(ImageType.SAND);
                    setHeight(GameEngine.RESIZATOR.getRATIO_HEIGHT());
                    setWidth(GameEngine.RESIZATOR.getRATIO_WIDTH());
                }
            });
            put(ImageType.TREE, new AssetImage() {
                {
                    setPath("tree.png");
                    setType(ImageType.TREE);
                    setHeight(GameEngine.RESIZATOR.getRATIO_HEIGHT());
                    setWidth(GameEngine.RESIZATOR.getRATIO_WIDTH());
                }
            });
            put(ImageType.WALL, new AssetImage() {
                {
                    setPath("wall.png");
                    setType(ImageType.WALL);
                    setHeight(GameEngine.RESIZATOR.getRATIO_HEIGHT());
                    setWidth(GameEngine.RESIZATOR.getRATIO_WIDTH());
                }
            });
            put(ImageType.MAPBG, new AssetImage() {
                {
                    setPath("mapBG.png");
                    setType(ImageType.MAPBG);
                    setHeight(GameEngine.RESIZATOR.getWINDOW_WIDTH());
                    setWidth(GameEngine.RESIZATOR.getWINDOW_HEIGHT());
                }
            });
            // put all the new images
            put(ImageType.HUBAllPath, new AssetImage() {
                {
                    setPath("allPath.png");
                    setType(ImageType.HUBAllPath);
                    setHeight(GameEngine.RESIZATOR.getRATIO_HEIGHT());
                    setWidth(GameEngine.RESIZATOR.getRATIO_WIDTH());
                }
            });
            put(ImageType.HUBEarth, new AssetImage() {
                {
                    setPath("HubEarth.png");
                    setType(ImageType.HUBEarth);
                    setHeight(GameEngine.RESIZATOR.getRATIO_HEIGHT());
                    setWidth(GameEngine.RESIZATOR.getRATIO_WIDTH());
                }
            });
            put(ImageType.HubMiddleTopRoof, new AssetImage() {
                {
                    setPath("middleTopRoof.png");
                    setType(ImageType.HubMiddleTopRoof);
                    setHeight(GameEngine.RESIZATOR.getRATIO_HEIGHT());
                    setWidth(GameEngine.RESIZATOR.getRATIO_WIDTH());
                }
            });
            put(ImageType.HubLeftSideTopRoof, new AssetImage() {
                {
                    setPath("LeftSideTopRoof.png");
                    setType(ImageType.HubLeftSideTopRoof);
                    setHeight(GameEngine.RESIZATOR.getRATIO_HEIGHT());
                    setWidth(GameEngine.RESIZATOR.getRATIO_WIDTH());
                }
            });
            put(ImageType.HubRightSideTopRoof, new AssetImage() {
                {
                    setPath("RightSideTopRoof.png");
                    setType(ImageType.HubRightSideTopRoof);
                    setHeight(GameEngine.RESIZATOR.getRATIO_HEIGHT());
                    setWidth(GameEngine.RESIZATOR.getRATIO_WIDTH());
                }
            });
            put(ImageType.LeftSideRoof, new AssetImage() {
                {
                    setPath("LeftSideRoof.png");
                    setType(ImageType.LeftSideRoof);
                    setHeight(GameEngine.RESIZATOR.getRATIO_HEIGHT());
                    setWidth(GameEngine.RESIZATOR.getRATIO_WIDTH());
                }
            });
            put(ImageType.MidleRoof, new AssetImage() {
                {
                    setPath("MiddleRoof.png");
                    setType(ImageType.MidleRoof);
                    setHeight(GameEngine.RESIZATOR.getRATIO_HEIGHT());
                    setWidth(GameEngine.RESIZATOR.getRATIO_WIDTH());
                }
            });
            put(ImageType.RightSideRoof, new AssetImage() {
                {
                    setPath("RightSideRoof.png");
                    setType(ImageType.RightSideRoof);
                    setHeight(GameEngine.RESIZATOR.getRATIO_HEIGHT());
                    setWidth(GameEngine.RESIZATOR.getRATIO_WIDTH());
                }
            });
            put(ImageType.pathParticles, new AssetImage() {
                {
                    setPath("pathParticles.png");
                    setType(ImageType.pathParticles);
                    setHeight(GameEngine.RESIZATOR.getRATIO_HEIGHT());
                    setWidth(GameEngine.RESIZATOR.getRATIO_WIDTH());
                }
            });
            put(ImageType.pathPattern1, new AssetImage() {
                {
                    setPath("pathPattern1.png");
                    setType(ImageType.pathPattern1);
                    setHeight(GameEngine.RESIZATOR.getRATIO_HEIGHT());
                    setWidth(GameEngine.RESIZATOR.getRATIO_WIDTH());
                }
            });
            put(ImageType.houseFace1, new AssetImage() {
                {
                    setPath("houseFace1.png");
                    setType(ImageType.houseFace1);
                    setHeight(GameEngine.RESIZATOR.getRATIO_HEIGHT());
                    setWidth(GameEngine.RESIZATOR.getRATIO_WIDTH());
                }
            });
            put(ImageType.houseFace2, new AssetImage() {
                {
                    setPath("houseFace2.png");
                    setType(ImageType.houseFace2);
                    setHeight(GameEngine.RESIZATOR.getRATIO_HEIGHT());
                    setWidth(GameEngine.RESIZATOR.getRATIO_WIDTH());
                }
            });
            put(ImageType.houseFace3, new AssetImage() {
                {
                    setPath("houseFace3.png");
                    setType(ImageType.houseFace3);
                    setHeight(GameEngine.RESIZATOR.getRATIO_HEIGHT());
                    setWidth(GameEngine.RESIZATOR.getRATIO_WIDTH());
                }
            });
            put(ImageType.houseFace4, new AssetImage() {
                {
                    setPath("houseFace4.png");
                    setType(ImageType.houseFace4);
                    setHeight(GameEngine.RESIZATOR.getRATIO_HEIGHT());
                    setWidth(GameEngine.RESIZATOR.getRATIO_WIDTH());
                }
            });
            put(ImageType.houseFace5, new AssetImage() {
                {
                    setPath("houseFace5.png");
                    setType(ImageType.houseFace5);
                    setHeight(GameEngine.RESIZATOR.getRATIO_HEIGHT());
                    setWidth(GameEngine.RESIZATOR.getRATIO_WIDTH());
                }
            });
            put(ImageType.houseFace6, new AssetImage() {
                {
                    setPath("houseFace6.png");
                    setType(ImageType.houseFace6);
                    setHeight(GameEngine.RESIZATOR.getRATIO_HEIGHT());
                    setWidth(GameEngine.RESIZATOR.getRATIO_WIDTH());
                }
            });
            put(ImageType.houseFace7, new AssetImage() {
                {
                    setPath("houseFace7.png");
                    setType(ImageType.houseFace7);
                    setHeight(GameEngine.RESIZATOR.getRATIO_HEIGHT());
                    setWidth(GameEngine.RESIZATOR.getRATIO_WIDTH());
                }
            });
            put(ImageType.houseFace8, new AssetImage() {
                {
                    setPath("houseFace8.png");
                    setType(ImageType.houseFace8);
                    setHeight(GameEngine.RESIZATOR.getRATIO_HEIGHT());
                    setWidth(GameEngine.RESIZATOR.getRATIO_WIDTH());
                }
            });
            put(ImageType.houseFace9, new AssetImage() {
                {
                    setPath("houseFace9.png");
                    setType(ImageType.houseFace9);
                    setHeight(GameEngine.RESIZATOR.getRATIO_HEIGHT());
                    setWidth(GameEngine.RESIZATOR.getRATIO_WIDTH());
                }
            });
            put(ImageType.houseFace10, new AssetImage() {
                {
                    setPath("houseFace10.png");
                    setType(ImageType.houseFace10);
                    setHeight(GameEngine.RESIZATOR.getRATIO_HEIGHT());
                    setWidth(GameEngine.RESIZATOR.getRATIO_WIDTH());
                }
            });
            put(ImageType.houseFace11, new AssetImage() {
                {
                    setPath("houseFace11.png");
                    setType(ImageType.houseFace11);
                    setHeight(GameEngine.RESIZATOR.getRATIO_HEIGHT());
                    setWidth(GameEngine.RESIZATOR.getRATIO_WIDTH());
                }
            });
            put(ImageType.Cespuglio, new AssetImage() {
                {
                    setPath("Cespuglio.png");
                    setType(ImageType.Cespuglio);
                    setHeight(GameEngine.RESIZATOR.getRATIO_HEIGHT());
                    setWidth(GameEngine.RESIZATOR.getRATIO_WIDTH());
                }
            });
            put(ImageType.middleQuestTable, new AssetImage() {
                {
                    setPath("middleQuestTable.png");
                    setType(ImageType.middleQuestTable);
                    setHeight(GameEngine.RESIZATOR.getRATIO_HEIGHT());
                    setWidth(GameEngine.RESIZATOR.getRATIO_WIDTH());
                }
            });
            put(ImageType.middleQuestTable2, new AssetImage() {
                {
                    setPath("middleQuestTable2.png");
                    setType(ImageType.middleQuestTable2);
                    setHeight(GameEngine.RESIZATOR.getRATIO_HEIGHT());
                    setWidth(GameEngine.RESIZATOR.getRATIO_WIDTH());
                }
            });
            put(ImageType.middleQuestTable3, new AssetImage() {
                {
                    setPath("middleQuestTable3.png");
                    setType(ImageType.middleQuestTable3);
                    setHeight(GameEngine.RESIZATOR.getRATIO_HEIGHT());
                    setWidth(GameEngine.RESIZATOR.getRATIO_WIDTH());
                }
            });
            put(ImageType.middleQuestTable4, new AssetImage() {
                {
                    setPath("middleQuestTable4.png");
                    setType(ImageType.middleQuestTable4);
                    setHeight(GameEngine.RESIZATOR.getRATIO_HEIGHT());
                    setWidth(GameEngine.RESIZATOR.getRATIO_WIDTH());
                }
            });
            put(ImageType.staccionata, new AssetImage() {
                {
                    setPath("staccionata.png");
                    setType(ImageType.staccionata);
                    setHeight(GameEngine.RESIZATOR.getRATIO_HEIGHT());
                    setWidth(GameEngine.RESIZATOR.getRATIO_WIDTH());
                }
            });
            put(ImageType.topQuestTable1, new AssetImage() {
                {
                    setPath("topQuestTable1.png");
                    setType(ImageType.topQuestTable1);
                    setHeight(GameEngine.RESIZATOR.getRATIO_HEIGHT());
                    setWidth(GameEngine.RESIZATOR.getRATIO_WIDTH());
                }
            });
            put(ImageType.topQuestTable2, new AssetImage() {
                {
                    setPath("topQuestTable2.png");
                    setType(ImageType.topQuestTable2);
                    setHeight(GameEngine.RESIZATOR.getRATIO_HEIGHT());
                    setWidth(GameEngine.RESIZATOR.getRATIO_WIDTH());
                }
            });
            put(ImageType.topQuestTable3, new AssetImage() {
                {
                    setPath("topQuestTable3.png");
                    setType(ImageType.topQuestTable3);
                    setHeight(GameEngine.RESIZATOR.getRATIO_HEIGHT());
                    setWidth(GameEngine.RESIZATOR.getRATIO_WIDTH());
                }
            });
            put(ImageType.topQuestTable4, new AssetImage() {
                {
                    setPath("topQuestTable4.png");
                    setType(ImageType.topQuestTable4);
                    setHeight(GameEngine.RESIZATOR.getRATIO_HEIGHT());
                    setWidth(GameEngine.RESIZATOR.getRATIO_WIDTH());
                }
            });
            put(ImageType.cespuglio2, new AssetImage() {
                {
                    setPath("cespuglio2.png");
                    setType(ImageType.cespuglio2);
                    setHeight(GameEngine.RESIZATOR.getRATIO_HEIGHT());
                    setWidth(GameEngine.RESIZATOR.getRATIO_WIDTH());
                }
            });
            put(ImageType.pathPattern2, new AssetImage() {
                {
                    setPath("pathPattern2.png");
                    setType(ImageType.pathPattern2);
                    setHeight(GameEngine.RESIZATOR.getRATIO_HEIGHT());
                    setWidth(GameEngine.RESIZATOR.getRATIO_WIDTH());
                }
            });
            put(ImageType.pathPattern3, new AssetImage() {
                {
                    setPath("pathPattern3.png");
                    setType(ImageType.pathPattern3);
                    setHeight(GameEngine.RESIZATOR.getRATIO_HEIGHT());
                    setWidth(GameEngine.RESIZATOR.getRATIO_WIDTH());
                }
            });
            put(ImageType.pathPattern4, new AssetImage() {
                {
                    setPath("pathPattern4.png");
                    setType(ImageType.pathPattern4);
                    setHeight(GameEngine.RESIZATOR.getRATIO_HEIGHT());
                    setWidth(GameEngine.RESIZATOR.getRATIO_WIDTH());
                }
            });
            put(ImageType.pathPattern5, new AssetImage() {
                {
                    setPath("pathPattern5.png");
                    setType(ImageType.pathPattern5);
                    setHeight(GameEngine.RESIZATOR.getRATIO_HEIGHT());
                    setWidth(GameEngine.RESIZATOR.getRATIO_WIDTH());
                }
            });
            put(ImageType.pathPattern6, new AssetImage() {
                {
                    setPath("pathPattern6.png");
                    setType(ImageType.pathPattern6);
                    setHeight(GameEngine.RESIZATOR.getRATIO_HEIGHT());
                    setWidth(GameEngine.RESIZATOR.getRATIO_WIDTH());
                }
            });
            put(ImageType.BottomQuestTable2, new AssetImage() {
                {
                    setPath("BottomQuestTable2.png");
                    setType(ImageType.BottomQuestTable2);
                    setHeight(GameEngine.RESIZATOR.getRATIO_HEIGHT());
                    setWidth(GameEngine.RESIZATOR.getRATIO_WIDTH());
                }
            });
            put(ImageType.BottomQuestTable3, new AssetImage() {
                {
                    setPath("BottomQuestTable3.png");
                    setType(ImageType.BottomQuestTable3);
                    setHeight(GameEngine.RESIZATOR.getRATIO_HEIGHT());
                    setWidth(GameEngine.RESIZATOR.getRATIO_WIDTH());
                }
            });
            put(ImageType.BottomQuestTable4, new AssetImage() {
                {
                    setPath("BottomQuestTable4.png");
                    setType(ImageType.BottomQuestTable4);
                    setHeight(GameEngine.RESIZATOR.getRATIO_HEIGHT());
                    setWidth(GameEngine.RESIZATOR.getRATIO_WIDTH());
                }
            });
            put(ImageType.BottomQuestTable1, new AssetImage() {
                {
                    setPath("BottomQuestTable1.png");
                    setType(ImageType.BottomQuestTable1);
                    setHeight(GameEngine.RESIZATOR.getRATIO_HEIGHT());
                    setWidth(GameEngine.RESIZATOR.getRATIO_WIDTH());
                }
            });
            put(ImageType.BottomStaccionata, new AssetImage() {
                {
                    setPath("BottomStaccionata.png");
                    setType(ImageType.BottomStaccionata);
                    setHeight(GameEngine.RESIZATOR.getRATIO_HEIGHT());
                    setWidth(GameEngine.RESIZATOR.getRATIO_WIDTH());
                }
            });
            put(ImageType.cespuglio3, new AssetImage() {
                {
                    setPath("cespuglio3.png");
                    setType(ImageType.cespuglio3);
                    setHeight(GameEngine.RESIZATOR.getRATIO_HEIGHT());
                    setWidth(GameEngine.RESIZATOR.getRATIO_WIDTH());
                }
            });
            put(ImageType.topCespuglio1, new AssetImage() {
                {
                    setPath("topCespuglio1.png");
                    setType(ImageType.topCespuglio1);
                    setHeight(GameEngine.RESIZATOR.getRATIO_HEIGHT());
                    setWidth(GameEngine.RESIZATOR.getRATIO_WIDTH());
                }
            });
            put(ImageType.pathPattern7, new AssetImage() {
                {
                    setPath("pathPattern7.png");
                    setType(ImageType.pathPattern7);
                    setHeight(GameEngine.RESIZATOR.getRATIO_HEIGHT());
                    setWidth(GameEngine.RESIZATOR.getRATIO_WIDTH());
                }
            });
            put(ImageType.pathPattern8, new AssetImage() {
                {
                    setPath("pathPattern8.png");
                    setType(ImageType.pathPattern8);
                    setHeight(GameEngine.RESIZATOR.getRATIO_HEIGHT());
                    setWidth(GameEngine.RESIZATOR.getRATIO_WIDTH());
                }
            });
            put(ImageType.pathPattern9, new AssetImage() {
                {
                    setPath("pathPattern9.png");
                    setType(ImageType.pathPattern9);
                    setHeight(GameEngine.RESIZATOR.getRATIO_HEIGHT());
                    setWidth(GameEngine.RESIZATOR.getRATIO_WIDTH());
                }
            });
            put(ImageType.pathPattern10, new AssetImage() {
                {
                    setPath("pathPattern10.png");
                    setType(ImageType.pathPattern10);
                    setHeight(GameEngine.RESIZATOR.getRATIO_HEIGHT());
                    setWidth(GameEngine.RESIZATOR.getRATIO_WIDTH());
                }
            });
            put(ImageType.hunterFront, new AssetImage() {
                {
                    setPath("hunter/hunter_front.png");
                    setType(ImageType.hunterFront);
                    setHeight(GameEngine.RESIZATOR.getRATIO_HEIGHT());
                    setWidth(GameEngine.RESIZATOR.getRATIO_WIDTH());
                }
            });
            put(ImageType.hunterFront1, new AssetImage() {
                {
                    setPath("hunter/hunter_front_1.png");
                    setType(ImageType.hunterFront1);
                    setHeight(GameEngine.RESIZATOR.getRATIO_HEIGHT());
                    setWidth(GameEngine.RESIZATOR.getRATIO_WIDTH());
                }
            });
            put(ImageType.hunterFront2, new AssetImage() {
                {
                    setPath("hunter/hunter_front_2.png");
                    setType(ImageType.hunterFront2);
                    setHeight(GameEngine.RESIZATOR.getRATIO_HEIGHT());
                    setWidth(GameEngine.RESIZATOR.getRATIO_WIDTH());
                }
            });
            put(ImageType.hunterBack, new AssetImage() {
                {
                    setPath("hunter/hunter_back.png");
                    setType(ImageType.hunterBack);
                    setHeight(GameEngine.RESIZATOR.getRATIO_HEIGHT());
                    setWidth(GameEngine.RESIZATOR.getRATIO_WIDTH());
                }
            });
            put(ImageType.hunterBack1, new AssetImage() {
                {
                    setPath("hunter/hunter_back_1.png");
                    setType(ImageType.hunterBack1);
                    setHeight(GameEngine.RESIZATOR.getRATIO_HEIGHT());
                    setWidth(GameEngine.RESIZATOR.getRATIO_WIDTH());
                }
            });
            put(ImageType.hunterBack2, new AssetImage() {
                {
                    setPath("hunter/hunter_back_2.png");
                    setType(ImageType.hunterBack2);
                    setHeight(GameEngine.RESIZATOR.getRATIO_HEIGHT());
                    setWidth(GameEngine.RESIZATOR.getRATIO_WIDTH());
                }
            });

            put(ImageType.hunterLeft, new AssetImage() {
                {
                    setPath("hunter/hunter_left.png");
                    setType(ImageType.hunterLeft);
                    setHeight(GameEngine.RESIZATOR.getRATIO_HEIGHT());
                    setWidth(GameEngine.RESIZATOR.getRATIO_WIDTH());
                }
            });
            put(ImageType.hunterLeft1, new AssetImage() {
                {
                    setPath("hunter/hunter_left_1.png");
                    setType(ImageType.hunterLeft1);
                    setHeight(GameEngine.RESIZATOR.getRATIO_HEIGHT());
                    setWidth(GameEngine.RESIZATOR.getRATIO_WIDTH());
                }
            });
            put(ImageType.hunterLeft2, new AssetImage() {
                {
                    setPath("hunter/hunter_left_2.png");
                    setType(ImageType.hunterLeft2);
                    setHeight(GameEngine.RESIZATOR.getRATIO_HEIGHT());
                    setWidth(GameEngine.RESIZATOR.getRATIO_WIDTH());
                }
            });
            put(ImageType.hunterRight, new AssetImage() {
                {
                    setPath("hunter/hunter_right.png");
                    setType(ImageType.hunterRight);
                    setHeight(GameEngine.RESIZATOR.getRATIO_HEIGHT());
                    setWidth(GameEngine.RESIZATOR.getRATIO_WIDTH());
                }
            });
            put(ImageType.hunterRight1, new AssetImage() {
                {
                    setPath("hunter/hunter_right_1.png");
                    setType(ImageType.hunterRight1);
                    setHeight(GameEngine.RESIZATOR.getRATIO_HEIGHT());
                    setWidth(GameEngine.RESIZATOR.getRATIO_WIDTH());
                }
            });
            put(ImageType.hunterRight2, new AssetImage() {
                {
                    setPath("hunter/hunter_right_2.png");
                    setType(ImageType.hunterRight2);
                    setHeight(GameEngine.RESIZATOR.getRATIO_HEIGHT());
                    setWidth(GameEngine.RESIZATOR.getRATIO_WIDTH());
                }
            });
            put(ImageType.zombieFront, new AssetImage() {
                {
                    setPath("zombie/zombie_front.png");
                    setType(ImageType.zombieFront);
                    setHeight(GameEngine.RESIZATOR.getRATIO_HEIGHT());
                    setWidth(GameEngine.RESIZATOR.getRATIO_WIDTH());
                }
            });
            put(ImageType.zombieFront1, new AssetImage() {
                {
                    setPath("zombie/zombie_front_1.png");
                    setType(ImageType.zombieFront1);
                    setHeight(GameEngine.RESIZATOR.getRATIO_HEIGHT());
                    setWidth(GameEngine.RESIZATOR.getRATIO_WIDTH());
                }
            });
            put(ImageType.zombieFront2, new AssetImage() {
                {
                    setPath("zombie/zombie_front_2.png");
                    setType(ImageType.zombieFront2);
                    setHeight(GameEngine.RESIZATOR.getRATIO_HEIGHT());
                    setWidth(GameEngine.RESIZATOR.getRATIO_WIDTH());
                }
            });
            put(ImageType.zombieBack, new AssetImage() {
                {
                    setPath("zombie/zombie_back.png");
                    setType(ImageType.zombieBack);
                    setHeight(GameEngine.RESIZATOR.getRATIO_HEIGHT());
                    setWidth(GameEngine.RESIZATOR.getRATIO_WIDTH());
                }
            });
            put(ImageType.zombieBack1, new AssetImage() {
                {
                    setPath("zombie/zombie_back_1.png");
                    setType(ImageType.zombieBack1);
                    setHeight(GameEngine.RESIZATOR.getRATIO_HEIGHT());
                    setWidth(GameEngine.RESIZATOR.getRATIO_WIDTH());
                }
            });
            put(ImageType.zombieBack2, new AssetImage() {
                {
                    setPath("zombie/zombie_back_2.png");
                    setType(ImageType.zombieBack2);
                    setHeight(GameEngine.RESIZATOR.getRATIO_HEIGHT());
                    setWidth(GameEngine.RESIZATOR.getRATIO_WIDTH());
                }
            });

            put(ImageType.zombieLeft, new AssetImage() {
                {
                    setPath("zombie/zombie_left.png");
                    setType(ImageType.zombieLeft);
                    setHeight(GameEngine.RESIZATOR.getRATIO_HEIGHT());
                    setWidth(GameEngine.RESIZATOR.getRATIO_WIDTH());
                }
            });
            put(ImageType.zombieLeft1, new AssetImage() {
                {
                    setPath("zombie/zombie_left_1.png");
                    setType(ImageType.zombieLeft1);
                    setHeight(GameEngine.RESIZATOR.getRATIO_HEIGHT());
                    setWidth(GameEngine.RESIZATOR.getRATIO_WIDTH());
                }
            });
            put(ImageType.zombieLeft2, new AssetImage() {
                {
                    setPath("zombie/zombie_left_2.png");
                    setType(ImageType.zombieLeft2);
                    setHeight(GameEngine.RESIZATOR.getRATIO_HEIGHT());
                    setWidth(GameEngine.RESIZATOR.getRATIO_WIDTH());
                }
            });
            put(ImageType.zombieRight, new AssetImage() {
                {
                    setPath("zombie/zombie_right.png");
                    setType(ImageType.zombieRight);
                    setHeight(GameEngine.RESIZATOR.getRATIO_HEIGHT());
                    setWidth(GameEngine.RESIZATOR.getRATIO_WIDTH());
                }
            });
            put(ImageType.zombieRight1, new AssetImage() {
                {
                    setPath("zombie/zombie_right_1.png");
                    setType(ImageType.zombieRight1);
                    setHeight(GameEngine.RESIZATOR.getRATIO_HEIGHT());
                    setWidth(GameEngine.RESIZATOR.getRATIO_WIDTH());
                }
            });
            put(ImageType.zombieRight2, new AssetImage() {
                {
                    setPath("zombie/zombie_right_2.png");
                    setType(ImageType.zombieRight2);
                    setHeight(GameEngine.RESIZATOR.getRATIO_HEIGHT());
                    setWidth(GameEngine.RESIZATOR.getRATIO_WIDTH());
                }
            });
            put(ImageType.skellyFront, new AssetImage() {
                {
                    setPath("skelly/skelly_front.png");
                    setType(ImageType.skellyFront);
                    setHeight(GameEngine.RESIZATOR.getRATIO_HEIGHT());
                    setWidth(GameEngine.RESIZATOR.getRATIO_WIDTH());
                }
            });
            put(ImageType.skellyFront1, new AssetImage() {
                {
                    setPath("skelly/skelly_front_1.png");
                    setType(ImageType.skellyFront1);
                    setHeight(GameEngine.RESIZATOR.getRATIO_HEIGHT());
                    setWidth(GameEngine.RESIZATOR.getRATIO_WIDTH());
                }
            });
            put(ImageType.skellyFront2, new AssetImage() {
                {
                    setPath("skelly/skelly_front_2.png");
                    setType(ImageType.skellyFront2);
                    setHeight(GameEngine.RESIZATOR.getRATIO_HEIGHT());
                    setWidth(GameEngine.RESIZATOR.getRATIO_WIDTH());
                }
            });
            put(ImageType.skellyBack, new AssetImage() {
                {
                    setPath("skelly/skelly_back.png");
                    setType(ImageType.skellyBack);
                    setHeight(GameEngine.RESIZATOR.getRATIO_HEIGHT());
                    setWidth(GameEngine.RESIZATOR.getRATIO_WIDTH());
                }
            });
            put(ImageType.skellyBack1, new AssetImage() {
                {
                    setPath("skelly/skelly_back_1.png");
                    setType(ImageType.skellyBack1);
                    setHeight(GameEngine.RESIZATOR.getRATIO_HEIGHT());
                    setWidth(GameEngine.RESIZATOR.getRATIO_WIDTH());
                }
            });
            put(ImageType.skellyBack2, new AssetImage() {
                {
                    setPath("skelly/skelly_back_2.png");
                    setType(ImageType.skellyBack2);
                    setHeight(GameEngine.RESIZATOR.getRATIO_HEIGHT());
                    setWidth(GameEngine.RESIZATOR.getRATIO_WIDTH());
                }
            });

            put(ImageType.skellyLeft, new AssetImage() {
                {
                    setPath("skelly/skelly_left.png");
                    setType(ImageType.skellyLeft);
                    setHeight(GameEngine.RESIZATOR.getRATIO_HEIGHT());
                    setWidth(GameEngine.RESIZATOR.getRATIO_WIDTH());
                }
            });
            put(ImageType.skellyLeft1, new AssetImage() {
                {
                    setPath("skelly/skelly_left_1.png");
                    setType(ImageType.skellyLeft1);
                    setHeight(GameEngine.RESIZATOR.getRATIO_HEIGHT());
                    setWidth(GameEngine.RESIZATOR.getRATIO_WIDTH());
                }
            });
            put(ImageType.skellyLeft2, new AssetImage() {
                {
                    setPath("skelly/skelly_left_2.png");
                    setType(ImageType.skellyLeft2);
                    setHeight(GameEngine.RESIZATOR.getRATIO_HEIGHT());
                    setWidth(GameEngine.RESIZATOR.getRATIO_WIDTH());
                }
            });
            put(ImageType.skellyRight, new AssetImage() {
                {
                    setPath("skelly/skelly_right.png");
                    setType(ImageType.skellyRight);
                    setHeight(GameEngine.RESIZATOR.getRATIO_HEIGHT());
                    setWidth(GameEngine.RESIZATOR.getRATIO_WIDTH());
                }
            });
            put(ImageType.skellyRight1, new AssetImage() {
                {
                    setPath("skelly/skelly_right_1.png");
                    setType(ImageType.skellyRight1);
                    setHeight(GameEngine.RESIZATOR.getRATIO_HEIGHT());
                    setWidth(GameEngine.RESIZATOR.getRATIO_WIDTH());
                }
            });
            put(ImageType.skellyRight2, new AssetImage() {
                {
                    setPath("skelly/skelly_right_2.png");
                    setType(ImageType.skellyRight2);
                    setHeight(GameEngine.RESIZATOR.getRATIO_HEIGHT());
                    setWidth(GameEngine.RESIZATOR.getRATIO_WIDTH());
                }
            });
            put(ImageType.knightFront, new AssetImage() {
                {
                    setPath("knight/knight_front.png");
                    setType(ImageType.knightFront);
                    setHeight(GameEngine.RESIZATOR.getRATIO_HEIGHT());
                    setWidth(GameEngine.RESIZATOR.getRATIO_WIDTH());
                }
            });
            put(ImageType.knightFront1, new AssetImage() {
                {
                    setPath("knight/knight_front_1.png");
                    setType(ImageType.knightFront1);
                    setHeight(GameEngine.RESIZATOR.getRATIO_HEIGHT());
                    setWidth(GameEngine.RESIZATOR.getRATIO_WIDTH());
                }
            });
            put(ImageType.knightFront2, new AssetImage() {
                {
                    setPath("knight/knight_front_2.png");
                    setType(ImageType.knightFront2);
                    setHeight(GameEngine.RESIZATOR.getRATIO_HEIGHT());
                    setWidth(GameEngine.RESIZATOR.getRATIO_WIDTH());
                }
            });
            put(ImageType.knightBack, new AssetImage() {
                {
                    setPath("knight/knight_back.png");
                    setType(ImageType.knightBack);
                    setHeight(GameEngine.RESIZATOR.getRATIO_HEIGHT());
                    setWidth(GameEngine.RESIZATOR.getRATIO_WIDTH());
                }
            });
            put(ImageType.knightBack1, new AssetImage() {
                {
                    setPath("knight/knight_back_1.png");
                    setType(ImageType.knightBack1);
                    setHeight(GameEngine.RESIZATOR.getRATIO_HEIGHT());
                    setWidth(GameEngine.RESIZATOR.getRATIO_WIDTH());
                }
            });
            put(ImageType.knightBack2, new AssetImage() {
                {
                    setPath("knight/knight_back_2.png");
                    setType(ImageType.knightBack2);
                    setHeight(GameEngine.RESIZATOR.getRATIO_HEIGHT());
                    setWidth(GameEngine.RESIZATOR.getRATIO_WIDTH());
                }
            });

            put(ImageType.knightLeft, new AssetImage() {
                {
                    setPath("knight/knight_left.png");
                    setType(ImageType.knightLeft);
                    setHeight(GameEngine.RESIZATOR.getRATIO_HEIGHT());
                    setWidth(GameEngine.RESIZATOR.getRATIO_WIDTH());
                }
            });
            put(ImageType.knightLeft1, new AssetImage() {
                {
                    setPath("knight/knight_left_1.png");
                    setType(ImageType.knightLeft1);
                    setHeight(GameEngine.RESIZATOR.getRATIO_HEIGHT());
                    setWidth(GameEngine.RESIZATOR.getRATIO_WIDTH());
                }
            });
            put(ImageType.knightLeft2, new AssetImage() {
                {
                    setPath("knight/knight_left_2.png");
                    setType(ImageType.knightLeft2);
                    setHeight(GameEngine.RESIZATOR.getRATIO_HEIGHT());
                    setWidth(GameEngine.RESIZATOR.getRATIO_WIDTH());
                }
            });
            put(ImageType.knightRight, new AssetImage() {
                {
                    setPath("knight/knight_right.png");
                    setType(ImageType.knightRight);
                    setHeight(GameEngine.RESIZATOR.getRATIO_HEIGHT());
                    setWidth(GameEngine.RESIZATOR.getRATIO_WIDTH());
                }
            });
            put(ImageType.knightRight1, new AssetImage() {
                {
                    setPath("knight/knight_right_1.png");
                    setType(ImageType.knightRight1);
                    setHeight(GameEngine.RESIZATOR.getRATIO_HEIGHT());
                    setWidth(GameEngine.RESIZATOR.getRATIO_WIDTH());
                }
            });
            put(ImageType.knightRight2, new AssetImage() {
                {
                    setPath("knight/knight_right_2.png");
                    setType(ImageType.knightRight2);
                    setHeight(GameEngine.RESIZATOR.getRATIO_HEIGHT());
                    setWidth(GameEngine.RESIZATOR.getRATIO_WIDTH());
                }
            });
            put(ImageType.wizardFront, new AssetImage() {
                {
                    setPath("wizard/wizard_front.png");
                    setType(ImageType.wizardFront);
                    setHeight(GameEngine.RESIZATOR.getRATIO_HEIGHT());
                    setWidth(GameEngine.RESIZATOR.getRATIO_WIDTH());
                }
            });
            put(ImageType.wizardFront1, new AssetImage() {
                {
                    setPath("wizard/wizard_front_1.png");
                    setType(ImageType.wizardFront1);
                    setHeight(GameEngine.RESIZATOR.getRATIO_HEIGHT());
                    setWidth(GameEngine.RESIZATOR.getRATIO_WIDTH());
                }
            });
            put(ImageType.wizardFront2, new AssetImage() {
                {
                    setPath("wizard/wizard_front_2.png");
                    setType(ImageType.wizardFront2);
                    setHeight(GameEngine.RESIZATOR.getRATIO_HEIGHT());
                    setWidth(GameEngine.RESIZATOR.getRATIO_WIDTH());
                }
            });
            put(ImageType.wizardBack, new AssetImage() {
                {
                    setPath("wizard/wizard_back.png");
                    setType(ImageType.wizardBack);
                    setHeight(GameEngine.RESIZATOR.getRATIO_HEIGHT());
                    setWidth(GameEngine.RESIZATOR.getRATIO_WIDTH());
                }
            });
            put(ImageType.wizardBack1, new AssetImage() {
                {
                    setPath("wizard/wizard_back_1.png");
                    setType(ImageType.wizardBack1);
                    setHeight(GameEngine.RESIZATOR.getRATIO_HEIGHT());
                    setWidth(GameEngine.RESIZATOR.getRATIO_WIDTH());
                }
            });
            put(ImageType.wizardBack2, new AssetImage() {
                {
                    setPath("wizard/wizard_back_2.png");
                    setType(ImageType.wizardBack2);
                    setHeight(GameEngine.RESIZATOR.getRATIO_HEIGHT());
                    setWidth(GameEngine.RESIZATOR.getRATIO_WIDTH());
                }
            });

            put(ImageType.wizardLeft, new AssetImage() {
                {
                    setPath("wizard/wizard_left.png");
                    setType(ImageType.wizardLeft);
                    setHeight(GameEngine.RESIZATOR.getRATIO_HEIGHT());
                    setWidth(GameEngine.RESIZATOR.getRATIO_WIDTH());
                }
            });
            put(ImageType.wizardLeft1, new AssetImage() {
                {
                    setPath("wizard/wizard_left_1.png");
                    setType(ImageType.wizardLeft1);
                    setHeight(GameEngine.RESIZATOR.getRATIO_HEIGHT());
                    setWidth(GameEngine.RESIZATOR.getRATIO_WIDTH());
                }
            });
            put(ImageType.wizardLeft2, new AssetImage() {
                {
                    setPath("wizard/wizard_left_2.png");
                    setType(ImageType.wizardLeft2);
                    setHeight(GameEngine.RESIZATOR.getRATIO_HEIGHT());
                    setWidth(GameEngine.RESIZATOR.getRATIO_WIDTH());
                }
            });
            put(ImageType.wizardRight, new AssetImage() {
                {
                    setPath("wizard/wizard_right.png");
                    setType(ImageType.wizardRight);
                    setHeight(GameEngine.RESIZATOR.getRATIO_HEIGHT());
                    setWidth(GameEngine.RESIZATOR.getRATIO_WIDTH());
                }
            });
            put(ImageType.wizardRight1, new AssetImage() {
                {
                    setPath("wizard/wizard_right_1.png");
                    setType(ImageType.wizardRight1);
                    setHeight(GameEngine.RESIZATOR.getRATIO_HEIGHT());
                    setWidth(GameEngine.RESIZATOR.getRATIO_WIDTH());
                }
            });
            put(ImageType.wizardRight2, new AssetImage() {
                {
                    setPath("wizard/wizard_right_2.png");
                    setType(ImageType.wizardRight2);
                    setHeight(GameEngine.RESIZATOR.getRATIO_HEIGHT());
                    setWidth(GameEngine.RESIZATOR.getRATIO_WIDTH());
                }
            });
            put(ImageType.arrow, new AssetImage() {
                {
                    setPath("utility/arrow.png");
                    setType(ImageType.arrow);
                    setHeight(GameEngine.RESIZATOR.getRATIO_HEIGHT());
                    setWidth(GameEngine.RESIZATOR.getRATIO_WIDTH());
                }
            });
            put(ImageType.bow, new AssetImage() {
                {
                    setPath("utility/bow.png");
                    setType(ImageType.bow);
                    setHeight(GameEngine.RESIZATOR.getRATIO_HEIGHT());
                    setWidth(GameEngine.RESIZATOR.getRATIO_WIDTH());
                }
            });
            put(ImageType.brassKnucles, new AssetImage() {
                {
                    setPath("utility/brass_knucles.png");
                    setType(ImageType.brassKnucles);
                    setHeight(GameEngine.RESIZATOR.getRATIO_HEIGHT());
                    setWidth(GameEngine.RESIZATOR.getRATIO_WIDTH());
                }
            });
            put(ImageType.hammer, new AssetImage() {
                {
                    setPath("utility/hammer.png");
                    setType(ImageType.hammer);
                    setHeight(GameEngine.RESIZATOR.getRATIO_HEIGHT());
                    setWidth(GameEngine.RESIZATOR.getRATIO_WIDTH());
                }
            });
            put(ImageType.noticeBoard, new AssetImage() {
                {
                    setPath("utility/notice_board.png");
                    setType(ImageType.noticeBoard);
                    setHeight(GameEngine.RESIZATOR.getWINDOW_HEIGHT());
                    setWidth(GameEngine.RESIZATOR.getWINDOW_WIDTH());
                }
            });
            put(ImageType.paper, new AssetImage() {
                {
                    setPath("utility/paper.png");
                    setType(ImageType.paper);
                    setHeight(GameEngine.RESIZATOR.getRATIO_HEIGHT());
                    setWidth(GameEngine.RESIZATOR.getRATIO_WIDTH());
                }
            });
            put(ImageType.sword, new AssetImage() {
                {
                    setPath("utility/sword.png");
                    setType(ImageType.sword);
                    setHeight(GameEngine.RESIZATOR.getRATIO_HEIGHT());
                    setWidth(GameEngine.RESIZATOR.getRATIO_WIDTH());
                }
            });
            put(ImageType.teleporter, new AssetImage() {
                {
                    setPath("utility/teleporter.png");
                    setType(ImageType.teleporter);
                    setHeight(GameEngine.RESIZATOR.getRATIO_HEIGHT());
                    setWidth(GameEngine.RESIZATOR.getRATIO_WIDTH());
                }
            });
            put(ImageType.blacksmith,new AssetImage(){
                {
                    setPath("utility/blacksmith.png");
                    setType(ImageType.blacksmith);
                    setHeight(GameEngine.RESIZATOR.getWINDOW_HEIGHT());
                    setWidth(GameEngine.RESIZATOR.getWINDOW_WIDTH());
                }
            });
        }
    };

    public static void resizeAssets() {
        imagePaths.forEach((k, v) -> {
            if (v.getType() == ImageType.MAPBG ||
                    v.getType() == ImageType.noticeBoard ||
                    v.getType() == ImageType.blacksmith) {
                v.setHeight(GameEngine.RESIZATOR.getWINDOW_HEIGHT());
                v.setWidth(GameEngine.RESIZATOR.getWINDOW_WIDTH());
            } else {
                v.setHeight(GameEngine.RESIZATOR.getRATIO_HEIGHT());
                v.setWidth(GameEngine.RESIZATOR.getRATIO_WIDTH());
            }
        });
    }
}
