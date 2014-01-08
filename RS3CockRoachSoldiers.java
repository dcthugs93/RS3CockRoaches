package scripts;

import java.awt.Color;
import java.awt.Point;

import org.tribot.api.General;
import org.tribot.api.Screen;
import org.tribot.api.rs3.*;
import org.tribot.api.rs3.types.*;
import org.tribot.api.input.*;
import org.tribot.api.rs3.util.ThreadSettings;
import org.tribot.api.rs3.util.ThreadSettings.MODEL_CLICKING_METHOD;
import org.tribot.script.EnumScript;
import org.tribot.script.ScriptManifest;
import org.tribot.script.interfaces.Painting;


@ScriptManifest(authors = { "dcthugs93" }, category = "Combat", name = "RS3 CockRoach Soldiers")
public class RS3CockRoachSoldiers extends EnumScript<RS3CockRoachSoldiers.STATE>
{


	final boolean debug = false;

	public static final EGWPosition Bank_Pos = new EGWPosition (3093, 3493, 0);
	public static final EGWPosition Cave_Pos = new EGWPosition (3074, 3464, 0);
	public static final EGWPosition CockRoach_Pos = new EGWPosition (3151, 4279);
	public static final EGWPosition Dung_Rope_Pos = new EGWPosition (3157, 4280);
	public static final int Banker = 574795741;
	public static final long CockRoach2 = 3663530087L; 
	public static final long CockRoach1 = 3168581986L;
	public static final int monkFish = 1137865;
	public static final long cave = 2445306396L;
	public static final int rope = 145299039;
	public static final int runeSQ = 1905315383;
	public static final long runeSC = 3210455169L;
	public static final long lawRune = 3754948404L;
	public static final int mithrilOre = 1485068412;
	public static final int adamantiteOre = 1485068412;
	public static int mouseSpeed = General.random(65, 155);

	
	enum STATE
	{
		CHECK, BANK, CHECK_FOR_FOOD, WALK_TO_CAVE, CLIMB_IN_CAVE, COMBAT, CLIMB_ROPE, WALK_TO_BANK, EAT, WALK_TO_ROPE, WALK_TO_ROACHES, LOOT
	}
	
		@Override
	public STATE getInitialState()
	{
		// set model clicking method
		ThreadSettings.get().setScreenModelClickingMethod(MODEL_CLICKING_METHOD.CENTRE);

		Mouse.setSpeed(General.random(165, 175));// Set mouse to a random speed.

		//if (debug) println("dcthugs93 testing start");// shameless intro message

		return STATE.CHECK;
	}

	@Override
	public STATE handleState(STATE t)
	{
		switch (t)
		{
			case CHECK:
			EGWPosition PlayerPOS = EGW.getPosition();

				if(PlayerPOS.distance(Bank_Pos) < 6 && Backpack.find(monkFish).length < 1 || Backpack.isFull()){
				return STATE.BANK;
				}else
				if(Backpack.find(monkFish).length > 1 && PlayerPOS.distance(Cave_Pos) > 5 && EGW.getFloor() < 2){
				return STATE.WALK_TO_CAVE;
				}else
				if(PlayerPOS.distance(Cave_Pos) < 3 && Backpack.find(monkFish).length > 1 && !Backpack.isFull()) {
				return STATE.CLIMB_IN_CAVE;
				}else
				if(PlayerPOS.distance(CockRoach_Pos) < 20 && Backpack.find(monkFish).length >= 1 && !Backpack.isFull() && !Looting.lootOnScreen()) {
				return STATE.COMBAT;
				}else
				if(Game.getHitpoints() <= 1500 && Backpack.find(monkFish).length >= 1){
				return STATE.EAT;
				}else
				if(EGW.getFloor() > 2 && Backpack.find(monkFish).length < 1 || Backpack.isFull()){
				while(PlayerPOS.distance(Dung_Rope_Pos) > 2){
					return STATE.WALK_TO_ROPE;
					}
				}else
				if(PlayerPOS.distance(Dung_Rope_Pos) <= 3 && Backpack.find(monkFish).length < 1 || Backpack.isFull()){
					while(EGW.getFloor() > 2){
						return STATE.CLIMB_ROPE;
					}
				}else
				if(PlayerPOS.distance(CockRoach_Pos) > 5 && Backpack.find(monkFish).length > 1 && !Backpack.isFull() && EGW.getFloor() > 2){
				return STATE.WALK_TO_ROACHES;
				}else
				if(Looting.lootOnScreen()){
				return STATE.LOOT;
				}

			
			case BANK:
			if(EGW.getFloor() < 2){
				if(Backpack.find(monkFish).length < 1 || Backpack.isFull()){
					ClickableMovements.bank();
				}
			}

			return STATE.CHECK;
			
			
			case WALK_TO_CAVE:

			WalkableMovements.walkToCave();
			General.sleep(1000, 1500);
			return STATE.CLIMB_IN_CAVE;
			
			case CLIMB_IN_CAVE:
			while(EGW.getFloor() < 2){
			ClickableMovements.clickOnCave();
			}
			return STATE.CHECK;
			
			case COMBAT:
			while(!Looting.lootOnScreen() && Backpack.find(monkFish).length > 0 || Game.getHitpoints() > 1500){
			KillRoaches.fightRoaches();
			return STATE.COMBAT;
			}
			return STATE.CHECK;
									
			case WALK_TO_BANK:
			WalkableMovements.walkToBank();
			return STATE.CHECK;
			
			case WALK_TO_ROPE:
			WalkableMovements.walkToRope();
			return STATE.CLIMB_ROPE;
			
			case WALK_TO_ROACHES:
			WalkableMovements.walkToRoaches();
			return STATE.CHECK;
			
			case CLIMB_ROPE:
			while(Backpack.find(monkFish).length < 1 && EGW.getFloor() > 2){
			ClickableMovements.climbRope();
			}
			return STATE.CHECK;
	
			case LOOT:
			while(Looting.lootOnScreen()){
			Looting.lootGoods();
			}
			return STATE.CHECK;
			
			case EAT:
			while(Game.getHitpoints() <= 1500){
			ClickableMovements.eatFood();
			}
			break;
			

		}
		return STATE.CHECK;
	}		
	
}
		
	
