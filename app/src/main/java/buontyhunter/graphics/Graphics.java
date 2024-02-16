package buontyhunter.graphics;

import buontyhunter.model.*;
import buontyhunter.weaponClasses.RangedWeapon;

public interface Graphics {

	void drawPlayer(GameObject obj, World w);

	void drawMap(TileManager tileManager, World w);

	void drawMiniMap(HidableObject tileManager, World w);

	void drawNavigatorLine(NavigatorLine navigatorLine, World w);

	void drawHealthBar(HealthBar healthBar, World w);

	void drawTeleporter(Teleporter tp, World w);

	void drawQuestPannel(QuestPannel questPannel, World w);

	void drawStringUnderPlayer(String s);

	void drawQuestJournal(World w);
	
	void drawWeapon(FighterEntity fe);

	void drawEnemy(GameObject obj, World w);

	void drawProgressBar(LoadingBar loadingBar, World w);

	void drawBullet(RangedWeapon w);

	void drawBlacksmithPanel(BlacksmithPanel blacksmithPanel, World w);
}
