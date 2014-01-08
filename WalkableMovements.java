package scripts;

import org.tribot.api.input.Mouse;
import org.tribot.api.rs3.*;
import org.tribot.api.rs3.types.*;
import org.tribot.api.rs3.util.ThreadSettings;
import org.tribot.api.rs3.util.ThreadSettings.MODEL_CLICKING_METHOD;
import org.tribot.api.General;

public class WalkableMovements{

	public static void walkToCave()  {
	EGWPosition PlayerPOS = EGW.getPosition();

		if(PlayerPOS.distance(RS3CockRoachSoldiers.Cave_Pos) > 3){
			WebWalking.walkTo(RS3CockRoachSoldiers.Cave_Pos);
             while (Player.isMoving())
                 General.sleep(800, 1000);
		}
	}
	
	public static void walkToRoaches()  {
	EGWPosition PlayerPOS = EGW.getPosition();

		if(PlayerPOS.distance(RS3CockRoachSoldiers.CockRoach_Pos) > 3){
			WebWalking.walkTo(RS3CockRoachSoldiers.CockRoach_Pos);
             while (Player.isMoving())
                 General.sleep(800, 1000);
		}
	}
	
	public static void walkToRope()  {
		EGWPosition PlayerPOS = EGW.getPosition();

		if(EGW.getFloor() > 1){
			EGW.walkTo(RS3CockRoachSoldiers.Dung_Rope_Pos);
             while (Player.isMoving())
                 General.sleep(800, 1000);
		}
	}
	
	public static void walkToBank()  {
		EGWPosition PlayerPOS = EGW.getPosition();
	
		if(PlayerPOS.distance(RS3CockRoachSoldiers.Bank_Pos) > 4){
		  WebWalking.walkTo(RS3CockRoachSoldiers.Bank_Pos);
             while (Player.isMoving())
                 General.sleep(800, 1000);
		}
	}
}
