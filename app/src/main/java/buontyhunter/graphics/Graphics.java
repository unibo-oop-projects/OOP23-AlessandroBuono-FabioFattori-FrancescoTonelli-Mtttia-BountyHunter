package buontyhunter.graphics;

import buontyhunter.model.*;
import buontyhunter.weaponClasses.RangedWeapon;
import buontyhunter.weaponClasses.Weapon;

public interface Graphics {
	/**
	 * this method is used to draw the player on the screen
	 * @param obj the object to draw (player)
	 * @param w the world
	 */
	void drawPlayer(GameObject obj, World w);

	/**
	 * this method is used to draw the map on the screen
	 * @param tileManager the tile manager
	 * @param w the world
	 */
	void drawMap(TileManager tileManager, World w);

	/**
	 * this method is used to draw the mini map on the screen
	 * @param tileManager the tile manager
	 * @param w the world
	 */
	void drawMiniMap(HidableObject tileManager, World w);

	/**
	 * this method is used to draw the navigator line on the screen
	 * @param navigatorLine the navigator line
	 * @param w the world
	 */
	void drawNavigatorLine(NavigatorLine navigatorLine, World w);

	/**
	 * this method is used to draw the health bar on the screen
	 * @param healthBar the health bar
	 * @param w the world
	 */
	void drawHealthBar(HealthBar healthBar, World w);

	/**
	 * this method is used to draw the teleporter on the screen
	 * @param healthBar the health bar
	 * @param w the world
	 */
	void drawTeleporter(Teleporter tp, World w);

	/**
	 * this method is used to draw the quest pannel on the screen
	 * @param questPannel the quest pannel
	 * @param w the world
	 */
	void drawQuestPannel(QuestPannel questPannel, World w);

	/**
	 * this method is used to draw the string under the player on the screen
	 * @param s the string to draw
	 */
	void drawStringUnderPlayer(String s);

	/**
	 * this method is used to draw the quest journal on the screen
	 * @param w the world
	 */
	void drawQuestJournal(World w);

	/**
	 * this method is used to draw the weapon on the screen
	 * @param fe the fighter entity
	 */
	void drawWeapon(FighterEntity fe);

	/**
	 * this method is used to draw the enemy on the screen
	 * @param obj the object to draw
	 * @param w the world
	 */
	void drawEnemy(GameObject obj, World w);

	/**
	 * this method is used to draw progress bar on the screen
	 * @param w the ranged weapon
	 */
	void drawProgressBar(LoadingBar loadingBar, World w);

	/**
	 * this method is used to draw the bullet shoot from the Ranged Weapon on the screen
	 * @param w the ranged weapon
	 */
	void drawBullet(RangedWeapon w);

	/**
	 * this method is used to draw the blacksmith panel on the screen
	 * @param blacksmithPanel the blacksmith panel
	 * @param w the world
	 */
	void drawBlacksmithPanel(BlacksmithPanel blacksmithPanel, World w);

	/**
	 * this method is used to draw Wizard boss on the screen
	 * @param blacksmithPanel the blacksmith panel
	 * @param w the world
	 */
	void drawWizardBoss(WizardBossEntity boss, World w);

	/**
	 * this method is used to draw the inventory on the screen
	 * @param inventory the inventory
	 * @param w the world
	 */
	void drawInventory(InventoryObject inventory, World w);
	
	/**
	 * this method is used to draw the weapon icon on the screen
	 * @param weapon the weapon
	 * @param x the x coordinate
	 * @param y the y coordinate
	 * @param dimension the dimension
	 */
	void drawWeaponIcon(Weapon weapon, int x, int y, int dimension);

	/**
	 * this method is used to draw the durability bar on the screen
	 * @param weapon the weapon
	 * @param x the x coordinate
	 * @param y the y coordinate
	 */
	void drawDurabilityBar(Weapon weapon, int x, int y);
}
